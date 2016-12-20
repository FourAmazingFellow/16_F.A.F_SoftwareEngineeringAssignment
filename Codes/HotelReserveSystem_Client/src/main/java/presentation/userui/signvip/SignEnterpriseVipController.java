package presentation.userui.signvip;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ModifyClientInfoService;
import businesslogicservice.userblservice.SignVipService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		 signVip = userFactory.createSignVipService();
		 modifyClientInfo = userFactory.createModifyClientInfoService();
//		signVip = new SignVipServiceImpl_Stub("阿里巴巴", "alibaba6");
		 
		 enterpriseNameField.setText("");
		 enterprisePasswordField.setText("");
	}

	public void setMainApp(ClientMainApp clientMainApp) {
		this.mainApp = clientMainApp;
	}
	public void setUserID(String userID){
		this.userID = userID;
	}
	
	public void signEnterpriseVip(){
		this.enterpriseID = enterpriseNameField.getText();
		this.enterprisePassword = enterprisePasswordField.getText();
		
		if(enterpriseID.equals("")||enterprisePassword.equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.show();
			return;
		}
		
		ClientInfoVO client = null;
		try {
			client = modifyClientInfo.getClientInfo(userID);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		EnterpriseVipVO enterpriseVip = new EnterpriseVipVO(userID, client.password, client.telNum, UserType.Client,
				client.creditValue, client.creditRecord, enterpriseID, enterprisePassword);
		boolean result = false;
		try {
			result = signVip.signEnterpriseVip(enterpriseVip);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
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
	public void cancelbuttonAction(ActionEvent event) {
		return;
	}

	@FXML
	// 注册按钮action，跳转提示框（是否注册成功）
	public void signButtonAction(ActionEvent event) {
		signEnterpriseVip();
	}
}
