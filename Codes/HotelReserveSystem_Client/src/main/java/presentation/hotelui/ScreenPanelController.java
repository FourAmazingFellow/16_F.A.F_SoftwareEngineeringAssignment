package presentation.hotelui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class ScreenPanelController {

	@FXML
	private ChoiceBox<String> hotelPriceChoiceBox;

	@FXML
	private ChoiceBox<String> isReservedBox;

	@FXML
	private ChoiceBox<String> hotelMarkChoiceBox;

	@FXML
	private Slider starLevelSlider;

	@FXML
	private ChoiceBox<String> hotelRoomTypeChoiceBox;

	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;

	private Stage dialogStage;
	private String[] conditions;
	private boolean confirmClicked = false;

	@FXML
	private void initialize() {
		hotelPriceChoiceBox.setItems(FXCollections.observableArrayList("不限", "低于200", "200-400", "400-600", "600-800", "800以上"));
		hotelMarkChoiceBox.setItems(FXCollections.observableArrayList("3", "4", "5"));
		hotelRoomTypeChoiceBox.setItems(FXCollections.observableArrayList("单人房","标准间","三人房","大床房"));
		isReservedBox.setItems(FXCollections.observableArrayList("否", "是"));
		
		hotelPriceChoiceBox.setValue("不限");
		hotelMarkChoiceBox.setValue("4");
		hotelRoomTypeChoiceBox.setValue("标准间");
		isReservedBox.setValue("否");
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isConfirmClicked() {
		return confirmClicked;
	}

	public void setConditions(String[] _conditions) {
		this.conditions = _conditions;
	}
	
	@FXML
	private void handleOk() {
		confirmClicked = true;
		setPriceRange();
		conditions[5] = String.valueOf((int)starLevelSlider.getValue());
		conditions[10] = String.valueOf(hotelRoomTypeChoiceBox.getSelectionModel().getSelectedIndex());
		conditions[9] = String.valueOf(isReservedBox.getSelectionModel().getSelectedIndex());
		
		dialogStage.close();
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	private void setPriceRange() {
		int index = hotelPriceChoiceBox.getSelectionModel().getSelectedIndex();
		if(index == 0) {
			conditions[3] = String.valueOf(0);
			conditions[4] = String.valueOf(10000000);
		}else if(index == 1) {
			conditions[3] = String.valueOf(0);
			conditions[4] = String.valueOf(200);
		}else if(index == 2) {
			conditions[3] = String.valueOf(200);
			conditions[4] = String.valueOf(400);
		}else if(index == 3) {
			conditions[3] = String.valueOf(400);
			conditions[4] = String.valueOf(600);
		}else if(index == 4) {
			conditions[3] = String.valueOf(600);
			conditions[4] = String.valueOf(800);
		}else {
			conditions[3] = String.valueOf(800);
			conditions[4] = String.valueOf(10000000);
		}
	}
}
