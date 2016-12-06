package presentation.orderui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class CreateOrderPanelController {

    @FXML
    private ChoiceBox<?> latestOrderDoneTimeChoicer;

    @FXML
    private Label hotelNameLabel;

    @FXML
    private ChoiceBox<?> isChildrenChoicer;

    @FXML
    private DatePicker beginDatePicker;

    @FXML
    private ChoiceBox<?> numChoicer;

    @FXML
    private Label hotelAddressLabel;

    @FXML
    private Button createOrderButton;

    @FXML
    private DatePicker finishDatePicker;

    @FXML
    private ChoiceBox<?> numOfPersonChoicer;

    @FXML
    private Button returnButton;

    @FXML
    private Label priceLabel;

    @FXML
    private ChoiceBox<?> roomTypeChoicer;

}
