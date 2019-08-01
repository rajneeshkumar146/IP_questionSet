package mystack;

public class Circular_tour {
	public static boolean iscirclecomplete(int i,int[] petrol,int[] dist){
		int d=i;
		int petrem=0;
		do{
			petrem+=petrol[i]-dist[i];
			if(petrem>=0){
				i++;
			}
			if(petrem<0){
				break;
			}
			 if(i>=petrol.length){
				i=0;
			}
		}while(d!=i);
		if(petrem>=0)
			return true;
		else return false;
	}
public static int circulartour(int[] petrol,int[] dist){
	for(int i=0;i<petrol.length;i++){
		if(iscirclecomplete(i,petrol,dist)){
			return i;
		}
	}
	return -1;
}
	public static void main(String[] args) {
		int petrol[]={4,6,7,4};
		int dist[]={6,5,3,5};
		System.out.println(circulartour(petrol,dist));
	}

}
