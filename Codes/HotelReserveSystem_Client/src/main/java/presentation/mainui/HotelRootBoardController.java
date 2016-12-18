package presentation.mainui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import presentation.HotelMainApp;

public class HotelRootBoardController {

    @FXML
    private MenuButton userActionButton;
    
    private String userId;
    private String address;
    private HotelMainApp mainApp;
    
    
    public void setMainApp(HotelMainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void setUserId(String userId){
        this.userId=userId;
        userActionButton.setText(userId);
    }
    
    public void setAddress(String address){
        this.address=address;
    }

    @FXML
    void handleMaintainHotelInfo(ActionEvent event) {
        
    }
    
    @FXML
    void handleBrowseOrder(ActionEvent event) {
        
    }

    @FXML
    void handleBrowseSpareRoom(ActionEvent event) {
        mainApp.showSpareRoomTablePanel();
    }

    @FXML
    void handleCheckIn(ActionEvent event) {
        mainApp.showManageCheckInPanel();
    }


    @FXML
    void handleCheckOut(ActionEvent event) {
        mainApp.showManageCheckOutPanel();
    }

    @FXML
    void handleManagePromotion(ActionEvent event) {
        mainApp.showManagePromotionPanel();
    }

    @FXML
    void handleEnrollValuableRoom(ActionEvent event) {
        
    }

    @FXML
    void handleLookPersonalInfo(ActionEvent event) {
        
    }
    
    @FXML
    void handleLogOut(ActionEvent event) {
        
    }
    
    @FXML
    void handleExit(ActionEvent event) {
        
    }

}
