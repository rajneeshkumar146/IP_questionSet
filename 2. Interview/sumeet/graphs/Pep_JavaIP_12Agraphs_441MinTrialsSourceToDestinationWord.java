package interview.graphs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_12Agraphs_441MinTrialsSourceToDestinationWord{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		String[] words = new String[Integer.parseInt(scn.nextLine())];
		for(int i = 0; i < words.length; i++){
			words[i] = scn.next();
		}
		
		String src = scn.next();
		String dest = scn.next();
		
		HashMap<String, HashSet<String>> graph = new HashMap<>();
		for(int i = 0; i < words.length; i++){
			String w1 = words[i];
			graph.put(w1, new HashSet<>());
			
			for(int j = 0; j < words.length; j++){
				String w2 = words[j];
				int ed = editDistance(w1, w2);
				
				if(ed == 1){
					graph.get(w1).add(w2);
				}
			}
		}
		
		System.out.println(bfs(src, dest, graph));
	}
	
	private static int bfs(String src, String dest, HashMap<String, HashSet<String>> graph) {
		int res = 0;
		
		LinkedList<String> queue = new LinkedList<>();
		
		queue.addLast(src);
		queue.addLast(null);
		
		HashSet<String> visited = new HashSet<>();
		while(queue.size() > 0){
			String rem = queue.removeFirst();
			
			if(rem == null){
				if(queue.size() > 0){
					res++;
					queue.add(null);
				} else {
					return -1;
				}
				continue;
			}
			
			if(visited.contains(rem)){
				continue;
			}
			visited.add(rem);
			
			if(rem.equals(dest)){
				return res;
			}
			
			for(String nbr: graph.get(rem)){
				if(visited.contains(nbr) == false){
					queue.add(nbr);
				}
			}
		}
		
		return -1;
	}

	private static int editDistance(String w1, String w2){
		int[][] dp = new int[w1.length() + 1][w2.length() + 1];
		
		int count = 0;
		for(int lrc = dp[0].length - 1; lrc >= 0; lrc--){
			dp[dp.length - 1][lrc] = count;
			count++;
		}
		
		count = 0;
		for(int lcr = dp.length - 1; lcr >= 0; lcr--){
			dp[lcr][dp[0].length - 1] = count;
			count++;
		}
		
		for(int i = dp.length - 2; i >= 0; i--){
			for(int j = dp[0].length - 2; j >= 0; j--){
				if(w1.charAt(i) == w2.charAt(j)){
					dp[i][j] = dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
				}
			}
		}
		
		return dp[0][0];
	}
	
	
}

//https://www.ideserve.co.in/learn/minimum-trials-to-reach-from-source-to-destination-word
//Test cases

//Test case 1
/*
7
BCCI AICC ICC CCI MCC MCA ACC
AICC MCA
3
*/

// Test case 2
/*
7
BCCI AICC ICC CCI MCC MCA ACC
MCA BCCI
-1
*/

//Test case 3
/*
7
BCCI AICC ICC CCI MCC MCA ACC
ACC MCA
2
*/
