package view.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import view.MainApp;

public class SearchPanelController {
	// Reference to the main application
	private MainApp mainApp;
	private ObservableList<String> districList = FXCollections.observableArrayList("新街口","栖霞区","鼓楼区");

	@FXML
	private Button searchButton;

	@FXML
	private TextField searchArea;

	@FXML
	private ChoiceBox<String> districtChooser;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public SearchPanelController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	private void initialize() {
		districtChooser.setItems(districList);
		districtChooser.setValue("新街口");
		//获取商圈的方法TO-DO
	}
}