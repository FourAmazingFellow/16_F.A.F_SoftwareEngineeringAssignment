package presentation.userui.manageuser;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ManageUserInfoService;
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
import presentation.WebsiteManageMainApp;
import vo.UserVO;

public class addNewUserController {
	private WebsiteManageMainApp mainApp;
	private UserUIFactoryServiceImpl userFactory;
	private ManageUserInfoService manageUser;
	private String userID;
	private String password;
	private String telNum;
	@FXML
	private TextField webMarketPasswordField;

	@FXML
	private Button cancelButton;

	@FXML
	private GridPane webMarketStaffInfo1;

	@FXML
	private TextField webMarketUserIDField;

	@FXML
	private TextField webMarketTelNumField;

	@FXML
	private Button confirmButton;

	@FXML
	private Label manageUserLabel;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		manageUser = userFactory.createManageUserInfoService();
		webMarketUserIDField.setText("");
		webMarketPasswordField.setText("");
		webMarketTelNumField.setText("");
	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
	}

	// 添加新用户
	public void addNewUser() {
		this.userID = webMarketUserIDField.getText();
		this.password = webMarketPasswordField.getText();
		this.telNum = webMarketTelNumField.getText();
		if (userID.equals("") || password.equals("") || telNum.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.show();
			return;
		}
		UserVO user = new UserVO(userID, password, telNum, UserType.WebMarketStaff);
		boolean result = false;
		try {
			result = manageUser.add(user);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (result == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("add info");
			alert.setHeaderText("添加成功！");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("添加失败！");
			alert.setContentText("请重试！");
			alert.show();
			return;
		}
	}

	@FXML
	// 取消按钮操作，返回管理用户界面
	void cancelButtonAction(ActionEvent event) {
		mainApp.showManageUserPanel();
	}

	@FXML
	//确认添加按钮操作，保存添加
	void confirmButtonAction(ActionEvent event) throws RemoteException {
		addNewUser();
	}

}
