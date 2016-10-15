package businesslogic.userbl;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public interface ClientCreditService {

    /**
     * 
     * @param ID
     * @return
     * @see
     */
    public int getCreditValue(long ID);
    
    /**
     * 
     * @param ID
     * @param num
     * @return
     * @see
     */
    public boolean changeCreditValue(long ID,int num);
}
