package bl_Driver.strategyblservice_Driver;

import java.util.ArrayList;

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
        ArrayList<StrategyVO> strategyList=updateStrategyService.getStrategyList("江苏省南京市栖霞区仙林大道163号", StrategyType.BirthdayPromotion);
        if(strategyList.isEmpty())
            System.out.println("This kind of strategy doesn't exit!\n");
        else
            System.out.println("There are " + strategyList.size() + " checkIns in this hotel!\n");
        
        StrategyVO strategyVO=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.BirthdayPromotion, "双十一折扣", 80);
        System.out.println("The strategy "+strategyVO.strategyName+" has discount "+strategyVO.discount+"/n");
        
        boolean addStrategy=updateStrategyService.add("江苏省南京市栖霞区仙林大道163号", strategyVO);
        if(addStrategy)
            System.out.println("add Strategy Succeed!\n");
        else
            System.out.println("add Strategy Failed!\n");
        
        boolean modifyStrategy=updateStrategyService.modify("江苏省南京市栖霞区仙林大道163号", strategyVO);
        if(modifyStrategy)
            System.out.println("modify Strategy Succeed!\n");
        else
            System.out.println("modify Strategy Failed!\n");
        
        boolean delStrategy=updateStrategyService.delete("江苏省南京市栖霞区仙林大道163号", strategyVO);
        if(delStrategy)
            System.out.println("delete Strategy Succeed!\n");
        else
            System.out.println("delete Strategy Failed!\n");
        
        boolean validStrategy=updateStrategyService.valid("江苏省南京市栖霞区仙林大道163号", strategyVO);
        if(validStrategy)
            System.out.println("Strategy valid!\n");
        else
            System.out.println("Strategy doesn't valid!\n");
        
    }
}
