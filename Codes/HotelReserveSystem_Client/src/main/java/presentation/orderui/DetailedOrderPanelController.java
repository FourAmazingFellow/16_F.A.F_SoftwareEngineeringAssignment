package presentation.orderui;

import businesslogicservice.orderblservice.BrowseUserOrderService;
import factory.OrderUIFactoryService;
import factory.OrderUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import po.OrderState;
import po.RoomType;
import presentation.MainApp;
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

	private MainApp mainApp;
	private OrderUIFactoryService factory;
	private BrowseUserOrderService browseHelper;

	@FXML
	public void initialize() {
		factory = new OrderUIFactoryServiceImpl();
		browseHelper = factory.createBrowseUserOrderService();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void showDetailedOrderPanel(String orderID) {
		OrderVO vo = browseHelper.getDetailedOrder(orderID);
		orderStateLabel.setText(getOrderState((OrderState) vo.orderState));
		isOnSaleLabel.setText(getTorF(vo.isOnSale));
		isCommentedLabel.setText(getTorF(vo.isCommented));
		beginTimeLabel.setText(vo.beginDate.toString());
		orderProducedTimeLabel.setText(vo.orderProducedTime.toString());
		orderIDLabel.setText(vo.orderID);
		isChildrenLabel.setText(getTorF(vo.isChildren));
		numOfPersonLabel.setText(String.valueOf(vo.numOfPerson));
		hotelNameLabel.setText(vo.hotelName);
		hotelAddressLabel.setText(vo.hotelAddress);
		numLabel.setText(String.valueOf(vo.num));
		latestOrderDoneTimeLabel.setText(vo.lastedOrderDoneTime.toString());
		finishDateLabel.setText(vo.finishDate.toString());
		totalPrcieLabel.setText(String.valueOf(totalPrcieLabel));
		roomTypeLabel.setText(getRoomType((RoomType) vo.roomType));
	}
	
	public void returnAction(String userID) {
		mainApp.showUserOrderPanel(userID);
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
