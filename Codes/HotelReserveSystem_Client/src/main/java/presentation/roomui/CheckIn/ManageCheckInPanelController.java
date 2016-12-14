package presentation.roomui.CheckIn;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.strategybl.exception.WrongInputException;
import businesslogicservice.roomblservice.UpdateCheckInService;
import factory.RoomUIFactoryService;
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
import presentation.ClientMainApp;
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

    private ClientMainApp mainApp;
    private ObservableList<String> roomTypeList = FXCollections.observableArrayList("全部房型",
            "单人间", "标准间", "三人间","大床房");
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
        roomTypeChoiceBox.setTooltip(new Tooltip("show check in list of selected roomType"));
    }

    public void setMainApp(ClientMainApp mainApp) {
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
        if (roomTypeStr.equals( "全部房型")) {
            showAllCheckInList(address);
        }
        Enum<RoomType> roomType=RoomType.chineseToEnum(roomTypeStr);
        
        ArrayList<RoomVO> searchedCheckInVOs = updateCheckInService.searchCheckInInfo(address,
                roomType);
        showCheckInList(searchedCheckInVOs);
    }

    @FXML
    void handleSearchWithDate() {
        Date startDate=null,endDate=null;
        //判断时间是否为空，是否合适
        boolean isValid=false;
        while(!isValid){
            LocalDate startTime = startDatePicker.getValue();
            LocalDate endTime = endDatePicker.getValue();
            startDate=LocalDateAdapter.toDate(startTime);
            endDate=LocalDateAdapter.toDate(endTime);
            if(validStartAndEndDate(startDate, endDate)){
                isValid=true;
            }
        }
        ArrayList<RoomVO> searchedCheckInVOsbyTime = updateCheckInService.searchCheckInInfo(address,
                startDate,endDate);
        showCheckInList(searchedCheckInVOsbyTime);
    }

    @FXML
    void handleNewCheckIn() {
        int selectedIndex = checkInTable.getSelectionModel().getSelectedIndex();
        CheckIn tmpCheckIn;
        if(selectedIndex>=0){
            tmpCheckIn=new CheckIn(checkInTable.getItems().get(selectedIndex).getRoomType(),0,null,null);
        }else{
            tmpCheckIn=new CheckIn();
        }
        boolean isConfirmed=mainApp.showCheckInEditDialog(tmpCheckIn, address);
        if(isConfirmed){
            checkIndata.add(tmpCheckIn);
        }
    }

    public static boolean validStartAndEndDate(Date startDate,Date endDate){
        if(startDate==null||endDate==null){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("搜索信息错误");
            alert.setHeaderText("搜索的时间为空");
            alert.setContentText("请输入搜索的开始时间和结束时间");

            alert.showAndWait();
            return false;
        }else if(endDate.compareTo(new Date())>0){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("搜索信息错误");
            alert.setHeaderText("搜索的结束时间不合理");
            alert.setContentText("搜索的结束时间应该不大于当前时间");

            alert.showAndWait();
            return false;
        }else if(endDate.compareTo(startDate)<0){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("搜索信息错误");
            alert.setHeaderText("搜索的开始时间和结束时间不合理");
            alert.setContentText("搜索的结束时间应该大于或等于开始时间");

            alert.showAndWait();
            return false;
        }
        return true;
    }
    /*
    //mainApp要添加的方法
    public void showManageCheckInPanel(String address) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClientMainApp.class.getResource("roomui/CheckIn/ManageCheckInPanel.fxml"));
            AnchorPane manageCheckInPanel = (AnchorPane) loader.load();

            HotelStaffRootLayout.setCenter(manageCheckInPanel);
            
            // Give the controller access to the main app.
            ManageCheckInPanelController controller = loader.getController();
            controller.setMainApp(this);
            //默认显示所有订单
            controller.showAllCheckInList(address);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}
