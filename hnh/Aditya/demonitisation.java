package hnh;

import java.util.Scanner;

public class demonitisation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scn=new Scanner(System.in);
int test=scn.nextInt();
for(int t=1;t<=test;t++){
	String s=scn.next();
	String a=scn.next();
	String b=scn.next();
	System.out.println(delete(s, a, b));
}
	}
public static String delete(String s,String a,String b){
	String t=s.replace(a,"");
	String l=t.replace(b,"");
	return l;
}
}
