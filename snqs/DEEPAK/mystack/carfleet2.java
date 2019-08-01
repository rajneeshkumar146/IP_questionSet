package mystack;
import java.util.*;
public class carfleet2 {
	static class DistanceSpeed implements Comparable<DistanceSpeed> {
	    int distance;
	    int speed;
	    
	    DistanceSpeed(int distance, int speed) {
	        this.distance = distance;
	        this.speed = speed;
	    }
	    
	    @Override
	    public int compareTo(DistanceSpeed other) {
	        return distance - other.distance;
	    }
	    
	    
	    public static  int carFleet(int target, int[] position, int[] speed) {
	        if (position.length == 0) {
	            return 0;
	        }
	        
	        DistanceSpeed[] ds = new DistanceSpeed[position.length];
	        int count = 0;
	        double prevTime = Double.MIN_VALUE;
	        double currTime;
	        
	        for (int i = 0; i < position.length; i++) {
	            ds[i] = new DistanceSpeed(target - position[i], speed[i]);
	        }
	        Arrays.sort(ds);
	        for(int i=0;i<ds.length;i++){
	        	System.out.print(ds[i].distance+"- "+ds[i].speed);
	        }
	        for (int i = 0; i < position.length; i++) {
	            currTime = (double) ds[i].distance / ds[i].speed;
	            if (currTime > prevTime) {
	                count++;
	            }
	            prevTime = Math.max(prevTime, currTime);
	        }
	        
	        return count;
	    }
	
	public static void main(String[] args) {
		int target = 12;
		int[] position = {10,8,0,5,3};
		int[] speed = {2,4,1,1,3};
		System.out.println(carFleet(target, position, speed));
	}

}
}
