package reccursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Strobogrammatic_Number_3 {
	public static void main(String[] args) {
		System.out.println(strobogrammaticInRange("50", "800"));
	}
	

    public static int strobogrammaticInRange(String low, String high) {
        long lowVal=Long.parseLong(low);
        long highVal=Long.parseLong(high);
        int count=0;
        for(int i=low.length();i<=high.length();i++){
            ArrayList<String> res=helper(i,i);
            for(int j=0;j<res.size();j++){
                long val=Long.parseLong(res.get(j));
                if(val>=lowVal&&val<=highVal){
                    count++;
                }
            }
        }
        return count;
        
        
    }
    
    public static ArrayList<String> helper(int clen,int tlen){
        if(clen==0){
            return new ArrayList<String>(Arrays.asList(""));
        }
        if(clen==1){
            return new ArrayList<>(Arrays.asList("0","1","8"));
        }
        
        ArrayList<String> rres=helper(clen-2,tlen);
        ArrayList<String> myres=new ArrayList<>();
        for(int i=0;i<rres.size();i++){
            String s=rres.get(i);
            if(clen!=tlen){
                myres.add("0"+s+"0");
            }
            myres.add("1"+s+"1");
            myres.add("6"+s+"9");
            myres.add("8"+s+"8");
            myres.add("9"+s+"6");
        }
        return myres;
        
    }
}
