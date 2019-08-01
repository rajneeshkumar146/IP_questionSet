package hnh;

import java.util.HashMap;
import java.util.Scanner;

public class substringcontainingequal012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		for(int t=1;t<=test;t++){
			String s=scn.next();
		System.out.println(result(s));
		}
	}
public static int result(String s){
	HashMap<Integer,Integer> map=new HashMap();
	int count0=0;
	int count1=0;
	int count2=0;
	int res=0;
	map.put(0^0, 1);
	for(int i=0;i<s.length();i++){
	int num=s.charAt(i)-'0';
	if(num==0){
		count0++;
	}else if(num==1){
		count1++;
	}else{
		count2++;
	}
	int num1=count0-count1;
	int num2=count0-count2;
	int val=(num1*(0x1f1f1f1f))^num2;
	if(map.containsKey(val)){
		res+=map.get(val);
	}
	if(map.containsKey(val)){
		map.put(val,map.get(val)+1);
	}else{
		map.put(val, 1);
	}
	}
	return res;
}
}
