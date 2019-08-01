package mystack;
import java.util.*;
public class first_non_repeating {
	public static void firstNon(char[] str){

        int arr[]=new int[26];
        Queue<Character> q=new LinkedList<>();

        for (int i=0; i<str.length;i++){

            char ch=str[i];

            arr[ch-'a']++;

            q.add(ch);

            while (!q.isEmpty()){

            	 if(arr[q.peek()-'a']>1){
                     q.remove();
                 }

                 else {
                     System.out.print(q.peek()+" ");
                     break;
                 }

             }

             if(q.isEmpty()){
                 System.out.print(-1+" ");
             }
         }

       
     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
char ch[]={'a','b','a'};
firstNon(ch);
	}

}
