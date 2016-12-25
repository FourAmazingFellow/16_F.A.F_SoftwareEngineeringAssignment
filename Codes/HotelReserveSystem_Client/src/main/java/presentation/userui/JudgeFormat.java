package presentation.userui;

/**
 * 用于判断各种格式是否正确的方法类
 * 
 * @author sparkler
 * @version
 * @see
 */
public class JudgeFormat {
	// 判断是否是字母数字或中文
	public boolean isLetterDigitOrChinese(String str) {
		String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
		return str.matches(regex);
	}

	// 判断是否是数字
	public boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// 判断是否是字母或数字
	public boolean isLetterOrDigit(String str) {
		String regex = "^[a-z0-9A-Z]+$";
		return str.matches(regex);
	}

	// 判断是否是大于等于零的数
	public boolean isNumberPositive(int num) {
		if (num >= 0)
			return true;
		else
			return false;
	}

	// 得到一个string的长度
	public int getStringLength(String str) {
		return str.length();
	}
}
