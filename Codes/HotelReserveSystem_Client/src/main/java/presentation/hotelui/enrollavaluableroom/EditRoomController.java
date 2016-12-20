package presentation.hotelui.enrollavaluableroom;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.ImportNewRoomService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import po.RoomType;
import presentation.HotelMainApp;
import vo.RoomVO;

public class EditRoomController {
	private HotelUIFactoryService hotelFactory;
	private ImportNewRoomService importNewRoom;
	private HotelMainApp mainApp;
	private RoomVO selected;
	private int roomNumm, roomPricem;

	public EditRoomController(RoomVO selected) {
		this.selected = selected;
	}

	@FXML
	private Button cancelButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Label avaluableRoomListLabel;

	@FXML
	private Button saveButton;

	@FXML
	private TextField roomPriceField;

	@FXML
	private TextField roomNumField;

	@FXML
	private Label roomTypeLabel;

	@FXML
	public void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		importNewRoom = hotelFactory.createImportNewRoomService();
		
		roomTypeLabel.setText(RoomType.enumToChinese(selected.roomType));
		roomNumField.setText(String.valueOf(selected.roomNum));
		roomPriceField.setText(String.valueOf(selected.roomPrice));
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void editRoomType() {
		this.roomNumm = Integer.parseInt(roomNumField.getText());
		this.roomPricem = Integer.parseInt(roomPriceField.getText());
		RoomVO modified = new RoomVO(RoomType.chineseToEnum(roomTypeLabel.getText()), roomNumm, roomPricem, selected.address);
		boolean result = false;
		try {
			result = importNewRoom.addRoom(modified);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (result == false) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("修改失败！");
			alert.setContentText("请重试！");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("modify info");
			alert.setHeaderText("修改成功！");
			alert.show();
		}
	}
	
	@FXML
	void cancelButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	void deleteButtonAction(ActionEvent event) {
		RoomVO deleted = new RoomVO(selected.roomType, 0, selected.roomPrice, selected.address);
		boolean result = false;
		try {
			result = importNewRoom.addRoom(deleted);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (result == false) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("删除失败！");
			alert.setContentText("请重试！");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("delete info");
			alert.setHeaderText("删除成功！");
			alert.show();
		}
	}

	@FXML
	void saveButtonAction(ActionEvent event) throws RemoteException {
		editRoomType();
	}
}
