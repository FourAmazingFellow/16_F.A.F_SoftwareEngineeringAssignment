package bl_Driver.roomblservice_Driver;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.strategybl.exception.WrongInputException;
import businesslogicservice.roomblservice.UpdateCheckOutService;
import po.RoomType;
import vo.CheckOutVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateCheckOutService_Driver {
    public void drive(UpdateCheckOutService updateCheckOutService) throws RemoteException{
        ArrayList<RoomVO> checkOutInfoList=updateCheckOutService.getCheckOutList("江苏省南京市栖霞区仙林大道163号");
        if(checkOutInfoList.isEmpty())
            System.out.println("This hotel doesn't have checkOut!\n");
        else
            System.out.println("There are " + checkOutInfoList.size() + " checkOuts in this hotel!\n");
        
        Date checkOutTime=new Date(System.currentTimeMillis());
        ArrayList<RoomVO> checkOutVOList1=updateCheckOutService.searchCheckOutInfo("江苏省南京市栖霞区仙林大道163号", checkOutTime, checkOutTime);
        CheckOutVO checkOutVO1=(CheckOutVO) checkOutVOList1.get(0);
        System.out.println("the checkOutInfo includes "+checkOutVO1.roomNum + " 间"+ checkOutVO1.roomType);
        System.out.println("Actual depart time is "+checkOutVO1.actDepartTime+"/n");
        
        ArrayList<RoomVO> checkOutVOList2=updateCheckOutService.searchCheckOutInfo("江苏省南京市栖霞区仙林大道163号", RoomType.SINGLE_ROOM);
        CheckOutVO checkOutVO2=(CheckOutVO) checkOutVOList2.get(0);
        System.out.println("the checkOutInfo includes "+checkOutVO2.roomNum + " 间"+ checkOutVO2.roomType);
        System.out.println("Actual depart time is "+checkOutVO2.actDepartTime+"/n");
        
        Date actDepartTime=new Date(System.currentTimeMillis());
        CheckOutVO checkOut=new CheckOutVO(RoomType.SINGLE_ROOM, 0000000000000003, "江苏省南京市栖霞区仙林大道163号", actDepartTime);
        boolean addCheckOut = false;
        try {
            addCheckOut = updateCheckOutService.addCheckOut("江苏省南京市栖霞区仙林大道163号", checkOut);
        } catch (RemoteException e1) {
            System.out.println(e1.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        if(addCheckOut)
            System.out.println("add checkOut Succeed!\n");
        else
            System.out.println("add checkOut Failed!\n");
       
        boolean validCheckOut = false;
        try {
            validCheckOut = updateCheckOutService.validCheckOut("江苏省南京市栖霞区仙林大道163号", checkOut);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
        if(validCheckOut)
            System.out.println("This checkOut valid!\n");
        else
            System.out.println("This checkOut not valid!\n");
        
    }
}
