package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.userui.login.LoginController;
import presentation.userui.login.RegisterController;

public class MainApp extends Application {
	private Stage primaryStage;
	private Application mainApp;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);
		
		showClientMainApp("原");
	}

	// 显示初始界面 --- 登陆界面
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

	// 显示新用户注册界面
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

	public void showClientMainApp(String userID) {
		mainApp = new ClientMainApp();
		try {
			ClientMainApp.userID = userID;
			mainApp.start(primaryStage);
			((ClientMainApp) mainApp).setMainApp(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showHotelMainApp(String hotelAddress, String userID) {
		mainApp = new HotelMainApp();
		try {
			HotelMainApp.hotelAddress = hotelAddress;
			HotelMainApp.userId = userID;
			mainApp.start(primaryStage);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showWebsitePromotionMainApp(String userID) {
		mainApp = new WebsiteManageMainApp();
		try {
			WebsiteManageMainApp.userID = userID;
			mainApp.start(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void showWebsiteManageMainApp(String userID){
		mainApp = new WebsiteManageMainApp();
		try {
			WebsiteManageMainApp.userID = userID;
			mainApp.start(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
