package SynamicProgramming;

import java.util.Arrays;

public class DP {
	static int c1, c2 = 0;

	public static long start = 0;
	public static long end = 0;

	public static void start() {
		start = System.currentTimeMillis();
	}

	public static long endalg() {
		end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) {
		int n = 42;
		int[] strg = new int[n + 1];

		/*
		  start();
		  System.out.println(fib(n)+" "+c1); 
		  System.out.println(endalg());
		  start();
		  System.out.println(fibrec(n,strg)+" "+c2);
		  System.out.println(endalg());
		  
		  start();
		  System.out.println(fibItr(n));
		 System.out.println(endalg());
		 
		 System.out.println(fibItrse(5));*/
		 
/*		
		
		System.out.println(fib(25));
		System.out.println(fibItr(25));
		System.out.println(fibItrse(25));*/

		/*
		 * start(); System.out.println(getBoardPathCount(0, 30));
		 * 
		 * System.out.println(endalg()); start();
		 * 
		 * System.out.println(getBoardPathCountDP(0, 30, new int[31]));
		 * System.out.println(endalg()); start(); System.out.println(getpathcountItr(0,
		 * 30)); System.out.println(endalg());
		 */
		
		/*start();
		System.out.println(LCS("abbsdfsdfsfg", "dabdsfffdfdfg"));
		System.out.println(endalg());
		start();
		System.out.println(LCSItrdpsol("abbsdfsdfsfg", "dabdsfffdfdfg"));
		System.out.println(endalg());*/
		
		/*
		start();
		System.out.println(editdistance("agbsdfdsfdfdfg","acdffdfdfdfffdggb"));
		System.out.println(endalg());
		
		start();
		System.out.println(editdistanceItr("agbsdfdsfdfdfg", "acdffdfdfdfffdggb"));
		System.out.println(endalg());*/
		
		
		//System.out.println(getBinaryStringCount(3));
		/*
		System.out.println(getBoardPathCount(0, 10));
		System.out.println(getBoardPathCountDP(0, 10, new int[10]));
		System.out.println(getpathcountItr(0, 10));
		System.out.println(getcountpath(0,15));
		
		System.out.println("--------------");
		System.out.println(getcountpathse(0, 15));*/
		//int row=13,col=13;
		/*System.out.println(countmazepath(new int[row][col], 0, 0));
		System.out.println(countmazepathmemoiz(new int[row][col], 0, 0, new int[row][col]));
		System.out.println(countmazepathDP(new int[row][col], 0, 0));
	System.out.println(countmazeppathdpse(new int[row][col], 0, 0));*/
		//System.out.println(countmazepathdiagonal(new int[row][col], 0, 0));
		//printmazepathdiagonal(new int[row][col], 0, 0, "");
		//int row=3,col=4;
		///System.out.println(countmazepathdiagonalDP(new int[row][col], 0, 0));
		//System.out.println(countmazeppathdiagonaldpse(new int[row][col], 0, 0));
		
		//System.out.println(LCS("acdsweqwrwerwerereds", "agcfdsdxcvcxvxcvvcvcvvsd"));
		//System.out.println(LCSsubse("acdsweqwrwerwerereds", "agcfdsdxcvcxvxcvvcvcvvsd", 0, 0));
		//int[] strg1[]=new int[50][50];
		
		//for(int[] a:strg1)
		//	Arrays.fill(a, -1);
		//System.out.println(LCSTD("abcdefghijklmnopqrst", "SDJKFKJSDFGKDJSFJKDF", 0, 0, new int[50][50]));
		//System.out.println(LCSItrdpsol("abcdefghijklmnopqrst", "SDJKFKJSDFGKDJSFJKDF"));
		//int[] ar=new int[1000] ;
		
	//	for(int i=0;i<ar.length;i++)
			//ar[i]=i;
		//System.out.println(WineProb(ar,0,999,1));
	//	System.out.println(WineProbTDP(ar, 0, 999, 1, new int[ar.length][ar.length]));
		//System.out.println(WineProbBDP(ar));
	//System.out.println(MCMTDP(new int[] {4, 2, 3,5,1},0,4,new int[5][5]));
//	System.out.println(MCMBUDP(new int[] {4,2,3,5,1}));
		//int[] wt=new int[] {1,3,4,5};
		//int price[]=new int[] {1,4,5,7};
		//int capacity=7;
		//System.out.println(knapsack(wt,price,0, capacity));
		//System.out.println(knapsackTDP(wt,price,0, capacity,new int[wt.length][capacity+1]));
		//System.out.println(knapsackBUP(wt, price, capacity));
		//int[] mixture=new int[] {40, 60, 20,70,80,50,50,40, 60, 20,70,80,50,50,40, 60, 20,70,80,50,50};
		//System.out.println(mixturs(mixture,0,mixture.length-1));
		//System.out.println(mixtursTDP(mixture, 0, mixture.length-1, new int[mixture.length][mixture.length]));
		//System.out.println(mixturesBUDP(mixture));
		/*int prices[]=new int[] {0,1,5,8,9,10,17,17,20};
		System.out.println(rodCuttg(prices, prices.length-1));
		System.out.println(rodCuttgTDP(prices, prices.length-1, new int[prices.length]));
		System.out.println(rodCuttgBU(prices, prices.length-1));*/
		//String str="babfsdvsfdfsffsffsdfffffffffffffffffffffffffff";
		String pattern="ba?************************";
	//	System.out.println(WildCardMatching(str,pattern));
		//System.out.println(WildCardMatching(str, pattern, 0, 0,new int[str.length()][pattern.length()]));
		//System.out.println(WildCardMatchingBUDP(str, pattern));
		//System.out.println(noOfUniqueBSTs(10));
		//System.out.println(noOfUniqueBSTsTD(10, new int[10+1]));
		//System.out.println(noOfUniqueBSTsBU(10));
		/*String s="cbbd";
		System.out.println(longestPalindromicSubsequence(s, 0, s.length()-1));
		System.out.println(longestPalindromicSubsequenceTD(s, 0, s.length()-1,new int[s.length()][s.length()]));
		System.out.println(longestPalindromicSubsequenceBU(s));*/
		String s1="abcdsdfdryujtyjesdddhthrthrthtyhdddddddddddddfsfdfdghi";
		String s2="htyrhhhhhrthbrtghyjyhhhhhhhhhhh thbhbhvvvvvvvvI";
		//System.out.println(kOrderedLCSRec(s1, s2, 5, 0, 0));
		//System.out.println(kOrderedLCSRecTD(s1, s2, 5, 0, 0, new int[6][s1.length()][s2.length()]));
		//System.out.println(kOrderedLCSRecBU(s1, s2, 5));
		String str1="qwertyuioopqwertyuiop";
		String str2="asdfghjkl;asdfghjk";
		String str3="zxcvbnm,,zxcvbnm,nbbvvc";
		//System.out.pridfdntln(lcs3Strings(str1, str2, str3, 0, 0, 0));
		//System.out.println(lcs3StringsTDP(str1, str2, str3, 0, 0, 0, new int[str1.length()+1][str2.length()+1][str3.length()+1]));
		//System.out.println(lcs3StringsBU(str1, str2, str3));
		
		/*int[][] dungeon=new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(dungeonGame(dungeon, 0, 0, 2, 2));
		System.out.println(dungeonGameBU(dungeon));*/
		int [] ar=new int[]{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};//{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}; // {3,4,-1,0,6,2,3};
			System.out.println(LIS(ar));
		
		System.out.println(Arrays.toString(ar));
			System.out.println(LISeffecient(ar));
	}

