package presentation.userui.maintain;

import java.rmi.RemoteException;
import java.sql.Date;

import bl_Stub.userblservice_Stub.ModifyClientInfoServiceImpl_Stub;
import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import po.UserType;
import presentation.ClientMainApp;
import vo.UserVO;

public class EditController {
	private ClientMainApp mainApp;
	private ModifyClientInfoService modifyClientInfo;
	private UserUIFactoryService userFactory;
	private String userID, newUserID;
	private String password;
	private String telNum, newTelNum;
	private int creditValue;
	private Date birth;
	private String enterpriseName;

	public EditController(String userID, String password, String telNum, int creditValue, Date birth,
			String enterpriseName) {
		this.userID = userID;
		this.password = password;
		this.telNum = telNum;
		this.creditValue = creditValue;
		this.birth = birth;
		this.enterpriseName = enterpriseName;
	}

	@FXML
	private Label InfoLabel;

	@FXML
	private TextField userIDField;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField telNumField;

	@FXML
	private GridPane InfoTable;

	@FXML
	private Button modifyPasswordButton;

	@FXML
	private Button saveButton;

	@FXML
	private Label birthOrEnterpriseLabel;

	@FXML
	private Label creditValueLabel;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		clientInfo();
		 modifyClientInfo = userFactory.createModifyClientInfoService();
//		modifyClientInfo = new ModifyClientInfoServiceImpl_Stub("Accident", "qwe123", "12345678900", UserType.Client,
//				1000, "阿里巴巴");
	}

	public void setMainApp(ClientMainApp clientMainApp) {
		this.mainApp = clientMainApp;
	}

	// 显示未修改前的客户信息
	public void clientInfo() {
		userIDField.setText(userID);
		telNumField.setText(telNum);
		creditValueLabel.setText(String.valueOf(creditValue));
		// 判断是否非空
		if (birth != null)
			birthOrEnterpriseLabel.setText(String.valueOf(birth));
		else if (!enterpriseName.isEmpty())
			birthOrEnterpriseLabel.setText(enterpriseName);
	}

	public void editClientInfo() throws RemoteException {
		newUserID = userIDField.getText();
		newTelNum = telNumField.getText();
		UserVO user = new UserVO(newUserID, password, newTelNum, UserType.Client);
		boolean result = modifyClientInfo.modifyClientInfo(user, userID);
		if(result == true){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("modify info");
		alert.setHeaderText("修改成功！");
		alert.show();
		}else{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("修改失败！");
			alert.setContentText("请重试！");
			alert.show();
		}
	}

	@FXML
	void cancelButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	void modifyPasswordButtonAction(ActionEvent event) {
		new ModifyPasswordController(userID, password, telNum);
	}

	@FXML
	void saveButtonAction(ActionEvent event) throws RemoteException {
		editClientInfo();

	}
}