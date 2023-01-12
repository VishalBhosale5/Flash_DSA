package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

public class LearnRecursion {
static int getBorderPathCount=0;
	//principle of mathematical induction
	// my function worked before writing my function definition
	// when a function call itself again and again
	// to do work 2 chances 
	//1)while building stack 
	//2) while removing stack function


	//print number in decreasing order
	public static void printnums(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		printnums(n - 1);
	}

	//tail recursion : when call is completed till function end then it will automatically remove remaining function from stack.

	
	// doing work while removing stack
	//print number in ascending order
	public static void printnumsinc(int n) {
		if (n == 0)
			return;

		printnumsinc(n - 1);
		System.out.println(n);
	}

	
	
	// print numbers in increasing and decreasing order
	public static void PDI(int n) {
		if (n == 0)
			return;
		
		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);
	}

	
	
		//print numbers by skipping even and then odd
	//if we have given any number and asked to print pattern  if pattern has 2 types then while building stack do 1 pattern and while removing function from stack do another pattern
	public static void PDISkip(int n) {
		if (n == 0)
			return;
		
		if (n % 2 != 0)
			System.out.println(n);
		
		PDISkip(n - 1);
		
		if (n % 2 == 0)
			System.out.println(n);
	}

	// factorial of a number
	public static int fact(int n) {
		if (n == 0)
			return 1;

		return n * fact(n - 1);
	}

	// calculate power of number O(power)
	public static int power(int n, int power) {
		System.out.println(power);
		if (power == 0)
			return 1;

		return n * power(n, power - 1);
	}
	
	//logn solution of power
	// x^n=x^n/2 * x^n/2 
	//GP series ar^n-1
	// calculate power of number
		public static int powerLogrithmic(int n, int power) {
				System.out.println("--");
			if (power == 0)
				return 1;

			int xnp=powerLogrithmic(n,power/2);
			
			int xn=xnp*xnp;
			
			if(power%2==1)
				xn=xn*n;
			
			return xn;
		}

	// calculate fibonacci
	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fib(n - 1) + fib(n - 2);
	}

	// is Array sorted
	public static boolean isArraySorted(int[] ar, int ck) {

		System.out.println(ck);
		if (ck == ar.length - 1)
			return true;

		if (ar[ck] > ar[ck + 1])
			return false;
		else
			return isArraySorted(ar, ck + 1); // do not use ck++ otherwise 0 value will be passed everytime and
												// stackoverflow error

	}

	// search element in an array
	// find first occurance in an array of NUMBER.

	public static int findinArray(int[] ar, int i, int data) {

		if (i == ar.length)
			return -1;

		if (ar[i] == data)
			return i;
		else
			return findinArray(ar, i + 1, data);
	}

	// find lastindex of an element by starting searching from index 0

	public static int lastindex(int[] ar, int si, int data) {

		if (si == ar.length) {
			return -1;
		}

		
		/*lastindex(ar, si+1, data);
		
		if(ar[si]==data)
		{
			System.out.println(si);
			return;
		}*/
	
		int index = lastindex(ar, si + 1, data);
		if (index == -1) {
			if (ar[si] == data)
				return si;
			else
				return -1;
		} else
			return index;

	}

	// print star pattern
	//hard to understand
	public static void print(int N, int row, int col) {
		if (row > N)
			return;

		if (col > row) {
			System.out.println();
			print(N, row + 1, 1);
			return;
		}

		System.out.print("*");
		print(N, row, col + 1);

	}
	
	
	
	
	//recursiove soln of bubble sort
	public static void bubblesort(int[] ar,int si,int li)
	{
		if(li==0)
			return;
	
		if(si==li)
		{
			bubblesort(ar, 0, li-1);
			return;
		}
		
		if(ar[si]>ar[si+1])
		{
			int temp=ar[si];
			ar[si]=ar[si+1];
			ar[si+1]=temp;
		}
		
		bubblesort(ar, si+1, li);
		
		
	}
	
	
	//find an return all the indices of any element
	
	public static int[] AllIndices(int[] ar,int si,int data,int count)
	{
		
		
		if(si==ar.length)
		{
			int[] base=new int[count];
			return base;
		}
		int[] indices=null;
		
		if(ar[si]==data)
		{
			indices=AllIndices(ar, si+1, data, count+1);
			
		}
		else
			indices=AllIndices(ar, si+1, data, count);
		
		
		if(ar[si]==data)
		indices[count]=si;
		
		
		return indices;
		
	
	}
	
	
	
	
	
	
	

	
	
	//Get all the subsequences of a string
	//relative order of characters should be maintained in subsequences
	//A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
	//(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
	//bac == abc  means {abc,bac} is permutation not combination so make sure. 2^n sequences can be generted
	// to solve this problem first think that getSeq() is already works means it returns subsequences of bc= ["",b,c,"bc"] 
	//now to make result of abc think what we need to do
	//a* foreach["",b,c,"bc"] == [" ",b,c,bc,a,ab,ac,abc] total 2^n
	
		public static ArrayList<String> getseq(String str)
		{
			
			if(str.length()==0)
			{
				
				
				ArrayList<String> baseresult=new ArrayList<>();
				baseresult.add(" ");
				return baseresult;
			}
			
			
			
			char cc=str.charAt(0);
			String ros=str.substring(1);
			ArrayList<String> recResult=getseq(ros);
			ArrayList<String> myres=new ArrayList<>();
			
			for(int i=0;i<recResult.size();i++)
			{
				
				
				myres.add(recResult.get(i));
				myres.add(cc+recResult.get(i));
			}
			return myres;
			
		}
		
		
		
		
		
		//another approach to print subssequences but this time not storing in arraylist
		//in this approach we will add the first character in the result or not add
		public static void printSequences(String str,String res)
		{
			
			
			if(str.length()==0)
			{
				System.out.println(res);
				return;
			}
			
			
			char cc=str.charAt(0);
			String ros=str.substring(1);
			//not add
			printSequences(ros, res);
			//add
			printSequences(ros, res+cc);
		}
		
		
		
		
				//to solve this problem first think it is working for smaller problem bc =bc,cb then to mke result of abc
				//=put a in every position of bc,cb > abc,bac,cba,acb,cab,cba
					//get all permutation n! permutations
				public static ArrayList<String> getPer(String str)
				{
					
					if(str.length()==0)
					{
						ArrayList<String> baserec=new ArrayList<>();
						baserec.add("");
						return baserec;
					}
					
					char c=str.charAt(0);
					String ros=str.substring(1);
					ArrayList<String> recresult=getPer(ros);
					ArrayList<String> myres=new ArrayList<>();
					
					
					
					for(String ss:recresult)
					{
						for(int i=0;i<=ss.length();i++)
						{
						String val=ss.substring(0,i)+c+ss.substring(i);   //logic to add at i th position
						myres.add(val);
						}
					}
					return myres;
					
				}
				
				
				
				
				// above question with another approach
				
				public static void printPermutation(String str,String res)
				{
					if(str.length()==0)
					{
						System.out.println(res);
						return;
					}
					
					
					for(int i=0;i<str.length();i++)
					{
						char ch=str.charAt(i);
						String roq=str.substring(0,i)+str.substring(i+1);
						printPermutation(roq, res+ch);
					}
				}
				
				
				//test
				public static void boardptt(int curr,int d,String psf)
				{
					if(curr==d)
					{
						System.out.println(psf);
						return ;
					}
					
					
					
					for(int i=1;i<=6;i++)
					{
						if(curr+i<=d)
							boardptt(curr+i, d, psf+i);
					}
					
					
				}
				
				
				
				
				
				//get board path dice
				//bigger problem is to go from 0 to 10 the think of smaller problem as to where we can go 
				//from 0 it [1,2,3,4,5,6]   then these are our smaller problems 
				//lets suppose we are at 1 then it will return [111111111,212121...]
				//to make the result of bigger problem we need to add current [1] to above list so =[1111111111,2121211] which are the paths from 0 to 10
				
				public static ArrayList<String> getBoardPath(int curr,int end)
				{
					//System.out.println("call "+curr+" "+end);
					
					if(curr==end)
					{
						ArrayList<String> base=new ArrayList<>();
						base.add("");
						return base;
					}
					
					if(curr>end)
					{
						ArrayList<String> base=new ArrayList<>();
							return base;
					}
					
					ArrayList<String> myres=new ArrayList<>();

					for(int dice=1;dice<=6;dice++)
					{
						ArrayList<String> rr=getBoardPath(curr+dice, end);
						
						
						
						for(String rrs:rr)
						{
							//System.out.println(dice+" "+rrs);
							myres.add(dice+rrs);
						}
					}
					
					return myres;
				}
				
				
				//print board path above problem with another approach
				
				
				public static void printBoardPth(int curr,String ans,int target)
				{
					
					if(curr==target)
					{
						System.out.println(ans);
						//getBorderPathCount++;
						return;
					}
					
					if(curr>target)
						return;
					
					for(int dice=1;dice<=6;dice++)
					{
						printBoardPth(curr+dice, ans+dice, target);
					}
				}
				
	
				
				
				
				
				
				
				
				
				
				
		//get maze path RAT question
		public static ArrayList<String> getMazePath(int cr,int cc,int er,int ec)
		{
			
			
			if(cr==ec && cc==ec)
			{
				ArrayList<String> base=new ArrayList<>();
				base.add("");
				return base;
			}
			
			
			if(cr>er || cc>ec)
			{
				ArrayList<String> base=new ArrayList<>();
				return base;
			}
			
			ArrayList<String> myres=new ArrayList<>();
			ArrayList<String> rr=getMazePath(cr, cc+1, er, ec);
			for(String rrsH:rr)
			{
				myres.add("H"+rrsH);
			}
			
			ArrayList<String> rrr=getMazePath(cr+1, cc, er, ec);
			for(String rrsV:rrr)
			{
				myres.add("V"+rrsV);
			}
			return myres;
		}
		
		//print maze path RAT question above question with another approach
		public static void printMazePath(int cr,int cc,int er,int ec,String ans)
		{
			
			
			if(cr==ec && cc==ec)
			{
				System.out.println(ans);
				return ;
			}
			
			
			if(cr>er || cc>ec)
			{
				return;
			}
			
			printMazePath(cr, cc+1, er, ec,ans+"H");
			
			printMazePath(cr+1, cc, er, ec,ans+"V");
			
			
		}
		
		//get count of paths maze path RAT question above question with another approach 
		public static int CountMazePath(int cr,int cc,int er,int ec)
		{
			
			
			if(cr==ec && cc==ec)
			{
				
				return 1;
			}
			
			
			if(cr>er || cc>ec)
			{
				return 0;
			}
			
			int hc=CountMazePath(cr, cc+1, er, ec);
			
			int vc=CountMazePath(cr+1, cc, er, ec);
			
			return hc+vc;
			
			
		}
		//get maza path with diagonal
		
		public static ArrayList<String> getMazePathD(int cr,int cc,int er,int ec)
		{
			
			
			if(cr==ec && cc==ec)
			{
				ArrayList<String> base=new ArrayList<>();
				base.add("");
				return base;
			}
			
			
			if(cr>er || cc>ec)
			{
				ArrayList<String> base=new ArrayList<>();
				return base;
			}
			
			ArrayList<String> myres=new ArrayList<>();
			ArrayList<String> rr=getMazePathD(cr, cc+1, er, ec);
			for(String rrsH:rr)
			{
				myres.add("H"+rrsH);
			}
			
			ArrayList<String> rrr=getMazePathD(cr+1, cc, er, ec);
			for(String rrsV:rrr)
			{
				myres.add("V"+rrsV);
			}
			
			ArrayList<String> rrrr=getMazePathD(cr+1, cc+1, er, ec);
			for(String rrsV:rrrr)
			{
				myres.add("D"+rrsV);
			}
			return myres;
		}
		
		
		
		//print maze path diagonal RAT question above question with another approach
				public static void printMazePathD(int cr,int cc,int er,int ec,String ans)
				{
					
					
					if(cr==ec && cc==ec)
					{
						System.out.println(ans);
						return ;
					}
					
					
					if(cr>er || cc>ec)
					{
						return;
					}
					
					printMazePathD(cr, cc+1, er, ec,ans+"H");
					
					printMazePathD(cr+1, cc, er, ec,ans+"V");
					printMazePathD(cr+1, cc+1, er, ec,ans+"D");
					
				}
				
				


				//test
	//vsisted array to remove the cyclic dependancy deadlock
	//in recursion problem input should be reduced f(n){ f(n) } is not good because it will led to infinite recursion
	//f(n){ f(n-1)}  problem should be reduced in every call
	public static void blockedmaze(int[][] maze,int row,int col,String ans,boolean visited[][])
	{
			if(row==maze.length-1 && col==maze[0].length-1)
			{
				System.out.println(ans);
				return;
			}
		if(row<0 || row>= maze.length || col<0 || col>=maze[0].length || visited[row][col] || maze[row][col]==1)
			return;

	//H
		visited[row][col]=true;
		blockedmaze(maze,row,col+1,ans+"R",visited);
		blockedmaze(maze,row+1,col,ans+"D",visited);

		blockedmaze(maze,row,col-1,ans+"L",visited);
		blockedmaze(maze,row-1,col,ans+"T",visited);
		visited[row][col]=false;


	}
	public static void blockedmazet(int[][] maze,int row,int col,String ans)
	{
		if(row==maze.length-1 && col==maze[0].length-1)
		{
			System.out.println(ans);
			return;
		}
		if(row<0 || row>= maze.length || col<0 || col>=maze[0].length || maze[row][col]==-1 || maze[row][col]==1)
			return;

		//H
		int temp=maze[row][col];
		maze[row][col]=-1;
		blockedmazet(maze,row,col+1,ans+"R");
		blockedmazet(maze,row+1,col,ans+"D");

		blockedmazet(maze,row,col-1,ans+"L");
		blockedmazet(maze,row-1,col,ans+"T");
		maze[row][col]=temp;


	}














				
				//blockedMazePath
				
				public static void BlockedMazePath(int[][] maze,int row,int col,String ans,boolean[][] visited)
				{
					
					if(row==maze.length-1 && col==maze[0].length-1)
					{
						System.out.println(ans);
						return;
					}
					
					
					if(row==-1 || row==maze.length || col==-1 || col==maze[0].length || maze[row][col]==1 || visited[row][col])
					{
						return;
					}
					
					
					visited[row][col]=true;
					//top
					BlockedMazePath(maze, row-1, col, ans+"T", visited);
					//left
					BlockedMazePath(maze, row, col-1, ans+"L", visited);
					
					//right
					BlockedMazePath(maze, row, col+1, ans+"R", visited);
					
					//down
					
					BlockedMazePath(maze, row+1, col, ans+"D", visited);
					
					visited[row][col]=false;
					
					
					
				}
				
				
				
				//test
				public static int NQueenproblems(boolean board[][],int row,int col)
				{
					
					if(row==board.length)
						return 1;
					
				int count=0;
					col=0;
					while(col<board[row].length)
					{
					if(isSafe(board,row, col))
					{
						board[row][col]=true;
						
						count+=NQueenproblems(board, row+1, col);
						board[row][col]=false;

					}
					col++;
					}
						
					return count;
				}
				
				public static  boolean isSafe(boolean[][] board,int row,int col)
				{
					
					/*for(int i=col;i>=0;i--)
					{
						if(board[row][i])
							return false;
					}*/
					for(int i=row;i>=0;i--)
					{
						if(board[i][col])
							return false;
					}
					int r=row,c=col;
					while(r>=0 && c>=0)
					{
						if(board[r--][c--])
							return false;
					}
					
					r=row;
					c=col;
					
					while(r>=0 && c<board[0].length)
					{
						if(board[r--][c++])
							return false;
						
					}
					
					return true;
					
				}
				
				
				
				
				
				
				
				//NQueen problem 
				//return no of ways we can put queen on nXn board without killing any queen
				
				//at each row try placing queen and then delegate to next row also backtrack to try  each cell in a row
				
				public static int NQueenProblem(boolean[][] board,int row)
				{
					
					
					if(row==board.length)
						return 1;
					
					
					int count=0;
					
					
					for(int col=0;col<board[row].length;col++)
					{
						if(isItSafe(board,row,col))
						{
							board[row][col]=true;
							count+=NQueenProblem(board, row+1);
							board[row][col]=false;

						}
					}
					return count;
				}
				
				
				//above problem with another approach to print
				public static void printNQueenProblem(boolean[][] board,int row,String ans)
				{
					
					
					if(row==board.length)
					{
						System.out.println(ans);
						return;
					}
					
					
			
					
					
					for(int col=0;col<board[row].length;col++)
					{
						if(isItSafe(board,row,col))
						{
							board[row][col]=true;
							printNQueenProblem(board, row+1,ans+"{"+(row+1)+"-"+(col+1)+"}");
							board[row][col]=false;

						}
					}
					
				}

				private static boolean isItSafe(boolean[][] board, int row, int col) {
					// TODO Auto-generated method stub
					
					for(int i=row;i>=0;i--)
					{
						if(board[i][col])
							return false;
					}
					
					for(int i=row,j=col;i>=0 && j>=0 ;i--,j--)
					{
						if(board[i][j])
							return false;
					}
					for(int i=row,j=col;i>=0 && j<board.length;i--,j++)
					{
						if(board[i][j])
							return false;
					}
					
					
					return true;
				}

				//codingblocks challenges

             	/*
             	Smart Keypad 1
             You will be given a numeric string S. Print all the possible codes for S.Following vector contains the codes corresponding to the digits mapped.
			string table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };
			For example, string corresponding to 0 is " " and 1 is ".+@$"
			Input Format: A single string containing numbers only.
			Constraints :length of string <= 10
				Output Format: All possible codes one per line in the following order.

					The letter that appears first in the code should come first


			Scanner sc=new Scanner(System.in);

			String str=sc.nextLine();
			String table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };

			printkp(table,str,0,"");

			*/
		public static void printkp(String[] table,String str,int idx,String asf)
		{

			if(idx==str.length())
			{
				System.out.println(asf);
				return ;
			}
			int j=Integer.valueOf(str.charAt(idx)+"");
			for(int i=0;i<table[j].length();i++)
			{

				printkp(table,str,idx+1,asf+table[j].charAt(i));
			}

		}

			/*
			Subset Sum
			Mike is a very passionate about sets. Lately, he is busy solving one of the problems on sets. He has to find whether if the sum of any of the non-empty subsets of the set A is zero.
			Input Format: The first line contains an integer T, which is the total number of test cases.
T test cases follow.
Each test case consists of two lines.
The first line consists of a single integer N, which is the number of elements present in the set A.
The second line contains N space separated integers denoting the elements of the set A.
Output Format
Print the answer for each testcase in a new line.
If the sum of any of the subset is zero, then print “Yes” (without quotes) else print “No”(without quotes).


			Scanner sc=new Scanner(System.in);

			int n=sc.nextInt();



			for(int j=0;j<n;j++)
			{
				int nn=sc.nextInt();

				int[] ar=new int[nn];

				for(int i=0;i<nn;i++)
					ar[i]=sc.nextInt();
				ArrayList<Integer> l=new ArrayList<>();
				//isZeroSubSet(ar);
				if(isZeroSubSet(ar))
					System.out.println("Yes");
				else
					System.out.println("No");

			}

		}
*/
		//isZeroSubset problem already coded below

