package presentation.strategyui.manageMarketStrategy;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

import businesslogic.strategybl.exception.WrongInputException;
import businesslogicservice.strategyblservice.UpdateStrategyService;
import factory.StrategyUIFactoryService;
import factory.StrategyUIFactoryServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import po.BusinessDistrictPO;
import po.StrategyType;
import presentation.roomui.CheckIn.CheckInEditPanelController;
import presentation.roomui.util.LocalDateAdapter;
import presentation.strategyui.model.Strategy;
import vo.StrategyVO;

public class MarketStrategyEditPanelController {
    
    @FXML
    private TabPane strategyTypeTabPane;
    
    @FXML
    private Tab memberRankMarketStrategyTab;
    
    @FXML
    private Tab VIPTradeAreaMarketStrategyTab;
    
    @FXML
    private Tab specialTimeMarketStrategyTab;
    
    @FXML
    private TextField strategyNameTextField1;

    @FXML
    private TextField strategyNameTextField2;
    
    @FXML
    private TextField strategyNameTextField3;
    
    @FXML
    private TextField discountTextField1;
    
    @FXML
    private TextField discountTextField2;
    
    @FXML
    private TextField discountTextField3;
    
    @FXML
    private ChoiceBox<Integer> vipRankChoiceBox1;
    
    @FXML
    private ChoiceBox<Integer> vipRankChoiceBox2;
    
    @FXML
    private ChoiceBox<String> cityChoiceBox2;
    
    @FXML
    private ChoiceBox<String> tradeAreaChoiceBox2;
    
    @FXML
    private DatePicker startTimeDatePicker3;

    @FXML
    private DatePicker endTimeDatePicker3;
    
