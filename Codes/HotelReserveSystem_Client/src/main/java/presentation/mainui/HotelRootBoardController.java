package presentation.mainui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import presentation.HotelMainApp;
import presentation.MainApp;

public class HotelRootBoardController {

	@FXML
    private MenuItem exitButton;

    @FXML
    private MenuButton userActionButton;

    @FXML
    private MenuItem logoutButton;

    @FXML
    private Button enrollAvalableRoomSection;

    @FXML
    private Button htelInfoSection;
    
    private String userId;
    private HotelMainApp mainApp;
    
    public void setMainApp(HotelMainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void setUserId(String userId){
        this.userId=userId;
        userActionButton.setText(this.userId);
    }

    @FXML
    void handleMaintainHotelInfo(ActionEvent event) {
        mainApp.showMaintainHotelInfoPanel();
    }
    
    @FXML
    void handleBrowseOrder(ActionEvent event) {
        mainApp.showHotelOrderPanel();
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
        mainApp.showEnrollAvaluableRoomPanel();
    }
 
    @FXML
    void handleLogOut(ActionEvent event) {
        //关闭酒店工作人员界面
        mainApp.getPrimaryStage().close();
        //打开登录界面
        mainApp.logOut();
    }
    
    @FXML
    void handleExit(ActionEvent event) {
        System.exit(0);
    }

}
