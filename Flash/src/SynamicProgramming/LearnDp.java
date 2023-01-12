package SynamicProgramming;

import java.util.Arrays;

public class LearnDp {

	private static int count,a,b;
	private static long start,timetaken;

	public static void main(String[] args) {
		
		int noOfStair = 25;
		//cracking the coding interview
//		start=System.currentTimeMillis();
//
//		System.out.println(countSteps(noOfStair ,""));
//		System.out.println("no of calls: "+count);
//		timetaken=System.currentTimeMillis()-start;
//		System.out.println("time taken:  "+timetaken);
//		
//		count=0;
//		start=System.currentTimeMillis();
//		int[] ar=new int[11111111];
//		Arrays.fill(ar, -1);
//		System.out.println(countSteps(noOfStair ,"",ar));
//		System.out.println("no of calls: "+count);
//		timetaken=System.currentTimeMillis()-start;
//		System.out.println("time taken:  "+timetaken);
//
//		
//		System.out.println(countSteps(noOfStair));
		
		
//		int[][] grid = { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 } };
//		findRobotPath(grid,"",0,0,new String[grid.length+1][grid.length+1]);
//		generateValidParenthesisString(3,3,"");
		//System.out.println(Coins(new int[] {1,2,3},3,"")+"  "+a);
//		System.out.println(Coins(new int[] {1,2,3},5,"",new int[6])+"  "+b);
//		System.out.println(CoinsDP(new int[] {1,2,3},5,""));
		
//		System.out.println(CoinsChngCombination(new int[] {1,3,5,7},32,"",0));
//		System.out.println(CoinsChngCombination(new int[] {1,3,5,7},32,"",0,new int[80][35]));
//System.out.println(CoinsComDP(new int[] {1,3,5,7},32,""));

//		a=0;
//			NQ(new int[4][4],0,0);
//			System.out.println("*****************");
//			NqOptimzd(new int[4][4],0,0,new int[10],new int[10],new int[10]);
//		
//System.out.println(a);
		
		
		
		
		int[] wt= {15,5,10};
		int[] val= {25,30,15};
		//System.out.println(knapsackrec(wt,val,wt.length-1,10));
		int[][] strg=new int[wt.length][41];
		for(int[] ar:strg)
			Arrays.fill(ar, -1);
		//System.out.println(knapsackMem(wt, val, wt.length-1, 10, strg));
		//KnapsackTD(wt,val,10);
		unboundedKnapsackTD(wt, val, 100);
	}
	private static int knapsackrec(int[] wt, int[] val, int idx,int capacity) {

			if(idx<0 || capacity==0)
				return 0;
			//System.out.println("--"+capacity);
			int i=0;
			if(wt[idx]<=capacity)
			 i= Math.max(val[idx]+knapsackrec(wt, val, idx-1, capacity-wt[idx]), knapsackrec(wt, val, idx-1, capacity));
			int e=knapsackrec(wt, val, idx-1, capacity);
			
			return Math.max(i, e);
	}
	
	private static int knapsackMem(int[] wt, int[] val, int idx,int capacity,int[][] strg) {

		if(idx<0 || capacity==0)
			return 0;
		
		if(strg[idx][capacity]!=-1)
			return strg[idx][capacity];
		
		int i=0;
		if(wt[idx]<=capacity)
		 i= Math.max(val[idx]+knapsackrec(wt, val, idx-1, capacity-wt[idx]), knapsackrec(wt, val, idx-1, capacity));
		else
		i=knapsackrec(wt, val, idx-1, capacity);
		
		return strg[idx][capacity]=i;
}
	private static void KnapsackTD(int[] wt, int[] val, int capacity) {
			
			int n=wt.length;
			//array size and capacity 
			int[][] strg=new int[n+1][capacity+1];
			
			for(int row=0;row<strg.length;row++)
			{
				for(int col=0;col<strg[row].length;col++)
				{
					
				if(row==0 || col==0)
				{
					strg[row][col]=0;
				}
				else
				{
				if(wt[row-1]<=col)
				{
					strg[row][col]=Math.max(val[row-1]+strg[row-1][col-wt[row-1]], strg[row-1][col]);
					
				}
				else
					strg[row][col]=strg[row-1][col];
				
				}	
			}
			}
			
			System.out.println(strg[wt.length][capacity]);
	
	}
	
	
	//unbounded knapsacck
	
