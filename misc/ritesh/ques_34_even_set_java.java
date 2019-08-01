package pepques;

public class ques_34_even_set_java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static int evenset(int[] a,int n){
	  long totalset =(long)Math.pow(2, n); 
      int c=0; 
     for(int i = 0; i < totalset; i++) 
     {   int sum=0;
         for(int j = 0; j < n; j++) 
         { 
             if((i & (1 << j)) > 0)
             sum+=a[j];
                
         } 
         if(sum%2==0)
         {
           
             c++;
         }
     } 
     return c-1;
}
}
