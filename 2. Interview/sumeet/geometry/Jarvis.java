package interview.geometry;

import java.util.ArrayList;

public class Jarvis {

	public static void main(String[] args) {
		// test case 1
//		Point[] points = new Point[10];
//		points[0] = new Point(0, 0);
//		points[1] = new Point(1, 2);
//		points[2] = new Point(3, 5);
//		points[3] = new Point(2, 4);
//		points[4] = new Point(0, 3);
//		points[5] = new Point(3, 0);
//		points[6] = new Point(4, 1);
//		points[7] = new Point(2, 3);
//		points[8] = new Point(3, 4);
//		points[9] = new Point(1, 0);
		
		// test case 2
//		Point[] points = new Point[10];
//		points[0] = new Point(-1, -1);
//		points[1] = new Point(0, 8);
//		points[2] = new Point(1, 3);
//		points[3] = new Point(0, 1);
//		points[4] = new Point(8, 0);
//		points[5] = new Point(-1, 1);
//		points[6] = new Point(-2, -1);
//		points[7] = new Point(0, -8);
//		points[8] = new Point(7, 0);
//		points[9] = new Point(-8, 0);
		
		// test case 3
//		Point[] points = new Point[10];
//		points[0] = new Point(0, 15);
//		points[1] = new Point(10, 0);
//		points[2] = new Point(3, -1);
//		points[3] = new Point(8, -8);
//		points[4] = new Point(-1, -1);
//		points[5] = new Point(3, 0);
//		points[6] = new Point(-8, -10);
//		points[7] = new Point(4, 2);
//		points[8] = new Point(0, 8);
//		points[9] = new Point(-9, 0);
		
		System.out.println(convexHull(points));
	}
	
	private static ArrayList<Point> convexHull(Point[] points){
		ArrayList<Point> hull = new ArrayList<>();
		
		// left most
		int li = 0;
		for(int i = 1; i < points.length; i++){
			if(points[i].x < points[li].x){
				li = i;
			}
		}
		
		// prev - curr game
		int prev = li;
		int curr = -1;
		while(curr != li){
			hull.add(points[prev]);
			curr = (prev + 1) % points.length;
			
			// curr is leftmost for prev
			for(int i = 0; i < points.length; i++){
				if(Orientation.getOrientation(points[prev], points[curr], points[i]) < 0){
					curr = i;
				}
			}
			
			prev = curr;
		}
		
		return hull;
	}

}
