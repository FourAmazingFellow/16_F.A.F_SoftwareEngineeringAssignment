package presentation.userui.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.MainApp;

public class LoginController {
	private MainApp mainApp;

	@FXML
	private TextField userIDTextArea;

	@FXML
	private Button registerButton;

	@FXML
	private Button loginButton;

	@FXML
	private TextField passwordTextArea;

	@FXML
	private void initialize() {

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void showRegisterPanel(){
		mainApp.showRegisterPanel();
	}
}
