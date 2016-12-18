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
    
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    
    public Strategy(Enum<StrategyType> strategyType){
        this(new StrategyVO("", strategyType, "", 0));
    }
    
    public Strategy(StrategyVO strategyVO){
        this.strategyType=new SimpleStringProperty(StrategyType.enumToChinese(strategyVO.strategyType));
        this.discount=new SimpleStringProperty(String.valueOf(strategyVO.discount));
        this.strategyName=new SimpleStringProperty(strategyVO.strategyName);
        if(strategyVO.strategyType==StrategyType.MemberRankMarket){
            if(strategyVO.vipRank!=0)
                vipRank=new SimpleStringProperty(String.valueOf(strategyVO.vipRank));
            else 
                vipRank=new SimpleStringProperty(String.valueOf(0));
        }else if(strategyVO.strategyType==StrategyType.MultiRoomPromotion){
            if(strategyVO.minRoomNum!=0)
                minRoomNum=new SimpleStringProperty(String.valueOf(strategyVO.minRoomNum));
            else
                minRoomNum=new SimpleStringProperty(String.valueOf(0));
        }else if(strategyVO.strategyType==StrategyType.CooperationEnterprisePromotion){
            if(strategyVO.enterpriseName!=null)
                enterpriseName=new SimpleStringProperty(strategyVO.enterpriseName);
            else
                enterpriseName=new SimpleStringProperty("");
            if(strategyVO.securityCode!=null)
                securityCode=new SimpleStringProperty(strategyVO.securityCode);
            else 
                securityCode=new SimpleStringProperty("");
        }else if(strategyVO.strategyType==StrategyType.VipTradeAreaMarket){
            if(strategyVO.vipRank!=0)
                vipRank=new SimpleStringProperty(String.valueOf(strategyVO.vipRank));
            else
                vipRank=new SimpleStringProperty(String.valueOf(0));
            tradeArea=new SimpleStringProperty(strategyVO.tradeArea);
        }else{
            if(strategyVO.startTime!=null)
                startTime=new SimpleStringProperty(dateFormat.format(strategyVO.startTime));
            else 
                startTime=new SimpleStringProperty();
            if(strategyVO.endTime!=null)
                endTime=new SimpleStringProperty(dateFormat.format(strategyVO.endTime));
            else 
                endTime=new SimpleStringProperty();
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
    
    public float getDiscount(){
        return Float.parseFloat(discount.get());
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
    
    public StrategyVO toVO(String address) throws ParseException{
        if(getStrategyType()==StrategyType.BirthdayPromotion){
            new StrategyVO(address, getStrategyType(), getStrategyName(), getDiscount());
        }else if(getStrategyType()==StrategyType.CooperationEnterprisePromotion){
            new StrategyVO(address, getStrategyType(), getStrategyName(), getDiscount(), getEnterpriseName(), getSecurityCode());
        }else if(getStrategyType()==StrategyType.MultiRoomPromotion){
            new StrategyVO(address, getStrategyType(), getStrategyName(), getDiscount(), getMinRoomNum());
        }else if(getStrategyType()==StrategyType.SpecificTimePromotion){
            new StrategyVO(address, getStrategyType(), getStrategyName(), getDiscount(), getStartTime(), getEndTime());
        }
        return null;
    }
}
