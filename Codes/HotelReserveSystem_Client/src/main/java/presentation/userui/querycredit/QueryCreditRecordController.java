package presentation.userui.querycredit;

import java.util.ArrayList;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import po.CreditRecordPO;
import presentation.ClientMainApp;
import presentation.hotelui.enrollavaluableroom.Room;
import vo.CreditRecordVO;
import vo.RoomVO;

public class QueryCreditRecordController {
	private UserUIFactoryService userFactory;
	private QueryClientCreditRecordService queryClientCreditRecord;
	private ClientMainApp mainApp;
	private String userID;
	private CreditRecordList creditRecordList;
	private ObservableList<CreditRecord> creditRecordData = FXCollections.observableArrayList();


	public QueryCreditRecordController(String userID) {
		this.userID = userID;
	}

	@FXML
	private Label creditLabel;

	@FXML
	private Button returnButton;

	@FXML
	private TableView<CreditRecord> creditTable;

	@FXML
	private TableColumn<CreditRecord, String> timeColumn;

	@FXML
	private TableColumn<CreditRecord, String> actionColumn;

	@FXML
	private TableColumn<CreditRecord, String> procassColumn;

	@FXML
	private TableColumn<CreditRecord, String> orderIDColumn;

	@FXML
	private TableColumn<CreditRecord, String> creditResultColumn;

	@FXML
	void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		queryClientCreditRecord = userFactory.createQueryClientCreditRecordService();
		
		timeColumn.setCellValueFactory(cellData -> cellData.getValue().changeTimeProperty());
		orderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
		actionColumn.setCellValueFactory(cellData -> cellData.getValue().actionProperty());
		procassColumn.setCellValueFactory(cellData -> cellData.getValue().processProperty());
		creditResultColumn.setCellValueFactory(cellData -> cellData.getValue().creditResultProperty());
	}
	
	public void setMainApp(ClientMainApp mainApp){
		this.mainApp = mainApp;
	}
	
	public void showCreditRecordList(){
		ArrayList<CreditRecordVO> creditRecordVOs = queryClientCreditRecord.queryCreditRecord(userID);
		creditRecordList.setCreditRecordList(creditRecordVOs);
		creditRecordData.clear();
		creditRecordData.addAll(creditRecordList.getCreditRecordList());
	}
	
	@FXML
	void returnButtonAction(ActionEvent event) {
		return;
	}
}