package mystack;

public class Backspace_String_Compare {
	public static boolean backspaceCompare(String S, String T) {

		 int i=S.length()-1;
	        int j=T.length()-1;
	        int BackspaceS=0;
	        int BackspaceT=0;
	        while(i>=0 || j>=0){
	            while(i>=0){
	                if(S.charAt(i)=='#'){
	                    BackspaceS++;
	                    i--;
	                }else if(BackspaceS>0){
	                    BackspaceS--;
	                    i--;
	                }else
	                break;
	            }
	             while(j>=0){
	                if(T.charAt(j)=='#'){
	                    BackspaceT++;
	                    j--;
	                }else if(BackspaceT>0){
	                    BackspaceT--;
	                    j--;
	                }else
	                break;
	            }
	            if(i>=0 != j>=0){
	                return false;
	            }
	            if(i>=0 && j>=0 && S.charAt(i)!=T.charAt(j)){
	                return false;
	            }
	            i--;
	            j--;
	            
	        }
	        return true;
	    }
	public static void main(String[] args) {
	   String s="ab#c#d";
	   String t="ac#e#d";
	   System.out.println(backspaceCompare(s,t));
	}

}
