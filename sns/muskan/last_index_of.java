package pep_sns;

public class last_index_of {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "00011100";
		//"0000" => -1
		int index = -1;
	     for(int i=input.length() - 1; i>=0; i--){
	         if(input.charAt(i) == '1'){
	             index = i;
	             break;
	         }
	     }
	     System.out.println(index);

	}

}
