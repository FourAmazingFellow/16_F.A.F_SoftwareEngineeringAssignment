package presentation.userui.login;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.LoginAndSignUpService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import po.UserType;
import presentation.MainApp;
import presentation.userui.JudgeFormat;
import vo.UserVO;

/**
 * 注册时完善用户信息
 * 
 * @author sparkler
 * @version
 * @see
 */
public class FillInUserInfoController {
	private UserUIFactoryService userFactory;
	private LoginAndSignUpService register;
	private MainApp mainApp;
	private String userID;
	private String password;
	private JudgeFormat judge = new JudgeFormat();

	@FXML
	private Label userIDField;

	@FXML
	private GridPane userInfoPane;

	@FXML
	private Button cancelButton;

	@FXML
	private ChoiceBox<String> userTypeChoiceBox;

	@FXML
	private TextField telNumField;

	@FXML
	private Label passwordField;

	@FXML
	private Button confirmButton;

	@FXML
	private Label userInfoLabel;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		register = userFactory.createLoginAndSignUpService();
		// registerInfo = new LoginAndSignUpServiceImpl_Stub();
		userTypeChoiceBox
				.setItems((ObservableList<String>) FXCollections.observableArrayList("客户", "网站营销人员", "网站管理人员"));
		userTypeChoiceBox.setValue("客户");
		telNumField.setText("");
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	// 设置用户账号和密码
	public void setUserIDAndPassword(String userID, String password) {
		this.userID = userID;
		this.password = password;
		userIDField.setText(userID);
	}

	// 完善用户信息
	public void fillInRegisterInfo() {
		String userTypeStr = userTypeChoiceBox.getValue();
		String telNum = telNumField.getText();
		boolean isNum = judge.isNumeric(telNum);
		int telNumLength = judge.getStringLength(telNum);

		UserType userType = null;
		// 信息填写不完整的警示框
		if (telNum.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		// 联系方式包含非法字符的警示框
		else if (isNum != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("联系方式包含非法字符（只能输入数字）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		// 联系方式长度不正确的提示框
		else if (telNumLength != 11) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("联系方式长度必须为11位！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else {
			if (userTypeStr.equals("客户")) {
				userType = UserType.Client;
				UserVO user = new UserVO(userID, password, telNum, userType);
				try {
					boolean result = register.add(user);
					if (result == false) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("wrong");
						alert.setHeaderText("注册失败！");
						alert.setContentText("请重试！");
						alert.showAndWait();
						return;
					} else {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("register info");
						alert.setHeaderText("注册成功！");
						alert.showAndWait();
						mainApp.showLoginView(userID);
					}
				} catch (RemoteException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("NetWork Warning");
					alert.setHeaderText("Fail to connect with the server!");
					alert.setContentText("Please check your network connection!");
					alert.showAndWait();
				}

			} else if (userTypeStr.equals("网站营销人员")) {
				userType = UserType.WebMarketStaff;
				UserVO user = new UserVO(userID, password, telNum, userType);
				try {
					boolean result = register.add(user);
					if (result == false) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("wrong");
						alert.setHeaderText("注册失败！");
						alert.setContentText("请重试！");
						alert.showAndWait();
						return;
					} else {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("register info");
						alert.setHeaderText("注册成功！");
						alert.showAndWait();
						mainApp.showLoginView(userID);
					}
				} catch (RemoteException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("NetWork Warning");
					alert.setHeaderText("Fail to connect with the server!");
					alert.setContentText("Please check your network connection!");
					alert.showAndWait();
				}
			} else if (userTypeStr.equals("网站管理人员")) {
				userType = UserType.WebManageStaff;
				UserVO user = new UserVO(userID, password, telNum, userType);
				try {
					boolean result = register.add(user);
					if (result == false) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("wrong");
						alert.setHeaderText("注册失败！");
						alert.setContentText("请重试！");
						alert.showAndWait();
						return;
					} else {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("register info");
						alert.setHeaderText("注册成功！");
						alert.showAndWait();
						// MainApp.userID = userID;
						mainApp.showLoginView(userID);
					}
				} catch (RemoteException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("NetWork Warning");
					alert.setHeaderText("Fail to connect with the server!");
					alert.setContentText("Please check your network connection!");
					alert.showAndWait();
				}
			}
		}

	}

	@FXML
	// 取消按钮操作，返回注册界面并提示注册失败
	public void cancelButtonAction(ActionEvent event) {
		mainApp.showRegisterPanel();
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("wrong");
		alert.setHeaderText("注册失败！");
		alert.setContentText("请重试！");
		alert.showAndWait();
	}

	@FXML
	// 确认按钮操作，调用完善用户信息方法
	public void comfirmButtonAction(ActionEvent event) {
		fillInRegisterInfo();
	}

}