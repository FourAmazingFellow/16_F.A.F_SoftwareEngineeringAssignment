package presentation.hotelui.enrollavaluableroom;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.ImportNewRoomService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import po.RoomType;
import presentation.HotelMainApp;
import presentation.userui.manageuser.addNewUserController;
import vo.RoomVO;

public class AddRoomTypeController {
	private HotelUIFactoryService hotelFactory;
	private ImportNewRoomService importNewRoom;
	private HotelMainApp mainApp;
	private String roomTypeStr;
	private RoomType roomType;
	public int roomNum;
	public int roomPrice;
	public String address;

	public  AddRoomTypeController(String address) {
		this.address = address;
	}
	
	@FXML
	private Label addNewRoomTypeLabel;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField roomNumberField;

	@FXML
	private TextField primePriceField;

	@FXML
	private GridPane newRoomTypeInfoTable;

	@FXML
	private TextField roomTypeField;

	@FXML
	private Button confirmButton;

	@FXML
	private ChoiceBox<String> choiceBox;

	@FXML
	void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		importNewRoom = hotelFactory.createImportNewRoomService();
		choiceBox.setItems(FXCollections.observableArrayList("单人房", "标准间", "三人房", "大床房"));
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void addRoomType() throws RemoteException {
		this.roomTypeStr = choiceBox.getTypeSelector();
		this.roomType = (RoomType) RoomType.chineseToEnum(roomTypeStr);
		this.roomNum = Integer.parseInt(roomNumberField.getText());
		this.roomPrice = Integer.parseInt(primePriceField.getText());
		RoomVO room = new RoomVO(roomType, roomNum, roomPrice, address);
		boolean result = importNewRoom.addRoom(room);
		if (result == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("add info");
			alert.setHeaderText("添加成功！");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("添加失败！");
			alert.setContentText("请重试！");
			alert.show();
		}
	}
	
	@FXML
	void cancelButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	void confirmButtonAction(ActionEvent event) throws RemoteException {
		addRoomType();
	}
}
