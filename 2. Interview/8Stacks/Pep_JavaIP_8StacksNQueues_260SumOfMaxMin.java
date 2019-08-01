package Stacks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_260SumOfMaxMin {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int k=scn.nextInt();
		
		Deque G = new LinkedList<>();
		Deque S = new LinkedList<>();
		G.push(arr[0]);
		S.push(arr[0]);
		
		for(int i=1; i<k; i++) {
			
			while(G.peekLast()!=null) {
				int lastele=(int) G.peekLast();
				if(arr[i] > lastele){
					G.removeLast();
				}else {
					break;
				}
			}
			
			while(S.peekLast()!=null) {
				int lastele=(int) S.peekLast();
				if(arr[i] < lastele){
					S.removeLast();
				}else {
					break;
				}
			}
			G.add(arr[i]);
			S.add(arr[i]);
		}
		
		int max=(int)G.peek();
		int min=(int) S.peek();
		int sum=0;
		sum+=max+min;
		int lo=0;
		for(int i=k; i<arr.length; i++) {
			G.remove(arr[lo]);
			S.remove(arr[lo]);
			while(G.peekLast()!=null) {
				int lastele=(int) G.peekLast();
				if(arr[i] > lastele){
					G.removeLast();
				}else {
					break;
				}
			}
			
			while(S.peekLast()!=null) {
				int lastele=(int) S.peekLast();
				if(arr[i] < lastele){
					S.removeLast();
				}else {
					break;
				}
			}
			G.add(arr[i]);
			S.add(arr[i]);

			max=(int)G.peek();
			min=(int) S.peek();
			
			sum+=max+min;
			lo++;
		}
		System.out.println(sum);
	}


}

/*
7
2 5 -1 7 -3 -1 -2
4
--------------------------
18


7
12 1 78 90 57 89 56
3
-------------------
609


6
10 54 -1 20 30 40
3
-------------------
195

Source: https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/

*/

