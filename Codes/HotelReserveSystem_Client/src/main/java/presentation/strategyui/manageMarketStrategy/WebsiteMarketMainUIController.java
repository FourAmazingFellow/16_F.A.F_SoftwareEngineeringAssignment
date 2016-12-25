package presentation.strategyui.manageMarketStrategy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import presentation.WebsitePromotionMainApp;

/**
 * 网站营销人员主界面的控制类
 * @author 双
 * @version 
 * @see
 */
public class WebsiteMarketMainUIController {
    
    private WebsitePromotionMainApp mainApp;
    
    public void setMainApp(WebsitePromotionMainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    void handleManageAddCreditRecord(ActionEvent event) {
        mainApp.showAddCreditPanel();
    }

    @FXML
    void handleManageAbnormalOrders(ActionEvent event) {
        mainApp.showAbnormalOrderPanel();
    }

    @FXML
    void handleManageMarketStrategy(ActionEvent event) {
        mainApp.showManageMarketStrategyPanel();
    }

}
