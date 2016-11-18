package data_Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import po.HotelPO;
import po.RoomType;

public class HotelDAO_Driver {
	public void driver(HotelDAO hotelDAO) {
		try {
			BriefHotelInfoPO briefHotelInfoPO = hotelDAO.getHotelBriefInfo("江苏省南京市栖霞区仙林大道163号");
			System.out.println("得到了" + briefHotelInfoPO.getHotelName() + "的基本信息");
		} catch (RemoteException e) {
			System.out.println("网络通信失败");
			e.printStackTrace();
		}
		
		String[] condition = {"不限", "不限", "不限", "不限", "不限", "不限", "不限", "不限", "否"};
		try {
			ArrayList<BriefHotelInfoPO> briefHotelInfoPOList = hotelDAO.getHotelBriefInfoListBySearching(condition);
			if(briefHotelInfoPOList.isEmpty())
				System.out.println("没有满足条件的酒店\n");
			else
				System.out.println("有" + briefHotelInfoPOList.size() + "个满足条件的酒店");
		} catch (RemoteException e) {
			System.out.println("网络通信失败");
			e.printStackTrace();
		}
		
		try {
			HotelPO hotel = hotelDAO.getHotelDetails("江苏省南京市栖霞区仙林大道163号");
			System.out.println("得到了" + hotel.getHotelName() + "的详细信息");
		} catch (RemoteException e) {
			System.out.println("网络通信失败");
			e.printStackTrace();
		}
		
		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 1000);
		HashMap<String, String> comments = new HashMap<>();
		comments.put("原", "该酒店服务到位，应有尽有！");
		HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 20);
		HotelPO hotelPO = new HotelPO("Jingling Hotel", "新街口", "江苏省南京市栖霞区仙林大道163号", 5, 5.0f, "南京市", "南京市最好的酒店", "所有服务应有尽有", roomTypeAndPrice, roomTypeAndNums, comments);
		try {
			hotelDAO.update(hotelPO);
			System.out.println("酒店信息更新成功！\n");
		} catch (RemoteException e) {
			System.out.println("网络通信失败");
			System.out.println("酒店信息更新失败！\n");
			e.printStackTrace();
		}
		
		HotelPO hotelPO2 = new HotelPO("HuiFu Hotel", "新街口", "江苏省南京市栖霞区仙林大道163号", 5, 5.0f, "南京市", "南京市最好的酒店", "所有服务应有尽有", roomTypeAndPrice, roomTypeAndNums, comments);
		try {
			hotelDAO.insert(hotelPO2);
			System.out.println("插入酒店信息成功\n");
		} catch (RemoteException e) {
			System.out.println("网络通信失败");
			System.out.println("插入酒店信息失败\n");
			e.printStackTrace();
		}
		
		try {
			hotelDAO.init();
			System.out.println("初始化持久化数据存储成功！\n");
		} catch (RemoteException e) {
			System.out.println("网络通信失败");
			System.out.println("初始化持久化数据存储失败！\n");
			e.printStackTrace();
		}
		
		try {
			hotelDAO.finish();
			System.out.println("结束持久化数据存储成功！\n");
		} catch (RemoteException e) {
			System.out.println("网络通信失败");
			System.out.println("结束持久化数据存储失败！\n");
			e.printStackTrace();
		}
	}
}