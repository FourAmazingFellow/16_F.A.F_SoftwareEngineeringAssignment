package presentation.strategyui.manageMarketStrategy;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToModifyStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogicservice.strategyblservice.UpdateStrategyService;
import factory.StrategyUIFactoryService;
import factory.StrategyUIFactoryServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import po.BusinessDistrictPO;
import po.StrategyType;
import presentation.roomui.util.LocalDateAdapter;
import presentation.strategyui.model.Strategy;
import vo.StrategyVO;

public class MarketStrategyEditPanelController {

    @FXML
    private TabPane strategyTypeTabPane;

    @FXML
    private Tab memberRankMarketStrategyTab;

    @FXML
    private Tab VIPTradeAreaMarketStrategyTab;

    @FXML
    private Tab specialTimeMarketStrategyTab;

    @FXML
    private TextField strategyNameTextField1;

    @FXML
    private TextField strategyNameTextField2;

    @FXML
    private TextField strategyNameTextField3;

    @FXML
    private TextField discountTextField1;

    @FXML
    private TextField discountTextField2;

    @FXML
    private TextField discountTextField3;

    @FXML
    private ChoiceBox<Integer> vipRankChoiceBox1;

    @FXML
    private ChoiceBox<Integer> vipRankChoiceBox2;

    @FXML
    private ChoiceBox<String> cityChoiceBox2;

    @FXML
    private ChoiceBox<String> tradeAreaChoiceBox2;

    @FXML
    private DatePicker startTimeDatePicker3;

    @FXML
    private DatePicker endTimeDatePicker3;

    private Stage dialogStage;
    private Strategy strategy;
    private boolean isConfirmed = false;
    private ObservableList<String> cityListData = FXCollections.observableArrayList("南京市", "上海市");
    private ObservableList<String> tradeAreaListData = FXCollections.observableArrayList();
    private ObservableList<Integer> vipRankList = FXCollections.observableArrayList(0, 1, 2, 3, 4);
    private StrategyUIFactoryService strategyUIFactoryService = new StrategyUIFactoryServiceImpl();
    private UpdateStrategyService updateStrategyService = strategyUIFactoryService.createUpdateStrategyService();
    private String address;
    private boolean isNewPromotion;

