package presentation.userui.manageuser;

import businesslogicservice.userblservice.ManageUserInfoService;
import businesslogicservice.userblservice.ModifyClientInfoService;
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
import presentation.WebsiteManageMainApp;
import vo.UserVO;

public class addNewUserController {
	private WebsiteManageMainApp mainApp;
	private UserUIFactoryServiceImpl userFactory;
	private ManageUserInfoService manageUser;
	private ModifyClientInfoService modifyClientInfo;
	private String userID;
	private String password;
	private String telNum;
	  @FXML
	    private TextField webMarketPasswordField;

	    @FXML
	    private Button cancelButton;

	    @FXML
	    private GridPane webMarketStaffInfo1;

	    @FXML
	    private TextField webMarketUserIDField;

	    @FXML
	    private TextField webMarketTelNumField;

	    @FXML
	    private Button confirmButton;

	    @FXML
	    private Label manageUserLabel;

	    @FXML
	    void initialize() {
	    	userFactory = new UserUIFactoryServiceImpl();
			manageUser = userFactory.createManageUserInfoService();
	    }
	    
	    public void addNewUser(){
	    	this.userID = webMarketUserIDField.getText();
	    	this.password = webMarketPasswordField.getText();
	    	this.telNum = webMarketTelNumField.getText();
	    	UserVO user = new UserVO(userID, password, telNum, UserType.WebMarketStaff);
	    	boolean result = manageUser.add(user);
	    	if(result == true){
	    		Alert alert = new Alert(AlertType.CONFIRMATION);
	    		alert.setTitle("add info");
	    		alert.setHeaderText("添加成功！");
	    		alert.show();
	    		}else{
	    			Alert alert = new Alert(AlertType.CONFIRMATION);
	    			alert.setTitle("wrong");
	    			alert.setHeaderText("添加失败！");
	    			alert.setContentText("请重试！");
	    			alert.show();
	    		}
	    }
	    
	    @FXML
	    void cancelButtonAction(ActionEvent event) {
	    	return;
	    }

	    @FXML
	    void confirmButtonAction(ActionEvent event) {
	    	addNewUser();
	    }
}
