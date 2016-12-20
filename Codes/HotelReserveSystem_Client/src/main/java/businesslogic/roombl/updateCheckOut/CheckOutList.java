package businesslogic.roombl.updateCheckOut;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.strategybl.exception.WrongInputException;
import dataservice.roomDAO.RoomDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.RoomPO;
import po.RoomType;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class CheckOutList {

    private RoomDAO roomDAO;
    
    private FactoryService factoryService;
    
    public CheckOutList(){
    	this.factoryService = new FactoryServiceImpl();
        roomDAO=factoryService.getRoomDAO();
    }
    
    /**
     * 得到退房信息列表
     * @param address String型，酒店地址
     * @return ArrayList<CheckOutItem>型，退房信息列表
     * @throws RemoteException 
     * @see
     */
    public ArrayList<CheckOutItem> getCheckOutList(String address) throws RemoteException{
        ArrayList<RoomPO> checkOutPOs;
        ArrayList<CheckOutItem> checkOutItems=new ArrayList<CheckOutItem>();
        checkOutPOs=roomDAO.getCheckOutInfoList(address);
        for(RoomPO checkOutPO:checkOutPOs){
            checkOutItems.add(new CheckOutItem(checkOutPO));
        }
        return checkOutItems;
    }
    
    /**
     * 根据退房时间搜索退房信息
     * @param address string型，酒店地址
     * @param time Date型，退房时间
     * @return ArrayList<CheckOutItem>型，返回符合条件的退房信息列表
     * @throws RemoteException 
     * @see
     */
    public ArrayList<CheckOutItem> searchCheckOutInfo(String address , Date startTime, Date endTime) throws RemoteException{
      //改变接口，只传一个Date,startTime ,endTime 自己计算出
        ArrayList<RoomPO> checkOutPOs;
        ArrayList<CheckOutItem> checkOutItems=new ArrayList<CheckOutItem>();
        checkOutPOs=roomDAO.getCheckOutInfo(address, startTime, endTime);
        
        for(RoomPO checkOutPO:checkOutPOs){
            checkOutItems.add(new CheckOutItem(checkOutPO));
        }
        return checkOutItems;
    }
    
    /**
     * 根据房间类型搜索退房信息
     * @param address string型，酒店地址
     * @param roomType 枚举类，房间类型
     * @return ArrayList<CheckOutItem>型，返回符合条件的退房信息列表
     * @throws RemoteException 
     * @see
     */
    public ArrayList<CheckOutItem> searchCheckOutInfo(String address ,Enum<RoomType> roomType) throws RemoteException{
        ArrayList<RoomPO> checkOutPOs;
        ArrayList<CheckOutItem> checkOutItems=new ArrayList<CheckOutItem>();
        checkOutPOs=roomDAO.getCheckOutInfo(address, roomType);
        
        for(RoomPO checkOutPO:checkOutPOs){
            checkOutItems.add(new CheckOutItem(checkOutPO));
        }
        return checkOutItems;
    }
    
    /**
     * 增加退房信息
     * @param address string型，酒店地址
     * @param CheckOut Room VO型，退房信息
     * @return 返回是否增加成功
     * @throws RemoteException 
     * @see
     */
    public boolean addCheckOut(String address, RoomVO checkOut) throws RemoteException{
        CheckOutItem checkOutItem=new CheckOutItem(checkOut);
        return checkOutItem.addCheckOut(address);
    }

    /**
     * 判断该退房信息是否有效
     * @param address string型，酒店地址
     * @param CheckOut Room VO型，退房信息
     * @return 返回是否退房信息有效
     * @throws WrongInputException 
     * @throws RemoteException 
     * @see
     */
    public boolean validCheckOut(String address, RoomVO checkOut) throws WrongInputException, RemoteException{
        CheckOutItem checkOutItem=new CheckOutItem(checkOut);
        return checkOutItem.validCheckOut();
    }
}

