package presentation.hotelui.commenthotel;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.CommentOnHotelService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import presentation.ClientMainApp;

public class CommentOnHotelController {
	private HotelUIFactoryService hotelFactory;
	private ClientMainApp mainApp;
	private CommentOnHotelService comment;
	private String userID;
	private String hotelAddress;
	private float mark;
	private String comments;
	
	public CommentOnHotelController(String userID, String hotelAddress) {
		this.userID = userID;
		this.hotelAddress = hotelAddress;
	}
	@FXML
	private Label commentLabel;

	@FXML
	private Button cancelButton;

	@FXML
	private TextArea commentArea;

	@FXML
	private TextField rankField;

	@FXML
	private GridPane commentField;

	@FXML
	private Button confirmButton;

	@FXML
	void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		comment = hotelFactory.createCommentOnHotelService();
	}
	
	public void setMainApp(ClientMainApp mainApp){
		this.mainApp = mainApp;
	}
	
	public void commentOnHotel() throws RemoteException{
		this.mark = Float.parseFloat(rankField.getText());
		this.comments = commentArea.getText();
		boolean result = comment.confirmComment(userID, mark, comments, hotelAddress);
		if (result == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("comment info");
			alert.setHeaderText("评价成功！");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("评价失败！");
			alert.setContentText("请重试！");
			alert.show();
		}
	}
	
	@FXML
	void cancelButtonAction(ActionEvent event) {
		return;
	}

	@FXML
	void confirmButtonAction(ActionEvent event) throws RemoteException {
		commentOnHotel();
	}
}