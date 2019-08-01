package Greedy;

import java.util.Scanner;

public class Pep_JavaIP_6Greedy_176MinimumTimeToFinishAllJobs {
// Similar to painters partition problem
//Apply binary search from 0 to max possible time
// We can improve upon lower bound by noticing that
// minimum time = max of jobs arrays
// So apply BSearch from max(Job) to max possible time
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();// Number of assignees available
		int T = scn.nextInt(); // Time taken by each assignee to complete a unit job
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();//each arr[i] stores the number of job units to be done
		}
		System.out.println(findMinTime(k, T, arr, arr.length));

	}

	// Utility function to get
	// maximum element in job[0..n-1]
	static int getMax(int arr[], int n) {
		int result = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > result)
				result = arr[i];
		return result;
	}

	// Returns true if it is possible to finish jobs[]
	// within given time 'time'
	static boolean isPossible(int time, int K, int job[], int n) {
		// cnt is count of current
		// assignees required for jobs
		int cnt = 1;

		// time assigned to current assignee
		int curr_time = 0;

		for (int i = 0; i < n;) {
			// If time assigned to current assignee
			// exceeds max, increment count of assignees.
			if (curr_time + job[i] > time) {
				curr_time = 0;
				cnt++;
			}

			// Else add time of job to current
			// time and move to next job.
			else {
				curr_time += job[i];
				i++;
			}
		}

		// Returns true if count
		// is smaller than k
		return (cnt <= K);
	}

	// Returns minimum time required to
	// finish given array of jobs
	// k --> number of assignees
	// T --> Time required by every assignee to finish 1 unit
	// m --> Number of jobs
	static int findMinTime(int K, int T, int job[], int n) {
		// Set start and end for binary search
		// end provides an upper limit on time
		int end = 0, start = 0;
		for (int i = 0; i < n; ++i)
			end += job[i];

		// Initialize answer
		int ans = end;

		// Find the job that takes maximum time
		int job_max = getMax(job, n);
		//we dont need to check for values below it
		start = job_max;

		// Do binary search for
		// minimum feasible time
		while (start <= end) {
			int mid = (start + end) / 2;

			// If it is possible to finish jobs in mid time
			if (isPossible(mid, K, job, n)) {
				// Update answer
				ans = Math.min(ans, mid);

				end = mid - 1;
			}

			else
				start = mid + 1;
		}

		return (ans * T);
	}

}

/*
Test cases:
2
5
3
4 5 10
----------
50





4
5
6
10 78 12 6 8
--------------
75

Source: https://www.geeksforgeeks.org/find-minimum-time-to-finish-all-jobs-with-given-constraints/
*/
