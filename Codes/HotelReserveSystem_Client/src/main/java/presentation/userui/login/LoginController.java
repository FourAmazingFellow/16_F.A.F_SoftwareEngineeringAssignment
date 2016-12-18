package presentation.userui.login;

import java.rmi.RemoteException;

import bl_Stub.userblservice_Stub.LoginAndSignUpServiceImpl_Stub;
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
import presentation.ClientMainApp;
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
	private void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		check = new CheckLoginInfo();
		 login = userFactory.createLoginAndSignUpService();
//		login = new LoginAndSignUpServiceImpl_Stub();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void verifyLogin() throws RemoteException {
		String userID = userIDTextArea.getText();
		String password = passwordTextArea.getText();
		UserType userType = check.checkUser(userID, password);
		boolean result = login.login(userID, password);

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
			
			if(userType == UserType.Client)
				mainApp.showClientMainApp();
			else if(userType == UserType.HotelStaff)
				mainApp.showHotelMainApp();
			else if(userType == UserType.WebMarketStaff)
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
