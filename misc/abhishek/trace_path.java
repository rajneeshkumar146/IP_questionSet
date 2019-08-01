package may31;

import java.util.Scanner;


public class TracePath {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T-- > 0){
			int r = s.nextInt();
			int c = s.nextInt();
			String str = s.next();
			
			int x = 0;
			int y = 0;
			int maxr = 0;
			int minr = 0;
			int maxc = 0;
			int minc = 0;
			
			
			for(int i = 0; i < str.length(); i++){
				if(str.charAt(i) == 'L'){
					x--;
				}else if(str.charAt(i) == 'R'){
					x++;
				}else if(str.charAt(i) == 'U'){
					y++;
				} else{
					y--;
				}
				
				
				maxr = Math.max(maxr, x);
				minr = Math.min(minr, x);
				maxc = Math.max(maxc, y);
				minc = Math.min(minc, y);
			}
			
			if((maxc - minc) < r && (maxr - minr) < c ){
				System.out.println(1);
			} else{
				System.out.println(0);
			}
			
		}

	}
}