package hnh;

import java.util.Arrays;

public class longestharmoniussubsequence {

	public static void main(String[] args) {

	}
public static int longestharmonius(int []arr){
	Arrays.sort(arr);
	int prevcount=1;
	int count=1;
	int result=0;
	for(int i=0;i<arr.length;i++){
		count=1;
		if(i>0&&arr[i]==arr[i-1]+1){
			while(i<arr.length-1&&arr[i]==arr[i+1]){
				count++;
				i++;
			}
			result=Math.max(count+prevcount,count);
		}else{
			while(i<arr.length-1&&arr[i]==arr[i+1]){
				count++;
				i++;
			}
			prevcount=count;
		}
	}
	return result;
}
}
