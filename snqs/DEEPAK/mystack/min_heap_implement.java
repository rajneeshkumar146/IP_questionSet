package mystack;

public class min_heap_implement {
	void push_pq(priority_queue<int, vector<int>, greater<int>> &pq, int x){
        pq.push(x);

	}
void pp_pq(priority_queue<int, vector<int>, greater<int>> &pq){
  
  
   if(!pq.empty())
       return pq.pop();
   else
   return ;
   
}

int pq_top(priority_queue<int, vector<int>, greater<int>> &pq){
   
    if(!pq.empty())
       return pq.top();
   else
   return -1;
   
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
