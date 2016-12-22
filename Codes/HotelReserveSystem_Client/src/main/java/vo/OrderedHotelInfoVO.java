package vo;

import java.util.Set;

import po.OrderState;

public class OrderedHotelInfoVO {
	 public String hotelName;
	 public String tradeArea;
	 public String hotelAddress;
	 public int starLevel;
	 public float mark;
	 public int min_Price;
	 public Set<Enum<OrderState>> hotelState;

	 public OrderedHotelInfoVO(String hotelName, String tradeArea, String hotelAddress, int starLevel, float mark, Set<Enum<OrderState>> hotelState, int min_Price) {
		 this.hotelName = hotelName;
		 this.tradeArea = tradeArea;
	     this.hotelAddress = hotelAddress;
	     this.starLevel = starLevel;
	     this.mark = mark;
	     this.hotelState = hotelState;
	     this.min_Price = min_Price;
	 }
	 
	 public OrderedHotelInfoVO(BriefHotelInfoVO briefHotelInfoVO, Set<Enum<OrderState>> hotelState) {
		 this.hotelName = briefHotelInfoVO.hotelName;
		 this.tradeArea = briefHotelInfoVO.tradeArea;
	     this.hotelAddress = briefHotelInfoVO.hotelAddress;
	     this.starLevel = briefHotelInfoVO.starLevel;
	     this.mark = briefHotelInfoVO.mark;
	     this.hotelState = hotelState;
	     this.min_Price = briefHotelInfoVO.min_Price;
	 }
}
