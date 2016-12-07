package presentation.roomui.CheckOut;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageCheckOutPanelController {
    
    @FXML
    private ChoiceBox<?> roomTypeChoiceBox;
    
    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;
    
    @FXML
    private TableView<?> checkOutTable;
    
    @FXML
    private TableColumn<?, ?> actDepartTimeColumn;

    @FXML
    private TableColumn<?, ?> roomTypeColumn;

    @FXML
    private TableColumn<?, ?> roomNumColumn;

    @FXML
    void handleSearchWithExpDepartime(ActionEvent event) {

    }

    @FXML
    void handleNewCheckOut(ActionEvent event) {

    }

}
