package presentation.orderui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class BrowseHotelOrderPanelController {

	 @FXML
	    private TableColumn<?, ?> numColumn;

	    @FXML
	    private Button searchButton;

	    @FXML
	    private TableColumn<?, ?> roomTypeColumn;

	    @FXML
	    private ChoiceBox<?> rankTypeChoiceBox;

	    @FXML
	    private TableColumn<?, ?> hotelAddressColumn;

	    @FXML
	    private TableColumn<?, ?> totalPriceColumn;

	    @FXML
	    private TableColumn<?, ?> beginDateColumn;

	    @FXML
	    private TextField searchTextField;

	    @FXML
	    private ChoiceBox<?> orderTypeChoiceBox;

	    @FXML
	    private TableColumn<?, ?> hotelNameColumn;

	    @FXML
	    private TableColumn<?, ?> finishDateColumn;

	    @FXML
	    private Button returnButton;
	    
	    @FXML
	    private Button getDetailedOrderButton;
	    
	    @FXML
	    private Button getOrderDoneButton;
}
