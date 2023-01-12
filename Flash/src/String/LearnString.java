package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class LearnString {

	public static void main(String[] args) {

		/*
		 * String is a class which is final hence immutable
		 * 
		 * 
		 * 
		 * String str="Hello" ;
		 * String s1="Hello";
		 * 
		 * stack variables:str,s1 of type string storing address of object stored in heap.
		 * jvm will check if there is any object present in string internal pool 
		 * if present then return the same address
		 * if not present then create new one in heap and return address.
		 * 
		 *now if we write s1="changed string" now this will not change the original hello object because string in java is immutable
		 *it will create new strig object in heap and return the address.
		 *if Strin g s4=new String("Hello") //this is create new string object insie heap but outside of intern pool
		 *
		 */
		// String s1="abc";
		// String s2=new String("abc");
		// System.out.println(s1==s2); //false == compares reference
		// System.out.println(s1.equals(s2)); //true equals comapres the value
		// String s3="abc";
		// System.out.println(s1==s3); //true due to String pool in heap

		// StringBuilder s=new StringBuilder(); //not thread safe hence faster than
		// string buffer
		// StringBuffer ss=new StringBuffer(); //thread safe

		// Scanner sc=new Scanner(System.in);

		// String sss=sc.next(); //it takes input token wise
		// suppose you entered " I am a king" then it will pick only "I"
		// sc.nextLine() ; //this is pick all the string util we press nextline(enter)

		// also take care while taking string input after nextInt() use
		// Integer.parseInt(sc.nextInt()) instead.
		// or put sc.nextLine() again

		// int a=Integer.parseInt(sc.nextLine());
		// int a=sc.nextInt();
		// sc.nextLine(); //put nextLine or use parseInt with sc.nextLIne();
		// String a1=sc.nextLine();
		// String a2=sc.nextLine();

		// System.out.println(a+" "+a1+" "+a2);
		//
		/*
		 * substring: empty ,whole or smaller part of string with contigious/original
		 * order subsequence: relative order should be maintained , not rq to be
		 * contigiouse "hello" substring- "".hello,hel,hell subsequence: hlo,ho,eo,lo
		 */

		
		//System.out.println((int)(91283472332L-Integer.MAX_VALUE));
//
		//System.out.print("abc".substring(2,2));  //empty string as si saying include but ei saying not inclue
	/*	String s=new String("abc");
		String ss="abc";
		System.out.println(s==ss); //false because s is created outside of intern pool but inside heap and ss is in intern pool
		
		System.out.println(ss.startsWith("a"));
		
		StringBuilder sb=new StringBuilder("lo");
		sb.append("l0");
		sb.setCharAt(0, 'h');
		sb.insert(0, "hello");
		sb.deleteCharAt(0);
		System.out.println(sb);
		//string to stringbuilder
		StringBuilder sbb=new StringBuilder("hi");
	//	stringbuilder to string
		sbb.toString();*/
		//ss.contains('s');
		// *************problems*************

		//printFirstCharOfString("    Hi i    am a geeks   ");
		//reverseEachWord("coding simplified is nice");
		//reverseEachWordStack("coding simplefied is nice");
		//System.out.println();
		//reverseSentence("coding simplefied is nice");
		//System.out.println(longestSubtrLenkUnique("wcysyycqpev", 6));
	//	System.out.println(longestSubtrNoRepeatingChararacters("babccbacd"));
		System.out.println(Long.MAX_VALUE);
	}

	// print first character of every string
	// time : O(n) space: O(1)
	private static void printFirstCharOfString(String string) {

		for (int i = 0; i < string.length(); i++) {

			char ch = string.charAt(i);

			if (ch != ' ' && (i == 0 || string.charAt(i - 1) == ' '))
				System.out.println(ch);

		}

	}

	/*
	 * Reverse the individulal words in a string 1)using for loop and stringbuilder
	 * 2) stack
	 */

	// time: O(n) space:O(n) for stringbuilder
	private static void reverseEachWord(String sentence) {
		StringBuilder temp = new StringBuilder();
		StringBuilder finalans = new StringBuilder();

		for (int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if (ch != ' ') {
				temp.insert(0, ch);
			} else {
				finalans = finalans.append(temp).append(" ");
				temp.setLength(0);
			}

		}

		finalans = finalans.append(temp);

		System.out.println(finalans);

	}

	// using stack time: O(n) space: O(n) for stack
	private static void reverseEachWordStack(String sentence) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if (ch == ' ') {
				while (!stack.isEmpty())
					System.out.print(stack.pop());
				System.out.print(" ");
			} else {
				stack.push(ch);
			}

		}

		while (!stack.isEmpty())
			System.out.print(stack.pop());

		// System.out.println(finalans);

	}
	
	
	//revere a sentence
	
	private static void reverseSentence(String sentence) {
		StringBuilder temp = new StringBuilder();
		StringBuilder finalans = new StringBuilder();

		for (int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if (ch != ' ') {
				temp.append(ch);
			} else {
				finalans = finalans.insert(0,temp.append(" "));
				temp.setLength(0);
			}

		}

		finalans = finalans.insert(0,temp.append(" "));

		System.out.println(finalans);
		

	}
	
	/*
	 * Longest Substring With Exactly K Unique Characters
	 * time:O(n) space: O(n) for hashmap
	 */
	
	private static int longestSubtrLenkUnique(String str,int k)
	{
		if(k>str.length())
			return -1;
		
		//Map to store unique characters
		HashMap<Character,Integer> map=new HashMap<>();
		
		//maxlen to store the maximum substring length so far
		int maxlensf=0;
		//to get window start and end =0
		//bccbababd
		
		for(int start=0,end=0;end<str.length();end++)
		{
			
			char ch=str.charAt(end);
			
			if(map.containsKey(ch))
			{
				map.put(ch, map.get(ch)+1);
				
			}
			else
			{
				map.put(ch, 1);
			}
			
			
			if(map.size()>k)
			{
				int old=map.get(str.charAt(start))-1;
				if(old==0)
					map.remove(str.charAt(start));
				else
				{
				map.put(str.charAt(start),map.get(str.charAt(start))-1);
				}
				start++;

			}
			
			if(maxlensf<(end-start+1))
				maxlensf=end-start+1;
		}
		
		System.out.println(map);
		return maxlensf;
		
		
	}
	
	
	//another approach using sliding window
	
	
	public int longestkSubstr(String str, int k) {

		// Map to store unique characters
		if (str.length() < k)
			return -1;
		HashMap<Character, Integer> map = new HashMap<>();

		// maxlen to store the maximum substring length so far
		int maxlensf = 0;
		// to get window start and end =0
		// bccbababd
		int start = 0, end = 0;
		for (; end < str.length();) {
			char ch = str.charAt(end);

			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}

			if (map.size() < k) {
				end++;
			} else if (map.size() == k) {
				if (maxlensf < (end - start + 1))
					maxlensf = end - start + 1;

				end++;
			} else if (map.size() > k) {
				while (map.size() > k) {
					int old = map.get(str.charAt(start)) - 1;
					;
					map.put(str.charAt(start), old);
					if (old == 0)
						map.remove(str.charAt(start));
					start++;

				}
				end++;

			}

		}
		// return map.size()==k?maxlensf:-1;
		return map.size() == k ? maxlensf : -1;

	}

	/*
	 * Longest Substring With no repeating Characters
	 * time:O(n) space: O(n) for hashmap
	 */
	
	static int longestSubtrNoRepeatingChararacters(String str) {
		// Map to store unique characters

		if (str.length() <= 0)
			return -1;

		HashMap<Character, Integer> map = new HashMap<>();

		// maxlen to store the maximum substring length so far
		int maxlensf = 0;
		// to get window start and end =0
		// bccbababd
		int start = 0, end = 0;
		for (; end < str.length();) {

			char ch = str.charAt(end);

			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);

			} else {
				map.put(ch, 1);
			}
			int len = end - start + 1;

			if (map.size() == len) {

				if (maxlensf < len)
					maxlensf = len;
				end++;
			} else if (map.size() < len) {

				while (ch != str.charAt(start)) {

					map.remove(str.charAt(start));
					start++;

				}
				start++;
				end++;

			}

		}
		//copy hashmap
		//Set<Entry<Character, Integer>> entries = map.entrySet();
