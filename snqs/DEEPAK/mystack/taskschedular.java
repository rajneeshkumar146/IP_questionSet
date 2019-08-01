package mystack;

import java.util.Arrays;

public class taskschedular {

	
	public static int mininterval(char[] tasks,int n){
		int[] freq=new int[26];
		for(char c:tasks){
			freq[c-'A']++;
		}
		Arrays.sort(freq);
		int time=0;
		while(freq[25]>0){
			int i=0;
			while(i<=n){
				if(freq[25]==0){
					break;
				}
				if(25-i>=0 && freq[25-i]>0){
					freq[25-i]--;
				}
				time++;
				i++;
			}
			Arrays.sort(freq);
		}
		return time;
	}
	public static void main(String[] args) {
char tasks[]={'A','A','A','B','B','B'};
System.out.println(mininterval(tasks, 2));
		
	}

}
