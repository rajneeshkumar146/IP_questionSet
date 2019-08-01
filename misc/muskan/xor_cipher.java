package pep_misc;

public class xor_cipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd";
		System.out.println(findXorCipher(s));
	}
	
	static String findXorCipher(String s) {
	     
	     if (s == null || s.length() == 0) {
	         return "";
	     }
	    int len = s.length();
	    String out = "" + s.charAt(len - 1);
	    for (int i = len - 1; i > len / 2; i--) {
	        int a = Integer.parseInt("" + s.charAt(i), 16);
	        int b = Integer.parseInt("" + s.charAt(i - 1), 16);
	        int hex = a^b;
	        out = Integer.toString(hex, 16) + out;
	    } 
	    
	    return out.toUpperCase();
	}

}
