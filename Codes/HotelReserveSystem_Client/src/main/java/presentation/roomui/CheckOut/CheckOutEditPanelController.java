package presentation.roomui.CheckOut;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CheckOutEditPanelController {
    
    @FXML
    private ChoiceBox<?> roomTypeChoiceBox;
    
    @FXML
    private TextField roomNumTextField;

    @FXML
    private DatePicker actDepartTimeDatepicker;
    
    @FXML
    private TextField hourTextField;

    @FXML
    private TextField minuteTxtField;

    @FXML
    void handleCanclel(ActionEvent event) {

    }

    @FXML
    void handleConfirm(ActionEvent event) {

    }

}
