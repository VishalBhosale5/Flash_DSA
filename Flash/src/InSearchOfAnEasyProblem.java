import java.util.*;
import java.io.*;

public class InSearchOfAnEasyProblem
{
    public static void main(String args[]) throws Exception
    {
       //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       Scanner sc=new Scanner(System.in);
			int l = sc.nextInt();
		for(int i=0;i<l;i++)
		{
			boolean b=false;

		          int m=sc.nextInt();
		          int[] a=new int[m];
		          
		          for(int j=0;j<m;j++)
		          {
		                    a[j]=sc.nextInt();
		                    
		                    
		          }
		          
		          Arrays.sort(a);
		     
		          
		          for(int k=0;k<a.length-1;k++)
		          {
		                    if(Math.abs(a[k]-a[k+1])>1) {
		                    	b=true;
		                    	break;
		                    }
		                    	
		                    
		          }
		          
		          	if(b)
			      	System.out.println("NO");
		          	else
				      	System.out.println("YES");


		          
		}
		
		
		
	
			
			
			
    }
}
        
        
    













