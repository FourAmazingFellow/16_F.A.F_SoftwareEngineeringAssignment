package presentation.hotelui.managehotel;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Set;

import businesslogicservice.hotelblservice.ManageHotelInfoService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
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
import po.UserType;
import presentation.HotelMainApp;
import presentation.WebsiteManageMainApp;
import vo.ClientInfoVO;
import vo.HotelStaffInfoVO;
import vo.HotelVO;

public class ManageHotelController {
	private HotelUIFactoryService hotelFactory;
	private ManageHotelInfoService manageHotel;
	private WebsiteManageMainApp mainApp;
	private String hotelAddress;
	private String hotelName, hotelNameNew;
	private String tradeArea;
	private String service;
	private int hotelStar;
	private String briefIntro;
	private String staffID;
	private String password;
	private String telNum;

	@FXML
	private Button searchButton;

	@FXML
	private TextField searchField;

	@FXML
	private Label briefIntroLabel;

	@FXML
	private Label starLabel;

	@FXML
	private TextField hotelNameField;

	@FXML
	private Button confirmButton;

	@FXML
	private Tab addNewHotelTab;

	@FXML
	private Button cancelButton;

	@FXML
	private GridPane hotelInfo;

	@FXML
	private Label hotelNameLabel;

	@FXML
	private Tab hotelInfoTab;

	@FXML
	private TextField telNumField;

	@FXML
	private Label tradeAreaLabel;

	@FXML
	private GridPane newHotelInfo;

	@FXML
	private Label hotelAddressLabel;

	@FXML
	private TextField passwordField;

	@FXML
	private Label manageHotelLabel;

	@FXML
	private TextField hotelStaffIDfField;

	@FXML
	private Label serviceLabel;

	@FXML
	private HBox searchBox;

	@FXML
	private TabPane tabPane;

	@FXML
	void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		manageHotel = hotelFactory.createManageHotelInfoService(null);
	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	void searchButtonAction(ActionEvent event) throws RemoteException {
		tabPane.getSelectionModel().select(hotelInfoTab);
		this.hotelAddress = searchField.getText();
		HotelVO hotel = manageHotel.getHotelInfo(hotelAddress);

		if (hotel == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("酒店地址输入错误！");
			alert.setContentText("请重新输入！");
		} else {
			this.hotelName = hotel.hotelName;
			this.tradeArea = hotel.tradeArea;
			this.hotelStar = hotel.starLevel;
			this.service = hotel.facilityAndService;
			this.briefIntro = hotel.briefIntroduction;
			hotelNameLabel.setText(hotelName);
			hotelAddressLabel.setText(hotelAddress);
			starLabel.setText(String.valueOf(hotelStar));
			tradeAreaLabel.setText(tradeArea);
			briefIntroLabel.setText(briefIntro);
		}

	}

	public void addNewHotel() throws RemoteException {
		tabPane.getSelectionModel().select(hotelInfoTab);
		this.hotelNameNew = hotelNameField.getText();
		this.staffID = hotelStaffIDfField.getText();
		this.password = passwordField.getText();
		this.telNum = telNumField.getText();
		HotelVO newHotel = new HotelVO(hotelNameNew, null, null, 0, 0, null, null, null, null, null, null);
		boolean result1 = manageHotel.addHotel(newHotel);
		HotelStaffInfoVO staff = new HotelStaffInfoVO(staffID, password, telNum, UserType.HotelStaff, null);
		boolean result2 = manageHotel.addHotelStaff(staff);
		if (result1 == false || result2 == false) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("添加失败！");
			alert.setContentText("请重试！");
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("add info");
			alert.setHeaderText("添加成功！");
		}
	}

	@FXML
	void cancelButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	void confirmButtonAction(ActionEvent event) throws RemoteException {
		addNewHotel();
	}
}
