package presentation.mainui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import presentation.MainApp;

public class ClientRootBoardController {

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

    @FXML
    private Button homeButton;

    private MainApp mainApp;
    
    public void setMainApp(MainApp mainApp) {
    	this.mainApp = mainApp;
    }
}
