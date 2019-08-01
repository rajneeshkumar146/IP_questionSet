package interview.geometry;

import java.util.ArrayList;
import java.util.HashSet;

public class QuickHull {

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

	private static ArrayList<Point> convexHull(Point[] points) {
		ArrayList<Point> hull = new ArrayList<>();
		
		int minxi = 0;
		int maxxi = 0;
		
		for(int i = 1; i < points.length; i++){
			if(points[i].x < points[minxi].x){
				minxi = i;
			}
			if(points[i].x > points[maxxi].x){
				maxxi = i;
			}
		}
		
		Point p1 = points[minxi];
		Point p2 = points[maxxi];
		
		hull.add(p1);
		hull.add(p2);
		
		ArrayList<Point> p1p2set = new ArrayList<>();
		ArrayList<Point> p2p1set = new ArrayList<>();
		
		for(int i = 0; i < points.length; i++){
			if(points[i] == p1 || points[i] == p2){
				continue;
			}
			if(Orientation.getOrientation(p1, p2, points[i]) < 0){
				p1p2set.add(points[i]);
			} else if(Orientation.getOrientation(p2, p1, points[i]) < 0){
				p2p1set.add(points[i]);
			}
		}
		
		quickhull(p1, p2, p1p2set, hull);
		quickhull(p2, p1, p2p1set, hull);
		
		return hull;
	}

	private static void quickhull(Point p1, Point p2, ArrayList<Point> p1p2set, ArrayList<Point> hull) {
		if(p1p2set.size() == 0){
			return;
		} else if(p1p2set.size() == 1){
			int insertAt = hull.indexOf(p2);
			hull.add(insertAt, p1p2set.get(0));
			return;
		}
		
		
		int insertAt = hull.indexOf(p2);
		
		Point fp = null;
		for(Point p: p1p2set){
			if(fp == null){
				fp = p;
			} else {
				if(perpendicularDistance(p1, p2, p) > perpendicularDistance(p1, p2, fp)){
					fp = p;
				}
			}
		}
		
		hull.add(insertAt, fp);
		
		ArrayList<Point> p1fpset = new ArrayList<>();
		ArrayList<Point> fpp2set = new ArrayList<>();
		
		for(Point p: p1p2set){
			if(p == fp){
				continue;
			}
			if(Orientation.getOrientation(p1, fp, p) < 0){
				p1fpset.add(p);
			} else if(Orientation.getOrientation(fp, p2, p) < 0){
				fpp2set.add(p);
			}
		}
		
		quickhull(p1, fp, p1fpset, hull);
		quickhull(fp, p2, fpp2set, hull);
	}
	
	// ax + by + c formulae without denominator
	private static int perpendicularDistance(Point p1, Point p2, Point p3){
		return Math.abs((p3.y - p1.y) * (p2.x - p1.x) - (p2.y - p1.y) * (p3.x - p1.x));
	}

}
