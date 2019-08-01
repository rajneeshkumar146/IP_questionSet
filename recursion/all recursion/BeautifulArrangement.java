package BackTracking;

public class BeautifulArrangement {

	public static void main(String[] args) {
		int n = 1;
		Arrrange(n, 1, new boolean[n + 1]);
		System.out.println(count);
	}

	static int count = 0;

	private static void Arrrange(int n, int cpos, boolean[] visited) {
		if (cpos > n) {
			count++;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if ((visited[i] == false) && (i % cpos == 0 || cpos % i == 0)) {
				visited[i] = true;
				Arrrange(n, cpos + 1, visited);
				visited[i] = false;
			}
		}
	}
}
