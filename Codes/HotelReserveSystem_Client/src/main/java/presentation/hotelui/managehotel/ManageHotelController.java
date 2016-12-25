package presentation.hotelui.managehotel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import businesslogicservice.hotelblservice.ManageHotelInfoService;
import businesslogicservice.strategyblservice.UpdateStrategyService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import factory.StrategyUIFactoryService;
import factory.StrategyUIFactoryServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import po.BusinessDistrictPO;
import po.RoomType;
import po.UserType;
import presentation.WebsiteManageMainApp;
import presentation.userui.JudgeFormat;
import vo.HotelStaffInfoVO;
import vo.HotelVO;

public class ManageHotelController {
	private HotelUIFactoryService hotelFactory;
	private StrategyUIFactoryService strategyFactory;
	private ManageHotelInfoService manageHotel;
	private UpdateStrategyService updateStrategyService;
	private WebsiteManageMainApp mainApp;
	private String hotelAddress;
	private String hotelName, hotelNameNew;
	private String tradeArea;
	private String city;
	private String service;
	private int hotelStar;
	private String briefIntro;
	private String staffID;
	private String password, passwordConfirm;
	private String telNum;
	private HotelVO newHotel;
	private HotelStaffInfoVO staff;
	private ObservableList<String> cityListData = FXCollections.observableArrayList("南京市", "上海市");
	private ObservableList<String> tradeAreaListData = FXCollections.observableArrayList();
	private HashMap<RoomType, Integer> hash1 = new HashMap<>();
	private HashMap<RoomType, Integer> hash2 = new HashMap<>();
	private HashMap<String, String> hash3 = new HashMap<>();
	private JudgeFormat judge = new JudgeFormat();

	@FXML
	private Label briefIntroLabel;

	@FXML
	private TextField hotelAddressField;

	@FXML
	private Button searchButton;

	@FXML
	private TextField searchField;

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
	private PasswordField passwordConfirmField;

	@FXML
	private Label tradeAreaLabel;

	@FXML
	private GridPane newHotelInfo;

	@FXML
	private ChoiceBox<String> tradeAreaChoiceBox;

	@FXML
	private Label hotelAddressLabel;

	@FXML
	private PasswordField passwordField;

	@FXML
	private ChoiceBox<String> cityChoiceBox;

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
		strategyFactory = new StrategyUIFactoryServiceImpl();
		updateStrategyService = strategyFactory.createUpdateStrategyService();
		// manageHotel = new ManageHotelInfoServiceImpl_Stub();

		searchField.setText("");
		
		cityChoiceBox.setItems(cityListData);
		tradeAreaChoiceBox.setItems(tradeAreaListData);
		 try {
	            setTradeAreaList(updateStrategyService
	                    .getBusinessDistrictList(cityChoiceBox.getSelectionModel().getSelectedItem()));
	        } catch (RemoteException e) {
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("NetWork Warning");
	            alert.setHeaderText("Fail to connect with the server!");
	            alert.setContentText("Please check your network connection!");
	            alert.showAndWait();
	        }
	        // 给cityChoiceBox2添加监听
	        cityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
	            @Override
	            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
	                try {
	                    setTradeAreaList(updateStrategyService.getBusinessDistrictList(cityListData.get((int) newValue)));
	                } catch (RemoteException e) {
	                    Alert alert = new Alert(AlertType.WARNING);
	                    alert.setTitle("NetWork Warning");
	                    alert.setHeaderText("Fail to connect with the server!");
	                    alert.setContentText("Please check your network connection!");
	                    alert.showAndWait();
	                }
	            }
	        });

	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void setPreInfo() {
		hotelNameLabel.setText("");
		hotelAddressLabel.setText("");
		starLabel.setText("");
		tradeAreaLabel.setText("");
		serviceLabel.setText("");
		briefIntroLabel.setText("");

		hotelNameField.setText("");
		hotelStaffIDfField.setText("");
		passwordField.setText("");
		telNumField.setText("");
	}

	public void setTradeAreaList(ArrayList<BusinessDistrictPO> tradeAreaPOs) {
		tradeAreaListData.clear();
		for (BusinessDistrictPO tradeAreaPO : tradeAreaPOs) {
			tradeAreaListData.add(tradeAreaPO.getBusinessDistrictName());
		}
	}

	public void getHotelInfo() {
		this.hotelAddress = searchField.getText();
		if (hotelAddress.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("未输入搜索信息！");
			alert.setContentText("请输入！");
			alert.showAndWait();
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
			alert.showAndWait();
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

	@FXML
	public void searchButtonAction(ActionEvent event) {
		tabPane.getSelectionModel().select(0);
		setPreInfo();
		getHotelInfo();
	}

	public void addNewHotel() {
		// tabPane.getSelectionModel().select(hotelInfoTab);
		this.hotelNameNew = hotelNameField.getText();
		this.hotelAddress = hotelAddressField.getText();
		this.city = cityChoiceBox.getSelectionModel().getSelectedItem();
		this.tradeArea = tradeAreaChoiceBox.getSelectionModel().getSelectedItem();
		this.staffID = hotelStaffIDfField.getText();
		this.password = passwordField.getText();
		this.passwordConfirm = passwordConfirmField.getText();
		this.telNum = telNumField.getText();
		boolean isValid = false;
		isValid = judge.isLetterDigitOrChinese(staffID);
		int userIDLength = 0;
		userIDLength = judge.getStringLength(staffID);
		boolean isPasswordValid = judge.isLetterOrDigit(password);
		int passwordLength = judge.getStringLength(password);
		boolean isNum = judge.isNumeric(telNum);
		int telNumLength = judge.getStringLength(telNum);

		// this.hotelNameNew = "qwe";
		// this.staffID = "staff";
		// this.password = "qwe123";
		// this.passwordConfirm = "qwe123";
		// this.telNum = "12345678900";

		if (hotelNameNew.equals("") ||hotelAddress.equals("")||tradeArea.equals("")||city.equals("")|| staffID.equals("") || password.equals("") || telNum.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (isValid != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("用户名包含非法字符（只能是数字、字母或中文）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (0 >= userIDLength || userIDLength > 20) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("用户名长度不合理（1~20）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (isPasswordValid != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("密码包含非法字符（只能是数字或字母）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (5 >= passwordLength || passwordLength > 16) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("密码长度不合理（6~16）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (!password.equals(passwordConfirm)) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("两次密码输入不一致！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (isNum != true) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("联系方式包含非法字符（只能输入数字）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (telNumLength != 11) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("长度必须为11位！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		this.newHotel = null;
		this.newHotel = new HotelVO(hotelNameNew,tradeArea, hotelAddress , 0, 0, city, "", "", hash1, hash2, hash3);
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
		this.staff = null;
		this.staff = new HotelStaffInfoVO(staffID, password, telNum, UserType.HotelStaff, hotelAddress);
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
			alert.showAndWait();
			return;
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("add info");
			alert.setHeaderText("添加成功！");
			alert.showAndWait();
			mainApp.showManageHotelPanel();
		}
	}

	@FXML
	public void cancelButtonAction(ActionEvent event) {
		mainApp.showManageHotelPanel();
	}

	@FXML
	public void confirmButtonAction(ActionEvent event) {
		addNewHotel();
	}
}