	// ***********Fibonacci DP*****************
	// O(2^n)
	public static int fib(int n) {
		c1++;
		if (n == 0 || n == 1)
			return n;

		int c1 = fib(n - 1);
		int c2 = fib(n - 2);

		return c1 + c2;
	}

	// O(n)
	public static int fibrec(int n, int strg[]) {
		c2++;
		if (n == 0 || n == 1)
			return n;
		if (strg[n] != 0)
			return strg[n];
		// int c1=strg[n-1]==0?fibrec(n-1,strg):strg[n-1];
		int c1 = fibrec(n - 1, strg);

		 //strg[n-1]=c1;
		// int c2=strg[n-2]==0?fibrec(n-2,strg):strg[n-2];
		int c2 = fibrec(n - 2, strg);
		strg[n] = c1 + c2;

		return c1 + c2;
	}

	public static int fibItr(int n) {
		int[] strag = new int[n + 1];
		strag[0] = 0;
		strag[1] = 1;

		for (int i = 2; i <= n; i++)
			strag[i] = strag[i - 1] + strag[i - 2];

		return strag[n];

	}

	//space efficient time: O(n) and space nearly O(1)
	public static int fibItrse(int n) {
		int[] strag = new int[2]; //we can also use two variables
		strag[0] = 0;
		strag[1] = 1;

		for (int i = 1; i < n; i++) //slide n-1 times
		{
			int t= strag[0] + strag[1];
			strag[0]=strag[1];
			strag[1]=t;
			System.out.println("["+strag[0]+","+strag[1]+"]");
		}

		return strag[1];

	}
	// ***********GetBoardPathCount DP*****************

	// O(6^n)
	public static int getBoardPathCount(int src, int end) {

		if (src == end)
			return 1;

		if (src > end)
			return 0;
		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += getBoardPathCount(src + dice, end);
		}

		return count;

	}

	// O(n)
	private static int getBoardPathCountDP(int src, int end, int[] strg) {
		if (src == end)
			return 1;

		if (src > end)
			return 0;

		if (strg[src] != 0)
			return strg[src];

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {

			// int c=strg[src+dice]==0?getBoardPathCountDP(src + dice,
			// end,strg):strg[src+dice];
			// strg[src+dice]=c;
			// count += c;
			count += getBoardPathCountDP(src + dice, end, strg);

		}
		strg[src] = count;
		return count;

	}

	public static int getpathcountItr(int src, int end) {
		int[] strg = new int[end + 1];
		strg[end] = 1;

		for (int i = end - 1; i >= 0; i--) {

			int count = 0;
			for (int dice = 1; dice <= 6 && dice + i < strg.length; dice++) {

				count += strg[dice + i];

			}

			strg[i] = count;
		}

		return strg[src];

	}
	
	//time O(n) space O(n)
	public static int getcountpath(int src,int n)
	{
		
		
		
		int strg[]=new int[n+6];
		
		strg[n]=1;
		
		
		for(int i=n-1;i>=0;i--)
		{
			
			int count=0;
			System.out.println(Arrays.toString(strg));
			for(int j=i+1;j<=(i+6);j++ )
			{
				count+=strg[j];
				
			}
			strg[i]=count;
			
		}
		
		
		return strg[0];
		
	}
	//getboardpath space efficient time: O(n) space;O(1)
	public static int getcountpathse(int src,int n)
	{
		
		
		
		int strg[]=new int[6];
		
		strg[0]=1;
		
		
		for(int i=0;i<n;i++)
		{
			
			int count=0;
			for(int j=0;j<strg.length;j++ )
			{
				count+=strg[j];
				
			}

			for(int j=strg.length-2;j>=0;j-- )
			{
				strg[j+1]=strg[j];
				
			}
			strg[0]=count;

		}
		
		
		return strg[0];
		
	}
	
	
	
	

	// ************longest common subsequence************

	// O(2^s1.length+s2.length)
	public static int LCS(String str1, String str2) {

		int count = 0;
		if (str1.length() == 0 || str2.length() == 0)
			return 0;

		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		if (str1.charAt(0) == str2.charAt(0))
			count = 1 + LCS(ros1, ros2);
		else
			count = Math.max(LCS(str1, ros2), LCS(ros1, str2));

		return count;
	}
	
	
	//in above lcs substring method tking n time hence we can reduce it via using vertual index
	//still  O(2^s1.length+s2.length)

	public static int LCSsubse(String str1, String str2,int vdx1,int vdx2) {

		int count = 0;
		if (vdx1 >= str1.length() || vdx2 >=str2.length())
			return 0;

	//	String ros1 = str1.substring(1);
		//String ros2 = str2.substring(1);
		if (str1.charAt(vdx1) == str2.charAt(vdx2))
			count = 1 + LCSsubse(str1, str2,vdx1+1,vdx2+1);
		else
			count = Math.max(LCSsubse(str1, str2,vdx1,vdx2+1), LCSsubse(str1, str2,vdx1+1,vdx2));

		return count;
	}
	
	
	
	//top down dp 
	
	public static int LCSTD(String str1, String str2,int vdx1,int vdx2,int[][] strg) {

		int count = 0;
		if (vdx1 >= str1.length() || vdx2 >=str2.length())
			return 0;
			
		if(strg[vdx1][vdx2]!=-1)
			return strg[vdx1][vdx2];
		
	//	String ros1 = str1.substring(1);
		//String ros2 = str2.substring(1);
		if (str1.charAt(vdx1) == str2.charAt(vdx2))
		{
			count = 1 + LCSTD(str1, str2,vdx1+1,vdx2+1,strg);
		}
		else
			count = Math.max(LCSTD(str1, str2,vdx1,vdx2+1,strg), LCSTD(str1, str2,vdx1+1,vdx2,strg));
		strg[vdx1][vdx2]=count;
		return count;
	}
