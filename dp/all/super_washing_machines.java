package InternQuestDP;

import java.util.Scanner;

public class super_washing_machines {
	  public static int findMinMoves(int[] machines) {
	        int total = 0, target = 0, result = 0, n = machines.length;
	        for(int i=0;i<machines.length;i++){
	        	total+=machines[i];
	        }
	      
	        if (total % n != 0) return -1;
	        target = total / n;
	        
	        int[] move = new int[n];
	        for (int i = 0; i < n - 1; i++) {
	            if (machines[i] > target) {
	                move[i] += machines[i] - target;
	                machines[i + 1] += machines[i] - target;
	                machines[i] = target;
	                
	            }
	            else {
	                move[i + 1] = target - machines[i];
	                machines[i + 1] -= target - machines[i];
	                machines[i] = target;
	             
	            }
	        }
	        for(int i=0;i<move.length;i++){
	        	result=Math.max(result,move[i]);
	        }
	        return result;
	    }

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int machines[]={1,0,5};
		System.out.println(machines);
		

	}

}
