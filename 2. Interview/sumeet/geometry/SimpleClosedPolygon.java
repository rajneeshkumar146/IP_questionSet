package interview.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SimpleClosedPolygon {

	public static void main(String[] args) {
		// test case 1
		// Point[] points = new Point[10];
		// points[0] = new Point(0, 4);
		// points[1] = new Point(-2, -6);
		// points[2] = new Point(-1, -14);
		// points[3] = new Point(3, 14);
		// points[4] = new Point(15, 4);
		// points[5] = new Point(-12, -2);
		// points[6] = new Point(-1, -21);
		// points[7] = new Point(-10, 5);
		// points[8] = new Point(-1, -17);
		// points[9] = new Point(16, 1);

		// test case 2
		Point[] points = new Point[10];
		points[0] = new Point(0, 0);
		points[1] = new Point(3, 11);
		points[2] = new Point(-1, 15);
		points[3] = new Point(12, 4);
		points[4] = new Point(10, 6);
		points[5] = new Point(-2, 12);
		points[6] = new Point(-6, 5);
		points[7] = new Point(15, 1);
		points[8] = new Point(-7, 1);
		points[9] = new Point(14, 2);

		System.out.println(closedPolygon(points));
	}

	private static ArrayList<Point> closedPolygon(Point[] points) {
		// bottom most (when y are equal, then leftmost in bottom mosts)
		int bmi = 0;
		for (int i = 1; i < points.length; i++) {
			if (points[i].y < points[bmi].y) {
				bmi = i;
			} else if (points[i].y == points[bmi].y) {
				if (points[i].x < points[bmi].x) {
					bmi = i;
				}
			}
		}

		start = points[bmi];
		Arrays.sort(points, new PointComparator());
		return new ArrayList<Point>(Arrays.asList(points));
	}

	public static int distance(Point p1, Point p2) {
		int deltay = p2.y - p1.y;
		int deltax = p2.x - p1.x;
		return deltay * deltay + deltax * deltax;
	}

	static Point start = null;

	private static class PointComparator implements Comparator<Point> {
		@Override
		public int compare(Point p1, Point p2) {
			int orienation = Orientation.getOrientation(start, p1, p2);
			if (orienation == 0) {
				int starttoP1Dist = distance(start, p1);
				int starttoP2Dist = distance(start, p2);
				return starttoP1Dist - starttoP2Dist;
			} else {
				// because p2 is more clockwise
				// hence it has a smaller angle with start as compared to
				// p1, so p1 is bigger
				return orienation;
			}
		}
	}
}
