package interview.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_323CountTreeWithSameAncestorMatrix {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		System.out.println(solve(arr));
	}

	public static int solve(int[][] arr) {
		// key is number of descendants, value is list of nodes with that many
		// number of descendants
		HashMap<Integer, ArrayList<Integer>> dmap = new HashMap<>();
		// list of nodes available as children
		HashSet<Integer> availableChildren = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			availableChildren.add(i);

			int numDesc = 0;
			for (int j = 0; j < arr[i].length; j++) {
				numDesc += arr[i][j];
			}

			if (!dmap.containsKey(numDesc)) {
				dmap.put(numDesc, new ArrayList<>());
			}
			dmap.get(numDesc).add(i);
		}

		HashMap<Integer, Integer> countTrees = new HashMap<>();
		int max = 0;
		for (int numDesc = 0; numDesc < arr.length; numDesc++) {
			// if nobody has this many number of descendants
			if (dmap.containsKey(numDesc) == false) {
				continue;
			} 

			// processing all descendants for this count of descendants
			for (Integer node : dmap.get(numDesc)) {
				// if there are no descendants, there is a single way to create this subtree
				if (numDesc == 0) {
					countTrees.put(node, 1);
					continue;
				}

				int countWays = 2; // one for left and one for right
				for (int nodesDesc = 0; nodesDesc < arr[node].length; nodesDesc++) {
					// if it is a descendant and in the available children list, make
					// it a child
					if (arr[node][nodesDesc] == 1 && availableChildren.contains(nodesDesc)) {
						availableChildren.remove(nodesDesc);
						// use child's way of creation to calculate subtrees' ways of creation.
						countWays *= countTrees.get(nodesDesc);
					}
				}
				countTrees.put(node, countWays);

				if (countWays > max) {
					max = countWays;
				}
			}
		}
		return max;
	}
}
