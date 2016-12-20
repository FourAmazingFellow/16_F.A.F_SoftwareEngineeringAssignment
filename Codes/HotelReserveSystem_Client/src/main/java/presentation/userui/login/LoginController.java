package presentation.userui.login;

import java.rmi.RemoteException;

import businesslogic.userbl.loginAndSignUp.CheckLoginInfo;
import businesslogicservice.userblservice.LoginAndSignUpService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import po.UserType;
import presentation.MainApp;

public class LoginController {
	private MainApp mainApp;
	private LoginAndSignUpService login;
	private CheckLoginInfo check;
	private UserUIFactoryService userFactory;
	@FXML
	private TextField userIDTextArea;

	@FXML
	private Button registerButton;

	@FXML
	private Button loginButton;

	@FXML
	private PasswordField passwordTextArea;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		check = new CheckLoginInfo();
		login = userFactory.createLoginAndSignUpService();
		// login = new LoginAndSignUpServiceImpl_Stub();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void verifyLogin() {
		String userID = userIDTextArea.getText();
		String password = passwordTextArea.getText();
		UserType userType = null;
		try {
			userType = check.checkUser(userID, password);
		} catch (RemoteException e1) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		boolean result = false;
		try {
			result = login.login(userID, password);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}

		if (result == false) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("用户名或密码错误！");
			alert.setContentText("请重新输入！");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("login info");
			alert.setHeaderText("登录成功！");
			alert.show();

			if (userType == UserType.Client)
				mainApp.showClientMainApp();
			else if (userType == UserType.HotelStaff)
				mainApp.showHotelMainApp();
			else if (userType == UserType.WebMarketStaff)
				mainApp.showWebsitePromotionMainApp();
			else if (userType == UserType.WebManageStaff)
				mainApp.showWebsiteManageMainApp();

		}
	}

	public void loginButtonAction() throws RemoteException {
		verifyLogin();
	}

	public void showRegisterPanel() {
	}

}