/*

0000
0001   -3                1000 & 1000
0010    2
0011    2 -3    0011 & 1000  0   0110  0 1100
0100    3
0101    3 -3
0110    3 2
0111    3 2 -3
1000    1
1001    1 -3
1010    1 2
1011    1 2 -3
1100    1 3
1101    1 3 -3
1110    1 3 2
1111    1 3 2 -3
*/



/*


Keypad codes
Take as input str, a string. str represents keys pressed on a nokia phone keypad. We are concerned with all possible words that can be written with the pressed keys.

Assume the following alphabets on the keys: 1 -> abc , 2 -> def , 3 -> ghi , 4 -> jkl , 5 -> mno , 6 -> pqrs , 7 -> tuv , 8 -> wx , 9 -> yz

E.g. “12” can produce following words “ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf”

a. Write a recursive function which returns the count of words for a given keypad string. Print the value returned.

b.Write a recursive function which prints all possible words for a given keypad string (void is the return type for function).

Input Format
Single line input containing a single integer.

Constraints
1 <= Length of string <= 10^3

Output Format
Print all the words in a space separated manner. Also print the count of these numbers in next line.

			Scanner sc=new Scanner(System.in);

			String str=sc.nextLine();
			String table[] = { "", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wx" ,"yz" };

			printkp(table,str,0,"");
			System.out.println("\n"+ct);

		*/



		public static void printkpp(String[] table,String str,int idx,String asf)
		{

			if(idx==str.length())
			{
				System.out.print(asf+" ");
				//ct++;
				return ;
			}
			int j=Integer.valueOf(str.charAt(idx)+"");
			for(int i=0;i<table[j].length();i++)
			{

				printkpp(table,str,idx+1,asf+table[j].charAt(i));
			}




		}

		/*

		Sudoku solver

		ou are given an N*N sudoku grid (N is a multiple of 3). Solve the sudoku and print the solution.
To learn more about sudoku, go to this link Sudoku-Wikipedia.

Input Format
First line contains a single integer N. Next N lines contains N integers each, where jth integer int ith line denotes the value at ith row and jth column in sudoku grid. This value is 0, if the cell is empty.

Constraints
N=9 Solution exists for input matrix.

Output Format
Print N lines containing N integers each, where jth integer int ith line denotes the value at ith row and jth column in sudoku grid, such that all cells are filled.

			Scanner sc=new Scanner(System.in);
			int grid=sc.nextInt();
			int[][] sb=new int[grid][grid];
			for(int i=0;i<grid;i++)
				for(int j=0;j<grid;j++)
					sb[i][j]=sc.nextInt();


			sudokuSolve(sb,0,0);
			//for(int[] s:sb)
			//System.out.println(Arrays.toString(s));
		*/

		public static void sudokuSolve(int[][] board,int row,int col)
		{
//System.out.println(row+" "+col);

//for(int[] s:board)
			//	System.out.println(Arrays.toString(s));

//System.out.println("----------------");


			if(col==board.length)
			{
				//	System.out.println("----------------");
				row++;
				col=0;
			}

			if(row==board.length)
			{
				//	System.out.println("---------------$-");

				for(int[] s:board)
				{
					for(int a:s)
						System.out.print(a+" ");
					System.out.println();
				}

				return;
			}

			if(board[row][col]==0)
			{
				for(int i=1;i<=9;i++)
				{

					if(isItSafe(board,row,col,i))
					{
						board[row][col]=i;
						sudokuSolve(board,row,col+1);


					}
					board[row][col]=0;
				}



			}
			else
				sudokuSolve(board,row,col+1);



		}

		public static boolean isItSafe(int[][] board,int r,int c,int val)
		{
			//row check
			int[] cl={0,3,6,9,12,15,18,21};
			int rr=r;
			int col=c;

			rr=0;
			for(;rr<board.length;rr++)
			{
				if(board[rr][col]==val)
				{
					return false;
				}
			}
			//column
			rr=r;
			col=0;
			for(;col<board.length;col++)
			{
				if(board[rr][col]==val)
					return false;
			}


			//inside block
			int rb=(r/3)+1;
			int cb=(c/3)+1;

			for(int i=cl[rb-1];i<(cl[rb-1]+3);i++)
			{
				for(int j=cl[cb-1];j<(cl[cb-1]+3);j++)
				{


					try
					{
						if(board[i][j]==val)
							return false;
					}
					catch(Exception e)
					{
						System.out.println(i+" "+j);
					}
				}

			}
			return true;

		}






	public static void main(String[] args) {
					// TODO Auto-generated method stub
					// printnums(5);
					//printnumsinc(5);
					//PDI(5);
					 //PDISkip(5);
					//System.out.println(fact(4));
					//System.out.println(power(2,3));
					//System.out.println(fib(5));
					// System.out.println(isArraySorted(new int[] {1,2,3,4,5,2},0));
					//System.out.println(findinArray(new int[] {1,2,3,4,6,5},0,3));
					//System.out.println(lastindex(new int[] {1,2,7,3,4,6,5,6,7,9},0,7));
					//print(5,1, 1);
					//int []ar=new int[]{5,4,3,2,1};
					//bubblesort(ar, 0, ar.length-1);
					//System.out.println(Arrays.toString(ar));
					//System.out.println(Arrays.toString(AllIndices(new int[] {8, 8, 8, 8,5,8},0,8,0)));
					
					//System.out.println(getseq("abc"));
						//printSequences("abc", "");
						//String s="s";
					//System.out.println(getPer("abc"));
					//printPermutation("abc", "");
					//System.out.println(getBoardPath(0, 3));
					//printBoardPth(0, "", 10);
					//System.out.println(getBorderPathCount);
					//System.out.println(getMazePath(0, 0, 2, 2));
					//printMazePathD(0, 0, 2, 2, "");
					//System.out.println(getMazePathD(0, 0, 2, 2));
					//printMazePath(0, 0, 2, 2, "");
					int[][] maze= {{0,1,0,0},{0,0,0,0},{0,1,0,0},{0,0,1,0}};
					//BlockedMazePath(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
					//System.out.println(CountMazePath(0, 0, 2, 2));
					//boolean[][] board=new boolean[4][4];
						//System.out.println(NQueenProblem(board, 0));
					//printNQueenProblem(board, 0, "");
					//int[] ar= {10,15,5,6,-9,86,55};
					
					//System.out.println(Arrays.toString(mergeSort(ar, 0, ar.length-1)));
					
					//quickSort(ar, 0, ar.length-1);
					
					//System.out.println(Arrays.toString(ar));
					
					
					
					//-------------Backtracking-----------------
					
					
					//QueenPermutation(new boolean[4], 0, 2, "");
					//QueenCombination(new boolean[4], 0, 2, "", -1);
					//queenCombinationPerspectiveBox(new boolean[4], 0, 0, 2, "");
					//QueenCombinationBoxPerspective2D(new boolean[2][2], 0, 0, 0, 2, "");
					//QueenCombinationBoxPerspective2DRecCall(new boolean[2][2], 0, 0, 0, 2, "");
					//QueenCombinationBoxPerspective2DKill(new boolean[3][4], 0, 0, 0, 3, "");
					//CoinChange(new int[] {2,3,5,6}, 10, "", 0);
					//CoinChangeP(new int[] {2, 3, 5,6},10,"");
					//CoinChangeCoinRespect(new int[] {1, 2, 3}, 0,4,"");
					//NKnight(new boolean[3][3], 0, 0, 0, 3, "");
					//NQueen2(new boolean[4][4], 0, 0, 4, "");
					//KQueen(new boolean[4][4], 0, 0, 3, "");
					//System.out.println(power(2,9));
					//System.out.println(powerLogrithmic(2, 9));
					//System.out.println(Arrays.toString(AllIndices(new int[] {7,2,3,7,6,5,6,7,5}, 0,7, 0)));
					//System.out.println(getseq("abc"));
				//System.out.println(getBoardPath(0, 10));
				//boardptt(0, 10, "");
					//System.out.println(getMazePath(0, 0, 2, 2));
					//mazepath(0, 0, 2, 2, "");
					//System.out.println(NQueenproblems(new boolean[6][6], 0, 0));
					//System.out.println(NQueenProblem(new boolean[6][6], 0));
						//printSequences("abc", "");
				//	QueenCombination(new boolean[4], 0, 2, "",-1);
					//CoinChangeP(new int[] {2,3,5,6}, 10, "");
					//queenCombinationPerspectiveBox(new boolean[4],0,0,2,"");
					//queencombination2t(new boolean[2][2], 0, 0, 0, 2, "");
					//QueenCombinationBoxPerspective2D(new boolean[2][2], 0, 0, 0, 2, "");
					//QueenCombinationBoxPerspective2DKill(new boolean[4][4],0,0,0,4,"");
					//NQueen2(new boolean[4][4],0,0,4,"");
					blockedmazet(maze,0,0,"");

	}



