package presentation.strategyui.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.StrategyType;

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
    
    public Strategy(Enum<StrategyType> strategyType, String strategyName, float discount){
        this.strategyType=new SimpleStringProperty(StrategyType.enumToChinese(strategyType));
        this.discount=new SimpleStringProperty(String.valueOf(discount));
        this.strategyName=new SimpleStringProperty(strategyName);
    }
    
    public Strategy(Enum<StrategyType> strategyType, String strategyName, float discount,int aInt){
        this.strategyType=new SimpleStringProperty(StrategyType.enumToChinese(strategyType));
        this.discount=new SimpleStringProperty(String.valueOf(discount));
        this.strategyName=new SimpleStringProperty(strategyName);
        if(strategyType==StrategyType.MemberRankMarket){
            vipRank=new SimpleStringProperty(String.valueOf(aInt));
        }
        if(strategyType==StrategyType.MultiRoomPromotion){
            minRoomNum=new SimpleStringProperty(String.valueOf(aInt));
        }
    }
    
    public Strategy(Enum<StrategyType> strategyType, String strategyName, float discount, Date startTime, Date endTime){
        this.strategyType=new SimpleStringProperty(StrategyType.enumToChinese(strategyType));
        this.discount=new SimpleStringProperty(String.valueOf(discount));
        this.strategyName=new SimpleStringProperty(strategyName);
        this.startTime=new SimpleStringProperty(dateFormat.format(startTime));
        this.endTime=new SimpleStringProperty(dateFormat.format(endTime));
    }
    
    
}
