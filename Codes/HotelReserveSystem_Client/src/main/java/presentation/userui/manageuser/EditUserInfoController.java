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
import vo.ClientInfoVO;
import vo.UserVO;

public class EditUserInfoController {
	private WebsiteManageMainApp mainApp;
	private UserUIFactoryServiceImpl userFactory;
	private ManageUserInfoService manageUser;
	private ModifyClientInfoService modifyClientInfo;
	private ClientInfoVO client;
	private UserVO webUser;
	private String userIDm;
	private String passwordm;
	private String telNumm;

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

	public EditUserInfoController(ClientInfoVO client) {
		this.client = client;
	}

	public EditUserInfoController(UserVO webUser) {
		this.webUser = webUser;
	}

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		manageUser = userFactory.createManageUserInfoService();
		modifyClientInfo = userFactory.createModifyClientInfoService();
	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void showPreUserInfo(ClientInfoVO client, UserVO webUser) {
		if (client != null) {
			tabPane.getSelectionModel().select(clientTab);
			clientUserIDField.setText(client.userID);
			clientPasswordField.setText(client.password);
			clientTelNumField.setText(client.telNum);
			creditValueLabel.setText(String.valueOf(client.creditValue));
		} else if (webUser != null) {
			tabPane.getSelectionModel().select(webMarketStaffTab);
			webMarketUserIDField.setText(webUser.userID);
			webMarketPasswordField.setText(webUser.password);
			webMarketTelNumField.setText(webUser.telNum);
		}
	}

	public void editClientInfo() {
		this.userIDm = clientUserIDField.getText();
		this.passwordm = clientPasswordField.getText();
		this.telNumm = clientTelNumField.getText();
		UserVO modified = new UserVO(userIDm, passwordm, telNumm, UserType.Client);
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
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("修改失败！");
			alert.setContentText("请重试！");
			alert.show();
			return;
		}
	}

	public void editWebUserInfo() {
		this.userIDm = webMarketPasswordField.getText();
		this.passwordm = webMarketPasswordField.getText();
		this.telNumm = webMarketTelNumField.getText();
		UserVO modified = new UserVO(userIDm, passwordm, telNumm, webUser.userType);
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
	public void cancelButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	public void confirmButtonAction(ActionEvent event) {
		if (tabPane.getSelectionModel().equals(clientTab)) {
			editClientInfo();
		} else if (tabPane.getSelectionModel().equals(webMarketStaffTab)) {
			editWebUserInfo();
		}
	}
}
