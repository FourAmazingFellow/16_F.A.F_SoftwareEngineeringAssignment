package businesslogic.strategybl;

import vo.OrderVO;

/**
 * StrategyInfoServiceImpl的Mock类
 * @author 双
 * @version 
 * @see
 */
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
	public float getBestDiscount(OrderVO order) {
		return 70;
	}

}
