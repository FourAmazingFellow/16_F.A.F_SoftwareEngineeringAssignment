package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import po.OrderType;
import presentation.mainui.HotelRootBoardController;
import presentation.orderui.BrowseHotelOrderPanelController;
import presentation.orderui.GetDetailedOrderDonePanelController;
import presentation.roomui.CheckIn.CheckInEditPanelController;
import presentation.roomui.CheckIn.ManageCheckInPanelController;
import presentation.roomui.CheckIn.model.CheckIn;
import presentation.roomui.CheckOut.CheckOutEditPanelController;
import presentation.roomui.CheckOut.ManageCheckOutPanelController;
import presentation.roomui.CheckOut.model.CheckOut;
import presentation.roomui.spareRoom.SpareRoomTablePanelController;
import presentation.strategyui.manageHotelPromotion.PromotionEditPanelController;
import presentation.strategyui.manageMarketStrategy.MarketStrategyEditPanelController;
import presentation.strategyui.manageMarketStrategy.MarketStrategyPanelController;
import presentation.strategyui.model.Strategy;

public class HotelMainApp extends Application {
	
	public static String hotelAddress = "";
	
	private Stage primaryStage;
	private BorderPane hotelRootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("F.A.F 酒店预定系统");
		this.primaryStage.setResizable(false);
		
