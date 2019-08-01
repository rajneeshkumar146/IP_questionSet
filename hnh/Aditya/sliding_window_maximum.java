package may28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class sliding_window_maximum {

	public static void main(String[] args) {
		int[] arr={1,7,8,9,3,6,8,4,2,1};
		kwin(arr, 3);

	}
	
	public static int[] nge_index(int[] seq)
	{

	    LinkedList<Integer> st=new LinkedList<>();
	    
	    int[] ans=new int[seq.length];

	    for (int i = 0; i < seq.length; i++)
	    {

	        while (st.size() != 0 && seq[i] > seq[st.getFirst()])
	        {
	            int poped = st.getFirst();
	            st.pop();

	            ans[poped]= i;
	        }

	        st.push(i);
	    }

	    while (st.size() != 0)
	    {
	        int poped = st.getFirst();
	        st.pop();

	        ans[poped]= -1;
	    }

	    return ans;
	}

	
	
	public static int[] kwin(int[] seq,int k){
		int[] nges=nge_index(seq);
		
		int[] winmax=new int[seq.length - k + 1];
		
		int i=0;
		int j=0;
		
		while(j<seq.length){
			if(j>i+k){
				i=j;
			}
			else
	        {
	            j=nges[j];
	        }

	        winmax[i]=j;
		}
		
		int[] ret=new int[winmax.length];
		int p=0;
		for(int idx:winmax){
			ret[p++]=seq[idx];
		}
		return ret;
	}
	
	
//	void kwindow(vector<int> &seq, int k)
//	{
//
//	    vector<int> nge;
//
//	    for (int i = 0; i < seq.size(); i++)
//	    {
//	        nge.push_back(0);
//	    }
//
//	    nge_index(seq, nge);
//
//	    int ith_win_ans[seq.size() - k + 1];
//	    
//	    for(int i=0;i<seq.size() - k + 1;i++){
//	        ith_win_ans[i]=seq[i];
//	    }
//
//	    int j = 0;
//	    int i = 0;
//	    while (j < seq.size())
//	    {
//	        if (j > i + k)
//	        {
//	            i=j;
//	        }
//
//	        else
//	        {
//	            //
//	        }
//	            
//	    }
//	}
	
}
