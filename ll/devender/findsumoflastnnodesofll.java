package ll;

public class findsumoflastnnodesofll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int count;
    //Return the sum of last k nodes
    public int sum(Node head, int k){
      //write code here
      count=k;
      return shelp(head);
    }
    public int shelp(Node head){
        if(head==null){
            return 0;
        }
        int val=shelp(head.next);
        if(count>0){
            val+=head.data;
            count--;
        }
        return val;
    }
    
    }
