package businesslogic.roombl.updateCheckOut;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import businesslogic.hotelbl.HotelInfoService;
import businesslogic.hotelbl.HotelInfoServiceImpl;
import businesslogic.roombl.RoomInfoService;
import businesslogic.roombl.RoomInfoServiceImpl;
import businesslogic.strategybl.StrategyInfoService;
import businesslogic.strategybl.StrategyInfoServiceImpl;
import businesslogic.strategybl.exception.WrongInputException;
import dataservice.roomDAO.RoomDAO;
import po.CheckOutPO;
import po.RoomPO;
import po.RoomType;
import rmi.RemoteHelper;
import vo.CheckOutVO;
import vo.HotelVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version
 * @see
 */
public class CheckOutItem {

    private Enum<RoomType> roomType;
    private int roomNum;
    private String address;
    private Date actDepartTime;

    private RoomDAO checkOutDAO;
    private RoomInfoService roomInfoService;
    private StrategyInfoService strategyInfoService;
    private HotelInfoService hotelInfoService;

    public CheckOutItem() {
        checkOutDAO=RemoteHelper.getInstance().getRoomDAO();
        strategyInfoService = new StrategyInfoServiceImpl();
        roomInfoService = new RoomInfoServiceImpl();
        hotelInfoService = new HotelInfoServiceImpl();
    }

    /**
     * 
     * @param roomPO
     *            RoomPO型，退房信息
     */
    public CheckOutItem(RoomPO roomPO) {
        this();
        CheckOutPO CheckOutPO = (CheckOutPO) roomPO;
        this.roomType = CheckOutPO.getRoomType();
        this.roomNum = CheckOutPO.getRoomNum();
        this.address = CheckOutPO.getAddress();
        this.actDepartTime = CheckOutPO.getActDepartTime();
    }

    /**
     * 
     * @param roomVO
     *            RoomVO型，退房信息
     */
    public CheckOutItem(RoomVO roomVO) {
        this();
        CheckOutVO CheckOutVO = (CheckOutVO) roomVO;
        this.roomType = CheckOutVO.roomType;
        this.roomNum = CheckOutVO.roomNum;
        this.address = CheckOutVO.address;
        this.actDepartTime = CheckOutVO.actDepartTime;
    }

    /**
     * 增加退房信息
     * 
     * @param address
     *            string型，酒店地址
     * @return
     * @throws RemoteException
     * @see
     */
    public boolean addCheckOut(String address) throws RemoteException {
        CheckOutPO checkOutPO = new CheckOutPO(roomType, roomNum, address, actDepartTime);
        try {
            checkOutDAO.insertCheckOut(checkOutPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        // 更新空房信息
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            today = sdf.parse(sdf.format(today));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        roomInfoService.addRoom(address, roomNum, roomType, today);

        return true;
    }

    /**
     * 判断该退房信息是否有效
     * 
     * @return 返回是否退房信息有效
     * @throws WrongInputException
     * @throws RemoteException
     * @see
     */
    public boolean validCheckOut() throws WrongInputException, RemoteException {
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

        // 实际离开时间必须在当天内
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (!sdf.format(actDepartTime).equals(sdf.format(new Date()))) {
            throw new WrongInputException("check-out time must be today");
        }

        // 非格式验证
        int spareRoomNum = 0;
        // 判断空房是否有该房型
        ArrayList<RoomVO> spareRoomList = roomInfoService.getSpareRoomList(address);
        boolean roomTypeExist = false;
        for (RoomVO spareRoomVO : spareRoomList) {
            if (spareRoomVO.roomType == roomType) {
                roomTypeExist = true;
                spareRoomNum = spareRoomVO.roomNum;
                break;
            }
        }
        if (!roomTypeExist)
            throw new WrongInputException("spare room of this roomType doesn't exist");

        // 如果roomNum是否大于可用客房数-空房数，则错误
        int availbleRoomNum = 0;
        HotelVO hotelVO = hotelInfoService.getHotelDetails(address);
        HashMap<RoomType, Integer> roomTypeAndNums = hotelVO.roomTypeAndNums;
        for (RoomType roomType : RoomType.class.getEnumConstants()) {
            if (roomType == this.roomType) {
                availbleRoomNum = roomTypeAndNums.get(roomType);
                break;
            }
        }
        if (availbleRoomNum - spareRoomNum < roomNum) {
            throw new WrongInputException("the roomNum is too large to check-Out");
        }
        return true;
    }

    /**
     * 转成checkInOutVO类型
     * 
     * @return RoomVO型，包含了退房信息
     * @see
     */
    public RoomVO toVO() {
        return new CheckOutVO(roomType, roomNum, address, actDepartTime);
    }
}
