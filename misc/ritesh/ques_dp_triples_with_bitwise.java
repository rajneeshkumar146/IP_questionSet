package pepques;

import java.util.Arrays;

public class ques_dp_triples_with_bitwise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
	}

	public static int tripleand(int [] a)
	{
		int count = 0;
        Arrays.sort(a);
        for (int i = 0 ; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int tmp = a[i] & a[j];
                for (int k = j; k < a.length; k++) {
                    int re = tmp & a[k];
                    if (re == 0) {
                        if (i == j && j == k) {
                            count += 1;
                        } else if (i == j || i == k || j == k) {
                            count += 3;
                        } else {
                            count += 6;
                        }
                    }
                }
            }
        }
        
        return count;
	}
}
