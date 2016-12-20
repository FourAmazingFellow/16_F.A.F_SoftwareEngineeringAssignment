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
import javafx.stage.Stage;
import po.OrderType;
import presentation.mainui.WebsitePromotionRootBoardController;
import presentation.orderui.BrowseAbnormalOrderPanelController;
import presentation.orderui.BrowseHotelOrderPanelController;
import presentation.orderui.GetDetailedOrderDonePanelController;
import presentation.orderui.SystemWithdrawDetailedOrderPanelController;
import presentation.userui.addcredit.AddCreditValueController;
import runner.ClientRunner;

public class WebsitePromotionMainApp extends Application {
	public static String userID = "";
	
	private Stage primaryStage;
	private BorderPane websitePromotionRootLayout;
	private ClientRunner clientRunner;
	
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
		
		showWebsitePromotionRootPanel();
		showAbnormalOrderPanel();
	}

	public static void main(String[] args) {
		launch(args);
	}

	//显示网站营销人员的导航栏
	public void showWebsitePromotionRootPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsitePromotionMainApp.class.getResource("mainui/websitePromotionRootBoard.fxml"));
			websitePromotionRootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(websitePromotionRootLayout);
			primaryStage.setScene(scene);
			
			WebsitePromotionRootBoardController controller = loader.getController();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	//显示网站营销人员的主界面
	public void showWebsitePromotionMainPanel() {
		
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
			
			primaryStage.show();
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}		
	}
}
