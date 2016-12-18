package presentation.hotelui.enrollavaluableroom;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import po.StrategyType;
import presentation.ClientMainApp;
import presentation.HotelMainApp;
import presentation.strategyui.model.Strategy;
import vo.RoomVO;
import vo.StrategyVO;

public class EnrollAvaluableRoomController {
	private HotelUIFactoryService hotelFactory;
	private ImportNewRoomService importNewRoom;
	private HotelMainApp mainApp;
	private String address;
	private RoomList roomList;
	private RoomVO selected;
	private ObservableList<Room> roomData = FXCollections.observableArrayList();

	public EnrollAvaluableRoomController(String address) {
		this.address = address;
	}
	@FXML
	private TableView<Room> avaluableRoomInfoTable;

	@FXML
	private TableColumn<Room, String> roomTypeColumn;
	@FXML
	private TableColumn<Room, String> roomNumColumn;
	@FXML
	private TableColumn<Room, String> roomPriceColumn;

	@FXML
	private Button cancelButton;

	@FXML
	private Button editButton;

	@FXML
	private Button addButton;

	@FXML
	private Label avaluableRoomListLabel;

	@FXML
	private Button confirmButton;

	@FXML
	void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		importNewRoom = hotelFactory.createImportNewRoomService();
		roomList = new RoomList();
		avaluableRoomInfoTable.setItems(roomData);
		roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
		roomNumColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumProperty());
		roomPriceColumn.setCellValueFactory(cellData -> cellData.getValue().roomPriceProperty());

	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void enrollAvaluableRoom() {
		ArrayList<RoomVO> roomVOs = importNewRoom.getAvailableRoomList(address);
		roomList.setRoomList(roomVOs);
		roomData.clear();
		roomData.addAll(roomList.getStrategyList());
	}

	@FXML
	void returnButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	void addNewRoomTypeButtonAction(ActionEvent event) {
		new AddRoomTypeController(address);
	}

	@FXML
	void editButtonAction(ActionEvent event) {
		try {
			this.selected = roomData.get(avaluableRoomInfoTable.getSelectionModel().getSelectedIndex()).toVO(address);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (selected != null)
			new EditRoomController(selected);
		else {
			 Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("wrong");
	            alert.setHeaderText("未选中房间类型！");
	            alert.setContentText("请重新选择！");
	            alert.show();
		}
	}
}
