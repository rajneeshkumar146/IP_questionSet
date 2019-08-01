package may27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class top_k_frequent_elements {

	public static void main(String[] args) {
		
		int[] arr={1,4,3,3,6,6,6,6,6,7,7,7,7,55,6,5};
		System.out.println(topKFrequent(arr, 3));
		

	}
	
	public static class pair implements Comparable<pair>{
		public int val;
		public int count;
		
		public pair(int val,int count){
			this.val=val;
			this.count=count;
		}
		
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return o.count-this.count;
		}
		
		
	}
	
	public static ArrayList<Integer> topKFrequent(int[] nums, int k) {
        
		ArrayList<Integer> ans=new ArrayList<>();
		
		HashMap<Integer, Integer> map=new HashMap<>();
		PriorityQueue<pair> pq=new PriorityQueue<>();
		
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i], map.get(nums[i])+1 );
			}
			else{
				map.put(nums[i], 1 );
			}
		}
		
		for(int val:map.keySet()){
			pq.add(new pair(val,map.get(val)));
		}
		
		for(int i=0;i<k;i++){
			ans.add(pq.remove().val);
		}
		
		return ans;
		
		
		
		
    }

}
