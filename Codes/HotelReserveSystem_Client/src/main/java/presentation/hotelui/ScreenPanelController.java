package presentation.hotelui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class ScreenPanelController {

	@FXML
	private ChoiceBox<?> hotelPriceChoiceBox;

	@FXML
	private ChoiceBox<?> isReservedBox;

	@FXML
	private ChoiceBox<?> hotelMarkChoiceBox;

	@FXML
	private Slider starLevelSlider;

	@FXML
	private ChoiceBox<?> hotelRoomTypeChoiceBox;

	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;

	private Stage dialogStage;
	private boolean confirmClicked = false;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isConfirmClicked() {
		return confirmClicked;
	}

	@FXML
	private void handleOk() {
		confirmClicked = true;
		dialogStage.close();
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

}
