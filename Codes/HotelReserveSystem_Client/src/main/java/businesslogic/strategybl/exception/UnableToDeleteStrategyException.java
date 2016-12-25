package businesslogic.strategybl.exception;

/**
 * 当无法删除策略时抛出该异常
 * @author 双
 * @version 
 * @see
 */
public class UnableToDeleteStrategyException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = -251697882441831617L;

    public UnableToDeleteStrategyException(String message){
        super(message);
    }
}
