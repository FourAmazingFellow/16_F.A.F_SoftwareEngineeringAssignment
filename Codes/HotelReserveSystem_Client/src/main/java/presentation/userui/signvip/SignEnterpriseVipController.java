package presentation.userui.signvip;

import java.rmi.RemoteException;

import bl_Stub.userblservice_Stub.SignVipServiceImpl_Stub;
import businesslogicservice.userblservice.ModifyClientInfoService;
import businesslogicservice.userblservice.SignVipService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import po.UserType;
import presentation.ClientMainApp;
import vo.ClientInfoVO;
import vo.EnterpriseVipVO;

public class SignEnterpriseVipController {
	private ClientMainApp mainApp;
	private SignVipService signVip;
	private UserUIFactoryService userFactory;
	private ModifyClientInfoService modifyClientInfo;
	private String userID;
	private String enterpriseID;
	private String enterprisePassword;

	public SignEnterpriseVipController(String userID) {
		this.userID = userID;
	}

	@FXML
	private TextField enterpriseNameField;

	@FXML
	private Button cancelButton;

	@FXML
	private Button signButton;

	@FXML
	private GridPane enterprise;

	@FXML
	private TextField enterprisePasswordField;

	@FXML
	void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		 signVip = userFactory.createSignVipService();
		 modifyClientInfo = userFactory.createModifyClientInfoService();
//		signVip = new SignVipServiceImpl_Stub("阿里巴巴", "alibaba6");
	}

	public void setMainApp(ClientMainApp clientMainApp) {
		this.mainApp = clientMainApp;
	}

	public void signEnterpriseVip() throws RemoteException {
		this.enterpriseID = enterpriseNameField.getText();
		this.enterprisePassword = enterprisePasswordField.getText();
		ClientInfoVO client = modifyClientInfo.getClientInfo(userID);
		EnterpriseVipVO enterpriseVip = new EnterpriseVipVO(userID, client.password, client.telNum, UserType.Client,
				client.creditValue, client.creditRecord, enterpriseID, enterprisePassword);
		boolean result = signVip.signEnterpriseVip(enterpriseVip);
		if (result == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("sign info");
			alert.setHeaderText("注册成功！");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("注册失败！");
			alert.setContentText("请重试！");
			alert.show();
		}
	}
	
	@FXML
	// 取消按钮action
	void cancelbuttonAction(ActionEvent event) {
		return;
	}

	@FXML
	// 注册按钮action，跳转提示框（是否注册成功）
	void signButtonAction(ActionEvent event) throws RemoteException {
		signEnterpriseVip();
	}
}
