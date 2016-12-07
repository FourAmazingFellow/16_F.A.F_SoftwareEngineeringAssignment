package presentation.userui.manageuser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ManageUserController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button cancelButton;

	@FXML
	private Button modifyButton;

	@FXML
	private Tab webMarketStaffTab;

	@FXML
	private GridPane hotelStaffInfo;

	@FXML
	private GridPane clientInfo;

	@FXML
	private Button addButton;

	@FXML
	private Tab clientTab;

	@FXML
	private Tab hotelStaffTab;

	@FXML
	private GridPane webMarketStaffInfo;

	@FXML
	private Button confirmButton;

	@FXML
	private Label manageUserLabel;

	@FXML
	private HBox searchBox;

	@FXML
	void initialize() {
		assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert modifyButton != null : "fx:id=\"modifyButton\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert webMarketStaffTab != null : "fx:id=\"webMarketStaffTab\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert hotelStaffInfo != null : "fx:id=\"hotelStaffInfo\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert clientInfo != null : "fx:id=\"clientInfo\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert clientTab != null : "fx:id=\"clientTab\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert hotelStaffTab != null : "fx:id=\"hotelStaffTab\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert webMarketStaffInfo != null : "fx:id=\"webMarketStaffInfo\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert manageUserLabel != null : "fx:id=\"manageUserLabel\" was not injected: check your FXML file 'ManageUser.fxml'.";
		assert searchBox != null : "fx:id=\"searchBox\" was not injected: check your FXML file 'ManageUser.fxml'.";

	}
}
