package InternQuestAS1;
import java.util.*;


import java.util.LinkedList; 
import java.util.Queue; 

public class Reveal_Cards_In_Increasing_Order {
	 public static int[] deckRevealedIncreasing(int[] deck) {
		 int n= deck.length;
	        Arrays.sort(deck);
	        Queue<Integer> q = new LinkedList<>(); 
	        for (int i=n-1; i>=0; i--){
	        	q.add(i);
	        }
	        int[] res= new int[n];
	        
	        for (int i=0; i<n; i++){
	            res[q.poll()]=deck[i];
	            q.add(q.poll());
	        }
	        return res;
	    }
//	        Arrays.sort(deck);
//	        if(deck.length<=2){
//	        	return deck;
//	        }
//	        int ans[]=new int[deck.length];
//	        int s=0;
//	        int e=deck.length-2;
//	        for(int i=0;i<ans.length;i++){
//	        	if( s==e && deck.length%2==1){
//	        		e=deck.length-1;
//	        		ans[i]=deck[e];
//	        	}
//	        	else if( s==e && deck.length%2==0){
//	        		ans[i]=deck[s];
//	        		s++;
//	        		e=deck.length-1;
//	        	}
//	        else if(i%2==0){
//	        		ans[i]=deck[s];
//	        		s++;
//	        	}
//	        	else if(i%2==1){
//	        		ans[i]=deck[e];
//	        		e--;
//	        	}
//	        	
//	        }
//	        return ans;
	        
	    

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int  deck[]={17,13,11,2,3,5,7};
		int ans[]=deckRevealedIncreasing(deck);
		for(int v:ans){
			System.out.print(v+" ");
		}
		System.out.println();
		

	}

}
