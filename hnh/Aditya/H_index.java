package may29;

import java.util.Arrays;
import java.util.Collections;

public class H_index {
	public int hIndex(int[] citations) {
			Arrays.sort(citations);
			
			int paperssofar=0;
			int hindex=0;
			for(int papercitations:citations){
				
				paperssofar++;
				if(paperssofar>=papercitations){
					if(papercitations==0){
						continue;
					}
					hindex=paperssofar;
				}
			}
			
			return hindex;
	}
}
