package businesslogic.strategybl;

import vo.OrderVO;

public class mockStrategyInfoServiceImpl extends StrategyInfoServiceImpl{

	@Override
	public String getAvailblePromotionName(OrderVO order) {
		
		return "双十一促销";
	}

	@Override
	public String getAvailbleMarketStrategyName(OrderVO order) {
		return "WhatEver";
	}

	@Override
	public int getBestDiscount(OrderVO order) {
		return 70;
	}

	@Override
	public boolean verifyEnterpriseMember(String hotelName, String enterpriseName, String securityCode) {
		return true;
	}
	
}
