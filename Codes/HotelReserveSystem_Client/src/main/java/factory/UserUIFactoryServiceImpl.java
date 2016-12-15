package factory;

import businesslogic.userbl.addCreditValue.AddCreditValueServiceImpl;
import businesslogic.userbl.loginAndSignUp.LoginAndSignUpServiceImpl;
import businesslogic.userbl.mamageUserInfo.ManageUserInfoServiceImpl;
import businesslogic.userbl.modifyClientInfo.ModifyClientInfoServiceImpl;
import businesslogic.userbl.queryClientCreditRecord.QueryClientCreditRecordServiceImpl;
import businesslogic.userbl.signVip.SignVipServiceImpl;
import businesslogicservice.userblservice.AddCreditValueService;
import businesslogicservice.userblservice.LoginAndSignUpService;
import businesslogicservice.userblservice.ManageUserInfoService;
import businesslogicservice.userblservice.ModifyClientInfoService;
import businesslogicservice.userblservice.QueryClientCreditRecordService;
import businesslogicservice.userblservice.SignVipService;

public class UserUIFactoryServiceImpl implements UserUIFactoryService {

	@Override
	public AddCreditValueService createAddCreditValueService() {
		return new AddCreditValueServiceImpl();
	}

	@Override
	public LoginAndSignUpService createLoginAndSignUpService() {
		return new LoginAndSignUpServiceImpl();
	}

	@Override
	public ManageUserInfoService createManageUserInfoService() {
		return new ManageUserInfoServiceImpl();
	}

	@Override
	public ModifyClientInfoService createModifyClientInfoService() {
		return new ModifyClientInfoServiceImpl();
	}

	@Override
	public QueryClientCreditRecordService createQueryClientCreditRecordService() {
		return new QueryClientCreditRecordServiceImpl();
	}

	@Override
	public SignVipService createSignVipService() {
		return new SignVipServiceImpl();
	}

}
