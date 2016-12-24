package presentation.mainui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import presentation.WebsiteManageMainApp;
import presentation.WebsitePromotionMainApp;

public class WebsiteManageRootBoardController {
	private WebsiteManageMainApp mainApp;

    @FXML
    private Button manageHotelSection;

    @FXML
    private MenuItem exitButton;

    @FXML
    private MenuButton userActionButton;

    @FXML
    private Button manageUserSection;

    @FXML
    private MenuItem logoutButton;


	@FXML
	void initialize() {

	}

	public void setMainApp(WebsiteManageMainApp mainApp) {
		this.mainApp = mainApp;
		userActionButton.setText(WebsitePromotionMainApp.userID);
	}
	
	@FXML
	void manageUserAction(ActionEvent event) {
		mainApp.showManageUserPanel();
	}

	@FXML
	void manageHotelAction(ActionEvent event) {
		mainApp.showManageHotelPanel();
	}
	
	public void handleLogout() {
		mainApp.logout();
	}

	public void handleExit() {
		System.exit(0);
	}
}
