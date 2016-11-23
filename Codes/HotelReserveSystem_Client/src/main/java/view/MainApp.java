package view;

import java.io.IOException;

import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.client.SearchPanelController;
import view.login.LoginController;

public class MainApp extends Application {
	private Stage primaryStage;
	private AnchorPane loginPanel;
	private AnchorPane searchPanel;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);

		showLoginView();
	}

	public void showLoginView() {
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(MainApp.class.getResource("login/Login.fxml"));
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

	public void showClientView() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("client/SearchPanel.fxml"));
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