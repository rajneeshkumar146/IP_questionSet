package pep_misc;

public class collecting_trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5; //128 => ans 1
		int count = 0;
	     for(int i=31; i>=0; i--){
	         if(((1<<i) & n) == (1 << i)){
	             count++;
	         }
	     }
	     System.out.println(count);

	}

}
