package presentation;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.mainui.WebsitePromotionRootBoardController;
import presentation.orderui.BrowseAbnormalOrderPanelController;
import presentation.orderui.SystemWithdrawDetailedOrderPanelController;
import presentation.strategyui.manageMarketStrategy.MarketStrategyEditPanelController;
import presentation.strategyui.manageMarketStrategy.MarketStrategyPanelController;
import presentation.strategyui.manageMarketStrategy.WebsiteMarketMainUIController;
import presentation.strategyui.model.Strategy;
import presentation.userui.addcredit.AddCreditValueController;
import runner.ClientRunner;

public class WebsitePromotionMainApp extends Application {
	public static String userID = "";
	
	private Stage primaryStage;
	private BorderPane websitePromotionRootLayout;
	private ClientRunner clientRunner;
	private static String websiteAddress="Web";
	private MainApp mainApp;
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
	
	public void logOut(){
	    WebsitePromotionMainApp.userID="";
	    mainApp.showLoginView();
	}
	
	@Override
	public void start(Stage primaryStage) {
		clientRunner = new ClientRunner();
		try {
			clientRunner.start();
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);
		
		initWebsitePromotionRootPanel();
		showWebsitePromotionMainPanel();
	}

	public static void main(String[] args) {
	    launch(args);
	}
	
	 public Stage getPrimaryStage() {
         return primaryStage;
     }

	 public void setUserId(String userId){
	     WebsitePromotionMainApp.userID=userId;
	 }

	/**
     * 显示网站营销人员导航栏
     * 
     * @see
     */
    public void initWebsitePromotionRootPanel() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(WebsitePromotionMainApp.class.getResource("mainui/websitePromotionRootBoard.fxml"));
            websitePromotionRootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(websitePromotionRootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            WebsitePromotionRootBoardController controller = loader.getController();
            controller.setMainApp(this);
            controller.setUserId(WebsitePromotionMainApp.userID);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //显示网站营销人员的主界面
    public void showWebsitePromotionMainPanel() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HotelMainApp.class.getResource("strategyui/manageMarketStrategy/WebsiteMarketMainUI.fxml"));
            AnchorPane websitePromotionMainUI = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            websitePromotionRootLayout.setCenter(websitePromotionMainUI);

            // Give the controller access to the main app.
            WebsiteMarketMainUIController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showAbnormalOrderPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsitePromotionMainApp.class.getResource("orderui/browseAbnormalOrderPanel.fxml"));
			AnchorPane allAbnormalOrderPanel = (AnchorPane) loader.load();

			websitePromotionRootLayout.setCenter(allAbnormalOrderPanel);
			
			BrowseAbnormalOrderPanelController controller = loader.getController();
			controller.setMainApp(this);
			
			//默认显示当天所有异常订单
			controller.getBriefAbnormalOrderList(new Date());

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showDetailedAbnormalOrderPanel(String orderID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsitePromotionMainApp.class.getResource("orderui/systemWithdrawDetailedOrderPanel.fxml"));
			AnchorPane detailedAbnormalOrderPanel = (AnchorPane) loader.load();
		
			websitePromotionRootLayout.setCenter(detailedAbnormalOrderPanel);
			
			SystemWithdrawDetailedOrderPanelController controller = loader.getController();
			
			controller.setMainApp(this);
			controller.showDetailedOrderPanel(orderID);
			
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
	//显示信用充值界面
	public void showAddCreditPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsitePromotionMainApp.class.getResource("userui/addcredit/AddCreditValue.fxml"));
			AnchorPane detailedAbnormalOrderPanel = (AnchorPane) loader.load();
		
			websitePromotionRootLayout.setCenter(detailedAbnormalOrderPanel);
			
			AddCreditValueController controller = loader.getController();
			
			controller.setMainApp(this);
//			controller.searchButtonAction();
//			controller.addCreditValue();
			
			primaryStage.show();
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}		
	}
	

    /**
     * 管理营销策略界面
     * @param address
     * @see
     */
    public void showManageMarketStrategyPanel(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HotelMainApp.class.getResource("strategyui/manageMarketStrategy/MarketStrategyPanel.fxml"));
            AnchorPane manageMarketStrategyPanel = (AnchorPane) loader.load();

            websitePromotionRootLayout.setCenter(manageMarketStrategyPanel);
            
            // Give the controller access to the main app.
            MarketStrategyPanelController controller = loader.getController();
            controller.setMainApp(this);
            //默认显示所有订单
            controller.showAllMarketStrategyList(websiteAddress);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 营销策略编辑界面
     * @param strategy
     * @param address
     * @param isNewaPromotion
     * @return
     * @see
     */
    public boolean showMarketStrategyEditDialog(Strategy strategy, boolean isNewaPromotion) {
           try {
               // Load the fxml file and create a new stage for the popup dialog.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(HotelMainApp.class.getResource("strategyui/manageMarketStrategy/MarketStrategyEditPanel.fxml"));
               AnchorPane page = (AnchorPane) loader.load();

               // Create the dialog Stage.
               Stage dialogStage = new Stage();
               dialogStage.setTitle("Edit MarketStrategy");
               dialogStage.initModality(Modality.WINDOW_MODAL);
               dialogStage.initOwner(primaryStage);
               Scene scene = new Scene(page);
               dialogStage.setScene(scene);

               // Set the person into the controller.
               MarketStrategyEditPanelController controller = loader.getController();
               controller.setDialogStage(dialogStage);
               controller.setStrategy(strategy, websiteAddress, isNewaPromotion);

               // Show the dialog and wait until the user closes it
               dialogStage.showAndWait();

               return controller.isConfirmed();
           } catch (IOException e) {
               e.printStackTrace();
               return false;
           }
       }
    
}