    private Stage dialogStage;
    private Strategy strategy;
    private boolean isConfirmed = false;
    private ObservableList<String> cityListData=FXCollections.observableArrayList("南京市","上海市");
    private ObservableList<String> tradeAreaListData=FXCollections.observableArrayList();
    private ObservableList<Integer> vipRankList=FXCollections.observableArrayList(0,1,2,3,4);
    private StrategyUIFactoryService strategyUIFactoryService=new StrategyUIFactoryServiceImpl();
    private UpdateStrategyService updateStrategyService = strategyUIFactoryService.createUpdateStrategyService();
    private String address;
    private boolean isNewaPromotion;
    
    
    @FXML
    private void initialize() {
        
        vipRankChoiceBox1.setItems(vipRankList);
        vipRankChoiceBox2.setItems(vipRankList);
        cityChoiceBox2.setItems(cityListData);
        tradeAreaChoiceBox2.setItems(tradeAreaListData);
        setTradeAreaList(updateStrategyService.getBusinessDistrictList(cityChoiceBox2.getSelectionModel().getSelectedItem()));
        //给cityChoiceBox2添加监听
        cityChoiceBox2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setTradeAreaList(updateStrategyService.getBusinessDistrictList(cityListData.get((int)newValue)));
            }
        });
    }
    
    public void setTradeAreaList(ArrayList<BusinessDistrictPO> tradeAreaPOs){
        tradeAreaListData.clear();
        for(BusinessDistrictPO tradeAreaPO:tradeAreaPOs){
            tradeAreaListData.add(tradeAreaPO.getBusinessDistrictName());
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setStrategy(Strategy strategy, String address, boolean isNewaPromotion) {
     // 把传进来的strategy设为成员变量，便于修改
        this.strategy = strategy;
        this.address = address;
     // 把其他策略类型的tab设置为disable,并把不能修改的东西设成disable,如果是修改strategy,把默认值设为原始值
        if (strategy.getStrategyType() == StrategyType.MemberRankMarket) {
            VIPTradeAreaMarketStrategyTab.setDisable(true);
            specialTimeMarketStrategyTab.setDisable(true);
            if(!isNewaPromotion){
                strategyNameTextField1.setText(strategy.getStrategyName());
                discountTextField1.setText(String.valueOf(strategy.getDiscount()));
                vipRankChoiceBox1.getSelectionModel().select(strategy.getVipRank());
            }
        }else if(strategy.getStrategyType() == StrategyType.VipTradeAreaMarket){
            memberRankMarketStrategyTab.setDisable(true);
            specialTimeMarketStrategyTab.setDisable(true);
            if(!isNewaPromotion){
                strategyNameTextField2.setText(strategy.getStrategyName());
                discountTextField2.setText(String.valueOf(strategy.getDiscount()));
                vipRankChoiceBox2.getSelectionModel().select(strategy.getVipRank());
                for(String city: cityListData){
                    for(BusinessDistrictPO tradeArea:updateStrategyService.getBusinessDistrictList(city)){
                        if(tradeArea.equals(strategy.getTradeArea())){
                            cityChoiceBox2.getSelectionModel().select(city);
                        }
                    }
                }
                tradeAreaChoiceBox2.getSelectionModel().select(strategy.getTradeArea());
            }
        }else if(strategy.getStrategyType()==StrategyType.SpecificTimeMarket){
            memberRankMarketStrategyTab.setDisable(true);
            VIPTradeAreaMarketStrategyTab.setDisable(true);
            if(!isNewaPromotion){
                strategyNameTextField3.setText(strategy.getStrategyName());
                discountTextField3.setText(String.valueOf(strategy.getDiscount()));
                try {
                    startTimeDatePicker3.setValue(LocalDateAdapter.fromDate(strategy.getStartTime()));
                    endTimeDatePicker3.setValue(LocalDateAdapter.fromDate(strategy.getEndTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!isNewaPromotion) {
            strategyNameTextField1.setDisable(true);
        }
    }

    @FXML
    void handleCancel() {
        dialogStage.close();
    }

    @FXML
    void handleConfirm() {
        // 判断输入的数据是否有效
        boolean inputValid = false;
        while (!inputValid) {
            if (isInputValid()) {
                inputValid = true;
            }
        }
        
        // 弹出对话框请求确认
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("确认添加或修改策略");
        alert.setHeaderText("你是否确定要增加或修改该策略？");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            isConfirmed = true;
        } else {
            isConfirmed = false;
            handleCancel();
            return;
        }
        
        // 把新建或修改的strategy传给上一个界面
        strategy.setStrategyName(strategyNameTextField1.getText());
        strategy.setDiscount(Integer.parseInt(discountTextField1.getText()));
        if (strategy.getStrategyType() == StrategyType.MemberRankMarket) {
            strategy.setVipRank(vipRankChoiceBox1.getSelectionModel().getSelectedItem());
        }else if (strategy.getStrategyType()==StrategyType.VipTradeAreaMarket){
            strategy.setVipRank(vipRankChoiceBox2.getSelectionModel().getSelectedItem());
            strategy.setTradeArea(tradeAreaChoiceBox2.getSelectionModel().getSelectedItem());
        }else if(strategy.getStrategyType()==StrategyType.SpecificTimeMarket){
            strategy.setStartTime(LocalDateAdapter.toDate(startTimeDatePicker3.getValue()));
            strategy.setEndTime(LocalDateAdapter.toDate(endTimeDatePicker3.getValue()));
        }
    }

    private boolean isInputValid() {
        if (strategy.getStrategyType() == StrategyType.MemberRankMarket) {
            if(strategyNameTextField1.getText()==""){
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("策略名称空缺");
                alert.setContentText("请输入策略名称");

                alert.showAndWait();
                return false;
            }
            if (discountTextField1.getText()==""||!isDigit(discountTextField1.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("折扣百分比错误");
                alert.setContentText("请在折扣百分比中输入数字");

                alert.showAndWait();
                return false;
            }
        }else if(strategy.getStrategyType() == StrategyType.VipTradeAreaMarket){
            if(strategyNameTextField2.getText()==""){
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("策略名称空缺");
                alert.setContentText("请输入策略名称");

                alert.showAndWait();
                return false;
            }
            if (discountTextField2.getText()==""||!isDigit(discountTextField2.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("折扣百分比错误");
                alert.setContentText("请在折扣百分比中输入数字");

                alert.showAndWait();
                return false;
            }
            
        }else if(strategy.getStrategyType() == StrategyType.SpecificTimeMarket){
            if(strategyNameTextField3.getText()==""){
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("策略名称空缺");
                alert.setContentText("请输入策略名称");

                alert.showAndWait();
                return false;
            }
            if (discountTextField3.getText()==""||!isDigit(discountTextField3.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("折扣百分比错误");
                alert.setContentText("请在折扣百分比中输入数字");

                alert.showAndWait();
                return false;
            }
            if(startTimeDatePicker3.getValue()==null||endTimeDatePicker3.getValue()==null){
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("时间空缺");
                alert.setContentText("请选择开始时间和结束时间");

                alert.showAndWait();
                return false;
            }
        }
        StrategyVO strategyVO = null;
        try {
            strategyVO=strategy.toVO(address);
        } catch (ParseException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("策略信息错误");
            alert.setHeaderText("信息格式错误");
            alert.setContentText("");
            alert.showAndWait();
            return false;
        }
        
        try {
            if(updateStrategyService.valid(address, strategyVO)){
                return true;
            }
        } catch (WrongInputException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("策略信息错误");
            alert.setHeaderText("策略信息错误");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return false;
    }
    
    private boolean isDigit(String str){
        return CheckInEditPanelController.isDigit(str);
    }
    
}
