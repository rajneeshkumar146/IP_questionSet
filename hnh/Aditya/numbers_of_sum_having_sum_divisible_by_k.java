package may28;

public class numbers_of_sum_having_sum_divisible_by_k {

	public int subarraysDivByK(int[] A, int K) {
	
		int[] prefixsums=new int[A.length+1];
		
		int sumsofar=0;
		
		for(int i=1;i<prefixsums.length;i++){
			sumsofar+=A[i-1];
			prefixsums[i]=sumsofar;
		}
		
		int[] prefixsumRemainders=new int[prefixsums.length];
		
		for(int i=0;i<prefixsums.length;i++){
			prefixsumRemainders[i]=(prefixsums[i]%K+K)%K; //get =ve remainder
		}
		
		int[] count=new int[K];
		for(int i=0;i<prefixsumRemainders.length;i++){
			count[prefixsumRemainders[i]]++;
		}
		
		
		int ans=0;
		for(int counts:count){
			ans+=((counts)*(counts-1))/2;
		}
		
		return ans;
	
	
	}

}
