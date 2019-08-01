package pep_sns;

public class replace_by_x {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String main = "ABABABABADGCFSABABHAB";
		String sub = "AB";
				
		StringBuilder ans = new StringBuilder("");
	     int count = 0;
	     for(int i=0; i<main.length();){
	         while((i <= main.length() - sub.length()) && main.substring(i, i + sub.length()).equals(sub)){
	             i += sub.length();
	             count++;
	         }
	         if(count != 0){
	            ans.append("X");
	            count = 0; 
	         }else{
	             ans.append(main.charAt(i));
	             i++;
	         }
	     }
	     System.out.println(ans);
	}

}
