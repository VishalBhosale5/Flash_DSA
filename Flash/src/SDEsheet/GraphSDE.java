package SDEsheet;

public class GraphSDE {
	public static void main(String[] args) {
		
	}
	
	 /* finding the connected components in undirected graph
	  * leetcode:https://leetcode.com/problems/number-of-provinces/submissions/
	  * time: O(V+E) space: O(V)
	  * */
    public int findCircleNum(int[][] isConnected) {
        int totalConnectedComp=0;
        int N=isConnected.length;
        boolean[] visited=new boolean[N+1];
        for(int i=1;i<=N;i++)
        {
            if(!visited[i])
            {
                dfs(i,isConnected,visited);
                totalConnectedComp++;
            }
        }
        return totalConnectedComp;
    }

    public void dfs(int src,int[][] graph,boolean[] visited)
    {
        visited[src]=true;

        for(int nbridx=1;nbridx<=graph[src-1].length;nbridx++)
        {
            if(graph[src-1][nbridx-1]==1 && !visited[nbridx] && nbridx!=src)
            dfs(nbridx,graph,visited);

        }
    }

}
