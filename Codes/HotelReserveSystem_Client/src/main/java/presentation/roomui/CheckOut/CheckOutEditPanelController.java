package presentation.roomui.CheckOut;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import businesslogic.strategybl.exception.WrongInputException;
import businesslogicservice.roomblservice.UpdateCheckOutService;
import factory.RoomUIFactoryService;
import factory.RoomUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import po.RoomType;
import presentation.roomui.CheckIn.CheckInEditPanelController;
import presentation.roomui.CheckOut.model.CheckOut;
import presentation.roomui.util.LocalDateAdapter;
import vo.CheckOutVO;

public class CheckOutEditPanelController {

    @FXML
    private ChoiceBox<String> roomTypeChoiceBox;

    @FXML
    private TextField roomNumTextField;

    @FXML
    private DatePicker actDepartTimeDatepicker;

    @FXML
    private TextField hourTextField;

    @FXML
    private TextField minuteTxtField;

    private ObservableList<String> roomTypeList = FXCollections.observableArrayList("单人间", "标准间", "三人间", "大床房");
    private Stage dialogStage;
    private CheckOut checkOut;
    private boolean isConfirmed = false;

    private RoomUIFactoryService roomUIFactoryService = new RoomUIFactoryServiceImpl();
    private UpdateCheckOutService updateCheckOutService = roomUIFactoryService.createUpdateCheckOutService();
    private String address;

    @FXML
    private void initialize() {
        roomNumTextField.setText("请输入退房房间数...");

        // Initialize the choiceBox
        roomTypeChoiceBox.setItems(roomTypeList);
        // 增加提示词
        roomTypeChoiceBox.setTooltip(new Tooltip("select roomType to check out"));
        // 退房时间设置默认值是当前时间
        actDepartTimeDatepicker.setValue(LocalDate.now());
        // 只能创建当天的入住信息
        hourTextField.setText("12");
        minuteTxtField.setText("00");
        actDepartTimeDatepicker.setEditable(false);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    // 把默认的checkOut先放进去
    public void setCheckOut(CheckOut checkOut, String address) {
        // 把传进来的checkIn设为成员变量，便于修改
        this.checkOut = checkOut;
        this.address = address;

        if (checkOut.getRoomType() != null) {
            roomTypeChoiceBox.getSelectionModel().select(RoomType.enumToChinese(checkOut.getRoomType()));
        }
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }
    
    @FXML
    void handleClickRoomNum(MouseEvent event) {
        if(roomNumTextField.getText().equals("请输入退房房间数..."))
            roomNumTextField.setText("");
    }

    @FXML
    void handleCanclel() {
        dialogStage.close();
    }

    @FXML
    void handleConfirm() {
        // 判断输入的数据是否有效
        if (!isInputValid()) {
            return;
        }

        // 弹出对话框请求确认
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("确认退房");
        alert.setHeaderText("你是否确定要退房？");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            isConfirmed = true;
        } else {
            isConfirmed = false;
            handleCanclel();
            return;
        }
        // 把新建的checkOut传给上一个界面
        checkOut.setRoomType(RoomType.chineseToEnum(roomTypeChoiceBox.getSelectionModel().getSelectedItem()));
        checkOut.setRoomNum(Integer.parseInt(roomNumTextField.getText()));
        checkOut.setActDepartTime(LocalDateAdapter.toDate(actDepartTimeDatepicker.getValue()),
                Integer.parseInt(hourTextField.getText()), Integer.parseInt(minuteTxtField.getText()));

        // 在数据库中增加退房信息
        try {
            updateCheckOutService.addCheckOut(address, checkOut.toVO(address));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (WrongInputException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dialogStage.close();
    }

    private boolean isInputValid() {
        // 判断格式对否
        if(roomTypeChoiceBox.getValue()==null){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("退房信息错误");
            alert.setHeaderText("退房房间类型空缺");
            alert.setContentText("请选择退房房间类型");

            alert.showAndWait();
            return false;
        }
        if (roomNumTextField.getText().equals("")|| !isInteger(roomNumTextField.getText())) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("退房信息错误");
            alert.setHeaderText("退房房间数量错误");
            alert.setContentText("请在退房房间数中输入数字");

            alert.showAndWait();
            return false;
        }
        if (actDepartTimeDatepicker.getValue() == null || hourTextField.getText().equals("")
                || minuteTxtField.getText().equals("")) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("退房信息错误");
            alert.setHeaderText("实际离开时间空缺");
            alert.setContentText("请完善实际离开时间");

            alert.showAndWait();
            return false;
        }
        if (!isHourNum(hourTextField.getText()) || !isMinuteNum(minuteTxtField.getText())) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("退房信息错误");
            alert.setHeaderText("实际离开时间错误");
            alert.setContentText("请输入正确的实际离开时间");

            alert.showAndWait();
            return false;
        }
        CheckOutVO checkOutVO;
        CheckOut tmpCheckOut=new CheckOut();
        tmpCheckOut.setRoomType(RoomType.chineseToEnum(roomTypeChoiceBox.getSelectionModel().getSelectedItem()));
        tmpCheckOut.setRoomNum(Integer.parseInt(roomNumTextField.getText()));
        tmpCheckOut.setActDepartTime(LocalDateAdapter.toDate(actDepartTimeDatepicker.getValue()),
                Integer.parseInt(hourTextField.getText()), Integer.parseInt(minuteTxtField.getText()));
        try {
            checkOutVO = tmpCheckOut.toVO(address);
        } catch (ParseException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("退房信息错误");
            alert.setHeaderText("时间格式错误");
            alert.setContentText("请输入正确的实际离开时间");
            alert.showAndWait();
            return false;
        }
        // 调用逻辑层的valid方法进一步验证数据是否合理
        try {
            if (updateCheckOutService.validCheckOut(address, checkOutVO)) {
                return true;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (WrongInputException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("退房信息错误");
            alert.setHeaderText("退房信息错误");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return false;
    }

    private boolean isHourNum(String hourStr){
        if(!isInteger(hourStr)){
            return false;
        }
        int hour=Integer.parseInt(hourStr);
        if(hour<0||hour>=24){
            return false;
        }
        return true;
    }
    
    private boolean isMinuteNum(String minuteStr){
        if(!isInteger(minuteStr)){
            return false;
        }
        int hour=Integer.parseInt(minuteStr);
        if(hour<0||hour>=60){
            return false;
        }
        return true;
    }
    
    private boolean isInteger(String str){
        for (char c : str.toCharArray()) {
            if ((c < '0' || c > '9')) {
                return false;
            }
        }
        return true;
    }
}
