package june1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RahulAndVilla {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		
		while(T-- > 0){
			int n = scn.nextInt();  // no of doors
			int m = scn.nextInt();  // no of exit doors
			int k = scn.nextInt();  // no of operations
			
			HashSet<Integer> exitDoors = new HashSet<>();
			
			for(int i=0 ; i < m; i++){
				exitDoors.add(scn.nextInt());
			}
			
			int currDoor = 1;
			boolean exitFound = false;
			
			for(int i=0; i < k; i++){
				int door1 = scn.nextInt();
				int door2 = scn.nextInt();
				
				if(door1 == currDoor){
					currDoor = door2;
				} else if (door2 == currDoor){
					currDoor = door1;
				}
				
				if(exitFound == false && exitDoors.contains(currDoor) && currDoor != 1){
					exitFound = true;
					System.out.println(currDoor);
				}
			}
			if(exitFound == false){
				System.out.println(currDoor);
			}
	
		}
	}

}
