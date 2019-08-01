package pep_sns;

public class maximum_partitions_to_make_array_sorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[] arr = { 2, 1, 0, 3, 4, 5 };
		int maxvalue = 0;
		int partitions = 0;
		for (int i = 0; i < n; i++) {
			maxvalue = Math.max(maxvalue, arr[i]);
			if (maxvalue == i) {
				partitions++;
			}
		}
		System.out.println(partitions);

	}

}
