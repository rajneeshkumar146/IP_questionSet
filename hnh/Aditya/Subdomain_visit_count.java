package may28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Subdomain_visit_count {

	public List<String> subdomainVisits(String[] cpdomains) {
		// Map<String, Integer> counts = new HashMap();

		// int count = Integer.valueOf(cpinfo[0]);
		//

		// }

		HashMap<String, Integer> domainMap = new HashMap<>();

		for (String eachDomain : cpdomains) {
			String[] completeLine = eachDomain.split("\\s+"); // splits string
																// into parts
																// based on
																// white spaces

			String[] actualNames = completeLine[1].split("\\."); // split
																	// strings
																	// into
																	// parts
																	// based on
																	// '.'

			int count = Integer.valueOf(completeLine[0]);
			String cur = "";

			for (int i = actualNames.length - 1; i >= 0; --i) {
				cur = actualNames[i] + (i < actualNames.length - 1 ? "." : "") + cur;

				domainMap.put(cur, domainMap.getOrDefault(cur, 0) + count);
			}

		}

		List<String> ans = new ArrayList<>();
		for (String dom : domainMap.keySet())
			ans.add("" + domainMap.get(dom) + " " + dom);
		return ans;

	}
}
