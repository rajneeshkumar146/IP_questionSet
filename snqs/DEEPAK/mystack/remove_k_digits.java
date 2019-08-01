package mystack;

public class remove_k_digits {
	 public static String removeKdigits(String num, int k) {
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<num.length();i++){
	            char currch=num.charAt(i);
	            while(k>0 && sb.length()>0 && sb.charAt(sb.length()-1)>currch){
	                sb.deleteCharAt(sb.length()-1);
	                k--;
	            }
	            sb.append(currch);
	        }
	            while(k-->0 && sb.length()>0){
	                sb.deleteCharAt(sb.length()-1);
	            }
	            while(sb.length()>0 && sb.charAt(0)=='0')
	                sb.deleteCharAt(0);
	            
	            if(sb.length()==0)
	                return "0";
	        return sb.toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="43672";
System.out.println(removeKdigits(s, 3));
	}

}
