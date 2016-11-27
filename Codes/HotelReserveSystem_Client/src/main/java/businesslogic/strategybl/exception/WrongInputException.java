package businesslogic.strategybl.exception;

public class WrongInputException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 4461623011933986222L;

    public WrongInputException(String message){
        super(message);
    }
}
