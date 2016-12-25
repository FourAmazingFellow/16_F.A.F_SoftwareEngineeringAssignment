package presentation.strategyui.manageHotelPromotion;

import java.rmi.RemoteException;
import java.text.ParseException;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToModifyStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogicservice.strategyblservice.UpdateStrategyService;
import factory.StrategyUIFactoryService;
import factory.StrategyUIFactoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import po.StrategyType;
import presentation.roomui.util.LocalDateAdapter;
import presentation.strategyui.model.Strategy;
import vo.StrategyVO;

/**
 * 编辑酒店营销策略界面的控制类
 * @author 双
 * @version 
 * @see
 */
public class PromotionEditPanelController {

    @FXML
    private TabPane strategyTypeTabPane;

    @FXML
    private Tab birthdayPromotionTab;

    @FXML
    private Tab multiRoomPromotionTab;

    @FXML
    private Tab cooperationEnterPrisePromotionTab;

    @FXML
    private Tab specialTimePromotionTab;

    @FXML
    private TextField strategyNameTextField1;

    @FXML
    private TextField discountTextField1;

    @FXML
    private TextField strategyNameTextField2;

    @FXML
    private TextField discountTextField2;

    @FXML
    private TextField minRoomTextField2;

    @FXML
    private TextField strategyNameTextField3;

    @FXML
    private TextField discountTextField3;

    @FXML
    private TextField cooperationEnterpriseTextField3;

    @FXML
    private TextField securityCodeTextField3;

    @FXML
    private TextField strategyNameTextField4;

    @FXML
    private TextField discountTextField4;

    @FXML
    private DatePicker startTimeDatePicker4;

    @FXML
    private DatePicker endTimeDatePicker4;

    private Stage dialogStage;
    private Strategy strategy;
    private boolean isConfirmed = false;

    private StrategyUIFactoryService strategyUIFactoryService = new StrategyUIFactoryServiceImpl();
    private UpdateStrategyService updateStrategyService = strategyUIFactoryService.createUpdateStrategyService();
    private String address;
    private boolean isNewPromotion;

