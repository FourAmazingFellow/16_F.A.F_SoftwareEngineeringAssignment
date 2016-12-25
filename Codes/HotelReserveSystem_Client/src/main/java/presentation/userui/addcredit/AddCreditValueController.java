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

/**
 * 信用充值界面
 * 
 * @author sparkler
 * @version
 * @see
 */
public class AddCreditValueController {
	private AddCreditValueService addCreditValue;
	private ModifyClientInfoService clientCreditInfo;
	private UserUIFactoryService userFactory;
	private WebsitePromotionMainApp mainApp;
	private String userID;

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
		// clientCreditInfo = new ModifyClientInfoServiceImpl_Stub("Accident",
		// "qwe123", "123456678900", UserType.Client,
		// 1000, "阿里巴巴");
		// addCreditValue = new AddCreditValueServiceImpl_Stub();

		addCreditField.setText("");
		userIDLabel.setText("");
		creditValueLabel.setText("");
	}

	public void setMainApp(WebsitePromotionMainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * 显示客户信息
	 */
	public void showClientDetail() {
		this.userID = searchField.getText();
		// this.userID = "Accident";
		ClientInfoVO client = null;

		// 搜索框用户名为空弹出警示框
		if (userID.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		try {
			client = clientCreditInfo.getClientInfo(userID);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}

		// 找不到此用户的警示框
		if (client == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("用户名输入错误！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else {
			int creditValue = client.creditValue;
			userIDLabel.setText(userID);
			creditValueLabel.setText(String.valueOf(creditValue));

		}
	}

	/**
	 * 信用充值
	 */
	public void addCreditValue() {
		// 未输入数值的警示框
		if (addCreditField.getText().equals("")) {
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("wrong");
			alert1.setHeaderText("未输入信用值！");
			alert1.setContentText("请重新输入！");
			alert1.showAndWait();
			return;
		} else {
			int creditAdded = Integer.parseInt(addCreditField.getText());
			// 信用值格式错误的警示框
			if (creditAdded % 100 != 0) {
				Alert alert2 = new Alert(AlertType.WARNING);
				alert2.setTitle("wrong");
				alert2.setHeaderText("信用值格式错误！（整百倍数）");
				alert2.setContentText("请重新输入！");
				alert2.showAndWait();
				return;
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
				alert3.showAndWait();
				return;
			} else {
				Alert alert4 = new Alert(AlertType.CONFIRMATION);
				alert4.setTitle("add info");
				alert4.setHeaderText("充值成功！");
				alert4.showAndWait();
				mainApp.showAddCreditPanel();

			}
		}
	}

	// 搜索按钮操作，显示客户信息
	public void searchButtonAction() {
		showClientDetail();
	}

	// 确认充值按钮操作，调用信用充值方法
	public void comfirmButtonAction() {
		addCreditValue();
	}

	// 取消按钮操作，返回信用初始充值界面
	public void cancelButtonAction() {
		mainApp.showAddCreditPanel();
	}

}
