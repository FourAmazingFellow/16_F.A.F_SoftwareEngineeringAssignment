package presentation.mainui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import presentation.WebsitePromotionMainApp;

public class WebsitePromotionRootBoardController {
    @FXML
    private MenuButton userActionButton;

    @FXML
    private Button modifyPersonalInfoSection;

    @FXML
    private Button myOrderSection;

    @FXML
    private Button myReservedHotelSection;

    @FXML
    private Button searchHotelSection;

    private WebsitePromotionMainApp mainApp;
    
    public void setMainApp(WebsitePromotionMainApp mainApp) {
    	this.mainApp = mainApp;
    }
}
