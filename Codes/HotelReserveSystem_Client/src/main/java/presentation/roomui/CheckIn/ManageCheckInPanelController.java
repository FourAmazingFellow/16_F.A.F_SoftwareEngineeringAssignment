package presentation.roomui.CheckIn;

import java.time.LocalDate;
import java.util.ArrayList;

import businesslogicservice.roomblservice.UpdateCheckInService;
import factory.RoomUIFactoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import po.RoomType;
import presentation.MainApp;
import presentation.roomui.CheckIn.model.CheckIn;
import presentation.roomui.CheckIn.model.CheckInListWrapper;
import presentation.roomui.util.LocalDateAdapter;
import vo.RoomVO;

public class ManageCheckInPanelController {

    @FXML
    private ChoiceBox<String> roomTypeChoiceBox;

    @FXML
    private DatePicker startDatePicker = new DatePicker();

    @FXML
    private DatePicker endDatePicker = new DatePicker(LocalDate.now());

    @FXML
    private TableView<CheckIn> checkInTable;

    @FXML
    private TableColumn<CheckIn, String> checkInTimeColumn;

    @FXML
    private TableColumn<CheckIn, String> roomTypeColumn;

    @FXML
    private TableColumn<CheckIn, String> roomNumColumn;

    @FXML
    private TableColumn<CheckIn, String> expDepartTimeColumn;

    private MainApp mainApp;
    private ObservableList<String> roomTypeList = FXCollections.observableArrayList("allRoomType",
            RoomType.SINGLE_ROOM.name(), RoomType.STANDARD_ROOM.name(), RoomType.TRIBLE_ROOM.name(),
            RoomType.KING_SIZE_ROOM.name());
    private ObservableList<CheckIn> checkIndata = FXCollections.observableArrayList();
    private CheckInListWrapper checkInList;
    private String address;
    private RoomUIFactoryService roomUIFactoryService;
    private UpdateCheckInService updateCheckInService = roomUIFactoryService.createUpdateCheckInService();

    @FXML
    private void initialize() {
        checkInList = new CheckInListWrapper();

        // Initialize the checkInTable and its columns.
        checkInTable.setItems(checkIndata);

        checkInTimeColumn.setCellValueFactory(cellData -> cellData.getValue().checkInTimeProperty());
        roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        roomNumColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumProperty());
        expDepartTimeColumn.setCellValueFactory(cellData -> cellData.getValue().expDepartTimeProperty());

        // Initialize the choiceBox
        roomTypeChoiceBox.setItems(roomTypeList);
        // 为roomTypeChoiceBox增加监听
        roomTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            handleSearchByRoomType(newValue.toString());
        });
        roomTypeChoiceBox.setTooltip(new Tooltip("select the RoomType"));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void showCheckInList(ArrayList<RoomVO> checkInVOs) {
        checkInList.setCheckInList(checkInVOs);
        checkIndata.addAll(checkInList.getCheckInList());
    }

    public void showAllCheckInList(String address) {
        this.address = address;
        // 从bl层获得数据，并添加到checkInData中
        ArrayList<RoomVO> allCheckInVOs = updateCheckInService.getCheckInList(address);
        showCheckInList(allCheckInVOs);
    }

    // roomTypeChoiceBox的事件行为
    void handleSearchByRoomType(String roomTypeStr) {
        if (roomTypeStr == "allRoomType") {
            showAllCheckInList(address);
        }
        ArrayList<RoomVO> searchedCheckInVOs = updateCheckInService.searchCheckInInfo(address,
                RoomType.valueOf(roomTypeStr));
        showCheckInList(searchedCheckInVOs);
    }

    @FXML
    void handleSearchWithDate(ActionEvent event) {
        LocalDate startTime = startDatePicker.getValue();
        LocalDate endTime = endDatePicker.getValue();
        //判断时间是否为空，是否合适
        ArrayList<RoomVO> searchedCheckInVOsbyTime = updateCheckInService.searchCheckInInfo(address,
                LocalDateAdapter.toDate(startTime), LocalDateAdapter.toDate(endTime));
        showCheckInList(searchedCheckInVOsbyTime);
    }

    @FXML
    void handleNewCheckIn(ActionEvent event) {

    }

}
