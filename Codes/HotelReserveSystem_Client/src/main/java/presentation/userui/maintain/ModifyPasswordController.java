package presentation.userui.maintain;

import bl_Stub.userblservice_Stub.ModifyClientInfoServiceImpl_Stub;
import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import po.UserType;
import vo.UserVO;

public class ModifyPasswordController {

	private ModifyClientInfoService modifyClientInfo;
	private UserUIFactoryService userFactory;
	private String userID;
	private String telNum;
	private String prePassword, prePasswordTrue, newPassword, newPasswordConfirm;

	@FXML
	private Label passwordTitleLabel;

	@FXML
	private TextField prePasswordField;

	@FXML
	private TextField newPasswordField;

	@FXML
	private TextField newPasswordConfirmField;

	@FXML
	private Button cancelButton;

	@FXML
	private Button confirmButton;

	public ModifyPasswordController(String userID, String password, String telNum) {
		this.userID = userID;
		this.prePasswordTrue = password;
		this.telNum = telNum;
	}

	@FXML
	void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		// modifyClientInfo = userFactory.createModifyClientInfoService();
		modifyClientInfo = new ModifyClientInfoServiceImpl_Stub("Accident", "qwe123", "12345678900", UserType.Client,
				1000, "阿里巴巴");
	}

	public void modifyPassword() {
		this.prePassword = prePasswordField.getText();
		this.newPassword = newPasswordField.getText();
		this.newPasswordConfirm = newPasswordConfirmField.getText();
		if (prePassword.equals(prePasswordTrue)) {
			if (newPassword.equals(newPasswordConfirm)) {
				UserVO user = new UserVO(userID, newPassword, telNum, UserType.Client);
				modifyClientInfo.modifyClientInfo(user, userID);
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("modify info");
				alert.setHeaderText("修改密码成功！");
				alert.show();
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("wrong");
				alert.setHeaderText("两次新密码输入不一致！");
				alert.setContentText("请重新输入！");
				alert.show();
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("原密码输入错误！");
			alert.setContentText("请重新输入！");
			alert.show();
		}
	}

	@FXML
	void cancelButtonAction(ActionEvent event) {

	}

	@FXML
	void confirmButtonAction(ActionEvent event) {
		modifyPassword();
	}
}
