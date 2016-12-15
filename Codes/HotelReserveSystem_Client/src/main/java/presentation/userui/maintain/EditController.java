package presentation.userui.maintain;

import java.sql.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EditController {
	private String userID;
	private String password;
	private String telNum;
	private int creditValue;
	private Date birth;
	private String enterpriseName;

	public EditController(String userID, String password, String telNum, int creditValue, Date birth,
			String enterpriseName) {
		this.userID = userID;
		this.password = password;
		this.telNum = telNum;
		this.creditValue = creditValue;
		this.birth = birth;
		this.enterpriseName = enterpriseName;
	}

	@FXML
	private Label InfoLabel;

	@FXML
	private Button cancelButton;

	@FXML
	private GridPane InfoTable;

	@FXML
	private Button modifyPasswordButton;

	@FXML
	private Button saveButton;

}