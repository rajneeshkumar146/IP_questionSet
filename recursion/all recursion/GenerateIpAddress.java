package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateIpAddress {
	public static ArrayList<String> genIp(String s) {
		ArrayList<String> list = new ArrayList<String>();
		if (s.length() > 12 || s.length() < 4) {
			return list;
		}
		ipaddress(s, 0, list, "");

		return list;
	}

	public static void ipaddress(String str, int n, ArrayList<String> list, String output) {
		if (str.length() == 0) {
			if (n == 4) {
				list.add(output.substring(0, output.length() - 1));

			}
			return;
		}
		if (n == 4 && str.length() > 0) {
			return;
		}
		if (str.charAt(0) == '0') {
			ipaddress(str.substring(1), n + 1, list, output + str.substring(0, 1) + ".");
			return;
		}
		ipaddress(str.substring(1), n + 1, list, output + str.substring(0, 1) + ".");
		if (str.length() > 1) {
			ipaddress(str.substring(2), n + 1, list, output + str.substring(0, 2) + ".");
		}
		if (str.length() > 2 && Integer.parseInt(str.substring(0, 3)) <= 255) {
			ipaddress(str.substring(3), n + 1, list, output + str.substring(0, 3) + ".");
		}
		return;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(genIp(str));

	}

}
