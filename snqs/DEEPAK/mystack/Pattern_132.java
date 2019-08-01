package mystack;
import java.util.*;

public class Pattern_132 {
	public static boolean find132pattern(int[] num) {
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < num.length - 1; j++) {
            mini = Math.min(mini, num[j]);
            for (int k = j + 1; k < num.length; k++) {
                if (num[k] < num[j] && mini < num[k])
                    return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
int arr[]={8,2,9,4,-2,6,9};
System.out.println(find132pattern(arr));
	}

}
