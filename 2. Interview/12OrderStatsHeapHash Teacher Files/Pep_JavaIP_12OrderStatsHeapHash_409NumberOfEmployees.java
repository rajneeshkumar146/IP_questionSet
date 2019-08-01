package OrderStatsHeapHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_409NumberOfEmployees {

	

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();// This is integer for the number of employees.So, we have pair information for
								// k employeees.
		// Each pair information contains 2 strings i.e employee's name and its
		// manager's name.
		// k lines follow after that. Each pair contain 2 strings.
		//Key : employee, Value : Direct reporting manager
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.put(scn.next(), scn.next());
		}
		// here, I will create a reverse map, which stores which manager and all its
		// employees in an arraylist
		findCount(map);
		

	}

	private static void findCount(HashMap<String, String> map) {
		/**Reverse map
		 * Key : Manager
		 * Value : list of directly reporting employees
		 */
		HashMap<String, ArrayList<String>> counts = new HashMap<>();

		ArrayList<String> keys = new ArrayList<>(map.keySet());
		for (String emp : keys) {
			String manager = map.get(emp);
			if (!manager.equals(emp)) {
				if (counts.containsKey(manager)) {
					ArrayList<String> list = counts.get(manager);
					list.add(emp);
					counts.put(manager, list);
				} else {
					ArrayList<String> list = new ArrayList<>();
					list.add(emp);
					counts.put(manager, list);

				}

			}

		}
		/**
		 * Key : employee
		 * Value : Count of employess in hierarchy reporting to key
		 */
		HashMap<String, Integer> result = new HashMap<>();
		for (String emp : keys) {
			getfinalcount(emp, counts, result);
		}
		ArrayList<String> al=new ArrayList<>(result.keySet());
		for(String s : al) {
			System.out.println(s+" "+result.get(s));
		}
	}

	private static int getfinalcount(String emp, HashMap<String, ArrayList<String>> counts,
			HashMap<String, Integer> result) {

		int count = 0;
		// if emp is not direct reporting manager of any employee
		if (counts.containsKey(emp) == false) {
			result.put(emp, 0);
			return 0;
		}
		// if we have calculated count for this employee
		// then return it.
		if (result.containsKey(emp)) {
			count=result.get(emp);
		} else {
			// add 1 for direct reporting employees
			// and search for heirarchies
			count = counts.get(emp).size();
			// list of direct reporting employees
			ArrayList<String> al = counts.get(emp);
			for (int i = 0; i < al.size(); i++) {
				count += getfinalcount(al.get(i), counts, result);

			}
			result.put(emp, count);
		}
		return count;
	}

}

/*
 Test cases 
6
a c
b c
c f
d e
e f
f f
----------------
a 0
b 0
c 2
d 0
e 1
f 5

6
a c
b d
c f
d d
e f
f d
--------------
a 0
b 0
c 1
d 5
e 0
f 3

4
a c
b d
c d
d d
----------
a 0
b 0
c 1
d 3

 Source: https://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
 */
