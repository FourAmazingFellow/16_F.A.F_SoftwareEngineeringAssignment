package businesslogic.roombl.updateCheckIn;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.roombl.RoomInfoService;
import businesslogic.roombl.RoomInfoServiceImpl;
import businesslogic.strategybl.StrategyInfoService;
import businesslogic.strategybl.StrategyInfoServiceImpl;
import businesslogic.strategybl.exception.WrongInputException;
import dataservice.roomDAO.RoomDAO;
import po.CheckInPO;
import po.RoomPO;
import po.RoomType;
import rmi.RemoteHelper;
import vo.CheckInVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version
 * @see
 */
public class CheckInItem {

    private Enum<RoomType> roomType;
    private int roomNum;
    private String address;
    private Date checkInTime;
    private Date expDepartTime;

    private RoomDAO checkInDAO;
    private RoomInfoService roomInfoService;
    private StrategyInfoService strategyInfoService;

    public CheckInItem() {
         checkInDAO = RemoteHelper.getInstance().getRoomDAO();
//        checkInTime=new Date();
//        Calendar calendar=Calendar.getInstance();
//        calendar.setTime(checkInTime);
//        calendar.add(Calendar.DATE, 1);
//        expDepartTime=calendar.getTime();
//        
//        checkInDAO = new RoomDAOImpl_Stub(RoomType.SINGLE_ROOM, 0000000000000003, 400, "江苏省南京市栖霞区仙林大道163号",
//                checkInTime, expDepartTime, null);
        
        roomInfoService = new RoomInfoServiceImpl();
        strategyInfoService = new StrategyInfoServiceImpl();
    }

    /**
     * 
     * @param roomPO
     *            RoomPO型，入住信息
     */
    public CheckInItem(RoomPO roomPO) {
        this();
        CheckInPO checkInPO = (CheckInPO) roomPO;
        this.roomType = checkInPO.getRoomType();
        this.roomNum = checkInPO.getRoomNum();
        this.address = checkInPO.getAddress();
        this.checkInTime = checkInPO.getCheckInTime();
        this.expDepartTime = checkInPO.getExpDepartTime();
    }

    /**
     * 
     * @param roomVO
     *            RoomVO型，入住信息
     */
    public CheckInItem(RoomVO roomVO) {
        this();
        CheckInVO checkInVO = (CheckInVO) roomVO;
        this.roomType = checkInVO.roomType;
        this.roomNum = checkInVO.roomNum;
        this.address = checkInVO.address;
        this.checkInTime = checkInVO.checkInTime;
        this.expDepartTime = checkInVO.expDepartTime;
    }

    /**
     * 增加入住信息
     * 
     * @param address
     *            string型，酒店地址
     * @return
     * @throws RemoteException
     * @see
     */
    public boolean addCheckIn(String address, boolean updateSpareRoom) throws RemoteException {
        CheckInPO checkInPO = new CheckInPO(roomType, roomNum, address, checkInTime, expDepartTime);
        try {
            checkInDAO.insertCheckIn(checkInPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        // 根据布尔值决定是否更新空房
        if (updateSpareRoom) {
            Date today = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
            try {
                today = sdf.parse(sdf.format(today));
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            roomInfoService.reduceRoom(address, roomNum, roomType, today);
        }
        return true;
    }

    /**
     * 判断该入住信息是否有效
     * 
     * @return 返回是否入住信息有效
     * @throws WrongInputException
     * @throws RemoteException
     * @see
     */
    public boolean validCheckIn() throws WrongInputException, RemoteException {
        // 格式验证

        // 验证地址
        if (address.length() > 50 || address.length() < 1) {
            throw new WrongInputException("the address can't be longer than 50 characters");
        }
        
        // 调用strategyItem的isRightName方法验证地址名称是否正确
        if (!strategyInfoService.isRightName(address)) {
            throw new WrongInputException("the address only includes number,letter, Chinese characters and underline");
        }

        // 验证房间数为正整数
        if (roomNum <= 0) {
            throw new WrongInputException("the number of room should large than 0");
        }

        // 验证时间是否合法，如果入住时间必须在当天内，预计离开时间大于入住时间，则错误
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (!sdf.format(checkInTime).equals( sdf.format(new Date()))) {
            throw new WrongInputException("check-in time must be today");
        }
        if (expDepartTime.compareTo(checkInTime) <= 0) {
            throw new WrongInputException("expected depart time should be earlier than the Check-in time");
        }

        // 非格式验证

        // 判断空房是否有该房型
        ArrayList<RoomVO> spareRoomList = roomInfoService.getSpareRoomList(address);
        boolean roomTypeExist = false;
        for (RoomVO spareRoomVO : spareRoomList) {
            if (spareRoomVO.roomType == roomType) {
                roomTypeExist = true;
                break;
            }
        }
        if (!roomTypeExist)
            throw new WrongInputException("spare room of this roomType doesn't exist");

        // roomNum小于空房数量
        Date today = new Date();
        try {
            today = sdf.parse(sdf.format(today));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        int spareRoomNum = roomInfoService.getAvailableRoomNum(address, roomType, today);
        if (roomNum > spareRoomNum) {
            throw new WrongInputException("the room number of check-in is larger than the spare Room number");
        }
        return true;
    }

    /**
     * 转成CheckInOutVO型
     * 
     * @return RoomVO型，包含入住信息
     * @see
     */
    public RoomVO toVO() {
        return new CheckInVO(roomType, roomNum, address, checkInTime, expDepartTime);
    }
}
