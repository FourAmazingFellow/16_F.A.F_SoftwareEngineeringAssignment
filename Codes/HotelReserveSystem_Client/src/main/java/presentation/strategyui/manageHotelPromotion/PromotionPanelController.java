package presentation.strategyui.manageHotelPromotion;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

import businesslogic.strategybl.exception.UnableToDeleteStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogicservice.strategyblservice.UpdateStrategyService;
import factory.StrategyUIFactoryService;
import factory.StrategyUIFactoryServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import po.StrategyType;
import presentation.HotelMainApp;
import presentation.strategyui.model.Strategy;
import presentation.strategyui.model.StrategyListWrapper;
import vo.StrategyVO;

public class PromotionPanelController {

    @FXML
    private TextField strategyNameTextField;

    @FXML
    private TabPane strategyTypeTabPane;

    @FXML
    private Tab birthdayPromotionTab;

    @FXML
    private Tab multiRoomPromotionTab;

    @FXML
    private Tab cooperationEnterprisePromotionTab;

    @FXML
    private Tab specialTimePromotionTab;

    @FXML
    private TableView<Strategy> birthdayPromotionTable;

    @FXML
    private TableView<Strategy> multiRoomPromotionTable;

    @FXML
    private TableView<Strategy> cooperationEnterprisePromotionTable;

    @FXML
    private TableView<Strategy> spcialTimePromotionTable;

    @FXML
    private TableColumn<Strategy, String> strategyNameColumn1;

    @FXML
    private TableColumn<Strategy, String> strategyNameColumn2;

    @FXML
    private TableColumn<Strategy, String> strategyNameColumn3;

    @FXML
    private TableColumn<Strategy, String> strategyNameColumn4;

    @FXML
    private TableColumn<Strategy, String> discountColumn1;

    @FXML
    private TableColumn<Strategy, String> discountColumn2;

    @FXML
    private TableColumn<Strategy, String> discountColumn3;

    @FXML
    private TableColumn<Strategy, String> discountColumn4;

    @FXML
    private TableColumn<Strategy, String> minRoomColumn2;

    @FXML
    private TableColumn<Strategy, String> cooperationEnterpriseColumn3;

    @FXML
    private TableColumn<Strategy, String> securityCodeColumn3;

    @FXML
    private TableColumn<Strategy, String> startTimeColumn4;

    @FXML
    private TableColumn<Strategy, String> endTimeColumn4;

    private HotelMainApp mainApp;
    private ObservableList<Strategy> birthDayPromotionData = FXCollections.observableArrayList();
    private ObservableList<Strategy> enterprisePromotinonData = FXCollections.observableArrayList();
    private ObservableList<Strategy> mutiRoomPromotionData = FXCollections.observableArrayList();
    private ObservableList<Strategy> specialTimePromotionData = FXCollections.observableArrayList();
    private StrategyListWrapper strategyList;
    private StrategyUIFactoryService strategyUIFactoryService=new StrategyUIFactoryServiceImpl();
    private UpdateStrategyService updateStrategyService = strategyUIFactoryService.createUpdateStrategyService();
    private String address;

    @FXML
    private void initialize() {
        strategyList = new StrategyListWrapper();

        // Initialize the strategyTable and its columns.
        birthdayPromotionTable.setItems(birthDayPromotionData);
        cooperationEnterprisePromotionTable.setItems(enterprisePromotinonData);
        multiRoomPromotionTable.setItems(mutiRoomPromotionData);
        spcialTimePromotionTable.setItems(specialTimePromotionData);

        strategyNameColumn1.setCellValueFactory(cellData -> cellData.getValue().strategyNameProperty());
        strategyNameColumn2.setCellValueFactory(cellData -> cellData.getValue().strategyNameProperty());
        strategyNameColumn3.setCellValueFactory(cellData -> cellData.getValue().strategyNameProperty());
        strategyNameColumn4.setCellValueFactory(cellData -> cellData.getValue().strategyNameProperty());
        discountColumn1.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
        discountColumn2.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
        discountColumn3.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
        discountColumn4.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
        minRoomColumn2.setCellValueFactory(cellData -> cellData.getValue().minRoomNumProperty());
        cooperationEnterpriseColumn3.setCellValueFactory(cellData -> cellData.getValue().enterpriseProperty());
        securityCodeColumn3.setCellValueFactory(cellData -> cellData.getValue().securityCodeProperty());
        startTimeColumn4.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());
        endTimeColumn4.setCellValueFactory(cellData -> cellData.getValue().endTimeProperty());

