package presentation;

import java.io.IOException;
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import po.OrderType;
import presentation.orderui.BrowseAbnormalOrderPanelController;
import presentation.orderui.BrowseHotelOrderPanelController;
import presentation.orderui.GetDetailedOrderDonePanelController;
import presentation.orderui.SystemWithdrawDetailedOrderPanelController;

public class WebsitePromotionMainApp extends Application {
	private Stage primaryStage;
	private BorderPane websitePromotionRootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void showWebsitePromotionRootPanel() {
		
	}
	
	public void showAbnormalOrderPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HotelMainApp.class.getResource("orderui/browseAbnormalOrderPanel.fxml"));
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
			loader.setLocation(HotelMainApp.class.getResource("orderui/systemWithdrawDetailedOrderPanel.fxml"));
			AnchorPane detailedAbnormalOrderPanel = (AnchorPane) loader.load();
		
			websitePromotionRootLayout.setCenter(detailedAbnormalOrderPanel);
			
			SystemWithdrawDetailedOrderPanelController controller = loader.getController();
			
			controller.setMainApp(this);
			
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
