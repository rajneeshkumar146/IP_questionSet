import java.util.ArrayList;
public class Q147_WaterConnectionProblem {

	static void Solve(int[][]A,int n,int p)
	{
		int[]start=new int[n+1];
		int[]end=new int[n+1];
		int[]distances=new int[n+1];
		
		for(int i=0;i<p;i++)
		{
			int startvertex=A[i][0];
			int endvertex=A[i][1];
			int distance=A[i][2];
			
			start[startvertex]=endvertex;
			distances[startvertex]=distance;
			end[endvertex]=startvertex;
		}
		int counter=0;
		ArrayList<Integer>startanswer=new ArrayList<>();
		ArrayList<Integer>endanswer=new ArrayList<>();
		ArrayList<Integer>distanceanswer=new ArrayList<>();
		
		for(int j=1;j<A.length;j++)
		{
			if(start[j]>0 && end[j]==0)
			{
				counter++;
				ans=Integer.MAX_VALUE;
				
				int finalend=Dfs(j,start,end,distances); //Finding the end of the connected component
				
				startanswer.add(j);
				endanswer.add(finalend); //Adding the final end
				distanceanswer.add(ans); //static variable for finding minimum distance
				
			}
		}
		System.out.println(counter);    //Number of disconnected components
		
		for(int i=0;i<startanswer.size();i++)
		{
			System.out.print(startanswer.get(i)+" "+endanswer.get(i)+" "+distanceanswer.get(i));
			System.out.println();
		}
	}
	static int ans;
	
	static int Dfs(int vertex,int[]start,int[]end,int[]distance)
	{
		if(start[vertex]==0)       //Yahan se aage aur koi raasta nahi
		{
			return vertex;
		}
		
		if(ans>distance[vertex])    //Minimum pipe diameter chahiye pure component ki
		{
			ans=distance[vertex];
		}
		return Dfs(start[vertex],start,end,distance);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                 Solve(new int[][]{ { 7, 4, 98 }, 
                        { 5, 9, 72 }, 
                        { 4, 6, 10 }, 
                        { 2, 8, 22 }, 
                        { 9, 7, 17 }, 
                        { 3, 1, 66 } },9,6);
	}
}
