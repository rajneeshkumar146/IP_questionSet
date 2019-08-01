package SnS;

import java.util.Arrays;

public class three_equal_parts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {1,0,0,1,0,1};
		int[] res=threeEqualParts(A);
		System.out.println("["+res[0]+" "+res[1]+"]");
	}
	
    public static int[] threeEqualParts(int[] A) {
        
        int sum=0;
        int[] res={-1,-1};
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        
        if(sum%3!=0){
            return res;
        }
        
        if(sum/3==0){
            return new int[]{0,A.length-1};
        }
        
        int k=sum/3;
        
        int i1=-1,i2=-1,i3=-1,j1=-1,j2=-1,j3=-1;
        int count=0;
        for(int i=0;i<A.length;i++){
            
            if(A[i]==1){
                count+=A[i];
                if(count==1){
                    i1=i;
                }
                if(count==k){
                     j1=i;
                }if(count==k+1){
                     i2=i;
                }if(count==2*k){
                     j2=i;
                }if(count==2*k+1){
                     i3=i;
                }if(count==3*k){
                     j3=i;
                }
            }
        }
        
        
        int[] p1=Arrays.copyOfRange(A,i1,j1+1);
        int[] p2=Arrays.copyOfRange(A,i2,j2+1);
        int[] p3=Arrays.copyOfRange(A,i3,j3+1);
        
        if(!Arrays.equals(p1,p2)||!Arrays.equals(p1,p3)){
            return res;
        }
        //zeroes in each part
        int zp1=i2-j1-1;
        int zp2=i3-j2-1;
        int zp3=A.length-j3-1;
        
        if(zp1<zp3||zp2<zp3){
            return res;
        }
        
        return new int[]{j1+zp3,j2+zp3+1};
    }


}
