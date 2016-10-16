package data_Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dataservice.orderDAO.OrderDAO;
import po.BriefOrderInfoPO;
import po.OrderPO;
import po.OrderState;
import po.OrderType;

public class OrderDAO_Driver {
	@SuppressWarnings("deprecation")
	public void drive(OrderDAO orderDAO){
		try {
			System.out.println("正在获取客户所有订单列表");
			ArrayList<BriefOrderInfoPO> normalOrderList = orderDAO.getUserOrderList(1, OrderType.ALL);
			System.out.println("正在获取详细订单信息");
			OrderPO orderPO_1 = orderDAO.getSingleOrder(normalOrderList.get(0).getHotelAddress(), normalOrderList.get(0).getOrderID());
			System.out.println("1号订单详情展开成功，其最晚订单执行时间为" + orderPO_1.getLastedOrderDoneTime().toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("网络通信故障");
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
		try {
			System.out.println("正在获取所有异常订单的列表");
			ArrayList<BriefOrderInfoPO> abnormalOrderList = orderDAO.getAllAbnormalList(new Date(2016, 10, 16));
			System.out.println("正在获取该异常订单的详细信息");
			OrderPO orderPO_2 = orderDAO.getSingleOrder(abnormalOrderList.get(0).getHotelAddress(), abnormalOrderList.get(0).getOrderID());
			System.out.println("2号订单详情展开成功，其最晚订单执行时间为" + orderPO_2.getLastedOrderDoneTime().toString());
			System.out.println("现在的时间为" + new Date().toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("网络通信故障");
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
		try {
			System.out.println("正在获取该客户所有可评价订单的列表");
			ArrayList<OrderPO> commentableOrderList = orderDAO.getCommentableOrders(1);
			OrderPO orderPO_3 = orderDAO.getSingleOrder(commentableOrderList.get(0).getHotelAddress(), commentableOrderList.get(0).getOrderID());
			System.out.println("2号订单详情展开成功，其订单评价状态为" + orderPO_3.isCommented());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("网络通信故障");
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
		try {
			System.out.println("正在获取该客户在该酒店所有订单的列表");
			ArrayList<OrderPO> allOrderList = orderDAO.getCommentableOrders(1);
			OrderPO orderPO_3 = orderDAO.getSingleOrder(allOrderList.get(0).getHotelAddress(), allOrderList.get(0).getOrderID());
			System.out.println("3号订单详情展开成功，其订单评价状态为" + orderPO_3.isCommented());
			
			System.out.println("判断该客户是否预定过地址为'江苏省南京市栖霞区仙林大道163号'的酒店");
			if(orderDAO.isReserved(orderPO_3.getUserID(), "江苏省南京市栖霞区仙林大道163号")){
				System.out.println("该客户预定过地址为'江苏省南京市栖霞区仙林大道163号'的酒店");
			}else{
				System.out.println("该客户没有预定过地址为'江苏省南京市栖霞区仙林大道163号'的酒店");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("网络通信故障");
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------");
		try {
			System.out.println("正在获取该订单号对应的订单详情");
			OrderPO orderPO_4 = orderDAO.getSingleOrder("江苏省南京市栖霞区仙林大道163号","0001000100010001");
			System.out.println("更改其状态为已执行");
			orderPO_4.setOrderState(OrderState.DONE_ORDER);
			orderDAO.update(orderPO_4);
			System.out.println("订单状态已更新");
			System.out.println("删除该订单");
			orderDAO.delete(orderPO_4);
			System.out.println("订单已删除");
			System.out.println("重新插入该订单");
			orderDAO.insert(orderPO_4);
			System.out.println("订单已插入");
			orderDAO.finish();
			System.out.println("结束对数据库的引用");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("网络通信故障");
			e.printStackTrace();
		}
		
	}
}
