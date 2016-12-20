package presentation.userui.addcredit;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.AddCreditValueService;
import businesslogicservice.userblservice.ModifyClientInfoService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import presentation.WebsitePromotionMainApp;
import vo.ClientInfoVO;

public class AddCreditValueController {
	private WebsitePromotionMainApp mainApp;
	private AddCreditValueService addCreditValue;
	private ModifyClientInfoService clientCreditInfo;
	private UserUIFactoryService userFactory;

	@FXML
	private Button cancelButton;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button searchButton;

	@FXML
	private TextField searchField;

	@FXML
	private Label addCreditLabel;

	@FXML
	private Label userIDLabel;

	@FXML
	private GridPane addCreditTable;

	@FXML
	private TextField addCreditField;

	@FXML
	private HBox searchBox;

	@FXML
	private Label creditValueLabel;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		 addCreditValue = userFactory.createAddCreditValueService();
		 clientCreditInfo = userFactory.createModifyClientInfoService();
//		clientCreditInfo = new ModifyClientInfoServiceImpl_Stub("Accident", "qwe123", "123456678900", UserType.Client,
//				1000, "阿里巴巴");
//		addCreditValue = new AddCreditValueServiceImpl_Stub();
	}

	public void setMainApp(WebsitePromotionMainApp webPromotion) {
		this.mainApp = webPromotion;
	}

	public void searchButtonAction(){
		String userID = searchField.getText();
		ClientInfoVO client = null;
		try {
			client = clientCreditInfo.getClientInfo(userID);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}

		if (client == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("用户名输入错误！");
			alert.setContentText("请重新输入！");
		} else {
			int creditValue = client.creditValue;
			userIDLabel.setText(userID);
			creditValueLabel.setText(String.valueOf(creditValue));

		}
	}

	public void addCreditValue(){
		int creditAdded = Integer.parseInt(addCreditField.getText());
		if (addCreditField.getText().equals(null)) {
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("wrong");
			alert1.setHeaderText("未输入信用值！");
			alert1.setContentText("请重新输入！");
		} else if (creditAdded % 100 != 0) {
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setTitle("wrong");
			alert2.setHeaderText("信用值格式错误！（整百倍数）");
			alert2.setContentText("请重新输入！");
		}
		boolean result = false;
		try {
			result = addCreditValue.addCreditValue(userIDLabel.getText(), creditAdded);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (result == false) {
			Alert alert3 = new Alert(AlertType.WARNING);
			alert3.setTitle("wrong");
			alert3.setHeaderText("充值失败！");
			alert3.setContentText("请重试！");
		} else {
			Alert alert4 = new Alert(AlertType.CONFIRMATION);
			alert4.setTitle("add info");
			alert4.setHeaderText("充值成功！");
		}
	}

	public void comfirmButtonAction() {
		addCreditValue();
	}
	
	public void cancelButtonAction(){
		return;
	}

}
