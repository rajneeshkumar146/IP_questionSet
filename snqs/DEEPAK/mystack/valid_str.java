package mystack;

public class valid_str {
	 public static boolean isValid(String S) {
	        int clen = S.length();
	        String str = S;
	        while(clen != 0){
	            str = str.replace("abc", "");
	            int nlen = str.length();
	            
	            if(nlen < clen){
	                clen = nlen;
	                continue;
	            }
	            if(nlen == clen && nlen != 0)
	                return false;
	        }     
	        return true;
	    }
	public static void main(String[] args) {
String s="abcabcd";
System.out.println(isValid(s));
	}

}
