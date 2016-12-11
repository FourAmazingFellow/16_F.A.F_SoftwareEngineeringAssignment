package presentation.roomui.spareRoom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.MainApp;
import presentation.roomui.spareRoom.model.SpareRoom;
import presentation.roomui.spareRoom.model.SpareRoomListWrapper;

public class SpareRoomTablePanelController {
    
    @FXML
    private TableView<SpareRoom> spareRoomTable;

    @FXML
    private TableColumn<SpareRoom, String> roomTypeColumn;

    @FXML
    private TableColumn<SpareRoom, String> roomNumColumn;
    
    @FXML
    private TableColumn<SpareRoom, String> roomPriceColumn;
    
    private MainApp mainApp;
    private ObservableList<SpareRoom> spareRoomData=FXCollections.observableArrayList();
    private SpareRoomListWrapper spareRoomList;
    private String address;

    @FXML
    private void initialize() {
        spareRoomList=new SpareRoomListWrapper();
        // Initialize the spareRoomTable and its columns.
        spareRoomTable.setItems(spareRoomData);
        
        roomNumColumn.setCellValueFactory(cellData->cellData.getValue().roomNumProperty());
        roomTypeColumn.setCellValueFactory(cellData->cellData.getValue().roomTypeProperty());
        roomPriceColumn.setCellValueFactory(cellData->cellData.getValue().roomPriceProperty());

    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
    }
    
    public void showSpareRoomList(String address){
        this.address=address;
        //从bl层获得数据，并添加到spareRoomData中
        spareRoomList.setSpareRoomListFromData(address);
        spareRoomData.addAll(spareRoomList.getSpareRoomList());
    }
    
    @FXML
    void handleNewCheckIn(ActionEvent event) {
        
    }
    /*
    public void showSpareRoomTablePanel(String address){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("roomui/spareRoom/SpareRoomTablePanel.fxml"));
            AnchorPane browseSpareRoomPanel = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(browseSpareRoomPanel);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            SpareRoomTablePanelController spareRoomController = loader.getController();
            spareRoomController.setMainApp(this);
            //默认显示空房列表
            spareRoomController.showSpareRoomList(address);;

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

}
