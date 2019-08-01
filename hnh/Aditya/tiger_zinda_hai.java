package may28;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class tiger_zinda_hai {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t=scn.nextInt();
		
		for (int tc = 0; tc < t; tc++) {
			int n = scn.nextInt();

			int[] tabs=new int[10001];
			int count = 0;

			for (int i = 0; i < n; i++) {
				String s = scn.next();
				if (s.compareTo("END") == 0) {
					tabs=new int[10001];
					count = 0;
				}
				else{
					int tabno=Integer.parseInt(s);
					if(tabs[tabno]==1){
						count--;
						tabs[tabno]=0;
					}
					else{
						count++;
						tabs[tabno]=1;
					}
				}
				 
			}
			
			System.out.println(count);
		}

	}

}
