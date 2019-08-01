package aNs1;

import java.util.ArrayList;
import java.util.HashMap;

public class design_log_storage_system {

	public static void main(String[] args) {
		
		logSystem obj=new logSystem();
		obj.put(1, "2017:01:01:23:59:59");
		obj.put(2, "2017:01:01:22:59:59");
		obj.put(3, "2016:01:01:00:00:00");
		System.out.println(obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year")); 
	}

	public static class logSystem {
		public HashMap<String, Integer> tstamps = null;
		public HashMap<String, Integer> gradient = null;

		public logSystem() {

			tstamps = new HashMap<>();
			gradient = new HashMap<>();
			gradient.put("Year", 4);
			gradient.put("Month", 7);
			gradient.put("Day", 10);
			gradient.put("Hour", 13);
			gradient.put("Minute", 16);
			gradient.put("Second", 19);

		}

		public void put(int id, String timestamp) {
			if (timestamp == null) {
				return;
			}
			tstamps.put(timestamp, id);
		}

		public  ArrayList<Integer> retrieve(String s, String e, String gra) {
			ArrayList<Integer> res = new ArrayList<>();
			int idx = gradient.get(gra);
			for (String val : tstamps.keySet()) {
				if (val.substring(0, idx).compareTo(s.substring(0, idx)) >= 0
						&& val.substring(0, idx).compareTo(e.substring(0, idx)) <= 0) {
					res.add(tstamps.get(val));
				}
			}
			return res;
		}
	}
}
