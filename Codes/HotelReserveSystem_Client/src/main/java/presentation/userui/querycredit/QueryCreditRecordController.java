package presentation.userui.querycredit;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.ClientMainApp;
import vo.CreditRecordVO;

public class QueryCreditRecordController {
	private UserUIFactoryService userFactory;
	private QueryClientCreditRecordService queryClientCreditRecord;
	private ClientMainApp mainApp;
	private String userID;
	private CreditRecordList creditRecordList;
	private ObservableList<CreditRecord> creditRecordData = FXCollections.observableArrayList();
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

//	private ArrayList<CreditRecordVO> creditRecord;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		creditRecordList = new CreditRecordList();
		queryClientCreditRecord = userFactory.createQueryClientCreditRecordService();
//		queryClientCreditRecord = new QueryClientCreditRecordServiceImpl_Stub("原", "qwe123", "12345678900", 1500, creditRecord);
		
		creditTable.setItems(creditRecordData);
		timeColumn.setCellValueFactory(cellData -> cellData.getValue().changeTimeProperty());
		orderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
		actionColumn.setCellValueFactory(cellData -> cellData.getValue().actionProperty());
		procassColumn.setCellValueFactory(cellData -> cellData.getValue().processProperty());
		creditResultColumn.setCellValueFactory(cellData -> cellData.getValue().creditResultProperty());
	}

	public void setMainApp(ClientMainApp mainApp) {
		this.mainApp = mainApp;
	}

	//显示信用记录列表
	public void showCreditRecordList(String userID) {
		this.userID = userID;
		ArrayList<CreditRecordVO> creditRecordVOs = null;
		try {
			creditRecordVOs = queryClientCreditRecord.queryCreditRecord(this.userID);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (creditRecordVOs == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("找不到信用记录！");
			alert.setContentText("请重试！");
			alert.show();
			return;
		}
		creditRecordData.clear();
		creditRecordList.setCreditRecordList(creditRecordVOs);
		creditRecordData.addAll(creditRecordList.getCreditRecordList());
	}

	@FXML
	//返回按钮操作，返回维护个人信息界面
	public void returnButtonAction(ActionEvent event) {
		mainApp.showModifyClientInfoPanel();
	}
}