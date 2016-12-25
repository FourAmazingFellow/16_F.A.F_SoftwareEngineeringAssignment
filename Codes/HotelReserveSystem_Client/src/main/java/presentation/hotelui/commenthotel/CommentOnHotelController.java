package presentation.hotelui.commenthotel;

import java.rmi.RemoteException;

import businesslogicservice.hotelblservice.CommentOnHotelService;
import factory.HotelUIFactoryService;
import factory.HotelUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import presentation.ClientMainApp;
import presentation.userui.JudgeFormat;

/**
 * 客户从订单详情进去的评价酒店界面
 * 
 * @author sparkler
 * @version
 * @see
 */
public class CommentOnHotelController {
	private HotelUIFactoryService hotelFactory;
	private ClientMainApp mainApp;
	private CommentOnHotelService comment;
	private String userID;
	private String hotelAddress;
	private float mark;
	private String orderID;
	private String comments;
	private JudgeFormat judge = new JudgeFormat();

	@FXML
	private Label commentLabel;

	@FXML
	private Button cancelButton;

	@FXML
	private TextArea commentArea;

	@FXML
	private ChoiceBox<Integer> markChoiceBox;

	@FXML
	private GridPane commentField;

	@FXML
	private Button confirmButton;

	@FXML
	public void initialize() {
		hotelFactory = new HotelUIFactoryServiceImpl();
		comment = hotelFactory.createCommentOnHotelService();

		markChoiceBox.setItems((ObservableList<Integer>) FXCollections.observableArrayList(1, 2, 3, 4, 5));
		markChoiceBox.getSelectionModel().select(4);
		commentArea.setText("");

	}

	public void setMainApp(ClientMainApp mainApp) {
		this.mainApp = mainApp;
	}

	// 设置用户名和酒店地址
	public void setuserIDAndAddress(String userID, String address, String orderID) {
		this.userID = userID;
		this.hotelAddress = address;
		this.orderID = orderID;
	}

	// 评价酒店
	public void commentOnHotel() {
		this.mark = markChoiceBox.getSelectionModel().getSelectedItem();
		this.comments = commentArea.getText();
		int commentsLength = judge.getStringLength(comments);

		// 检查填写内容是否合理
		if (comments.equals("")) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("信息填写不完整！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		} else if (commentsLength < 5) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("wrong");
			alert.setHeaderText("长度不合理（至少五个字）！");
			alert.setContentText("请重新输入！");
			alert.showAndWait();
			return;
		}
		boolean result = false;
		try {
			result = comment.confirmComment(userID, mark, comments, hotelAddress, orderID);
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("NetWork Warning");
			alert.setHeaderText("Fail to connect with the server!");
			alert.setContentText("Please check your network connection!");
			alert.showAndWait();
		}
		if (result == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("comment info");
			alert.setHeaderText("评价成功！");
			alert.showAndWait();
			mainApp.showUserOrderPanel(userID);
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("wrong");
			alert.setHeaderText("评价失败！");
			alert.setContentText("请重试！");
			alert.showAndWait();
			return;
		}
	}

	@FXML
	// 取消按钮操作
	void cancelButtonAction(ActionEvent event) {
		mainApp.showDetailedOrderPanel(orderID);
	}

	@FXML
	// 确定按钮操作
	void confirmButtonAction(ActionEvent event) {
		commentOnHotel();
	}

}