package presentation.userui.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.MainApp;

public class RegisterController {
	private MainApp mainApp;

	@FXML
	private TextField r_passwordCofirmArea;

	@FXML
	private TextField r_passwordArea;

	@FXML
	private TextField r_userIDArea;

	@FXML
	private Button registerButton;

	@FXML
	private Button returnButton;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void returnButton(){
    	mainApp.showLoginView();
    }
}
