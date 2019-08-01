package june1;

import java.util.HashMap;

public class RabbitsInForest {

	public static void main(String[] args) {
		//int[] answers = {1, 1, 2};
		int[] answers = {10, 10, 10};
		
		System.out.println(numRabbits(answers));
	}
	
	private static int numRabbits(int[] answers) {
		// no answers therefore no rabbits
        if(answers.length == 0){
        	return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        
        for(int i = 0; i < answers.length; i++){
        	int ans = answers[i];
        	
        	if(ans == 0){
        		sum += 1;  // only 1 rabbit has this color
        		continue;
        	}
        	
        	if(map.containsKey(ans) == false){ // this answer not accounted before
        		map.put(ans, 0);
        		sum += (ans + 1);  // if ans = 10, then 11 rabbits have this color
        		
        	} else {
        		
        		map.put(ans, map.get(ans) + 1);
        		
        		if(map.get(ans) == ans){
        			map.remove(ans);
        		}	
        	}
        }
        
        return sum;
    }

}
