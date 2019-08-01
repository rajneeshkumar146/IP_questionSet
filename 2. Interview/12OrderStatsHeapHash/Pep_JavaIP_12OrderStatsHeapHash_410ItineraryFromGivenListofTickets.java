package OrderStatsHeapHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_410ItineraryFromGivenListofTickets {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			map.put(scn.next(), scn.next());
		}
		
		//create a reverse map
		ArrayList<String> al=new ArrayList<>(map.keySet());
		HashMap<String, String> rev_map = new HashMap<>();
		for(String src: al) {
			rev_map.put(map.get(src), src);
		}
		String start_point="";
		for(String src: al) {
			if(rev_map.containsKey(src)==false) {
				 start_point=src;
				break;
			}
		}
		String ans="";
		while(map.containsKey(start_point)) {
			ans+=start_point+"->"+map.get(start_point)+" ";
			start_point=map.get(start_point);
		}
		
		System.out.println(ans);
	}

}
/*
Test cases:
4
Chennai Bangalore
Bombay Delhi
Goa Chennai
Delhi Goa
-------------------
Bombay->Delhi Delhi->Goa Goa->Chennai Chennai->Bangalore

4
Chennai Bangalore
Bombay Delhi
Hisar Chennai
Delhi Hisar
----------------------
Bombay->Delhi Delhi->Hisar Hisar->Chennai Chennai->Bangalore

5
Chennai Bangalore
Bombay Delhi
Goa Chennai
Delhi Goa
Bangalore Bhopal
-----------------------
Bombay->Delhi Delhi->Goa Goa->Chennai Chennai->Bangalore Bangalore->Bhopal

Source : https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
	*/