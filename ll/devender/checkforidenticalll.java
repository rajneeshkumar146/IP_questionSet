package ll;

public class checkforidenticalll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static boolean check(Node n,Node n2){
	while(n!=null&&n2!=null){
		if(n.data!=n2.data){
			return false;
		}
	}
	if(n==null&&n2==null){
		return false;
	}
	return true;
}
}
