package InternshipQuestionAs1;

public class Valid_Word_Abbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
	}

	public static boolean validWordAbbreviation(String word, String abbr) {
		int pos = 0;
		int i = 0;
		int num = 0;
		while (i < abbr.length()) {
			if (Character.isDigit(abbr.charAt(i))) {
				while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
					if (abbr.charAt(i) == '0' && num == 0) {
						return false;
					}
					if (num == 0) {
						num += Integer.parseInt(abbr.charAt(i) + "");
					} else {
						num = num * 10 + Integer.parseInt(abbr.charAt(i) + "");
					}
					i++;
				}
				pos += num;
				num = 0;

			} else {

				if (pos >= word.length()) {
					return false;
				}
				if (abbr.charAt(i) != word.charAt(pos)) {
					return false;
				}
				pos++;
				i++;
			}
		}
		return pos == word.length();
	}
}
