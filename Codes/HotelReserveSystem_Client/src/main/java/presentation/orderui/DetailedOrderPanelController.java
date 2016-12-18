package presentation.orderui;

import java.util.Date;
import java.util.Optional;

import businesslogicservice.orderblservice.BrowseUserOrderService;
import businesslogicservice.orderblservice.WithdrawOrderService;
import factory.OrderUIFactoryService;
import factory.OrderUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import po.OrderState;
import po.RoomType;
import presentation.ClientMainApp;
import vo.OrderVO;

public class DetailedOrderPanelController {
	@FXML
	private Label orderStateLabel;
	@FXML
	private Label isOnSaleLabel;
	@FXML
	private Button commentButton;
	@FXML
	private Label isCommentedLabel;
	@FXML
	private Label beginTimeLabel;
	@FXML
	private Label orderProducedTimeLabel;
	@FXML
	private Label orderIDLabel;
	@FXML
	private Label isChildrenLabel;
	@FXML
	private Label numOfPersonLabel;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label hotelAddressLabel;
	@FXML
	private Label numLabel;
	@FXML
	private Label latestOrderDoneTimeLabel;
	@FXML
	private Label finishDateLabel;
	@FXML
	private Button withdrawOrderButton;
	@FXML
	private Button returnButton;
	@FXML
	private Label totalPrcieLabel;
	@FXML
	private Label roomTypeLabel;

	private ClientMainApp mainApp;
	private OrderVO vo;
	private OrderUIFactoryService factory;
	private BrowseUserOrderService browseHelper;
	private WithdrawOrderService orderWithdrawer;

	@FXML
	public void initialize() {
		factory = new OrderUIFactoryServiceImpl();
		browseHelper = factory.createBrowseUserOrderService();
		orderWithdrawer = factory.createWithdrawOrderService();
	}

	public void setMainApp(ClientMainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void commentOrder() {
		
	}
	
	public void showDetailedOrderPanel(String orderID) {
		this.vo = browseHelper.getDetailedOrder(orderID);
		
		//若订单已过时，则不可撤销订单
		if(vo.lastedOrderDoneTime.getTime() - (new Date()).getTime() < 0 || 
				vo.orderState != OrderState.NOT_DONE_ORDER)
			withdrawOrderButton.setDisable(true);
		
		orderStateLabel.setText(getOrderState((OrderState) vo.orderState));
		isOnSaleLabel.setText(getTorF(vo.isOnSale));
		isCommentedLabel.setText(getTorF(vo.isCommented));
		beginTimeLabel.setText(FxBriefOrder.toDate(vo.beginDate));
		orderProducedTimeLabel.setText(FxBriefOrder.toSec(vo.orderProducedTime));
		orderIDLabel.setText(vo.orderID);
		isChildrenLabel.setText(getTorF(vo.isChildren));
		numOfPersonLabel.setText(String.valueOf(vo.numOfPerson));
		hotelNameLabel.setText(vo.hotelName);
		hotelAddressLabel.setText(vo.hotelAddress);
		numLabel.setText(String.valueOf(vo.num));
		latestOrderDoneTimeLabel.setText(FxBriefOrder.toSec(vo.lastedOrderDoneTime));
		finishDateLabel.setText(FxBriefOrder.toDate(vo.finishDate));
		totalPrcieLabel.setText(String.valueOf(vo.totalPrice));
		roomTypeLabel.setText(getRoomType((RoomType) vo.roomType));
	}
	
	public void returnAction() {
		mainApp.showUserOrderPanel(ClientMainApp.userID);
	}
	
	public void withDrawOrderAction() {
		Date now = new Date();
		if(vo.lastedOrderDoneTime.getTime() - (new Date()).getTime() < 0) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("操作失败");
			alert.setContentText("订单异常，不能执行撤销操作");

			alert.showAndWait();
			mainApp.showDetailedOrderPanel(vo.orderID);
		}
			
		if(vo.lastedOrderDoneTime.getTime() - now.getTime() < 1000*60*60*6){
			Alert conf = new Alert(AlertType.CONFIRMATION);
			conf.setTitle("确认撤销订单");
			conf.setContentText("距离最晚订单执行时间不足6小时，撤销订单会扣除信用值，确认撤销订单吗？");

			Optional<javafx.scene.control.ButtonType> result = conf.showAndWait();
			if(result.get() == javafx.scene.control.ButtonType.OK) {
				if(orderWithdrawer.withdrawOrder(vo, true)){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("操作成功");
					alert.setContentText("撤销订单成功");

					alert.showAndWait();
				}else{
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("操作失败");
					alert.setContentText("请检查您的网络连接！");

					alert.showAndWait();
				}
			}
		}else {
			Alert conf = new Alert(AlertType.CONFIRMATION);
			conf.setTitle("确认撤销订单");
			conf.setContentText("确认撤销订单？");

			Optional<javafx.scene.control.ButtonType> result = conf.showAndWait();
			if(result.get() == javafx.scene.control.ButtonType.OK) {
				if(orderWithdrawer.withdrawOrder(vo, false)){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("操作成功");
					alert.setContentText("撤销订单成功");

					alert.showAndWait();
				}else{
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("操作失败");
					alert.setContentText("请检查您的网络连接！");

					alert.showAndWait();
				}
			}
		}
		mainApp.showDetailedOrderPanel(vo.orderID);
	}

	private String getOrderState(OrderState orderState) {
		switch (orderState) {
		case ABNORMAL_ORDER:
			return "异常";
		case DONE_ORDER:
			return "已执行";
		case NOT_DONE_ORDER:
			return "未执行";
		case WITHDREW_ORDER:
			return "已撤销";
		default:
			return null;
		}
	}

	private String getRoomType(RoomType roomType) {
		switch (roomType) {
		case KING_SIZE_ROOM:
			return "大床房";
		case SINGLE_ROOM:
			return "单人房";
		case STANDARD_ROOM:
			return "标准间";
		case TRIBLE_ROOM:
			return "三人房";
		default:
			return null;
		}
	}

	private String getTorF(boolean b) {
		if (b)
			return "是";
		else
			return "否";
	}
	
	
}
