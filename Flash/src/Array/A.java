
package Array;
import java.util.*;
public class A {
    public static void main(String args[]) throws Exception {
/*		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  long l=Long.parseLong(br.readLine());
boolean flag=false;

if(l==2 || l==3 || l==5)
	  System.out.println("prime");
else
{

  for(int i=2;i<Math.sqrt(l);i++)
  {
	  if(l%i==0)
	  flag=true;
  }
  
  if(!flag)
	  System.out.println("prime");
  else
	  System.out.println("Not prime");


    }*/
    	
    	
    	
    	/*int x=1;
    	int count=0;
    	while((x<60) && (x>0))
    	{
    		x++;
    		count++;
    	}
    	System.out.println(count);
    	*/
    	char[][] chess={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    
Solution s=new Solution();
System.out.println(s.exist(chess,"ABCCED"));
    	
    }
}

class Solution {
	public boolean exist(char[][] board, String word) {
		if(board.length==0 || word==null || word.length()==0)
			return false;

		return searchwd(board,word,0,0,0,new boolean[board.length][board[0].length]);
	}

	public boolean searchwd(char[][] board,String word,int row,int col,int idx,boolean[][] bo)
	{
		for(boolean[] s:bo)
			System.out.println(Arrays.toString(s));
		System.out.println("----------");
   /*       if(col==board[0].length)
        {
            row++;
            col=0;
        }

        if(row==board.length)
            return false;*/

		if(row<0 || col<0 || col>=board[0].length || row>=board.length ||  bo[row][col])
			return false;

		if(idx==word.length())
		{

			for(boolean[] s:bo)
				System.out.println(Arrays.toString(s));
			return true;
		}




		boolean ans=false;

		//R
		if(word.charAt(idx)==board[row][col])
		{
			bo[row][col]=true;
			ans=  searchwd(board,word,row,col+1,idx+1,bo) || searchwd(board,word,row-1,col,idx+1,bo) || searchwd(board,word,row+1,col,idx+1,bo) ||searchwd(board,word,row,col-1,idx+1,bo);

			bo[row][col]=false;
		}
		else
			ans=  searchwd(board,word,row,col+1,idx,bo) || searchwd(board,word,row-1,col,idx,bo) || searchwd(board,word,row+1,col,idx,bo) || searchwd(board,word,row,col-1,idx,bo);


		return ans;
	}
}