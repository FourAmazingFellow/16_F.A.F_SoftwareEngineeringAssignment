package presentation;

import java.io.IOException;
import java.rmi.RemoteException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.hotelui.managehotel.ManageHotelController;
import presentation.mainui.WebsiteManageRootBoardController;
import presentation.userui.manageuser.EditUserInfoController;
import presentation.userui.manageuser.ManageUserController;
import presentation.userui.manageuser.addNewUserController;
import runner.ClientRunner;
import vo.ClientInfoVO;
import vo.UserVO;

public class WebsiteManageMainApp extends Application {
	public static String userID = "";
	
	private Stage primaryStage;
	private BorderPane websiteManageRootLayout;
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

		showWebManageRootPanel();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	 public Stage getPrimaryStage() {
	        return primaryStage;
	    }

	// 显示网站管理人员导航栏
	public void showWebManageRootPanel() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsiteManageMainApp.class.getResource("mainui/websiteManageRootBoard.fxml"));
			websiteManageRootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(websiteManageRootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			WebsiteManageRootBoardController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showManageUserPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsiteManageMainApp.class.getResource("userui/manageuser/ManageUser.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			websiteManageRootLayout.setCenter(searchPanel);

			// Give the controller access to the main app.
			ManageUserController controller = loader.getController();

			controller.setMainApp(this);
//			controller.showUserInfo();
			
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showManageHotelPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsiteManageMainApp.class.getResource("hotelui/managehotel/ManageHotel.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			websiteManageRootLayout.setCenter(searchPanel);

			// Give the controller access to the main app.
			ManageHotelController controller = loader.getController();

			controller.setMainApp(this);
			
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showEditUserInfoPanel(ClientInfoVO client, UserVO webUser){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsiteManageMainApp.class.getResource("userui/manageuser/EditUserInfo.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			websiteManageRootLayout.setCenter(searchPanel);

			// Give the controller access to the main app.
			EditUserInfoController controller = loader.getController();

			controller.setMainApp(this);
			controller.showPreUserInfo(client, webUser);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAddUserPanel(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsiteManageMainApp.class.getResource("userui/manageuser/AddNewUser.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			websiteManageRootLayout.setCenter(searchPanel);

			// Give the controller access to the main app.
			addNewUserController controller = loader.getController();

			controller.setMainApp(this);
			
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
