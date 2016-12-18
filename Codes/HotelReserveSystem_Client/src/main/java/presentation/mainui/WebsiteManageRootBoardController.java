package presentation.mainui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import presentation.WebsiteManageMainApp;

public class WebsiteManageRootBoardController {
	private WebsiteManageMainApp mainApp;

	@FXML
	private Button manageHotelSection;

	@FXML
	private MenuButton userActionButton;

	@FXML
	private MenuItem userIDMenuItem;

	@FXML
	private Button manageUserSection;	

	@FXML
	void initialize() {

	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	void manageUserAction(ActionEvent event) {
		mainApp.showManageUserPanel();
	}

	@FXML
	void manageHotelAction(ActionEvent event) {
		mainApp.showManageHotelPanel();
	}
}
