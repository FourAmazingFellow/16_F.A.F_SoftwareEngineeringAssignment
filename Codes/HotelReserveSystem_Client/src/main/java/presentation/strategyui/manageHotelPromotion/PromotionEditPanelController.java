package presentation.strategyui.manageHotelPromotion;

import businesslogicservice.strategyblservice.UpdateStrategyService;
import factory.StrategyUIFactoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.strategyui.model.Strategy;

public class PromotionEditPanelController {
    
    @FXML
    private TabPane strategyTypeTabPane;
    
    @FXML
    private Tab birthdayPromotionTab;
    
    @FXML
    private Tab multiRoomPromotionTab;
    
    @FXML
    private Tab cooperationEnterPrisePromotionTab;
    
    @FXML
    private Tab specialTimePromotionTab;
    
    @FXML
    private TextField strategyNameTextField1;
    
    @FXML
    private TextField discountTextField1;
    
    @FXML
    private TextField strategyNameTextField2;
    
    @FXML
    private TextField discountTextField2;

    @FXML
    private TextField minRoomTextField2;
    
    @FXML
    private TextField strategyNameTextField3;
    
    @FXML
    private TextField discountTextField3;

    @FXML
    private TextField cooperationEnterpriseTextField3;
    
    @FXML
    private TextField securityCodeTextField3;

    @FXML
    private TextField strategyNameTextField4;

    @FXML
    private TextField discountTextField4;

    @FXML
    private DatePicker startTimeDatePicker4;

    @FXML
    private DatePicker endTimeDatePicker4;
    
    private ObservableList<String> strategyTypeList = FXCollections.observableArrayList(
            "生日折扣","多房间折扣", "合作企业折扣","特定时间促销折扣");
    private Stage dialogStage;
    private Strategy strategy;
    private boolean isConfirmed = false;
    
    private StrategyUIFactoryService strategyUIFactoryService;
    private UpdateStrategyService updateStrategyService=strategyUIFactoryService.createUpdateStrategyService();
    private String address;
    
    @FXML
    private void initialize(){
        
        //添加Tab的监听
    }
    
    

    @FXML
    void handleCancel(ActionEvent event) {

    }

    @FXML
    void handleConfirm(ActionEvent event) {

    }

}
