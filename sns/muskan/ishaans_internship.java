package pep_sns;

public class ishaans_internship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 18; //30 ->>> output = 27
		int k = 3;
		int pos = 1;
	     while(n >= k){
	         n = n/k;
	         pos = pos*k;
	     }
	     System.out.println(pos);

	}

}
