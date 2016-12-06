package presentation.orderui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class BrowseAbnormalOrderPanel {

    @FXML
    private TableColumn<?, ?> numColumn;

    @FXML
    private TableColumn<?, ?> HotelAddressColumn;

    @FXML
    private Button searchButton;

    @FXML
    private TableColumn<?, ?> roomTypeColumn;

    @FXML
    private TableColumn<?, ?> totalPriceColumn;

    @FXML
    private TableColumn<?, ?> beginDateColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField searchTextArea;

    @FXML
    private TableColumn<?, ?> hotelNameColumn;

    @FXML
    private Button detailedOrderButton;

    @FXML
    private TableColumn<?, ?> finishDateColumn;

    @FXML
    private Button withdrawButton;

    @FXML
    private Button returnButton;

    @FXML
    private TableColumn<?, ?> userIDColumn;

}
