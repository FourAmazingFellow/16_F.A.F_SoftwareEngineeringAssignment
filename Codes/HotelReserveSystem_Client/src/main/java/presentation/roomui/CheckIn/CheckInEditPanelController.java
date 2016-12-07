package presentation.roomui.CheckIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CheckInEditPanelController {
    
    @FXML
    private ChoiceBox<?> roomTypeChoiceBox;
    
    @FXML
    private TextField roomNumTextField;
    
    @FXML
    private DatePicker checkInTimeDatepicker;
    
    @FXML
    private TextField hourTextField1;

    @FXML
    private TextField minuteTxtField1;
    
    @FXML
    private DatePicker expDepartTimeDatepicker;

    @FXML
    private TextField hourTextField2;

    @FXML
    private TextField minuteTxtField2;

    @FXML
    void handleCancel(ActionEvent event) {

    }

    @FXML
    void handleConfirm(ActionEvent event) {

    }
    
}
