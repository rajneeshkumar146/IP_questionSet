package pep_sns;

import java.util.Arrays;

public class all_cells_distinct_order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] results = allCellsDistOrder(2, 2, 0, 1);
		for(int i=0; i<results.length; i++) {
			for(int j=0; j<results[0].length; j++) {
				System.out.print(results[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static class Pair implements Comparable<Pair>{
        int r;
        int c;
        int dist;
        Pair(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.dist = d;
        }
        @Override
        public int compareTo(Pair o){
            return this.dist - o.dist;
        }
    }
    public static int[][] allCellsDistOrder(int r, int c, int r0, int c0) {
        Pair[] pair = new Pair[r*c];
        int k = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int dist = Math.abs(i - r0) + Math.abs(j - c0);
                pair[k] = new Pair(i, j, dist);
                k++;
            }
        }
        Arrays.sort(pair);
        int[][] res = new int[r*c][2];
        for(int i=0; i<pair.length; i++){
            res[i][0] = pair[i].r;
            res[i][1] = pair[i].c;
        }
        return res;
    }

}