//O(m*n) 
	//fill strg with -1 to avoid the worst case as if two strings are different then computed or not how we can know as 0 is default value and not computed is also 0
	public static int LCSItrdpsol(String str1,String str2)
	{
		
		int[] strg[]=new int[str1.length()+1][str2.length()+1];
		
		//strg[str1.length()][str2.length()]=0;
		
		
		for(int i=str1.length();i>=0;i--)
		{
			
			for(int j=str2.length();j>=0;j--)
			{
				
				
				if(i==str1.length() || j==str2.length())
				{
					strg[i][j]=0;
					continue;
				}
				
				
				if(str1.charAt(i)==str2.charAt(j))
				{
					
					
					strg[i][j]=1+strg[i+1][j+1];
				}
				else
				{
					strg[i][j]=Math.max(strg[i+1][j], strg[i][j+1]);
				}
				
				
				
				
				
			}
			
			
			
			
		}
		
		
		return strg[0][0];
		
		
	}
	
	
	//***************edit distance //minimum no of operations required to make string 2 like string 1***************
	
	
	
	
	//O(2^s1.length+s2.length)
	public static int editdistance(String st1,String st2)
	{
		if(st1.length()==0)
			return st2.length();
		
		if(st2.length()==0)
			return st1.length();
		String ros1=st1.substring(1);
		String ros2=st2.substring(1);
		
		int ans=0;
		if(st1.charAt(0)==st2.charAt(0))
				{
			ans=editdistance(ros1, ros2);
				}
		else
		{
			//replace
			int f1=1+editdistance(ros1, ros2);
			//add
			int f2=1+editdistance(st1, ros2);
			//remove
			int f3=1+editdistance(ros1, st2);
			ans=Math.min(f1, Math.min(f2, f3));
			
		}
	
		
		
		
		return ans;
		
	}
	
	
	
	
	
	
	
	
	public static int editdistanceItr(String str1,String str2)
	{
		
		int[] [] strg=new int[str1.length()+1][str2.length()+1];
		
		
		strg[str1.length()][str2.length()]=0;
		
		
		for(int i=str1.length();i>=0;i--)
		{
			for(int j=str2.length();j>=0;j--)
			{
		
				if(i==str1.length())
				{
					strg[i][j]=str2.length()-j;
					continue;
				}
				
				if(j==str2.length())
				{
					strg[i][j]=str1.length()-i;
					continue;
				}
				
				if(str1.charAt(i)==str2.charAt(j))
				{
					strg[i][j]=strg[i+1][j+1];
				}
				else
				{
					strg[i][j]=1+Math.min(strg[i+1][j], Math.min(strg[i][j+1], strg[i+1][j+1]));
				}
			}
		}
		
		return strg[0][0];
		
		
	}
	
	
	
	//***********Count Number of binary strings************
	
	
	public static int getBinaryStringCount(int n)
	{
		
		if(n==1)
			return 2;
		int[] ones=new int[n];
		int[] zeros=new int[n];
		
		//seed
		zeros[0]=1;
		ones[0]=1;
		
		for(int i=1;i<n;i++)
		{
			zeros[i]=zeros[i-1]+ones[i-1];
			ones[i]=zeros[i-1];
			
			
			
		}
		
		return zeros[n-1]+ones[n-1];
		
		
	}
	
	
	//*******************CountMazePath****************-
	
//count maze paths
	public static int countmazepath(int[] []maze,int row,int col)
	{
		
		if(row<0 || col<0 || row>=maze.length || col>=maze[0].length)
			return 0;
		
		if(row==maze.length-1 && col==maze[0].length-1)
		{
			return 1;
			
		}
		int count=0;
		
		count+=countmazepath(maze,row+1, col);
		count+=countmazepath(maze,row, col+1);
		
		return count;
	}
	
	//O(row*col) space:O(er*ec) +recurrance
	public static int countmazepathmemoiz(int[] []maze,int row,int col,int[][] strg)
	{
		
		if(row<0 || col<0 || row>=maze.length || col>=maze[0].length)
			return 0;
		if(strg[row][col]!=0)
			return strg[row][col];
		
		if(row==maze.length-1 && col==maze[0].length-1)
		{
			return 1;
			
		}
		int count=0;
		
		count+=countmazepathmemoiz(maze,row+1, col,strg);
		count+=countmazepathmemoiz(maze,row, col+1,strg);
		
		strg[row][col]=count;
		return count;
	}
	
	
	//O(row*col) space:O(row*col)
	
public static int countmazepathDP(int[] maze[],int row,int col)
{
	int[][] strg=new int[maze.length+1][maze[0].length+1];
	
	
	strg[maze.length-1][maze[0].length-1]=1;
	
	//for(int[] ar:strg)
	//	System.out.println(Arrays.toString(ar));
	
	for(int i=maze.length-1;i>=0;i--)
	{
		for(int j=maze[0].length-1;j>=0;j--)
		{
			if(i==maze.length-1 && j==maze[0].length-1)
				strg[i][j]=1;
			else
				strg[i][j]=strg[i+1][j]+strg[i][j+1];
			
			
			
		}
		
	}

	//for(int[] ar:strg)
		//System.out.println(Arrays.toString(ar));


	return strg[0][0];



}
	


//countmazepath space efficient
//time O(row*col) space O(col)

public static int countmazeppathdpse(int[][] maze,int row,int col)
{
	int[] strg=new int[maze[0].length];
	
	Arrays.fill(strg, 1);
	
	for(int slide=maze.length-2;slide>=0;slide--)
	{
		
		for(int coll=maze[0].length-1;coll>=0;coll--)
		{
			if(coll==maze[0].length-1)
				strg[coll]=1;
			else
				strg[coll]=strg[coll]+strg[coll+1];
			
			
		}
		
		//System.out.println(Arrays.toString(strg));
		
		
	}
	
	return strg[0];

}


//maze path diagonal
public static void printmazepathdiagonal(int[] []maze,int row,int col,String psf)
{
	
	if(row<0 || col<0 || row>=maze.length || col>=maze[0].length)
		return;
	
	if(row==maze.length-1 && col==maze[0].length-1)
	{
		System.out.println(psf);
		
	}
	
	
	printmazepathdiagonal(maze,row+1, col,psf+"V");
	printmazepathdiagonal(maze,row, col+1,psf+"H");
	printmazepathdiagonal(maze, row+1, col+1,psf+"D");
	
	
}

public static int countmazepathdiagonal(int[] []maze,int row,int col)
{
	
	if(row<0 || col<0 || row>=maze.length || col>=maze[0].length)
		return 0;
	
	if(row==maze.length-1 && col==maze[0].length-1)
	{
		return 1;
		
	}
	int count=0;
	
	count+=countmazepathdiagonal(maze,row+1, col);
	count+=countmazepathdiagonal(maze,row, col+1);
	count+=countmazepathdiagonal(maze, row+1, col+1);
	
	return count;
}



public static int countmazepathdiagonalDP(int[] maze[],int row,int col)
{
	int[][] strg=new int[maze.length+1][maze[0].length+1];
	
	
	strg[maze.length-1][maze[0].length-1]=1;
	
	//for(int[] ar:strg)
	//	System.out.println(Arrays.toString(ar));
	
	for(int i=maze.length-1;i>=0;i--)
	{
		for(int j=maze[0].length-1;j>=0;j--)
		{
			if(i==maze.length-1 && j==maze[0].length-1)
				strg[i][j]=1;
			else
				strg[i][j]=strg[i+1][j]+strg[i][j+1]+strg[i+1][j+1];
			
			
			
		}
		
	}

	//for(int[] ar:strg)
		//System.out.println(Arrays.toString(ar));


	return strg[0][0];



}


public static int countmazeppathdiagonaldpse(int[][] maze,int row,int col)
{
	int[] strg=new int[maze[0].length];
	
	Arrays.fill(strg, 1);
	int diagonal=0;
	for(int slide=maze.length-2;slide>=0;slide--)
	{
		
		for(int coll=maze[0].length-1;coll>=0;coll--)
		{
			if(coll==maze[0].length-1)
			{
				strg[coll]=1;
				diagonal=1;
			}
			else
			{
				
				int val=strg[coll]+strg[coll+1]+diagonal;
				diagonal=strg[coll];
				strg[coll]=val;
			}
			
			
		}
		
		//System.out.println(Arrays.toString(strg));
		
		
	}
	
	return strg[0];

}


