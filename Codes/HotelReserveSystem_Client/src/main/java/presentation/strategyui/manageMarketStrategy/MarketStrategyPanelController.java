package presentation.strategyui.manageMarketStrategy;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import po.StrategyType;
import presentation.WebsitePromotionMainApp;
import presentation.strategyui.model.Strategy;
import presentation.strategyui.model.StrategyListWrapper;
import vo.StrategyVO;

/**
 * 管理网站营销策略界面的控制类
 * @author 双
 * @version 
 * @see
 */
public class MarketStrategyPanelController {

    @FXML
    private TextField strategyNameTextField;

    @FXML
    private TabPane strategyTypeTabPane;

    @FXML
    private Tab MemberRankMarketStrategyTab;

    @FXML
    private Tab VIPTradeAreaMarketStrategyTab;

    @FXML
    private Tab specialTimeMarketStrategyTab;

    @FXML
    private TableView<Strategy> memberRankMarketStrategyTable;

    @FXML
    private TableView<Strategy> VIPTradeAreaMarketStrategyTable;

    @FXML
    private TableView<Strategy> specialTimeMarketStrategyTable;

    @FXML
    private TableColumn<Strategy, String> strategyNameColumn1;

    @FXML
    private TableColumn<Strategy, String> strategyNameColumn2;

    @FXML
    private TableColumn<Strategy, String> strategyNameColumn3;

    @FXML
    private TableColumn<Strategy, String> discountColumn1;

    @FXML
    private TableColumn<Strategy, String> discountColumn2;

    @FXML
    private TableColumn<Strategy, String> discountColumn3;

    @FXML
    private TableColumn<Strategy, String> VIPRankColumn1;

    @FXML
    private TableColumn<Strategy, String> VIPRankColumn2;

    @FXML
    private TableColumn<Strategy, String> tradeAreaColumn2;

    @FXML
    private TableColumn<Strategy, String> startTimeColumn3;

    @FXML
    private TableColumn<Strategy, String> endTimeColumn3;

    private WebsitePromotionMainApp mainApp;
    private ObservableList<Strategy> memberRankStrategyData = FXCollections.observableArrayList();
    private ObservableList<Strategy> VIPTradeAreaStrategyData = FXCollections.observableArrayList();
    private ObservableList<Strategy> specialTimeStrategyData = FXCollections.observableArrayList();
    private StrategyListWrapper strategyList;
    private StrategyUIFactoryService strategyUIFactoryService=new StrategyUIFactoryServiceImpl();
    private UpdateStrategyService updateStrategyService = strategyUIFactoryService.createUpdateStrategyService();
    private String address;

    @FXML
    private void initialize() {
        strategyList = new StrategyListWrapper();
        // Initialize the strategyTable and its columns.
        memberRankMarketStrategyTable.setItems(memberRankStrategyData);
        VIPTradeAreaMarketStrategyTable.setItems(VIPTradeAreaStrategyData);
        specialTimeMarketStrategyTable.setItems(specialTimeStrategyData);

        strategyNameColumn1.setCellValueFactory(cellData -> cellData.getValue().strategyNameProperty());
        strategyNameColumn2.setCellValueFactory(cellData -> cellData.getValue().strategyNameProperty());
        strategyNameColumn3.setCellValueFactory(cellData -> cellData.getValue().strategyNameProperty());
        discountColumn1.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
        discountColumn2.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
        discountColumn3.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
        VIPRankColumn1.setCellValueFactory(cellData -> cellData.getValue().vipRankProperty());
        VIPRankColumn2.setCellValueFactory(cellData -> cellData.getValue().vipRankProperty());
        tradeAreaColumn2.setCellValueFactory(cellData -> cellData.getValue().tradeAreaProperty());
        startTimeColumn3.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());
        endTimeColumn3.setCellValueFactory(cellData -> cellData.getValue().endTimeProperty());

