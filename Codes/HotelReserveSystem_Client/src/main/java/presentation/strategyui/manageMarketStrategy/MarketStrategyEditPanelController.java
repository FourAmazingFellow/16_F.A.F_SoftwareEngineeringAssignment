package presentation.strategyui.manageMarketStrategy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

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
    private ChoiceBox<?> vipRankChoiceBox1;
    
    @FXML
    private ChoiceBox<?> vipRankChoiceBox2;
    
    @FXML
    private ChoiceBox<?> tradeAreaChoiceBox2;
    
    @FXML
    private DatePicker startTimeDatePicker3;

    @FXML
    private DatePicker endTimeDatePicker3;

    @FXML
    void handleCancel(ActionEvent event) {

    }

    @FXML
    void handleConfirm(ActionEvent event) {

    }

}