/*
 * 
 * Wine problem to get max profit
 * TC:O(2^n)
 */
	
static int WineProb(int[] ar,int si,int ei,int yr)
{
	//int yr=ar.length-(ei-si+1)+1;  we can use this instead of year parameter
if(si==ei)
	return ar[si]*yr;

//when we sell leftmost
int start=WineProb(ar, si+1, ei, yr+1)+ar[si]*yr;
int end=WineProb(ar, si, ei-1, yr+1)+ar[ei]*yr;

int ans=Math.max(start, end);

return ans;
}

//top down dp for large inputs efficient
static int WineProbTDP(int[] ar,int si,int ei,int yr,int [][]strg)
{
	
if(si==ei)
	return ar[si]*yr;
if(strg[ei][si]!=0)
return strg[ei][si];

//when we sell leftmost
int start=WineProbTDP(ar, si+1, ei, yr+1,strg)+ar[si]*yr;
int end=WineProbTDP(ar, si, ei-1, yr+1,strg)+ar[ei]*yr;

int ans=Math.max(start, end);
strg[ei][si]=ans;
return ans;
}

//wine problem bottom up approach

static int WineProbBDP(int[] ar)
{
	int n=ar.length;
	int[][] strg=new int[n][n];
	
	
	//fill 
	
		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= (n - slide - 1); si++) {

				int ei = si + slide;
			int yr=n-(ei-si+1)+1;
				if(ei==si)
					strg[si][ei]=ar[si]*yr;
				else
				{
					
					int start=strg[si+1][ei]+ar[si]*yr;
					int end=strg[si][ei-1]+ar[ei]*yr;
					
					strg[si][ei]=Math.max(start, end);
				}
				
			
				
			}
		}
	
			return strg[0][n-1];
}

