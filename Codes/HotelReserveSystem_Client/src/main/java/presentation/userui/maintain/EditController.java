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
		} else if (client instanceof RegularVipVO) {
			this.regularVip = (RegularVipVO) client;
		}
		this.birth = regularVip.birth;
		if (birth == null) {
			this.enterpriseName = enterpriseVip.enterpriseID;
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
		newTelNum = telNumField.getText();
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
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("修改失败！");
			alert.setContentText("请重试！");
			alert.show();
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