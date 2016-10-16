package bl_Driver.hotelblservice_Driver;

import java.util.HashMap;

import businesslogicservice.hotelblservice.ManageHotelInfoService;
import po.RoomType;
import vo.HotelStaffInfoVO;
import vo.HotelVO;
import vo.UserType;

public class ManageHotelInfoService_Driver {
	public void drive(ManageHotelInfoService manageHotelInfoService) {
		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 1000);
		HashMap<String, String> comments = new HashMap<>();
		comments.put("原", "该酒店服务到位，应有尽有！");
		HotelVO hotel = new HotelVO("Jingling Hotel", "新街口", "江苏省南京市栖霞区仙林大道163号", 5, 5, "南京市最好的酒店", "所有服务应有尽有", roomTypeAndPrice, comments);
		boolean result = manageHotelInfoService.addHotel(hotel);
		if(result)
			System.out.println("添加酒店成功！\n");
		else
			System.out.println("添加酒店失败！\n");
		
		HotelStaffInfoVO staff = new HotelStaffInfoVO(19970909, "123456", 13655255834L, UserType.HotelStaff, "Jingling Hotel");
		boolean result2 = manageHotelInfoService.addHotelStaff(staff);
		if(result2)
			System.out.println("添加酒店工作人员成功！\n");
		else
			System.out.println("添加酒店工作人员失败！\n");
	}
}
