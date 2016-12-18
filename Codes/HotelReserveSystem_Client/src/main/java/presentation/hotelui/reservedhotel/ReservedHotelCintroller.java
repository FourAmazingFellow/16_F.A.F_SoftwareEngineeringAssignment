package presentation.hotelui.reservedhotel;

import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import businesslogicservice.hotelblservice.ManageHotelInfoService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import presentation.HotelMainApp;

public class ReservedHotelCintroller {
	private HotelUIFactoryService hotelFactory;
	private CheckOrderedHotelService checkOrderedHotel;
	private HotelMainApp mainApp;

	@FXML
	private Tab abnormalTab;

	@FXML
	private Tab undoTab;

	@FXML
	private Tab normalTab;

	@FXML
	private TableView<?> orderDetailTableAbnormal;

	@FXML
	private TableView<?> orderDetailTableNormal;

	@FXML
	private TabPane orderListTab;

	@FXML
	private TableView<?> orderDetailTableAll;

	@FXML
	private Button orderDoneButton;

	@FXML
	private Tab allTab;

	@FXML
	private TableView<?> orderDetailTableUndo;

	@FXML
	private Button hotelDetailButton;

	@FXML
	void hotelDetailButtonAction(ActionEvent event) {

	}

	@FXML
	void orderDoneButtonAction(ActionEvent event) {

	}

	@FXML
	void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		checkOrderedHotel = hotelFactory.createCheckOrderedHotelService();
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}
}
