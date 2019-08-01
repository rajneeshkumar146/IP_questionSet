package ll;

public class linkedlistmatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node func(int [][]mat,int n){
	Node head=made(mat,0,0,n);
}
public static made(int []mat,int i,int j,int n){
	if(i==n||j==n){
		return null;
	}
	Node nt=new Node(mat[i][j]);
	nt.right=made(mat,i,j+1,n);
	nt.down=made(mat,i+1,j,n);
	return nt;
}
}
