package pep_sns;

import java.util.ArrayList;

public class longest_word_in_dictionary_through_deleting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("ale");
		list.add("apple");
		list.add("monkey");
		list.add("plea");
		String s = "abpcplea";
		System.out.println(findLongestWord(s, list));

	}
	
	public static String findLongestWord(String s, ArrayList<String> d) {
        String res = "";
        for(int i=0; i<d.size(); i++){
            String word = d.get(i);
            if(ispossible(s, word)){
                if((word.length() > res.length()) || (word.length() == res.length() && word.compareTo(res) < 0)){
                    //smaller string lexicographically
                    res = word;
                }
            }
        }
        return res;
    }
    
    public static boolean ispossible(String main, String sub){
        for(int i=0, j=0; i<main.length() && j<sub.length(); i++){
            if(main.charAt(i) == sub.charAt(j)){
                j++;
            }
            if(j == sub.length())
                return true;
        }
        return false;
    }

}
