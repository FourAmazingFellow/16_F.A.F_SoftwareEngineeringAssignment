package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import po.OrderType;
import presentation.hotelui.SearchPanelController;
import presentation.orderui.BrowseUserOrderPanelController;
import presentation.userui.login.LoginController;
import presentation.userui.login.RegisterController;

public class MainApp extends Application {
	private Stage primaryStage;
	private AnchorPane loginPanel;
	private AnchorPane registerPanel;
	private AnchorPane searchPanel;
	

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);

		showLoginView();
	}

	//显示初始界面 --- 登陆界面
	public void showLoginView() {
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(MainApp.class.getResource("userui/login/Login.fxml"));
			loginPanel = (AnchorPane) loader.load();

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
			loader.setLocation(MainApp.class.getResource("userui/login/Register.fxml"));
			registerPanel = (AnchorPane) loader.load();

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
	
	
	//显示用户主界面 --- 搜索界面
	public void showSearchView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("hotelui/SearchPanel.fxml"));
			searchPanel = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(searchPanel);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			SearchPanelController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showUserOrderPanel(String userID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("orderui/browseUserOrderPanel.fxml"));
			AnchorPane allUserOrderPanel = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(allUserOrderPanel);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			BrowseUserOrderPanelController controller = loader.getController();
			controller.setMainApp(this);
			//默认显示所有订单
			controller.showBriefOrderList(userID, OrderType.ALL);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showDetailedOrderPanel(String orderID) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("orderui/detailedORderPanel.fxml"));
		try {
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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