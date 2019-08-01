package InternshipQuestionAs1;

public class Set_Matrix_Zeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m[][] = new int[][] { { 8, 3, 6, 9, 7, 8, 0, 6 }, { 0, 3, 7, 0, 0, 4, 3, 8 }, { 5, 3, 6, 7, 1, 6, 2, 6 },
				{ 8, 7, 2, 5, 0, 6, 4, 0 }, { 0, 2, 9, 9, 3, 9, 7, 3 } };
		setZeroes(m);
		for (int c[] : m) {
			for (int v : c)
				System.out.print(v + " ");
			System.out.println();
		}
	}

	public static void setZeroes(int[][] m) {

		boolean f0 = false;
		boolean fr = false;
		boolean fc = false;

		if (m[0][0] == 0)
			f0 = true;

		for (int c = 1; c < m[0].length; c++)
			if (m[0][c] == 0)
				fr = true;

		for (int r = 1; r < m.length; r++)
			if (m[r][0] == 0)
				fc = true;

		for (int r = 0; r < m.length; r++)
			for (int c = 0; c < m[0].length; c++)
				if (m[r][c] == 0) {
					m[0][c] = Integer.MIN_VALUE + 1;
					m[r][0] = Integer.MIN_VALUE + 1;
				}

		for (int c = 1; c < m[0].length; c++)
			if (m[0][c] == Integer.MIN_VALUE + 1)
				for (int r = 0; r < m.length; r++)
					m[r][c] = 0;

		for (int r = 1; r < m.length; r++)
			if (m[r][0] == Integer.MIN_VALUE + 1)
				for (int c = 0; c < m[0].length; c++)
					m[r][c] = 0;

		if (f0) {
			for (int c = 0; c < m[0].length; c++)
				m[0][c] = 0;
			for (int r = 0; r < m.length; r++)
				m[r][0] = 0;
		}

		if (fr)
			for (int c = 0; c < m[0].length; c++)
				m[0][c] = 0;

		if (fc)
			for (int r = 0; r < m.length; r++)
				m[r][0] = 0;

	}
}
