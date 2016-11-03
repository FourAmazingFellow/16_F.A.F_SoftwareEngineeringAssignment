package vo;

import java.util.ArrayList;

import po.OrderState;

public class OrderedHotelInfoVO {
	 public String hotelName;
	 public String businessDistrict;
	 public String hotelAddress;
	 public int starLevel;
	 public int mark;
	 public ArrayList<OrderState> hotelState;

	 public OrderedHotelInfoVO(String hotelName, String businessDistrict, String hotelAddress, int starLevel, int mark, ArrayList<OrderState> hotelState) {
		 this.hotelName = hotelName;
		 this.businessDistrict = businessDistrict;
	     this.hotelAddress = hotelAddress;
	     this.starLevel = starLevel;
	     this.mark = mark;
	     this.hotelState = hotelState;
	 }
	 
	 public OrderedHotelInfoVO(BriefHotelInfoVO briefHotelInfoVO, ArrayList<OrderState> hotelState) {
		 this.hotelName = briefHotelInfoVO.hotelName;
		 this.businessDistrict = briefHotelInfoVO.businessDistrict;
	     this.hotelAddress = briefHotelInfoVO.hotelAddress;
	     this.starLevel = briefHotelInfoVO.starLevel;
	     this.mark = briefHotelInfoVO.mark;
	     this.hotelState = hotelState;
	 }
}
