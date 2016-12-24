package presentation.userui.maintain;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import po.UserType;
import presentation.ClientMainApp;
import presentation.userui.JudgeFormat;
import vo.UserVO;

public class ModifyPasswordController {

	private ModifyClientInfoService modifyClientInfo;
	private UserUIFactoryService userFactory;
	private ClientMainApp mainApp;
	private String userID;
	private String telNum;
	private String prePassword, prePasswordTrue, newPassword, newPasswordConfirm;
	private JudgeFormat judge = new JudgeFormat();

	@FXML
	private Label userIDLabel;

	@FXML
	private Label passwordTitleLabel;

	@FXML
	private PasswordField prePasswordField;

	@FXML
	private PasswordField newPasswordField;

	@FXML
	private PasswordField newPasswordConfirmField;

	@FXML
	private Button cancelButton;

	@FXML
	private Button confirmButton;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		modifyClientInfo = userFactory.createModifyClientInfoService();
		// modifyClientInfo = new ModifyClientInfoServiceImpl_Stub("Accident",
		// "qwe123", "12345678900", UserType.Client,
		// 1000, "阿里巴巴");
	}
	
	public void setMainApp(ClientMainApp mainApp){
		this.mainApp = mainApp;
	}

	//显示客户账号信息，并保存密码和联系方式
	public void showUserID(String userID,String telNum, String prePasswordTrue) {
		this.userID = userID;
		this.telNum = telNum;
		userIDLabel.setText(userID);
		this.prePasswordTrue = prePasswordTrue;
	}

	//修改密码
	public void modifyPassword() {
		this.prePassword = prePasswordField.getText();
		this.newPassword = newPasswordField.getText();
		this.newPasswordConfirm = newPasswordConfirmField.getText();
		boolean isPrePasswordValid = judge.isLetterOrDigit(prePassword);
		int prePasswordLength = judge.getStringLength(prePassword);
		
		boolean isNewPasswordValid = judge.isLetterOrDigit(newPassword);
		int newPasswordLength = judge.getStringLength(newPassword);
		if (isPrePasswordValid != true || isNewPasswordValid != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("密码包含非法字符（只能是数字或字母）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (5 >= prePasswordLength ||newPasswordLength<=5|| prePasswordLength > 16||newPasswordLength>16) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("密码长度不合理（6~16）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		if (prePassword.equals(prePasswordTrue)) {
			if (newPassword.equals(newPasswordConfirm)) {
				UserVO user = new UserVO(userID, newPassword, telNum, UserType.Client);
				try {
					modifyClientInfo.modifyClientInfo(user, userID);
				} catch (RemoteException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("NetWork Warning");
					alert.setHeaderText("Fail to connect with the server!");
					alert.setContentText("Please check your network connection!");
					alert.showAndWait();
				}
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("modify info");
				alert.setHeaderText("修改密码成功！");
				alert.showAndWait();
				mainApp.showModifyClientInfoPanel();
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("wrong");
				alert.setHeaderText("两次新密码输入不一致！");
				alert.setContentText("请重新输入！");
				alert.showAndWait();
				return;
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("原密码输入错误！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
	}

	@FXML
	//取消按钮操作，返回编辑信息界面
	public void cancelButtonAction(ActionEvent event) {
		mainApp.showEditClientInfoPanel(userID);
	}

	@FXML
	//确认修改按钮操作，保存修改
	public void confirmButtonAction(ActionEvent event){
		modifyPassword();
	}

}
