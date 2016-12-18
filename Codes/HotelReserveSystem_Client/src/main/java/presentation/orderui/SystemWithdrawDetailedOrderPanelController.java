package presentation.orderui;

import java.rmi.RemoteException;
import java.util.Optional;

import businesslogicservice.orderblservice.CheckAbnormalOrderService;
import factory.OrderUIFactoryService;
import factory.OrderUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import po.OrderState;
import po.RoomType;
import presentation.WebsitePromotionMainApp;
import vo.OrderVO;

public class SystemWithdrawDetailedOrderPanelController {

	@FXML
	private Label userIDLabel;
	
    @FXML
    private Label orderStateLabel;

    @FXML
    private Label isOnSaleLabel;

    @FXML
    private Button systemWIthdrawOrderButton;

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
    private Label totalPrcieLabel;

    @FXML
    private Label roomTypeLabel;

    private OrderVO currentOrderVO;
    private WebsitePromotionMainApp mainApp;
	private OrderUIFactoryService factory;
	private CheckAbnormalOrderService abnormalOrderChecker;

	@FXML
	public void initialize() {
		factory = new OrderUIFactoryServiceImpl();
		
		abnormalOrderChecker = factory.createBrowseAbnormalOrderService();
//		abnormalOrderChecker = new CheckAbnormalOrderServiceImpl_Stub("19970206","0000000000000003","仙林大酒店", "仙林大道163号" ,new Date(116,10,16),
//				new Date(116,10,17),RoomType.KING_SIZE_ROOM,1,100,OrderState.NOT_DONE_ORDER,new Date(116,10,16,18,0),
//				new java.util.Date(116, 10, 16, 20, 0),2,false,true,false);
	}
	
	public void showDetailedOrderPanel(String orderID) throws RemoteException {
		currentOrderVO = abnormalOrderChecker.getDetailedOrder(orderID);

		if(currentOrderVO.orderState != OrderState.ABNORMAL_ORDER)
			systemWIthdrawOrderButton.setDisable(true);
		
		userIDLabel.setText(currentOrderVO.userID);
		orderStateLabel.setText(getOrderState((OrderState) currentOrderVO.orderState));
		isOnSaleLabel.setText(getTorF(currentOrderVO.isOnSale));
		isCommentedLabel.setText(getTorF(currentOrderVO.isCommented));
		beginTimeLabel.setText(FxBriefOrder.toDate(currentOrderVO.beginDate));
		orderProducedTimeLabel.setText(FxBriefOrder.toSec(currentOrderVO.orderProducedTime));
		orderIDLabel.setText(currentOrderVO.orderID);
		isChildrenLabel.setText(getTorF(currentOrderVO.isChildren));
		numOfPersonLabel.setText(String.valueOf(currentOrderVO.numOfPerson));
		hotelNameLabel.setText(currentOrderVO.hotelName);
		hotelAddressLabel.setText(currentOrderVO.hotelAddress);
		numLabel.setText(String.valueOf(currentOrderVO.num));
		latestOrderDoneTimeLabel.setText(FxBriefOrder.toSec(currentOrderVO.lastedOrderDoneTime));
		finishDateLabel.setText(FxBriefOrder.toDate(currentOrderVO.finishDate));
		totalPrcieLabel.setText(String.valueOf(currentOrderVO.totalPrice));
		roomTypeLabel.setText(getRoomType((RoomType) currentOrderVO.roomType));
	}
	
	public void returnAction() {
		mainApp.showAbnormalOrderPanel();
	}
	
	public void systemWithdraw(){
		boolean isRecoverHalf = false;
		//请操作人员选择要恢复信用值的全部或一半 TO-DO
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("选择要恢复的信用值");
		alert.setHeaderText("需要您确认要恢复信用值的全部？还是一半？");
		alert.setContentText("请选择：");

		ButtonType buttonTypeOne = new ButtonType("全部");
		ButtonType buttonTypeTwo = new ButtonType("一半");
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
			isRecoverHalf = false;
		} else if (result.get() == buttonTypeTwo) {
			isRecoverHalf = true;
		} else {
			mainApp.showAbnormalOrderPanel();
			return;
		}
		
		if(abnormalOrderChecker.systemWithdrawOrder(currentOrderVO, isRecoverHalf)){
			Alert alert_ = new Alert(AlertType.INFORMATION);
			alert_.setTitle("操作成功");
			alert_.setContentText("撤销订单成功!并成功恢复了用户的信用值！");

			alert_.showAndWait();
		}else{
			Alert alert_ = new Alert(AlertType.WARNING);
			alert_.setTitle("操作失败");
			alert_.setContentText("请检查您的网络连接！");

			alert_.showAndWait();
		}
		mainApp.showAbnormalOrderPanel();
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

	public void setMainApp(WebsitePromotionMainApp websitePromotionMainApp) {
		this.mainApp = websitePromotionMainApp;
	}

}
