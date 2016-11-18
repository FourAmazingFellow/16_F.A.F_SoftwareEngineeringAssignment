package org.FAF.businesslogic.orderbl.createNewOrder;

import org.junit.Before;

import businesslogic.roombl.MockRoomInfoServiceImpl;
import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.MockClientCreditInfoImpl;
import businesslogicservice.orderblservice.ResultMessage;

public class CheckerTest {
	private ClientCreditInfo mockClientCreditGetter;
	private RoomInfoService mockOrderChecker;
	
	private boolean canUserCreateNewOrder;
	private ResultMessage resultMessage;
	
	@Before
	public void setup(){
		mockClientCreditGetter = new MockClientCreditInfoImpl();
		mockOrderChecker = new MockRoomInfoServiceImpl();
	}
}
