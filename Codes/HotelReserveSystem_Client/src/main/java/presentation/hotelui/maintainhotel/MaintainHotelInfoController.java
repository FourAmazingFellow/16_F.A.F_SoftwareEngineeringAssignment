package presentation.hotelui.maintainhotel;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import presentation.HotelMainApp;
import vo.HotelVO;

public class MaintainHotelInfoController {
	private HotelUIFactoryService hotelFactory;
	private MaintainHotelBasicInfoService maintainHotelBasicInfo;
	private HotelMainApp mainApp;
	private String hotelAddress;
	private HotelVO hotelVO;

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
	private Label serviceLabel;

	@FXML
	public void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();

//		String address = "南京市栖霞区仙林大道163号";
//		// this.hotelAddress = address;
//		String hotelName = "F.A.F酒店";
//		String tradeArea = "栖霞区";
//		int starLevel = 4;
//		float mark = (float) 4.6;
//		String city = "南京市";
//		String facilityAndService = "空调、热水";
//		String briefIntroduction = "南京市最好的酒店";
//		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
//		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 150);
//		HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
//		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 30);
//		HashMap<String, String> comments = new HashMap<>();
//		comments.put("原", "这是我住过最舒服的酒店！！！！！");
//		maintainHotelBasicInfo = new MaintainHotelBasicInfoServiceImpl_Stub(hotelName, tradeArea, address, starLevel,
//				mark, city, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
		
		 try {
		 maintainHotelBasicInfo =
		 hotelFactory.createMaintainHotelBasicInfoService();
		 } catch (RemoteException e) {
		 Alert alert = new Alert(AlertType.WARNING);
		 alert.setTitle("NetWork Warning");
		 alert.setHeaderText("Fail to connect with the server!");
		 alert.setContentText("Please check your network connection!");
		 alert.showAndWait();
		 }
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void showHotelDetail(String address) {
		this.hotelAddress = address;
		try {
			this.hotelVO = maintainHotelBasicInfo.enrollHotelBasicInfo(hotelAddress);
		} catch (RemoteException e) {
			 Alert alert = new Alert(AlertType.WARNING);
			 alert.setTitle("NetWork Warning");
			 alert.setHeaderText("Fail to connect with the server!");
			 alert.setContentText("Please check your network connection!");
			 alert.showAndWait();
		}
		hotelNameLabel.setText(hotelVO.hotelName);
		hotelAddressLabel.setText(hotelVO.hotelAddress);
		hotelStarLabel.setText(String.valueOf(hotelVO.starLevel));
		hotelMarkLabel.setText(String.valueOf(hotelVO.mark));
		tradeAreaLabel.setText(hotelVO.tradeArea);
		briefIntroductionabel.setText(hotelVO.briefIntroduction);
		serviceLabel.setText(hotelVO.facilityAndService);
	}

	@FXML
	public void editButtonAction(ActionEvent event) {
		mainApp.showEditHotelInfoPanel(hotelVO);
	}
}
