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
    public String tradeArea;
    public String hotelAddress;
    public int starLevel;
    public float mark;
    public String city;
    public int min_Price;
    public int max_Price;

    public BriefHotelInfoVO(BriefHotelInfoPO briefHotelInfoPO) {
    	this.hotelName = briefHotelInfoPO.getHotelName();
        this.tradeArea = briefHotelInfoPO.getTradeArea();
        this.hotelAddress = briefHotelInfoPO.getHotelAddress();
        this.starLevel = briefHotelInfoPO.getStarLevel();
        this.mark = briefHotelInfoPO.getMark();
        this.city = briefHotelInfoPO.getCity();
        this.min_Price = briefHotelInfoPO.getMin_Price();
        this.max_Price = briefHotelInfoPO.getMax_Price();
    }
    
    public BriefHotelInfoVO(String hotelName, String tradeArea, String hotelAddress, int starLevel, float mark, String city) {
        this.hotelName = hotelName;
        this.tradeArea = tradeArea;
        this.hotelAddress = hotelAddress;
        this.starLevel = starLevel;
        this.mark = mark;
        this.city = city;
    }
}

