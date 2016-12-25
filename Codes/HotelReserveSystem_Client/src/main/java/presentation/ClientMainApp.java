package presentation;

import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import po.OrderType;
import presentation.hotelui.ScreenPanelController;
import presentation.hotelui.SearchDetailsPanelController;
import presentation.hotelui.SearchPanelController;
import presentation.hotelui.commenthotel.CommentOnHotelController;
import presentation.hotelui.reservedhotel.HotelCommentsPanelController;
import presentation.hotelui.reservedhotel.ReservedHotelPanelController;
import presentation.hotelui.reservedhotel.SearchedDetailedHotelPanelController;
import presentation.hotelui.reservedhotel.SimpleDetailedHotelPanelController;
import presentation.hotelui.reservedhotel.SimpleHotelCommentsPanelController;
import presentation.mainui.ClientRootBoardController;
import presentation.orderui.BrowseUserOrderPanelController;
import presentation.orderui.CreateOrderPanelController;
import presentation.orderui.DetailedOrderPanelController;
import presentation.orderui.UserOrdersByHotelPanelController;
import presentation.userui.maintain.EditController;
import presentation.userui.maintain.ModifyClientInfoController;
import presentation.userui.maintain.ModifyPasswordController;
import presentation.userui.querycredit.QueryCreditRecordController;
import presentation.userui.signvip.SignEnterpriseVipController;
import presentation.userui.signvip.SignRegularVipController;

public class ClientMainApp extends Application {
	public static String userID = "原";

	private MainApp mainApp;
	private Stage primaryStage;
	private BorderPane clientRootLayout;

	@Override
	public void start(Stage primaryStage) {
//		ClientRunner clientRunner = new ClientRunner();
//		try {
//			clientRunner.start();
//		} catch (RemoteException e) {
//			Alert alert = new Alert(AlertType.WARNING);
//			alert.setTitle("NetWork Warning");
//			alert.setHeaderText("Fail to connect with the server!");
//			alert.setContentText("Please check your network connection!");
//			alert.showAndWait();
//		}
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);

		showClientRootPanel();
		showSearchView();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void logout() {
		userID = "";
		mainApp.showLoginView("");
	}
	
