package june1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minimum_cost_to_hire_k_workers {

	public static class worker implements Comparable<worker> {
		public int minwage;
		public int quality;

		public worker(int quality, int minwage) {
			this.minwage = minwage;
			this.quality = quality;
		}
		
		@Override
		public int compareTo(worker o) {
			// TODO Auto-generated method stub
			return Double.compare(this.fraction(), o.fraction()); //compareto for double
		}
		

		public double fraction() {
			return (this.minwage * 1.0) / this.quality;
		}
	}

	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {

		worker[] workers = new worker[quality.length];

		for (int i = 0; i < wage.length; i++) {
			workers[i] = new worker(quality[i], wage[i]);
		}

		Arrays.sort(workers); // workers sorted on ratio,the worker with least
								// ratio is our captain (best of all worst
								// cases)

		double ans = 1e9;
		int sumq = 0;  //sum of quality
		
		PriorityQueue<Integer> pool = new PriorityQueue(); //maintain a pool of k best suited workers based on quality 
		
		for (worker worker : workers) {  // assigning potential captain
			pool.offer(-worker.quality);
			sumq += worker.quality;			//adding quality from sumq
			if (pool.size() > K)
				sumq += pool.poll();		//removing quality from sumq
			if (pool.size() == K)
				ans = Math.min(ans, sumq * worker.fraction());  //getting best captain
		}

		return ans;

	}
}
