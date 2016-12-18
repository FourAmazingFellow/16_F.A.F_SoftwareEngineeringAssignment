package presentation.userui.maintain;

import java.sql.Date;
import java.util.Optional;

import bl_Stub.userblservice_Stub.ModifyClientInfoServiceImpl_Stub;
import businesslogic.userbl.VipInfo;
import businesslogicservice.userblservice.ModifyClientInfoService;
import businesslogicservice.userblservice.SignVipService;
import factory.UserUIFactoryService;
import factory.UserUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import po.UserType;
import presentation.ClientMainApp;
import presentation.userui.querycredit.QueryCreditRecordController;
import presentation.userui.signvip.SignEnterpriseVipController;
import presentation.userui.signvip.SignRegularVipController;
import vo.ClientInfoVO;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

public class ModifyClientInfoController {
	private ClientMainApp mainApp;
	private ModifyClientInfoService modifyClientInfo;
	private VipInfo vipInfo;
	private UserUIFactoryService userFactory;
	private String userID;
	private String password;
	private String telNum;
	private int creditValue;
	private Date birth;
	private String enterpriseName;

	public ModifyClientInfoController(String userID) {
		this.userID = userID;
	}
	
	@FXML
	private Label InfoLabel;

	@FXML
	private Label telNumLabel;


	@FXML
	private GridPane InfoTable;

	@FXML
	private Label userIDLabel;

	@FXML
	private Label creditValueLabel;

	@FXML
	private Label birthOrEnterpriseLabel;
	
	@FXML
	private Button editButton;
	
	@FXML
	private Button signVipButton;

	@FXML
	private Button creditButton;

	@FXML
	private void initialize() {
		userIDLabel.setText(null);
		creditValueLabel.setText(null);
		birthOrEnterpriseLabel.setText(null);
		clientInfo(userID);
		userFactory = new UserUIFactoryServiceImpl();
		// modifyClientInfo = userFactory.createModifyClientInfoService();
		modifyClientInfo = new ModifyClientInfoServiceImpl_Stub("Accident", "qwe123", "12345678900", UserType.Client,
				1000, "阿里巴巴");

	}

	public void setMainApp(ClientMainApp clientMainApp) {
		this.mainApp = clientMainApp;
	}

	//获取客户信息，显示在界面上
	public void clientInfo(String userID){
		ClientInfoVO client = modifyClientInfo.getClientInfo(userID);
		this.userID = userID;
		this.password = client.password;
		this.telNum = client.telNum;
		this.creditValue = client.creditValue;
		RegularVipVO regular = vipInfo.getRegularVipInfo(userID);
		this.birth = regular.birth;
		EnterpriseVipVO enterprise = vipInfo.getEnterpriseVipInfo(userID);
		this.enterpriseName = enterprise.enterpriseID;
		
		userIDLabel.setText(userID);
		telNumLabel.setText(telNum);
		creditValueLabel.setText(String.valueOf(creditValue));
		//判断是否非空
		if(birth != null)
			birthOrEnterpriseLabel.setText(String.valueOf(birth));
		else if(!enterpriseName.isEmpty())
			birthOrEnterpriseLabel.setText(enterpriseName);
	}
	
	@FXML
	//编辑按钮action，跳转编辑界面
	public void editButtonAction() {
		new EditController(userID, password, telNum, creditValue, birth, enterpriseName);
	}

	@FXML
	//查看信用记录按钮action，跳转信用记录界面
	public void creditButtonAction() {
		new QueryCreditRecordController(userID);
	}

	@FXML
	//注册会员按钮action，跳转注册会员相关界面
	public void signVipButtonAction() {
		//检查生日（企业名）一栏，若为空则说明不是会员，可以注册
		if(birthOrEnterpriseLabel.getText().equals(null)){
			Alert alert = new Alert(AlertType.NONE);
			ButtonType signRegularVip = new ButtonType("注册普通会员");
			ButtonType signEnterpriseVip = new ButtonType("注册企业会员");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.get() == signRegularVip){
				new SignRegularVipController(userID);
			}else if(result.get() == signEnterpriseVip){
				new SignEnterpriseVipController(userID);
			}
			//不为空则已经是会员了，不可重复注册
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("您已经是会员了！");
			alert.setContentText("不可重复注册！");
			alert.show();
		}
	}
}