    @FXML
    private void initialize() {
        startTimeDatePicker4.setEditable(false);
        endTimeDatePicker4.setEditable(false);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setStrategy(Strategy strategy, String address, boolean isNewaPromotion) {
        // 把传进来的strategy设为成员变量，便于修改
        this.strategy = strategy;
        this.address = address;
        this.isNewPromotion = isNewaPromotion;
        // 把其他策略类型的tab设置为disable,并把不能修改的东西设成disable,如果是修改strategy,把默认值设为原始值
        if (strategy.getStrategyType() == StrategyType.BirthdayPromotion) {
            cooperationEnterPrisePromotionTab.setDisable(true);
            multiRoomPromotionTab.setDisable(true);
            specialTimePromotionTab.setDisable(true);
            strategyTypeTabPane.getSelectionModel().select(0);
            if (!isNewaPromotion) {
                strategyNameTextField1.setText(strategy.getStrategyName());
                discountTextField1.setText(String.valueOf(strategy.getDiscount()));
                strategyNameTextField1.setDisable(true);
            }
        } else if (strategy.getStrategyType() == StrategyType.CooperationEnterprisePromotion) {
            birthdayPromotionTab.setDisable(true);
            multiRoomPromotionTab.setDisable(true);
            specialTimePromotionTab.setDisable(true);
            strategyTypeTabPane.getSelectionModel().select(2);
            if (!isNewaPromotion) {
                strategyNameTextField3.setText(strategy.getStrategyName());
                discountTextField3.setText(String.valueOf(strategy.getDiscount()));
                cooperationEnterpriseTextField3.setText(strategy.getEnterpriseName());
                securityCodeTextField3.setText(strategy.getSecurityCode());
                strategyNameTextField3.setDisable(true);
            }
        } else if (strategy.getStrategyType() == StrategyType.MultiRoomPromotion) {
            birthdayPromotionTab.setDisable(true);
            cooperationEnterPrisePromotionTab.setDisable(true);
            specialTimePromotionTab.setDisable(true);
            strategyTypeTabPane.getSelectionModel().select(1);
            if (!isNewaPromotion) {
                strategyNameTextField2.setText(strategy.getStrategyName());
                discountTextField2.setText(String.valueOf(strategy.getDiscount()));
                minRoomTextField2.setText(String.valueOf(strategy.getMinRoomNum()));
                strategyNameTextField2.setDisable(true);
            }
        } else if (strategy.getStrategyType() == StrategyType.SpecificTimePromotion) {
            birthdayPromotionTab.setDisable(true);
            cooperationEnterPrisePromotionTab.setDisable(true);
            multiRoomPromotionTab.setDisable(true);
            strategyTypeTabPane.getSelectionModel().select(3);
            if (!isNewaPromotion) {
                strategyNameTextField4.setText(strategy.getStrategyName());
                discountTextField4.setText(String.valueOf(strategy.getDiscount()));
                try {
                    startTimeDatePicker4.setValue(LocalDateAdapter.fromDate(strategy.getStartTime()));
                    endTimeDatePicker4.setValue(LocalDateAdapter.fromDate(strategy.getEndTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                strategyNameTextField4.setDisable(true);
            }
        }
    }

    @FXML
    void handleCancel() {
        dialogStage.close();
    }

    @FXML
    void handleConfirm() {
        // 判断输入的数据是否有效
        if (!isInputValid()) {
            return;
        }
        // 把新建或修改的strategy传给上一个界面
        if (strategy.getStrategyType() == StrategyType.BirthdayPromotion) {
            strategy.setStrategyName(strategyNameTextField1.getText());
            strategy.setDiscount(Float.parseFloat(discountTextField1.getText()));
        } else if (strategy.getStrategyType() == StrategyType.MultiRoomPromotion) {
            strategy.setStrategyName(strategyNameTextField2.getText());
            strategy.setDiscount(Float.parseFloat(discountTextField2.getText()));
            strategy.setMinRoomNum(Integer.parseInt(minRoomTextField2.getText()));
        } else if (strategy.getStrategyType() == StrategyType.CooperationEnterprisePromotion) {
            strategy.setStrategyName(strategyNameTextField3.getText());
            strategy.setDiscount(Float.parseFloat(discountTextField3.getText()));
            strategy.setEnterpriseName(cooperationEnterpriseTextField3.getText());
            strategy.setSecurityCode(securityCodeTextField3.getText());
        } else if (strategy.getStrategyType() == StrategyType.SpecificTimePromotion) {
            strategy.setStrategyName(strategyNameTextField4.getText());
            strategy.setDiscount(Float.parseFloat(discountTextField4.getText()));
            strategy.setStartTime(LocalDateAdapter.toDate(startTimeDatePicker4.getValue()));
            strategy.setEndTime(LocalDateAdapter.toDate(endTimeDatePicker4.getValue()));
        }

        try {
            if (isNewPromotion)
                updateStrategyService.add(address, strategy.toVO(address));
            else 
                updateStrategyService.modify(address, strategy.toVO(address));
        } catch (UnableAddStrategyException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("策略信息错误");
            alert.setHeaderText("策略信息错误");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        } catch (RemoteException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
            return;
        } catch (WrongInputException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("策略信息错误");
            alert.setHeaderText("策略信息错误");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        } catch (ParseException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("策略信息错误");
            alert.setHeaderText("策略信息错误");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        } catch (UnableToModifyStrategyException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("策略信息错误");
            alert.setHeaderText("策略信息错误");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }
        isConfirmed=true;
        Alert alert2 = new Alert(AlertType.INFORMATION);
        alert2.setTitle("操作成功");
        if (isNewPromotion)
            alert2.setHeaderText("增加策略成功！");
        else
            alert2.setHeaderText("修改策略成功！");
        alert2.showAndWait();
        dialogStage.close();
    }

    private boolean isInputValid() {
        if (strategy.getStrategyType() == StrategyType.BirthdayPromotion) {
            if (strategyNameTextField1.getText().equals("")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("策略名称空缺");
                alert.setContentText("请输入策略名称");

                alert.showAndWait();
                return false;
            }
            if (discountTextField1.getText().equals("") || !isDiscount(discountTextField1.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("折扣百分比错误");
                alert.setContentText("请在折扣百分比中输入数字且数字要小于1");

                alert.showAndWait();
                return false;
            }
        }
        if (strategy.getStrategyType() == StrategyType.CooperationEnterprisePromotion) {
            if (strategyNameTextField3.getText().equals("") || cooperationEnterpriseTextField3.getText().equals("")
                    || securityCodeTextField3.getText().equals("")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("策略信息空缺");
                alert.setContentText("请完善策略信息");

                alert.showAndWait();
                return false;
            }
            if (discountTextField3.getText().equals("") || !isDiscount(discountTextField3.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("折扣百分比错误");
                alert.setContentText("请在折扣百分比中输入数字且数字要小于1");

                alert.showAndWait();
                return false;
            }
        }
        if (strategy.getStrategyType() == StrategyType.MultiRoomPromotion) {
            if (strategyNameTextField2.getText().equals("")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("策略名称空缺");
                alert.setContentText("请输入策略名称");

                alert.showAndWait();
                return false;
            }
            if (discountTextField2.getText().equals("") || !isDiscount(discountTextField2.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("折扣百分比错误");
                alert.setContentText("请在折扣百分比中输入数字且数字要小于1");

                alert.showAndWait();
                return false;
            }
            if (minRoomTextField2.getText().equals("") || !isInteger(minRoomTextField2.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("最少房间数错误");
                alert.setContentText("请在最少房间数中输入整数");

                alert.showAndWait();
                return false;
            }
        }
        if (strategy.getStrategyType() == StrategyType.SpecificTimePromotion) {
            if (strategyNameTextField4.getText().equals("")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("策略名称空缺");
                alert.setContentText("请输入策略名称");

                alert.showAndWait();
                return false;
            }
            if (discountTextField4.getText().equals("") || !isDiscount(discountTextField4.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("折扣百分比错误");
                alert.setContentText("请在折扣百分比中输入数字且数字要小于1");

                alert.showAndWait();
                return false;
            }
            if (startTimeDatePicker4.getValue() == null || endTimeDatePicker4.getValue() == null) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("时间空缺");
                alert.setContentText("请选择开始时间和结束时间");

                alert.showAndWait();
                return false;
            }
        }
        StrategyVO strategyVO = null;
        Strategy tmpStrategy = new Strategy(strategy.getStrategyType());
        if (tmpStrategy.getStrategyType() == StrategyType.BirthdayPromotion) {
            tmpStrategy.setStrategyName(strategyNameTextField1.getText());
            tmpStrategy.setDiscount(Float.parseFloat(discountTextField1.getText()));
        } else if (tmpStrategy.getStrategyType() == StrategyType.MultiRoomPromotion) {
            tmpStrategy.setStrategyName(strategyNameTextField2.getText());
            tmpStrategy.setDiscount(Float.parseFloat(discountTextField2.getText()));
            tmpStrategy.setMinRoomNum(Integer.parseInt(minRoomTextField2.getText()));
        } else if (tmpStrategy.getStrategyType() == StrategyType.CooperationEnterprisePromotion) {
            tmpStrategy.setStrategyName(strategyNameTextField3.getText());
            tmpStrategy.setDiscount(Float.parseFloat(discountTextField3.getText()));
            tmpStrategy.setEnterpriseName(cooperationEnterpriseTextField3.getText());
            tmpStrategy.setSecurityCode(securityCodeTextField3.getText());
        } else if (tmpStrategy.getStrategyType() == StrategyType.SpecificTimePromotion) {
            tmpStrategy.setStrategyName(strategyNameTextField4.getText());
            tmpStrategy.setDiscount(Float.parseFloat(discountTextField4.getText()));
            tmpStrategy.setStartTime(LocalDateAdapter.toDate(startTimeDatePicker4.getValue()));
            tmpStrategy.setEndTime(LocalDateAdapter.toDate(endTimeDatePicker4.getValue()));
        }
        try {
            strategyVO = tmpStrategy.toVO(address);
        } catch (ParseException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("策略信息错误");
            alert.setHeaderText("信息格式错误");
            alert.setContentText("");
            alert.showAndWait();
            return false;
        }
        try {
            if (updateStrategyService.valid(address, strategyVO)) {
                return true;
            }
        } catch (WrongInputException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("策略信息错误");
            alert.setHeaderText("策略信息错误");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (RemoteException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
        }
        return false;
    }

    private boolean isDiscount(String str) {
        for (char c : str.toCharArray()) {
            if ((c < '0' || c > '9') && c != '.') {
                return false;
            }
        }
        if (str.indexOf('.') == 0 || str.indexOf('.') == str.length() - 1) {
            return false;
        }
        if (str.indexOf('.') != str.lastIndexOf('.')) {
            return false;
        }
        if (Float.parseFloat(str) > 1 || Float.parseFloat(str) <= 0) {
            return false;
        }
        return true;
    }

    private boolean isInteger(String str) {
        for (char c : str.toCharArray()) {
            if ((c < '0' || c > '9')) {
                return false;
            }
        }
        return true;
    }

}
