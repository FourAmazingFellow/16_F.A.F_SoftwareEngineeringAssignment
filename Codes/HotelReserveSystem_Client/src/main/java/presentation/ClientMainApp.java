package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import po.OrderType;
import presentation.hotelui.ScreenPanelController;
import presentation.hotelui.SearchPanelController;
import presentation.mainui.ClientRootBoardController;
import presentation.orderui.BrowseUserOrderPanelController;
import presentation.orderui.CreateOrderPanelController;
import presentation.orderui.DetailedOrderPanelController;
import presentation.userui.login.LoginController;
import presentation.userui.login.RegisterController;
import runner.ClientRunner;

public class ClientMainApp extends Application {
	public static String userID = "原";
	
	private Stage primaryStage;
	private BorderPane clientRootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		ClientRunner clientRunner = new ClientRunner();
		clientRunner.start();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);

		showClientRootPanel();
		showCreateOrderPanel(ClientMainApp.userID, "Jingling Hotel", "江苏省南京市栖霞区仙林大道163号");
	}

	//显示客户导航栏
	public void showClientRootPanel() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("mainui/clientRootBoard.fxml"));
			clientRootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(clientRootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			ClientRootBoardController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//显示初始界面 --- 登陆界面
	public void showLoginView() {
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(ClientMainApp.class.getResource("userui/login/Login.fxml"));
			AnchorPane loginPanel = (AnchorPane) loader.load();

			Scene scene = new Scene(loginPanel);
			primaryStage.setScene(scene);

			LoginController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//显示新用户注册界面
	public void showRegisterPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("userui/login/Register.fxml"));
			AnchorPane registerPanel = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(registerPanel);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			RegisterController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//显示生成订单页面
	public void showCreateOrderPanel(String userID, String hotelName, String hotelAddress) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("orderui/createNewOrderPanel.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(searchPanel);
			
			// Give the controller access to the main app.
			CreateOrderPanelController controller = loader.getController();
			
			controller.setMainApp(this);
			controller.initOrder(userID, hotelName, hotelAddress);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//显示用户主界面 --- 搜索界面
	public void showSearchView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/SearchPanel.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(searchPanel);
			
			// Give the controller access to the main app.
			SearchPanelController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//显示搜索结果
	public void showSearchDetailsPanel(String city, String district, String hotelName, String roomType, String roomNum, 
			String beginDate, String finishDate) {
		String[] conditions = {city, district, hotelName, "0", "100000000", "0", "6", "0.0", "6.0", "0",
				roomType, roomNum, beginDate, finishDate};
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("orderui/SearchDetailsPanel.fxml"));
			AnchorPane searchResultPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(searchResultPanel);
			
			S controller = loader.getController();
			controller.setMainApp(this);
			//默认显示所有订单
			controller.getBriefOrderList(userID, OrderType.ALL);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//显示所有订单列表
	public void showUserOrderPanel(String userID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("orderui/browseUserOrderPanel.fxml"));
			AnchorPane allUserOrderPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(allUserOrderPanel);
			
			// Give the controller access to the main app.
			BrowseUserOrderPanelController controller = loader.getController();
			controller.setMainApp(this);
			//默认显示所有订单
			controller.getBriefOrderList(userID, OrderType.ALL);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//显示订单详情页面
	public void showDetailedOrderPanel(String orderID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("orderui/detailedORderPanel.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();
		
			clientRootLayout.setCenter(detailedOrderPanel);
			
			DetailedOrderPanelController controller = loader.getController();
			
			controller.setMainApp(this);
			controller.showDetailedOrderPanel(orderID);
			
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean showHotelScreenPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/ScreenPanel.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("酒店筛选");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ScreenPanelController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isConfirmClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}