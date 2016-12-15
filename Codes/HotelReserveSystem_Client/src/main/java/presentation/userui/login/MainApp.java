package presentation.userui.login;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private GridPane login;
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);
		
		showLoginPanel();
		
	}

	public void showLoginPanel(){
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("Login.fxml"));
			login = (GridPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(login);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			LoginController controller = loader.getController();
			controller.setMainApp2(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showRegisterPanel() {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
