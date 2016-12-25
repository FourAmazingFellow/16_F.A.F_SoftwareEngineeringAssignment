package presentation.userui.signvip;

import java.rmi.RemoteException;
import java.sql.Date;
import java.time.LocalDate;

import businesslogicservice.userblservice.ModifyClientInfoService;
import businesslogicservice.userblservice.SignVipService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import po.UserType;
import presentation.ClientMainApp;
import vo.ClientInfoVO;
import vo.RegularVipVO;

/**
 * 注册普通会员界面
 * 
 * @author sparkler
 * @version
 * @see
 */
public class SignRegularVipController {
	private ClientMainApp mainApp;
	private SignVipService signVip;
	private ModifyClientInfoService modifyClientInfo;
	private UserUIFactoryService userFactory;
	private String userID;
	private int creditValue;
	private int vipRank;
	private Date birth;

	@FXML
	private HBox birthday;

	@FXML
	private Button cancelButton;

	@FXML
	private Button signButton;

	@FXML
	private DatePicker datePicker;

	@FXML
	public void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		signVip = userFactory.createSignVipService();
		modifyClientInfo = userFactory.createModifyClientInfoService();
		// signVip = new SignVipServiceImpl_Stub(new Date(1997 - 1900, 3 - 1,
		// 22));

		// datePicker.setValue(LocalDate.now());
		datePicker.setEditable(false);
	}

	public void setMainApp(ClientMainApp clientMainApp) {
		this.mainApp = clientMainApp;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void signRegularVip() {
		LocalDate date = datePicker.getValue();

		if (date == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("未选择生日！");
			alert.setContentText("请选择！");
			alert.showAndWait();
			return;
		}

		this.birth = getDate(date);

		ClientInfoVO client = null;
		try {
			client = modifyClientInfo.getClientInfo(userID);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}

		// 根据目前客户的信用值更新初始会员信息中的vipRank
		this.creditValue = client.creditValue;
		if (creditValue <= 600)
			this.vipRank = 0;
		else if (creditValue > 600 && creditValue <= 2000)
			this.vipRank = 1;
		else if (creditValue > 2000 && creditValue <= 6000)
			this.vipRank = 2;
		else if (creditValue > 6000 && creditValue <= 12000)
			this.vipRank = 3;
		else if (creditValue > 12000)
			this.vipRank = 4;

		// new一个普通会员VO
		RegularVipVO regularVip = new RegularVipVO(userID, client.password, client.telNum, UserType.Client,
				client.creditValue, client.creditRecord, birth, vipRank);
		boolean result = false;
		try {
			result = signVip.signRegularVip(regularVip);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (result == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("sign info");
			alert.setHeaderText("注册成功！");
			alert.showAndWait();
			mainApp.showModifyClientInfoPanel();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("注册失败！");
			alert.setContentText("请重试！");
			alert.showAndWait();
			return;
		}
	}

	@SuppressWarnings("deprecation")
	// date转换方法
	public Date getDate(LocalDate date) {
		return new Date(date.getYear() - 1900, date.getMonthValue() - 1, date.getDayOfMonth());
	}

	@FXML
	// 取消按钮action,返回维护个人信息界面
	public void cancelButtonAction(ActionEvent event) {
		mainApp.showModifyClientInfoPanel();
	}

	@FXML
	// 注册按钮action，跳转提示框（是否注册成功）
	public void signButttonAction(ActionEvent event) {
		signRegularVip();
	}
}
