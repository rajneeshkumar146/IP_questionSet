package ll;

public class identicalll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static boolean check(Node h1,Node h2){
	Node n1=h1;
	Node n2=h2;
	int count=0;
	int count2=0;
while(n1!=null&&n2!=null){
	if(n1.data!=n2.data){
		return false;
	}
	n1=n1.next;
	count++;
}
if(n1==null||n2==null){
	return false;
}
return true;
}

}
