package bl_Driver.hotelblservice_Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.QueryHotelService;
import vo.HotelVO;
import vo.OrderVO;
import vo.OrderedHotelInfoVO;

public class QueryHotelService_Driver {
	public void driver(QueryHotelService queryHotelService) throws RemoteException {
		String[] conditions  = {"从低到高", "从高到低", "从高到低", "是"};
		ArrayList<OrderedHotelInfoVO> briefHotelInfoVOList = queryHotelService.getHotelBriefInfoListByQuerying(conditions);
		if(briefHotelInfoVOList.isEmpty())
			System.out.println("无满足此条件的酒店");
		else
			System.out.println(briefHotelInfoVOList.size() + "酒店满足条件");
		
		HotelVO hotel = queryHotelService.getHotelDetails("江苏省南京市栖霞区仙林大道163号");
		System.out.println(hotel.briefIntroduction);
		
		ArrayList<OrderVO> orderVOList = queryHotelService.getOrders("江苏省南京市栖霞区仙林大道163号", "原");
		if(orderVOList.isEmpty())
			System.out.println("没有此类订单");
		else
			System.out.println("共有" + orderVOList.size() + "个订单");
		
		
	}
}