//--------------Backtracking-----------------------
//3 tunnels to find gold
//wear green cap and go to tunnel 1 if gold not found then comeback and remove greencap(backtrack) undo and wear blue cap and go to tunnel to ....so on until gold found
// 4 places and 2 queen hence 4P2=4!/2!=12 ways   npr =r elements in n places
				//ncr  picking r things from n things
				
				//permutation  ab and ba are different   {ab,ba} valid permutations
				//combination/sequences ab=ba   {ab,ba}  invalid combinations
				
				//select 2 boxes out of 4 boxes and then place 2 queens in those 2 boxes = 4C2.2!=4P2=12
static int count=0;
public static void QueenPermutation(boolean[] board,int qpsf,int tq,String ans)
{
	if(qpsf==tq)
	{
		count++;
		System.out.println(count+"."+ans);
		return ;
	}


	
	
	for(int i=0;i<board.length;i++)
	{
		
		if(board[i]==false)
		{
		board[i]=true;
		
		QueenPermutation(board, qpsf+1, tq, ans+"b"+i+"q"+qpsf+" ");
		board[i]=false;  //backtrack  undo changes 	
		}
		
	}






}
			//Queen combination nCr
	public static void QueenCombination(boolean[] board, int qpsf, int tq, String ans,int lastBoxUsed) {
		if (qpsf == tq) {
			count++;
			System.out.println(count + "." + ans);
			return ;
		}

		for (int i = lastBoxUsed+1; i < board.length; i++) {

			if (board[i] == false) {   //this condition is no more required
				board[i] = true;

				QueenCombination(board, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ",i);
				board[i] = false; // backtrack undo changes
			}

		}

	}
	
	
	
	
	//queencombination above question with another approach
	//in this approach we are thinking from box perspective
	//either box have queen or not have
	//backtracking
	/*
	1)implicity undoing (asf)
	2)explicit undoing (board[col]=true and then false after completing the call)
	 */
	
	
	public static void queenCombinationPerspectiveBox(boolean[] board,int col,int qpsf,int tq,String ans)
	{


		if(qpsf==tq)
		{
			System.out.println(ans);
			return;
		}
		if(col==board.length)
			return;

		//sequence of above two conditions matter because if positive base case hit and u placed 2nd if above then print statement will not execute and it will return;
		
		board[col]=true;
		queenCombinationPerspectiveBox(board, col+1, qpsf+1, tq, ans+"b"+col);
		board[col]=false;
		queenCombinationPerspectiveBox(board, col+1, qpsf, tq, ans);
	}



	//2D
	
	
	public static void QueenCombinationBoxPerspective2D(boolean[][] board,int row,int col,int qpsf,int tq,String ans)
	{
		
		//positive base case
		if(qpsf==tq)
		{
			System.out.println(ans);
			return;
		}
		
		//manually adding condition for variable change
		/*
		2 ways to handle below ssetuation
		1)manually changing the variables
		2)giving extra call to handle further (0,2) call (explained in QueenCombinationBoxPerspective2DExtraRecCall)
		 */
		if(col==board[0].length)
		{
			//this
				row++;
				col=0;
				//or
			//QueenCombinationBoxPerspective2D(board,row+1,0,qpsf,tq,ans);
			//return;
		}
		
		//negative base case
		if(row==board.length)
			return;
		
		
		//queen place at 0,0
		board[row][col]=true;
		QueenCombinationBoxPerspective2D(board, row, col+1, qpsf+1, tq, ans+"("+row+","+col+")");
		board[row][col]=false;
		
		//no place at 0,0
		QueenCombinationBoxPerspective2D(board, row, col+1, qpsf, tq, ans);
		
	}
	
	
	
	//another apporach for manually variable change
	

	public static void QueenCombinationBoxPerspective2DExtraRecCall(boolean[][] board,int row,int col,int qpsf,int tq,String ans)
	{
		
		//positive base case
		if(qpsf==tq)
		{
			System.out.println(ans);
			return;
		}
		
		//manually adding condition for variable change
		if(col==board[0].length)
		{
			QueenCombinationBoxPerspective2DExtraRecCall(board, row+1, 0, qpsf, tq, ans);
			return;
		}
		
		//negative base case
		if(row==board.length)
			return;
		
		
		//queen place at 0,0
		board[row][col]=true;
		QueenCombinationBoxPerspective2DExtraRecCall(board, row, col+1, qpsf+1, tq, ans+"("+row+","+col+")");
		board[row][col]=false;
		
		//no place at 0,0
		QueenCombinationBoxPerspective2DExtraRecCall(board, row, col+1, qpsf, tq, ans);
		
	}
	
	
	//coin change combination problem
	
	
	public static void CoinChange(int[] denominators,int amount,String ans,int lastDenomUsed)
	{
		//System.out.println(amount);
		if(amount==0)
		{
			System.out.println(ans);
			return;
		}
		
		for(int i=lastDenomUsed;i<denominators.length;i++)
		{
			if(denominators[i]<=amount)
			{
				CoinChange(denominators, amount-denominators[i], ans+denominators[i], i);
			}
		}
		
	}
	
	
	//coin change permutation problem
	
	
		public static void CoinChangeP(int[] denominators,int amount,String ans)
		{
			
			if(amount==0)
			{
				System.out.println(ans);
				return;
			}
			
			for(int i=0;i<denominators.length;i++)
			{
				if(denominators[i]<=amount)
				{
					CoinChangeP(denominators, amount-denominators[i], ans+denominators[i]);
				}
			}
			
		}
		
		
		//coinchange above problem  with another approach
		//coin respect
		//either coin will give its contribution or not
		
		
		public static void CoinChangeCoinRespect(int[] denom,int vidx,int amount,String ans)
		{
			
			if(amount==0)
			{
				System.out.println(ans);
				return;
				
			}
			
			if(amount<0 || vidx==denom.length)
				return;
			
			
			//yes
			CoinChangeCoinRespect(denom, vidx, amount-denom[vidx], ans+denom[vidx]);
			
			//no
			CoinChangeCoinRespect(denom, vidx+1, amount, ans);
		}
		
		//Queen problem with NQueen approach
		
		public static void QueenCombinationBoxPerspective2DKill(boolean[][] board,int row,int col,int qpsf,int tq,String ans)
		{
			
			//positive base case
			if(qpsf==tq)
			{
				System.out.println(ans);
				return;
			}
			
			//manually adding condition for variable change
			if(col==board[0].length)
			{
				row++;
				col=0;
			}
			
			//negative base case
			if(row==board.length)
				return;
			
			
			//queen place at 0,0
			
			if(isItSf(board,row,col))
			{
			board[row][col]=true;
			//QueenCombinationBoxPerspective2DKill(board, row, col+1, qpsf+1, tq, ans+"("+row+","+col+")");
			// to save the recursive call we can change above line to below which goes to next rwo when placed queen as this will kill in same rows
					QueenCombinationBoxPerspective2DKill(board, row+1, 0, qpsf+1, tq, ans+"("+row+","+col+")");

			board[row][col]=false;
			}
			
			//no place at 0,0
			QueenCombinationBoxPerspective2DKill(board, row, col+1, qpsf, tq, ans);
			
		}
		
		private static boolean isItSf(boolean[][] board, int row, int col) {
			// TODO Auto-generated method stub
			//vertically upward
			for(int i=row-1;i>=0;i--)
			{
				if(board[i][col])
					return false;
			}
			
			//horizontally left
			for(int i=col-1;i>=0;i--)
			{
				if(board[row][i])
					return false;
			}
			//diagonally left
			for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--)
			{
				if(board[i][j])
					return false;
			}
			
			//diagonally right
			for(int i=row-1,j=col+1;i>=0 && j<board[0].length;i--,j++)
			{
				if(board[i][j])
					return false;
			}
			
			
			return true;
		}
		
		
		
		//N Knights problem no kill
		static int c=0;
		
		public static void NKnight(boolean[][] board,int row,int col,int kpsf,int tk,String ans)
		{
			
			if(kpsf==tk)
			{
				c++;
				System.out.println(c+"."+ans);
				return;
			}
			
			if(col==board.length)
			{
				row++;
				col=0;
			}
			
			if(row==board.length)
				return;
			
			if(isItSafeToPlaceknight(board, row, col))
			{
			board[row][col]=true;
			NKnight(board, row, col+1, kpsf+1,tk,ans+"("+row+","+col+")");
			board[row][col]=false;
			}
			
			NKnight(board, row, col+1, kpsf, tk, ans);
			
		}
		
		
		public static boolean isItSafeToPlaceknight(boolean[][] board,int row,int col)
		{
			int[] rowar= {-1,-2,-2,-1};
			int[] colar= {2,1,-1,-2};
			
			
			for (int i = 0; i < 4; i++) {
				
			
			int r=row+rowar[i];
			int c=col+colar[i];
			
			
			if(r>=0 && r<board.length && c>=0 && c<board[0].length)
			{
				if(board[r][c])
					return false;
			}
			
			}
			
			return true;
			
			
			
			
		}
		
		//NQueen 2
		static int cc=0;
		public static void NQueen2(boolean[][] board,int row,int qpsf,int tq,String ans)
		{
			
			
			if(qpsf==tq)
			{
				cc++;
				System.out.println(cc+"."+ans);
				return;
			}
			
			if(row==board.length)
				return;
			
			for(int col=0;col<board[0].length;col++)
			{
				
				if(isItSafe(board, row, col))
				{
				board[row][col]=true;
				NQueen2(board, row+1, qpsf+1, tq, ans+"("+row+","+col+")");
				board[row][col]=false;
				}
				
			}
		}
		
		
		//what if we want to place K queens rather than N queens
	
		public static void KQueen(boolean[][] board,int row,int qpsf,int tq,String ans)
		{
			
			
			if(qpsf==tq)
			{
				cc++;
				System.out.println(cc+"."+ans);
				return;
			}
			
			if(row==board.length)
				return;
			
			for(int col=0;col<board[0].length;col++)
			{
				
				if(isItSafe(board, row, col))
				{
				board[row][col]=true;
				KQueen(board, row+1, qpsf+1, tq, ans+"("+row+","+col+")");
				board[row][col]=false;
				}
				
			}
			
			//not place
			
			KQueen(board, row+1, qpsf, tq, ans);
		}
		
		
		
		
		//merge sort
		//not inplace sorted algoeithm because we are not making changes in original arrays
		//inplace -bubble sort,insertion sort,selection sort
		//devide and conquer algorithm
		
		public static int[] mergeSort(int[] ar,int low,int high)
		{
			//base condition
			
			if(low==high)
			{
				int[] base=new int[1];
				base[0]=ar[low];
				return base;
			}
			
			
			//self work
			int mid=low+(high-low)/2;
			
			int[] first=mergeSort(ar, low, mid);
			int[] second=mergeSort(ar,mid+1,high);
			
			
			int[] merge=merge(first,second);
			
			return merge;
			
		}

		private static int[] merge(int[] first, int[] second) {
			// TODO Auto-generated method stub
			
			int[] merge=new int[first.length+second.length];
			
			
			
			int i=0,j=0,k=0;
			
			while(i<first.length && j<second.length)
			{
				
				if(first[i]>second[j])
					merge[k++]=second[j++];
				else
					merge[k++]=first[i++];
				
			}	
				while(i<first.length)
					merge[k++]=first[i++];
				
				while(j<second.length)
					merge[k++]=second[j++];
				
				
			
			return merge;
		}
		
		//Quick Sort in place devide and conquer algorithm
		public static void quickSort(int[] ar,int low,int high)
		{
			
			
			//base case;
			
			if(low>=high)
				return;
			
			int mid=low+(high-low)/2;
			
			int pivot=ar[mid];
			
			int left=low;
			int right=high;
			
			
			while(left<=right)
			{
				
				
				while(ar[left]<pivot)//make sure it should not be == because it will consider pivot as well
				{
					left++;
				}
				
				while(ar[right]>pivot)
					right--;
				
				
				if(left<=right)
				{
					int temp=ar[right];
					ar[right]=ar[left];
					ar[left]=temp;
					left++;
					right--;
					
				}
				
				
				
				
				
			}
			
			quickSort(ar, low, right);
			quickSort(ar, left, high);
			
			
		}
		
		//codingblock subset question
		//using bit manipulation we can find the subsets of string and array
		
	public static void subset(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int j = 0; j < n; j++) {
			int nn = sc.nextInt();

			int[] ar = new int[nn];

			for (int i = 0; i < nn; i++)
				ar[i] = sc.nextInt();
			ArrayList<Integer> l = new ArrayList<>();
			// isZeroSubSet(ar);
			if (isZeroSubSet(ar))
				System.out.println("Yes");
			else
				System.out.println("No");

		}

	}

	public static boolean isZeroSubSet(int[] ar) {

		int n = ar.length;
		// System.out.println(n);

		n = (int) Math.pow(2, n) - 1;
		// System.out.println(n);

		int mask = (int) Math.pow(2, ar.length - 1);
		// System.out.println(mask);

		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> l = new ArrayList<>();
			int j = 0;
			int k = i;
			while (k > 0) {
				// System.out.println(k+" --");
				if ((k & mask) == mask) {
					// System.out.println(ar[j]+" =");

					l.add(ar[j]);
				}
				j++;
				k = k << 1;
			}

			int sum = 0;
			for (int m : l) {
				sum += m;
			}
			if (sum == 0)
				return true;
			// System.out.println();
		}

		return false;
	}

		/*

		0000  
		0001   -3                1000 & 1000  
		0010    2
		0011    2 -3    0011 & 1000  0   0110  0 1100   
		0100    3
		0101    3 -3
		0110    3 2
		0111    3 2 -3
		1000    1
		1001    1 -3
		1010    1 2
		1011    1 2 -3
		1100    1 3
		1101    1 3 -3
		1110    1 3 2
		1111    1 3 2 -3
		*/
	
	
	/*
	 * Optimal strategy
	 * Piyush and Nimit are playing a coin game. They are given n coins with values x1, x2 �. xn where 'n' is always even. They take alternate terms. In each turn, a player picks either the first coin or the last coin from the row and removes it from the row. The value of coin is received by that player. Determine the maximum value that Piyush can win with if he moves first. Both the players play optimally.

		Input Format
		First line contains the number of coins 'n'.
		Second line contains n space separated integers where ith index denotes the value of ith coin.

		Assume worst when things happen to you , do best when you can
	 */
	
	public static long optimalGame(int[] arr,int i, int j) {
        if (i > j) {
            return 0;
        }
        //  Consider both the possibilities. You can pick either the first or the last coin.
        //  Since the opponent plays optimally , we would get the minimum of the remaining coins for each choice.
        long pickFirst = arr[i] + Math.min(optimalGame(arr,i + 2, j), optimalGame(arr,i + 1, j - 1));
        long pickLast = arr[j] + Math.min(optimalGame(arr,i, j - 2), optimalGame(arr,i + 1, j - 1));

        // Pick the max of two as your final result
        long ans = Math.max(pickFirst, pickLast);

        return ans;
    }
	
	
	
	
	
	
	
	/*
	 * tiling problem
	 */
	
	/*public static int tiling(int n)
	{
		
		
		
		
	}*/
}
