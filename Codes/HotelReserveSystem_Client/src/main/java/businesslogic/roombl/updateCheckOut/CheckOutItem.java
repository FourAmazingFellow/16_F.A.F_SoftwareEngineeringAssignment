package businesslogic.roombl.updateCheckOut;

import java.rmi.RemoteException;
import java.util.Date;

import dataservice.roomDAO.RoomDAO;
import po.CheckInOutPO;
import po.RoomPO;
import po.RoomType;
import vo.CheckInOutVO;
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
    
    public CheckOutItem(){
        
    }
    
    /**
     * 
     * @param roomPO RoomPO型，退房信息
     */
    public CheckOutItem(RoomPO roomPO) {
        super();
        CheckInOutPO CheckOutPO=(CheckInOutPO)roomPO;
        this.roomType = CheckOutPO.getRoomType();
        this.roomNum = CheckOutPO.getRoomNum();
        this.address = CheckOutPO.getAddress();
        this.actDepartTime = CheckOutPO.getActDepartTime();
    }
    
    /**
     * 
     * @param roomVO RoomVO型，退房信息
     */
    public CheckOutItem(RoomVO roomVO){
        super();
        CheckInOutVO CheckOutVO=(CheckInOutVO)roomVO;
        this.roomType = CheckOutVO.roomType;
        this.roomNum = CheckOutVO.roomNum;
        this.address = CheckOutVO.address;
        this.actDepartTime = CheckOutVO.actDepartTime;
    }
    
    /**
     * 增加退房信息
     * @param address string型，酒店地址
     * @return
     * @see
     */
    public boolean addCheckOut(String address){
        RoomPO checkOutPO=new CheckInOutPO(roomType, roomNum, address, actDepartTime);
        try {
            checkOutDAO.insert(checkOutPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * 修改 退房信息
     * @param address string型，酒店地址
     * @return 返回是否修改成功
     * @see
     */
    public boolean modifyCheckOut(String address){
        RoomPO checkOutPO=new CheckInOutPO(roomType, roomNum, address, actDepartTime);
        try {
            checkOutDAO.update(checkOutPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * 删除退房信息
     * @param address string型，酒店地址
     * @return 返回是否删除成功
     * @see
     */
    public boolean delCheckOut(String address){
        RoomPO checkOutPO=new CheckInOutPO(roomType, roomNum, address, actDepartTime);
        try {
            checkOutDAO.delete(checkOutPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * 判断该退房信息是否有效
     * @return 返回是否退房信息有效
     * @see
     */
    public boolean validCheckOut(){
        return false;
        
    }
    
    /**
     * 转成checkInOutVO类型
     * @return RoomVO型，包含了退房信息
     * @see
     */
    public RoomVO toVO(){
        return new CheckInOutVO(roomType, roomNum, address, actDepartTime);
    }
}

