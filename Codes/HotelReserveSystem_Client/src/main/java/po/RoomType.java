package po;

/**
 * 房间类型的枚举类型
 * @author 双
 * @version 
 * @see
 */
public enum RoomType {
	SINGLE_ROOM,
	STANDARD_ROOM,
	TRIBLE_ROOM,
	KING_SIZE_ROOM;
    
    public static String enumToChinese(Enum<RoomType> roomType){
        if(roomType==null){
            return null;
        }
        if(roomType==RoomType.SINGLE_ROOM){
            return "单人间";
        }else if(roomType==RoomType.STANDARD_ROOM){
            return "标准间";
        }else if(roomType==RoomType.TRIBLE_ROOM){
            return "三人间";
        }else{
            return "大床房";
        }
    }
    
    public static Enum<RoomType> chineseToEnum(String roomTypeStr){
        if(roomTypeStr==null||roomTypeStr.isEmpty()){
            return null;
        }
        Enum<RoomType> roomType;
        if(roomTypeStr.equals("单人间")){
            roomType=RoomType.SINGLE_ROOM;
        }else if(roomTypeStr.equals("标准间")){
            roomType=RoomType.STANDARD_ROOM;
        }else if(roomTypeStr.equals("三人间")){
            roomType=RoomType.TRIBLE_ROOM;
        }else{
            roomType=RoomType.KING_SIZE_ROOM;
        }
        return roomType;
    }
}
