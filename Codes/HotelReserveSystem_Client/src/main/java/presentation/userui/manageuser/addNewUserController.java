package presentation.userui.manageuser;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ManageUserInfoService;
import factory.UserUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import po.UserType;
import presentation.WebsiteManageMainApp;
import presentation.userui.JudgeFormat;
import vo.UserVO;

public class addNewUserController {
	private WebsiteManageMainApp mainApp;
	private UserUIFactoryServiceImpl userFactory;
	private ManageUserInfoService manageUser;
	private String userID;
	private String password, passwordConfirm;
	private String telNum;
	private JudgeFormat judge = new JudgeFormat();

	@FXML
	private PasswordField webMarketPasswordField;

	@FXML
	private PasswordField webMarketPasswordConfirmField;

	@FXML
	private Button cancelButton;

	@FXML
	private GridPane webMarketStaffInfo1;

	@FXML
	private TextField webMarketUserIDField;

	@FXML
	private TextField webMarketTelNumField;

	@FXML
	private Button confirmButton;

	@FXML
	private Label manageUserLabel;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		manageUser = userFactory.createManageUserInfoService();
		// manageUser = new ManageUserInfoServiceImpl_Stub("staff0001",
		// "qwe123", "12345678909", UserType.WebMarketStaff, "");
		// modifyClientInfo = new ModifyClientInfoServiceImpl_Stub("原",
		// "qwe123", "12345678900", UserType.Client, 1500, "阿里巴巴");

		webMarketUserIDField.setText("");
		webMarketPasswordField.setText("");
		webMarketTelNumField.setText("");
	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
	}

	// 添加新用户
	public void addNewUser() {
		this.userID = webMarketUserIDField.getText();
		this.password = webMarketPasswordField.getText();
		this.passwordConfirm = webMarketPasswordConfirmField.getText();
		this.telNum = webMarketTelNumField.getText();

		boolean isValid = judge.isLetterDigitOrChinese(userID);
		int newUserIDLength = judge.getStringLength(userID);
		boolean isNum = judge.isNumeric(telNum);
		int newTelNumLength = judge.getStringLength(telNum);
		boolean isPasswordValid = judge.isLetterOrDigit(password);
		int passwordLength = judge.getStringLength(password);

		// this.userID = "test";
		// this.password = "test";
		// this.passwordConfirm = "test";
		// this.telNum = "12345678944";
		if (userID.equals("") || password.equals("") || telNum.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (!password.equals(passwordConfirm)) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("两次密码输入不一致！");
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
		} else if (0 >= newUserIDLength || newUserIDLength > 20) {
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
		}else if (isNum != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("联系方式包含非法字符（只能输入数字）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (newTelNumLength != 11) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("联系方式长度必须为11位！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		UserVO user = new UserVO(userID, password, telNum, UserType.WebMarketStaff);
		boolean result = false;
		try {
			result = manageUser.add(user);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (result == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("add info");
			alert.setHeaderText("添加成功！");
			alert.showAndWait();
			mainApp.showManageUserPanel();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("添加失败！");
			alert.setContentText("请重试！");
			alert.showAndWait();
			return;
		}
	}

	@FXML
	// 取消按钮操作，返回管理用户界面
	void cancelButtonAction(ActionEvent event) {
		mainApp.showManageUserPanel();
	}

	@FXML
	// 确认添加按钮操作，保存添加
	void confirmButtonAction(ActionEvent event) throws RemoteException {
		addNewUser();
	}

}
