package pep_misc;

public class predict_the_column {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] M = {{1,1,0},{1,1,0},{1,1,0}};
		System.out.println(columnWithMaxZeros(3, M));
	}
	
	public static int columnWithMaxZeros(int N, int[][] M){
	    int maxcount = 0;
	    int maxindxc = 0;
	    for(int j=0; j<N; j++){
	        int currcount = 0;
	        for(int i=0; i<N; i++){
	            if(M[i][j] == 0){
	                currcount++;
	            }
	        }
	        if(currcount > maxcount){
	            maxcount = currcount;
	            maxindxc = j;
	        }
	    }
	    return maxindxc;
	}

}
