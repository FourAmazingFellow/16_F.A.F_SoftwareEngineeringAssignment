package presentation.roomui.CheckOut.model;

import java.util.ArrayList;
import java.util.List;

import vo.CheckOutVO;
import vo.RoomVO;


public class CheckOutListWrapper {

    private List<CheckOut> checkOutList;
    
    public List<CheckOut> getCheckOutList(){
        return checkOutList;
    }
    
    //把checkOutVO转化成Checkout模型类
    private CheckOut checkInVOToModel(CheckOutVO checkOutVO){
        return new CheckOut(checkOutVO.roomType, checkOutVO.roomNum, checkOutVO.actDepartTime);
    }
    
    public void setCheckOutList(ArrayList<RoomVO> checkOutList){
        checkOutList.clear();
        for(RoomVO roomVO: checkOutList){
            CheckOutVO checkOutVO=(CheckOutVO)roomVO;
            this.checkOutList.add(checkInVOToModel(checkOutVO));
        }
    }
    
    
}
