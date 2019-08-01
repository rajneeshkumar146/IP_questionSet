package pep_misc;

public class check_if_an_integer_is_power_8_or_not {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 2097152;
	     double log = (Math.log(n)/Math.log(8));
	     System.out.println(log);
	     if(log - Math.floor(log) < 0.000001){
	         System.out.println("Yes");
	     }else{
	         System.out.println("No");
	     }
	}

}
