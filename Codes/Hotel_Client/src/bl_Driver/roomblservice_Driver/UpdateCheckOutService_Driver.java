package bl_Driver.roomblservice_Driver;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.roomblservice.UpdateCheckOutService;
import po.RoomType;
import vo.CheckInOutVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateCheckOutService_Driver {
    public void drive(UpdateCheckOutService updateCheckOutService){
        ArrayList<RoomVO> checkOutInfoList=updateCheckOutService.getCheckOutList("江苏省南京市栖霞区仙林大道163号");
        if(checkOutInfoList.isEmpty())
            System.out.println("This hotel doesn't have checkOut!\n");
        else
            System.out.println("There are " + checkOutInfoList.size() + " checkOuts in this hotel!\n");
        
        Date checkOutTime=new Date(System.currentTimeMillis());
        ArrayList<RoomVO> checkOutVOList1=updateCheckOutService.getCheckOutInfo("江苏省南京市栖霞区仙林大道163号", checkOutTime);
        CheckInOutVO checkOutVO1=(CheckInOutVO) checkOutVOList1.get(0);
        System.out.println("the checkOutInfo includes "+checkOutVO1.roomNum + " 间"+ checkOutVO1.roomType);
        System.out.println("Actual depart time is "+checkOutVO1.actDepartTime+"/n");
        
        ArrayList<RoomVO> checkOutVOList2=updateCheckOutService.getCheckOutInfo("江苏省南京市栖霞区仙林大道163号", RoomType.SINGLE_ROOM);
        CheckInOutVO checkOutVO2=(CheckInOutVO) checkOutVOList2.get(0);
        System.out.println("the checkOutInfo includes "+checkOutVO2.roomNum + " 间"+ checkOutVO2.roomType);
        System.out.println("Actual depart time is "+checkOutVO2.actDepartTime+"/n");
        
        Date actDepartTime=new Date(System.currentTimeMillis());
        CheckInOutVO checkOut=new CheckInOutVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", actDepartTime);
        boolean addCheckOut=updateCheckOutService.addCheckOut("江苏省南京市栖霞区仙林大道163号", checkOut);
        if(addCheckOut)
            System.out.println("add checkOut Succeed!\n");
        else
            System.out.println("add checkOut Failed!\n");
        
        boolean modifyCheckOut=updateCheckOutService.modifyCheckOut("江苏省南京市栖霞区仙林大道163号", checkOut);
        if(modifyCheckOut)
            System.out.println("modify checkOut Succeed!\n");
        else
            System.out.println("modify checkOut Failed!\n");
        
        boolean delCheckOut=updateCheckOutService.delCheckOut("江苏省南京市栖霞区仙林大道163号", checkOut);
        if(delCheckOut)
            System.out.println("delete checkOut Succeed!\n");
        else
            System.out.println("delete checkOut Failed!\n");
        
        boolean validCheckOut=updateCheckOutService.validCheckOut("江苏省南京市栖霞区仙林大道163号", checkOut);
        if(validCheckOut)
            System.out.println("This checkOut valid!\n");
        else
            System.out.println("This checkOut not valid!\n");
        
    }
}
