package pepques;

import java.util.Arrays;
import java.util.Scanner;

import pepques.ques_149knapsack.item;

public class ques_181_world_bank_theft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
xc
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			
			int n=s.nextInt();
			int cap=s.nextInt();
			
			int [] wts=new int[n];
			int [] prices=new int[n];
			for(int i=0;i<n;i++)
			{
				prices[i]=s.nextInt();
				wts[i]=s.nextInt();
			}
			fractionalknapsack(wts,prices,cap);
			t--;
		}

	}

	public static void fractionalknapsack(int[] wts,int[] prices,int sia)
	{
		double val=0d;
		
		item []items;
		items=new item[wts.length];
		for(int  i=0;i<items.length;i++)
		{
			items[i]= new item(wts[i],prices[i]);
		}
		Arrays.sort(items);
		int i=0;
		while(sia>0 && i<items.length)
		{
			if((items[i].wt)!=)
			if(items[i].wt<=sia)
			{
				val+=items[i].price;
				sia-=items[i].wt;
			}
			else 
			{
				val+=items[i].ratio*sia;
				sia-=items[i].ratio*sia;
			}
			i++;
		}
		System.out.printf("%.3f\n", val);
	}
	  public static class item implements Comparable<item> {
				int wt;
				int price;
				double ratio;
				item(int wt,int price)
				{
					this.wt=wt;
					this.price=price;
					this.ratio=price*1.0/wt;
				}
				@Override
				public int compareTo(item o) {
					// TODO Auto-generated method stub
					 if(this.ratio>o.ratio)
						  return -1;
					  else if(this.ratio==o.ratio)
						  return 0;
					  else
						  return +1;
				}
	}

}
