package may27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tom_and_string {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		HashMap<Character, Integer> hmap=new HashMap<>();
		
		String dictionary="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0;i<dictionary.length();i++){
			hmap.put(dictionary.charAt(i), i);
		}
		
		
		int t = scn.nextInt();
		scn.nextLine();

		for (int tc = 0; tc < t; tc++) {
			String line = scn.nextLine();
			ArrayList<String> words = new ArrayList<>();

			int idx = 0;
			StringBuilder word = new StringBuilder("");
			while (idx <= line.length()) {
				if (idx == line.length() || line.charAt(idx) == ' ') {
					words.add(word.toString());
					word = new StringBuilder("");
				} else {
					word.append(line.charAt(idx));
				}

				idx++;
				
			}
			
			//words filled
			
			int hashcode=0;
			for(String wd: words){
				
				for(int wi=0;wi<wd.length();wi++){
					hashcode+=(hmap.get(wd.charAt(wi))+wi);
				}
				
			}
			System.out.println(hashcode*words.size());
			
			
			
		}

	}
}
