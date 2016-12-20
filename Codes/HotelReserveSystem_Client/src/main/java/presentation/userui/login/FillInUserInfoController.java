package presentation.userui.login;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ManageUserInfoService;
import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import po.UserType;
import presentation.MainApp;
import vo.UserVO;

public class FillInUserInfoController {
	private UserUIFactoryService userFactory;
	private ModifyClientInfoService modifyClientInfo;
	private ManageUserInfoService manageUserInfo;
	private MainApp mainApp;
	private String userID;
	private String password;

	@FXML
	private Label userIDField;

	@FXML
	private GridPane userInfoPane;

	@FXML
	private Button cancelButton;

	@FXML
	private ChoiceBox<String> userTypeChoiceBox;

	@FXML
	private TextField telNumField;

	@FXML
	private Label passwordField;

	@FXML
	private Button confirmButton;

	@FXML
	private Label userInfoLabel;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		modifyClientInfo = userFactory.createModifyClientInfoService();
		// registerInfo = new LoginAndSignUpServiceImpl_Stub();
		userTypeChoiceBox
				.setItems((ObservableList<String>) FXCollections.observableArrayList("客户", "网站营销人员", "网站管理人员"));
		userTypeChoiceBox.setValue("客户");
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}

	public void setUserIDAndPassword(String userID, String password){
		userIDField.setText(userID);
		passwordField.setText(password);
	}
	
	public void fillInRegisterInfo() {
		String userTypeStr = userTypeChoiceBox.getValue();
		String telNum = telNumField.getText();
		UserType userType;
		if (userTypeStr.equals("客户")) {
			userType = UserType.Client;
			UserVO user = new UserVO(userID, password, telNum, userType);
			try {
				modifyClientInfo.modifyClientInfo(user, userID);
			} catch (RemoteException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("NetWork Warning");
				alert.setHeaderText("Fail to connect with the server!");
				alert.setContentText("Please check your network connection!");
				alert.showAndWait();
			}
		} else if (userTypeStr.equals("网站营销人员")) {
			userType = UserType.WebMarketStaff;
			UserVO user = new UserVO(userID, password, telNum, userType);
			try {
				manageUserInfo.modifyUserInfo(user, userID);
			} catch (RemoteException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("NetWork Warning");
				alert.setHeaderText("Fail to connect with the server!");
				alert.setContentText("Please check your network connection!");
				alert.showAndWait();
			}
		} else if (userTypeStr.equals("网站管理人员")) {
			userType = UserType.WebManageStaff;
			UserVO user = new UserVO(userID, password, telNum, userType);
			try {
				manageUserInfo.modifyUserInfo(user, userID);
			} catch (RemoteException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("NetWork Warning");
				alert.setHeaderText("Fail to connect with the server!");
				alert.setContentText("Please check your network connection!");
				alert.showAndWait();
			}
		}

	}

	@FXML
	public void cancelButtonAction(ActionEvent event) {
		mainApp.showRegisterPanel();
	}

	@FXML
	public void comfirmButtonAction(ActionEvent event) {
		fillInRegisterInfo();
	}

}