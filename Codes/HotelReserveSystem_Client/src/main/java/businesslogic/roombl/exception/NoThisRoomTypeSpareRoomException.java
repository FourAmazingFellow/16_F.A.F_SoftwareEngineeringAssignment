package businesslogic.roombl.exception;

/**
 * 当没有这种房型的空房抛出该异常
 * @author 双
 * @version 
 * @see
 */
public class NoThisRoomTypeSpareRoomException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = -7706869496072977665L;

    public NoThisRoomTypeSpareRoomException(String message){
        super(message);
    }
}
