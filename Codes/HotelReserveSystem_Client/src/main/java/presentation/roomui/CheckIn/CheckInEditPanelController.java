package presentation.roomui.CheckIn;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import businesslogic.strategybl.exception.WrongInputException;
import businesslogicservice.roomblservice.UpdateCheckInService;
import factory.RoomUIFactoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import po.RoomType;
import presentation.roomui.CheckIn.model.CheckIn;
import presentation.roomui.util.LocalDateAdapter;
import vo.CheckInVO;

public class CheckInEditPanelController {
    
    @FXML
    private ChoiceBox<String> roomTypeChoiceBox;
    
    @FXML
    private TextField roomNumTextField;
    
    @FXML
    private DatePicker checkInTimeDatepicker;
    
    @FXML
    private TextField hourTextField1;

    @FXML
    private TextField minuteTxtField1;
    
    @FXML
    private DatePicker expDepartTimeDatepicker;

    @FXML
    private TextField hourTextField2;

    @FXML
    private TextField minuteTxtField2;
    
    private ObservableList<String> roomTypeList = FXCollections.observableArrayList(
            "单人间", "标准间", "三人间","大床房");
    private Stage dialogStage;
    private CheckIn checkIn;
    private boolean isConfirmed = false;
    
    private RoomUIFactoryService roomUIFactoryService;
    private UpdateCheckInService updateCheckInService = roomUIFactoryService.createUpdateCheckInService();
    private String address;
    
    @FXML
    private void initialize() {
        roomNumTextField.setText("请输入入住房间数...");
        // Initialize the choiceBox
        roomTypeChoiceBox.setItems(roomTypeList);
        //增加提示词
        roomTypeChoiceBox.setTooltip(new Tooltip("select roomType to check in"));
        //入住时间设置默认值是当前时间
        checkInTimeDatepicker=new DatePicker(LocalDate.now());
        //只能创建当天的入住信息
        checkInTimeDatepicker.setDisable(true);
        hourTextField1.setText("12");
        minuteTxtField1.setText("00");
        //预计离开时间设置默认值为第二天
        expDepartTimeDatepicker=new DatePicker(LocalDate.now().plusDays(1));
        hourTextField2.setText("12");
        minuteTxtField2.setText("00");
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    //把默认的checkIn先放进去
    public void setCheckIn(CheckIn checkIn,String address) {
        //把传进来的checkIn设为成员变量，便于修改
        this.checkIn=checkIn;
        this.address=address;
        
        //设置默认选择的房间类型
        if(checkIn.getRoomType()!=null)
            roomTypeChoiceBox.setValue(RoomType.enumToChinese(checkIn.getRoomType()));
    }
    
    public boolean isConfirmed() {
        return isConfirmed;
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    @FXML
    private void handleConfirm() {
        //判断输入的数据是否有效
        boolean inputValid=false;
        while(!inputValid){
            if(isInputValid()){
                inputValid=true;
            }
        }
        //弹出对话框选择是否更新空房
        boolean updateSpareRoom=false;
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("确认和更新空房");
        alert.setHeaderText("你是否确认办理入住？如果是，请选择是否更新空房");
        alert.setContentText("Choose your option.");
        
        ButtonType confirmAndUpdate = new ButtonType("确认并更新空房");
        ButtonType confirmNotUpdate = new ButtonType("确认但不更新空房");
        ButtonType cancel = new ButtonType("取消入住", ButtonData.CANCEL_CLOSE);
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == confirmAndUpdate){
            updateSpareRoom=true;
        } else if (result.get() == confirmNotUpdate) {
            updateSpareRoom=false;
        } else if (result.get() == cancel) {
            alert.close();
            handleCancel();
            return;
        } 
        
        //把新建的checkIn传给上一个界面
        checkIn.setRoomType(RoomType.chineseToEnum(roomTypeChoiceBox.getValue()));
        checkIn.setRoomNum(Integer.parseInt(roomNumTextField.getText()));
        checkIn.setCheckInTime(LocalDateAdapter.toDate(checkInTimeDatepicker.getValue()), 
                Integer.parseInt(hourTextField1.getText()), Integer.parseInt(minuteTxtField1.getText()));
        checkIn.setExpDepartTime(LocalDateAdapter.toDate(expDepartTimeDatepicker.getValue()), 
                Integer.parseInt(hourTextField2.getText()), Integer.parseInt(minuteTxtField2.getText()));
        isConfirmed = true;
        
        //在数据库中增加入住信息
        try {
            updateCheckInService.addCheckIn(address, checkIn.toVO(address), updateSpareRoom);
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
        //判断格式对否
        if(!isDigit(roomNumTextField.getText())){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("入住信息错误");
            alert.setHeaderText("入住房间数量错误");
            alert.setContentText("请在入住房间数中输入数字");

            alert.showAndWait();
            return false;
        }
        if(checkInTimeDatepicker.getValue()==null||
                hourTextField1.getText()==""||minuteTxtField1.getText()==""){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("入住信息错误");
            alert.setHeaderText("入住时间空缺");
            alert.setContentText("请完善入住时间");

            alert.showAndWait();
            return false;
        }
        if(!isDigit(hourTextField1.getText())||!isDigit(minuteTxtField1.getText())){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("入住信息错误");
            alert.setHeaderText("入住时间错误");
            alert.setContentText("请输入正确的入住时间");

            alert.showAndWait();
            return false;
        }
        if(expDepartTimeDatepicker.getValue()==null||
                hourTextField2.getText()==""||minuteTxtField2.getText()==""){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("入住信息错误");
            alert.setHeaderText("预计离开时间空缺");
            alert.setContentText("请完善预计离开时间");

            alert.showAndWait();
            return false;
        }
        if(!isDigit(hourTextField1.getText())||!isDigit(minuteTxtField1.getText())){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("入住信息错误");
            alert.setHeaderText("预计离开时间错误");
            alert.setContentText("请输入正确的预计离开时间");

            alert.showAndWait();
            return false;
        }
        CheckInVO checkInVO;
        try {
            checkInVO=checkIn.toVO(address);
        } catch (ParseException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("入住信息错误");
            alert.setHeaderText("时间格式错误");
            alert.setContentText("请输入正确的时间");
            alert.showAndWait();
            return false;
        }
        //调用逻辑层的valid方法进一步验证数据是否合理
        try {
            if(updateCheckInService.validCheckIn(address, checkInVO)){
                return true;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (WrongInputException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("入住信息错误");
            alert.setHeaderText("入住信息错误");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return false;
    }
    
    public static boolean isDigit(String str){
        for(char c:str.toCharArray()){
            if(c<'0'||c>'9'){
                return false;
            }
        }
        return true;
    }
    
}
