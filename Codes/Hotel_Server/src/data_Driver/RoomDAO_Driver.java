package data_Driver;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.roomDAO.RoomDAO;
import po.CheckInOutPO;
import po.RoomPO;
import po.RoomType;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class RoomDAO_Driver {
    public void drive(RoomDAO roomDAO) throws RemoteException{
        ArrayList<RoomPO> spareRoomList=roomDAO.getSpareRoomInfoList("江苏省南京市栖霞区仙林大道163号");
        if(spareRoomList.isEmpty())
            System.out.println("No spareRoom!\n");
        else
            System.out.println("There are " + spareRoomList.size() + " kinds of spareRoom!\n");
        
        RoomPO roomPO=roomDAO.getSpareRoomInfo("江苏省南京市栖霞区仙林大道163号", RoomType.SINGLE_ROOM);
        System.out.println("There are "+roomPO.getRoomNum()+" "+roomPO.getRoomType()+" room!/n");
        
        ArrayList<RoomPO> checkInInfoList=roomDAO.getCheckInInfoList("江苏省南京市栖霞区仙林大道163号");
        if(checkInInfoList.isEmpty())
            System.out.println("This hotel doesn't have checkIn!\n");
        else
            System.out.println("There are " + checkInInfoList.size() + " checkIns in this hotel!\n");
        
        CheckInOutPO checkInPO1=(CheckInOutPO)roomDAO.getCheckInInfo("江苏省南京市栖霞区仙林大道163号", RoomType.SINGLE_ROOM);
        System.out.println("the checkInInfo includes "+checkInPO1.getRoomNum() + " "+ checkInPO1.getRoomType());
        System.out.println("checkin time is "+checkInPO1.getCheckInTime());
        System.out.println("expected time is "+checkInPO1.getExpDepartTime()+"/n");
        
        Date checkInTime=new Date(System.currentTimeMillis());
        CheckInOutPO checkInPO2=(CheckInOutPO)roomDAO.getCheckInInfo("江苏省南京市栖霞区仙林大道163号", checkInTime);
        System.out.println("the checkInInfo includes "+checkInPO2.getRoomNum() + " "+ checkInPO2.getRoomType());
        System.out.println("checkin time is "+checkInPO2.getCheckInTime());
        System.out.println("expected time is "+checkInPO2.getExpDepartTime()+"/n");
        
        ArrayList<RoomPO> checkOutInfoList=roomDAO.getCheckInInfoList("江苏省南京市栖霞区仙林大道163号");
        if(checkOutInfoList.isEmpty())
            System.out.println("This hotel doesn't have checkOut!\n");
        else
            System.out.println("There are " + checkOutInfoList.size() + " checkOuts in this hotel!\n");
        
        CheckInOutPO checkOutPO1=(CheckInOutPO)roomDAO.getCheckInInfo("江苏省南京市栖霞区仙林大道163号", RoomType.SINGLE_ROOM);
        System.out.println("the checkOutInfo includes "+checkOutPO1.getRoomNum() + " "+ checkOutPO1.getRoomType());
        System.out.println("checkOut time is "+checkOutPO1.getActDepartTime()+"/n");
        
        Date checkOutTime=new Date(System.currentTimeMillis());
        CheckInOutPO checkOutPO2=(CheckInOutPO)roomDAO.getCheckInInfo("江苏省南京市栖霞区仙林大道163号", checkOutTime);
        System.out.println("the checkInInfo includes "+checkOutPO2.getRoomNum() + " "+ checkOutPO2.getRoomType());
        System.out.println("checkOut time is "+checkOutPO2.getActDepartTime()+"/n");
        
        
        RoomPO roomPo=new RoomPO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号");
        roomDAO.update(roomPo);
        roomDAO.insert(roomPo);
        roomDAO.delete(roomPo);
        roomDAO.init();
        roomDAO.finish();

    }
}