	private static void unboundedKnapsackTD(int[] wt, int[] val, int capacity) {
		
		int n=wt.length;
		//array size and capacity 
		int[][] strg=new int[n+1][capacity+1];
		
		for(int row=0;row<strg.length;row++)
		{
			for(int col=0;col<strg[row].length;col++)
			{
				
			if(row==0 || col==0)
			{
				strg[row][col]=0;
			}
			else
			{
			if(wt[row-1]<=col)
			{
				strg[row][col]=Math.max(val[row-1]+strg[row][col-wt[row-1]], strg[row-1][col]);
				
			}
			else
				strg[row][col]=strg[row-1][col];
			
			}	
		}
		}
		
		System.out.println(strg[wt.length][capacity]);

}
	
	private static void NqOptimzd(int[][] board, int row, int col, int[] uc, int[] ld, int[] rd) {
		// TODO Auto-generated method stub
		if(row==board.length)
		{
			for(int[] a:board)
				System.out.println(Arrays.toString(a));
			
			System.out.println("_____________");
			return;
		}
		
		
		while(col<board.length)
		{
			
			if(uc[col]==0 && ld[(board.length-1)+(col-row)]==0 && rd[row+col]==0)
			{
				uc[col]=1;
				ld[(board.length-1)+(col-row)]=1;
				rd[row+col]=1;
				board[row][col]=1;
				NqOptimzd(board, row+1, 0,uc,ld,rd);
				ld[(board.length-1)+(col-row)]=0;
				rd[row+col]=0;
				uc[col]=0;

				board[row][col]=0;
			}
			col++;
		}
	}
	private static void NQ(int[][] board, int row, int col) {
		
		a++;
		if(row==board.length)
		{
			for(int[] a:board)
				System.out.println(Arrays.toString(a));
			
			System.out.println("_____________");
			return;
		}
		
		
		while(col<board.length)
		{
			
			if(isValid(board,row,col))
			{
				board[row][col]=1;
				NQ(board, row+1, 0);
				board[row][col]=0;
			}
			col++;
		}
		
		
	}
	private static boolean isValid(int[][] board, int row, int col) {
		
		//check up
		for(int r=row-1;r>=0;r--)
		{
			if(board[r][col]==1)
				return false;
		}
		
		//check dl
		int r=row-1,c=col-1;
		while(r>=0 && c>=0)
		{
			if(board[r][c]==1)
				return false;
			r--;
			c--;
		}
		
		//check rd
		 r=row-1;
				 c=col+1;
		while(r>=0 && c<board.length)
		{
			if(board[r][c]==1)
				return false;
			r--;
			c++;
		}
		
	
		return true;
	}
	//coin change permutation
	
	private static int Coins(int[] coins, int total, String answer) {
		a++;
		if(total==0)
		{
			
			return 1;
		}
		int ways =0;
		for(int i:coins)
		{
			if(total-i >= 0)
			ways+=Coins(coins, total - i, answer+" "+i);
		}
		return ways;
	}
	

	private static int Coins(int[] coins, int total, String answer,int[] srg) {
		
		b++;
		if(total==0)
		{
			
			return 1;
		}
		
		if(srg[total]!=0)
			return srg[total];
		int ways =0;
		for(int i:coins)
		{
			if(total-i >= 0)
			ways+=Coins(coins, total - i, answer+" "+i,srg);
		}
		srg[total]=ways;
		return ways;
	}


private static int CoinsDP(int[] coins, int total, String answer) {
		
		
	int[] ans=new int[total+1];
	ans[0]=1;
	
	for(int i=1;i<=total;i++)
	{
		int ways=0;
		for(int j=0;j<coins.length;j++)
		{
			int a= i - coins[j] >=0?ans[i-coins[j]]:0;
			ways+=a;
		}
		ans[i]=ways;
	}
	return ans[total];
	}


// coin change cmbination

private static int CoinsChngCombination(int[] coins, int total, String answer,int idx) {
	if(total==0)
	{
		//System.out.println(answer);
		return 1;
	}
	int ways =0;
	for(int i=idx;i<coins.length;i++)
	{
		if(total-coins[i] >= 0)
		ways+=CoinsChngCombination(coins, total-coins[i], answer+ " "+coins[i], i);
	}
	return ways;
}


private static int CoinsChngCombination(int[] coins, int total, String answer,int idx,int[][] strg) {
	if(total==0)
	{
		//System.out.println(answer);
		return 1;
	}
	
	if(strg[total][idx]!=0)
		return strg[total][idx];
	int ways =0;
	for(int i=idx;i<coins.length;i++)
	{
		if(total-coins[i] >= 0)
		ways+=CoinsChngCombination(coins, total-coins[i], answer+ " "+coins[i], i,strg);
	}
	strg[total][idx]=ways;
	return ways;
}




private static int CoinsComDP(int[] coins, int total, String answer) {
	
	int max=0;
	
	for(int i:coins)
		max=Math.max(max, i);
	
	int[][] ans=new int[max+1][total+1];
	
	
		
		for(int col=0;col<ans[0].length;col++)
		{
			for(int row=coins.length-1;row>=0;row--)
			{
				if(col==0 || coins[row]>col)
				{
					if(coins[row]>col && col!=0)
					ans[coins[row]][col]=0;
					else
					   ans[coins[row]][col]=1;
				}
				else if(coins[row]==ans.length-1)
				{
					ans[coins[row]][col]=ans[coins[row]][col-coins[row]];
				}
				else
				{
					ans[coins[row]][col]=ans[coins[row]][col-coins[row]]+ans[coins[row+1]][col];

				}
			}
		}
		
		for(int[] ar:ans)
		{
			System.out.println(Arrays.toString(ar));
		}
	return ans[coins[0]][total];
	
	}
	private static void generateValidParenthesisString(int open, int close, String str) {
		
		if(open==0 && close==0)
		{
			System.out.println(str);
			return;
		}
		
		if(open>0)
		{
			generateValidParenthesisString(open-1, close, str+"(");
			
			
		}
		
		if(open<close)
		{
			generateValidParenthesisString(open, close-1, str+")");
		}
		
	}

