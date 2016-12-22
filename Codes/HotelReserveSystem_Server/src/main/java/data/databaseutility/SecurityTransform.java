package data.databaseutility;
/**
 * 实现用户密码的加密与解密工作
 * @author 原
 * @version
 * @see
 */
public class SecurityTransform {
	private final static char securityCode = '*';
	
	public static String encrypt(String password) {
		String result = "";
		for(char i : password.toCharArray()) {
			result = result + (char)(i^securityCode);
		}
		return result;
	}
	
	public static String decrypt(String password) {
		String result = "";
		for(char i : password.toCharArray()) {
			result = result + (char)(i^securityCode);
		}
		return result;
	}
}
