package presentation.userui.maintain;

import java.rmi.RemoteException;
import java.sql.Date;

import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import po.UserType;
import presentation.ClientMainApp;
import presentation.userui.JudgeFormat;
import vo.ClientInfoVO;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;
import vo.UserVO;

public class EditController {
	private ClientMainApp mainApp;
	private ModifyClientInfoService modifyClientInfo;
	private UserUIFactoryService userFactory;
	private String userID, newUserID;
	private ClientInfoVO client;
	private RegularVipVO regularVip;
	private EnterpriseVipVO enterpriseVip;
	private String password;
	private String telNum, newTelNum;
	private int creditValue;
	private Date birth;
	private String enterpriseName;
	private JudgeFormat judge = new JudgeFormat();


	@FXML
	private Label InfoLabel;

	@FXML
	private TextField userIDField;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField telNumField;

	@FXML
	private GridPane InfoTable;

	@FXML
	private Button modifyPasswordButton;

	@FXML
	private Button saveButton;

	@FXML
	private Label birthOrEnterpriseLabel;

	@FXML
	private Label creditValueLabel;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		modifyClientInfo = userFactory.createModifyClientInfoService();
		// modifyClientInfo = new ModifyClientInfoServiceImpl_Stub("Accident",
		// "qwe123", "12345678900", UserType.Client,
		// 1000, "阿里巴巴");
	}

	public void setMainApp(ClientMainApp clientMainApp) {
		this.mainApp = clientMainApp;
	}

	// 显示未修改前的客户信息
	public void showPreClientInfo(String userID) {
		try {
			this.client = modifyClientInfo.getClientInfo(userID);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		this.userID = client.userID;
		this.password = client.password;
		this.telNum = client.telNum;
		this.creditValue = client.creditValue;

		if (client instanceof EnterpriseVipVO) {
			this.enterpriseVip = (EnterpriseVipVO) client;
			this.enterpriseName = enterpriseVip.enterpriseID;
		} else if (client instanceof RegularVipVO) {
			this.regularVip = (RegularVipVO) client;
			this.birth = regularVip.birth;
		}
		userIDField.setText(userID);
		telNumField.setText(telNum);
		creditValueLabel.setText(String.valueOf(creditValue));
		// 判断是否非空
		if (birth != null)
			birthOrEnterpriseLabel.setText(String.valueOf(birth));
		else if (enterpriseName != null)
			birthOrEnterpriseLabel.setText(enterpriseName);
	}

	// 编辑客户信息
	public void editClientInfo() {
		newUserID = userIDField.getText();
		ClientMainApp.userID = newUserID;
		newTelNum = telNumField.getText();
		boolean isValid = judge.isLetterDigitOrChinese(newUserID);
		int newUserIDLength = judge.getStringLength(newUserID);
		boolean isNum = judge.isNumeric(newTelNum);
		int newTelNumLength = judge.getStringLength(newTelNum);
		if (newUserID.equals("") || newTelNum.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (isValid != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("用户名包含非法字符（必须是数字、字母或中文）！");
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
		} else if(isNum != true){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("联系方式包含非法字符（只能输入数字）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}else if(newTelNumLength != 11){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("联系方式长度必须为11位！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}else {
			UserVO user = new UserVO(newUserID, password, newTelNum, UserType.Client);
			boolean result = false;
			try {
				result = modifyClientInfo.modifyClientInfo(user, userID);
			} catch (RemoteException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("NetWork Warning");
				alert.setHeaderText("Fail to connect with the server!");
				alert.setContentText("Please check your network connection!");
				alert.showAndWait();
			}
			if (result == true) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("modify info");
				alert.setHeaderText("修改成功！");
				alert.showAndWait();
				mainApp.showModifyClientInfoPanel();
			} else {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("wrong");
				alert.setHeaderText("修改失败！");
				alert.setContentText("请重试！");
				alert.showAndWait();
				return;
			}
		}
	}

	@FXML
	// 返回按钮对应操作，返回客户信息界面
	void cancelButtonAction(ActionEvent event) {
		mainApp.showModifyClientInfoPanel();
	}

	@FXML
	// 修改密码按钮对应操作，跳转修改密码界面
	void modifyPasswordButtonAction(ActionEvent event) {
		mainApp.showModifyPasswordPanel(userID, telNum, password);
	}

	@FXML
	// 保存编辑按钮操作，保存修改
	void saveButtonAction(ActionEvent event) {
		editClientInfo();

	}

}