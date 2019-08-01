package june1;

import java.util.HashMap;

public class max_point_on_a_line {
	//points class in input -> leet
	
	public int maxPoints(Point[] points) {
    	if (points==null) return 0;
    	if (points.length<=2) return points.length;
    	
    	HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<Integer,HashMap<Integer,Integer>>();
    	int result=0;
    	for (int i=0;i<points.length;i++){ 
    		map.clear();
    		int overlap=0,max=0;
    		for (int j=i+1;j<points.length;j++){
    			int x=points[j].x-points[i].x;
    			int y=points[j].y-points[i].y;
    			if (x==0&&y==0){
    				overlap++;
    				continue;
    			}
    			int gcd=generateGCD(x,y);
    			if (gcd!=0){
    				x/=gcd;
    				y/=gcd;
    			}
    			
    			if (map.containsKey(x)){
    				if (map.get(x).containsKey(y)){
    					map.get(x).put(y, map.get(x).get(y)+1);
    				}else{
    					map.get(x).put(y, 1);
    				}   					
    			}else{
    				HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
    				m.put(y, 1);
    				map.put(x, m);
    			}
    			max=Math.max(max, map.get(x).get(y));
    		}
    		result=Math.max(result, max+overlap+1);
    	}
    	return result;
    	
    	
    }
    private int generateGCD(int a,int b){

    	if (b==0) return a;
    	else return generateGCD(b,a%b);
    	
    }
}
