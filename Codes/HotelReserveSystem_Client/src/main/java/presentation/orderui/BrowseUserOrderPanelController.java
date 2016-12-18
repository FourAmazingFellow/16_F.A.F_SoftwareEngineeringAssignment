package presentation.orderui;

import java.util.ArrayList;

import businesslogicservice.orderblservice.BrowseUserOrderService;
import factory.OrderUIFactoryService;
import factory.OrderUIFactoryServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import po.OrderType;
import presentation.ClientMainApp;
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
	
	private ArrayList<BriefOrderInfoVO> list;
	
	private ClientMainApp mainApp;
	
	@FXML
	public void initialize() {
		orderTypeChoiceBox.setItems(FXCollections.observableArrayList("全部订单", "异常订单", "未执行订单", "已执行订单","已撤销订单"));
		orderTypeChoiceBox.setValue("全部订单");
		rankTypeChoiceBox.setItems(FXCollections.observableArrayList("订单生成时间","订单开始时间","价格"));
		rankTypeChoiceBox.setValue("订单生成时间");
		
		orderTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(OrderType.values()[(int) newValue]);
				getBriefOrderList(ClientMainApp.userID, OrderType.values()[(int) newValue]);
			}
		});
		
		rankTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if(newValue.intValue() == 0)
					userOrders.getSortOrder().add(totalPriceColumn);
				else if(newValue.intValue() == 1)
					userOrders.getSortOrder().add(beginDateColumn);
				else {
					userOrders.getSortOrder().add(totalPriceColumn);
				}
			}
		});
		
		factory = new OrderUIFactoryServiceImpl();
		browseHelper = factory.createBrowseUserOrderService();
	}

	public void setMainApp(ClientMainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void getBriefOrderList(String userID, OrderType orderType) {
		list = browseHelper.getUserOrderList(userID, orderType);
		showBriefOrderList();
	}
	
	private void showBriefOrderList() {
		BriOrderVO2Fx trans = new BriOrderVO2Fx();
		briefFxOrderList = FXCollections.observableArrayList();
		
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
		mainApp.showSearchView();
	}
	
	public void showDetailedOrder() {
		int selectedIndex = userOrders.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			String orderID = userOrders.getItems().get(selectedIndex).getOrderID().getValue();
			System.out.println("请求查看订单号为" + orderID + "的订单详情");
			mainApp.showDetailedOrderPanel(orderID);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("未选择订单");
			alert.setHeaderText("您没有选择要查看的订单");
			alert.setContentText("请在列表中选择一个订单！");

			alert.showAndWait();
		}
	}
}
