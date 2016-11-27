package businesslogic.roombl;

import java.util.Date;

import businesslogicservice.orderblservice.ResultMessage;
import dataservice.roomDAO.RoomDAO;
import po.RoomType;
import vo.OrderVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class RoomInfoServiceImpl implements RoomInfoService{

    RoomDAO roomDAO;
    
    @Override
    public int getAvailableRoomNum(String address, Enum<RoomType> roomType) {
        //搜索得到对应房间类型的空房信息
        //得到空房信息的房间数
        return 0;
    }

    @Override
    public boolean isTimeAvailable(String addresss, Enum<RoomType> roomType, Date beginDate, Date finishDate) {
        //取出那天的空房表
        //判断那天的空房表房间数是否大于
        return false;
    }

    @Override
    public ResultMessage checkOrder(OrderVO vo) {
        //调用上两个方法
        return null;
    }

    @Override
    public boolean updateSpareRoom(String address, RoomVO roomvo) {
        //取得空房列表
        //看空房列表是否存在该房间类型
        //有则调用更新空房的方法
        //无则调用增加空房的方法
        return false;
    }

    @Override
    public boolean reduceRoom(String address, int change, Enum<RoomType> roomType) {
        //调用更新空房的方法改变房间数量
        return false;
    }

    @Override
    public boolean addRoom(String address, int change, Enum<RoomType> roomType) {
        //调用更新空房的方法改变房间数量
        return false;
    }

}
