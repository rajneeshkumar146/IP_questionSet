package SnS;

public class smallest_rectangle_enclosing_black_pixels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] image = { { '0', '0', '1', '0' }, { '0', '1', '1', '0' },{'0','1','0','0'}};
		System.out.println(minArea(image, 0, 2));
	}

	public static int top, bottom, left, right;

	public static int minArea(char[][] image, int x, int y) {

		if (image.length == 0) {
			return 0;
		}
		top = bottom = x;
		left = right = y;
		traverse(image, x, y);
		return (bottom - top) * (right - left);
	}

	public static void traverse(char[][] image, int x, int y) {

		if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] == '0') {
			return;
		}

		image[x][y] = '0';

		top = Math.min(x, top);
		left = Math.min(y, left);

		right = Math.max(y + 1, right);
		bottom = Math.max(x + 1, bottom);
		traverse(image, x + 1, y);
		traverse(image, x - 1, y);
		traverse(image, x, y + 1);
		traverse(image, x, y - 1);
	}

}
