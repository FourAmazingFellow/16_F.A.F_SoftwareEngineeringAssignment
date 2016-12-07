package presentation.strategyui.manageHotelPromotion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PromotionPanelController {
    
    @FXML
    private TextField strategyNameTextField;
    
    @FXML
    private TabPane strategyTypeTabPane;
    
    @FXML
    private Tab birthdayPromotionTab;
    
    @FXML
    private Tab multiRoomPromotionTab;
    
    @FXML
    private Tab cooperationEnterprisePromotionTab;
    
    @FXML
    private Tab specialTimePromotionTab;
    
    @FXML
    private TableView<?> birthdayPromotionTable;
    
    @FXML
    private TableView<?> multiRoomPromotionTable;
    
    @FXML
    private TableView<?> cooperationEnterprisePromotionTable;
    
    @FXML
    private TableView<?> spcialTimePromotionTable;
    
    @FXML
    private TableColumn<?, ?> strategyNameColumn1;

    @FXML
    private TableColumn<?, ?> strategyNameColumn2;

    @FXML
    private TableColumn<?, ?> strategyNameColumn3;
    
    @FXML
    private TableColumn<?, ?> strategyNameColumn4;
    
    @FXML
    private TableColumn<?, ?> discountColumn1;
    
    @FXML
    private TableColumn<?, ?> discountColumn2;

    @FXML
    private TableColumn<?, ?> discountColumn3;

    @FXML
    private TableColumn<?, ?> discountColumn4;
    
    @FXML
    private TableColumn<?, ?> minRoomColumn2;
    
    @FXML
    private TableColumn<?, ?> cooperationEnterpriseColumn3;
    
    @FXML
    private TableColumn<?, ?> securityCodeColumn3;
    
    @FXML
    private TableColumn<?, ?> startTimeColumn4;

    @FXML
    private TableColumn<?, ?> endTimeColumn4;
    
    @FXML
    void handleSearchWithStrategyName(ActionEvent event) {
        
    }

    @FXML
    void handleNewPromotion(ActionEvent event) {

    }

    @FXML
    void handleDeletePromotion(ActionEvent event) {

    }

    @FXML
    void handleModifyPromotion(ActionEvent event) {

    }

}
