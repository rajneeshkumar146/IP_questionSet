package hnh;

import java.util.HashMap;
import java.util.Scanner;

public class contains012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		for(int t=1;t<=test;t++){
			String s=scn.next();
		System.out.println(m(s));
		}
	}

	public static int m(String s) {
		int[] numbers = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - '0';
			if (num == 0) {
                  numbers[i]=-3;
			}else{
				numbers[i]=num;
			}
		}
	HashMap<Integer,Integer> vs=new HashMap<>();
	vs.put(numbers[0], 1);
	int sum=numbers[0];
	int res=0;
	for(int i=1;i<numbers.length;i++){
		sum+=numbers[i];
		if(vs.containsKey(sum)){
			res+=vs.get(sum);
			vs.put(sum, vs.get(sum)+1);
		}else{
			vs.put(sum, 1);
		}
		

	}
	if(vs.containsKey(0)){
		res+=vs.get(0);
	}
	
	return res;
	}
}
