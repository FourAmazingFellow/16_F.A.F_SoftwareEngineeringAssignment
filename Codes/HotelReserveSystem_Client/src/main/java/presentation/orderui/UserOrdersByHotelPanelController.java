package presentation.orderui;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.hotelbl.OrderInfo;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
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
import po.OrderState;
import presentation.ClientMainApp;
import vo.BriefOrderInfoVO;

public class UserOrdersByHotelPanelController {

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

	private String hotelAddress;
	private ObservableList<FxBriefOrder> briefFxOrderList = FXCollections.observableArrayList();
	private HotelUIFactoryService factory;
	private OrderInfo userOrdersByHotelHelper;
	private ArrayList<BriefOrderInfoVO> list;
	private ClientMainApp mainApp;
	
	@FXML
	public void initialize() {
		//设置订单类型的初始值
		orderTypeChoiceBox.setItems(FXCollections.observableArrayList("全部订单", "异常订单", "未执行订单", "已执行订单","已撤销订单"));
		orderTypeChoiceBox.setValue("全部订单");
		//设置排序类型的初始值
		rankTypeChoiceBox.setItems(FXCollections.observableArrayList("订单生成时间","订单开始时间","价格"));
		rankTypeChoiceBox.setValue("订单生成时间");
		
		//设置订单类型的监听
		orderTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if((int)newValue == -1)
					return;
				if((int)newValue == 0)
					showBriefOrderList(null);
				else
					showBriefOrderList(OrderState.values()[(int) newValue - 1]);
			}
		});
		
		//设置排序选择的监听
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
		
		factory = new HotelUIFactoryServiceImpl();
		userOrdersByHotelHelper = factory.createOrderInfo();
	}

	public void setMainApp(ClientMainApp mainApp, String hotelAddress) {
		this.mainApp = mainApp;
		this.hotelAddress = hotelAddress;
	}
	
	public void getBriefOrderList() {
		try {
			list = OrderVO2BriefOrderInfoVO.trans(userOrdersByHotelHelper.getOrderList(ClientMainApp.userID, this.hotelAddress));
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
		}
		showBriefOrderList(null);
	}
	
	/**
	 * 分别给每一列设置值
	 * @see
	 */
	private void showBriefOrderList(OrderState orderState) {
		BriOrderVO2Fx trans = new BriOrderVO2Fx();
		briefFxOrderList = FXCollections.observableArrayList();
		
		//对每一个VO，将其转化为自定义的JavaFX的Model类
		for (BriefOrderInfoVO vo : list) {
			if(orderState == null)
				briefFxOrderList.add(trans.briefOrderVO2Fx(vo));
			else {
				if(vo.orderState == orderState)
					briefFxOrderList.add(trans.briefOrderVO2Fx(vo));
			}
				
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
		mainApp.simplyShowDetailedHotelPanel(this.hotelAddress);
	}
	
	/**
	 * 显示详细订单的方法
	 * @see
	 */
	public void showDetailedOrder() {
		int selectedIndex = userOrders.getSelectionModel().getSelectedIndex();
		//保证用户一定选择了一个订单，否则给予提示
		if (selectedIndex >= 0) {
			String orderID = userOrders.getItems().get(selectedIndex).getOrderID().getValue();
			mainApp.showDetailedOrderPanel(orderID);
		} else {
			//提示用户选择一个订单
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("未选择订单");
			alert.setHeaderText("您没有选择要查看的订单");
			alert.setContentText("请在列表中选择一个订单！");

			alert.showAndWait();
		}
	}
}
