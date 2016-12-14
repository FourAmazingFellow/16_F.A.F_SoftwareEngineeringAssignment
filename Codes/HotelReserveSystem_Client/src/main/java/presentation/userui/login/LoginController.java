package presentation.userui.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.ClientMainApp;

public class LoginController {
	private ClientMainApp mainApp;

	@FXML
	private TextField userIDTextArea;

	@FXML
	private Button registerButton;

	@FXML
	private Button loginButton;

	@FXML
	private PasswordField passwordTextArea;

	@FXML
	private void initialize() {

	}

	public void setMainApp(ClientMainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void showRegisterPanel(){
		mainApp.showRegisterPanel();
	}
}
