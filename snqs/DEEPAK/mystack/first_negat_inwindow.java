package mystack;
import java.util.*;
public class first_negat_inwindow {

	public static void main(String[] args) {
		 Scanner s=new Scanner(System.in);
		 int t=s.nextInt();
		 while(t!=0){
		     int size=s.nextInt();
		     int[]arr=new int[size];
		     for(int i=0;i<size;i++){
		         arr[i]=s.nextInt();
		     }
		     int k=s.nextInt();
		     
		     for(int i=0;i<=size-k;i++){
		         boolean flag=true;
		         for(int j=0;j<k;j++){
		            if(arr[i+j]<0){
		             System.out.print(arr[i+j]+" ");
	                  flag=false;	            
		             break;
		            }
		            
		            }
		            if(flag){
		                System.out.print("0 ");
		         }
		     }
		     
		     System.out.println();
		     t--;
		 }
		 }
	}


