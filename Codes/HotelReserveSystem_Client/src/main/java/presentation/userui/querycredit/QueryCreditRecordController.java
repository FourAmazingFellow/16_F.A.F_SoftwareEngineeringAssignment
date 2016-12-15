package presentation.userui.querycredit;

import javafx.fxml.FXML;
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
	private TableView<?> creditTable;

}