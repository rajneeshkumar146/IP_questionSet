package june2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Employee_importance {
	static class Employee {

	}

	 static HashMap<Integer, Employee> map = new HashMap<>();

		public int getImportance(List<Employee> employees, int id) {

			for (Employee emp : employees) {
				map.put(emp.id, emp);
			}

			return dfs(employees, id);
			
		}

		

		public static int dfs(List<Employee> employees, int rootid) {
			
	        Employee rootemp=map.get(rootid);
	        int ans=rootemp.importance;
	        
			for (int employeeid : rootemp.subordinates) {
				ans+=dfs(employees, employeeid);
			}
			return ans;
		}
}
