package presentation.userui.querycredit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class QueryCreditRecordController {
	private String userID;

	public QueryCreditRecordController(String userID) {
		this.userID = userID;
	}

	@FXML
	private Label creditLabel;

	@FXML
	private Button returnButton;

	@FXML
	private TableView<?> creditTable;

	@FXML
	void returnButtonAction(ActionEvent event) {

	}

	@FXML
	void initialize() {

	}
}