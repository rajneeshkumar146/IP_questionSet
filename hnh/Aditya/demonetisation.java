package may31;

import java.util.Scanner;

public class demonetisation {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		
		int t=scn.nextInt();
		
		for(int tc=0;tc<t;tc++){
			String str=scn.next();
			String m=scn.next();
			String n=scn.next();
			int[] canprint=new int[str.length()];
			
			for(int i=0;i<str.length()-m.length()+1;i++){
				//get substring of length m
				String totest=str.substring(i, i+m.length());
				if(totest.compareTo(m)==0){
					for(int j=i;j<i+m.length();j++){
						canprint[j]++;
					}
				}
			}
			
			for(int i=0;i<str.length()-n.length()+1;i++){
				//get substring of length n
				String totest=str.substring(i, i+n.length());
				if(totest.compareTo(n)==0){
					for(int j=i;j<i+n.length();j++){
						canprint[j]++;
					}
				}
			}
			
			int printed=0;
			for(int i=0;i<canprint.length;i++){
				if(canprint[i]==0){
					System.out.print(str.charAt(i));
					printed++;
				}
			}
			
			if(printed==0){
				System.out.println(-1);
			}
			else{
			    System.out.println();
			}
		}
	}

}
