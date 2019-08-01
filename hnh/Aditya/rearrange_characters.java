package may31;

import java.util.PriorityQueue;
import java.util.Scanner;

public class rearrange_characters {

	static class pair implements Comparable<pair> {
		public int freq;
		public char c;

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return o.freq - this.freq;
		}

		public pair(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {
			String str = scn.next();
			int[] freqmap = new int[26];

			for (char c : str.toCharArray()) {
				freqmap[c - 'a']++;
			}
			
			PriorityQueue<pair> pq=new PriorityQueue<>();

			for (int i = 0; i < freqmap.length; i++) {
				if (freqmap[i] > 0) {
					pair p = new pair((char)('a'+i),freqmap[i]);
					pq.add(p);
				}
			}
			
			
			pair prev=null;
			int count=0;
			while(pq.size()!=0){
				pair p=pq.poll();
				
				count++;
				
				p.freq--;
				if(prev!=null && prev.freq>0){
					pq.add(prev);
				}
				
				prev=p;
			}
			
			if(count==str.length()){
				System.out.println(1);
			}
			else{
				System.out.println(0);
			}
			
		}
	}
}
