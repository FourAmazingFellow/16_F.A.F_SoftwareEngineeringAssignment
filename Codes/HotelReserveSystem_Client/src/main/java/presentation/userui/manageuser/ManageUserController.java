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
import javafx.scene.layout.HBox;
import presentation.WebsiteManageMainApp;
import vo.ClientInfoVO;
import vo.HotelStaffInfoVO;
import vo.UserVO;

public class ManageUserController {
	private WebsiteManageMainApp mainApp;
	private UserUIFactoryServiceImpl userFactory;
	private ManageUserInfoService manageUser;
	private ModifyClientInfoService modifyClientInfo;
	private String userID;
	private ClientInfoVO client;
	private HotelStaffInfoVO hotelStaff;
	private UserVO webUser;

	@FXML
	private Button searchButton;

	@FXML
	private Button addButton;

	@FXML
	private Button editButton;

	@FXML
	private TextField searchField;

	@FXML
	private TabPane tabPane;

	@FXML
	private Tab clientTab;

	@FXML
	private Tab hotelStaffTab;

	@FXML
	private GridPane webMarketStaffInfo;

	@FXML
	private Label passwordLabel;

	@FXML
	private Label creditValueLabel;

	@FXML
	private Label webMarketpasswordLabel;

	@FXML
	private Tab webMarketStaffTab;

	@FXML
	private Label hotelAddressLabel;

	@FXML
	private Label hotelpasswordLabel;

	@FXML
	private Label telNumLabel;

	@FXML
	private Label hoteluserIDLabel;

	@FXML
	private Label hoteltelNumLabel;

	@FXML
	private GridPane clientInfo;

	@FXML
	private Label webMarketuserIDLabel;

	@FXML
	private Label manageUserLabel;

	@FXML
	private Label webMarkettelNumLabel;

	@FXML
	private Label userIDLabel;

	@FXML
	private GridPane hotelStaffInfo;

	@FXML
	private HBox searchBox;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		manageUser = userFactory.createManageUserInfoService();
		modifyClientInfo = userFactory.createModifyClientInfoService();
		// manageUser = new ManageUserInfoServiceImpl_Stub("staff0001",
		// "qwe123", "12345678909", UserType.WebMarketStaff, "qwe");
		// modifyClientInfo = new ModifyClientInfoServiceImpl_Stub("原",
		// "qwe123", "12345678900", UserType.Client, 1500, "阿里巴巴");
		// searchField.setText("");

	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void setPreInfo() {
		userIDLabel.setText("");
		telNumLabel.setText("");
		creditValueLabel.setText("");

		hoteluserIDLabel.setText("");
		hoteltelNumLabel.setText("");
		hotelAddressLabel.setText("");

		webMarketuserIDLabel.setText("");
		webMarkettelNumLabel.setText("");
	}

	// 显示用户信息
	public void showUserInfo() {
		this.userID = searchField.getText();
//		 this.userID = "yuan";
		if (userID.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("未输入查找的用户名！");
			alert.setContentText("请重新输入！");
			alert.show();
			return;
		}
		ClientInfoVO client = null;
		HotelStaffInfoVO hotelStaff = null;
		UserVO webUser = null;
		try {
			client = modifyClientInfo.getClientInfo(userID);
			this.client = client;
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (this.client == null) {
			try {
				hotelStaff = manageUser.getHotelStaffInfo(userID);
				this.hotelStaff = hotelStaff;
			} catch (RemoteException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("NetWork Warning");
				alert.setHeaderText("Fail to connect with the server!");
				alert.setContentText("Please check your network connection!");
				alert.showAndWait();
			}
		} else if (this.client == null && this.hotelStaff == null) {
			try {
				webUser = manageUser.getUserInfo(userID);
				this.webUser = webUser;
			} catch (RemoteException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("NetWork Warning");
				alert.setHeaderText("Fail to connect with the server!");
				alert.setContentText("Please check your network connection!");
				alert.showAndWait();
			}
		}

		if (this.client != null) {
			// tabPane.getSelectionModel().select(clientTab);
			userIDLabel.setText(client.userID);
			telNumLabel.setText(client.telNum);
			creditValueLabel.setText(String.valueOf(client.creditValue));
		} else if (this.hotelStaff != null) {
			// tabPane.getSelectionModel().select(hotelStaffTab);
			hoteluserIDLabel.setText(hotelStaff.userID);
			hoteltelNumLabel.setText(hotelStaff.telNum);
			hotelAddressLabel.setText(hotelStaff.hotelAddress);
		} else if (this.webUser != null) {
			// tabPane.getSelectionModel().select(webMarketStaffTab);
			webMarketuserIDLabel.setText(webUser.userID);
			webMarkettelNumLabel.setText(webUser.telNum);
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("未找到相关用户！");
			alert.setContentText("请重新输入！");
			alert.show();
			return;
		}
	}

	@FXML
	// 搜索按钮操作，显示搜索后的信息
	public void searchButtonAction(ActionEvent event) {
		this.client = null;
		this.hotelStaff = null;
		this.webUser = null;
		setPreInfo();
		showUserInfo();
	}

	@FXML
	// 编辑按钮操作，跳转编辑界面
	public void editButtonAction(ActionEvent event) {
		if (client != null) {
			this.webUser = null;
			mainApp.showEditUserInfoPanel(client, webUser);
		} else if (hotelStaff != null) {
			// 不可以对酒店工作人员信息进行修改
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("不可对酒店工作人员信息进行修改！");
			alert.show();
		} else if (webUser != null) {
			this.client = null;
			mainApp.showEditUserInfoPanel(client, webUser);
		}
	}

	@FXML
	// 添加按钮操作，跳转添加新用户界面
	public void addButtonAction(ActionEvent event) {
		mainApp.showAddUserPanel();
	}

}
