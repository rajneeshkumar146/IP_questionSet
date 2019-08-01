import java.util.*;
	import java.lang.*;
	import java.io.*;
public class Q105_PrintAdjacencyList {
	    static void printAdjacencyList(ArrayList<ArrayList<Integer>> list, int v)
		{
		    for(int i=0;i<v;i++)
	        {
	            System.out.print(i);
	            for(int x:list.get(i))
	            {
	                System.out.print("-> "+x);
	            }
	            System.out.println();
	       }
		}

}
