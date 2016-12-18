package bl_Driver.userblservice_Driver;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.AddCreditValueService;

public class AddCreditValueServiceImpl_Driver {
    public void drive(AddCreditValueService addCreditValueService) throws RemoteException{
        boolean result = addCreditValueService.addCreditValue("原", 100);
        if(result)
           System.out.println("Add Succeed!\n");
       else
           System.out.println("Add Failed!\n");
    }
}
