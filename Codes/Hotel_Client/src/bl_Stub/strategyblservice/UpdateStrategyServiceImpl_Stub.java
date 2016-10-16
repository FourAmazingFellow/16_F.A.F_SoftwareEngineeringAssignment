package bl_Stub.strategyblservice;

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
public class UpdateStrategyServiceImpl_Stub implements UpdateStrategyService{

    @Override
    public ArrayList<StrategyVO> getStrategyList(String address, Enum<StrategyType> StrategyType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StrategyVO getStrategyInfo(String address, String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(String address, StrategyVO strategy) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modify(String address, StrategyVO strategy) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(String address, StrategyVO strategy) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean Valid(String address, StrategyVO strategy) {
        // TODO Auto-generated method stub
        return false;
    }

}
