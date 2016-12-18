package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.mainui.WebsiteManageRootBoardController;

public class WebsiteManageMainApp extends Application{
	private Stage primaryStage;
	private BorderPane websiteManageRootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	//显示网站管理人员导航栏
	public void showWebManageRootPanel() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("mainui/websiteManageRootLayout.fxml"));
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
			loader.setLocation(ClientMainApp.class.getResource("userui/manageuser/ManageUser.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			websiteManageRootLayout.setCenter(searchPanel);
			
			// Give the controller access to the main app.
			WebsiteManageRootBoardController controller = loader.getController();
			
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showManageHotelPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("userui/managehotel/ManageHotel.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			websiteManageRootLayout.setCenter(searchPanel);
			
			// Give the controller access to the main app.
			WebsiteManageRootBoardController controller = loader.getController();
			
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
