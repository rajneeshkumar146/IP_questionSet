package mystack;
import java.util.*;
public class rotcards {

		public static void cardRotation(int N){
		    LinkedList<Integer>q=new LinkedList();
		    for(int i=0;i<N;i++)q.addLast(i);//preparing the given sorted deck
		    int[] ans=new int[N];
		    int i=1;
		    while(q.size()!=0 && i<=N){
		        for(int j=0;j<i;j++){
		            q.addLast(q.removeFirst());
		        }
		        ans[q.getFirst()]=i;
		        q.removeFirst();
		        
		        i++;
		    }
		    if(i<N){System.out.println(-1);return;
	}
		    for(int j=0;j<N;j++)System.out.print(ans[j]+" ");
		}
	        
	        public static void main (String[] args) {
			Scanner sc=new Scanner(System.in);
			int N=sc.nextInt();
			cardRotation(N);
			System.out.println("Done");
		}
}
