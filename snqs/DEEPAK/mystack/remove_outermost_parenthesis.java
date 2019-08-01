package mystack;

public class remove_outermost_parenthesis {
	public String removeOuterParentheses(String s) {
	      int count=0;
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='('){
	                if(++count>1)
	                    sb.append("(");
	            }else{
	                if(--count>0){
	                    sb.append(")");
	                }
	            }
	        }
	        return sb.toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
