package InternQuestionDP;

import java.util.Scanner;

public class Minimum_number_of_jumps {

	public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
		 int t = scn.nextInt();
		 while(t-->0){
		     int n = scn.nextInt();
		     int a[] = new int[n];
		     for(int i=0;i<a.length;i++){
		         a[i]=scn.nextInt();
		     }
		     System.out.println(mj(a));
		 }
		 }
		 public static Integer mj(int[] m) {
			int[] f = new int[m.length];

			for (int i = m.length - 1; i >= 0; i--) {
				if (i == m.length - 1) {
					f[i] = 0;
				} else if (m[i] == 0) {
					f[i] = -1;
				} else {
					int min = Integer.MAX_VALUE;
					for (int j = 1; j <= m[i] && i + j < m.length; j++) {
						if (f[i + j] != -1) {
							min = Math.min(min, f[i + j]);
						}
					}
					if (min == Integer.MAX_VALUE) {
						f[i] = -1;
					} else
						f[i] = min + 1;
				}
			}
			return f[0];
		}
	}