package mystack;
import java.util.*;
public class min_sum_formed_digit {
public static void minsum(int a[]){
	int n=a.length;
	Arrays.sort(a);
    int num1=0,num2=0;
    for(int i=0;i<n;i=i+2)
    {
        num1=num1*10+a[i];
    }
    for(int i=1;i<n;i=i+2)
    {
        num2=num2*10+a[i];
    }
    System.out.println(num1+num2);
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]={4,3,6,0};
minsum(arr);
	}

}
