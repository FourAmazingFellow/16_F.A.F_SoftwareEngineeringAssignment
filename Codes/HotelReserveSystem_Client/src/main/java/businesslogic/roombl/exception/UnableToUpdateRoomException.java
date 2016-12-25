package businesslogic.roombl.exception;

/**
 * 当无法更新空房时抛出该异常
 * @author 双
 * @version 
 * @see
 */
public class UnableToUpdateRoomException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = -2027117854465029202L;

    public UnableToUpdateRoomException(String message){
        super(message);
    }
}
