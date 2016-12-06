package presentation.userui.hotelstaff;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HotelStaff extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("HotelStaffRoot.fxml"));
		Scene scene = new Scene(root, 1000, 700);
		scene.getStylesheets().add(HotelStaff.class.getResource("Theme.css").toExternalForm());
		stage.setTitle("F.A.F 酒店预订系统");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
