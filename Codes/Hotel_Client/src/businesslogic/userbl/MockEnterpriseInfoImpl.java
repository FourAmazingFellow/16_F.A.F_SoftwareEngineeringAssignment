package businesslogic.userbl;

import businesslogic.strategybl.StrategyInfoService;

public class MockEnterpriseInfoImpl extends EnterpriseInfoImpl{
    private StrategyInfoService strategyInfoService ;
    
    @Override
    public boolean verifyEnterpriseMember(String enterpriseName, String securityCode) {
        return strategyInfoService.verifyEnterpriseMember(enterpriseName, securityCode);
    }
}
