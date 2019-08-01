package may30;

import java.util.ArrayList;
import java.util.HashMap;

public class find_duplicate_file_in_system {
	public ArrayList<ArrayList<String>> findDuplicate(String[] paths) {
		
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		for (String path : paths) {
			
			String[] values = path.split(" ");
			
			for (int i = 1; i < values.length; i++) {
				
				String[] name_cont = values[i].split("\\(");	//creating
				name_cont[1] = name_cont[1].replace(")", "");	//content
				
				ArrayList<String> list = map.getOrDefault(name_cont[1], new ArrayList<String>());
				
				list.add(values[0] + "/" + name_cont[0]); //paths
				map.put(name_cont[1], list);
			
			}
		}
		
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key).size() > 1)
				res.add(map.get(key));
		}
		return res;
	}
}
