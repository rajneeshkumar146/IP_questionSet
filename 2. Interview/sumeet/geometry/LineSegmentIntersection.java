package interview.geometry;

public class LineSegmentIntersection {
	public static void main(String[] args) {
//		// test case 1
//		Point p1 = new Point(0, 9);
//		Point q1 = new Point(5, -4);
//		Point p2 = new Point(1, 1);
//		Point q2 = new Point(16, 16);
//		
		// test case 2
//		Point p1 = new Point(-3, 1);
//		Point q1 = new Point(-1, 6);
//		Point p2 = new Point(1, -14);
//		Point q2 = new Point(6, -7);
		
		// test case 3
//		Point p1 = new Point(2, 8);
//		Point q1 = new Point(4, 5);
//		Point p2 = new Point(0, 1);
//		Point q2 = new Point(15, 16);

		// intersection
		System.out.println(getIntersection(p1, q1, p2, q2));
	}

	public static boolean getIntersection(Point p1, Point q1, Point p2, Point q2) {
		int o1 = Orientation.getOrientation(p1, q1, p2);
		int o2 = Orientation.getOrientation(p1, q1, q2);
		int o3 = Orientation.getOrientation(p2, q2, p1);
		int o4 = Orientation.getOrientation(p2, q2, q1);

		if (o1 != o2 && o3 != o4) {
			return true;
		}

		// when collinear
		if (o1 == 0 && onSegment(p1, q1, p2)) {
			return true;
		} else if (o2 == 0 && onSegment(p1, q1, q2)) {
			return true;
		} else if (o3 == 0 && onSegment(p2, q2, p1)) {
			return true;
		} else if (o4 == 0 && onSegment(p2, q2, q1)) {
			return true;
		}

		return false;
	}

	// check if p3 is on the segment
	public static boolean onSegment(Point p1, Point p2, Point p3) {
		int minx = Math.min(p1.x, p2.x);
		int maxx = Math.max(p1.x, p2.x);
		int miny = Math.min(p1.y, p2.y);
		int maxy = Math.max(p1.y, p2.y);

		return p3.x >= minx && p3.x <= maxx && p3.y >= miny && p3.y <= maxy;
	}
}
