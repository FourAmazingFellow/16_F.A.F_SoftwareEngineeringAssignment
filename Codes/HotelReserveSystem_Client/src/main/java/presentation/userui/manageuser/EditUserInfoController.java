package presentation.userui.manageuser;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ManageUserInfoService;
import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import po.UserType;
import presentation.WebsiteManageMainApp;
import presentation.userui.JudgeFormat;
import vo.ClientInfoVO;
import vo.UserVO;

public class EditUserInfoController {
	private WebsiteManageMainApp mainApp;
	private UserUIFactoryServiceImpl userFactory;
	private ManageUserInfoService manageUser;
	private ModifyClientInfoService modifyClientInfo;
	private ClientInfoVO client;
	private UserVO webUser;
	private UserVO modified;
	private String userIDm;
	private String telNumm;
	private JudgeFormat judge = new JudgeFormat();

	@FXML
	private TextField webMarketPasswordField;

	@FXML
	private TextField hotelPasswordField;

	@FXML
	private TextField clientPasswordField;

	@FXML
	private GridPane clientInfo;

	@FXML
	private Tab clientTab;

	@FXML
	private Tab hotelStaffTab;

	@FXML
	private GridPane webMarketStaffInfo;

	@FXML
	private Button confirmButton;

	@FXML
	private TextField clientTelNumField;

	@FXML
	private Label manageUserLabel;

	@FXML
	private Label creditValueLabel;

	@FXML
	private TextField hotelTelNumField;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField webMarketUserIDField;

	@FXML
	private TextField hotelUserIDField;

	@FXML
	private Tab webMarketStaffTab;

	@FXML
	private GridPane hotelStaffInfo;

	@FXML
	private Label hotelAddressLabel;

	@FXML
	private TextField webMarketTelNumField;

	@FXML
	private TextField clientUserIDField;

	@FXML
	private TabPane tabPane;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		 manageUser = userFactory.createManageUserInfoService();
		 modifyClientInfo = userFactory.createModifyClientInfoService();
//		manageUser = new ManageUserInfoServiceImpl_Stub("staff0001", "qwe123", "12345678909", UserType.WebMarketStaff,
//				"");
//		modifyClientInfo = new ModifyClientInfoServiceImpl_Stub("原", "qwe123", "12345678900", UserType.Client, 1500,
//				"阿里巴巴");
	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
	}

	// 显示修改前的信息
	public void showPreUserInfo(ClientInfoVO client, UserVO webUser) {
		this.client = client;
		this.webUser = webUser;
		if (client != null) {
			 tabPane.getSelectionModel().select(0);
			clientUserIDField.setText(client.userID);
			clientTelNumField.setText(client.telNum);
			creditValueLabel.setText(String.valueOf(client.creditValue));
		} else if (webUser != null) {
			 tabPane.getSelectionModel().select(1);
			webMarketUserIDField.setText(webUser.userID);
			webMarketTelNumField.setText(webUser.telNum);
		}
	}

	// 修改客户信息
	public void editClientInfo() {
		this.userIDm = clientUserIDField.getText();
		this.telNumm = clientTelNumField.getText();
		boolean isValid = judge.isLetterDigitOrChinese(userIDm);
		int newUserIDLength = judge.getStringLength(userIDm);
		boolean isNum = judge.isNumeric(telNumm);
		int newTelNumLength = judge.getStringLength(telNumm);
		if (userIDm.equals("") || telNumm.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (isValid != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("用户名包含非法字符！");
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
		}
//		this.userIDm = "原";
//		this.telNumm = "12345612345";
		this.modified = null;
		this.modified = new UserVO(userIDm, client.password, telNumm, UserType.Client);
		boolean result = false;
		try {
			result = modifyClientInfo.modifyClientInfo(modified, client.userID);
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
			mainApp.showManageUserPanel();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("修改失败！");
			alert.setContentText("请重试！");
			alert.showAndWait();
			return;
		}
	}

	// 修改网站人员信息
	public void editWebUserInfo() {
		this.userIDm = webMarketUserIDField.getText();
		this.telNumm = webMarketTelNumField.getText();
		boolean isValid = judge.isLetterDigitOrChinese(userIDm);
		int newUserIDLength = judge.getStringLength(userIDm);
		boolean isNum = judge.isNumeric(telNumm);
		int newTelNumLength = judge.getStringLength(telNumm);
		if (userIDm.equals("") || telNumm.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (isValid != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("包含非法字符！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (0 >= newUserIDLength || newUserIDLength > 20) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("长度不合理（1~20）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if(isNum != true){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("包含非法字符（只能输入数字）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}else if(newTelNumLength != 11){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("长度必须为11位！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		this.modified = null;
		this.modified = new UserVO(userIDm, webUser.password, telNumm, webUser.userType);
		boolean result = false;
		try {
			result = manageUser.modifyUserInfo(modified, webUser.userID);
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
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("修改失败！");
			alert.setContentText("请重试！");
			alert.showAndWait();
			return;
		}
	}

	@FXML
	// 取消按钮操作，返回管理用户界面
	public void cancelButtonAction(ActionEvent event) {
		mainApp.showManageUserPanel();
	}

	@FXML
	// 确认按钮操作，根据选择的tab调用不同的修改方法
	public void confirmButtonAction(ActionEvent event) {
		if (client != null) {
			editClientInfo();
		} else if (webUser != null) {
			editWebUserInfo();
		}
	}
}
