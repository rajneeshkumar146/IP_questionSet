package dp;

import java.util.Scanner;

public class Maximum_sum_of_3_non_overlapping_subarrrays {

	public static void main(String[] args) {
Scanner scn=new Scanner(System.in);
int n=scn.nextInt();

int k=scn.nextInt();
int []arr=new int[n];
for(int i=0;i<n;i++){
	arr[i]=scn.nextInt();
}
int []art=maxsum(arr, k);
for(int val:art){
	System.out.println(val);
}
	}

	public static int[] maxsum(int[] arr, int k) {
		int[] w = new int[arr.length - k + 1];
		int i = 0;
		int sum = 0;
		while (i < k) {
			sum += arr[i];
			i++;
		}
		w[0] = sum;
		for (int l = k; l < arr.length; l++) {
			sum += arr[l] - arr[l - k];
			w[l - k + 1] = sum;
		}
		int maxval = 0;
		int goodindx = 0;
		int[] left = new int[w.length];
		int[] right = new int[w.length];
		for (int lt = 0; lt < w.length; lt++) {
			if (w[lt] > maxval) {
				maxval = w[lt];
				goodindx = lt;
			}

			left[lt] = goodindx;

		}
		maxval = 0;
		goodindx = w.length - 1;
		for (int rt = w.length - 1; rt >= 0; rt--) {
			if (w[rt] > maxval) {
				maxval = w[rt];
				goodindx = rt;
			}
			right[rt] = goodindx;
		}
		int []res=new int[3];
		int j=k;
		int max=0;
		while(j+k<w.length){
			int ll=left[j-k];
			int rl=right[j+k];
			if(res[0]==-1||w[ll]+w[j]+w[rl]>max){
				max=w[ll]+w[j]+w[rl];
				res[0]=ll;
				res[1]=j;
				res[2]=rl;
			}
			j++;
		}
		return res;
	}
}
