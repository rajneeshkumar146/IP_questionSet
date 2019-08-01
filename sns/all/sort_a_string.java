package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class sort_a_string {

	public static void main (String[] args) {
		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		for(int t=0;t<test;t++){
		    int len=scn.nextInt();
		    String s=scn.next();
		    char[] str=s.toCharArray();
		    Arrays.sort(str);
		    System.out.println(str);
		}
	}
}
