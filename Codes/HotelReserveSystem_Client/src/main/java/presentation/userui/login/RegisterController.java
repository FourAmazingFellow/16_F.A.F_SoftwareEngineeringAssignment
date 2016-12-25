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
import presentation.userui.JudgeFormat;

public class RegisterController {
	private MainApp mainApp;
	@SuppressWarnings("unused")
	private LoginAndSignUpService register;
	private UserUIFactoryService userFactory;
	private JudgeFormat judge = new JudgeFormat();

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
		
		boolean isValid = judge.isLetterDigitOrChinese(userID);
		int userIDLength = judge.getStringLength(userID);
		boolean isPasswordValid = judge.isLetterOrDigit(password);
		int passwordLength = judge.getStringLength(password);
		
		if (userID.equals("") || password.equals("") || password_c.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (isValid != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("用户名包含非法字符（只能是数字、字母或中文）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (0 >= userIDLength || userIDLength > 20) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("用户名长度不合理（1~20）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (isPasswordValid != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("密码包含非法字符（只能是数字或字母）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (5 >= passwordLength || passwordLength > 16) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("密码长度不合理（6~16）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (password.equals(password_c)) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("register info");
			alert.setHeaderText("请继续完善您的信息！");
			alert.showAndWait();
			mainApp.showFillInUserInfoPanel(userID, password);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("两次密码不一致！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}

	}

	public void returnButton() {
		mainApp.showLoginView();
	}
}
