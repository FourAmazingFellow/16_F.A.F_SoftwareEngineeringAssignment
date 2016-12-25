package presentation.mainui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import presentation.WebsitePromotionMainApp;

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
    private String userId;
    
    public void setMainApp(WebsitePromotionMainApp mainApp) {
    	this.mainApp = mainApp;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
        userActionButton.setText(this.userId);
    }
    
    @FXML
    void addCreditAction(ActionEvent event) {
    	mainApp.showAddCreditPanel();
    }
    
    @FXML
    void handleManageAbnormalOrder(ActionEvent event) {
        mainApp.showAbnormalOrderPanel();
    }

    @FXML
    void handleManageMarketStrategy(ActionEvent event) {
        mainApp.showManageMarketStrategyPanel();
    }

    @FXML
    void handleLogOut(ActionEvent event) {
        //关闭网站营销人员界面
        mainApp.getPrimaryStage().close();
        //打开登录界面
        mainApp.logOut();
    }

    @FXML
    void handleExit(ActionEvent event) {
        System.exit(0);
    }

}
