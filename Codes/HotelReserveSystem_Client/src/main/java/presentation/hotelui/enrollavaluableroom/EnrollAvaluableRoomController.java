package presentation.hotelui.enrollavaluableroom;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.ImportNewRoomService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.HotelMainApp;
import vo.RoomVO;

public class EnrollAvaluableRoomController {
	private HotelUIFactoryService hotelFactory;
	private ImportNewRoomService importNewRoom;
	private HotelMainApp mainApp;
	private String address;
	private RoomList roomList;
	private RoomVO selected;
	private ObservableList<Room> roomData = FXCollections.observableArrayList();

	@FXML
	private TableView<Room> avaluableRoomInfoTable;

	@FXML
	private TableColumn<Room, String> roomTypeColumn;
	@FXML
	private TableColumn<Room, String> roomNumColumn;
	@FXML
	private TableColumn<Room, String> roomPriceColumn;

	@FXML
	private Button editButton;

	@FXML
	private Button addButton;

	@FXML
	private Label avaluableRoomListLabel;

	@FXML
	public void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		importNewRoom = hotelFactory.createImportNewRoomService();

		// RoomType roomType = RoomType.KING_SIZE_ROOM;
		// int roomNum = 30;
		// int roomPrice = 150;
		// String address ="南京市栖霞区仙林大道163号";
		// importNewRoom = new ImportNewRoomServiceImpl_Stub(roomType, roomNum,
		// roomPrice, address);

		roomList = new RoomList();
		avaluableRoomInfoTable.setItems(roomData);
		roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
		roomNumColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumProperty());
		roomPriceColumn.setCellValueFactory(cellData -> cellData.getValue().roomPriceProperty());

	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}

	// 显示可用客房信息
	public void enrollAvaluableRoom(String address) {
		this.address = address;
		ArrayList<RoomVO> roomVOs = null;
		try {
			roomVOs = importNewRoom.getAvailableRoomList(this.address);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (roomVOs == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("找不到房型信息！");
			alert.setContentText("请重试！");
			alert.showAndWait();
			return;
		}
		roomData.clear();
		roomList.setRoomList(roomVOs);
		roomData.addAll(roomList.getStrategyList());
	}

	@FXML
	public void addNewRoomTypeButtonAction(ActionEvent event) {
		mainApp.showAddNewRoomTypePanel();
	}

	@FXML
	public void editButtonAction(ActionEvent event) {
		if(avaluableRoomInfoTable.getSelectionModel().getSelectedIndex()< 0){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("wrong");
		alert.setHeaderText("未选中房间类型！");
		alert.setContentText("请重新选择！");
		alert.showAndWait();
		return;
		}
		else {
			try {
				this.selected = roomData.get(avaluableRoomInfoTable.getSelectionModel().getSelectedIndex()).toVO(address);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (selected != null)
				mainApp.showEditAvaluableRoomTypePanel(selected);
		}
	}
}
