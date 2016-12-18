package presentation.mainui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import presentation.ClientMainApp;
import presentation.HotelMainApp;

public class HotelRootBoardController {

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

    private HotelMainApp mainApp;
    
    public void setMainApp(HotelMainApp mainApp) {
    	this.mainApp = mainApp;
    }    
    
}
