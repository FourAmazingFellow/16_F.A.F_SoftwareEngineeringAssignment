package presentation.strategyui.manageMarketStrategy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MarketStrategyPanelController {
    
    @FXML
    private TextField strategyNameTextField;
    
    @FXML
    private TabPane strategyTypeTabPane;
    
    @FXML
    private Tab MemberRankMarketStrategyTab;
    
    @FXML
    private Tab VIPTradeAreaMarketStrategyTab;
    
    @FXML
    private Tab specialTimeMarketStrategyTab;
    
    @FXML
    private TableView<?> memberRankMarketStrategyTable;
    
    @FXML
    private TableView<?> VIPTradeAreaMarketStrategyTable;
    
    @FXML
    private TableView<?> specialTimeMarketStrategyTable;
    
    @FXML
    private TableColumn<?, ?> strategyNameColumn1;
    
    @FXML
    private TableColumn<?, ?> strategyNameColumn2;
    
    @FXML
    private TableColumn<?, ?> strategyNameColumn3;

    @FXML
    private TableColumn<?, ?> discountColumn1;

    @FXML
    private TableColumn<?, ?> discountColumn2;
    
    @FXML
    private TableColumn<?, ?> discountColumn3;
    
    @FXML
    private TableColumn<?, ?> VIPRankColumn1;

    @FXML
    private TableColumn<?, ?> VIPRankColumn2;
    
    @FXML
    private TableColumn<?, ?> tradeAreaColumn2;

    @FXML
    private TableColumn<?, ?> startTimeColumn3;

    @FXML
    private TableColumn<?, ?> endTimeColumn3;
    
    @FXML
    void handleSearchWithStrategyName(ActionEvent event) {
        
    }

    @FXML
    void handleNewMarketStrategy(ActionEvent event) {

    }

    @FXML
    void handleDeleteMarketStrategy(ActionEvent event) {

    }

    @FXML
    void handleModifyMarketStrategy(ActionEvent event) {

    }

}
