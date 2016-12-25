package presentation.orderui;

import java.rmi.RemoteException;
import java.util.Optional;

import businesslogicservice.orderblservice.CheckAbnormalOrderService;
import factory.OrderUIFactoryService;
import factory.OrderUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
		
		//请操作人员选择要恢复信用值的全部或一半
		Alert conf = new Alert(AlertType.CONFIRMATION);
		conf.setTitle("请求确认");
		conf.setContentText("若要恢复信用值的全部请按\"全部\" \n 恢复一半请按\"一半\":");
		ButtonType wholeButton = new ButtonType("全部");
		ButtonType halfButton = new ButtonType("一半");
		ButtonType cancelButton = new ButtonType("取消");
		conf.getButtonTypes().setAll(wholeButton, halfButton, cancelButton);
		Optional<javafx.scene.control.ButtonType> result = conf.showAndWait();
		if (result.get() == wholeButton) {
			isRecoverHalf = false;
		}else if (result.get() == halfButton) {
			isRecoverHalf = true;
		}else if(result.get() == cancelButton) {
			conf.close();
			return;
		}
		if(abnormalOrderChecker.systemWithdrawOrder(currentOrderVO, isRecoverHalf)){
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
	
	//给本Controller MainApp的引用，实现跳转逻辑
	public void setMainApp(WebsitePromotionMainApp websitePromotionMainApp) {
		this.mainApp = websitePromotionMainApp;
	}

}