        // 为tabPane增加监听,每次切换策略类型，都刷新一下策略列表
        strategyTypeTabPane.getSelectionModel().selectedIndexProperty()
                .addListener((observable, oldValue, newValue) -> {
                    showAllMarketStrategyList(address);
                });

    }
    
    @FXML
    public void handleClickedStrategyNameTextField(MouseEvent event){
        if(strategyNameTextField.getText().equals("用折扣名称搜索...")){
            strategyNameTextField.setText("");
        }
    }

    public void setMainApp(WebsitePromotionMainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void showAllMarketStrategyList(String address) {
        this.address = address;
        // 从bl层获得数据，并添加到checkInData中
        showMemberRankStrategyList();
        showVipTradeAreaStrategyList();
        showspecialTimeStrategyList();
    }

    public void showMemberRankStrategyList() {
        ArrayList<StrategyVO> memberRankStrategyVOs = updateStrategyService.getStrategyList(address,
                StrategyType.MemberRankMarket);
        memberRankStrategyData.clear();
        strategyList.setStrategyList(memberRankStrategyVOs);
        memberRankStrategyData.addAll(strategyList.getStrategyList());
    }

    public void showVipTradeAreaStrategyList() {
        ArrayList<StrategyVO> vipTradeAreaStrategyVOs = updateStrategyService.getStrategyList(address,
                StrategyType.VipTradeAreaMarket);
        VIPTradeAreaStrategyData.clear();
        strategyList.setStrategyList(vipTradeAreaStrategyVOs);
        VIPTradeAreaStrategyData.addAll(strategyList.getStrategyList());
    }

    public void showspecialTimeStrategyList() {
        ArrayList<StrategyVO> specialTimeStrategyVOs = updateStrategyService.getStrategyList(address,
                StrategyType.SpecificTimeMarket);
        specialTimeStrategyData.clear();
        strategyList.setStrategyList(specialTimeStrategyVOs);
        specialTimeStrategyData.addAll(strategyList.getStrategyList());
    }

    @FXML
    void handleSearchWithStrategyName(ActionEvent event) {
        int selectedIndex = strategyTypeTabPane.getSelectionModel().getSelectedIndex();
        if (strategyNameTextField.getText().equals("")) {
            showAllMarketStrategyList(address);
            return;
        }
        StrategyVO searchedStrategyVO = null;
        if (selectedIndex == 0) {
            searchedStrategyVO = updateStrategyService.getStrategyInfo(address, StrategyType.MemberRankMarket,
                    strategyNameTextField.getText());
        } else if (selectedIndex == 1) {
            searchedStrategyVO = updateStrategyService.getStrategyInfo(address, StrategyType.VipTradeAreaMarket,
                    strategyNameTextField.getText());
        } else if (selectedIndex == 2) {
            searchedStrategyVO = updateStrategyService.getStrategyInfo(address, StrategyType.SpecificTimeMarket,
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
//            memberRankMarketStrategyTable.getSelectionModel().select(new Strategy(searchedStrategyVO));
            memberRankStrategyData.clear();
            memberRankStrategyData.add(new Strategy(searchedStrategyVO));
        }
        else if (selectedIndex == 1){
//            VIPTradeAreaMarketStrategyTable.getSelectionModel().select(new Strategy(searchedStrategyVO));
            VIPTradeAreaStrategyData.clear();
            VIPTradeAreaStrategyData.add(new Strategy(searchedStrategyVO));
        }
        else if (selectedIndex == 2){
//            specialTimeMarketStrategyTable.getSelectionModel().select(new Strategy(searchedStrategyVO));
            specialTimeStrategyData.clear();
            specialTimeStrategyData.add(new Strategy(searchedStrategyVO));
        }
    }

    @FXML
    void handleNewMarketStrategy(ActionEvent event) {
        int selectedTab = strategyTypeTabPane.getSelectionModel().getSelectedIndex();
        Strategy strategy = null;
        if (selectedTab == 0) {
            strategy = new Strategy(StrategyType.MemberRankMarket);
        } else if (selectedTab == 1)
            strategy = new Strategy(StrategyType.VipTradeAreaMarket);
        else if (selectedTab == 2)
            strategy = new Strategy(StrategyType.SpecificTimeMarket);
        boolean isNewaPromotion = true;
        boolean isConfirmed = mainApp.showMarketStrategyEditDialog(strategy, isNewaPromotion);
        if (isConfirmed) {
            if (selectedTab == 0)
                memberRankMarketStrategyTable.getItems().add(strategy);
            else if (selectedTab == 1)
                VIPTradeAreaMarketStrategyTable.getItems().add(strategy);
            else if (selectedTab == 2)
                specialTimeMarketStrategyTable.getItems().add(strategy);
        }
    }

    @FXML
    void handleDeleteMarketStrategy(ActionEvent event) {
        int selectedTab = strategyTypeTabPane.getSelectionModel().getSelectedIndex();
        int selectedStrategy = -1;
        if (selectedTab == 0) {
            selectedStrategy = memberRankMarketStrategyTable.getSelectionModel().getSelectedIndex();
        } else if (selectedTab == 1)
            selectedStrategy = VIPTradeAreaMarketStrategyTable.getSelectionModel().getSelectedIndex();
        else if (selectedTab == 2)
            selectedStrategy = specialTimeMarketStrategyTable.getSelectionModel().getSelectedIndex();
        // 如果没有选中策略，则警告
        if (selectedStrategy < 0) {
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
                updateStrategyService.delete(address, memberRankStrategyData.get(selectedStrategy).toVO(address));
            else if (selectedTab == 1)
                updateStrategyService.delete(address, VIPTradeAreaStrategyData.get(selectedStrategy).toVO(address));
            else if (selectedTab == 2)
                updateStrategyService.delete(address, specialTimeStrategyData.get(selectedStrategy).toVO(address));
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
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 在StrategyData中也删掉
        if (selectedTab == 0) {
            memberRankMarketStrategyTable.getItems().remove(selectedStrategy);
        } else if (selectedTab == 1)
            VIPTradeAreaMarketStrategyTable.getItems().remove(selectedStrategy);
        else if (selectedTab == 2)
            specialTimeMarketStrategyTable.getItems().remove(selectedStrategy);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("删除策略成功");
        alert.setHeaderText("删除策略成功！");
        alert.showAndWait();
    }

    @FXML
    void handleModifyMarketStrategy(ActionEvent event) {
        int selectedTab = strategyTypeTabPane.getSelectionModel().getSelectedIndex();
        int selectedStrategy = -1;
        Strategy strategy = null;
        if (selectedTab == 0) {
            selectedStrategy = memberRankMarketStrategyTable.getSelectionModel().getSelectedIndex();
        } else if (selectedTab == 1)
            selectedStrategy = VIPTradeAreaMarketStrategyTable.getSelectionModel().getSelectedIndex();
        else if (selectedTab == 2)
            selectedStrategy = specialTimeMarketStrategyTable.getSelectionModel().getSelectedIndex();
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
                strategy = new Strategy(memberRankStrategyData.get(selectedStrategy).toVO(address));
            } else if (selectedTab == 1)
                strategy = new Strategy(VIPTradeAreaStrategyData.get(selectedStrategy).toVO(address));
            else if (selectedTab == 2)
                strategy = new Strategy(specialTimeStrategyData.get(selectedStrategy).toVO(address));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean isNewaPromotion = false;
        boolean isConfirmed = mainApp.showMarketStrategyEditDialog(strategy, isNewaPromotion);
        if (isConfirmed) {
            if (selectedTab == 0){
                memberRankMarketStrategyTable.getItems().remove(selectedStrategy);
                memberRankMarketStrategyTable.getItems().add(selectedStrategy, strategy);
            }else if (selectedTab == 1){
                VIPTradeAreaMarketStrategyTable.getItems().remove(selectedStrategy);
                VIPTradeAreaMarketStrategyTable.getItems().add(selectedStrategy,strategy);
            }else if (selectedTab == 2){
                specialTimeMarketStrategyTable.getItems().remove(selectedStrategy);
                specialTimeMarketStrategyTable.getItems().add(selectedStrategy,strategy);
            }
        }
    }

}
