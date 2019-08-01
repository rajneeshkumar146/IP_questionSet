package pep_sns;

import java.util.Arrays;

public class ishwar_and_his_proposals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] popularity = {6, 9, 1, 4, 8};
		Arrays.sort(popularity);
	     System.out.println(popularity[popularity.length - 2] + " " + popularity[1]);
	}

}

/*
for(int i=0; i<n; i++){
    popularity[i] = scn.nextInt();
    maxPop = Math.max(maxPop, popularity[i]);
    minPop = Math.min(minPop, popularity[i]);
}
int smin = Integer.MAX_VALUE;
int smax = Integer.MIN_VALUE;
for(int i=0; i<n; i++){
    if(popularity[i] > minPop && popularity[i] < smin && popularity[i] != minPop){
        smin = popularity[i];
    }
    if(popularity[i] < maxPop && popularity[i] > smin && popularity[i] != maxPop){
        smax = popularity[i];
    }
}
System.out.println(smax + " " + smin);
*/