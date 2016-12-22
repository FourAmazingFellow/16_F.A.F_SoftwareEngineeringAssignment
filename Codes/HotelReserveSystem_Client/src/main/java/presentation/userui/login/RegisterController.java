package presentation.userui.login;

import businesslogicservice.userblservice.LoginAndSignUpService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.MainApp;

public class RegisterController {
	private MainApp mainApp;
	private LoginAndSignUpService register;
	private UserUIFactoryService userFactory;

	@FXML
	private PasswordField r_passwordCofirmArea;

	@FXML
	private PasswordField r_passwordArea;

	@FXML
	private TextField r_userIDArea;

	@FXML
	private Button registerButton;

	@FXML
	private Button returnButton;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		register = userFactory.createLoginAndSignUpService();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void register() {
		String userID = r_userIDArea.getText();
		String password = r_passwordArea.getText();
		String password_c = r_passwordCofirmArea.getText();
		if (userID.equals("") || password.equals("") || password_c.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.show();
			return;
		} else if (password.equals(password_c)) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("register info");
			alert.setHeaderText("请继续完善您的信息！");
			alert.show();
			mainApp.showFillInUserInfoPanel(userID, password);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("两次密码不一致！");
			alert.setContentText("请重新输入！");
			alert.show();
			return;
		}

	}

	public void returnButton() {
		mainApp.showLoginView();
	}
}
