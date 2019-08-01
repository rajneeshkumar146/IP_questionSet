package SnS;

public class square_Root {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long x=18467;
		System.out.println(floorSqrt(x));
	}
	
	public static long floorSqrt(long x)
    {      
	    	return (long)Math.floor(Math.sqrt((double)x));
	 }

}