/*
 * 
 * MCM (Matrix chain multiplication) 
 * problem:What is the minimum number of multiplication operation required to multiply these four matrices
 * M1*(M2M3)==(M2M3)*M1) is same but different multiplication operation counts
 * M1=i*j and M2=J*k then resultant is i*k   and no of multiplications required are i*j*k
 */


	static int MCM(int[] ar,int si,int ei)
	{
		
		int min=Integer.MAX_VALUE;
		//Base case when only one matrix is there
		if(si+1==ei)
			return 0;
		
		for(int k=si+1;k<=ei-1;k++)
		{
			
			
			int fp=MCM(ar, si, k);
			int sp=MCM(ar, k, ei);
			int sw=ar[si]*ar[k]*ar[ei];
			int total=fp+sp+sw;
			
			if(total<min)
				min=total;
			

			
		}
		
return min;		
		
	}
	
	
	static int MCMTDP(int[] ar,int si,int ei,int[][] strg)
	{
		
		int min=Integer.MAX_VALUE;
		//Base case when only one matrix is there
		if(si+1==ei)
			return 0;
		
		
		if(strg[si][ei]!=0)
			return strg[si][ei];
		for(int k=si+1;k<=ei-1;k++)
		{
			
			
			int fp=MCMTDP(ar, si, k,strg);
			int sp=MCMTDP(ar, k, ei,strg);
			int sw=ar[si]*ar[k]*ar[ei];
			int total=fp+sp+sw;
			
			if(total<min)
				min=total;
			

			
		}
		
		strg[si][ei]=min;
		
return min;		
		
	}
	//O(n^3) sp: O(n^2)
	static int MCMBUDP(int ar[])
	{
		int n=ar.length;
		int[][] strg=new int[n][n];
		
		for(int slide=1;slide<=n-1;slide++)
		{
			
			for(int si=0;si<=n-slide-1;si++)
			{
				int ei=si+slide;
		
				int min=Integer.MAX_VALUE;
				//Base case when only one matrix is there
				if(si+1==ei)
					strg[si][ei]= 0;
				else
				{
				for(int k=si+1;k<=ei-1;k++)
				{
					
					
					int fp=strg[si][k];
					int sp=strg[k][ei];
					int sw=ar[si]*ar[k]*ar[ei];
					int total=fp+sp+sw;
					
					if(total<min)
						min=total;
					

					
				}
				
				strg[si][ei]=min;
				
			
				
				}
				
			}
		}
		
		return strg[0][n-1];
		
	}
	
	
	
	/*
	 * 
	 * Mixtures problem : harry potter has n mixtures in front of (spoj)
	 * approach:similar to MCM
	 */
	
	public static int mixturs(int[] mixtures,int start,int end)
	{
		if(start==end)
			return 0;
		
		int min=Integer.MAX_VALUE;
		for(int k=start;k<=end-1;k++)
		{
			
			int fp=mixturs(mixtures, start,k);
			int sp=mixturs(mixtures, k+1,end);
			
			int sw=color(mixtures,start,k)*color(mixtures, k+1, end);
			
			int total=fp+sp+sw;
			if(total<min)
				min=total;
		}
		

		
		return min;
	}
	
	public static int mixtursTDP(int[] mixtures,int start,int end,int[][] strg)
	{
		if(start==end)
			return 0;
		
		if(strg[start][end]!=0)
			return strg[start][end];
		
		int min=Integer.MAX_VALUE;
		for(int k=start;k<=end-1;k++)
		{
			
			int fp=mixtursTDP(mixtures, start,k,strg);
			int sp=mixtursTDP(mixtures, k+1,end,strg);
			
			int sw=color(mixtures,start,k)*color(mixtures, k+1, end);
			
			int total=fp+sp+sw;
			if(total<min)
				min=total;
		}
		
		strg[start][end]=min;
		
		return min;
	}
	
	public static int color(int[] mixtures,int s,int e) {
		int sum=0;
		
		
		for(int i=s;i<=e;i++)
			sum+=mixtures[i];
		
		return sum%100;
	}
	
	
	
	
	static int mixturesBUDP(int mixtures[])
	{
		int n=mixtures.length;
		int[][] strg=new int[n][n];
		
		for(int slide=0;slide<=n-1;slide++)
		{
			
			for(int si=0;si<=n-slide-1;si++)
			{
				int ei=si+slide;
		
				//Base case when only one matrix is there
				if(si==ei)
					strg[si][ei]= 0;
				else
				{
					int min=Integer.MAX_VALUE;

					for(int k=si;k<=ei-1;k++)
					{
						
						int fp=strg[si][k];
						int sp=strg[k+1][ei];
						
						int sw=color(mixtures,si,k)*color(mixtures, k+1, ei);
						
						int total=fp+sp+sw;
						if(total<min)
							min=total;
						
					}
					
					strg[si][ei]=min;
					
				
				}
				
			}
		}
		
		return strg[0][n-1];
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * problem: 0/1   ck
	 * 
	 */
	
	public static int knapsack(int[] wt,int[] price,int widx,int capacity)
	{
		
		if(widx==wt.length || capacity==0)
			return 0;
		
		//exclude
		int e=knapsack(wt, price, widx+1, capacity);
		
		int i=0;
		
		if(capacity>=wt[widx])
			i=knapsack(wt, price, widx+1, capacity-wt[widx])+price[widx];
		int ans=Math.max(e, i);
		
		return ans;
		
		
		
	}
	
	public static int knapsackTDP(int[] wt,int[] price,int vidx,int capacity,int[][] strg)
	{
		
		if(vidx==wt.length || capacity==0)
			return 0;
		if(strg[vidx][capacity]!=0)
			return strg[vidx][capacity];
		//exclude
		int e=knapsackTDP(wt, price, vidx+1, capacity,strg);
		
		int i=0;
		
		if(capacity>=wt[vidx])
			i=knapsackTDP(wt, price, vidx+1, capacity-wt[vidx],strg)+price[vidx];
		int ans=Math.max(e, i);
		
		strg[vidx][capacity]=ans;
		return ans;
		
		
		
	}
	
	static int knapsackBUP(int[] wt,int[] price,int cap)
	{
		
		int n=wt.length;
		int[][] strg=new int[n+1][cap+1];
		
		
		
		for(int row=n-1;row>=0;row--)
		{
			for(int col=1;col<=cap;col++)
			{
				
				
				int e=strg[row+1][col];
				int i=0;
				
				if(col>=wt[row])
					i=strg[row+1][col-wt[row]]+price[row];
				
				int ans=Math.max(e, i);
				
				strg[row][col]=ans;
				
				
			}
			
		}
		
		
		return strg[0][cap];
		
		
		
		
		
	}
	
	
	/*
	 * Rod cutting :find maximum profit by cutting rod 
	 * 
	 */
	
	public static int rodCuttg(int[] prices,int n)
	{
		if(n==1)
			return prices[1];
		
		int max=0; //or set max =prices[n] so that next time we no need to compute max
		
		for(int i=1;i<=n/2;i++)
		{
			
			int fp=rodCuttg(prices, i);
			int sp=0;
			if((n-i)>0)
			 sp=rodCuttg(prices, n-i);
			
			int ans=fp+sp;
			
			if(ans>max)
				max=ans;
			
		}
		
		
		int sw=prices[n];

		return Math.max(max, sw);
		
		
		
	}
	
	
	//rod cutting top down dp
	
	public static int rodCuttgTDP(int[] prices,int n,int[] strg)
	{
		if(n==1)
			return prices[1];
		
		
		if(strg[n]!=0)
			return strg[n];
		
		int max=0; //or set max =prices[n] so that next time we no need to compute max
		
		for(int i=1;i<=n/2;i++)
		{
			
			int fp=rodCuttgTDP(prices, i,strg);
			int sp=0;
			if((n-i)>0)
			 sp=rodCuttgTDP(prices, n-i,strg);
			
			int ans=fp+sp;
			
			if(ans>max)
				max=ans;
			
		}
		
		
		int sw=prices[n];

		strg[n]=Math.max(max, sw);
		
		return strg[n];
		
	}
	
	//rod cutting bottom up method
	
	
	public static int rodCuttgBU(int[] prices,int n)
	{
		
		
		
		
		int[] strg=new int[n+1];
		strg[0]=0;
		strg[1]=prices[1];
		
	
		
		
		for(int i=1;i<=n;i++)
		{
			
			int max=prices[i]; //or set max =prices[n] so that next time we no need to compute max
			
			for(int j=1;j<i;j++)
			{
				
				int fp=strg[j];
				int sp=0;
				if((i-j)>0)
				 sp=strg[i-j];
				
				int ans=fp+sp;
				
				if(ans>max)
					max=ans;
				
			}
			strg[i]=max;
			
		}
		
	
		
		return strg[n];
		
	}

	
	/*
	 * wildcard pattern matching problem
	 */
	public static boolean WildCardMatching(String str,String pattern)
	{
		if(str.length() ==0 && pattern.length()==0)
		{
			return true;
		}
		
		if(str.length()==0 || pattern.length()==0)
		{
			if(pattern.length()==0)
				return false;
			else
			{
				
				for(int i=0;i<pattern.length();i++)
				{
					if(pattern.charAt(i)!='*')
						return false;
						
				}
				return true;
			}
		}
		
		int sch=str.charAt(0);
		int pch=pattern.charAt(0);
		
		String ros=str.substring(1);
		String rop=pattern.substring(1);
		
		boolean ans=false;
		
		if(sch==pch || pch=='?')
		{
			ans= WildCardMatching(ros, rop);
		}
		else if(pch=='*')
		{
			
			boolean empty=WildCardMatching(str, rop);
			
			boolean multiple=WildCardMatching(ros, pattern);
			
			if(empty || multiple)
				ans= true;
		}
		else
		{
			//sch!=pch
			ans= false;
		}
		
		
		return ans;
		
		
	}
	
	
	//using indexes
	
	
	public static boolean WildCardMatching(String str,String pattern,int svidx,int pvidx,int[][] strg)
	{
		if(str.length() ==svidx && pattern.length()==pvidx)
		{
			return true;
		}
		
		if(str.length()==svidx || pattern.length()==pvidx)
		{
			if(pattern.length()==pvidx)
				return false;
			else
			{
				
				for(int i=pvidx;i<pattern.length();i++)
				{
					if(pattern.charAt(i)!='*')
						return false;
						
				}
				return true;
			}
		}
		
		
		if(strg[svidx][pvidx]!=0)
			return strg[svidx][pvidx]==2?true:false;
		
		int sch=str.charAt(svidx);
		int pch=pattern.charAt(pvidx);
		
		//String ros=str.substring(1);
		//String rop=pattern.substring(1);
		
		boolean ans=false;
		
		if(sch==pch || pch=='?')
		{
			ans= WildCardMatching(str, pattern,svidx+1,pvidx+1,strg);
		}
		else if(pch=='*')
		{
			
			boolean empty=WildCardMatching(str, pattern,svidx,pvidx+1,strg);
			
			boolean multiple=WildCardMatching(str, pattern,svidx+1,pvidx,strg);
			
			if(empty || multiple)
				ans= true;
		}
		else
		{
			//sch!=pch
			ans= false;
		}
		strg[svidx][pvidx]=ans==true?2:1;
		
		return ans;
		
		
	}
	
	//bottom up approach
	

	public static boolean WildCardMatchingBUDP(String str,String pattern)
	{
		
		boolean[][] strg=new boolean[str.length()+1][pattern.length()+1];
		
		
		
		
		
		
		
		
		for(int row=str.length();row>=0;row--)
			{
			
			for(int col=pattern.length();col>=0;col--)
			{
				

				if(row==str.length() && col==pattern.length())
				{
					strg[row][col]=true;
				}
				else if(str.length()==row || pattern.length()==col)
				{
					boolean ans=true;

					if(pattern.length()==col)
						ans= false;
					else
					{
						for(int i=col;i<pattern.length();i++)
						{
							if(pattern.charAt(i)!='*')
							{
								ans= false;
								break;
							}
								
						}
						
					}
					strg[row][col]=ans;
				}
				else
				{
				if(str.charAt(row)==pattern.charAt(col) || pattern.charAt(col)=='?')
				{
					strg[row][col]= strg[row+1][col+1];
				}
				else if(pattern.charAt(col)=='*')
				{
					
					boolean empty=strg[row][col+1];
					
					boolean multiple=strg[row+1][col];
					
					if(empty || multiple)
						strg[row][col]= true;
				}
				else
				{
					//sch!=pch
					strg[row][col]= false;
				}
				
				}
				
				
				
				
				
			}
			
			System.out.println();
			
			for(boolean[] a:strg)
				System.out.println(Arrays.toString(a));
			}
		
		
		
		return strg[0][0];

		
		
		
		
		
		
	}
	
	
	/*
	 * Catalan series
	 * No of unique BSTs
	 * 
	 * 
	 */
	public static int noOfUniqueBSTs(int n)
	{
		
		if(n<=1)
			return 1;
		
		
		int total=0;
		for(int i=1;i<=n;i++)
		{
			
			
			int left=noOfUniqueBSTs(i-1);
			int right=noOfUniqueBSTs(n-i);;
			
			int ans=left*right;
			
			total+=ans;
			
			
			
			
		}
		
		return total;
		
		
		
	}
	
	
	
	
	//noOfUniqueBSTs top down
	
	public static int noOfUniqueBSTsTD(int n,int strg[])
	{
		
		if(n<=1)
			return 1;
		
		if(strg[n]!=0)
			return strg[n];
		int total=0;
		for(int i=1;i<=n;i++)
		{
			
			
			int left=noOfUniqueBSTsTD(i-1,strg);
			int right=noOfUniqueBSTsTD(n-i,strg);;
			
			int ans=left*right;
			
			total+=ans;
			
			
			
			
		}
		
		strg[n]=total;
		return total;
		
		
		
	}
	
	//bottom up
	
	public static int noOfUniqueBSTsBU(int tn)
	{
		
		int [] strg=new int[tn+1];
		
		strg[0]=strg[1]=1;
		
		for(int n=2;n<=tn;n++)
		{
			int total=0;
			for(int i=1;i<=n;i++)
			{
				
				
				int left=strg[i-1];
				int right=strg[n-i];
				
				int ans=left*right;
				
				total+=ans;
				
				
				
				
			}
			
			strg[n]=total;
			
			
		}
		
		return strg[tn];
	}
	
	/*
	 * Palindrome partitioning II
	 */
	
	  public int minCut(String s) {
	      //  int[][] strg=new int[s.length()][s.length()];
	        
	       // for(int [] ar:strg)
	          //  Arrays.fill(ar,-1);
	        
	       // return mincuts(s,0,s.length()-1,strg);
	        //return mincutsBU(s);
	         int n=s.length();
	        int strg[][]=new int[n][n];
	        
	       boolean[][] iss=ispalindrome(s);
	        
	       // for(boolean[] t:iss)
	         //   System.out.println(Arrays.toString(t));
	        
	        
	        for(int slide=0;slide<n;slide++)
	        {
	            
	            for(int si=0;si<n-slide;si++)
	            {
	                
	                int ei=si+slide;
	             
	                
	                
	      
	                 if(iss[si][ei])
	                {
	                    strg[si][ei]=0;
	                 }
	                else
	                {
	                    //;
	                    
	                     int cuts=Integer.MAX_VALUE;
	                    for(int i=si;i<=ei-1;i++)
	                     {
	           
	           
	            
	                         int fpp=strg[si][i];
	                        int spp=strg[i+1][ei];
	            
	                     int ans=fpp+spp+1;
	                        if(cuts>ans)
	                    cuts=ans;
	            
	                    }
	                    strg[si][ei]=cuts;
	                }
	                
	            }
	            
	            
	            
	        }
	        
	        
	        
	        
	        return strg[0][s.length()-1];
	        
	    }
	    
	    /*public int mincuts(String s,int si,int ei,int[][] strg)
	    {
	        
	       
	        
	        
	        if(strg[si][ei]!=-1)
	            return strg[si][ei];
	        
	      
	     //       if(ispalindrome(s,si,ei))
	      //      return 0;
	       
	        int cuts=Integer.MAX_VALUE;
	        for(int i=si;i<=ei-1;i++)
	        {
	           
	           
	            
	            int fpp=mincuts(s,si,i,strg);
	            int spp=mincuts(s,i+1,ei,strg);
	            
	           int ans=fpp+spp+1;
	                if(cuts>ans)
	                    cuts=ans;
	            
	        }
	        for(int[] ar:strg)
	            System.out.println(Arrays.toString(ar));
	        
	        System.out.println("---------");
	        strg[si][ei]=cuts;
	        return cuts;
	    }
	    */
	    
	    public  int mincutsBU(String s)
	    {
	        int n=s.length();
	        int strg[][]=new int[n][n];
	        
	       boolean[][] iss=ispalindrome(s);
	        
	       // for(boolean[] t:iss)
	         //   System.out.println(Arrays.toString(t));
	        
	        
	        for(int slide=0;slide<n;slide++)
	        {
	            
	            for(int si=0;si<n-slide;si++)
	            {
	                
	                int ei=si+slide;
	             
	                
	                
	      
	                 if(iss[si][ei])
	                {
	                    strg[si][ei]=0;
	                 }
	                else
	                {
	                    //;
	                    
	                     int cuts=Integer.MAX_VALUE;
	                    for(int i=si;i<=ei-1;i++)
	                     {
	           
	           
	            
	                         int fpp=strg[si][i];
	                        int spp=strg[i+1][ei];
	            
	                     int ans=fpp+spp+1;
	                        if(cuts>ans)
	                    cuts=ans;
	            
	                    }
	                    strg[si][ei]=cuts;
	                }
	                
	            }
	            
	            
	            
	        }
	        
	        
	        
	        
	        return strg[0][s.length()-1];
	        
	        
	    }
	    
	    public boolean[][] ispalindrome(String s)
	    {
	     // System.out.println(s+" "+si+" "+ei);
	      
	        /*
	        if(si==ei)
	           return true;
	      
	        for(int i=si,j=ei;i<j;i++,j--)
	        {
	            if(s.charAt(i)!=s.charAt(j))
	            {
	                return false;
	            }
	        }
	        
	        
	       
	        
	        
	        return true;
	        
	        */
	        
	         boolean[][] is=new boolean[s.length()][s.length()];
	        
	         for(boolean[] t:is)
	            Arrays.fill(t,true);
	        
	        
	        int n=s.length();
	          for(int row=n-2;row>=0;row--)
	             {
	            
	            for(int col=row+1;col<n;col++)
	            {
	                
	                //System.out.println(si+" "+ei);
	                if(row==col)
	                    is[row][col]=true;
	                else
	                {
	                    
	                    if(s.charAt(row)==s.charAt(col))
	                    is[row][col]=is[row+1][col-1];
	                    else
	                        is[row][col]=false;
	                    
	                }
	            }
	              
	          }
	        return is;
	    }
	
	    
	    
	    
	    /*
	     * 
	     * Longest Palindromic subsequence
	     * subsequence: relative order should be matched , not required to be contigi.ous
	     */
	
	    
	    public static int longestPalindromicSubsequence(String s,int si,int ei)
	    {
	    	//System.out.println(si+" "+ei);
	    	if(si>ei)
	    		return 0;
	    	if(si==ei)
	    		return 1;
	    	
	    	
	    	int ans=0;
	    	
	    	if(s.charAt(si)==s.charAt(ei))
	    	{
	    		ans=longestPalindromicSubsequence(s, si+1, ei-1)+2;
	    	}
	    	else
	    	{
	    		
	    		int firstprob=longestPalindromicSubsequence(s, si+1, ei);
	    		int secondprob=longestPalindromicSubsequence(s, si, ei-1);
	    		ans=Math.max(firstprob, secondprob);
	    	}
	    	
	    	return ans;
	    }
	    
	    //top down
	    
	    public static  int longestPalindromicSubsequenceTD(String s,int si,int ei,int[][] strg)
	    {
	    	//System.out.println(si+" "+ei);
	    	if(si>ei)
	    		return 0;
	    	if(si==ei)
	    		return 1;
	    	
	    	if(strg[si][ei]!=0)
                return strg[si][ei];
            
	    	int ans=0;
	    	
	    	if(s.charAt(si)==s.charAt(ei))
	    	{
	    		ans=longestPalindromicSubsequenceTD(s, si+1, ei-1,strg)+2;
	    	}
	    	else
	    	{
	    		
	    		int firstprob=longestPalindromicSubsequenceTD(s, si+1, ei,strg);
	    		int secondprob=longestPalindromicSubsequenceTD(s, si, ei-1,strg);
	    		ans=Math.max(firstprob, secondprob);
	    	}
	    	strg[si][ei]=ans;
	    	return ans;
	    }
    
	    
	    //bottom up
	    
	public static int longestPalindromicSubsequenceBU(String s) {

		int[][] strg = new int[s.length()][s.length()];
		int n = s.length();

		for (int slide = 0; slide < n; slide++) {

			for (int si = 0; si < n - slide; si++) {

				int ei = si + slide;

				if (si == ei)
					strg[si][ei] = 1;
				else {

					int ans = 0;

					if (s.charAt(si) == s.charAt(ei)) {
						ans = strg[si + 1][ ei - 1]+2;
					} else {

						int firstprob = strg[si + 1][ ei];
						int secondprob = strg[si][ ei - 1];
						ans = Math.max(firstprob, secondprob);
					}
					strg[si][ei] = ans;
				}
			}

		}
		return strg[0][n - 1];
	}
	
	/*
	 * K ordered LCS 
	 * in this problem we have given k which is at most we can change 
	 * characters only and considering that change what is length of longest palindrome 
	 * 
	 */
	public static int kOrderedLCSRec(String str1,String str2,int k,int vidx1,int vidx2)
	{
		if(str1.length()==vidx1 || str2.length()==vidx2)
			return 0;
		
		
		int ans=0;
		if(str1.charAt(vidx1)==str2.charAt(vidx2))
			ans=kOrderedLCSRec(str1, str2, k, vidx1+1, vidx2+1)+1;
		else
		{
			
			
			int fp=kOrderedLCSRec(str1, str2, k, vidx1, vidx2+1);
			int sp=kOrderedLCSRec(str1, str2, k, vidx1+1, vidx2);
			int tp=0;
			if(k>=1)
				tp=kOrderedLCSRec(str1, str2, k-1, vidx1+1, vidx2+1)+1;
		
			ans=Math.max(tp, Math.max(fp, sp));
			
		}
		
		
		return ans;
		
		
	}
	
	
	//top down
	

	public static int kOrderedLCSRecTD(String str1,String str2,int k,int vidx1,int vidx2,int strg[][][])
	{
		if(str1.length()==vidx1 || str2.length()==vidx2)
			return 0;
		
		
		if(strg[k][vidx1][vidx2]!=0)
			return strg[k][vidx1][vidx2];
		
		int ans=0;
		if(str1.charAt(vidx1)==str2.charAt(vidx2))
			ans=kOrderedLCSRec(str1, str2, k, vidx1+1, vidx2+1)+1;
		else
		{
			
			
			int fp=kOrderedLCSRec(str1, str2, k, vidx1, vidx2+1);
			int sp=kOrderedLCSRec(str1, str2, k, vidx1+1, vidx2);
			int tp=0;
			if(k>=1)
				tp=kOrderedLCSRec(str1, str2, k-1, vidx1+1, vidx2+1)+1;
		
			ans=Math.max(tp, Math.max(fp, sp));
			
		}
		
		strg[k][vidx1][vidx2]=ans;
		return ans;
		
		
	}
	
	//bottom up
	
	
	public static int kOrderedLCSRecBU(String str1,String str2,int tk)
	{
		
		int[][][] strg=new int[tk+1][str1.length()+1][str2.length()+1];
	
		for(int k=0;k<=tk;k++ )
		{
		for(int row=str1.length()-1;row>=0;row--)
		{
			
			for(int col=str2.length()-1;col>=0;col--)
			{
				
				
				
				int ans=0;
				if(str1.charAt(row)==str2.charAt(col))
					ans=strg[k][ row+1][ col+1]+1;
				else
				{
					
					
					int fp=strg[k][ row][col+1];
					int sp=strg[k][ row+1][col];
					int tp=0;
					if(k>=1)
					{
						tp=strg[k-1][ row+1][ col+1]+1;
						
					}
				
					ans=Math.max(tp, Math.max(fp, sp));
					
				}
				
				strg[k][row][col]=ans;
				
				
				
				
				
				
			}
				
			}
			
			//for(int[] a:strg)
			//	System.out.println(Arrays.toString(a));
			
			//System.out.println();
			
		}
		
		
		return strg[tk][0][0];
		
		
	}
	
	
	
	/*
	 * LCS3String
	 */
	
	public static int lcs3Strings(String str1,String str2,String str3,int vidx1,int vidx2,int vidx3)
	{
		
		if(str1.length()==vidx1 || str2.length()==vidx2 || str3.length()==vidx3)
			return 0;
		
		//check if first char of all 3 string matches
		int ans=0;
		if(str1.charAt(vidx1)==str2.charAt(vidx2) && str2.charAt(vidx2)==str3.charAt(vidx3))
			ans=lcs3Strings(str1, str2, str3, vidx1+1, vidx2+1, vidx3+1)+1;
		else
		{
			
			int fp=lcs3Strings(str1, str2, str3, vidx1+1, vidx2, vidx3);
			int sp=lcs3Strings(str1, str2, str3, vidx1, vidx2+1, vidx3);
			int tp=lcs3Strings(str1, str2, str3, vidx1, vidx2, vidx3+1);
			
			ans=Math.max(fp, Math.max(sp, tp));
			
		}
		
		
		
		return ans;
		
		
		
	}
	
	//top down lcs3strings 

	public static int lcs3StringsTDP(String str1, String str2, String str3, int vidx1, int vidx2, int vidx3,int[][][] strg) {

		if (str1.length() == vidx1 || str2.length() == vidx2 || str3.length() == vidx3)
			return 0;

		// check if first char of all 3 string matches
		
		
		if(strg[vidx1][vidx2][vidx3]!=0)
			return strg[vidx1][vidx2][vidx3];
		
		int ans = 0;
		if (str1.charAt(vidx1) == str2.charAt(vidx2) && str2.charAt(vidx2) == str3.charAt(vidx3))
			ans = lcs3StringsTDP(str1, str2, str3, vidx1 + 1, vidx2 + 1, vidx3 + 1,strg) + 1;
		else {

			int fp = lcs3StringsTDP(str1, str2, str3, vidx1 + 1, vidx2, vidx3,strg);
			int sp = lcs3StringsTDP(str1, str2, str3, vidx1, vidx2 + 1, vidx3,strg);
			int tp = lcs3StringsTDP(str1, str2, str3, vidx1, vidx2, vidx3 + 1,strg);

			ans = Math.max(fp, Math.max(sp, tp));

		}
		strg[vidx1][vidx2][vidx3]=ans;
		return ans;

	}
	
	
	//bottom up approach
	
	
	public static int lcs3StringsBU(String str1, String str2, String str3) {

		int[][][] strg=new int[str1.length()+1][str2.length()+1][str3.length()+1];
		int n1=str1.length();
		int n2=str2.length();
		int n3=str3.length();
		

		for(int x=n1-1;x>=0;x--)
		{
			
			for(int y=n2-1;y>=0;y--)
			{
				
				for(int z=n3-1;z>=0;z--)
				{
					
					
					
					int ans = 0;
					if (str1.charAt(x) == str2.charAt(y) && str2.charAt(y) == str3.charAt(z))
						ans = strg[x+1][y+1][z+1] + 1;
					else {

						int fp = strg[x+1][y][z];
						int sp = strg[x][y+1][z];
						int tp = strg[x][y][z+1];

						ans = Math.max(fp, Math.max(sp, tp));

					}
					strg[x][y][z]=ans;
					
					
					
					
					
					
					
				}
				
			}
			
			
		}
		
		
	
		return strg[0][0][0];

	}
	
	
	
	
	
	/*
	 * Dungeon game
	 */
	
	public static int dungeonGame(int[][] dungeon,int cr,int cc,int er,int ec)
	{
		
		
		if(cr==er && cc==ec)
		{
			
			if(dungeon[cr][cc]<=0)
			{
				return -dungeon[cr][cc]+1;
			}
			else
				return 1;
			
			
		}
		if(cr>er || cc>ec)
			return Integer.MAX_VALUE;
		
		
		int r=dungeonGame(dungeon, cr, cc+1, er, ec);
		int d=dungeonGame(dungeon, cr+1, cc, er, ec);
		
		
		int minamountrequired=Math.min(r, d)-dungeon[cr][cc];
		int ans=0;
	
		if(minamountrequired>=1)
		{
			ans=minamountrequired;
		}
		else
		{
			ans=1;
		}
		
		
		
		
		
		return ans;
		
		
	}
	
	
	//top down
	
	 public static int dungeonGameTDP(int[][] dungeon,int cr,int cc,int er,int ec,int[][] strg)
		{
			
			
			if(cr==er && cc==ec)
			{
				
				if(dungeon[cr][cc]<=0)
				{
					return -dungeon[cr][cc]+1;
				}
				else
					return 1;
				
				
			}
			if(cr>er || cc>ec)
				return Integer.MAX_VALUE;
	        
	        if(strg[cr][cc]!=0)
	            return strg[cr][cc];
			
			
			int r=dungeonGameTDP(dungeon, cr, cc+1, er, ec,strg);
			int d=dungeonGameTDP(dungeon, cr+1, cc, er, ec,strg);
			
			
			int minamountrequired=Math.min(r, d)-dungeon[cr][cc];
			int ans=0;
		
			if(minamountrequired>=1)
			{
				ans=minamountrequired;
			}
			else
			{
				ans=1;
			}
			
			
			
			strg[cr][cc]=ans;
			
			return ans;
			
			
		}
	 
	 //bottom up
	 
	 public static int dungeonGameBU(int[][] dungeon)
		{
			
			int[][] strg=new int[dungeon.length+1][dungeon[0].length+1];
			
			int rowl=dungeon.length;
			int coll=dungeon[0].length;
			
			for(int row=rowl;row>=0;row--)
			{
				
				for(int col=coll;col>=0;col--)
				{
					
					if(row==rowl || col==coll)
					{
						strg[row][col]=Integer.MAX_VALUE;
					}
					else if(row==rowl-1 && col==coll-1)
					{
						
						if(dungeon[row][col]<=0)
						{
							strg[row][col]=-dungeon[row][col]+1;
						}
						else
							strg[row][col]=1;
						
						
					}
					else
					{
			        
			    
					
					
					int r=strg[row][col+1];
					int d=strg[row+1][col];
					
					
					int minamountrequired=Math.min(r, d)-dungeon[row][col];
					int ans=0;
				
					if(minamountrequired>=1)
					{
						ans=minamountrequired;
					}
					else
					{
						ans=1;
					}
					
					
					
					strg[row][col]=ans;
					
					
					}
				}
				
				
				
			}
			
			
			return strg[0][0];
			
			
		}
	 
	 /*
	  * Longest Insreasing subsequence (LIS)
	  */
	 //O(n^2) solution
	 
	 
	 public static int LIS(int[] ar)
	 {
		 
		 
		 int[] strg=new int[ar.length];
		 
		 //filling -1 because considering only 1 number there is subsequence of length 1 initially
		 Arrays.fill(strg, 1);
		 int maxlislen=0;
		 for(int i=1;i<ar.length;i++)
		 {
			 int maxllen=strg[i];
			 for(int j=0;j<i;j++)
			 {
				 int len=0;
				 if(ar[j]<ar[i])
				 {
					 len=strg[j]+1;
					 
				 }
				 
				 if(maxllen<len)
					 maxllen=len;
				 
				 
				 
			 }
			 if(maxlislen<maxllen)
				 maxlislen=maxllen;
			 strg[i]=maxllen;
			 
		 }
		 
		 
		 
		 for(int i:strg)
			 System.out.print(i+" ");
		 
		 System.out.println();
		 return maxlislen;
		 
		 
		 
		 
		 
		 
		 
		 
	 }
	 
	 //LIS logn
	 
	 
	 public static int LISeffecient(int[] ar)
	 {
		 
		 
		 //we will store the last elements of each stages
		 int lastele[]=new int[ar.length];
		 lastele[0]=ar[0];
		 int len=1;
		 for(int i=1;i<ar.length;i++)
		 {
			 int j=len-1;
			 if(lastele[j]<ar[i])
			 {
				 lastele[len]=ar[i];
				 len++;
			 }
			 else
			 {
				 
				/* 
				 while(j>=0 && lastele[j]>=ar[i])
				 {
					 j--;
				 }
				 
				 lastele[j+1]=ar[i];*/
				 //instead of above use binary search to find just greator number than ar[i]
				 int idx=binarySearch(lastele, 0, j, ar[i]);
				 lastele[idx]=ar[i];
			 }
			 
			 
			 for(int k:lastele)
				 System.out.print(" "+k+" ");
			 System.out.println();
			 
		 }
		 
		 
		 
		 
		 return len;
		 
		 
		 
		 
	 }
	 
	 
	 public static int binarySearch(int len[],int si,int ei,int item)
	 {
		 
		 int low=si;
		 int high=ei;
		 
		 
		 
		 while(low<=high)
		 {
			 int mid=(low+high)/2;
			 if(item>len[mid])
			 {
				 low=mid+1;
			 }
			 else
				 high=mid-1;
			 
			 
		 }
		 
		 return low;
	 }
	
}
class pair
{
int color;
int smoke;
}


