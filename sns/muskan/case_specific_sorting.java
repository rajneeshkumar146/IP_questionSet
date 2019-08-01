package pep_sns;

import java.util.Arrays;

public class case_specific_sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "defRTSersUXI";
		sort(s);

	}
	
	public static void sort(String s) {
		char[] smallarr;
		char[] capsarr;
		int ss = 0, cs = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				ss++;
			else
				cs++;
		}
		
		smallarr = new char[ss];
		capsarr = new char[cs];
		ss=0; cs = 0;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				smallarr[ss] = ch;
				ss++;
			}
			else{
				capsarr[cs] = ch;
				cs++;
			}
		}
		ss = 0;
		cs = 0;
		Arrays.sort(smallarr);
		Arrays.sort(capsarr);
		StringBuilder result = new StringBuilder("");
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				result.append(smallarr[ss]);
				ss++;
			}
			else{
				result.append(capsarr[cs]);
				cs++;
			}
		}
		System.out.println(result);
		
	}

}
