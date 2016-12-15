package presentation.userui.maintain;

import java.sql.Date;

import bl_Stub.userblservice_Stub.ModifyClientInfoServiceImpl_Stub;
import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import po.UserType;
import presentation.ClientMainApp;
import presentation.userui.querycredit.QueryCreditRecordController;
import presentation.userui.signvip.SignRegularVipController;

public class ModifyClientInfoController {
	private ClientMainApp mainApp;
	private ModifyClientInfoService modifyClientInfo;
	private UserUIFactoryService userFactory;
	private String userID;
	private String password;
	private String telNum;
	private int creditValue;
	private Date birth;
	private String enterpriseName;

	@FXML
	private Label InfoLabel;

	@FXML
	private Label telNumLabel;

	@FXML
	private Button editButton;

	@FXML
	private Button signVipButton;

	@FXML
	private GridPane InfoTable;

	@FXML
	private Label userIDLabel;

	@FXML
	private Label creditValueLabel;

	@FXML
	private Label birthOrEnterpriseLabel;

	@FXML
	private Button creditButton;

	@FXML
	private void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		// modifyClientInfo = userFactory.createModifyClientInfoService();
		modifyClientInfo = new ModifyClientInfoServiceImpl_Stub("Accident", "qwe123", "12345678900", UserType.Client,
				1000, "阿里巴巴");

	}

	public void setMainApp(ClientMainApp clientMainApp) {
		this.mainApp = clientMainApp;
	}

	public void editButtonAction() {
		new EditController(userID, password, telNum, creditValue, birth, enterpriseName);
	}

	public void creditButtonAction() {
		new QueryCreditRecordController(userID);
	}

	public void signVipButtonAction() {
		if(birthOrEnterpriseLabel.getText().equals(null)){
			new SignRegularVipController();
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("您已经是会员了！");
			alert.setContentText("不可重复注册！");
			alert.show();
		}
	}
}
