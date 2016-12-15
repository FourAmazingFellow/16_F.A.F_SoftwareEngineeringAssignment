package presentation.strategyui.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.StrategyType;
import vo.StrategyVO;

public class Strategy {
    
    private StringProperty strategyType;
    private StringProperty strategyName;
    private StringProperty discount;
    private StringProperty minRoomNum;
    private StringProperty enterpriseName;
    private StringProperty securityCode;
    private StringProperty startTime;
    private StringProperty endTime;
    private StringProperty tradeArea;
    private StringProperty vipRank;
    
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public Strategy(){
        this(null);
    }
    
    public Strategy(StrategyVO strategyVO){
        this.strategyType=new SimpleStringProperty(StrategyType.enumToChinese(strategyVO.strategyType));
        this.discount=new SimpleStringProperty(String.valueOf(strategyVO.discount));
        this.strategyName=new SimpleStringProperty(strategyVO.strategyName);
        if(strategyVO.strategyType==StrategyType.MemberRankMarket){
            vipRank=new SimpleStringProperty(String.valueOf(strategyVO.vipRank));
        }else if(strategyVO.strategyType==StrategyType.MultiRoomPromotion){
            minRoomNum=new SimpleStringProperty(String.valueOf(strategyVO.minRoomNum));
        }else if(strategyVO.strategyType==StrategyType.CooperationEnterprisePromotion){
            enterpriseName=new SimpleStringProperty(strategyVO.enterpriseName);
            securityCode=new SimpleStringProperty(strategyVO.securityCode);
        }else if(strategyVO.strategyType==StrategyType.VipTradeAreaMarket){
            vipRank=new SimpleStringProperty(String.valueOf(strategyVO.vipRank));
            tradeArea=new SimpleStringProperty(strategyVO.tradeArea);
        }else{
            startTime=new SimpleStringProperty(dateFormat.format(strategyVO.startTime));
            endTime=new SimpleStringProperty(dateFormat.format(strategyVO.endTime));
        }
    }
    
    public StringProperty strategyTypeProperty(){
        return strategyType;
    }
    
    public StringProperty strategyNameProperty(){
        return strategyName;
    }
    
    public StringProperty discountProperty(){
        return discount;
    }
    
    public StringProperty minRoomNumProperty(){
        return minRoomNum;
    }
    
    public StringProperty enterpriseProperty(){
        return enterpriseName;
    }
    
    public StringProperty securityCodeProperty(){
        return securityCode;
    }
    
    public StringProperty startTimeProperty(){
        return startTime;
    }
    
    public StringProperty endTimeProperty(){
        return endTime;
    }
    
    public StringProperty tradeAreaProperty(){
        return tradeArea;
    }
    
    public StringProperty vipRankProperty(){
        return vipRank;
    }
    
    public void setStrategyType(Enum<StrategyType> strategyType){
        this.strategyType.set(StrategyType.enumToChinese(strategyType));
    }
    
    public void setStrategyName(String strategyName){
        this.strategyName.set(strategyName);
    }
    
    public void setDiscount(int discount){
        this.discount.set(String.valueOf(discount));
    }
    
    public void setMinRoomNum(int minRoomNum){
        this.minRoomNum.set(String.valueOf(minRoomNum));
    }
    
    public void setEnterpriseName(String enterpriseName){
        this.enterpriseName.set(enterpriseName);
    }
    
    public void setSecurityCode(String securityCode){
        this.securityCode.set(securityCode);
    }
    
    public void setStartTime(Date StartTime){
        this.startTime.set(dateFormat.format(StartTime));
    }
    
    public void setEndTime(Date endTime){
        this.endTime.set(dateFormat.format(endTime));
    }
    
    public void setTradeArea(String tradeArea){
        this.tradeArea.set(tradeArea);
    }
    
    public void setVipRank(int vipRank){
        this.vipRank.set(String.valueOf(vipRank));
    }
    
    public Enum<StrategyType> getStrategyType(){
        return StrategyType.chineseToEnum(strategyType.get());
    }
    
    public String getStrategyName(){
        return strategyName.get();
    }
    
    public int getDiscount(){
        return Integer.parseInt(discount.get());
    }
    
    public int getMinRoomNum(){
        return Integer.parseInt(minRoomNum.get());
    }
    
    public String getEnterpriseName(){
        return strategyName.get();
    }
    
    public String getSecurityCode(){
        return securityCode.get();
    }
    
    public Date getStartTime() throws ParseException{
        return dateFormat.parse(startTime.get());
    }
    
    public Date getEndTime() throws ParseException{
        return dateFormat.parse(endTime.get());
    }
    
    public String getTradeArea(){
        return tradeArea.get();
    }
    
    public int getVipRank(){
        return Integer.parseInt(vipRank.get());
    }
}
