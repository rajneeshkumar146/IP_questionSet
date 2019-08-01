package pep_misc;

public class primitive_typing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] chars = {{'a', 'b', 'c', 'd', 'e'},
				{'f', 'g', 'h', 'i', 'j'},
				{'k', 'l','m', 'n', 'o'},
				{'p', 'q', 'r', 's', 't'},
				{'u', 'v', 'w', 'x', 'y'},
				{'z'}};
		
		String s = "cozy";
		int cx = 0;
		int cy = 0;
	     int count = 0;
	     for(int i=0; i<s.length(); i++){
	    	 // this should be 'a' & 'b' -> some error in questions' test cases
	         int nx = (s.charAt(i) - 'A')/5;
	         int ny = (s.charAt(i) - 'A')%5;
	         while(cx > nx){
	             cx--;
	             count++;
	         }
	         while(cy > ny){
	             cy--;
	             count++;
	         }
	         while(cx < nx){
	             cx++;
	             count++;
	         }
	         while(cy < ny){
	             cy++;
	             count++;
	         }
	         count++;
	     }
	     System.out.println(count);

	}

}
