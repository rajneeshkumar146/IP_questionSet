package SnS;
	//Initial Template for Java
	import java.util.*;
	import java.lang.*;
	import java.io.*;
	class Sorting
	{
	    static int a[] = new int[100001];
	    static int b[] = new int[100001];
	    static int newtable[] = new int[100001];
	    public static void main(String args[])throws IOException
	    {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        while(t-- > 0)
	        {
	            int m = sc.nextInt();
	            int n = sc.nextInt();
	            for(int i = 0; i < m; i++)
	              a[i] =sc.nextInt();
	              
	            for(int i = 0; i < n; i++)
	              b[i] = sc.nextInt();
	            new Union_of_Sortedarrays().printUnion(m, n);
	            System.out.println();
	        }
	    }
	}

	/*Please note that it's Function problem i.e.
	you need to write your solution in the form of Function(s) only.
	Driver Code to call/invoke your function is mentioned above.*/

	//User function Template for Java
	class Union_of_Sortedarrays
	{
	    // object to access global array 
	    //variables declared in Sorting class
	    static Sorting obj = new Sorting();
	    static void printUnion(int m, int n)
	    {
	        HashSet<Integer> map=new HashSet<>();
	        for(int i=0;i<m;i++){
	            if(!map.contains(obj.a[i])){
	                map.add(obj.a[i]);
	                System.out.print(obj.a[i]+" ");
	            }
	        }
	        
	        for(int i=0;i<n;i++){
	            if(!map.contains(obj.b[i])){
	                map.add(obj.b[i]);
	                System.out.print(obj.b[i]+" ");
	            }
	        }
	    }
	}

	
//	 static void printUnion(int m, int n)
//	    {   
//	        int max=Math.max(obj.a[m-1],obj.b[n-1]);
//	        boolean[] strg=new boolean[max+1];
//	        strg[obj.a[0]]=true;
//	        System.out.print(obj.a[0]+" ");
//	        
//	        
//	        for(int i=1;i<m;i++){
//	            if(obj.a[i]!=obj.a[i-1]){
//	                strg[obj.a[i]]=true;
//	                System.out.print(obj.a[i]+" ");
//	            }
//	        }
//	        
//	        for(int i=0;i<n;i++){
//	            if(obj.b[i]!=obj.b[i-1]&&strg[obj.b[i]]==false){
//	                strg[obj.b[i]]=true;
//	                System.out.print(obj.b[i]+" ");
//	            }
//	        }
//	    }
