package june5;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

import javax.crypto.CipherInputStream;

public class minimum_number_of_refueling_stops {

	public static void main(String[] args) {

		int[][] stations = { { 50, 50 } };

		System.out.println(minRefuelStops(100, 50, stations));
	}

	public static int minRefuelStops(int target, int startFuel, int[][] stations) {

		int stationsUsed = 0;
		if (startFuel >= target) {
			return stationsUsed;
		}

		int currfuel = startFuel;
		int prev = 0;

		PriorityQueue<Integer> fuel = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < stations.length; i++) {
			if (currfuel >= target) {
				return stationsUsed;
			}
			currfuel -= (stations[i][0] - prev);
			target -= (stations[i][0] - prev);
			prev = stations[i][0];

			if (currfuel >= 0) {

			} else {
				while (currfuel < 0) {
					if (fuel.size() == 0) {
						return -1;
					}
					currfuel += fuel.poll();
					stationsUsed++;
				}
			}

			fuel.add(stations[i][1]);
		}
		target = target - currfuel;
		if (target == 0) {
			return stationsUsed;
		}
		currfuel = 0;
		while (currfuel>=target||fuel.size() > 0) {
			if (currfuel >= target) {
				return stationsUsed;
			}
			currfuel += fuel.poll();
			stationsUsed++;
		}

		return -1;

	}
}
