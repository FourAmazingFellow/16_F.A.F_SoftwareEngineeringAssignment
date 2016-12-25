package presentation.hotelui.maintainhotel;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	private HotelVO modified;
	@FXML
	private Label maintainHotelInfoLabel;

	@FXML
	private Label hotelNameLabel;

	@FXML
	private Button cancelButton;

	@FXML
	private ChoiceBox<Integer> hotelStarChoiceBox;

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
			maintainHotelBasicInfo = hotelFactory.createMaintainHotelBasicInfoService();
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		
		hotelStarChoiceBox.setItems((ObservableList<Integer>) FXCollections.observableArrayList(1,2,3,4,5));
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void showPreDetails(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
		hotelNameLabel.setText(hotelVO.hotelName);
		hotelAddressLabel.setText(hotelVO.hotelAddress);
		hotelStarChoiceBox.getSelectionModel().select(hotelVO.starLevel-1);
		hotelMarkLabel.setText(String.valueOf(hotelVO.mark));
		tradeAreaLabel.setText(hotelVO.tradeArea);
		briefIntroductionField.setText(hotelVO.briefIntroduction);
		serviceField.setText(hotelVO.facilityAndService);
	}

	public void editHotelInfo() {
		this.hotelStarm = hotelStarChoiceBox.getSelectionModel().getSelectedItem();
		this.briefIntrom = briefIntroductionField.getText();
		this.servicem = serviceField.getText();
		if (briefIntrom.equals("") || servicem.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else {

			this.modified = null;
			this.modified = new HotelVO(hotelVO.hotelName, hotelVO.tradeArea, hotelVO.hotelAddress, hotelStarm,
					hotelVO.mark, hotelVO.city, briefIntrom, servicem, hotelVO.roomTypeAndPrice,
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
				alert.showAndWait();
				mainApp.showMaintainHotelInfoPanel();
			} else {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("wrong");
				alert.setHeaderText("修改失败！");
				alert.setContentText("请重试！");
				alert.showAndWait();
				return;
			}
		}
	}

	@FXML
	void cancelButtonAction(ActionEvent event) {
		mainApp.showMaintainHotelInfoPanel();
	}

	@FXML
	void confirmButtonAction(ActionEvent event) {
		editHotelInfo();
	}
}
