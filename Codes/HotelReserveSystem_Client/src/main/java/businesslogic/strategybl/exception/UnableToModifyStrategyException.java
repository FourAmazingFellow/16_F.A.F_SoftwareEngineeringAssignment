package businesslogic.strategybl.exception;

/**
 * 当无法修改策略时抛出该异常
 * @author 双
 * @version 
 * @see
 */
public class UnableToModifyStrategyException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 3602414230178071729L;

    public UnableToModifyStrategyException(String message){
        super(message);
    }
}
