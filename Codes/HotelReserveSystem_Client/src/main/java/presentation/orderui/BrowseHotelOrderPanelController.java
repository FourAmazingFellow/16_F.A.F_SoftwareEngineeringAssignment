package presentation.orderui;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import bl_Stub.orderblservice_Stub.BrowseHotelOrderServiceImpl_Stub;
import businesslogicservice.orderblservice.BrowseHotelOrderService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import factory.OrderUIFactoryServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import po.OrderState;
import po.OrderType;
import po.RoomType;
import presentation.HotelMainApp;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseHotelOrderPanelController {
	@FXML
	private TableView<FxBriefOrder> hotelOrderTableView;

	@FXML
	private TableColumn<FxBriefOrder, String> numColumn;

	@FXML
	private Button searchButton;

	@FXML
	private TableColumn<FxBriefOrder, String> roomTypeColumn;

	@FXML
	private ChoiceBox<String> rankTypeChoiceBox;

	@FXML
	private TableColumn<FxBriefOrder, String> hotelAddressColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> totalPriceColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> beginDateColumn;

	@FXML
	private TextField searchTextField;

	@FXML
	private ChoiceBox<String> orderTypeChoiceBox;

	@FXML
	private TableColumn<FxBriefOrder, String> hotelNameColumn;

	@FXML
	private TableColumn<FxBriefOrder, String> finishDateColumn;

	@FXML
	private Button returnButton;

	@FXML
	private Button getDetailedOrderButton;

	private HotelMainApp mainApp;

	private OrderUIFactoryServiceImpl factory;
	
	ArrayList<BriefOrderInfoVO> list;

	private BrowseHotelOrderService hotelOrderBrowser;

	@SuppressWarnings("deprecation")
	@FXML
	public void initialize() {
		orderTypeChoiceBox.setItems(FXCollections.observableArrayList("全部订单", "未执行订单", "已执行订单", "已撤销订单", "异常订单"));
		orderTypeChoiceBox.setValue("全部订单");
		rankTypeChoiceBox.setItems(FXCollections.observableArrayList("订单生成时间", "订单开始时间", "价格"));
		rankTypeChoiceBox.setValue("订单生成时间");

		orderTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				getBriefOrderList(HotelMainApp.hotelAddress, OrderType.values()[(int) newValue]);
			}
		});

		rankTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if(newValue.intValue() == 0)
					hotelOrderTableView.getSortOrder().add(totalPriceColumn);
				else if(newValue.intValue() == 1)
					hotelOrderTableView.getSortOrder().add(beginDateColumn);
				else {
					hotelOrderTableView.getSortOrder().add(totalPriceColumn);
				}
			}
		});

		factory = new OrderUIFactoryServiceImpl();

		hotelOrderBrowser = new BrowseHotelOrderServiceImpl_Stub("19970206", "0000000000000003", "仙林大酒店", "仙林大道163号",
				new Date(116, 10, 16), new Date(116, 10, 17), RoomType.SINGLE_ROOM, 1, 500,
				OrderState.NOT_DONE_ORDER, new Date(116, 10, 16, 18, 0), new java.util.Date(116, 10, 16, 20, 0), 2,
				false, true, false);
	}

	public void setMainApp(HotelMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void getBriefOrderList(String address, OrderType orderType) {
		list = hotelOrderBrowser.getHotelOrderList(address, orderType);
		showBriefOrderList();
	}

	private void showBriefOrderList() {

		BriOrderVO2Fx trans = new BriOrderVO2Fx();
		ObservableList<FxBriefOrder> briefFxOrderList = FXCollections.observableArrayList();

		for (BriefOrderInfoVO vo : list) {
			briefFxOrderList.add(trans.briefOrderVO2Fx(vo));
		}

		hotelOrderTableView.setItems(briefFxOrderList);

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
			vo = hotelOrderBrowser.getSingleOrder(HotelMainApp.hotelAddress, orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (vo == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("订单号错误");
			alert.setHeaderText("订单号不存在或无访问权限！");
			alert.setContentText("请查证后重新输入订单号！");

			alert.showAndWait();
		} else {
			mainApp.showHotelDetailedOrderPanel(orderID);
		}
	}

	public void returnButtonAction() {

	}

	public void getOrderDone() {

	}

	public void showDetailedOrder() {
		int selectedIndex = hotelOrderTableView.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			String orderID = hotelOrderTableView.getItems().get(selectedIndex).getOrderID().getValue();
			mainApp.showHotelDetailedOrderPanel(orderID);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("未选择订单");
			alert.setHeaderText("您没有选择要查看的订单");
			alert.setContentText("请在列表中选择一个订单！");

			alert.showAndWait();
		}
	}
}
