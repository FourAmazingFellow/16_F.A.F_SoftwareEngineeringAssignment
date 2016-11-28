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
    @SuppressWarnings("deprecation")
    public void drive(RoomDAO roomDAO) throws RemoteException{
        ArrayList<RoomPO> spareRoomList=roomDAO.getSpareRoomInfoList("江苏省南京市栖霞区仙林大道163号",new Date(116,10,27));
        if(spareRoomList.isEmpty())
            System.out.println("No spareRoom!\n");
        else
            System.out.println("There are " + spareRoomList.size() + " kinds of spareRoom!\n");
        
        RoomPO roomPO=roomDAO.getSpareRoomInfo("江苏省南京市栖霞区仙林大道163号", RoomType.SINGLE_ROOM,new Date(116,10,27));
        System.out.println("There are "+roomPO.getRoomNum()+" "+roomPO.getRoomType()+" room!/n");
        
        ArrayList<RoomPO> checkInInfoList=roomDAO.getCheckInInfoList("江苏省南京市栖霞区仙林大道163号");
        if(checkInInfoList.isEmpty())
            System.out.println("This hotel doesn't have checkIn!\n");
        else
            System.out.println("There are " + checkInInfoList.size() + " checkIns in this hotel!\n");
        
        ArrayList<RoomPO> checkInPOlist1=roomDAO.getCheckInInfo("江苏省南京市栖霞区仙林大道163号", RoomType.SINGLE_ROOM);
        CheckInOutPO checkInPO1=(CheckInOutPO) checkInPOlist1.get(0);
        System.out.println("the checkInInfo includes "+checkInPO1.getRoomNum() + " "+ checkInPO1.getRoomType());
        System.out.println("checkin time is "+checkInPO1.getCheckInTime());
        System.out.println("expected time is "+checkInPO1.getExpDepartTime()+"/n");
        
        Date checkInTime=new Date(System.currentTimeMillis());
        ArrayList<RoomPO> checkInPOlist2=roomDAO.getCheckInInfo("江苏省南京市栖霞区仙林大道163号", checkInTime, checkInTime);
        CheckInOutPO checkInPO2=(CheckInOutPO) checkInPOlist2.get(0);
        System.out.println("the checkInInfo includes "+checkInPO2.getRoomNum() + " "+ checkInPO2.getRoomType());
        System.out.println("checkin time is "+checkInPO2.getCheckInTime());
        System.out.println("expected time is "+checkInPO2.getExpDepartTime()+"/n");
        
        ArrayList<RoomPO> checkOutInfoList=roomDAO.getCheckInInfoList("江苏省南京市栖霞区仙林大道163号");
        if(checkOutInfoList.isEmpty())
            System.out.println("This hotel doesn't have checkOut!\n");
        else
            System.out.println("There are " + checkOutInfoList.size() + " checkOuts in this hotel!\n");
        
        ArrayList<RoomPO> checkOutPOlist1=roomDAO.getCheckOutInfo("江苏省南京市栖霞区仙林大道163号", RoomType.SINGLE_ROOM);
        CheckInOutPO checkOutPO1=(CheckInOutPO) checkOutPOlist1.get(0);
        System.out.println("the checkOutInfo includes "+checkOutPO1.getRoomNum() + " "+ checkOutPO1.getRoomType());
        System.out.println("checkOut time is "+checkOutPO1.getActDepartTime()+"/n");
        
        Date checkOutTime=new Date(System.currentTimeMillis());
        ArrayList<RoomPO> checkOutPOlist2=roomDAO.getCheckInInfo("江苏省南京市栖霞区仙林大道163号", checkOutTime, checkOutTime);
        CheckInOutPO checkOutPO2=(CheckInOutPO) checkOutPOlist2.get(0);
        System.out.println("the checkInInfo includes "+checkOutPO2.getRoomNum() + " "+ checkOutPO2.getRoomType());
        System.out.println("checkOut time is "+checkOutPO2.getActDepartTime()+"/n");
        
        
        RoomPO roomPo=new RoomPO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号");
        roomDAO.updateRoom(roomPo,new Date(116,10,27));
        roomDAO.insertRoom(roomPo);

    }
}
