package SnS;

public class selection_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,80,9,1,65,3,87,-5};
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void selectionSort(int arr[])
	{
		int n = arr.length;
		for(int i=n-1; i>=0; i--)
		{
			int j = select(arr, i);
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}	
	}
	
	public static int  select(int arr[], int i)
    {
        int idx=i;
	    for(int k=0;k<i;k++){
	        if(arr[k]>arr[idx]){
	            idx=k;
	        }
	    }
	    return idx;
    }

}
