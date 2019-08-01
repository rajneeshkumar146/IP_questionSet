package mystack;
import java.util.*;
public class verify_preorder_serilization {
	public static boolean isValidSerialization(String preorder) {
        Stack<String> st=new Stack<>();
        String[] pre=preorder.split(",");
        for(int i=pre.length-1;i>=0;i--){
            if(pre[i]!="#"){
                if(st.size()<2)
                    return false;
                st.pop();
                st.pop();
            }
            st.push(pre[i]);
        }
        if(st.size()==1)
            return true;
        return false;
        
    }
	public static void main(String[] args) {
	String s=	"9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(isValidSerialization(s));
	}

}
