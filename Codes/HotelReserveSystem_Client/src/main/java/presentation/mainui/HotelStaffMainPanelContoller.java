package presentation.mainui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.HotelMainApp;

public class HotelStaffMainPanelContoller {

    @FXML
    private TextField searchOrderTextField;
    
    private HotelMainApp mainApp;
    
    public void setMainApp(HotelMainApp mainApp) {
        this.mainApp = mainApp;
    }
   
    @FXML
    void handleSearchOrder(ActionEvent event) {
        
    }

    @FXML
    void handlEditHotelInfo(ActionEvent event) {
        
    }
}
