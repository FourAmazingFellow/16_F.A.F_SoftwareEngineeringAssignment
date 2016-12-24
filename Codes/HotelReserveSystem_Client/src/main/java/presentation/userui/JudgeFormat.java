package presentation.userui;

public class JudgeFormat {
	public boolean isLetterDigitOrChinese(String str) {
		String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
		return str.matches(regex);
	}

	public boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public boolean isLetterOrDigit(String str){
		String regex = "^[a-z0-9A-Z]+$";
		return str.matches(regex);
	}
	
	public boolean isNumberPositive(int num) {
		if (num >= 0)
			return true;
		else
			return false;
	}

	public int getStringLength(String str) {
		return str.length();
	}
}
