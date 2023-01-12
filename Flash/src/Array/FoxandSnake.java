package Array;

import java.util.*;
import java.io.*;

class FoxandSnake {

	public static void main(String args[]) throws Exception {
		// BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";

		for (int i = 0; i < m; i++) {
			s1 += "#";
			s2 += ".";
		}
		s3 = s2.substring(0, s2.length()-1) + "#";
		s4 = "#" + s2.substring(1, s2.length());
		
	

		int j=1;
		for (int i = 0; i < n; i++) {
				if(i%2==0)
				{
					System.out.println(s1);
					continue;
				}
				j++;
				if(j%2==0)
					System.out.println(s3);
				
				if(j%2==1)
				{
					System.out.println(s4);
					
				}
				
		}

	}

}
