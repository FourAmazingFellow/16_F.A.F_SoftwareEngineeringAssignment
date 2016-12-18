package presentation.hotelui.reservedhotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
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
import javafx.scene.control.Alert.AlertType;
import presentation.ClientMainApp;
import presentation.hotelui.BriHotelVO2Fx;
import presentation.hotelui.FxBriefHotelInfo;
import vo.OrderedHotelInfoVO;

public class ReservedHotelPanelController {

	@FXML
	private ChoiceBox<String> rankTypeChoiceBox;

	@FXML
	private Button checkDetailedHotelButton;

	@FXML
	private TableView<FxBriefHotelInfo> hotelTableView;

	@FXML
	private TableColumn<FxBriefHotelInfo, String> hotelNameCol;

	@FXML
	private TableColumn<FxBriefHotelInfo, String> markCol;

	@FXML
	private TableColumn<FxBriefHotelInfo, String> tradeAreaCol;

	@FXML
	private TableColumn<FxBriefHotelInfo, String> starLevelCol;

	@FXML
	private TableColumn<FxBriefHotelInfo, String> orderTypesCol;

	@FXML
	private Button createButton;

	@FXML
	private Button returnButton;

	@FXML
	private TableColumn<FxBriefHotelInfo, String> hotelAddressCol;

	private ClientMainApp mainApp;
	private HotelUIFactoryService factory;
	private CheckOrderedHotelService checkReservedHotelService;

	private ObservableList<FxBriefHotelInfo> briefFxHotelList;

	@FXML
	private void intialize() {
		factory = new HotelUIFactoryServiceImpl();
		checkReservedHotelService = factory.createCheckOrderedHotelService();

		rankTypeChoiceBox.setItems(FXCollections.observableArrayList("按星级排序", "按评分排序"));

		rankTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() == 0)
					hotelTableView.getSortOrder().add(starLevelCol);
				else if (newValue.intValue() == 1)
					hotelTableView.getSortOrder().add(markCol);
			}
		});
	}

	public void showReservedHotels() {
		ArrayList<OrderedHotelInfoVO> list;
		try {
			list = checkReservedHotelService.enrollHotelBreifInfoList(ClientMainApp.userID);
			BriHotelVO2Fx trans = new BriHotelVO2Fx();
			briefFxHotelList = FXCollections.observableArrayList();

			for (OrderedHotelInfoVO vo : list) {
				briefFxHotelList.add(trans.trans(vo));
			}

			hotelTableView.setItems(briefFxHotelList);

			hotelNameCol.setCellValueFactory(cellData -> cellData.getValue().getHotelName());
			hotelAddressCol.setCellValueFactory(cellData -> cellData.getValue().getHotelAddress());
			markCol.setCellValueFactory(cellData -> cellData.getValue().getMark());
			starLevelCol.setCellValueFactory(cellData -> cellData.getValue().getStarLevel());
			tradeAreaCol.setCellValueFactory(cellData -> cellData.getValue().getTradeArea());
			orderTypesCol.setCellValueFactory(cellData -> cellData.getValue().getOrderTypes());
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
	}

	public void setMainApp(ClientMainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void returnAction() {
		mainApp.showSearchView();
	}

	@FXML
	private void handleCheckDetailedHotel() {
		int selectedIndex = hotelTableView.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			String hotelAddress = hotelTableView.getItems().get(selectedIndex).getHotelAddress().getValue();
			mainApp.simplyShowDetailedHotelPanel(hotelAddress);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText("您没有在表中选择任何酒店！");
			alert.setContentText("请在表中选择一个酒店！");
			alert.showAndWait();
		}
	}

	@FXML
	private void handleCreateOrder() {
		int selectedIndex = hotelTableView.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			String hotelAddress = hotelTableView.getItems().get(selectedIndex).getHotelAddress().getValue();
			String hotelName = hotelTableView.getItems().get(selectedIndex).getHotelName().getValue();
			mainApp.showCreateOrderPanel(ClientMainApp.userID, hotelName, hotelAddress);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText("您没有在表中选择任何酒店！");
			alert.setContentText("请在表中选择一个酒店！");
			alert.showAndWait();
		}
	}

}
