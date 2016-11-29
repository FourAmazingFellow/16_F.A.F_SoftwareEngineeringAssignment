package po;

import java.io.Serializable;

public class BusinessDistrictPO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3240302967894727923L;
	private String businessDistrictName;
    private String city;
    
   

	public BusinessDistrictPO(String businessDistrictName, String city){
        this.businessDistrictName=businessDistrictName;
        this.city = city;
    }

    public String getBusinessDistrictName() {
        return businessDistrictName;
    }

    public void setBusinessDistrictName(String businessDistrictName) {
        this.businessDistrictName = businessDistrictName;
    }
    
    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
