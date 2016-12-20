package presentation.mainui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import presentation.ClientMainApp;

public class ClientRootBoardController {
	@FXML
	private MenuItem personalInfoButton;

	@FXML
	private MenuItem logoutButton;

	@FXML
	private MenuItem exitButton;

	@FXML
	private MenuButton userActionButton;

	@FXML
	private Button modifyPersonalInfoSection;

	@FXML
	private Button myOrderSection;

	@FXML
	private Button myReservedHotelSection;

	@FXML
	private Button searchHotelSection;

	@FXML
	private Button homeButton;

	private ClientMainApp mainApp;

	@FXML
	private void initialize() {
		userActionButton.setText(ClientMainApp.userID);
	}
	
	public void setMainApp(ClientMainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void modifyPersonalInfoAction() {
		mainApp.showModifyClientInfoPanel(ClientMainApp.userID);
	}

	public void myOrderAction() {
		mainApp.showUserOrderPanel(ClientMainApp.userID);
	}

	public void myReservedHotelAction() {
		mainApp.showReservedHotelPanel();
	}

	public void searchHotelAction() {
		mainApp.showSearchView();
	}

	public void handleLogout() {
		mainApp.logout();
	}

	public void handleExit() {
		System.exit(0);
	}

}
