package pep_sns;

import java.util.Arrays;

public class reaching_the_heights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2,3,4,5};
		int n = arr.length;
		result(arr);
	}
	
	public static void result(int[] arr){
        if(arr.length==1)
        {
            System.out.println(arr[0]);
            return;
        }
            
        Arrays.sort(arr);
        
        int[] arr2 = new int[arr.length];
        
        int sum = 0;
        
        for(int i=0;i<arr2.length;i++){
            if(i%2==0)
            {
                arr2[i] = arr[arr2.length - i/2 - 1];
                sum+=arr2[i];
            }
            else{
                arr2[i] = arr[(i-1)/2];
                sum-=arr2[i];
            }
            
            if(i!=0 && sum<=0){
                System.out.println("Not Possible");
                return;
            }
        }
        
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        
    }

}
