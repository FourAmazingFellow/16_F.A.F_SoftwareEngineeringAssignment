package presentation.hotelui.reservedhotel;

import java.rmi.RemoteException;
import java.util.Set;

import businesslogicservice.hotelblservice.QueryHotelService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import po.RoomType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import presentation.ClientMainApp;
import vo.HotelVO;

public class SearchedDetailedHotelPanelController {

	private String[] conditions;
	
	@FXML
    private Label stanRoomPriceLabel;

    @FXML
    private Label triRoomPriceLabel;

    @FXML
    private Button checkCommentsButton;

    @FXML
    private Label hotelMarkLabel;

    @FXML
    private Label minPriceLabel;

    @FXML
    private Label singleRoomPriceLabel;

    @FXML
    private Label hotelNameLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label hotelStarLabel;

    @FXML
    private Label hotelAddressLabel;

    @FXML
    private TextArea briefIntroTextArea;

    @FXML
    private Button createOrderButton;

    @FXML
    private TextArea facilityAndServiceTextArea;

    @FXML
    private Button returnButton;

    @FXML
    private Label districtLabel;

    @FXML
    private Label kingRoomPriceLabel;
    
    private ClientMainApp mainApp;
	private HotelVO vo;
	private HotelUIFactoryService factory;
	private QueryHotelService queryHotelService;
	
	@FXML
	private void initialize() {
		factory = new HotelUIFactoryServiceImpl();
		try {
			queryHotelService = factory.createQueryHotelService(ClientMainApp.userID);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
		}
	}
	
	public void setMainApp(ClientMainApp mainApp, String[] _conditions) {
		this.mainApp = mainApp;
		this.conditions = _conditions;
	}
	
	public void returnAction() {
		mainApp.showSearchDetailsPanel(conditions);
	}
	
	public void showDetailedOrderPanel(String address) {
		try {
			vo = queryHotelService.getHotelDetails(address);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
		}  
		String starLevel[] = {"一","二","三","四","五"};

	    hotelMarkLabel.setText(String.valueOf(vo.mark));
	    minPriceLabel.setText(String.valueOf(vo.min_Price));
	    hotelNameLabel.setText(vo.hotelName);
	    cityLabel.setText(vo.city);
	    hotelStarLabel.setText(starLevel[vo.starLevel - 1]);
	    hotelAddressLabel.setText(vo.hotelAddress);
	    briefIntroTextArea.setText(vo.briefIntroduction);
	    facilityAndServiceTextArea.setText(vo.facilityAndService);
	    districtLabel.setText(vo.tradeArea);
	    
	    Set<RoomType> roomTypes = vo.roomTypeAndPrice.keySet();
	    for(RoomType roomType : roomTypes) {
	    	int price = vo.roomTypeAndPrice.get(roomType);
	    	switch (roomType) {
			case SINGLE_ROOM:
				singleRoomPriceLabel.setText(String.valueOf(price));;
				break;
			case STANDARD_ROOM:
				stanRoomPriceLabel.setText(String.valueOf(price));
				break;
			case TRIBLE_ROOM:
				triRoomPriceLabel.setText(String.valueOf(price));
				break;
			case KING_SIZE_ROOM:
				kingRoomPriceLabel.setText(String.valueOf(price));
			default:
				break;
			}
	    }
	}
	
	@FXML
	private void createAction() {
		mainApp.showCreateOrderPanel(ClientMainApp.userID, hotelNameLabel.getText(), hotelAddressLabel.getText());
	}
	
	@FXML
	private void checkComments() {
		mainApp.showHotelComments(vo.comments, vo.hotelAddress, conditions);
	}
}
