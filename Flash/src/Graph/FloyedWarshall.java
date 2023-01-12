package Graph;

public class FloyedWarshall {
	
	public static void main(String[] args) {
		int V=4;
		
		int[][] graph= {{0,3,1000,7},{8,0,2,10000},{5,1000,0,1},{2,10000,1000,0}};
		//10000 is infinity to avoid overflow infinity+something
		
		
		
		
		int[][] dist=new int[V][V];
		
		//fill the vallue
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
				dist[i][j]=graph[i][j];
		}
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
				System.out.print(graph[i][j]+" ");
			
			System.out.println();
		}
		int count=0;
		
		for(int k=0;k<V;k++)
		{
			
			
			for(int i=0;i<V;i++)
			{
				
				for(int j=0;j<V;j++)
					{
					
					int oldcost=dist[i][j];
					
					int newcost=dist[i][k]+dist[k][j];
					
					if(oldcost>newcost)
						dist[i][j]=newcost;
					
					count++;
					
					
				}
			}
		}
			
			System.out.println(count);
			for(int i=0;i<V;i++)
			{
				for(int j=0;j<V;j++)
					System.out.print(dist[i][j]+"    ");
				System.out.println();
			}
				
			
			
			
		}
		
		
	}


