package interview.geometry;

public class Orientation {
	public static void main(String[] args) {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(4, 4);
		
		// test case 1
//		Point p3 = new Point(4, 5);
		
		// test case 2
//		Point p3 = new Point(5, 4);
		
		// test case 3
		Point p3 = new Point(5, 5);
		
		int orientation = getOrientation(p1, p2, p3);
		System.out.println(orientation == 0? "collinear": orientation > 0? "clockwise": "anticlockwise");
	}
	
	// -ve if anti, 0 if collinear, +ve if clockwise
	public static int getOrientation(Point p1, Point p2, Point p3){
		int val = (p2.y - p1.y) * (p3.x - p1.x) - (p3.y - p1.y) * (p2.x - p1.x);
		return val == 0? 0: val > 0? 1: -1;
	}
}
