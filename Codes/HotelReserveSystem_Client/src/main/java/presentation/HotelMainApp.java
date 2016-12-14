package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import po.OrderType;
import presentation.mainui.HotelRootBoardController;
import presentation.orderui.BrowseHotelOrderPanelController;
import presentation.orderui.GetDetailedOrderDonePanelController;

public class HotelMainApp extends Application {
	
	public static String hotelAddress = "";
	
	private Stage primaryStage;
	private BorderPane hotelRootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);
		
		showHotelRootPanel();
		showHotelOrderPanel();
	}
	public static void main(String[] args) {
		launch(args);
	}

	public void showHotelRootPanel() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HotelMainApp.class.getResource("mainui/hotelRootBoard.fxml"));
			hotelRootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(hotelRootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			HotelRootBoardController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showHotelOrderPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HotelMainApp.class.getResource("orderui/browseHotelOrderPanel.fxml"));
			AnchorPane allHotelOrderPanel = (AnchorPane) loader.load();

			hotelRootLayout.setCenter(allHotelOrderPanel);
			
			// Give the controller access to the main app.
			BrowseHotelOrderPanelController controller = loader.getController();
			controller.setMainApp(this);
			//默认显示所有订单
			controller.getBriefOrderList(HotelMainApp.hotelAddress, OrderType.ALL);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showHotelDetailedOrderPanel(String orderID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HotelMainApp.class.getResource("orderui/getDetailedOrderDonePanel.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();
		
			hotelRootLayout.setCenter(detailedOrderPanel);
			
			GetDetailedOrderDonePanelController controller = loader.getController();
			
			controller.setMainApp(this);
			controller.showDetailedOrderPanel(orderID);
			
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
