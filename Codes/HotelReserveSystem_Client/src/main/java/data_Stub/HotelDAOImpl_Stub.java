package data_Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.HotelPO;
import po.RoomType;

public class HotelDAOImpl_Stub implements HotelDAO {

	public String hotelName;
	public String businessDistrict;
	public String hotelAddress;
	public int starLevel;
	public float mark;
	public String city;
	
	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<RoomType, Integer> roomTypeAndNums;
	public HashMap<String, String> comments;
	
	public HotelDAOImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel, float mark, String city) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
		this.city = city;
	}
	
	public HotelDAOImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel, float mark, String city,
			String briefIntroduction, String facilityAndService, HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<RoomType, Integer> roomTypeAndNums,
			HashMap<String, String> comments) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
		this.city = city;
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.roomTypeAndNums = roomTypeAndNums;
		this.comments = comments;
	}
	
	@Override
	public BriefHotelInfoPO getHotelBriefInfo(String address) throws RemoteException {
		return new BriefHotelInfoPO(hotelName, businessDistrict, address, starLevel, mark, city);
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListBySearching(String[] condition) throws RemoteException {
		ArrayList<BriefHotelInfoPO> briefHotelInfoPOList = new ArrayList<>();
		briefHotelInfoPOList.add(new BriefHotelInfoPO(hotelName, businessDistrict, hotelAddress, starLevel, mark, city));
		return briefHotelInfoPOList;
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListByQuerying(String[] condition, ArrayList<BriefOrderInfoPO> orderedHotelList) throws RemoteException {
		ArrayList<BriefHotelInfoPO> briefHotelInfoPOList = new ArrayList<>();
		briefHotelInfoPOList.add(new BriefHotelInfoPO(hotelName, businessDistrict, hotelAddress, starLevel, mark, city));
		return briefHotelInfoPOList;
	}

	@Override
	public HotelPO getHotelDetails(String address) throws RemoteException {
		return new HotelPO(hotelName, businessDistrict, address, starLevel, mark, city, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
	}

	@Override
	public void updateHotel(HotelPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}

	@Override
	public void insertHotel(HotelPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}

}
