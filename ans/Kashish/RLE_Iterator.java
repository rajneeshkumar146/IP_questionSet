package InternQuestAS1;

import java.util.Scanner;

public class RLE_Iterator {
	int index;
    int [] A;
    public  void RLEIterator(int[] A) {
        this.A = A;
        index = 0;
    }
    
    public int next(int n) {
        while(index < A.length && n > A[index]){
            n = n - A[index];
            index += 2;
        }
        
        if(index >= A.length){
            return -1;
        }
        
        A[index] = A[index] - n;
        return A[index + 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		

	}

}
