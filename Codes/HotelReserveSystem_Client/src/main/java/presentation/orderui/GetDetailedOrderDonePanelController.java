package presentation.orderui;

import java.rmi.RemoteException;
import java.util.Date;

import bl_Stub.orderblservice_Stub.BrowseHotelOrderServiceImpl_Stub;
import bl_Stub.orderblservice_Stub.GetOrderDoneServiceImpl_Stub;
import businesslogicservice.orderblservice.BrowseHotelOrderService;
import businesslogicservice.orderblservice.GetOrderDoneService;
import factory.OrderUIFactoryService;
import factory.OrderUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import po.OrderState;
import po.RoomType;
import presentation.HotelMainApp;
import vo.OrderVO;

public class GetDetailedOrderDonePanelController {

	@FXML
	private Button delayCheckInButton;
	
    @FXML
    private Label orderStateLabel;

    @FXML
    private Label isOnSaleLabel;

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
    private Button returnButton;

    @FXML
    private Button getOrderDoneButton;

    @FXML
    private Label totalPrcieLabel;

    @FXML
    private Label roomTypeLabel;

    private OrderVO currentOrderVO;
    private HotelMainApp mainApp;
	private OrderUIFactoryService factory;
	private BrowseHotelOrderService browseHotelOrderHelper;
	private GetOrderDoneService getOrderDoner;

	@SuppressWarnings("deprecation")
	@FXML
	public void initialize() {
		factory = new OrderUIFactoryServiceImpl();
//		browseHotelOrderHelper = factory.createBrowseHotelOrderService();
		browseHotelOrderHelper = new BrowseHotelOrderServiceImpl_Stub("19970206","0000000000000003","仙林大酒店", "仙林大道163号" ,new Date(116,10,16),
				new Date(116,10,17),RoomType.KING_SIZE_ROOM,1,100,OrderState.NOT_DONE_ORDER,new Date(116,10,16,18,0),
				new java.util.Date(116, 10, 16, 20, 0),2,false,true,false);
//	    getOrderDoner = factory.createGetOrderDoneService();
		getOrderDoner = new GetOrderDoneServiceImpl_Stub("19970206","0000000000000003","仙林大酒店", "仙林大道163号" ,new Date(116,10,16),
				new Date(116,10,17),RoomType.KING_SIZE_ROOM,1,100,OrderState.NOT_DONE_ORDER,new Date(116,10,16,18,0),
				new java.util.Date(116, 10, 16, 20, 0),2,false,true,false);
	}
	
	public void showDetailedOrderPanel(String orderID) {
		System.out.println(orderID);
		OrderVO vo = null;
		try {
			vo = browseHotelOrderHelper.getSingleOrder(HotelMainApp.hotelAddress, orderID);
			currentOrderVO = vo;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(vo.orderState != OrderState.NOT_DONE_ORDER)
			getOrderDoneButton.setDisable(true);
		
		if(vo.orderState != OrderState.ABNORMAL_ORDER)
			delayCheckInButton.setDisable(true);
		
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
		mainApp.showHotelOrderPanel();
	}

	public void getOrderDone() {
		if(getOrderDoner.getOrderDone(currentOrderVO)){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("操作成功");
			alert.setContentText("执行订单成功");

			alert.showAndWait();
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("操作失败");
			alert.setContentText("请检查您的网络连接！");

			alert.showAndWait();
		}
		mainApp.showHotelDetailedOrderPanel(currentOrderVO.orderID);
	}
	
	public void delayCheckIn(){
		if(getOrderDoner.delayCheckIn(currentOrderVO)){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("操作成功");
			alert.setContentText("延迟入住成功!");

			alert.showAndWait();
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("操作失败");
			alert.setContentText("请检查您的网络连接！");

			alert.showAndWait();
		}
		mainApp.showHotelDetailedOrderPanel(currentOrderVO.orderID);
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

	public void setMainApp(HotelMainApp hotelMainApp) {
		this.mainApp = hotelMainApp;
	}
}
