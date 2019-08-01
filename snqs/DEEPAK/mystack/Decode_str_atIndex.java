package mystack;

public class Decode_str_atIndex {
	 public static String decodeAtIndex(String S, int K) {
	        long size=0;
	        int n=S.length();
	        for(int i=0;i<n;i++){
	            char ch=S.charAt(i);
	            if(Character.isDigit(ch))
	            {
	                size*=ch-'0';
	            }
	            else{
	                size++;
	            }
	        }
	         for (int i = n-1; i >= 0; --i) {
	            char c = S.charAt(i);
	             if(size!=0)
	            K %= size;
	            if (K == 0 && Character.isLetter(c))
	                return Character.toString(c);

	            if (Character.isDigit(c))
	                size /= c - '0';
	            else
	                size--;
	        }
	        return null;
	    }
	public static void main(String[] args) {
String s="pep2code3";
System.out.println(decodeAtIndex(s,10));
	}

}
