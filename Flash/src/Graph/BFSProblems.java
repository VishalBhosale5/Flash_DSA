package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BFSProblems {

	/*
	 * Algorithm for searching in graph data structure. it starts from src node and
	 * explores all the neighbour nodes of current depth/level prior to moving on to
	 * the the nodes at next depth.
	 * 
	 * In BFS we visits nodes level by level means level 1 nodes are visited first
	 * then level 2( all childs of curr node are vsisted then their childs) Hence we
	 * use Queue data structure to impelement BFS. we also use visited array to
	 * avoid the stackoverflow because in undirected graph a can visted to b and b
	 * can also visit to a later so it will go in infinite recursion. we will not
	 * vsisted the already visited node again BFS always gives shortest path till
	 * destination node as it travers level by levels.
	 */
	public static void main(String[] args) {

		Graph g = new Graph();
		/*
		 * g.addVertex("A"); g.addVertex("B"); g.addVertex("C"); g.addVertex("D");
		 * g.addVertex("E"); g.addVertex("F"); g.addVertex("G"); // g.addVertex("7");
		 * g.addEdge("A", "D", 5); g.addEdge("A", "B", 6); g.addEdge("B", "C", 3);
		 * g.addEdge("C", "D", 9); g.addEdge("D", "E", 4); g.addEdge("E", "F", 4);
		 * g.addEdge("E", "G", 4); g.addEdge("F", "G", 4); g.display();
		 * g.removeEdge("D", "E");
		 */

		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "B", 10);
		g.addEdge("B", "C", 20);
		g.addEdge("C", "D", 30);
		g.addEdge("A", "D", 11);
		g.addEdge("D", "E",5);
	//	g.addEdge("C", "E",5);
		g.addEdge("C", "F",2);

		g.addEdge("E", "F", 1);
		g.addEdge("E", "G", 9);
		g.addEdge("F", "G", 1);
		g.display();
		// g.removeEdge("D", "E");

		// BFS("A", g);
		// BFSPath("A", g);
		//getConnectedComponents(g);
		
		//System.out.println(topologicalSortBFSKahnsalgorithm(g));
		//System.out.println(detectCycle(g));
		System.out.println(Dijkstras(g, "A"));

	}

	/*
	 * BFS traversal using Queue time:O(V+E) space: O(V)
	 */
	public static void BFS(String src, Graph g) {

		Queue<String> q = new LinkedList<>();
		HashSet<String> processed = new HashSet<>();

		q.add(src);

		while (!q.isEmpty()) {
			// remove
			String rm = q.remove();
			// print

			if (!processed.contains(rm))
				System.out.print(rm + " -> ");
			else
				continue;

			// mark as processed

			processed.add(rm);
			// add neighbours

			for (String key : g.vtces.get(rm).neighbr.keySet()) {

				if (!processed.contains(key)) {
					q.add(key);

				}

			}

		}
		System.out.println();

	}

	/*
	 * BFS traversal with priting the path from src to each vertex
	 * 
	 * 
	 * we can Also use BFT which handles when we have more than one connected
	 * components it performs BFS from each vertex
	 */

	public static void BFSPath(String src, Graph g) {
		Queue<Pair> q = new LinkedList<>();
		HashSet<String> processed = new HashSet<>();

		Pair p = new Pair();
		p.vertex = src;
		p.psf = src;
		q.add(p);

		// processed.add(src);

		while (!q.isEmpty()) {
			// remove
			Pair rm = q.remove();
			// print

			if (!processed.contains(rm.vertex))
				System.out.println(rm.vertex + " via  " + rm.psf);
			else
				continue;

			// mark
			processed.add(rm.vertex);

			// add neighbours

			for (String key : g.vtces.get(rm.vertex).neighbr.keySet()) {

				if (!processed.contains(key)) {
					Pair pp = new Pair();
					pp.vertex = key;
					pp.psf = rm.psf + key;
					q.add(pp);

				}

			}

		}

	}

	/*
	 * problem: to find the connected components in the undirected graph print count
	 * and component nodes. if a graph have single componenet then we can say it as
	 * connected graph approach : we will simply peform the BFS or DFS on each
	 * vertex.
	 * 
	 * time: O(V+E) since we are using BFS or DFS traversal space: O(V+E) to store
	 * the vertices and edges
	 */

	public static void getConnectedComponents(Graph g) {
		HashSet<String> visited = new HashSet<>();
		int count = 0;
		for (String key : g.vtces.keySet()) {

			if (!visited.contains(key)) {
				System.out.print(++count + " :-   ");
				BFSUtil(key, g, visited);
			}
		}
	}

	public static void BFSUtil(String src, Graph g, HashSet<String> processed) {

		Queue<String> q = new LinkedList<>();
		// HashSet<String> processed = new HashSet<>();

		q.add(src);

		while (!q.isEmpty()) {
			// remove
			String rm = q.remove();
			// print

			if (!processed.contains(rm))
				System.out.print(rm + " -> ");
			else
				continue;

			// mark as processed

			processed.add(rm);
			// add neighbours

			for (String key : g.vtces.get(rm).neighbr.keySet()) {

				if (!processed.contains(key)) {
					q.add(key);

				}

			}

		}
		System.out.println();

	}

	
	/*
	 *  kahn's Algorithm for topoplogical sort :  we are using BFS
	 * approach Time: O(V+E) due to BFS space: O(N) Queue and idegree array
	 */
	
	
	public static ArrayList<String> topologicalSortBFSKahnsalgorithm(Graph g)
	{
		ArrayList<String> ans=new ArrayList<>();
		//first calculate the indegree of all the vertices
		
		
		HashMap<String,Integer> indegree=new HashMap<>();
		
		
		for(String key: g.vtces.keySet())
		{
			System.out.println(key);
			if(!indegree.containsKey(key))
			{
				indegree.put(key, 0);
			}
			
			for(String nbr:g.vtces.get(key).neighbr.keySet())
			{
				indegree.put(nbr, indegree.get(nbr)==null?1:indegree.get(nbr)+1);
			}
			System.out.println(indegree);
		}
		
		
		//now for each vertex if indegree is 0 then push into the Queue
		Queue<String> q=new LinkedList<>();
		
		for(String key:indegree.keySet())
		{
			if(indegree.get(key)==0)
				q.add(key);
		}
		
		//now for each vertex remove and deduce the indegree from his neighbours
		
		while(!q.isEmpty())
		{
			
			String rm=q.poll();
			ans.add(rm);
			
			for(String k:g.vtces.get(rm).neighbr.keySet())
			{
				indegree.put(k, indegree.get(k)-1);
				
				if(indegree.get(k)==0)
					q.add(k);
			}
			
			
			
			
			
			
			
		}
		return ans;
		
		
	}
	
	/*
	 * Problem: Detect a cycle in undirected graph using BFS
	 * Approach: to perform BFS with passing current vertex and parent vertex , if next adjacent vertex is visited but not the parent of current vertex then it has cycle.
	 * time: O(V+E) due to BFS
	 * Space: O(V) for queue and visited O(V)
	 */
	
	
	public static  boolean detectCycle(Graph g)
	{
		
		HashSet<String> visited=new HashSet<>();
		
		
		for(String adj:g.vtces.keySet())
		{
			if(!visited.contains(adj)) {
				if(hascycle(adj,g,visited,"-1"))
				{
					return true;
				}
			}
			
		}
		
		
		return false;
	}

	private static boolean hascycle(String adj, Graph g, HashSet<String> visited, String parent) {
		
		
		Queue<cyclepair> q=new LinkedList<>();
		cyclepair p=new cyclepair();
		p.vertex=adj;
		p.parent=parent;
		q.add(p);
		
		while(!q.isEmpty())
		{
			cyclepair rmv=q.poll();
			
			visited.add(rmv.vertex);
			
		for(String key:g.vtces.get(rmv.vertex).neighbr.keySet())
		{
			if(!visited.contains(key))
			{
				cyclepair pp=new cyclepair();
				pp.vertex=key;
				pp.parent=rmv.vertex;
				q.add(pp);
			}
			else if(key!=rmv.parent)
				return true;
		}
		
		}
		return false;
	}
	
	
	/*
	 * 
	 * problem: Dijkstras algorithm to find the shortest path from source to all other certices
	 * approach: use BFS but instead of queue use priority queue as BFS finds the shortest path 
	 * time:O(V+E)  BFS
	 * space: O(V) for visited and ans O(V)
	 */
	public static HashMap<String,Integer> Dijkstras(Graph g, String src)
	{
		
		PriorityQueue<djkstrapair> q=new PriorityQueue<>();
		HashMap<String,Integer> ans=new HashMap<>();
		djkstrapair pair=new djkstrapair();
		pair.vname=src;
		pair.psf=src;
		pair.wsf=0;
		q.add(pair);
		HashSet<String> visited=new HashSet<>();
		
		while(!q.isEmpty())
		{
			
			//remove
			djkstrapair pp=q.poll();
			System.out.println(pp.vname);
			//ans
			
			if(visited.contains(pp.vname))
				continue;
			ans.put(pp.vname, pp.wsf);
			
			//mark
			visited.add(pp.vname);
			
			for(String nbr:g.vtces.get(pp.vname).neighbr.keySet())
			{
				if(!visited.contains(nbr))
				{
					djkstrapair np=new djkstrapair();
					np.vname=nbr;
					np.psf=pp.psf+nbr;
					np.wsf=pp.wsf+g.vtces.get(pp.vname).neighbr.get(nbr);
					q.add(np);
				}
				
			}
			
			
			
			System.out.println(q);
			
		}
		return ans;
		
		
	}
	
	
	

}


class djkstrapair implements Comparable<djkstrapair>
{
String vname;
String psf;
int wsf;
@Override
public int compareTo(djkstrapair o) {
	
	return this.wsf-o.wsf;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.vname;
	}
}
class cyclepair
{
String vertex;
String parent;
}
class Pair {
	String vertex;
	String psf;

}
