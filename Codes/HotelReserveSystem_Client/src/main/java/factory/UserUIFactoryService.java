package factory;

import businesslogicservice.userblservice.AddCreditValueService;
import businesslogicservice.userblservice.LoginAndSignUpService;
import businesslogicservice.userblservice.ManageUserInfoService;
import businesslogicservice.userblservice.ModifyClientInfoService;
import businesslogicservice.userblservice.QueryClientCreditRecordService;
import businesslogicservice.userblservice.SignVipService;

public interface UserUIFactoryService {
	public AddCreditValueService createAddCreditValueService();

	public LoginAndSignUpService createLoginAndSignUpService();

	public ManageUserInfoService createManageUserInfoService();

	public ModifyClientInfoService createModifyClientInfoService();

	public QueryClientCreditRecordService createQueryClientCreditRecordService();

	public SignVipService createSignVipService();
}
