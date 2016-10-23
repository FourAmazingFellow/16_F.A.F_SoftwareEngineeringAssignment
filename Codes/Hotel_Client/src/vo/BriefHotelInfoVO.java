package vo;

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
    public int mark;

    public BriefHotelInfoVO(String hotelName, String businessDistrict, String hotelAddress, int starLevel, int mark) {
        this.hotelName = hotelName;
        this.businessDistrict = businessDistrict;
        this.hotelAddress = hotelAddress;
        this.starLevel = starLevel;
        this.mark = mark;
    }
}

