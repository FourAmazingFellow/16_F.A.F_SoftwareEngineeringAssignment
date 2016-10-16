package bl_Stub.hotelblservice_Stub;

import java.util.ArrayList;
import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import vo.BriefHotelInfoVO;

public class CheckOrderedHotelServiceImpl_Stub implements CheckOrderedHotelService{
	public String hotelName;
	public String businessDistrict;
	public String hotelAddress;
	public int starLevel;
	public int mark;
	
	public CheckOrderedHotelServiceImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel,
			int mark) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
	}
	
	@Override
	public ArrayList<BriefHotelInfoVO> enrollHotelBreifInfoList(long ID) {
		ArrayList<BriefHotelInfoVO> briefHotelInfoVOList = new ArrayList<>();
		briefHotelInfoVOList.add(new BriefHotelInfoVO(hotelName, businessDistrict, hotelAddress, starLevel, mark));
		return briefHotelInfoVOList;
	}

}
