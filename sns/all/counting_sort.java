package pep_sns;

public class counting_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = {'g','e','e','k','s','f','o','r','g','e','e','k','s'};
		countSort(arr);
		for(char c : arr)
			System.out.print(c + " ");

	}
	
	public static void countSort(char arr[])
    {
        char[] carr = new char[arr.length];
		int[] fmap = new int[26];
		int[] prefixsumarray = new int[26];
		for(int i=0; i<arr.length; i++) {
			fmap[arr[i] - 'a'] += 1;
		}
		prefixsumarray[0] = fmap[0];
		for(int i=1; i<fmap.length; i++) {
			prefixsumarray[i] = fmap[i] + prefixsumarray[i-1];
		}
		for(int i=arr.length-1; i>=0; i--) {
			int idx = prefixsumarray[arr[i] - 'a'] - 1;
			carr[idx] = arr[i];
			prefixsumarray[arr[i] - 'a'] -= 1;
		}
		for(int i=0; i<arr.length; i++){
		    arr[i] = carr[i];
		} 
    }

}
