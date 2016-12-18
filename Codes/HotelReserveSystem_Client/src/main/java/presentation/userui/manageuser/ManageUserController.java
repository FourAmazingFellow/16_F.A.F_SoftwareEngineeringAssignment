package presentation.userui.manageuser;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ManageUserInfoService;
import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	private UserVO webUser;

	@FXML
	private Button searchButton;

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
	private Button confirmButton;

	@FXML
	private Label passwordLabel;

	@FXML
	private Label creditValueLabel;

	@FXML
	private Button cancelButton;

	@FXML
	private Button modifyButton;

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
	private Button addButton;

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
	void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		manageUser = userFactory.createManageUserInfoService();
		modifyClientInfo = userFactory.createModifyClientInfoService();
	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void showClientPanel() {
		tabPane.getSelectionModel().select(clientTab);
	}

	public void showHotelStaffPanel() {
		tabPane.getSelectionModel().select(hotelStaffTab);
	}

	public void showWebMarketPanel() {
		tabPane.getSelectionModel().select(webMarketStaffTab);
	}

	@FXML
	void searchButtonAction(ActionEvent event) throws RemoteException {
		this.userID = searchField.getText();
		ClientInfoVO client = modifyClientInfo.getClientInfo(userID);
		this.client = client;
		HotelStaffInfoVO hotelStaff = manageUser.getHotelStaffInfo(userID);
		UserVO webUser = manageUser.getUserInfo(userID);
		this.webUser = webUser;
		if (client != null) {
			tabPane.getSelectionModel().select(clientTab);
			userIDLabel.setText(client.userID);
			passwordLabel.setText(client.password);
			telNumLabel.setText(client.telNum);
			creditValueLabel.setText(String.valueOf(client.creditValue));
		} else if (hotelStaff != null) {
			tabPane.getSelectionModel().select(hotelStaffTab);
			hoteluserIDLabel.setText(hotelStaff.userID);
			hotelpasswordLabel.setText(hotelStaff.password);
			hoteltelNumLabel.setText(hotelStaff.telNum);
			hotelAddressLabel.setText(hotelStaff.hotelAddress);
		} else if (webUser != null) {
			tabPane.getSelectionModel().select(webMarketStaffTab);
			webMarketuserIDLabel.setText(webUser.userID);
			webMarketpasswordLabel.setText(webUser.password);
			webMarkettelNumLabel.setText(webUser.telNum);
		}
	}

	@FXML
	void returnButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	void editButtonAction(ActionEvent event) {
		if (tabPane.getSelectionModel().equals(clientTab)) {
			new EditUserInfoController(client);
		} else if (tabPane.getSelectionModel().equals(hotelStaffTab)) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("不可对酒店工作人员信息进行修改！");
			alert.show();
		} else if (tabPane.getSelectionModel().equals(webMarketStaffTab)) {
			new EditUserInfoController(webUser);
		}
	}

	@FXML
	void addButtonAction(ActionEvent event) {
		new addNewUserController();
	}

}
