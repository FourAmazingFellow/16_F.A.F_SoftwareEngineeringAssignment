package businesslogic.hotelbl;

import vo.BriefHotelInfoVO;
import vo.HotelVO;

public class MockHotelInfoServiceImpl extends HotelInfoServiceImpl{

	HotelVO hotelVO;
	BriefHotelInfoVO briefHotelInfoVO;
	
	public MockHotelInfoServiceImpl(HotelVO hotelVO, BriefHotelInfoVO briefHotelInfoVO) {
		this.briefHotelInfoVO = briefHotelInfoVO;
		this.hotelVO = hotelVO;
	}
	
	@Override
	public BriefHotelInfoVO getHotelBriefInfo(String address) {
		return briefHotelInfoVO;
	}

	@Override
	public HotelVO getHotelDetails(String address) {
		return hotelVO;
	}
	
	
}
