package presentation.hotelui;

import java.time.LocalDate;
import java.util.ArrayList;


import businesslogicservice.hotelblservice.SearchHotelService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import po.BusinessDistrictPO;
import presentation.ClientMainApp;
import vo.OrderedHotelInfoVO;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;

public class SearchDetailsPanelController {
	private ClientMainApp mainApp;
	private ObservableList<String> cityList = FXCollections.observableArrayList("南京市", "上海市");
	private ObservableList<String> districList;
	private ObservableList<FxBriefHotelInfo> briefFxHotelList;
	
	private String[] conditions;
	
	@FXML
	private TableView<FxBriefHotelInfo> hotelTableView;
	
    @FXML
    private ChoiceBox<String> rankTypeChoiceBox;


    @FXML
    private DatePicker beginDatePicker;

    @FXML
    private Button createButton;

    @FXML
    private ChoiceBox<String> cityChoiceBox;

    @FXML
    private DatePicker finishDatePicker;

    @FXML
    private Button returnButton;

    @FXML
    private Button checkDetailedHotelButton;
    
    @FXML
    private Button filterButton;

    @FXML
    private ChoiceBox<String> districtChoiceBox;
    
    @FXML
    private TableColumn<FxBriefHotelInfo, String> hotelNameCol;

    @FXML
    private TableColumn<FxBriefHotelInfo, String> markCol;

    @FXML
    private TableColumn<FxBriefHotelInfo, String> tradeAreaCol;

    @FXML
    private TableColumn<FxBriefHotelInfo, String> orderTypesCol;
    
    @FXML
    private TableColumn<FxBriefHotelInfo, String> hotelAddressCol;
    
    @FXML
    private TableColumn<FxBriefHotelInfo, String> starLevelCol;


	
	private HotelUIFactoryService factory;
	private SearchHotelService searchHotelService;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(ClientMainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setConditions(String[] _conditions) {
		this.conditions = _conditions;
	}
	
	public void showSearchResult() {
		ArrayList<OrderedHotelInfoVO> list = searchHotelService.getHotelBriefInfoListBySearching(conditions);
		
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
	}
	
	@FXML
	private void handleScreenButton() {
		boolean confirmClicked = mainApp.showScreenDialog(conditions);
		if (confirmClicked) {
			conditions[0] = cityChoiceBox.getValue();
			conditions[1] = districtChoiceBox.getValue();
			conditions[12] = getDate(beginDatePicker.getValue());
			conditions[13] = getDate(finishDatePicker.getValue());
			showSearchResult();
		}
	}
	
	@FXML
	private void returnAction() {
		mainApp.showSearchView();
	}
	
	@FXML
	private void handleCheckDetailedHotel() {
		int selectedIndex = hotelTableView.getSelectionModel().getSelectedIndex();	
		if (selectedIndex >= 0) {
			String hoteledAddress = hotelTableView.getItems().get(selectedIndex).getHotelAddress().getValue();
			mainApp.showDetailedHotelPanel(hoteledAddress);
		} else {
			
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
			
		}
	}
	
	@FXML
	private void initialize() {
		factory = new HotelUIFactoryServiceImpl();
		searchHotelService = factory.createSearchHotelService(ClientMainApp.userID);
		
		cityChoiceBox.setItems(cityList);
		cityChoiceBox.setValue("南京市");
		
		cityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				setDistrictChoiceBox(cityList.get((int)(newValue)));
			}
		});
		
		setDistrictChoiceBox("南京市");

		setDatePicker();
	}
	
	private String getDate(LocalDate date) {
		return String.valueOf(date.getYear()) + "-" + String.valueOf(date.getMonth()) + "-" + String.valueOf(date.getDayOfMonth());
	}
	
	private void setDistrictChoiceBox(String cityName) {
		ArrayList<BusinessDistrictPO> tradeAreaList = searchHotelService.getBusinessDistrictList(cityName);
		districList = FXCollections.observableArrayList();
		for(BusinessDistrictPO districtPO: tradeAreaList) {
			districList.add(districtPO.getBusinessDistrictName());
		}
		districtChoiceBox.setItems(districList);
		districtChoiceBox.setValue(districList.get(0));
	}
	
	private void setDatePicker() {
		beginDatePicker.setValue(LocalDate.now());
		beginDatePicker.setEditable(false);
		finishDatePicker.setEditable(false);
		beginDatePicker.setDayCellFactory(
				new Callback<DatePicker, DateCell>() {
	                @Override
	                public DateCell call(final DatePicker datePicker) {
	                    return new DateCell() {
	                        @Override
	                        public void updateItem(LocalDate item, boolean empty) {
	                            super.updateItem(item, empty);

	                            if (item.isBefore(
	                            		LocalDate.now()) || 
	                            		item.isAfter(LocalDate.now().plusDays(6))
	                                ) {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: rgb(160,160,160);");
	                            }   
	                        }
	                    };
	                }});
		
		final Callback<DatePicker, DateCell> dayCellFactory = 
	            new Callback<DatePicker, DateCell>() {
	                @Override
	                public DateCell call(final DatePicker datePicker) {
	                    return new DateCell() {
	                        @Override
	                        public void updateItem(LocalDate item, boolean empty) {
	                            super.updateItem(item, empty);

	                            if (item.isBefore(
	                            		LocalDate.now().plusDays(1)) || 
	                            		item.isAfter(LocalDate.now().plusDays(7)) ||
	                            		item.isAfter(beginDatePicker.getValue().plusDays(7))
	                                ) {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: rgb(160,160,160);");
	                            }   
	                    }
	                };
	            }
	        };
	    finishDatePicker.setDayCellFactory(dayCellFactory);
	    finishDatePicker.setValue(beginDatePicker.getValue().plusDays(1));
	}
	
	public void dateFilter() {
		final Callback<DatePicker, DateCell> dayCellFactory = 
	            new Callback<DatePicker, DateCell>() {
	                @Override
	                public DateCell call(final DatePicker datePicker) {
	                    return new DateCell() {
	                        @Override
	                        public void updateItem(LocalDate item, boolean empty) {
	                            super.updateItem(item, empty);

	                            if (item.isBefore(
	                            		beginDatePicker.getValue().plusDays(1)) || 
	                            		item.isAfter(LocalDate.now().plusDays(7)))
	                                {
	                                    setDisable(true);
	                                    setStyle("-fx-background-color: rgb(160,160,160);");
	                            }   
	                    }
	                };
	            }
	        };
	    finishDatePicker.setDayCellFactory(dayCellFactory);
	    finishDatePicker.setValue(beginDatePicker.getValue().plusDays(1));
	}
}
