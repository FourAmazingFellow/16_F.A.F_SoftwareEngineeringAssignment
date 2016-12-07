package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelVO;
import vo.OrderVO;
import vo.OrderedHotelInfoVO;

/**
 * 为界面提供查看酒店信息所需要的方法
 * @author 原
 * @version 1.0
 * @see
 */
public interface QueryHotelService {
    
    /**
     * 查找符合输入条件的酒店
     * @param condition String[]型，界面传递来的查看条件,数组长度必须为4；
     * condition[0]代表的是酒店所在的城市，不可为空，如"南京市"；
	 * condition[1]代表的是酒店所在的商圈，不可为空，如"栖霞区"；
	 * condition[2]代表的是用户所希望的浏览时的酒店的排序方式，"0"代表的是按价格从低到高，"1"代表的是按价格从高到低，"2"代表的是按星级从低到高，"3"代表的是按星级从高到低，"4"代表的是按评分从低到高，"5"代表的是按评分从高到低(所有其他的数据将被当作非法数据)；
	 * condition[3]代表的是用户是否限定只搜索自己预定过的酒店，"0"代表不限定，"1"代表限定，这两者以外的其他字符均会被当成非法字符；
     * @return 返回符合输入条件的所有酒店的简要信息列表
     * @see
     */
    public ArrayList<OrderedHotelInfoVO> getHotelBriefInfoListByQuerying (String[] condition);
    
    /**
     * 获取酒店详细信息
     * @param address String型，界面传递来的酒店地址
     * @return 返回酒店详细信息
     * @see
     */
    public HotelVO getHotelDetails(String address);
    
    /**
     * 获取用户在该酒店的所有订单
     * @param address String型，界面传递来的酒店地址
     * @param ID long型，界面传递来的用户标识
     * @return 返回用户在该酒店的所有订单的列表
     * @see
     */
    public ArrayList<OrderVO> getOrders(String address, String userID);

}
