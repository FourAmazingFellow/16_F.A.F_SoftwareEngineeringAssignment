package vo;

import po.BriefHotelInfoPO;

/**
 * 
 * @author 原
 * @version 1.0
 * @see
 */
public class BriefHotelInfoVO{
    public String hotelName;
    public String businessDistrict;
    public String hotelAddress;
    public int starLevel;
    public float mark;
    public String city;
    public int min_Price;

    public BriefHotelInfoVO(BriefHotelInfoPO briefHotelInfoPO) {
    	this.hotelName = briefHotelInfoPO.getHotelName();
        this.businessDistrict = briefHotelInfoPO.getBusinessDistrict();
        this.hotelAddress = briefHotelInfoPO.getHotelAddress();
        this.starLevel = briefHotelInfoPO.getStarLevel();
        this.mark = briefHotelInfoPO.getMark();
        this.city = briefHotelInfoPO.getCity();
        this.min_Price = briefHotelInfoPO.getMin_Price();
    }
    
    public BriefHotelInfoVO(String hotelName, String businessDistrict, String hotelAddress, int starLevel, float mark, String city) {
        this.hotelName = hotelName;
        this.businessDistrict = businessDistrict;
        this.hotelAddress = hotelAddress;
        this.starLevel = starLevel;
        this.mark = mark;
        this.city = city;
    }
}

