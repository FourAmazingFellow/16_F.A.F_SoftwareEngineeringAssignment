package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.hotelui.managehotel.ManageHotelController;
import presentation.mainui.WebsiteManageRootBoardController;
import presentation.userui.manageuser.EditUserInfoController;
import presentation.userui.manageuser.ManageUserController;
import presentation.userui.manageuser.addNewUserController;
import vo.ClientInfoVO;
import vo.UserVO;

public class WebsiteManageMainApp extends Application {
	public static String userID = "";
	
	private MainApp mainApp;
	private Stage primaryStage;
	private BorderPane websiteManageRootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);

		showWebManageRootPanel();
		showManageUserPanel();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void logout() {
		userID = "";
		mainApp.showLoginView("");
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

	//显示管理用户界面
	public void showManageUserPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsiteManageMainApp.class.getResource("userui/manageuser/ManageUser.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			websiteManageRootLayout.setCenter(searchPanel);

			// Give the controller access to the main app.
			ManageUserController controller = loader.getController();

			controller.setMainApp(this);
			controller.setPreInfo();
//			controller.searchButtonAction(null);
//			 controller.showUserInfo();
//			controller.editButtonAction(null);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 显示管理酒店界面
	public void showManageHotelPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsiteManageMainApp.class.getResource("hotelui/managehotel/ManageHotel.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			websiteManageRootLayout.setCenter(searchPanel);

			// Give the controller access to the main app.
			ManageHotelController controller = loader.getController();

			controller.setMainApp(this);
			controller.setPreInfo();
//			controller.confirmButtonAction(null);
			
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 显示编辑用户信息界面
	public void showEditUserInfoPanel(ClientInfoVO client, UserVO webUser) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsiteManageMainApp.class.getResource("userui/manageuser/EditUserInfo.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			websiteManageRootLayout.setCenter(searchPanel);

			// Give the controller access to the main app.
			EditUserInfoController controller = loader.getController();

			controller.setMainApp(this);
			controller.showPreUserInfo(client, webUser);
//			controller.editClientInfo();

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 显示添加新用户界面
	public void showAddUserPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WebsiteManageMainApp.class.getResource("userui/manageuser/AddNewUser.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			websiteManageRootLayout.setCenter(searchPanel);

			// Give the controller access to the main app.
			addNewUserController controller = loader.getController();

			controller.setMainApp(this);
//			controller.addNewUser();
			
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
