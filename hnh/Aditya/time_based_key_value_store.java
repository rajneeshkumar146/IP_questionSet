package may31;

import java.util.HashMap;
import java.util.TreeMap;

public class time_based_key_value_store {
	 /** Initialize your data structure here. */
	// custom class problem 
		//leet premium
	
	HashMap<String, TreeMap<Integer, String>> map;
	
    public time_based_key_value_store() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
        	map.get(key).put(timestamp, value);
        }
        else{
        	map.put(key, new TreeMap<>());
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
        	TreeMap<Integer, String> tmap=map.get(key);
        	Integer timestamp_prev=tmap.floorKey(timestamp);
        	if(timestamp_prev==null){
        		return "";
        	}
        	else{
        		return tmap.get(timestamp_prev);
        	}
        }
        else{
        	return "";
        }
    }
}
