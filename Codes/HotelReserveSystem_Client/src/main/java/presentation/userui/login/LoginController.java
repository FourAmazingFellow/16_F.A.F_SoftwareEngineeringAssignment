package presentation.userui.login;

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

public class LoginController {
	private ClientMainApp mainApp;
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
//		login = userFactory.createLoginAndSignUpService();
		login = new LoginAndSignUpServiceImpl_Stub();
	}

	public void setMainApp(ClientMainApp clientMainApp) {
		this.mainApp = clientMainApp;
	}
	
	
	public void verifyLogin(){
		String userID = userIDTextArea.getText();
		String password = passwordTextArea.getText();
		UserType userType = check.checkUser(userID, password);
		boolean result = login.login(userID, password);
		
		if(result == false){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("用户名或密码错误！");
			alert.setContentText("请重新输入！");
			alert.show();
		}
		else if(result == true){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("login info");
			alert.setHeaderText("登录成功！");
			alert.show();
		}
	}
	
	public void loginButtonAction(){
		verifyLogin();
	}
	
	
	public void showRegisterPanel(){
		mainApp.showRegisterPanel();
	}

}
