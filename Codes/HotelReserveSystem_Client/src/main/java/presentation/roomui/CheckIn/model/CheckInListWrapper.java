package presentation.roomui.CheckIn.model;

import java.util.ArrayList;
import java.util.List;

import vo.CheckInVO;
import vo.RoomVO;

public class CheckInListWrapper {

    private List<CheckIn> checkInList;
    
    public List<CheckIn> getCheckInList(){
        return checkInList;
    }
    
    //把checkInVO转化成CheckIn模型类
    private CheckIn checkInVOToModel(CheckInVO checkInVO){
        return new CheckIn(checkInVO.roomType, checkInVO.roomNum, checkInVO.checkInTime, checkInVO.expDepartTime);
    }
   
    public void setCheckInList(ArrayList<RoomVO> checkInList){
        checkInList.clear();
        for(RoomVO roomVO: checkInList){
            CheckInVO checkInVO=(CheckInVO)roomVO;
            this.checkInList.add(checkInVOToModel(checkInVO));
        }
    }
}
