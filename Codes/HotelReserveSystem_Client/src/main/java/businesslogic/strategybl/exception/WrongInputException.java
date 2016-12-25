package businesslogic.strategybl.exception;

/**
 * 当从界面层传来的信息内容有误时抛出该异常
 * @author 双
 * @version 
 * @see
 */
public class WrongInputException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 4461623011933986222L;

    public WrongInputException(String message){
        super(message);
    }
}
