package pep_sns;

public class find_smallest_letter_greater_than_target {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] letters = {'c', 'f', 'j'};
		System.out.println(nextGreatestLetter(letters, 'a'));

		System.out.println(nextGreatestLetter(letters, 'c'));

		System.out.println(nextGreatestLetter(letters, 'd'));

		System.out.println(nextGreatestLetter(letters, 'g'));

		System.out.println(nextGreatestLetter(letters, 'j'));

		System.out.println(nextGreatestLetter(letters, 'k'));
	}
	
	public static char nextGreatestLetter(char[] letters, char target) {
        if(target >= letters[letters.length - 1]){
            return letters[0];
        }
        if(target < letters[0]){
            return letters[0];
        }
        int left = 0;
        int right = letters.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(letters[mid] > target && letters[mid - 1] <= target){
                return letters[mid];
            }
            if(letters[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return (char)(-1);
    }

}
