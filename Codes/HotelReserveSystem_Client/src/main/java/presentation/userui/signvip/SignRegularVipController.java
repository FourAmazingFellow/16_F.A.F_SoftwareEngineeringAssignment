package presentation.userui.signvip;

import java.rmi.RemoteException;
import java.sql.Date;
import java.time.LocalDate;

import bl_Stub.userblservice_Stub.SignVipServiceImpl_Stub;
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

public class SignRegularVipController {
	private ClientMainApp mainApp;
	private SignVipService signVip;
	private ModifyClientInfoService modifyClientInfo;
	private UserUIFactoryService userFactory;
	private String userID;
	private int creditValue;
	private int vipRank;
	private Date birth;

	public SignRegularVipController(String userID) {
		this.userID = userID;
	}

	@FXML
	private HBox birthday;

	@FXML
	private Button cancelButton;

	@FXML
	private Button signButton;

	@FXML
	private DatePicker datePicker;

	@SuppressWarnings("deprecation")
	@FXML
	void initialize() {
		userFactory = new UserUIFactoryServiceImpl();
		 signVip = userFactory.createSignVipService();
		 modifyClientInfo = userFactory.createModifyClientInfoService();
//		signVip = new SignVipServiceImpl_Stub(new Date(1997 - 1900, 3 - 1, 22));
	}

	public void setMainApp(ClientMainApp clientMainApp) {
		this.mainApp = clientMainApp;
	}

	public void signRegularVip() throws RemoteException {
		LocalDate date = datePicker.getValue();
		this.birth = getDate(date);
		ClientInfoVO client = modifyClientInfo.getClientInfo(userID);
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
		RegularVipVO regularVip = new RegularVipVO(userID, client.password, client.telNum, UserType.Client,
				client.creditValue, client.creditRecord, birth, vipRank);
		boolean result = signVip.signRegularVip(regularVip);
		if (result == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("sign info");
			alert.setHeaderText("注册成功！");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("注册失败！");
			alert.setContentText("请重试！");
			alert.show();
		}
	}

	@SuppressWarnings("deprecation")
	public Date getDate(LocalDate date) {
		return new Date(date.getYear() - 1900, date.getMonthValue() - 1, date.getDayOfMonth());
	}

	@FXML
	// 取消按钮action
	void cancelButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	// 注册按钮action，跳转提示框（是否注册成功）
	void signButttonAction(ActionEvent event) throws RemoteException {
		signRegularVip();
	}
}
