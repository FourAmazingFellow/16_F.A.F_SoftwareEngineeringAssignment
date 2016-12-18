package presentation.hotelui.maintainhotel;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import presentation.HotelMainApp;
import vo.HotelVO;

public class MaintainHotelInfoController {
	private HotelUIFactoryService hotelFactory;
	private MaintainHotelBasicInfoService maintainHotelBasicInfo;
	private HotelMainApp mainApp;
	private String hotelAddress;
	private HotelVO hotelVO;
	
	public MaintainHotelInfoController(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	@FXML
	private Label maintainHotelInfoLabel;

	@FXML
	private Label hotelNameLabel;

	@FXML
	private GridPane hotelEditTable;

	@FXML
	private Label tradeAreaLabel;

	@FXML
	private Label hotelStarLabel;

	@FXML
	private Button editButton;

	@FXML
	private Label hotelAddressLabel;

	@FXML
	private Label briefIntroductionabel;

	@FXML
	private Label hotelMarkLabel;

	@FXML
	private Button returnButton;

	@FXML
	private Label serviceLabel;

	@FXML
	void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		maintainHotelBasicInfo = hotelFactory.createMaintainHotelBasicInfoService(hotelAddress);
		showHotelDetail();
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void showHotelDetail(){
		this.hotelVO = maintainHotelBasicInfo.enrollHotelBasicInfo(hotelAddress);
		hotelNameLabel.setText(hotelVO.hotelName);
		hotelAddressLabel.setText(hotelVO.hotelAddress);
		hotelStarLabel.setText(String.valueOf(hotelVO.starLevel));
		hotelMarkLabel.setText(String.valueOf(hotelVO.mark));
		tradeAreaLabel.setText(hotelVO.tradeArea);
		briefIntroductionabel.setText(hotelVO.briefIntroduction);
		serviceLabel.setText(hotelVO.facilityAndService);
	}
	
	@FXML
	void returnButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	void editButtonAction(ActionEvent event) {
		new EditHotelInfoController(hotelVO);
	}
}
