package presentation.userui.maintain;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.Optional;

import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import presentation.ClientMainApp;
import vo.ClientInfoVO;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

public class ModifyClientInfoController {
	private ClientMainApp mainApp;
	private ModifyClientInfoService modifyClientInfo;
	private UserUIFactoryService userFactory;
	private String userID;
	private String telNum;
	private int creditValue;
	private Date birth;
	private String enterpriseName;
	private ClientInfoVO client;
	private RegularVipVO regularVip;
	private EnterpriseVipVO enterpriseVip;

	@FXML
	private Label InfoLabel;

	@FXML
	private Label telNumLabel;

	@FXML
	private GridPane InfoTable;

	@FXML
	private Label userIDLabel;

	@FXML
	private Label creditValueLabel;

	@FXML
	private Label birthOrEnterpriseLabel;

	@FXML
	private Button editButton;

	@FXML
	private Button signVipButton;

	@FXML
	private Button creditButton;

	@FXML
	public void initialize() {
		userIDLabel.setText("");
		telNumLabel.setText("");
		creditValueLabel.setText("");
		birthOrEnterpriseLabel.setText("");
		userFactory = new UserUIFactoryServiceImpl();
		modifyClientInfo = userFactory.createModifyClientInfoService();
		// modifyClientInfo = new ModifyClientInfoServiceImpl_Stub("Accident",
		// "qwe123", "12345678900", UserType.Client,
		// 1000, "阿里巴巴");

	}

	public void setMainApp(ClientMainApp clientMainApp) {
		this.mainApp = clientMainApp;
	}

	// 获取客户信息，显示在界面上
	public void showClientInfo(String userID) {
		try {
			this.client = modifyClientInfo.getClientInfo(userID);

		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		this.userID = userID;
		this.telNum = client.telNum;
		this.creditValue = client.creditValue;
		if (client instanceof EnterpriseVipVO) {
			this.enterpriseVip = (EnterpriseVipVO) client;
			this.enterpriseName = enterpriseVip.enterpriseID;
		} else if (client instanceof RegularVipVO) {
			this.regularVip = (RegularVipVO) client;
			this.birth = regularVip.birth;
		}

		userIDLabel.setText(userID);
		telNumLabel.setText(telNum);
		creditValueLabel.setText(String.valueOf(creditValue));
		// 判断是否非空
		if (birth != null)
			birthOrEnterpriseLabel.setText(String.valueOf(birth));
		else if (enterpriseName != null)
			birthOrEnterpriseLabel.setText(enterpriseName);
	}

	@FXML
	// 编辑按钮action，跳转编辑界面
	public void editButtonAction() {
		mainApp.showEditClientInfoPanel(client, regularVip, enterpriseVip);
	}

	@FXML
	// 查看信用记录按钮action，跳转信用记录界面
	public void creditButtonAction() {
		mainApp.showQueryCreditRecordPanel(userID);
	}

	@FXML
	// 注册会员按钮action，跳转注册会员相关界面
	public void signVipButtonAction() {
		// 检查生日（企业名）一栏，若为空则说明不是会员，可以注册
		if (birthOrEnterpriseLabel.getText().equals("")) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("vip info");
			alert.setHeaderText("请选择注册会员类型！");
			ButtonType signRegularVip = new ButtonType("注册普通会员");
			ButtonType signEnterpriseVip = new ButtonType("注册企业会员");
			ButtonType cancel = new ButtonType("取消", ButtonData.CANCEL_CLOSE);
			alert.getButtonTypes().setAll(signRegularVip, signEnterpriseVip, cancel);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == signRegularVip) {
				mainApp.showSignRegularVipPanel(userID);
			} else if (result.get() == signEnterpriseVip) {
				mainApp.showSignEnterpriseVipPanel(userID);
			} else {
				return;
			}
			// 不为空则已经是会员了，不可重复注册
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("您已经是会员了！");
			alert.setContentText("不可重复注册！");
			alert.show();
		}
	}
}
