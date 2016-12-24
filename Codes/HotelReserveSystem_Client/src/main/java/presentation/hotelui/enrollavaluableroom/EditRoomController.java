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
import presentation.userui.JudgeFormat;
import vo.RoomVO;

public class EditRoomController {
	private HotelUIFactoryService hotelFactory;
	private ImportNewRoomService importNewRoom;
	private HotelMainApp mainApp;
	private RoomVO selected;
	private RoomVO modified;
	private RoomVO deleted;
	private int roomNumm, roomPricem;
	private JudgeFormat judge = new JudgeFormat();

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
//		 RoomType roomType = RoomType.KING_SIZE_ROOM;
//		 int roomNum = 30;
//		 int roomPrice = 150;
//		 String address  ="南京市栖霞区仙林大道163号";
//		importNewRoom = new ImportNewRoomServiceImpl_Stub(roomType, roomNum, roomPrice, address);
		
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void showPreInfo(RoomVO selected) {
		this.selected = selected;
		roomTypeLabel.setText(RoomType.enumToChinese(selected.roomType));
		roomNumField.setText(String.valueOf(selected.roomNum));
		roomPriceField.setText(String.valueOf(selected.roomPrice));
	}

	// 编辑某一种房型
	public void editRoomType() {
		if (roomNumField.getText().equals("") || roomPriceField.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		this.roomNumm = Integer.parseInt(roomNumField.getText());
		this.roomPricem = Integer.parseInt(roomPriceField.getText());

		boolean isRoomNumValid = judge.isNumberPositive(roomNumm);
		boolean isRoomPriceValid = judge.isNumberPositive(roomPricem);
		
		if(isRoomNumValid != true || isRoomPriceValid !=true){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("数据格式错误（必须是自然数）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		
		this.modified = null;
		this.modified = new RoomVO(RoomType.chineseToEnum(roomTypeLabel.getText()), roomNumm, roomPricem,
				selected.address);
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
			alert.showAndWait();
			return;
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("modify info");
			alert.setHeaderText("修改成功！");
			alert.showAndWait();
			mainApp.showEnrollAvaluableRoomPanel();
		}
	}

	@FXML
	void cancelButtonAction(ActionEvent event) {
		mainApp.showEnrollAvaluableRoomPanel();
	}

	@FXML
	// 删除某一种房型
	void deleteButtonAction(ActionEvent event) {
		this.deleted = null;
		this.deleted = new RoomVO(selected.roomType, 0, selected.roomPrice, selected.address);
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
			alert.showAndWait();
			return;
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("delete info");
			alert.setHeaderText("删除成功！");
			alert.showAndWait();
			mainApp.showEnrollAvaluableRoomPanel();
		}
	}

	@FXML
	void saveButtonAction(ActionEvent event) throws RemoteException {
		editRoomType();
	}
}
