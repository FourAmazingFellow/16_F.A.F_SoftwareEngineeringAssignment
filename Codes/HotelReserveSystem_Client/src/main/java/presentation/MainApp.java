package presentation;

import java.io.IOException;
import java.rmi.RemoteException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.userui.login.FillInUserInfoController;
import presentation.userui.login.LoginController;
import presentation.userui.login.RegisterController;
import runner.ClientRunner;

public class MainApp extends Application {
	private Stage primaryStage;
	private Application mainApp;
	
	private ClientRunner runner;

	@Override
	public void start(Stage primaryStage) {
		this.runner = new ClientRunner();
		try {
			runner.start();
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
		showLoginView();
//		showClientMainApp("原");
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

	public void showFillInUserInfoPanel(String userID, String password){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("userui/login/FillInUserInfo.fxml"));
			AnchorPane registerPanel = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(registerPanel);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			FillInUserInfoController controller = loader.getController();
			controller.setMainApp(this);
			controller.setUserIDAndPassword(userID, password);
			
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

	public void showHotelMainApp(String userID, String hotelAddress) {
		mainApp = new HotelMainApp();
		try {
			HotelMainApp.hotelAddress = hotelAddress;
			HotelMainApp.userId = userID;
			mainApp.start(primaryStage);
			((HotelMainApp)mainApp).setMainApp(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showWebsitePromotionMainApp(String userID) {
		mainApp = new WebsitePromotionMainApp();
		try {
			WebsitePromotionMainApp.userID = userID;
			mainApp.start(primaryStage);
			((WebsitePromotionMainApp)mainApp).setMainApp(this);
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
