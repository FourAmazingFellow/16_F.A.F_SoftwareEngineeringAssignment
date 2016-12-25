package presentation.roomui.CheckOut;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.roomblservice.UpdateCheckOutService;
import factory.RoomUIFactoryService;
import factory.RoomUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import po.RoomType;
import presentation.HotelMainApp;
import presentation.roomui.CheckIn.ManageCheckInPanelController;
import presentation.roomui.CheckOut.model.CheckOut;
import presentation.roomui.CheckOut.model.CheckOutListWrapper;
import presentation.roomui.util.LocalDateAdapter;
import vo.RoomVO;

/**
 * 退房信息列表界面的控制类
 * @author 双
 * @version 
 * @see
 */
public class ManageCheckOutPanelController {

    @FXML
    private ChoiceBox<String> roomTypeChoiceBox;

    @FXML
    private DatePicker startDatePicker = new DatePicker();

    @FXML
    private DatePicker endDatePicker = new DatePicker(LocalDate.now());

    @FXML
    private TableView<CheckOut> checkOutTable;

    @FXML
    private TableColumn<CheckOut, String> actDepartTimeColumn;

    @FXML
    private TableColumn<CheckOut, String> roomTypeColumn;

    @FXML
    private TableColumn<CheckOut, String> roomNumColumn;

    private HotelMainApp mainApp;
    private ObservableList<String> roomTypeList = FXCollections.observableArrayList("全部房型", "单人间", "标准间", "三人间", "大床房");
    private ObservableList<CheckOut> checkOutdata = FXCollections.observableArrayList();
    private CheckOutListWrapper checkOutList;
    private String address;
    private RoomUIFactoryService roomUIFactoryService = new RoomUIFactoryServiceImpl();
    private UpdateCheckOutService updateCheckOutService = roomUIFactoryService.createUpdateCheckOutService();

    @FXML
    private void initialize() {
        checkOutList = new CheckOutListWrapper();

        // Initialize the checkInTable and its columns.
        checkOutTable.setItems(checkOutdata);

        actDepartTimeColumn.setCellValueFactory(cellData -> cellData.getValue().actDepartTimeProperty());
        roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        roomNumColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumProperty());

        // Initialize the choiceBox
        roomTypeChoiceBox.setItems(roomTypeList);
        // 为roomTypeChoiceBox增加监听
        roomTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            handleSearchByRoomType(roomTypeList.get((int) newValue));
        });
        roomTypeChoiceBox.setTooltip(new Tooltip("选择某房间类型显示对应退房信息"));
        startDatePicker.setEditable(false);
        endDatePicker.setEditable(false);
    }

    public void setMainApp(HotelMainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void showCheckOutList(ArrayList<RoomVO> checkOutVOs) {
        checkOutdata.clear();
        checkOutList.setCheckOutList(checkOutVOs);
        checkOutdata.addAll(checkOutList.getCheckOutList());
    }

    public void showAllCheckOutList(String address) {
        this.address = address;
        // 从bl层获得数据，并添加到checkOutData中
        try {
            ArrayList<RoomVO> allCheckOutVOs = updateCheckOutService.getCheckOutList(address);
            showCheckOutList(allCheckOutVOs);
        } catch (RemoteException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
        }
    }

    // roomTypeChoiceBox的事件行为
    void handleSearchByRoomType(String roomTypeStr) {
        // 如果之前搜索过，为了避免歧义，把之前搜索的时间选择器的值设成null
        if (startDatePicker.getValue() != null) {
            startDatePicker.setValue(null);
        }
        if (endDatePicker.getValue() != null) {
            endDatePicker.setValue(null);
        }
        if (roomTypeStr.equals("全部房型")) {
            showAllCheckOutList(address);
            return;
        }
        Enum<RoomType> roomType = RoomType.chineseToEnum(roomTypeStr);

        try {
            ArrayList<RoomVO> searchedCheckOutVOs = updateCheckOutService.searchCheckOutInfo(address, roomType);
            showCheckOutList(searchedCheckOutVOs);
        } catch (RemoteException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
        }
    }

    @FXML
    void handleSearchWithExpDepartime() {
        Date startDate = null, endDate = null;
        // 判断时间是否为空，是否合适
        LocalDate startTime = startDatePicker.getValue();
        LocalDate endTime = endDatePicker.getValue();
        startDate = LocalDateAdapter.toDate(startTime);
        endDate = LocalDateAdapter.toDate(endTime);
        if (!validStartAndEndDate(startDate, endDate)) {
            return;
        }
        try {
            ArrayList<RoomVO> searchedCheckOutVOsbyTime = updateCheckOutService.searchCheckOutInfo(address, startDate,
                    endDate);
            showCheckOutList(searchedCheckOutVOsbyTime);
        } catch (RemoteException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
        }
    }

    @FXML
    void handleNewCheckOut(ActionEvent event) {
        int selectedIndex = roomTypeChoiceBox.getSelectionModel().getSelectedIndex();
        CheckOut tmpCheckOut;
        if (selectedIndex >= 0) {
            tmpCheckOut = new CheckOut(RoomType.chineseToEnum(roomTypeChoiceBox.getItems().get(selectedIndex)), 0,
                    null);
        } else {
            tmpCheckOut = new CheckOut();
        }
        boolean isConfirmed = mainApp.showCheckOutEditDialog(tmpCheckOut);
        if (isConfirmed) {
            checkOutTable.getItems().add(tmpCheckOut);
        }
    }

    private static boolean validStartAndEndDate(Date startDate, Date endDate) {
        return ManageCheckInPanelController.validStartAndEndDate(startDate, endDate);
    }

}
