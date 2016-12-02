package bl_Driver.strategyblservice_Driver;

import java.util.ArrayList;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToDeleteStrategyException;
import businesslogic.strategybl.exception.UnableToModifyStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogicservice.strategyblservice.UpdateStrategyService;
import po.StrategyType;
import vo.StrategyVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateStrategyService_Driver {
    public void drive(UpdateStrategyService updateStrategyService){
        ArrayList<StrategyVO> strategyList=updateStrategyService.getStrategyList("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion);
        if(strategyList.isEmpty())
            System.out.println("This kind of strategy doesn't exit!\n");
        else
            System.out.println("There are " + strategyList.size() + " checkIns in this hotel!\n");
        
        StrategyVO strategyVO=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion, "双十一折扣", 80);
        System.out.println("The strategy "+strategyVO.strategyName+" has discount "+strategyVO.discount+"/n");
        
        boolean addStrategy = false;
        try {
            addStrategy = updateStrategyService.add("江苏省南京市栖霞区仙林大道163号", strategyVO);
        } catch (UnableAddStrategyException e1) {
            System.out.println(e1.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        if(addStrategy)
            System.out.println("add Strategy Succeed!\n");
        else
            System.out.println("add Strategy Failed!\n");
        
        boolean modifyStrategy = false;
        try {
            modifyStrategy = updateStrategyService.modify("江苏省南京市栖霞区仙林大道163号", strategyVO);
        } catch (UnableToModifyStrategyException e1) {
            System.out.println(e1.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        if(modifyStrategy)
            System.out.println("modify Strategy Succeed!\n");
        else
            System.out.println("modify Strategy Failed!\n");
        
        boolean delStrategy = false;
        try {
            delStrategy = updateStrategyService.delete("江苏省南京市栖霞区仙林大道163号", strategyVO);
        } catch (UnableToDeleteStrategyException e1) {
            System.out.println(e1.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        if(delStrategy)
            System.out.println("delete Strategy Succeed!\n");
        else
            System.out.println("delete Strategy Failed!\n");
        
        boolean validStrategy=false;
        try {
            validStrategy = updateStrategyService.valid("江苏省南京市栖霞区仙林大道163号", strategyVO);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        if(validStrategy)
            System.out.println("Strategy valid!\n");
        else
            System.out.println("Strategy doesn't valid!\n");
        
    }
}
