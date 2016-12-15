package presentation.mainui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import presentation.ClientMainApp;

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

    private ClientMainApp mainApp;
    
    public void setMainApp(ClientMainApp mainApp) {
    	this.mainApp = mainApp;
    }
    
    public void modifyPersonalInfoAction() {
    	
    }
    
    public void myOrderAction() {
    	mainApp.showUserOrderPanel(ClientMainApp.userID);
    }
    
    public void myReservedHotelAction() {
    	
    }
    
    public void searchHotelAction() {
    	mainApp.showSearchView();
    }
    
    
}