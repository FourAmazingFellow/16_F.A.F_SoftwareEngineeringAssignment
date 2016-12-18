package businesslogicservice.hotelblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BusinessDistrictPO;
import vo.OrderedHotelInfoVO;

/**
 * 为界面提供搜索酒店所需要的方法
 * @author 原
 * @version 1.0
 * @see
 */
public interface SearchHotelService {
	
	/**
	 * 搜索符合输入条件的酒店
	 * @param condition String[]型，界面传递来的搜索条件，是一个长度为13的String数组，且必须保证传过来的数组长度为14；
	 * condition[0]代表的是酒店所在的城市，不可为空，如"南京市"；
	 * condition[1]代表的是酒店所在的商圈，不可为空，如"栖霞区"；
	 * condition[2]代表的是酒店名称，可以为空，若为空，则用""的空字符串来填补；
	 * condition[3]代表的是酒店的价格区间的左端点，必须为一个大于等于0的整数的字符串形式，如"0"；
	 * condition[4]代表的是酒店的价格区间的右端点，必须为一个大于等于condition[3]的整数的字符串形式；
	 * 如果用户没有限定酒店价格，则可以将condition[3]设置成"0"，condition[4]设置成一个很大的数，如"1000000"，这样就相当于价格没有限制；
	 * condition[5]代表的是酒店星级区间的左端点，必须为一个大于等于0的整数的字符串形式，如"3"；
	 * condition[6]代表的是酒店星级区间的右端点，必须为一个大于等于condition[5]的整数的字符串形式， 如"5"；
	 * 如果用户没有限定酒店星级，则可以将condition[5]设置为"0"，condition[6]设置成"6"(考虑到酒店星级最大为5)；
	 * condition[7]代表的是酒店评分区间的左端点，必须为一个大于等于0的浮点数的字符串形式，如"3.0"(注意此处并不需要在小数后面加f)；
	 * condition[8]代表的是酒店评分区间的右端点，必须为一个大于等于condition[7]的浮点数的字符串形式，如"5.0"(注意此处并不需要在小数后面加f)；
	 * 如果用户没有限定酒店评分，则可以将condition[7]设置为"0.0"(注意此处并不需要在小数后面加f),condition[8]设置为"6.0"(注意此处并不需要在小数后面加f)；
	 * condition[9]代表的是用户是否限定只搜索自己预定过的酒店，"0"代表不限定，"1"代表限定，这两者以外的其他字符均会被当成非法字符；
	 * condition[10]代表的是用户选择的搜索房型，这里用"0"、"1"、"2"、"3"（其他字符均会被当成非法字符）对应于RoomType中的四种房间类型（按照RoomType中定义的顺序)，不能为空，若用户没有限定，则默认为"0"；
	 * condition[11]代表的是用户选择的房间数量，必须为一个大于等于0的整数的字符串形式，不能为空，若用户没有限定，则默认为"1"；
	 * condition[12]代表的是用户选择的入住日期，形式为"xxxx-xx-xx"，如"2016-12-06"，不能为空；
	 * condition[13]代表的是用户选择的离店日期，形式为"xxxx-xx-xx"，如"2016-12-07"，不能为空；
	 * 以上所有的条件若用户没有限定，则界面传递过来时，必须手动为其赋值为相应的默认值；
	 * @return 返回所有满足条件的酒店简要信息列表
	 * @throws RemoteException 
	 * @see
	 */
	public ArrayList<OrderedHotelInfoVO> getHotelBriefInfoListBySearching(String[] condition) throws RemoteException;

	/**
	 * 获得商圈列表
	 * @return 返回商圈列表
	 * @throws RemoteException 
	 * @see
	 */
	public ArrayList<BusinessDistrictPO> getBusinessDistrictList(String city) throws RemoteException;
}
