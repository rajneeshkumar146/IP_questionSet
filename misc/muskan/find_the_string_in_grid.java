package pep_misc;

public class find_the_string_in_grid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] words = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
				{ 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
				{ 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		String x = "GEEKS";
		boolean flag = false;
	     for(int i=0; i<words.length; i++){
	         for(int j=0; j<words[0].length; j++){
	             if(check(words, x, i, j)){
	                 System.out.print(i + " " + j + ", ");
	                 flag = true;
	             }
	         }
	     }
	     if(flag == false){
	         System.out.println("-1");
	     }else{
	         System.out.println();
	     }
	}
	public static boolean check(char[][] arr, String pat, int i, int j){
	     int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
	     if(arr[i][j] != pat.charAt(0)){
	         return false;
	     }
	     for(int d = 0; d<dirs.length; d++){
	         int x = i + dirs[d][0];
	         int y = j + dirs[d][1];
	         int k;
   	     for(k=1; k<pat.length(); k++){
   	         if(x < 0 || y < 0 || x >= arr.length || y >= arr[0].length){
   	             break;
   	         }
   	         if(arr[x][y] != pat.charAt(k)){
   	             break;
   	         }
   	         x += dirs[d][0];
   	         y += dirs[d][1];
   	     }
   	     if(k == pat.length()){
   	         return true;
   	     }
	     }
	     return false;
	 }

}
