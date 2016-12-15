package presentation.userui.login;

import bl_Stub.userblservice_Stub.LoginAndSignUpServiceImpl_Stub;
import businesslogicservice.userblservice.LoginAndSignUpService;
import businesslogicservice.userblservice.ManageUserInfoService;
import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import po.UserType;

public class FillInUserInfoController {
	private UserUIFactoryService userFactory;
	private LoginAndSignUpService registerInfo;
	private ModifyClientInfoService modifyClientInfo;
	private ManageUserInfoService manageUserInfo;
	
	@FXML
	private GridPane userInfoPane;

	@FXML
	private Button cancelButton;

	@FXML
	private Button confirmButton;

	@FXML
	private Label userInfoLabel;

	@FXML
	private ChoiceBox<String> userTypeChoiceBox;

	@FXML
	private TextField telNumField;

	@FXML
	void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		// registerInfo = userFactory.createLoginAndSignUpService();
		registerInfo = new LoginAndSignUpServiceImpl_Stub();

		userTypeChoiceBox.setItems(FXCollections.observableArrayList("客户", "网站营销人员", "网站管理人员"));
		userTypeChoiceBox.setValue("客户");
	}

	public void registerInfo() {
		String userTypeStr = userTypeChoiceBox.getValue();
		String telNum = telNumField.getText();
		UserType userType;
		if (userTypeStr.equals("客户")) {
			userType = UserType.Client;
		} else if (userTypeStr.equals("网站营销人员")) {
			userType = UserType.WebMarketStaff;
		} else if (userTypeStr.equals("网站管理人员")) {
			userType = UserType.WebManageStaff;
		}

	}

}