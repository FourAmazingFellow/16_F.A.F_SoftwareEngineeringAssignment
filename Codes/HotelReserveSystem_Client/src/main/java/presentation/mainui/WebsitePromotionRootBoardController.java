package presentation.mainui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import presentation.WebsitePromotionMainApp;
import runner.ClientRunner;

public class WebsitePromotionRootBoardController {
    @FXML
    private MenuButton userActionButton;

    @FXML
    private Button manageAbnormalOrderSection;

    @FXML
    private Button addCreditSection;

    @FXML
    private Button updateStrategySection;

    private WebsitePromotionMainApp mainApp;


    
    public void setMainApp(WebsitePromotionMainApp mainApp) {
    	this.mainApp = mainApp;
    }
    
    @FXML
    void addCreditAction(ActionEvent event) {
    	mainApp.showAddCreditPanel();
    }
}
