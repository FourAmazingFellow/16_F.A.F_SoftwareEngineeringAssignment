package presentation.roomui.CheckIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageCheckInPanelController {
    
    @FXML
    private ChoiceBox<?> roomTypeChoiceBox;
    
    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TableView<?> checkInTable;
    
    @FXML
    private TableColumn<?, ?> checkInTimeColumn;
    
    @FXML
    private TableColumn<?, ?> roomTypeColumn;

    @FXML
    private TableColumn<?, ?> roomNumColumn;

    @FXML
    private TableColumn<?, ?> expDepartTimeColumn;

    @FXML
    void handleSearchWithDate(ActionEvent event) {

    }

    @FXML
    void handleNewCheckIn(ActionEvent event) {

    }

}