		showHotelRootPanel();
		showHotelOrderPanel();
	}
	public static void main(String[] args) {
		launch(args);
	}

	public void showHotelRootPanel() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HotelMainApp.class.getResource("mainui/hotelRootBoard.fxml"));
			hotelRootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(hotelRootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			HotelRootBoardController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showHotelOrderPanel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HotelMainApp.class.getResource("orderui/browseHotelOrderPanel.fxml"));
			AnchorPane allHotelOrderPanel = (AnchorPane) loader.load();

			hotelRootLayout.setCenter(allHotelOrderPanel);
			
			// Give the controller access to the main app.
			BrowseHotelOrderPanelController controller = loader.getController();
			controller.setMainApp(this);
			//默认显示所有订单
			controller.getBriefOrderList(HotelMainApp.hotelAddress, OrderType.ALL);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showHotelDetailedOrderPanel(String orderID) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HotelMainApp.class.getResource("orderui/getDetailedOrderDonePanel.fxml"));
			AnchorPane detailedOrderPanel = (AnchorPane) loader.load();
		
			hotelRootLayout.setCenter(detailedOrderPanel);
			
			GetDetailedOrderDonePanelController controller = loader.getController();
			
			controller.setMainApp(this);
			controller.showDetailedOrderPanel(orderID);
			
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * 酒店工作人员的主界面
	 * 
	 * @see
	 */
	public void showHotelMainPanel() {
		
	}
	
	/**
	 * 办理入住界面
	 */
	public void showManageCheckInPanel(String address) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HotelMainApp.class.getResource("roomui/CheckIn/ManageCheckInPanel.fxml"));
            AnchorPane manageCheckInPanel = (AnchorPane) loader.load();

            hotelRootLayout.setCenter(manageCheckInPanel);
            
            // Give the controller access to the main app.
            ManageCheckInPanelController controller = loader.getController();
            controller.setMainApp(this);
            //默认显示所有订单
            controller.showAllCheckInList(address);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * 编辑入住信息界面
	 * @param checkIn
	 * @param address
	 * @return
	 * @see
	 */
	 public boolean showCheckInEditDialog(CheckIn checkIn, String address) {
	        try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(HotelMainApp.class.getResource("roomui/CheckIn/CheckInEditPanel.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Edit CheckIn");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);

	            // Set the person into the controller.
	            CheckInEditPanelController controller = loader.getController();
	            controller.setDialogStage(dialogStage);
	            controller.setCheckIn(checkIn, address);;

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();

	            return controller.isConfirmed();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 /**
	  * 办理入住界面
	  * @param address
	  * @see
	  */
	 public void showManageCheckOutPanel(String address) {
	        try {
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(HotelMainApp.class.getResource("roomui/CheckOut/ManageCheckOutPanel.fxml"));
	            AnchorPane manageCheckOutPanel = (AnchorPane) loader.load();

	            hotelRootLayout.setCenter(manageCheckOutPanel);
	            
	            // Give the controller access to the main app.
	            ManageCheckOutPanelController controller = loader.getController();
	            controller.setMainApp(this);
	            //默认显示所有订单
	            controller.showAllCheckOutList(address);

	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 /**
	  * 编辑退房信息界面
	  * @param checkOut
	  * @param address
	  * @return
	  * @see
	  */
	 public boolean showCheckOutEditDialog(CheckOut checkOut, String address) {
	        try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(HotelMainApp.class.getResource("roomui/CheckOut/CheckOutEditPanel.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Edit CheckOut");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);

	            // Set the person into the controller.
	            CheckOutEditPanelController controller = loader.getController();
	            controller.setDialogStage(dialogStage);
	            controller.setCheckOut(checkOut, address);

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();

	            return controller.isConfirmed();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 /**
	  * 浏览空房界面
	  * @param address
	  * @see
	  */
	 public void showSpareRoomTablePanel(String address){
	        try {
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(HotelMainApp.class.getResource("roomui/spareRoom/SpareRoomTablePanel.fxml"));
	            AnchorPane browseSpareRoomPanel = (AnchorPane) loader.load();

	            // Show the scene containing the root layout.
	            Scene scene = new Scene(browseSpareRoomPanel);
	            primaryStage.setScene(scene);

	            // Give the controller access to the main app.
	            SpareRoomTablePanelController spareRoomController = loader.getController();
	            spareRoomController.setMainApp(this);
	            //默认显示空房列表
	            spareRoomController.showSpareRoomList(address);;

	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 /**
	  * 管理促销策略界面
	  * @param address
	  * @see
	  */
	 public void showManagePromotionPanel(String address){
	     try {
	         FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(HotelMainApp.class.getResource("strategyui/manageMarketStrategy/MarketStrategyPabel.fxml"));
	         AnchorPane manageMarketStrategyPanel = (AnchorPane) loader.load();

	         hotelRootLayout.setCenter(manageMarketStrategyPanel);
	         
	         // Give the controller access to the main app.
	         MarketStrategyPanelController controller = loader.getController();
	         controller.setMainApp(this);
	         //默认显示所有订单
	         controller.showAllMarketStrategyList(address);;

	         primaryStage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }
	 
	 
	 /**
	  * 促销策略编辑界面
	  * @param strategy
	  * @param address
	  * @param isNewaPromotion
	  * @return
	  * @see
	  */
	 public boolean showPromotionEditDialog(Strategy strategy, String address, boolean isNewaPromotion) {
	        try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(HotelMainApp.class.getResource("strategyui/manegeHotelPromotion/PromotionEditPanel.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Edit Promotion");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);

	            // Set the person into the controller.
	            PromotionEditPanelController controller = loader.getController();
	            controller.setDialogStage(dialogStage);
	            controller.setStrategy(strategy, address, isNewaPromotion);

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();

	            return controller.isConfirmed();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 /**
	  * 管理营销策略界面
	  * @param address
	  * @see
	  */
	 public void showManageMarketStrategyPanel(String address){
	     try {
	         FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(HotelMainApp.class.getResource("strategyui/manageMarketStrategy/MarketStrategyPabel.fxml"));
	         AnchorPane manageMarketStrategyPanel = (AnchorPane) loader.load();

	         hotelRootLayout.setCenter(manageMarketStrategyPanel);
	         
	         // Give the controller access to the main app.
	         MarketStrategyPanelController controller = loader.getController();
	         controller.setMainApp(this);
	         //默认显示所有订单
	         controller.showAllMarketStrategyList(address);;

	         primaryStage.show();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }
	 
	 /**
	  * 营销策略编辑界面
	  * @param strategy
	  * @param address
	  * @param isNewaPromotion
	  * @return
	  * @see
	  */
	 public boolean showMarketStrategyEditDialog(Strategy strategy, String address, boolean isNewaPromotion) {
	        try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(HotelMainApp.class.getResource("strategyui/manegeMarketStrategy/MarketStrategyEditPanel.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Edit MarketStrategy");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);

	            // Set the person into the controller.
	            MarketStrategyEditPanelController controller = loader.getController();
	            controller.setDialogStage(dialogStage);
	            controller.setStrategy(strategy, address, isNewaPromotion);

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();

	            return controller.isConfirmed();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
