package presentation.hotelui.managehotel;

import java.rmi.RemoteException;
import java.util.HashMap;

import businesslogicservice.hotelblservice.ManageHotelInfoService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
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
import po.RoomType;
import po.UserType;
import presentation.WebsiteManageMainApp;
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
	private HashMap<RoomType, Integer> hash1 = new HashMap<>();
	private HashMap<RoomType, Integer> hash2 = new HashMap<>();
	private HashMap<String, String> hash3 = new HashMap<>();

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
	public void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		manageHotel = hotelFactory.createManageHotelInfoService(null);
		
		hotelNameLabel.setText("");
		hotelAddressLabel.setText("");
		starLabel.setText("");
		tradeAreaLabel.setText("");
		serviceLabel.setText("");
		briefIntroLabel.setText("");
		
		searchField.setText("");
		
		hotelNameField.setText("");
		hotelStaffIDfField.setText("");
		passwordField.setText("");
		telNumField.setText("");
	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	void searchButtonAction(ActionEvent event) {
//		tabPane.getSelectionModel().select(0);;
		this.hotelAddress = searchField.getText();
		if(hotelAddress.equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("未输入搜索信息！");
			alert.setContentText("请输入！");
			alert.show();
			return;
		}
		HotelVO hotel = null;
		try {
			hotel = manageHotel.getHotelInfo(hotelAddress);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (hotel == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("酒店地址输入错误！");
			alert.setContentText("请重新输入！");
			return;
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
			serviceLabel.setText(service);
			briefIntroLabel.setText(briefIntro);
		}

	}

	public void addNewHotel() {
//		tabPane.getSelectionModel().select(hotelInfoTab);
		this.hotelNameNew = hotelNameField.getText();
		this.staffID = hotelStaffIDfField.getText();
		this.password = passwordField.getText();
		this.telNum = telNumField.getText();
		
		if(hotelNameNew.equals("")||staffID.equals("")||password.equals("")||telNum.equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.show();
			return;
		}
		HotelVO newHotel = new HotelVO(hotelNameNew, "", "", 0, 0, "", "", "", hash1, hash2, hash3);
		boolean result1 = false;
		try {
			result1 = manageHotel.addHotel(newHotel);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		HotelStaffInfoVO staff = new HotelStaffInfoVO(staffID, password, telNum, UserType.HotelStaff, null);
		boolean result2 = false;
		try {
			result2 = manageHotel.addHotelStaff(staff);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (result1 == false || result2 == false) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("添加失败！");
			alert.setContentText("请重试！");
			alert.show();
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
	void confirmButtonAction(ActionEvent event) {
		addNewHotel();
	}
}
