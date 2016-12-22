package presentation.hotelui;

import java.rmi.RemoteException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import po.BusinessDistrictPO;
import presentation.ClientMainApp;

public class SearchPanelController {
	// Reference to the main application
	private ClientMainApp mainApp;
	private ObservableList<String> cityList = FXCollections.observableArrayList("南京市", "上海市");
	private ObservableList<String> districList;

	@FXML
	private Button searchButton;

	@FXML
	private ChoiceBox<Integer> roomNumChoiceBox;

	@FXML
	private DatePicker beginDatePicker;

	@FXML
	private ChoiceBox<String> tradeAreaChoiceBox;

	@FXML
	private ChoiceBox<String> cityChoiceBox;

	@FXML
	private DatePicker finishDatePicker;

	@FXML
	private ChoiceBox<String> roomTypeChoiceBox;

	@FXML
	private TextField searchTextArea;
	
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
	
	@FXML
	private void initialize() {
		factory = new HotelUIFactoryServiceImpl();
		try {
			searchHotelService = factory.createSearchHotelService(ClientMainApp.userID);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
		}
		
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
		
		roomTypeChoiceBox.setItems(FXCollections.observableArrayList("单人房","标准间","三人房","大床房"));
		roomTypeChoiceBox.setValue("标准间");
		
		roomNumChoiceBox.setItems(FXCollections.observableArrayList(1,2,3,4));
		roomNumChoiceBox.setValue(1);
	}

	@FXML
	private void showSearchResult() {
		String[] _conditions = {cityChoiceBox.getValue(), tradeAreaChoiceBox.getValue(), searchTextArea.getText(), "0", "100000000", "0", "6", "0.0", "6.0", "0",
				String.valueOf(roomTypeChoiceBox.getSelectionModel().selectedIndexProperty().get()), String.valueOf(roomNumChoiceBox.getSelectionModel().selectedIndexProperty().get() + 1),
				getDate(beginDatePicker.getValue()), getDate(finishDatePicker.getValue())};
		
		mainApp.showSearchDetailsPanel(_conditions);
	}
	
	private String getDate(LocalDate date) {
		return String.valueOf(date.getYear()) + "-" + String.valueOf(date.getMonthValue()) + "-" + String.valueOf(date.getDayOfMonth());
	}
	
	private void setDistrictChoiceBox(String cityName) {
		ArrayList<BusinessDistrictPO> tradeAreaList;
		try {
			tradeAreaList = searchHotelService.getBusinessDistrictList(cityName);
			districList = FXCollections.observableArrayList();
			for(BusinessDistrictPO districtPO: tradeAreaList) {
				districList.add(districtPO.getBusinessDistrictName());
			}
			tradeAreaChoiceBox.setItems(districList);
			tradeAreaChoiceBox.setValue(districList.get(0));
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
		}
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
