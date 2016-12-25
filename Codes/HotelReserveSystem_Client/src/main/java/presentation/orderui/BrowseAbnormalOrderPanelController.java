package presentation.orderui;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.orderblservice.CheckAbnormalOrderService;
import factory.OrderUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import presentation.WebsitePromotionMainApp;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseAbnormalOrderPanelController {
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private TableView<FxBriefOrder> abnormalOrderTableView;

	@FXML
	private TableColumn<FxBriefOrder, String> numColumn;

	@FXML
	private Button searchButton;

	@FXML
	private TableColumn<FxBriefOrder, String> roomTypeColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> hotelAddressColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> totalPriceColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> beginDateColumn;

	@FXML
	private TextField searchTextField;

	@FXML
	private TableColumn<FxBriefOrder, String> hotelNameColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> userIDColumn;
	
	@FXML
	private TableColumn<FxBriefOrder, String> finishDateColumn;

	@FXML
	private Button returnButton;

	@FXML
	private Button getDetailedOrderButton;

	private WebsitePromotionMainApp mainApp;

	private OrderUIFactoryServiceImpl factory;
	
	ArrayList<BriefOrderInfoVO> list;

	private CheckAbnormalOrderService abnormalOrderBrowser;

	@FXML
	public void initialize() {
		factory = new OrderUIFactoryServiceImpl();
		abnormalOrderBrowser = factory.createBrowseAbnormalOrderService();
		datePicker.setValue(LocalDate.now());
		datePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isAfter(LocalDate.now())) {
							setDisable(true);
							setStyle("-fx-background-color: rgb(160,160,160);");
						}
					}
				};
			}
		});
	}

	@SuppressWarnings("deprecation")
	public void pickDateAction() {
		LocalDate l = datePicker.getValue();
		Date pickedDate = new Date(l.getYear() - 1900, l.getMonthValue() - 1, l.getDayOfMonth());
		getBriefAbnormalOrderList(pickedDate);
	}
	
	public void setMainApp(WebsitePromotionMainApp websitePromotionMainApp) {
		this.mainApp = websitePromotionMainApp;
	}

	public void getBriefAbnormalOrderList(Date date) {
		try {
			list = abnormalOrderBrowser.getAbnormalOrderList(date);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
		}
		showBriefOrderList();
	}
	
	private void showBriefOrderList() {

		BriOrderVO2Fx trans = new BriOrderVO2Fx();
		ObservableList<FxBriefOrder> briefFxOrderList = FXCollections.observableArrayList();

		for (BriefOrderInfoVO vo : list) {
			briefFxOrderList.add(trans.briefOrderVO2Fx(vo));
		}
		abnormalOrderTableView.setItems(briefFxOrderList);

		userIDColumn.setCellValueFactory(cellData -> cellData.getValue().getUserID());
		hotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().getHotelName());
		hotelAddressColumn.setCellValueFactory(cellData -> cellData.getValue().getHotelAddress());
		beginDateColumn.setCellValueFactory(cellData -> cellData.getValue().getBeginDate());
		finishDateColumn.setCellValueFactory(cellData -> cellData.getValue().getFinishDate());
		roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getRoomType());
		numColumn.setCellValueFactory(cellData -> cellData.getValue().getNum());
		totalPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getTotalPrice());
	}

	public void searchOrderByID() {
		String orderID = searchTextField.getText();
		OrderVO vo = null;
		try {
			vo = abnormalOrderBrowser.getDetailedOrder(orderID);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
		}
		if (vo == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("订单号错误");
			alert.setHeaderText("订单号不存在或无访问权限！");
			alert.setContentText("请查证后重新输入订单号！");

			alert.showAndWait();
		} else {
			mainApp.showDetailedAbnormalOrderPanel(orderID);
		}
	}

	public void returnButtonAction() {
		mainApp.showWebsitePromotionMainPanel();
	}

	public void showDetailedOrder() {
		int selectedIndex = abnormalOrderTableView.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			String orderID = abnormalOrderTableView.getItems().get(selectedIndex).getOrderID().getValue();
			mainApp.showDetailedAbnormalOrderPanel(orderID);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("未选择订单");
			alert.setHeaderText("您没有选择要查看的订单");
			alert.setContentText("请在列表中选择一个订单！");

			alert.showAndWait();
		}
	}

}
