package interview.genericTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10genericTree_309LongestPathUndirectedTree {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		int[][] arr = new int[n][n];
		int edges = scn.nextInt();
		
		for(int i = 0; i < edges; i++){
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();
			arr[v1][v2] = 1;
			arr[v2][v1] = 1;
		}
		
		int ans = solve(arr);
		System.out.println(ans);
	}
	
	private static class Pair {
		int end;
		int dist;
		
		Pair(int end, int dist){
			this.end = end;
			this.dist = dist;
		}
	}
	
	private static int solve(int[][] arr){
		Pair first = bft(arr, 1);
		Pair second = bft(arr, first.end);
		return second.dist;
	}
	
	private static Pair bft(int[][] arr, int src){
		LinkedList<Pair> queue = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		
		queue.add(new Pair(src, 0));
		Pair farthest = null;
		while(queue.size() > 0){
			Pair rem = queue.removeFirst();
			
			farthest = rem;
			visited.add(rem.end);
			
			for(int nbr = 0; nbr < arr[rem.end].length; nbr++){
				if(arr[rem.end][nbr] != 0 && !visited.contains(nbr)){
					queue.addLast(new Pair(nbr, rem.dist + 1));
				}
			}
		}
		
		return farthest;
	}
}

/*
11
10
0 1
0 2
0 3
1 4
1 5
1 6
2 7
2 8
3 9
3 10
4
*/

//test case 2
/*
12
11
0 1
1 2
2 3
2 4
0 5
5 6 
5 7
5 8
5 9
6 10
6 11
6
*/
