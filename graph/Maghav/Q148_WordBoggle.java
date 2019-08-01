import java.util.HashMap;
public class Q148_WordBoggle {
	static HashMap<String,Integer>hm;
	static void Boggle(String[]dict,char[][]matrix)
	{
		boolean[][]visited=new boolean[matrix.length][matrix[0].length];
		
		hm=new HashMap<>();
		for(String X:dict)
		{
			hm.put(X, 1);
		}
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				
			    Find(i,j,matrix,visited,"");
			}
		}
		
	}
	
	static void Find(int i,int j,char[][]matrix,boolean[][]visited,String str)
	{
		visited[i][j]=true;
		str=str+matrix[i][j];
		
		if(hm.containsKey(str))
		{
			System.out.print(str+" "); //For displaying all words(repition allowed)
			//To avoid duplicates, we can use a hashset and then print only the unique values
		}
		int[][]dirs=
			{
					{1,0},
					{1,1},
					{0,1},
					{-1,1},
					{-1,0},
					{-1,-1},
					{0,-1},
					{1,-1}
			};
		
		for(int[]x:dirs)
		{
			int newx=i+x[0];
			int newy=j+x[1];
			
			if(newx>=0 && newx<matrix.length && newy>=0 && newy<matrix[0].length 
			&&visited[newx][newy]==false)
			{
				Find(newx,newy,matrix,visited,str);
			}
		}
		
		visited[i][j]=false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char boggle[][] = { { 'G', 'I', 'Z' }, 
                { 'U', 'E', 'K' }, 
                { 'Q', 'S', 'E' } };
		String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
		Boggle(dictionary,boggle);
	}

}
