
public class _01KnapSack {
	public static void Knapsack(int wt[],int pr[],int tw){
		int strg[]=new int[tw+1];
		strg[0]=0;
		for(int i=1;i<strg.length;i++){
			for(int j=0;j<wt.length;j++){
				if(i>=wt[j]){
					strg[i]=strg[i-wt[j]]+pr[j]>strg[i]?
							strg[i-wt[j]]+pr[j]:strg[i];
				}
			}
		}
		System.out.println(strg[tw]);
	}
}
