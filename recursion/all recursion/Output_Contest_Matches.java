package BackTracking;

public class Output_Contest_Matches {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(findContestMatch(n));
	}

	public static String findContestMatch(int n) {
		String[] arr = new String[n];
		for (int i = 1; i <= n; i++) {
			arr[i - 1] = i + "";
		}
		while (n != 1) {
			for (int i = 0; i < n / 2; i++) {
				arr[i] = "(" + arr[i] + "," + arr[n - 1 - i] + ")";
			}
			n = n / 2;
		}
		return arr[0];
	}
}
