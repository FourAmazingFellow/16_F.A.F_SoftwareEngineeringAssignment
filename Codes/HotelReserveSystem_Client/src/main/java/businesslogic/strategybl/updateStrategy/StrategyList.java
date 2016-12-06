package businesslogic.strategybl.updateStrategy;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToDeleteStrategyException;
import businesslogic.strategybl.exception.UnableToModifyStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import dataservice.strategyDAO.StrategyDAO;
import po.StrategyPO;
import po.StrategyType;
import rmi.RemoteHelper;
import vo.StrategyVO;

/**
 * 
 * @author 双
 * @version
 * @see
 */
public class StrategyList {

    private StrategyDAO strategyDAO;

    // 在bl层储存策略列表
    private ArrayList<StrategyItem> birthdatyPromotionList;
    private ArrayList<StrategyItem> multiRoomPromotionList;
    private ArrayList<StrategyItem> memberRankMarketList;
    private ArrayList<StrategyItem> cooperationEnterprisePromotionList;
    private ArrayList<StrategyItem> specificTimePromotionList;
    private ArrayList<StrategyItem> specificTimeMarketList;
    private ArrayList<StrategyItem> vipTradeAreaMarketList;
    private HashMap<StrategyType, ArrayList<StrategyItem>> allStrategyList;

    private static StrategyList strategyList;
    private String address;

    protected StrategyList(String address) {
        this.address = address;
        strategyDAO = RemoteHelper.getInstance().getStrategyDAO();
        birthdatyPromotionList = getStrategyList(address, StrategyType.BirthdayPromotion);
        multiRoomPromotionList = getStrategyList(address, StrategyType.MultiRoomPromotion);
        memberRankMarketList = getStrategyList(address, StrategyType.MemberRankMarket);
        cooperationEnterprisePromotionList = getStrategyList(address, StrategyType.CooperationEnterprisePromotion);
        specificTimeMarketList = getStrategyList(address, StrategyType.SpecificTimeMarket);
        specificTimePromotionList = getStrategyList(address, StrategyType.SpecificTimePromotion);
        vipTradeAreaMarketList = getStrategyList(address, StrategyType.VipTradeAreaMarket);
        allStrategyList = new HashMap<>();
        allStrategyList.put(StrategyType.BirthdayPromotion, birthdatyPromotionList);
        allStrategyList.put(StrategyType.MultiRoomPromotion, multiRoomPromotionList);
        allStrategyList.put(StrategyType.MemberRankMarket, memberRankMarketList);
        allStrategyList.put(StrategyType.CooperationEnterprisePromotion, cooperationEnterprisePromotionList);
        allStrategyList.put(StrategyType.SpecificTimeMarket, specificTimeMarketList);
        allStrategyList.put(StrategyType.SpecificTimePromotion, specificTimePromotionList);
        allStrategyList.put(StrategyType.VipTradeAreaMarket, vipTradeAreaMarketList);

    }

    public static StrategyList getInstance(String address) {
        if (strategyList == null) {
            strategyList = new StrategyList(address);
        }
        if (!strategyList.address.equals(address)) {
            strategyList = new StrategyList(address);
        }
        return strategyList;
    }

    HashMap<StrategyType, ArrayList<StrategyItem>> getAllStrategyList() {
        return allStrategyList;
    }