//HashMap<Character, Integer> m = (HashMap<Character, Integer>) entries.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		return maxlensf;
	}
	
	/*
	 * https://leetcode.com/problems/minimum-window-substring/
	 * important sliding window problem
	 */
	public String minWindow(String str, String p) {
		// Base condition
		if (str.length() <= 0 || p.length() <= 0)
			return "";

		boolean b = false;
		HashMap<Character, Integer> map = new HashMap<>();
		String ans = str;
		int start = 0, end = 0;

		int len = Integer.MAX_VALUE;

		// store the map
		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);

			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);

			} else {
				map.put(ch, 1);
			}

		}

		int count = map.size();

		for (; end < str.length(); end++) {
			char ch = str.charAt(end);

			// if count >=0

			if (count > 0) {

				if (map.containsKey(ch)) {
					int old = map.get(ch) - 1;
					if (old == 0) {
						count--;
					}
					map.put(ch, old);
				}

			}

			// System.out.println(ch+" "+map+" count "+count);

			if (count == 0) {
				/*
				 * if((end-start)<(ei-si)) { si=start; ei=end; }
				 */

				b = true;
				// need to optimize the window
				// ei=end;

				while (count <= 0 && start <= end) {

					// if((end-start+1)<len)
					// len=end-start+1;

					ans = ans.length() > str.substring(start, end + 1).length() ? str.substring(start, end + 1) : ans;
					// ei=end;

					char chh = str.charAt(start++);

					if (map.containsKey(chh)) {
						int old = map.get(chh);
						map.put(chh, old + 1);
						if (map.get(chh) > 0)
							count = map.get(chh);
					}

				}

				// count=map.size();
			}

			/*
			 * if(isp(map,p)) {
			 * 
			 * while(isp(map,p)==true) { int old=map.get(str.charAt(start))-1; if(old==0)
			 * map.remove(str.charAt(start)); else map.put(str.charAt(start),old);
			 * 
			 * start++;
			 * 
			 * }
			 * 
			 * start--; map.put(str.charAt(start),1);
			 * 
			 * //end++; int len=ans.length();
			 * 
			 * if(len>str.substring(start,end+1).length()) { ans=str.substring(start,end+1);
			 * }
			 * 
			 * 
			 * 
			 * 
			 * end++; } else end++;
			 */

			// System.out.println(map);

		}
		/*
		 * //return map.size()==k?maxlensf:-1;
		 * 
		 * // System.out.println(ss+" "+ee); int count=0; for(int
		 * i=0;i<ans.length();i++) { if(map.containsKey(ans.charAt(i))) {
		 * count+=map.get(ans.charAt(i)); map.remove(ans.charAt(i)); } }
		 */

		// System.out.println(" Ans "+ans);
		return !b ? "" : ans;
		// return !ans.equals("rretergrgrgrgrgrgrgr")?ans:"-1";
	}
	
	/*
	 * Kartik Bhaiya has a string consisting of only 'a' and 'b' as the characters. Kartik Bhaiya describes perfectness
	 *  of a string as the maximum length substring of equal characters. Kartik Bhaiya is given a number k 
	 *  which denotes the maximum number of characters he can change. Find the maximum perfectness 
	 *  he can generate by changing no more than k characters.
	Input Format
			The first line contains an integer denoting the value of K. The next line contains a string having only ‘a’ and ‘b’ as the characters.
	 * 
	 */
	 public static void substringab (String args[]) {
			Scanner sc=new Scanner(System.in);

			int n=sc.nextInt();
			sc.nextLine();
			String str=sc.nextLine();

			//System.out.println(Math.max(findsubs(str,n,'a'),findsubs(str,n,'b')));
			//System.out.println(Math.max(findsubs(str,n,'a'),findsubs(str,n,'b')));


			//Sliding window approach
			int[] ch=new int[]{0,0};
			int start=0,ans=0,k=n;
			for(int end=0;end<str.length();end++)
			{

				int c=str.charAt(end);

				
				ch[c-'a']++;
				//constraints
				if(Math.min(ch[0],ch[1])>k)
				{
					ch[str.charAt(start)-'a']--;
					start++;
				}
				else ans++;


			}
			System.out.println(ans);

		}
	 
	 /*
	  * Longest Palindromic substring
	  */
	public String longestPalindromee(String str, int start, int end, String[][] strg) {

		String ans = "";

		String anss = "";
		if (start == end)
			return str.substring(start, end + 1);

		if (start > end)
			return "";

		if (strg[start][end] != null)
			return strg[start][end];

		int len = end - start - 1;
		if (str.charAt(start) == str.charAt(end)) {
			if (len == longestPalindromee(str, start + 1, end - 1, strg).length()) {
				strg[start][end] = str.substring(start, end + 1);
				return strg[start][end];
			}
		}

		String l = longestPalindromee(str, start, end - 1, strg);
		String rr = longestPalindromee(str, start + 1, end, strg);

		if (l.length() > rr.length())
			ans = l;
		else
			ans = rr;

		
		strg[start][end] = ans;
		return ans;

	}
	
	/*
	 * String to Integer (atoi)
	 */
	
	   public static int myAtoi(String s) {

	        HashSet<String> set=new HashSet<>();
	        for(int i=0;i<10;i++)
	            set.add(String.valueOf(i));
	        //remove spaces
	        s=s.trim();
	        
	        if(s.length()==0)
	            return 0;
	        
	        boolean issign=s.charAt(0)=='-' || s.charAt(0)=='+'?true:false;
	        
	        int i=0;
	        if(issign)
	            i++;
	        String ans="";
	        
	        //remove leading 0's
	        while(i<s.length() && s.charAt(i)=='0')
	        {
	            i++;
	        }
	      
	        while(i<s.length() && s.charAt(i)!=' ' && set.contains(s.charAt(i)+""))
	        {
	            ans+=s.charAt(i++);
	            
	            
	        }
	        
	        if(ans.length()==0)
	            return 0;
	        
	        long a=0;
	
	        if(issign && s.charAt(0)=='-')
	        {
	        	
	        	
	        		if(ans.length()>=19)
		               return Integer.MIN_VALUE;
	        	
	        		  a=Long.valueOf(s.charAt(0)+ans);
	   	            if(a<Integer.MIN_VALUE)
	   	             {
	   	            return Integer.MIN_VALUE;
	   	            }	
	   	         else
		             return Integer.valueOf(s.charAt(0)+ans);
	        	
	        
	            
	      
	        }
	        else
	        {
	        		
	         
	        		  if(ans.length()>=19)
	  	                return Integer.MAX_VALUE;
	  	            a=Long.valueOf(ans);
	  	            if(a>Integer.MAX_VALUE)
	  	           return Integer.MAX_VALUE;
	  	            else
	  	            return Integer.valueOf(ans);
	             
	        	
	    
	        	
	        	
	        }
	   }
	   
	   /*
	    * Regular Expression matching
	    * "." and "*"
	    * 
	    */
	   public static  boolean isMatch(String s, String p,int i,int j) {
           // System.out.println(svidx+" "+pvidx);
   
   if(j==p.length())
       return i==s.length();
   
   
   if(j+1<p.length() && p.charAt(j+1)=='*')
   {
	   //2 * conditions 1) empty 2)multiple character matching
       if(isMatch(s,p,i,j+2) || (i<s.length() && (p.charAt(j)=='.' || s.charAt(i)==p.charAt(j) ) && isMatch(s,p,i+1,j)))
           return true;
       
       
       
   }
   else if(i<s.length() && s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')
       return isMatch(s,p,i+1,j+1);

      return false;
  }
}
