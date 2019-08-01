package InternQuestAS1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Reorder_Log_Files {
	public  static String[] reorderLogFiles(String[] logs){
		 Comparator<String> myComp = new Comparator<String>() {
	         @Override
	         public int compare(String s1, String s2) {
	           String[] split1 = s1.split(" ", 2);//2 signifies to break the string into two half;
	           String[] split2 = s2.split(" ", 2);
	           boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
	           boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
	           if(!isDigit1 && !isDigit2) {             
	             int comp = split1[1].compareTo(split2[1]);
	             if(comp != 0){
	              return comp;
	             }
	             else{
	              return split1[0].compareTo(split2[0]);
	             }
	           }
	             return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
	         }
	       };
	       Arrays.sort(logs, myComp);
	       return logs;
	    
	}

	public static void main(String[] args) {
	
		Scanner scn=new Scanner(System.in);
		String Input[] ={"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		String ans[]=reorderLogFiles(Input);
		
		

	}

}
