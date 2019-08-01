package ll;

public class countnodesoflinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static int getcount(Node n){
	int count=0;
	for(Node l=n;l!=null;l=l.next){
		count++;
	}
	return count;
}
}
