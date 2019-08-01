package may30;

import java.util.HashMap;

public class prison_cells_after_n_days {
	public int[] prisonAfterNDays(int[] cells, int N) {

		int state = 0;
		for (int i = 0; i < 8; ++i) {
			if (cells[i] > 0)
				state ^= 1 << i;
		}

		HashMap<Integer, Integer> statemap = new HashMap<>();

		while (N > 0) {

			// is same state is obtained,fast forward time till the days left
			// are less than the time period of the found state
			if (statemap.containsKey(state)) {
				N %= statemap.get(state) - N;
			}
			statemap.put(state, N);

			if (N >= 1) {
				N--;
				state = change_state(state);
			}
		}

		int[] ret=new int[8];
		for(int i=0;i<8;i++){
			if((state&(1<<i))!=0){
				ret[i]=1;
			}
		}
		
		return ret;
	}

	static int change_state(int state) {
		int newstate = 0;

		for (int i = 1; i < 7; i++) {
			if ((state>>(i-1) & 1) == (state>>(i+1) & 1) ){
				newstate |= 1 << (i);
			}
		}

		return newstate;
	}
}
