package data_Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import po.HotelPO;
import po.RoomType;

public class HotelDAOImpl_Stub implements HotelDAO {

	public String hotelName;
	public String businessDistrict;
	public String hotelAddress;
	public int starLevel;
	public int mark;
	
	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<String, String> comments;
	
	public HotelDAOImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel, int mark) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
	}
	
	public HotelDAOImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel, int mark,
			String briefIntroduction, String facilityAndService, HashMap<RoomType, Integer> roomTypeAndPrice,
			HashMap<String, String> comments) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.comments = comments;
	}
	
	@Override
	public BriefHotelInfoPO getHotelBriefInfo(String address) throws RemoteException {
		return new BriefHotelInfoPO(hotelName, businessDistrict, address, starLevel, mark);
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListBySearching(String[] condition) throws RemoteException {
		ArrayList<BriefHotelInfoPO> briefHotelInfoPOList = new ArrayList<>();
		briefHotelInfoPOList.add(new BriefHotelInfoPO(hotelName, businessDistrict, hotelAddress, starLevel, mark));
		return briefHotelInfoPOList;
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListByQuerying(String[] condition) throws RemoteException {
		ArrayList<BriefHotelInfoPO> briefHotelInfoPOList = new ArrayList<>();
		briefHotelInfoPOList.add(new BriefHotelInfoPO(hotelName, businessDistrict, hotelAddress, starLevel, mark));
		return briefHotelInfoPOList;
	}

	@Override
	public HotelPO getHotelDetails(String address) throws RemoteException {
		return new HotelPO(hotelName, businessDistrict, address, starLevel, mark, briefIntroduction, facilityAndService, roomTypeAndPrice, comments);
	}

	@Override
	public void update(HotelPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}

	@Override
	public void insert(HotelPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}

	@Override
	public void init() throws RemoteException {
		System.out.println("Init Succeed!\n");
	}

	@Override
	public void finish() throws RemoteException {
		System.out.println("Finish succeed!\n");
	}

}
