package mystack;

public class easy_string_compress {
	 public static String compress_string(String s){
	        String ans="";
	        int count=0;
	        if(s.length()==1){
	            ans="1"+s;
	        }
	        else{
	            for(int i=0;i<s.length();i++){
	                while(i+1<s.length() && (s.charAt(i)==s.charAt(i+1) || (Math.abs(s.charAt(i)-s.charAt(i+1))==32))){
	                   count++;
	                   i++;
	                }
	                ans+=(count+1)+""+s.charAt(i);
	                count=0;
	            }
	        }
	       ans= ans.toLowerCase();
	                    return ans;

	    }
	public static void main(String[] args) {
String s="aaABbB";
System.out.println(compress_string(s));
	}

}
