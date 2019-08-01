package may30;

import java.util.ArrayList;
import java.util.HashSet;

public class powerful_Integer {
	 public ArrayList<Integer> powerfulIntegers(int x, int y, int bound) {
	        HashSet<Integer> seen = new HashSet<>();
	        int xi = 1;
	        for (int i = 0; i < 20 && xi <= bound; i++, xi *= x) {
	            int yj = 1;
	            for (int j = 0; j < 20 && xi + yj <= bound; j++, yj *= y)
	                if (xi + yj <= bound)
	                    seen.add(xi + yj);
	        }
	        return new ArrayList<>(seen);
	    }
}
