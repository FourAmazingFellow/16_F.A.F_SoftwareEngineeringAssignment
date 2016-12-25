package presentation.hotelui.enrollavaluableroom;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.ImportNewRoomService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import po.RoomType;
import presentation.HotelMainApp;
import presentation.userui.JudgeFormat;
import vo.RoomVO;

/**
 * 酒店工作人员在录入可用客房界面下的新增房间界面
 * 
 * @author sparkler
 * @version
 * @see
 */
public class AddRoomTypeController {
	private HotelUIFactoryService hotelFactory;
	private ImportNewRoomService importNewRoom;
	private HotelMainApp mainApp;
	private String roomTypeStr;
	private RoomType roomType;
	public int roomNum;
	public int roomPrice;
	public String address;
	private RoomVO newRoom;
	private JudgeFormat judge = new JudgeFormat();

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
	public void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		importNewRoom = hotelFactory.createImportNewRoomService();

		// RoomType roomType = RoomType.KING_SIZE_ROOM;
		// int roomNum = 30;
		// int roomPrice = 150;
		// String address ="南京市栖霞区仙林大道163号";
		// importNewRoom = new ImportNewRoomServiceImpl_Stub(roomType, roomNum,
		// roomPrice, address);

		choiceBox.setItems(FXCollections.observableArrayList("单人房", "标准间", "三人房", "大床房"));
		choiceBox.getSelectionModel().select(0);
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}

	// 设置酒店地址
	public void setHotelAddress(String address) {
		this.address = address;
	}

	// 新增房型相关信息
	public void addRoomType() {
		// this.roomTypeStr = choiceBox.getTypeSelector();
		// this.roomTypeStr = "单人间";
		this.roomType = (RoomType) RoomType.chineseToEnum(roomTypeStr);

		if (roomNumberField.getText().equals("") || primePriceField.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}

		this.roomNum = Integer.parseInt(roomNumberField.getText());
		this.roomPrice = Integer.parseInt(primePriceField.getText());

		boolean isRoomNumValid = judge.isNumberPositive(roomNum);
		boolean isRoomPriceValid = judge.isNumberPositive(roomPrice);

		if (isRoomNumValid != true || isRoomPriceValid != true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("数据格式错误（必须是自然数）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		this.newRoom = null;
		this.newRoom = new RoomVO(roomType, roomNum, roomPrice, address);
		boolean result = false;
		try {
			result = importNewRoom.addRoom(newRoom);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (result == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("add info");
			alert.setHeaderText("添加成功！");
			alert.showAndWait();
			mainApp.showEnrollAvaluableRoomPanel();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("添加失败！");
			alert.setContentText("请重试！");
			alert.showAndWait();
			return;
		}

	}

	@FXML
	// 返回按钮操作，返回录入可用客房主界面（显示已有信息）
	void cancelButtonAction(ActionEvent event) {
		mainApp.showEnrollAvaluableRoomPanel();
	}

	@FXML
	// 确认按钮操作，确认添加新房型
	void confirmButtonAction(ActionEvent event) {
		addRoomType();
	}
}
