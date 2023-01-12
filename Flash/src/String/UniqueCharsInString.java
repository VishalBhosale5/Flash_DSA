package String;

import java.util.Scanner;

/**
 * Time complexity:O(n) size of string and O(1) is space complexity
 * we can say O(1) time complexity as if it never exceeds 128 
 * @author USER
 *
 */

public class UniqueCharsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		boolean b=uniqueChars(s);
		System.out.println(s+" Has all the unique characters: ;"+b);
		
		
		

	}

	private static boolean uniqueChars(String s) {
		
		//assume ASCII  128
		
		boolean[] b=new boolean[128];
		
		for(int i=0;i<s.length();i++)
		{
			
			if(b[(int)s.charAt(i)])
			{
				return false;
				
			}
			else
				b[(int)s.charAt(i)]=true;
			
		}
		
		return true;
	}

}
