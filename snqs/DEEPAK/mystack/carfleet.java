package mystack;
import java.util.*;
public class carfleet {
	private static class Car implements Comparable<Car>{
        int pos;
        double time;
        Car(int p,double t){
            pos=p;
            time=t;
        }
        
       
	

		@Override
		public int compareTo(Car o) {
			// TODO Auto-generated method stub
			if(this.pos<o.pos){
				return -1;
			}else if(this.pos==o.pos){
				return 0;
			}else{ 
				return 1;
			}
			
		}
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        Car[] cars=new Car[position.length];
        int ans=0;

        for(int i=0;i<position.length;i++){
            cars[i]=new Car(position[i],(double)(target-position[i])*1.0/speed[i]);
            }
            Arrays.sort(cars);
           
           int t=position.length-1;
           while(t>0){
        	  if(cars[t].time<cars[t-1].time){
        		 ans++;
        	  }
        	  else cars[t-1]=cars[t];
        		 
                  
        	  
        	  t--;
           }
        if(t==0)
            ans+=1;
        return ans;
        
    }
	public static void main(String[] args) {
		int target = 12;
		int []position = {10,8,0,5,3};
		int []speed = {2,4,1,1,3};
		System.out.println(carFleet(target, position, speed));
	}

}
