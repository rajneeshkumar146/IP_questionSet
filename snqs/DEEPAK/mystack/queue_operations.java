package mystack;
import java.util.*;
public class queue_operations {
	
public static void insert(Queue<Integer> q, int k){
        q.add(k);
}

static int findFrequency(Queue<Integer> q, int k){
int count=0;
Stack<Integer> st=new Stack<>();
while(!q.isEmpty()){
    if(q.peek()==k)
    count++;
    st.push(q.remove());
}
while(!st.isEmpty()){
    q.add(st.pop());
}
if(count==0)
return -1;
return count;
}
	public static void main(String[] args) {
Queue<Integer> q=new LinkedList<>();
insert(q,3);
insert(q,7);
insert(q,13);
insert(q,7);

insert(q,1);
insert(q,7);
insert(q,19);
System.out.println(findFrequency(q, 7));
	}

}
