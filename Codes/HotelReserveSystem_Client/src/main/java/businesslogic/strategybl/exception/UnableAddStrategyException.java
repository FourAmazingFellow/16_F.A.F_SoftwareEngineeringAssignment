package businesslogic.strategybl.exception;

/**
 * 当无法添加策略时抛出该异常
 * @author 双
 * @version 
 * @see
 */
public class UnableAddStrategyException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = -7188060698556986932L;

    public UnableAddStrategyException(String message){
        super(message);
    }
}