	// 显示客户导航栏
	public void showClientRootPanel() {
		try {
			// Load root layout from FXML file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("mainui/clientRootBoard.fxml"));
			clientRootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(clientRootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the mainApp.
			ClientRootBoardController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示生成订单的页面
	 * @param userID 用户名
	 * @param hotelName 酒店明晨
	 * @param hotelAddress 酒店地址
	 * @see
	 */
	public void showCreateOrderPanel(String userID, String hotelName, String hotelAddress) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("orderui/createNewOrderPanel.fxml"));
			AnchorPane createOrderPanel = (AnchorPane) loader.load();

			// Give the controller access to the mainApp.
			CreateOrderPanelController controller = loader.getController();
			controller.setMainApp(this);
			if(controller.initOrder(userID, hotelName, hotelAddress)) {
				clientRootLayout.setCenter(createOrderPanel);
				controller.initOrder(userID, hotelName, hotelAddress);
				controller.setStrategy();
				primaryStage.show();
			}				
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("生成失败");
				alert.setHeaderText("您的信用值不足，无法生成订单。");
				alert.setContentText("请给您的信用值充值");
				alert.showAndWait();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示"我预定过的酒店"界面
	 * @see
	 */
	public void showReservedHotelPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/reservedhotel/ReservedHotelPanel.fxml"));
			AnchorPane reservedHotelPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(reservedHotelPanel);

			ReservedHotelPanelController controller = loader.getController();

			controller.setMainApp(this);			
			controller.showReservedHotels();

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示当前用户在某酒店的全部订单
	 * @param hotelAddress 酒店地址
	 * @see
	 */
	public void showUserOrdersByHotel(String hotelAddress) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("orderui/userOrdersByHotelPanel.fxml"));
			AnchorPane userOrdersByHotelPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(userOrdersByHotelPanel);

			// Give the controller access to the mainApp.
			UserOrdersByHotelPanelController controller = loader.getController();

			// 默认显示所有订单
			controller.setMainApp(this, hotelAddress);
			controller.getBriefOrderList();

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 显示用户主界面 --- 搜索界面
	 * @see
	 */
	public void showSearchView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/SearchPanel.fxml"));
			AnchorPane searchPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(searchPanel);

			// Give the controller access to the mainApp.
			SearchPanelController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示搜索结果
	 * @param conditions
	 * @see
	 */
	public void showSearchDetailsPanel(String[] conditions) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/SearchDetailsPanel.fxml"));
			AnchorPane searchResultPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(searchResultPanel);

			SearchDetailsPanelController controller = loader.getController();
			controller.setMainApp(this);
			// 默认显示所有订单
			controller.setConditions(conditions);
			controller.showSearchResult();

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示搜索筛选界面
	 * @param conditions String数组 已经被设置的条件
	 * @return 用户是否已经确认
	 * @see
	 */
	public boolean showScreenDialog(String[] conditions) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/ScreenPanel.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("酒店筛选");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ScreenPanelController controller = loader.getController();
			controller.setConditions(conditions);
			controller.setDialogStage(dialogStage);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isConfirmClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 由"搜索界面"到达的"酒店详情界面"
	 * @param hotelAddress
	 * @param conditions String[]
	 * @see
	 */
	public void showDetailedHotelPanel(String hotelAddress, String[] conditions) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/reservedhotel/detailedHotelPanel.fxml"));
			AnchorPane detailedHotelPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(detailedHotelPanel);

			// Give the controller access to the mainApp.
			SearchedDetailedHotelPanelController controller = loader.getController();

			controller.setMainApp(this, conditions);
			controller.showDetailedOrderPanel(hotelAddress);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 由"我预定过的酒店"到达的详情界面
	 * @param hotelAddress 酒店地址
	 * @see
	 */
	public void simplyShowDetailedHotelPanel(String hotelAddress) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/reservedhotel/simpleDetailedHotelPanel.fxml"));
			AnchorPane detailedHotelPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(detailedHotelPanel);

			SimpleDetailedHotelPanelController controller = loader.getController();

			controller.setMainApp(this);
			controller.showDetailedOrderPanel(hotelAddress);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示酒店评论界面
	 * @param comments HashMap<String, String> 已有评论
	 * @param hotelAddress 酒店地址
	 * @param conditions String[]
	 * @see
	 */
	public void showHotelComments(HashMap<String, String> comments, String hotelAddress, String[] conditions) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/reservedhotel/HotelCommentsPanel.fxml"));
			AnchorPane hotelCommentsPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(hotelCommentsPanel);

			// Give the controller access to the mainApp.
			HotelCommentsPanelController controller = loader.getController();

			// Give the mainApp access to the controller
			controller.setMainApp(this, hotelAddress, conditions);
			controller.showComments(comments);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void simplyShowHotelComments(HashMap<String, String> comments, String hotelAddress) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/reservedhotel/SimpleHotelCommentsPanel.fxml"));
			AnchorPane hotelCommentsPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(hotelCommentsPanel);

			// Give the controller access to the mainApp.
			SimpleHotelCommentsPanelController controller = loader.getController();

			// Give the mainApp access to the controller
			controller.setMainApp(this, hotelAddress);
			controller.showComments(comments);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示用户所有订单的列表
	 * @param userID
	 * @see
	 */
	public void showUserOrderPanel(String userID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("orderui/browseUserOrderPanel.fxml"));
			AnchorPane allUserOrderPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(allUserOrderPanel);

			// Give the controller access to the mainApp.
			BrowseUserOrderPanelController controller = loader.getController();

			// 默认显示所有订单
			controller.setMainApp(this);
			controller.getBriefOrderList(userID, OrderType.ALL);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示订单详情页面
	 * @param orderID
	 * @see
	 */
	public void showDetailedOrderPanel(String orderID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("orderui/detailedORderPanel.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(detailedOrderPanel);

			DetailedOrderPanelController controller = loader.getController();

			controller.setMainApp(this);
			controller.showDetailedOrderPanel(orderID);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 显示维护个人信息界面
	 * @see
	 */
	public void showModifyClientInfoPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("userui/maintain/ModifyClientInfo.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(detailedOrderPanel);

			ModifyClientInfoController controller = loader.getController();

			controller.setMainApp(this);
			controller.showClientInfo(userID);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示维护个人信息编辑界面
	 * @param userID
	 * @see
	 */
	public void showEditClientInfoPanel(String userID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("userui/maintain/Edit.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(detailedOrderPanel);

			EditController controller = loader.getController();

			controller.setMainApp(this);
			controller.showPreClientInfo(userID);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示维护个人信息修改密码界面
	 * @param userID 用户名
	 * @param telNum 联系方式
	 * @param password 当前密码
	 * @see
	 */
	public void showModifyPasswordPanel(String userID, String telNum, String password) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("userui/maintain/ModifyPassword.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(detailedOrderPanel);

			ModifyPasswordController controller = loader.getController();

			controller.showUserID(userID,telNum, password);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示维护个人信息查看信用记录界面
	 * @see
	 */
	public void showQueryCreditRecordPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("userui/querycredit/QueryCreditRecord.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(detailedOrderPanel);

			QueryCreditRecordController controller = loader.getController();

			controller.setMainApp(this);
			controller.showCreditRecordList(userID);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示注册普通会员页面
	 * @param userID
	 * @see
	 */
	public void showSignRegularVipPanel(String userID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("userui/signvip/SignRegularVip.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(detailedOrderPanel);

			SignRegularVipController controller = loader.getController();

			controller.setMainApp(this);
			controller.setUserID(userID);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示注册企业会员页面
	 * @param userID
	 * @see
	 */
	public void showSignEnterpriseVipPanel(String userID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("userui/signvip/SignEnterpriseVip.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(detailedOrderPanel);

			SignEnterpriseVipController controller = loader.getController();

			controller.setMainApp(this);
			controller.setUserID(userID);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 显示评论界面
	 * @param hotelAddress
	 * @param orderID
	 * @see
	 */
	public void showCommentOnHotelPanel(String hotelAddress, String orderID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ClientMainApp.class.getResource("hotelui/commenthotel/CommentOnHotel.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();

			clientRootLayout.setCenter(detailedOrderPanel);

			CommentOnHotelController controller = loader.getController();

			controller.setMainApp(this);
			controller.setuserIDAndAddress(userID, hotelAddress, orderID);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	
}