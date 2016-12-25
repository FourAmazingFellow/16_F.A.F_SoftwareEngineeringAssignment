package po;

/**
 * 折扣策略类型的枚举类
 * @author 双
 * @version 
 * @see
 */
public enum StrategyType {
    BirthdayPromotion, MultiRoomPromotion, CooperationEnterprisePromotion,
    SpecificTimePromotion, SpecificTimeMarket,VipTradeAreaMarket, MemberRankMarket;
    
    /**
     * 把某策略的枚举类型转化成该策略的中文
     * @param strategyType 策略的枚举类
     * @return
     * @see
     */
    public static String enumToChinese(Enum<StrategyType> strategyType){
        if(strategyType==null){
            return null;
        }
        if(strategyType==StrategyType.BirthdayPromotion){
            return "生日折扣";
        }else if(strategyType==StrategyType.CooperationEnterprisePromotion){
            return "合作企业折扣";
        }else if(strategyType==StrategyType.MemberRankMarket){
            return "会员等级折扣";
        }else if(strategyType==StrategyType.MultiRoomPromotion){
            return "多房间折扣";
        }else if(strategyType==StrategyType.SpecificTimeMarket){
            return "特定时间营销折扣";
        }else if(strategyType==StrategyType.SpecificTimePromotion){
            return "特定时间促销折扣";
        }else if(strategyType==StrategyType.VipTradeAreaMarket){
            return "专属商圈会员等级折扣";
        }else {
            return null;
        }
    }
    
    /**
     * 把某策略的中文转化成对应枚举类型
     * @param strategyTypeShowed 策略的中文
     * @return
     * @see
     */
    public static Enum<StrategyType> chineseToEnum(String strategyTypeShowed){
        if(strategyTypeShowed==null||strategyTypeShowed.isEmpty()){
            return null;
        }
        Enum<StrategyType> strategyType;
        if(strategyTypeShowed.equals("生日折扣")){
            strategyType=StrategyType.BirthdayPromotion;
        }else if(strategyTypeShowed.equals("合作企业折扣")){
            strategyType=StrategyType.CooperationEnterprisePromotion;
        }else if(strategyTypeShowed.equals("会员等级折扣")){
            strategyType=StrategyType.MemberRankMarket;
        }else if(strategyTypeShowed.equals("多房间折扣")){
            strategyType=StrategyType.MultiRoomPromotion;
        }else if(strategyTypeShowed.equals("特定时间促销折扣")){
            strategyType=StrategyType.SpecificTimePromotion;
        }else if(strategyTypeShowed.equals("特定时间营销折扣")){
            strategyType=StrategyType.SpecificTimeMarket;
        }else{
            strategyType=StrategyType.VipTradeAreaMarket;
        }
        return strategyType;
    }
}
