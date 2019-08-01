package pep_sns;

public class max_intervals_overlap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 13 28 29 14 40 17 3 
			107 95 111 105 70 127 74 
			output -> 7 40
		 */
		int n = 5;
	     int[] start = {1, 2, 10, 5, 5};
	     int[] end = {4, 5, 12, 9, 12};
	     int maxstart = 0;
	     int maxend = 0;
	     for(int i = 0; i<n; i++){
	         if(start[i] > maxstart){
	             maxstart = start[i];
	         }
	         if(end[i] > maxend){
	             maxend = end[i];
	         }
	     }
	     int max = Math.max(maxstart, maxend);
	     int[] timings = new int[max + 2];
	     for(int i=0; i<n; i++){
	         timings[start[i]] += 1;
	         timings[end[i] + 1] -= 1;
	     }
	     int sum = 0;
	     int maxpeople = 0;
	     int maxidx = 0;
	     for(int i=1; i<timings.length; i++){
	         sum += timings[i];
	         if(sum > maxpeople){
	             maxpeople = sum;
	             maxidx = i;
	         }
	     }
	     System.out.println(maxpeople + " " + maxidx);

	}

}
