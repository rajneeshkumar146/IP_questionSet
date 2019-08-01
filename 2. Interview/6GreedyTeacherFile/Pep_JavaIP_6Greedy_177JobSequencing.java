package Greedy;

import java.util.Arrays;
import java.util.Scanner;

import Greedy.Pep_JavaIP_6Greedy_171JobSequencingProblem.Job;

public class Pep_JavaIP_6Greedy_177JobSequencing {
//Disjoint set DS : Initially there are max_deadline+1 disjoint sets
// parent of each set indicates the next greatest available slot
// Find : gives the next available available slot
// Union : If a job is given time t, then merges the sets t-1,t
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		Job[] jobs=new Job[scn.nextInt()];
		for(int i=0; i<jobs.length; i++) {
			jobs[i]=new Job(scn.next().charAt(0), scn.nextInt(), scn.nextInt());
		}

		int max_deadline=Integer.MIN_VALUE;
		for(int i=0; i<jobs.length; i++) {
			if(jobs[i].deadline>max_deadline) {
				max_deadline=jobs[i].deadline;
			}
		}
		// Initialize parents as itself, as Initially slots are empty
		// Ex: next greatest availableslot for 4 is 4, 3 is 3 and so on
		int[] parent=new int[max_deadline+1];
		for(int i=0; i<=max_deadline; i++) {
			parent[i]=i;
		}
		// on the basis of Profit
		Arrays.sort(jobs);

		for(int i=0; i<jobs.length; i++) {
			int availableslot=find(jobs[i].deadline,parent);
      // we have a free slot
			if(availableslot>0) {
				// Parent of t-1 needs to merged with t.
				merge(find(availableslot-1,parent),availableslot,parent);
				System.out.print(jobs[i].JobID+" ");
			}
		}


	}


	  // Path Compression
    static int find(int s, int[] parent)
    {
        /* Make the parent of the nodes in the path
           from u--> parent[u] point to parent[u] */
        if (s == parent[s])
            return s;
        return parent[s] = find(parent[s], parent);
    }

    // Makes u as parent of v.
		//If a slot t is filled then this function is called with
		// (t-1,t)--> t-1 is made parent of t.
    static void merge(int u, int v, int[] parent)
    {
        //update the greatest available
        //free slot to u
        parent[v] = u;
    }

    static class Job implements Comparable<Job>{
		char JobID;
		int deadline;
		int Profit;

		public Job(char JobID, int deadline, int profit) {
			this.JobID=JobID;
			this.deadline=deadline;
			this.Profit=profit;
		}

		@Override
		public int compareTo(Job o) {
			//Since I want to sort them in decreasing order of profit, so
			//update the definition accordingly
			return o.Profit-this.Profit;
			//Arrays.sort() always puts smaller thing ahead.
			// I have changed the definition, now even if o.profit is smaller, it will think that answer is for this.profit
			//and keep it ahead and thus it will sort in increasing order.
		}


	}
}

/*Test Cases:

	4
	a 4 20
	b 1 10
	c 1 40
	d 1 30
	------------
	c a

	5
	a 2 100
	b 1 19
	c 2 27
	d 1 25
	e 3 15
	------------------
	a c e

	Source: https://www.geeksforgeeks.org/job-sequencing-using-disjoint-set-union/

	*/
