package po;

import java.io.Serializable;

import vo.BriefHotelInfoVO;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public class BriefHotelInfoPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7803949077367829494L;
	
	private String hotelName;
	private String businessDistrict;
	private String hotelAddress;
	private int starLevel;
	private float mark;
	private String city;
	private int min_Price;
	
	public BriefHotelInfoPO(String hotelName, String businessDistrict, String hotelAddress, int starLevel, float mark, String city) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
		this.city = city;
	}
	
	public BriefHotelInfoPO(BriefHotelInfoVO briefHotelInfoVO) {
		this.hotelName = briefHotelInfoVO.hotelName;
		this.businessDistrict = briefHotelInfoVO.businessDistrict;
		this.hotelAddress = briefHotelInfoVO.hotelAddress;
		this.starLevel = briefHotelInfoVO.starLevel;
		this.mark = briefHotelInfoVO.mark;
		this.city = briefHotelInfoVO.city;
		this.min_Price = briefHotelInfoVO.min_Price;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getBusinessDistrict() {
		return businessDistrict;
	}
	public void setBusinessDistrict(String businessDistrict) {
		this.businessDistrict = businessDistrict;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public int getStarLevel() {
		return starLevel;
	}
	public void setStarLevel(int starLevel) {
		this.starLevel = starLevel;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getMin_Price() {
		return min_Price;
	}
	public void setMin_Price(int min_Price) {
		this.min_Price = min_Price;
	}

}
