package presentation.hotelui.reservedhotel;

import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import businesslogicservice.hotelblservice.ManageHotelInfoService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import po.OrderType;
import presentation.ClientMainApp;
import presentation.HotelMainApp;
import presentation.orderui.FxBriefOrder;

public class ReservedHotelCintroller {
	private HotelUIFactoryService hotelFactory;
	private CheckOrderedHotelService checkOrderedHotel;
	private HotelMainApp mainApp;
	private ObservableList<FxBriefOrder> orderList = FXCollections.observableArrayList();

	@FXML
	private TabPane orderListTab;
	@FXML
	private Tab allTab;
	@FXML
	private Tab abnormalTab;

	@FXML
	private Tab undoTab;

	@FXML
	private Tab normalTab;

	@FXML
	private Button hotelDetailButton;

	@FXML
	private Button orderDoneButton;

	@FXML
	private TableView<?> orderDetailTableAll;

	@FXML
	private TableView<?> orderDetailTableNormal;

	@FXML
	private TableView<?> orderDetailTableAbmormal;

	@FXML
	private TableView<?> orderDetailTableUndo;

	@FXML
	private TableColumn<?, ?> tagColumn2;

	@FXML
	private TableColumn<?, ?> tagColumn3;

	@FXML
	private TableColumn<?, ?> tagColumn1;

	@FXML
	private TableColumn<?, ?> hotelAddressColumn;

	@FXML
	private TableColumn<?, ?> tagColumn;

	@FXML
	private TableColumn<?, ?> tradeAreaColumn3;

	@FXML
	private TableColumn<?, ?> tradeAreaColumn2;

	@FXML
	private TableColumn<?, ?> tradeAreaColumn;

	@FXML
	private TableColumn<?, ?> tradeAreaColumn1;

	@FXML
	private TableColumn<?, ?> hotelStarColumn;

	@FXML
	private TableColumn<?, ?> hotelAddressColumn2;

	@FXML
	private TableColumn<?, ?> hotelAddressColumn3;

	@FXML
	private TableColumn<?, ?> hotelNameColumn1;

	@FXML
	private TableColumn<?, ?> hotelNameColumn2;

	@FXML
	private TableColumn<?, ?> hotelNameColumn3;

	@FXML
	private TableColumn<?, ?> hotelAddressColumn1;

	@FXML
	private TableColumn<?, ?> hotelStarColumn1;

	@FXML
	private TableColumn<?, ?> hotelMarkColumn1;

	@FXML
	private TableColumn<?, ?> hotelStarColumn3;

	@FXML
	private TableColumn<?, ?> hotelStarColumn2;

	@FXML
	private TableColumn<?, ?> hotelMarkColumn2;

	@FXML
	private TableColumn<?, ?> hotelMarkColumn3;

	@FXML
	private TableColumn<?, ?> hotelNameColumn;

	@FXML
	private TableColumn<?, ?> hotelMarkColumn;

	@FXML
	void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		checkOrderedHotel = hotelFactory.createCheckOrderedHotelService();
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	void hotelDetailButtonAction(ActionEvent event) {

	}

	@FXML
	void orderDoneButtonAction(ActionEvent event) {

	}
}