    /**
     * 得到某种策略类型的列表
     * 
     * @param address
     *            string型，酒店地址
     * @param StrategyType
     *            枚举类，策略类型
     * @return 返回策略列表
     * @see
     */
    public ArrayList<StrategyItem> getStrategyList(String address, Enum<StrategyType> strategyType) {
        // 如果传入address不是该类的address,即查看非本酒店的策略，则返回null
        if (!this.address.equals(address)) {
            return null;
        }
        // 如果该类已初始化，则可以直接调用逻辑层的策略列表
        if (allStrategyList != null) {
            return allStrategyList.get(strategyType);
        }
        ArrayList<StrategyItem> strategyItems = new ArrayList<StrategyItem>();
        ArrayList<StrategyPO> strategyPOs;
        try {
            strategyPOs = strategyDAO.getStrategyList(address, strategyType);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for (StrategyPO strategyPO : strategyPOs) {
            strategyItems.add(new StrategyItem(strategyPO));
        }
        return strategyItems;

    }

    /**
     * 得到对应策略名称的策略
     * 
     * @param address
     *            string型，酒店地址
     * @param name
     *            string型，策略名称
     * @return 返回策略类
     * @see
     */
    public StrategyItem getStrategyInfo(String address, Enum<StrategyType> strategyType, String name) {
        // 在该类存储着的折扣列表中搜索
        ArrayList<StrategyItem> strategyItemList = allStrategyList.get(strategyType);
        for (StrategyItem strategyItem : strategyItemList) {
            if (strategyItem.toVO().strategyName.contains(name)) {
                return strategyItem;
            }
        }
        // 在数据库中搜索
        StrategyPO strategyPO;
        try {
            strategyPO = strategyDAO.getStrategyInfo(address, strategyType, name);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        // 如果没有搜索到该名称的折扣strategyPO,则返回null
        if (strategyPO == null) {
            return null;
        }
        return new StrategyItem(strategyPO);
    }

    /**
     * 增加一个策略
     * 
     * @param address
     *            string型，酒店地址
     * @param strategy
     *            StrategyVO型，包含策略信息
     * @return 返回是否增加成功
     * @throws UnableAddStrategyException
     * @see
     */
    public boolean add(String address, StrategyVO strategyVO) throws UnableAddStrategyException {

        if (!address.equals(this.address) || !address.equals(strategyVO.address)) {
            throw new UnableAddStrategyException(
                    "the address is not this hotel's address, you cann't add other hotel's strategy");
        }
        // 判断该折扣是否可以被添加
        if (!availableToAdd(strategyVO)) {
            return false;
        }
        StrategyItem strategyItem = new StrategyItem(strategyVO);
        boolean added = strategyItem.add(address);

        // 在添加策略之后及时更新该类中的策略列表
        if (added)
            allStrategyList.get(strategyVO.strategyType).add(strategyItem);
        return added;
    }

    /**
     * 判断该折扣是否可以被添加
     * 
     * @param strategyItem
     *            折扣信息
     * @return 返回该折扣是否可以被添加
     * @see
     */
    private boolean availableToAdd(StrategyVO strategyVO) throws UnableAddStrategyException {
        // 该折扣名称是否已存在，存在则无法添加
        Enum<StrategyType> addStrategyType = strategyVO.strategyType;
        for (StrategyItem strategyItem : allStrategyList.get(addStrategyType)) {
            if (strategyItem.toVO().strategyName.equals(strategyVO.strategyName)) {
                throw new UnableAddStrategyException("the strategyName has already existed");
            }
        }
        // 如果添加生日折扣，判断是否已存在生日折扣，生日折扣只能有一种
        if (addStrategyType == StrategyType.BirthdayPromotion && birthdatyPromotionList.size() == 1)
            throw new UnableAddStrategyException(
                    "the birthdayPromotion has already exited, there should be only one birthdayPromotion");
        Enum<StrategyType> strategyType = strategyVO.strategyType;
        // 如果添加多房间折扣，判断该房间数是否已存在
        if (strategyType == StrategyType.MultiRoomPromotion) {
            for (StrategyItem strategyItem : allStrategyList.get(strategyType)) {
                if (strategyItem.toVO().minRoomNum == strategyVO.minRoomNum) {
                    throw new UnableAddStrategyException("this minimum Room Number has already existed");
                }
            }
        }
        // 如果添加合作企业折扣，判断该合作企业是否已存在
        if (strategyType == StrategyType.CooperationEnterprisePromotion) {
            for (StrategyItem strategyItem : allStrategyList.get(strategyType)) {
                if (strategyItem.toVO().enterpriseName.equals(strategyVO.enterpriseName))
                    throw new UnableAddStrategyException("the enterprise has already existed");
            }
        }
        // 如果添加会员等级折扣，判断该会员等级是否已存在
        if (strategyType == StrategyType.MemberRankMarket) {
            for (StrategyItem strategyItem : allStrategyList.get(strategyType)) {
                if (strategyItem.toVO().vipRank == strategyVO.vipRank) {
                    throw new UnableAddStrategyException("this vipRank has already existed");
                }
            }
        }
        // 如果添加特定商圈会员专属折扣，判断该商圈的会员等级是否已存在
        if (strategyType == StrategyType.VipTradeAreaMarket) {
            // 判断该商圈的会员等级是否存在
            for (StrategyItem strategyItem : allStrategyList.get(strategyType)) {
                StrategyVO vo = strategyItem.toVO();
                if (vo.tradeArea.equals(strategyVO.tradeArea) && vo.vipRank == strategyVO.vipRank) {
                    throw new UnableAddStrategyException(
                            "the same tradeArea with the same vipRank number has already existed");
                }
            }
        }
        return true;
    }


    /**
     * 修改一个策略
     * 
     * @param address
     *            string型，酒店地址
     * @param strategy
     *            StrategyVO型，包含策略信息
     * @return 返回是否修改成功
     * @throws UnableToModifyStrategyException
     * @see
     */
    public boolean modify(String address, StrategyVO strategyVO) throws UnableToModifyStrategyException {
        if (!address.equals(this.address) || !address.equals(strategyVO.address)) {
            throw new UnableToModifyStrategyException(
                    "the address is not this hotel's address, you cann't modify other hotel's strategy");
        }
        // 判断该折扣是否可以被修改
        Enum<StrategyType> strategyType = strategyVO.strategyType;
        if (!availableToModify(strategyVO)) {
            return false;
        }
        StrategyItem strategyItem = new StrategyItem(strategyVO);
        boolean modifyed = strategyItem.modify(address);
        if (modifyed) {
            // 在修改策略之后及时更新该类中的策略列表
            ArrayList<StrategyItem> strategyItems = allStrategyList.get(strategyType);
            for (int i = 0; i < strategyItems.size(); i++) {
                if (strategyItems.get(i).toVO().strategyName.equals(strategyVO.strategyName)) {
                    allStrategyList.get(strategyType).remove(i);
                    allStrategyList.get(strategyType).add(i, strategyItem);
                    break;
                }
            }
        }
        return modifyed;
    }

    /**
     * 判断该折扣是否可以被修改
     * 
     * @param strategyVO
     *            折扣信息
     * @return 返回折扣是否可以被修改
     * @see
     */
    public boolean availableToModify(StrategyVO strategyVO) throws UnableToModifyStrategyException {
        Enum<StrategyType> modigyStrategyType = strategyVO.strategyType;
        // 该折扣名称是否已存在，不存在则无法修改
        boolean exited = false;
        for (StrategyItem strategyItem : allStrategyList.get(modigyStrategyType)) {
            if (strategyItem.toVO().strategyName.equals(strategyVO.strategyName)) {
                exited = true;
                break;
            }
        }
        if (!exited)
            throw new UnableToModifyStrategyException("the strategyName doesn't exist");
        // 如果是生日折扣，名称不能改变
        if (modigyStrategyType == StrategyType.BirthdayPromotion) {
            if (!strategyVO.strategyName.equals(birthdatyPromotionList.get(0).toVO().strategyName)) {
                throw new UnableToModifyStrategyException("the name of birthdayPromotion cannot be changed");
            }
        }
        // 判断该折扣能否被添加或修改
        // try {
        // if (!availbleToAddOrModify(strategyVO))
        // return false;
        // } catch (UnableAddStrategyException e) {
        // throw new UnableToModifyStrategyException(e.getMessage());
        // }
        Enum<StrategyType> strategyType = strategyVO.strategyType;
        // 如果添加多房间折扣，判断该房间数是否已存在
        if (strategyType == StrategyType.MultiRoomPromotion) {
            for (StrategyItem strategyItem : allStrategyList.get(strategyType)) {
                if (!strategyVO.strategyName.equals(strategyItem.toVO().strategyName)) {
                    if (strategyItem.toVO().minRoomNum == strategyVO.minRoomNum) {
                        throw new UnableToModifyStrategyException("this minimum Room Number has already existed");
                    }
                }
            }
        }
        // 如果添加合作企业折扣，判断该合作企业是否已存在
        if (strategyType == StrategyType.CooperationEnterprisePromotion) {
            for (StrategyItem strategyItem : allStrategyList.get(strategyType)) {
                if (!strategyVO.strategyName.equals(strategyItem.toVO().strategyName)) {
                    if (strategyItem.toVO().enterpriseName.equals(strategyVO.enterpriseName))
                        throw new UnableToModifyStrategyException("the enterprise has already existed");
                }
            }
        }
        // 如果添加会员等级折扣，判断该会员等级是否已存在
        if (strategyType == StrategyType.MemberRankMarket) {
            for (StrategyItem strategyItem : allStrategyList.get(strategyType)) {
                if (!strategyVO.strategyName.equals(strategyItem.toVO().strategyName)) {
                    if (strategyItem.toVO().vipRank == strategyVO.vipRank) {
                        throw new UnableToModifyStrategyException("this vipRank has already existed");
                    }
                }
            }
        }
        // 如果添加特定商圈会员专属折扣，判断该商圈的会员等级是否已存在
        if (strategyType == StrategyType.VipTradeAreaMarket) {
            // 判断该商圈的会员等级是否存在
            for (StrategyItem strategyItem : allStrategyList.get(strategyType)) {
                StrategyVO vo = strategyItem.toVO();
                if (!strategyVO.strategyName.equals(strategyItem.toVO().strategyName)) {
                    if (vo.tradeArea.equals(strategyVO.tradeArea) && vo.vipRank == strategyVO.vipRank) {
                        throw new UnableToModifyStrategyException(
                                "the same tradeArea with the same vipRank number has already existed");
                    }
                }
            }
        }
        return true;
    }

    /**
     * 删除一个策略
     * 
     * @param address
     *            string型，酒店地址
     * @param strategy
     *            StrategyVO型，包含策略信息
     * @return 返回是否删除成功
     * @throws UnableToDeleteStrategyException
     * @see
     */
    public boolean delete(String address, StrategyVO strategyVO) throws UnableToDeleteStrategyException {
        if (!address.equals(this.address) || !address.equals(strategyVO.address)) {
            throw new UnableToDeleteStrategyException(
                    "the address is not this hotel's address, you cann't delete other hotel's strategy");
        }
        // 该折扣名称是否已存在，不存在则无法删除
        boolean exited = false;
        Enum<StrategyType> strategyType = strategyVO.strategyType;
        for (StrategyItem strategyItem : allStrategyList.get(strategyType)) {
            if (strategyItem.toVO().strategyName.equals(strategyVO.strategyName)) {
                exited = true;
                break;
            }
        }
        if (!exited)
            throw new UnableToDeleteStrategyException("the strategyName doesn't exist");
        StrategyItem strategyItem = new StrategyItem(strategyVO);
        boolean deleted = strategyItem.delete(address);
        // 在删除策略之后及时更新该类中的策略列表
        if (deleted) {
            ArrayList<StrategyItem> strategyItems = allStrategyList.get(strategyType);
            for (int i = 0; i < strategyItems.size(); i++) {
                if (strategyItems.get(i).toVO().strategyName.equals(strategyVO.strategyName)) {
                    allStrategyList.get(strategyType).remove(i);
                    break;
                }
            }
        }
        return deleted;
    }

    /**
     * 判断该策略信息是否有效
     * 
     * @param address
     *            string型，酒店地址
     * @param strategy
     *            StrategyVO型，包含策略信息
     * @return 返回该策略信息是否有效
     * @see
     */
    public boolean valid(String address, StrategyVO strategyVO) throws WrongInputException {
        StrategyItem strategyItem = new StrategyItem(strategyVO);
        return strategyItem.valid();
    }

    /**
     * 验证特定商圈会员专属折扣的商圈名称在某城市是否存在
     * 
     * @param city
     *            String型，城市名称
     * @param strategyVO
     *            策略信息
     * @return 返回商圈是否存在
     * @throws WrongInputException
     * @see
     */
    public boolean verifyTradeArea(String city, StrategyVO strategyVO) throws WrongInputException {
        StrategyItem strategyItem = new StrategyItem(strategyVO);
        return strategyItem.verifyTradeArea(city);
    }
}
