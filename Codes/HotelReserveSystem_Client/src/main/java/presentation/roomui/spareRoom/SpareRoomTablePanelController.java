package presentation.roomui.spareRoom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SpareRoomTablePanelController {
    
    @FXML
    private TableView<?> spareRoomTable;

    @FXML
    private TableColumn<?, ?> roomTypeColumn;

    @FXML
    private TableColumn<?, ?> roomNumColumn;
    
    @FXML
    private TableColumn<?, ?> roomPriceColumn;

    @FXML
    void handleNewCheckIn(ActionEvent event) {

    }

}
