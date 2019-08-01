package InternshipQuestionAs1;

public class Student_Attendance_Record_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkRecord("PPALLL"));
	}

	public static boolean checkRecord(String s) {

		int ACount = 0;
		int LCount = 0;
		boolean L3 = false;

		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'A')
				ACount++;
			if (arr[i] != 'L')
				LCount = 0;
			else if (arr[i] == 'L') {
				LCount++;
				if (LCount == 3)
					L3 = true;
			}
		}

		if (L3 || ACount > 1)
			return false;
		else
			return true;
	}
}
