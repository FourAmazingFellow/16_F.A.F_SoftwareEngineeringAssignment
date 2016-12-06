package presentation.orderui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

public class BrowseHotelOrderPanelController {

    @FXML
    private TableColumn<?, ?> numColumn;

    @FXML
    private TableColumn<?, ?> roomTypeColumn;

    @FXML
    private ComboBox<?> rankTypeComboBox;

    @FXML
    private TableColumn<?, ?> totalPriceColumn;

    @FXML
    private TableColumn<?, ?> beginDateColumn;

    @FXML
    private TableColumn<?, ?> finishDateColumn;

    @FXML
    private TableColumn<?, ?> orderIDColumn;

    @FXML
    private Button getDetailedOrderButton;

    @FXML
    private Button returnButton;

    @FXML
    private TableColumn<?, ?> userIDColumn;

    @FXML
    private ComboBox<?> orderTypeComboBox;

}
