package InternshipQuestionAs1;

public class Validate_IP_Address {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
	}

	public static String validIPAddress(String ip) {

		String[] ipv4 = ip.split("\\.", -1);
		String[] ipv6 = ip.split(":", -1);

		if (ipv4.length == 4) {
			for (String s : ipv4) {
				if (s.isEmpty())
					return "Neither";
				if (s.length() > 1 && (s.charAt(0) == '0' || s.charAt(0) == '-'))
					return "Neither";

				try {
					int decimal = Integer.parseInt(s);
					if (decimal < 0 || decimal > 255) {
						return "Neither";
					}
				} catch (NumberFormatException nfe) {
					return "Neither";
				}

			}
			return "IPv4";
		}

		if (ipv6.length == 8) {
			for (String s : ipv6) {
				if (s.length() > 4 || s.length() == 0) {
					return "Neither";
				}
				for (int i = 0; i < s.length(); i++) {
					char c = s.charAt(i);
					if (!Character.isDigit(c) && "abcdefABCDEF".indexOf(c) == -1) {
						return "Neither";
					}
				}
			}
			return "IPv6";
		}
		return "Neither";
	}
}
