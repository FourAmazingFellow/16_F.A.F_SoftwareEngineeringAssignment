package presentation.orderui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import vo.BriefOrderInfoVO;

public class BrowseUserOrderPanelController {

    @FXML
    private TableColumn<?, ?> hotelNameColumn;

    @FXML
    private TableColumn<?, ?> numColumn;

    @FXML
    private TableColumn<?, ?> roomTypeColumn;

    @FXML
    private ComboBox<?> rankTypeComboBox;

    @FXML
    private TableColumn<?, ?> hotelAddressColumn;

    @FXML
    private TableColumn<?, ?> totalPriceColumn;

    @FXML
    private TableColumn<?, ?> beginDateColumn;

    @FXML
    private TableColumn<?, ?> finishDateColumn;

    @FXML
    private Button getDetailedOrderButton;

    @FXML
    private Button returnButton;

    @FXML
    private ComboBox<?> orderTypeComboBox;

    private ObservableList<BriefOrderInfoVO> briefOrderList = FXCollections.observableArrayList();
}
