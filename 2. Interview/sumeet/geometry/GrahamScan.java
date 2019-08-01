package interview.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class GrahamScan {

	public static void main(String[] args) {
		// test case 1
		// Point[] points = new Point[10];
		// points[0] = new Point(0, 0);
		// points[1] = new Point(1, 2);
		// points[2] = new Point(3, 5);
		// points[3] = new Point(2, 4);
		// points[4] = new Point(0, 3);
		// points[5] = new Point(3, 0);
		// points[6] = new Point(4, 1);
		// points[7] = new Point(2, 3);
		// points[8] = new Point(3, 4);
		// points[9] = new Point(1, 0);

		// test case 2
		// Point[] points = new Point[10];
		// points[0] = new Point(-1, -1);
		// points[1] = new Point(0, 8);
		// points[2] = new Point(1, 3);
		// points[3] = new Point(0, 1);
		// points[4] = new Point(8, 0);
		// points[5] = new Point(-1, 1);
		// points[6] = new Point(-2, -1);
		// points[7] = new Point(0, -8);
		// points[8] = new Point(7, 0);
		// points[9] = new Point(-8, 0);

		// test case 3
		Point[] points = new Point[10];
		points[0] = new Point(0, 15);
		points[1] = new Point(10, 0);
		points[2] = new Point(3, -1);
		points[3] = new Point(8, -8);
		points[4] = new Point(-1, -1);
		points[5] = new Point(3, 0);
		points[6] = new Point(-8, -10);
		points[7] = new Point(4, 2);
		points[8] = new Point(0, 8);
		points[9] = new Point(-9, 0);

		System.out.println(convexHull(points));
	}

	private static Stack<Point> convexHull(Point[] points) {
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

		Stack<Point> hullStack = new Stack<>();

		hullStack.push(points[0]);
		hullStack.push(points[1]);

		for (int i = 2; i < points.length; i++) {
			Point p1 = hullStack.pop();
			Point p2 = points[i];

			while (Orientation.getOrientation(hullStack.peek(), p1, p2) > 0) {
				p1 = hullStack.pop();
			}

			hullStack.push(p1);
			hullStack.push(p2);
		}

		return hullStack;
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