        // 为tabPane增加监听,每次切换策略类型，都刷新一下策略列表
        strategyTypeTabPane.getSelectionModel().selectedIndexProperty()
                .addListener((observable, oldValue, newValue) -> {
                    showAllPromotionList(address);
                });
        ;
    }
    
    @FXML
    public void handleClickedStrategyNameTextField(MouseEvent event){
        if(strategyNameTextField.getText().equals("用折扣名称搜索...")){
            strategyNameTextField.setText("");
        }
    }

    public void setMainApp(HotelMainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void showAllPromotionList(String address) {
        this.address = address;
        // 从bl层获得数据，并添加到checkInData中
        showbirthdayPromotionList();
        showEnterprisePromotionList();
        showMutiRoomPromotionList();
        showSpecialTimePromotionList();
    }

    public void showbirthdayPromotionList() {
        ArrayList<StrategyVO> birthdayPromotionVOs = updateStrategyService.getStrategyList(address,
                StrategyType.BirthdayPromotion);
        birthDayPromotionData.clear();
        strategyList.setStrategyList(birthdayPromotionVOs);
        birthDayPromotionData.addAll(strategyList.getStrategyList());
    }

    public void showEnterprisePromotionList() {
        ArrayList<StrategyVO> enterprisePromotionVOs = updateStrategyService.getStrategyList(address,
                StrategyType.CooperationEnterprisePromotion);
        enterprisePromotinonData.clear();
        strategyList.setStrategyList(enterprisePromotionVOs);
        enterprisePromotinonData.addAll(strategyList.getStrategyList());
    }

    public void showMutiRoomPromotionList() {
        ArrayList<StrategyVO> multiRoomPromotionVOs = updateStrategyService.getStrategyList(address,
                StrategyType.MultiRoomPromotion);
        mutiRoomPromotionData.clear();
        strategyList.setStrategyList(multiRoomPromotionVOs);
        mutiRoomPromotionData.addAll(strategyList.getStrategyList());
    }

    public void showSpecialTimePromotionList() {
        ArrayList<StrategyVO> specialTimePromotionVOs = updateStrategyService.getStrategyList(address,
                StrategyType.SpecificTimePromotion);
        specialTimePromotionData.clear();
        strategyList.setStrategyList(specialTimePromotionVOs);
        specialTimePromotionData.addAll(strategyList.getStrategyList());
    }

    @FXML
    void handleSearchWithStrategyName() {
        int selectedIndex = strategyTypeTabPane.getSelectionModel().getSelectedIndex();
        if (strategyNameTextField.getText().equals("")) {
            showAllPromotionList(address);
            return;
        }
        StrategyVO searchedStrategyVO = null;
        if (selectedIndex == 0) {
            searchedStrategyVO = updateStrategyService.getStrategyInfo(address, StrategyType.BirthdayPromotion,
                    strategyNameTextField.getText());
        } else if (selectedIndex == 1) {
            searchedStrategyVO = updateStrategyService.getStrategyInfo(address, StrategyType.MultiRoomPromotion,
                    strategyNameTextField.getText());
        } else if (selectedIndex == 2) {
            searchedStrategyVO = updateStrategyService.getStrategyInfo(address,
                    StrategyType.CooperationEnterprisePromotion, strategyNameTextField.getText());
        } else if (selectedIndex == 3) {
            searchedStrategyVO = updateStrategyService.getStrategyInfo(address, StrategyType.SpecificTimePromotion,
                    strategyNameTextField.getText());
        }
        if (searchedStrategyVO == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("搜索不到");
            alert.setHeaderText("该策略名称不存在");
            alert.setContentText("请重新输入策略名称");

            alert.showAndWait();
            return;
        }
        if (selectedIndex == 0){
//            birthdayPromotionTable.getSelectionModel().select(new Strategy(searchedStrategyVO));
            birthDayPromotionData.clear();
            birthDayPromotionData.add(new Strategy(searchedStrategyVO));
        }
        else if (selectedIndex == 1){
//            multiRoomPromotionTable.getSelectionModel().select(new Strategy(searchedStrategyVO));
            mutiRoomPromotionData.clear();
            mutiRoomPromotionData.add(new Strategy(searchedStrategyVO));
        }
        else if (selectedIndex == 2){
//            cooperationEnterprisePromotionTable.getSelectionModel().select(new Strategy(searchedStrategyVO));
            enterprisePromotinonData.clear();
            enterprisePromotinonData.add(new Strategy(searchedStrategyVO));
        }
        else if (selectedIndex == 3){
            specialTimePromotionData.clear();
            specialTimePromotionData.add(new Strategy(searchedStrategyVO));
        }
    }

    @FXML
    void handleNewPromotion() {
        int selectedTab = strategyTypeTabPane.getSelectionModel().getSelectedIndex();
        Strategy strategy = null;
        if (selectedTab == 0) {
            strategy = new Strategy(StrategyType.BirthdayPromotion);
        } else if (selectedTab == 1)
            strategy = new Strategy(StrategyType.MultiRoomPromotion);
        else if (selectedTab == 2)
            strategy = new Strategy(StrategyType.CooperationEnterprisePromotion);
        else if (selectedTab == 3)
            strategy = new Strategy(StrategyType.SpecificTimePromotion);

        boolean isNewaPromotion = true;
        boolean isConfirmed = mainApp.showPromotionEditDialog(strategy, isNewaPromotion);
        if (isConfirmed) {
            if (selectedTab == 0)
                birthdayPromotionTable.getItems().add(strategy);
            else if (selectedTab == 1)
                multiRoomPromotionTable.getItems().add(strategy);
            else if (selectedTab == 2)
                cooperationEnterprisePromotionTable.getItems().add(strategy);
            else if (selectedTab == 3)
                spcialTimePromotionTable.getItems().add(strategy);
        }
    }

    @FXML
    void handleModifyPromotion() {
        int selectedTab = strategyTypeTabPane.getSelectionModel().getSelectedIndex();
        int selectedStrategy = -1;
        Strategy strategy = null;
        if (selectedTab == 0) {
            selectedStrategy = birthdayPromotionTable.getSelectionModel().getSelectedIndex();
        } else if (selectedTab == 1)
            selectedStrategy = multiRoomPromotionTable.getSelectionModel().getSelectedIndex();
        else if (selectedTab == 2)
            selectedStrategy = cooperationEnterprisePromotionTable.getSelectionModel().getSelectedIndex();
        else if (selectedTab == 3)
            selectedStrategy = spcialTimePromotionTable.getSelectionModel().getSelectedIndex();
        // 如果没有选中策略，则警告
        if (selectedStrategy < 0) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("无法修改");
            alert.setHeaderText("无法进行修改");
            alert.setContentText("请选择一个策略来修改");
            alert.showAndWait();
            return;
        }
        // 得到要修改的strategy
        try {
            if (selectedTab == 0) {
                strategy = new Strategy(birthDayPromotionData.get(selectedStrategy).toVO(address));
            } else if (selectedTab == 1)
                strategy = new Strategy(mutiRoomPromotionData.get(selectedStrategy).toVO(address));
            else if (selectedTab == 2)
                strategy = new Strategy(enterprisePromotinonData.get(selectedStrategy).toVO(address));
            else if (selectedTab == 3)
                strategy = new Strategy(specialTimePromotionData.get(selectedStrategy).toVO(address));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean isNewaPromotion = false;
        boolean isConfirmed = mainApp.showPromotionEditDialog(strategy, isNewaPromotion);
        if (isConfirmed) {
            if (selectedTab == 0)
                birthdayPromotionTable.getItems().add(strategy);
            else if (selectedTab == 1)
                multiRoomPromotionTable.getItems().add(strategy);
            else if (selectedTab == 2)
                cooperationEnterprisePromotionTable.getItems().add(strategy);
            else if (selectedTab == 3)
                spcialTimePromotionTable.getItems().add(strategy);
        }
    }

    @FXML
    void handleDeletePromotion() {
        int selectedTab = strategyTypeTabPane.getSelectionModel().getSelectedIndex();
        int selectStrategy = -1;
        if (selectedTab == 0) {
            selectStrategy = birthdayPromotionTable.getSelectionModel().getSelectedIndex();
        } else if (selectedTab == 1) {
            selectStrategy = multiRoomPromotionTable.getSelectionModel().getSelectedIndex();
        } else if (selectedTab == 2) {
            selectStrategy = cooperationEnterprisePromotionTable.getSelectionModel().getSelectedIndex();
        } else if (selectedTab == 3) {
            selectStrategy = spcialTimePromotionTable.getSelectionModel().getSelectedIndex();
        }
        if (selectStrategy < 0) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("无法删除");
            alert.setHeaderText("无法进行删除");
            alert.setContentText("请选择一个策略来删除");
            alert.showAndWait();
            return;
        }
        Alert alert1 = new Alert(AlertType.CONFIRMATION);
        alert1.setTitle("确认删除策略");
        alert1.setHeaderText("你是否确定要删除该策略？");
        alert1.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert1.showAndWait();
        if (result.get() != ButtonType.OK) {
            return;
        }
        try {
            if (selectedTab == 0)
                    updateStrategyService.delete(address, birthDayPromotionData.get(selectStrategy).toVO(address));
            else if (selectedTab == 1)
                updateStrategyService.delete(address, mutiRoomPromotionData.get(selectStrategy).toVO(address));
            else if (selectedTab == 2)
                updateStrategyService.delete(address, enterprisePromotinonData.get(selectStrategy).toVO(address));
            else if (selectedTab == 3)
                updateStrategyService.delete(address, specialTimePromotionData.get(selectStrategy).toVO(address));
        } catch (UnableToDeleteStrategyException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("删除失败");
            alert.setHeaderText("删除策略失败");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        } catch (WrongInputException e) {
            e.printStackTrace();
            return;
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 在StrategyData中也删掉
        if (selectedTab == 0) {
            birthdayPromotionTable.getItems().remove(selectStrategy);
        } else if (selectedTab == 1)
            multiRoomPromotionTable.getItems().remove(selectStrategy);
        else if (selectedTab == 2)
            cooperationEnterprisePromotionTable.getItems().remove(selectStrategy);
        else if (selectedTab == 3)
            spcialTimePromotionTable.getItems().remove(selectStrategy);

    }


}
