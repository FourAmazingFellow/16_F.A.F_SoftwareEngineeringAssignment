package presentation.orderui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import vo.BriefOrderInfoVO;

public class BrowseUserOrderPanelController {

	@FXML
    private TableColumn<?, ?> numColumn;

    @FXML
    private TableColumn<?, ?> roomTypeColumn;

    @FXML
    private ChoiceBox<?> rankTypeChoiceBox;

    @FXML
    private TableColumn<?, ?> totalPriceColumn;

    @FXML
    private TableColumn<?, ?> beginDateColumn;

    @FXML
    private TableColumn<?, ?> finishDateColumn;

    @FXML
    private TableColumn<?, ?> orderIDColumn;

    @FXML
    private ChoiceBox<?> orderTypeChoiceBox;

    @FXML
    private Button getDetailedOrderButton;

    @FXML
    private Button returnButton;

    @FXML
    private TableColumn<?, ?> userIDColumn;

    private ObservableList<BriefOrderInfoVO> briefOrderList = FXCollections.observableArrayList();
}
