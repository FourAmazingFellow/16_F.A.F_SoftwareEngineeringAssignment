package presentation.userui.login;

import bl_Stub.userblservice_Stub.LoginAndSignUpServiceImpl_Stub;
import businesslogicservice.userblservice.LoginAndSignUpService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.ClientMainApp;
import presentation.MainApp;
import vo.UserVO;

public class RegisterController {
	private MainApp mainApp;
	private LoginAndSignUpService register;
	private UserUIFactoryService userFactory;

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

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		// register = userFactory.createLoginAndSignUpService();
		register = new LoginAndSignUpServiceImpl_Stub();
	}

	public void register() {
		String userID = r_userIDArea.getText();
		String password = r_passwordArea.getText();
		String password_c = r_passwordCofirmArea.getText();
		UserVO user = new UserVO(userID, password, null, null);
		boolean result = register.add(user);
		if (password.equals(password_c)) {
			if (result == true) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("register info");
				alert.setHeaderText("注册成功！");
				alert.show();
				
				new FillInUserInfoController(userID, password);
				
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("wrong");
				alert.setHeaderText("用户名已被占用！");
				alert.setContentText("请重新输入！");
				alert.show();
			}

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("两次密码不一致！");
			alert.setContentText("请重新输入！");
			alert.show();
		}

	}

	public void returnButton() {
		mainApp.showLoginView();
	}
	
	public void registerButtonAction(){
		
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