	//recursion
	private static void findRobotPath(int[][] grid, String psf,int i,int j) {
		
		if(i>=grid.length || j>=grid.length || i<0 || j<0 || grid[i][j]==1)
			return;
		else if(i==grid.length-1 && j==grid.length-1)
		{
			System.out.println(psf);
			return;
		}
		
		//right
		findRobotPath(grid, psf+"->R", i, j+1);
		findRobotPath(grid, psf+"->D", i+1, j);
	}
	
	//top down
	private static String findRobotPath(int[][] grid, String psf,int i,int j,String[][] matrix) {
		
		if(i>=grid.length || j>=grid.length || i<0 || j<0 || grid[i][j]==1)
			return "";
		else if(i==grid.length-1 && j==grid.length-1)
		{
			System.out.println(psf);
			return psf;
		}
		
		if(matrix[i][j]!=null)
		{
			System.out.println(psf+matrix[i][j]);
			return matrix[i][j];
		}
		//right
		String r=findRobotPath(grid, psf+"->R", i, j+1,matrix);
		String d=findRobotPath(grid, psf+"->D", i+1, j,matrix);
		matrix[i][j+1]=r;
		matrix[i+1][j]=d;
		
		System.out.println(Arrays.toString(matrix[0]));
		return matrix[i][j];
	}
	
	/*
	 * 
	 * ->R->R->D->D->D->R
->D->D->R->R->D->R
->D->D->R->D->R->R
->D->D->D->R->R->R
	 */

	//dp
	private static int countSteps(int noOfStair,String steps) {
		count++;
		if(noOfStair == 0)
		{
		//	System.out.println(steps);
			return 1;
		}
		else if(noOfStair<0)
			return 0;
		
		int oneStep = countSteps(noOfStair-1,steps+"->1");
		int twoStep = countSteps(noOfStair-2,steps+"->2");
		int threeStep = countSteps(noOfStair-3,steps+"->3");
		
		return oneStep+threeStep+twoStep;
		
	}
	
	//memoization
	
	private static int countSteps(int noOfStair,String steps,int[] strg) {
		count++;
		if(noOfStair == 0)
		{
			//System.out.println(steps);
			return 1;
		}
		else if(noOfStair<0)
			return 0;
		
		
		if(strg[noOfStair]!=-1)
			return strg[noOfStair];
		
		int oneStep = countSteps(noOfStair-1,steps+"->1",strg);
		int twoStep = countSteps(noOfStair-2,steps+"->2",strg);
		int threeStep = countSteps(noOfStair-3,steps+"->3",strg);

	
		strg[noOfStair] = oneStep+threeStep+twoStep;
		return oneStep+threeStep+twoStep;
		
	}
	//bottom up
	private static int countSteps(int noOfStair) {
		
		
		
		int[] dp=new int[noOfStair+1];
		
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for(int i=4;i<=noOfStair;i++)
		{
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
	
		return dp[noOfStair];
	}


}
