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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import po.BusinessDistrictPO;
import presentation.ClientMainApp;
import vo.OrderedHotelInfoVO;

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
	private TableColumn<FxBriefHotelInfo, String>minPriceCol;
	
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

	@FXML
	private void handleCheckDetailedHotel() {
		int selectedIndex = hotelTableView.getSelectionModel().getSelectedIndex();
		//保证客户一定选择了某个酒店，否则弹框提醒
		if (selectedIndex >= 0) {
			String hoteledAddress = hotelTableView.getItems().get(selectedIndex).getHotelAddress().getValue();
			mainApp.showDetailedHotelPanel(hoteledAddress, conditions);
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
		//保证客户一定选择了某个酒店，否则弹框提醒
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

		//给城市选择添加监听
		cityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				//将商区设置为该城市对应的商区列表
				setDistrictChoiceBox(cityList.get((int) (newValue)));
				
				//立即显示出新的搜索条件下的搜索结果
//				conditions[0] = cityChoiceBox.getItems().get((int)newValue);
//				conditions[1] = districtChoiceBox.getItems().get(0);
//				showNewResult();
			}
		});
		
		//给商区选择添加监听
		districtChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				//立即显示出新的搜索条件下的搜索结果
//				showNewResult();
			}
		});

		setDatePicker();
		rankTypeChoiceBox.setItems(FXCollections.observableArrayList("星级从低到高","星级从高到低","按评分从低到高","按评分从高到低","按价格从低到高", "按价格从高到低", "默认排序方式"));
		rankTypeChoiceBox.setValue("默认排序方式");
		
		//设置排序逻辑
		rankTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@SuppressWarnings("unchecked")
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if(newValue.intValue() == 0) {
					starLevelCol.setSortType(SortType.ASCENDING);
					hotelTableView.getSortOrder().setAll(starLevelCol);
				}else if(newValue.intValue() == 1) {
					starLevelCol.setSortType(SortType.DESCENDING);
					hotelTableView.getSortOrder().setAll(starLevelCol);
				}else if(newValue.intValue() == 2) {
					markCol.setSortType(SortType.ASCENDING);
					hotelTableView.getSortOrder().setAll(markCol);
				} else if (newValue.intValue() == 3) {
					markCol.setSortType(SortType.DESCENDING);
					hotelTableView.getSortOrder().setAll(markCol);
				} else if (newValue.intValue() == 4) {
					minPriceCol.setSortType(SortType.ASCENDING);
					hotelTableView.getSortOrder().setAll(minPriceCol);
				} else if (newValue.intValue() == 5) {
					minPriceCol.setSortType(SortType.DESCENDING);
					hotelTableView.getSortOrder().setAll(minPriceCol);
				}
			}
		});
	}

	/**
	 * 将LocalDate转化为String的方法
	 * @param date
	 * @return
	 * @see
	 */
	private String getDate(LocalDate date) {
		return String.valueOf(date.getYear()) + "-" + String.valueOf(date.getMonthValue()) + "-"
				+ String.valueOf(date.getDayOfMonth());
	}

	/**
	 * 根据城市将商区列表重置的方法
	 * @param cityName
	 * @see
	 */
	private void setDistrictChoiceBox(String cityName) {
		ArrayList<BusinessDistrictPO> tradeAreaList;
		try {
			tradeAreaList = searchHotelService.getBusinessDistrictList(cityName);
			districList = FXCollections.observableArrayList();
			for (BusinessDistrictPO districtPO : tradeAreaList) {
				districList.add(districtPO.getBusinessDistrictName());
			}
			districtChoiceBox.setItems(districList);
			districtChoiceBox.setValue(districList.get(0));
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
	}
	
	public void setConditions(String[] _conditions) {
		this.conditions = _conditions;
	}

	public void showSearchResult() {
		cityChoiceBox.setValue(conditions[0]);
		setDistrictChoiceBox(conditions[0]);
		districtChoiceBox.setValue(conditions[1]);
		beginDatePicker.setValue(LocalDate.parse(conditions[12]));
		finishDatePicker.setValue(LocalDate.parse(conditions[13]));
		
		ArrayList<OrderedHotelInfoVO> list;
		try {
			list = searchHotelService.getHotelBriefInfoListBySearching(conditions);
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
			minPriceCol.setCellValueFactory(cellData -> cellData.getValue().getMinPrice());
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
	private void showNewResult() {
		conditions[0] = cityChoiceBox.getValue();
		conditions[1] = districtChoiceBox.getValue();
		conditions[12] = getDate(beginDatePicker.getValue());
		conditions[13] = getDate(finishDatePicker.getValue());
		showSearchResult();
	}
	
	@FXML
	private void returnAction() {
		mainApp.showSearchView();
	}

	/**
	 * 限制用户选择今天之后七天之内的日期，限制用户不能把退房日期设为早于入住日期
	 * @see
	 */
	private void setDatePicker() {
		beginDatePicker.setValue(LocalDate.now());
		beginDatePicker.setEditable(false);
		finishDatePicker.setEditable(false);
		beginDatePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(LocalDate.now()) || item.isAfter(LocalDate.now().plusDays(6))) {
							setDisable(true);
							setStyle("-fx-background-color: rgb(160,160,160);");
						}
					}
				};
			}
		});

		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(LocalDate.now().plusDays(1)) || item.isAfter(LocalDate.now().plusDays(7))
								|| item.isAfter(beginDatePicker.getValue().plusDays(7))) {
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
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(beginDatePicker.getValue().plusDays(1))
								|| item.isAfter(LocalDate.now().plusDays(7))) {
							setDisable(true);
							setStyle("-fx-background-color: rgb(160,160,160);");
						}
					}
				};
			}
		};
		finishDatePicker.setDayCellFactory(dayCellFactory);
		finishDatePicker.setValue(beginDatePicker.getValue().plusDays(1));
		showNewResult();
	}
}
