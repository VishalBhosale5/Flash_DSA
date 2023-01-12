package Array;

import java.util.*;
import java.io.*;

public class ArrayWithOddSum {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("n is :"+n);
		for (int i = 0; i < n; ++i) {
			int l1 = sc.nextInt();
			int sum = 0;
			int t1 = 0;
			for(int j=0;j<l1;j++)
			{
				t1 = sc.nextInt();
				System.out.println("t1 is:"+t1);
				sum += t1;
			}

			System.out.println(sum);
			if (sum % 2 != 0)
				System.out.println("YES");
			else
				System.out.println("NO");

		}
System.out.println(1052+445+683+995+722+1012+1263);
	}

}
