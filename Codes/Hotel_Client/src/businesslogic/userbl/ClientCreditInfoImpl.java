package businesslogic.userbl;


public class ClientCreditInfoImpl implements ClientCreditInfo{

    @Override
    public int getCreditValue(String userID) {
        return 0;
    }

    @Override
    public boolean changeCreditValue(String userID, int num) {
        return false;
    }

}
