package presentation.strategyui.manageHotelPromotion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

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

    @FXML
    void handleCancel(ActionEvent event) {

    }

    @FXML
    void handleConfirm(ActionEvent event) {

    }

}
