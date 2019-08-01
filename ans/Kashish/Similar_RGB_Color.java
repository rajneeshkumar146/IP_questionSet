package InternQuestAS1;

import java.util.Scanner;

public class Similar_RGB_Color {
	

	public static String similarRGB(String color) {
		String redix = "0123456789abcdef";
		 color = color.substring(1);
	        char []ans = {0,0,0};
	        String ret="";
	        int minVal=Integer.MIN_VALUE;
	        for (int i = 0; i < redix.length(); i++) {
	            ans[0] = redix.charAt(i);
	            for (int j = 0; j < redix.length(); j++) {
	                ans[1] = redix.charAt(j);
	                for (int k = 0; k < redix.length(); k++) {
	                    ans[2] = redix.charAt(k);
	                    String tmp = "";
	                    for (char ch : ans) {
	                        tmp+=ch;
	                        tmp+=ch;
	                    }
	                    int val = calculate(tmp, color);
	                    if (minVal < val) {
	                        minVal = val;
	                        ret = tmp;
	                    }
	                }
	            }
	        }
	        return "#" + ret;
	    }

	

	private static int calculate(String psf, String color) {
		int similarity = 0;
		for (int i = 0; i < color.length(); i = i + 2) {
			int v1 = Integer.parseInt(psf.substring(i, i + 2), 16);
			int v2 = Integer.parseInt(color.substring(i, i + 2), 16);
			similarity -=(v2 - v1) * (v2 - v1);
		}

		return similarity;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = "#09f166";
		System.out.println(similarRGB(s));

	}

}
