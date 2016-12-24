package data.databaseutility;
/**
 * 实现用户密码的加密与解密工作，用一个设定好的特定字符与密码里的每一个字符做异或，实现加密工作
 * 从数据库中取出时，再用相同的字符对密码的每一个字符做异或，实现解密工作
 * @author 原
 * @version
 * @see
 */
public class SecurityTransform {
	//做密码加密存储与解密工作的特定的异或字符
	private final static char securityCode = '*';
	
	/**
	 * 进行加密工作
	 * @param password 密码原来的数值
	 * @return 返回加密过后的密码
	 * @see
	 */
	public static String encrypt(String password) {
		String result = "";
		for(char i : password.toCharArray()) {
			result = result + (char)(i^securityCode);
		}
		return result;
	}
	
	/**
	 * 进行解密工作
	 * @param password 密码经过加密后的数值
	 * @return 密码解密后的原来的数值
	 * @see
	 */
	public static String decrypt(String password) {
		String result = "";
		for(char i : password.toCharArray()) {
			result = result + (char)(i^securityCode);
		}
		return result;
	}
}
