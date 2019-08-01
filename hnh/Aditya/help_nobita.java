package may29;

import java.util.Scanner;

public class help_nobita {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		
		int t=1;
		
		for(int tc=0;tc<t;tc++){
			
			int[] alpha=new int[26];
			
			String s="gslfdvkfhgjfdds";
			
			for(char c:s.toCharArray()){
				alpha[c-'a']++;
			}
			
			int x=0;
			int y=0;
			for(int i=0;i<26;i++){
				if(alpha[i]!=0 && alpha[i]%2==0 && (i+1)%2==0){
					x++;
				}
				else if(alpha[i]%2==1 && (i+1)%2==1){
					y++;
				}
			}
			
			int val=x+y;
			
			if(val%2==0){
				System.out.println("EVEN");
			}
			else{
				System.out.println("ODD");
			}
			
			
		}

	}

}
