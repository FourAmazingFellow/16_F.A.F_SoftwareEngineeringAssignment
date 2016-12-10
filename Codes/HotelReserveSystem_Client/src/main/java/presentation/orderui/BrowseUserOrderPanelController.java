package presentation.orderui;

import java.util.ArrayList;

import org.controlsfx.dialog.Dialogs;

import businesslogicservice.orderblservice.BrowseUserOrderService;
import factory.OrderUIFactoryService;
import factory.OrderUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import po.OrderType;
import presentation.MainApp;
import vo.BriefOrderInfoVO;

public class BrowseUserOrderPanelController {

	@FXML
	private TableView<FxBriefOrder> userOrders;

	@FXML
	private TableColumn<FxBriefOrder, String> numColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> roomTypeColumn;

	@FXML
	private ChoiceBox<String> rankTypeChoiceBox;

	@FXML
	private TableColumn<FxBriefOrder, String> totalPriceColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> beginDateColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> finishDateColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> hotelNameColumn;

	@FXML
	private ChoiceBox<String> orderTypeChoiceBox;

	@FXML
	private Button getDetailedOrderButton;

	@FXML
	private Button returnButton;

	@FXML
	private TableColumn<FxBriefOrder, String> userIDColumn;

	private ObservableList<FxBriefOrder> briefFxOrderList = FXCollections.observableArrayList();

	private OrderUIFactoryService factory;

	private BrowseUserOrderService browseHelper;

	private MainApp mainApp;
	
	@FXML
	public void initialize() {
		factory = new OrderUIFactoryServiceImpl();
		browseHelper = factory.createBrowseUserOrderService();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void showBriefOrderList(String userID, OrderType orderType) {
		BriOrderVO2Fx trans = new BriOrderVO2Fx();
		ArrayList<BriefOrderInfoVO> list = browseHelper.getUserOrderList(userID, orderType);
		for (BriefOrderInfoVO vo : list) {
			briefFxOrderList.add(trans.briefOrderVO2Fx(vo));
		}

		userOrders.setItems(briefFxOrderList);

		userIDColumn.setCellValueFactory(cellData -> cellData.getValue().getUserID());
		hotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().getHotelName());
		beginDateColumn.setCellValueFactory(cellData -> cellData.getValue().getBeginDate());
		finishDateColumn.setCellValueFactory(cellData -> cellData.getValue().getFinishDate());
		roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getRoomType());
		numColumn.setCellValueFactory(cellData -> cellData.getValue().getNum());
		totalPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getTotalPrice());
	}

	public void returnButtonAction() {
		//TO-DO
		mainApp.showSearchView();
	}
	
	public void showDetailedOrder() {
		int selectedIndex = userOrders.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			String orderID = userOrders.getItems().get(selectedIndex).getOrderID().toString();
			System.out.println("请求查看订单号为" + orderID + "的订单详情");
			mainApp.showDetailedOrderPanel(orderID);
		} else {
			// Nothing selected.
			Dialogs.create()
		        .title("No Selection")
		        .masthead("No Person Selected")
		        .message("Please select a person in the table.")
		        .showWarning();
		}
	}
}
