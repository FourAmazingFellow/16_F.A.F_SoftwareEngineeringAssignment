package presentation.hotelui.maintainhotel;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import presentation.HotelMainApp;
import vo.HotelVO;

public class EditHotelInfoController {
	private HotelUIFactoryService hotelFactory;
	private MaintainHotelBasicInfoService maintainHotelBasicInfo;
	private HotelMainApp mainApp;
	private HotelVO hotelVO;
	private int hotelStarm;
	private String briefIntrom;
	private String servicem;
	@FXML
	private Label maintainHotelInfoLabel;

	@FXML
	private Label hotelNameLabel;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField hotelStarField;

	@FXML
	private GridPane hotelEditTable;

	@FXML
	private TextField serviceField;

	@FXML
	private Label tradeAreaLabel;

	@FXML
	private Label hotelAddressLabel;

	@FXML
	private Label hotelMarkLabel;

	@FXML
	private Button confirmButton;

	@FXML
	private TextField briefIntroductionField;

	public EditHotelInfoController(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
	}
//create方法中参数？？？
	@FXML
	public void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		try {
			maintainHotelBasicInfo = hotelFactory.createMaintainHotelBasicInfoService(null);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		showPreDetails();
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void showPreDetails() {
		hotelNameLabel.setText(hotelVO.hotelName);
		hotelAddressLabel.setText(hotelVO.hotelAddress);
		hotelStarField.setText(String.valueOf(hotelVO.starLevel));
		hotelMarkLabel.setText(String.valueOf(hotelVO.mark));
		tradeAreaLabel.setText(hotelVO.tradeArea);
		briefIntroductionField.setText(hotelVO.briefIntroduction);
		serviceField.setText(hotelVO.facilityAndService);
	}

	public void editHotelInfo()  {
		this.hotelStarm = Integer.parseInt(hotelStarField.getText());
		this.briefIntrom = briefIntroductionField.getText();
		this.servicem = serviceField.getText();
		HotelVO modified = new HotelVO(hotelVO.hotelName, hotelVO.tradeArea, hotelVO.hotelAddress, hotelStarm,
				hotelVO.mark, hotelVO.tradeArea, briefIntrom, servicem, hotelVO.roomTypeAndPrice,
				hotelVO.roomTypeAndNums, hotelVO.comments);
		boolean result = false;
		try {
			result = maintainHotelBasicInfo.confirmModify(modified);
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
	void cancelButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	void confirmButtonAction(ActionEvent event){
		editHotelInfo();
	}
}
