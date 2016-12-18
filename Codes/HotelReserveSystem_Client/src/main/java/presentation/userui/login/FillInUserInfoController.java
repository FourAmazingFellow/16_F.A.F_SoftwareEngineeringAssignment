package presentation.userui.login;

import java.rmi.RemoteException;

import bl_Stub.userblservice_Stub.LoginAndSignUpServiceImpl_Stub;
import businesslogicservice.userblservice.LoginAndSignUpService;
import businesslogicservice.userblservice.ManageUserInfoService;
import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import po.UserType;
import vo.UserVO;

public class FillInUserInfoController {
	private UserUIFactoryService userFactory;
	private LoginAndSignUpService registerInfo;
	private ModifyClientInfoService modifyClientInfo;
	private ManageUserInfoService manageUserInfo;
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

	public FillInUserInfoController(String userID, String password) {
		this.userID = userID;
		this.password = password;
	}

	@FXML
	void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		 registerInfo = userFactory.createLoginAndSignUpService();
//		registerInfo = new LoginAndSignUpServiceImpl_Stub();
		userIDField.setText(userID);
		passwordField.setText(password);
		userTypeChoiceBox.setItems((ObservableList<String>) FXCollections.observableArrayList("客户", "网站营销人员", "网站管理人员"));
		userTypeChoiceBox.setValue("客户");
	}

	public void registerInfo() throws RemoteException {
		String userTypeStr = userTypeChoiceBox.getValue();
		String telNum = telNumField.getText();
		UserType userType;
		if (userTypeStr.equals("客户")) {
			userType = UserType.Client;
			UserVO user = new UserVO(userID, password, telNum, userType);
			modifyClientInfo.modifyClientInfo(user, userID);
		} else if (userTypeStr.equals("网站营销人员")) {
			userType = UserType.WebMarketStaff;
			UserVO user = new UserVO(userID, password, telNum, userType);
			manageUserInfo.modifyUserInfo(user, userID);
		} else if (userTypeStr.equals("网站管理人员")) {
			userType = UserType.WebManageStaff;
			UserVO user = new UserVO(userID, password, telNum, userType);
			manageUserInfo.modifyUserInfo(user, userID);
		}

	}

}