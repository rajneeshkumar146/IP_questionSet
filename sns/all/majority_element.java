package pep_sns;

import java.util.HashMap;

public class majority_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
	     int[] arr = {3,1,3,3,2};
	     HashMap<Integer, Integer> map = new HashMap<>();
	     for(int i=0; i<n; i++){
	         if(map.containsKey(arr[i])){
	             map.put(arr[i], map.get(arr[i]) + 1);
	         }else{
	             map.put(arr[i], 1);
	         }
	     }
	     int majele = -1;
	     int majcount = arr.length/2;
	     for(int i=0; i<arr.length; i++){
	         if(map.containsKey(arr[i]) && map.get(arr[i]) > majcount){
	             majcount = map.get(arr[i]);
	             majele = arr[i];
	         }
	     }
	     System.out.println(majele);
	}

}