    @FXML
    private void initialize() {
        startTimeDatePicker3.setEditable(false);
        endTimeDatePicker3.setEditable(false);
        vipRankChoiceBox1.setItems(vipRankList);
        vipRankChoiceBox2.setItems(vipRankList);
        cityChoiceBox2.setItems(cityListData);
        tradeAreaChoiceBox2.setItems(tradeAreaListData);
        try {
            setTradeAreaList(updateStrategyService
                    .getBusinessDistrictList(cityChoiceBox2.getSelectionModel().getSelectedItem()));
        } catch (RemoteException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
        }
        // 给cityChoiceBox2添加监听
        cityChoiceBox2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                try {
                    setTradeAreaList(updateStrategyService.getBusinessDistrictList(cityListData.get((int) newValue)));
                } catch (RemoteException e) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("NetWork Warning");
                    alert.setHeaderText("Fail to connect with the server!");
                    alert.setContentText("Please check your network connection!");
                    alert.showAndWait();
                }
            }
        });
    }

    public void setTradeAreaList(ArrayList<BusinessDistrictPO> tradeAreaPOs) {
        tradeAreaListData.clear();
        for (BusinessDistrictPO tradeAreaPO : tradeAreaPOs) {
            tradeAreaListData.add(tradeAreaPO.getBusinessDistrictName());
        }
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
        this.isNewPromotion=isNewaPromotion;
        // 把其他策略类型的tab设置为disable,并把不能修改的东西设成disable,如果是修改strategy,把默认值设为原始值
        if (strategy.getStrategyType() == StrategyType.MemberRankMarket) {
            VIPTradeAreaMarketStrategyTab.setDisable(true);
            specialTimeMarketStrategyTab.setDisable(true);
            strategyTypeTabPane.getSelectionModel().select(0);
            if (!isNewaPromotion) {
                strategyNameTextField1.setText(strategy.getStrategyName());
                discountTextField1.setText(String.valueOf(strategy.getDiscount()));
                vipRankChoiceBox1.getSelectionModel().select(strategy.getVipRank());
                strategyNameTextField1.setDisable(true);
            }
        } else if (strategy.getStrategyType() == StrategyType.VipTradeAreaMarket) {
            memberRankMarketStrategyTab.setDisable(true);
            specialTimeMarketStrategyTab.setDisable(true);
            strategyTypeTabPane.getSelectionModel().select(1);
            if (!isNewaPromotion) {
                strategyNameTextField2.setText(strategy.getStrategyName());
                discountTextField2.setText(String.valueOf(strategy.getDiscount()));
                vipRankChoiceBox2.getSelectionModel().select(strategy.getVipRank());
                for (String city : cityListData) {
                    try {
                        for (BusinessDistrictPO tradeArea : updateStrategyService.getBusinessDistrictList(city)) {
                            if (tradeArea.getBusinessDistrictName().equals(strategy.getTradeArea())) {
                                cityChoiceBox2.getSelectionModel().select(city);
                            }
                        }
                    } catch (RemoteException e) {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("NetWork Warning");
                        alert.setHeaderText("Fail to connect with the server!");
                        alert.setContentText("Please check your network connection!");
                        alert.showAndWait();
                    }
                }
                tradeAreaChoiceBox2.getSelectionModel().select(strategy.getTradeArea());
                strategyNameTextField2.setDisable(true);
            }
        } else if (strategy.getStrategyType() == StrategyType.SpecificTimeMarket) {
            memberRankMarketStrategyTab.setDisable(true);
            VIPTradeAreaMarketStrategyTab.setDisable(true);
            strategyTypeTabPane.getSelectionModel().select(2);
            if (!isNewaPromotion) {
                strategyNameTextField3.setText(strategy.getStrategyName());
                discountTextField3.setText(String.valueOf(strategy.getDiscount()));
                try {
                    startTimeDatePicker3.setValue(LocalDateAdapter.fromDate(strategy.getStartTime()));
                    endTimeDatePicker3.setValue(LocalDateAdapter.fromDate(strategy.getEndTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                strategyNameTextField3.setDisable(true);
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
        if (strategy.getStrategyType() == StrategyType.MemberRankMarket) {
            strategy.setStrategyName(strategyNameTextField1.getText());
            strategy.setDiscount(Float.parseFloat(discountTextField1.getText()));
            strategy.setVipRank(vipRankChoiceBox1.getSelectionModel().getSelectedItem());
        } else if (strategy.getStrategyType() == StrategyType.VipTradeAreaMarket) {
            strategy.setStrategyName(strategyNameTextField2.getText());
            strategy.setDiscount(Float.parseFloat(discountTextField2.getText()));
            strategy.setVipRank(vipRankChoiceBox2.getSelectionModel().getSelectedItem());
            strategy.setTradeArea(tradeAreaChoiceBox2.getSelectionModel().getSelectedItem());
        } else if (strategy.getStrategyType() == StrategyType.SpecificTimeMarket) {
            strategy.setStrategyName(strategyNameTextField3.getText());
            strategy.setDiscount(Float.parseFloat(discountTextField3.getText()));
            strategy.setStartTime(LocalDateAdapter.toDate(startTimeDatePicker3.getValue()));
            strategy.setEndTime(LocalDateAdapter.toDate(endTimeDatePicker3.getValue()));
        }
        
        try {
            if (isNewPromotion)
                updateStrategyService.add(address, strategy.toVO(address));
            else 
                updateStrategyService.modify(address, strategy.toVO(address));
        } catch (RemoteException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("NetWork Warning");
            alert.setHeaderText("Fail to connect with the server!");
            alert.setContentText("Please check your network connection!");
            alert.showAndWait();
            return;
        } catch (UnableAddStrategyException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("策略信息错误");
            alert.setHeaderText("策略信息错误");
            alert.setContentText(e.getMessage());
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
        if (strategy.getStrategyType() == StrategyType.MemberRankMarket) {
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
            if(vipRankChoiceBox1.getSelectionModel().getSelectedIndex()<0){
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("会员等级空缺");
                alert.setContentText("请选择会员等级");

                alert.showAndWait();
                return false;
            }
        } else if (strategy.getStrategyType() == StrategyType.VipTradeAreaMarket) {
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
            if(vipRankChoiceBox2.getSelectionModel().getSelectedIndex()<0){
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("会员等级空缺");
                alert.setContentText("请选择会员等级");

                alert.showAndWait();
                return false;
            }
            if (cityChoiceBox2.getSelectionModel().getSelectedIndex() < 0
                    || tradeAreaChoiceBox2.getSelectionModel().getSelectedIndex() < 0) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("没有选择城市或商圈");
                alert.setContentText("请选择城市和商圈");

                alert.showAndWait();
                return false;
            }
        } else if (strategy.getStrategyType() == StrategyType.SpecificTimeMarket) {
            if (strategyNameTextField3.getText().equals("")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("策略名称空缺");
                alert.setContentText("请输入策略名称");

                alert.showAndWait();
                return false;
            }
            if (discountTextField3.getText().equals("")|| !isDiscount(discountTextField3.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("折扣百分比错误");
                alert.setContentText("请在折扣百分比中输入数字且数字要小于1");

                alert.showAndWait();
                return false;
            }
            if (startTimeDatePicker3.getValue() == null || endTimeDatePicker3.getValue() == null) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("策略信息错误");
                alert.setHeaderText("时间空缺");
                alert.setContentText("请选择开始时间和结束时间");

                alert.showAndWait();
                return false;
            }
        }
        StrategyVO strategyVO = null;
        Strategy tmpStrategy =new Strategy(strategy.getStrategyType());
        if (strategy.getStrategyType() == StrategyType.MemberRankMarket) {
            tmpStrategy.setStrategyName(strategyNameTextField1.getText());
            tmpStrategy.setDiscount(Float.parseFloat(discountTextField1.getText()));
            tmpStrategy.setVipRank(vipRankChoiceBox1.getSelectionModel().getSelectedItem());
        } else if (strategy.getStrategyType() == StrategyType.VipTradeAreaMarket) {
            tmpStrategy.setStrategyName(strategyNameTextField2.getText());
            tmpStrategy.setDiscount(Float.parseFloat(discountTextField2.getText()));
            tmpStrategy.setVipRank(vipRankChoiceBox2.getSelectionModel().getSelectedItem());
            tmpStrategy.setTradeArea(tradeAreaChoiceBox2.getSelectionModel().getSelectedItem());
        } else if (strategy.getStrategyType() == StrategyType.SpecificTimeMarket) {
            tmpStrategy.setStrategyName(strategyNameTextField3.getText());
            tmpStrategy.setDiscount(Float.parseFloat(discountTextField3.getText()));
            tmpStrategy.setStartTime(LocalDateAdapter.toDate(startTimeDatePicker3.getValue()));
            tmpStrategy.setEndTime(LocalDateAdapter.toDate(endTimeDatePicker3.getValue()));
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
        if(Float.parseFloat(str)>1||Float.parseFloat(str)<=0){
            return false;
        }
        return true;
    }

}
