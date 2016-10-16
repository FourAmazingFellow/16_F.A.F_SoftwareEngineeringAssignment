package data_Driver;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;

public class UserDAO_Driver {
    public void driver(UserDAO userDAO){
        try {
            UserPO userPO = userDAO.getUserInfo(1111, UserType.Client);
            System.out.println("得到了" + userPO.getUserID() + "的信息");
        } catch (RemoteException e) {
            System.out.println("网络通信失败");
            e.printStackTrace();
        }
        
        try {
            UserPO userPO = userDAO.queryCredit(1111);
            System.out.println("得到了" + userPO.getUserID() + "的信用值记录");
        } catch (RemoteException e) {
            System.out.println("网络通信失败");
            e.printStackTrace();
        }
        
        try {
            UserPO userPO = userDAO.getUserInfo(1111, UserType.Client);
            int creditValue = userDAO.getCreditValue(1111);
            System.out.println("得到了" + userPO.getUserID() + "的信用值"+creditValue);
        } catch (RemoteException e) {
            System.out.println("网络通信失败");
            e.printStackTrace();
        }
        
        
        try {
            UserPO userPO = new UserPO(1111, "qwe123", 11265768, UserType.Client);
            userDAO.insert(userPO);
            System.out.println("酒店信息更新成功！\n");
        } catch (RemoteException e) {
            System.out.println("网络通信失败");
            System.out.println("酒店信息更新失败！\n");
            e.printStackTrace();
        }
        
        try {
            UserPO userPO = userDAO.getUserInfo(1111, UserType.Client);
            userDAO.delete(userPO);
            System.out.println("插入酒店信息成功\n");
        } catch (RemoteException e) {
            System.out.println("网络通信失败");
            System.out.println("插入酒店信息失败\n");
            e.printStackTrace();
        }
        
        try {
            UserPO userPO = userDAO.getUserInfo(1111, UserType.Client);
            userDAO.update(userPO);
            System.out.println("初始化持久化数据存储成功！\n");
        } catch (RemoteException e) {
            System.out.println("网络通信失败");
            System.out.println("初始化持久化数据存储失败！\n");
            e.printStackTrace();
        }
        
        try {
            userDAO.finish();
            System.out.println("结束持久化数据存储成功！\n");
        } catch (RemoteException e) {
            System.out.println("网络通信失败");
            System.out.println("结束持久化数据存储失败！\n");
            e.printStackTrace();
        }
    }
}