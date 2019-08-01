package pep_misc;

public class score_after_flipping_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
		System.out.println(matrixScore(A));
	}
	
	public static int matrixScore(int[][] A) {
        for(int i=0; i<A.length; i++){
            if(A[i][0] == 0){
                fliprow(A, i);
            }
        }
        for(int j=1; j<A[0].length; j++){
            int cz= 0, co =0;
            for(int i=0; i<A.length; i++){
                if(A[i][j] == 0)
                    cz++;
                else
                    co++;
            }
            if(cz > co){
                flipcol(A, j);
            }
        }
        int sum = 0;
        for(int i=0; i<A.length; i++){
            String num = "";
            for(int j=0; j<A[0].length; j++){
                num += A[i][j];
            }
            sum += Integer.parseInt(num, 2);
        }
        return sum;
    }
    public static void fliprow(int[][] A, int r){
        for(int i=0; i<A[0].length; i++){
            if(A[r][i] == 0)
                A[r][i] = 1;
            else
                A[r][i] = 0;
        }
    } 
    public static void flipcol(int[][] A, int c){
        for(int i=0; i<A.length; i++){
            if(A[i][c] == 0)
                A[i][c] = 1;
            else
                A[i][c] = 0;
        }
    }

}
