package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DfsProblems {

	public static void main(String[] args) {
		
		/*
		 * DFS traversal is like pre/post/inorder traversal 
		 *
		 */

		Graph g = new Graph();
	/*	g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addVertex("5");
		g.addVertex("6");
		g.addVertex("7");
		g.addEdge("0", "2", 5);
		g.addEdge("0", "3", 6);
		g.addEdge("0", "1", 3);
		g.addEdge("1", "2", 9);
		g.addEdge("2", "4", 4);

		g.addEdge("5", "6", 9);
		g.addEdge("6", "7", 6);*/
		
		/*g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addVertex("5");
		g.addVertex("6");
		g.addVertex("7");
		//g.addVertex("8");
		//g.addVertex("E");
		
		//g.addVertex("B");
		g.addEdge("0", "1", 5);
		g.addEdge("3", "0", 6);
		g.addEdge("1", "2", 6);
		g.addEdge("2", "4", 6);
		g.addEdge("4", "5", 6);
		g.addEdge("6", "4", 6);
		g.addEdge("5", "6", 6);
		g.addEdge("6", "7", 6);
		g.addEdge("2", "3", 6);*/
		//g.addEdge("2", "3", 6);
		/*g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		// g.addVertex("7");
		g.addEdge("A", "D", 5);
		g.addEdge("A", "B", 6);
		g.addEdge("C", "B", 3);
		g.addEdge("D", "C", 9);
		g.addEdge("D", "E", 4);
		g.addEdge("E", "F", 4);
		g.addEdge("E", "G", 4);
		g.addEdge("G", "F", 4);*/
		//g.display();
		
		
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		//g.addVertex("7");
	//g.addEdge("D", "A", 5);
		g.addEdge("A", "B", 6);
		g.addEdge("B", "C", 3);
		g.addEdge("C", "D", 9);
		g.addEdge("D", "E", 4);
	g.addEdge("E", "F", 4);
		g.addEdge("F", "G", 4);
		g.addEdge("E", "G", 4);
		g.display();
		/*// for disconnected component
		int count=0;
		
		//to find the no of connected components in a graph (count)
		for (String key : g.vtces.keySet()) {

			if (!visited.contains(key))
			{
				count++;
			
				DFStvsl(key,g);
			}

		}
		System.out.println();
		System.out.println("connected components are: "+count);
		DFStvslitr("0",g);
		System.out.println();
		DFSPath("0", g);*/
		//topolocalSorting(g);
		//DFStvslitr("A", g);
		//Kosarajusalgorithm(g);
		//System.out.println(detectCycledfsund(g));
		DFStvsl("A", g);
		System.out.println("\n\n\n\n");
		findBridgesinGraph(g);

	}

	
	//DFS traversal using recursion O(v+E)
	static HashSet<String> visited = new HashSet<>();

	public static void DFStvsl(String src,Graph g) {

		// Vertex pair=this.vtces.get(src);
		System.out.print(src + " ->");
		visited.add(src);

		for (String key : g.vtces.get(src).neighbr.keySet()) {
			if (!visited.contains(key))
				DFStvsl(key,g);
		}

	}

	// DFS traversal iterative O(E+V)
	public static void DFStvslitr(String src,Graph g) {
		HashSet<String> visited = new HashSet<>();
		Stack<String> st = new Stack<>();

		st.push(src);
		//visited.add(src);

		while (!st.isEmpty()) {
			// remove ,mark ,add neighbour

			String rm = st.pop();
			
			if(!visited.contains(rm))
			System.out.print(rm + " ->");
			else
				continue;
			visited.add(rm);

			for (String nbr : g.vtces.get(rm).neighbr.keySet()) {
				if (visited.contains(nbr) == false) {
					st.push(nbr);
					//visited.add(nbr);
				}
			}

		}

	}
	
	
	//dfs path traverse
	
	public static void DFSPath(String src,Graph g) {
		HashSet<String> visited = new HashSet<>();
		Stack<Pairs> st = new Stack<>();
		Pairs p=new Pairs();
		p.vertex=src;
		p.psf=src;
		st.push(p);
		//visited.add(src);

		while (!st.isEmpty()) {
			// remove ,mark ,add neighbour

			Pairs rm = st.pop();
			
			if(!visited.contains(rm.vertex))
			System.out.println(rm.vertex + " via "+rm.psf );
			else
				continue;
			
			visited.add(rm.vertex);

			for (String nbr : g.vtces.get(rm.vertex).neighbr.keySet()) {
				if (visited.contains(nbr) == false) {
					Pairs pr=new Pairs();
					pr.vertex=nbr;
					pr.psf=rm.psf+nbr;
					st.push(pr);
					//visited.add(nbr);
				}
			}

		}

	}
	
	
	
	
	/*
	 * Algorithm: Topological sorting (DFS) here we are using a version of dfs
	 * approach Time: O(V+E) due to DFS space: O(N) stack and visited array
	 */

	public static Stack<String> topolocalSorting(Graph g) {
		HashSet<String> visited = new HashSet<>();
		Stack<String> st = new Stack<>();
		int count = 0;
		for (String key : g.vtces.keySet()) {

			if (!visited.contains(key)) {
				DFSUtiltp(key, g, visited, st);
			}
		}
		
		return st;
	}

	private static void DFSUtiltp(String src, Graph g, HashSet<String> visited, Stack<String> stk) {
		
		// Vertex pair=this.vtces.get(src);
		//System.out.print(src + " ->");
		visited.add(src);

		for (String key : g.vtces.get(src).neighbr.keySet()) {
			if (!visited.contains(key))
				DFSUtiltp(key, g, visited, stk);
		}
		stk.push(src);
		
	}
	
	
	
	
	
	/*
	 * problem :  to Find and print strongly connected components in a graph.
	 * appriach: we will be using kosaraju's algorithm to find the strongly connected components
	 * 
	 * Time : O(V+E)  //DFS 2 times
	 * Space: O(V+E)             //O(V+E) + O(V) +O(V) for transpose graph. visited and stack
	 * 
	 * 
	 * We can also check if graph is strongly connected or not.
	 */
	
	
	
	public static void Kosarajusalgorithm(Graph g)
	{
		HashSet<String> visited = new HashSet<>();

		//first get vextex sorted based on their finishing time (topological sort)
		
		Stack<String> st=topolocalSorting(g);
		
		//transpose the graph
		
		HashMap<String,Vertex> transpose=new HashMap<>();
		for(String src: g.vtces.keySet())
		{

			for(String dest:g.vtces.get(src).neighbr.keySet())
			{
				HashMap<String, Integer> nbr = new HashMap<>();
				nbr.put(src, g.vtces.get(src).neighbr.get(dest));
				Vertex vtx=new Vertex();
				vtx.neighbr=nbr;
				transpose.put(dest, vtx);

			}
			

		}
		
		
		for (String key : transpose.keySet()) {
			System.out.print(key + " -> ");
			System.out.print(transpose.get(key).neighbr);
			System.out.println();
		}
		
		System.out.println(st);
		
		
		while(!st.isEmpty())
		{
			
			String rm=st.pop();
			
			if(!visited.contains(rm))
			{
				DFSUtilScc(rm, transpose, visited);
				System.out.println();
			}
		}
		
		
		
		
	}
	
 static void DFSUtilScc(String src, HashMap<String,Vertex> g, HashSet<String> visited) {
		
		// Vertex pair=this.vtces.get(src);
		System.out.print(src + " ->");
		visited.add(src);

		for (String key : g.get(src).neighbr.keySet()) {
			if (!visited.contains(key))
				DFSUtilScc(key, g, visited);
		}
		
	}
 
 
 /*
	 * Problem: Detect a cycle in undirected graph using DFS
	 * Approach: to perform dfs with passing current vertex and parent vertex , if next adjacent vertex is visited but not the parent of current vertex then it has cycle.
	 * time: O(V+E) due to DFS
	 * Space: O(V) for queue and visited O(V)
	 */
	
	
	public static  boolean detectCycledfs(Graph g)
	{
		
		HashSet<String> visited=new HashSet<>();
		
		
		for(String adj:g.vtces.keySet())
		{
			if(!visited.contains(adj)) {
				if(hascyclee(adj,g,visited,"-1"))
				{
					return true;
				}
			}
			
		}
		
		
		return false;
	}

	private static boolean hascyclee(String adj, Graph g, HashSet<String> visited, String parent) {
		
	System.out.println(adj+" - "+parent);
	visited.add(adj);
	System.out.println(visited);

		for(String key:g.vtces.get(adj).neighbr.keySet())
		{
			System.out.println(key+"----");

			if(!visited.contains(key))
			{
				boolean b=hascyclee(key, g, visited, adj);
				if(b)
				{
					System.out.println("0000"+key+" - "+adj);
					return true;
				}
			}
			else if(key!=parent)
			{
				
				System.out.println("***********");
				System.out.println(adj+" - "+parent+"  "+key);
				return true;
			}
			//System.out.println(key);


		}
		
		System.out.println("returning "+adj+" "+parent);
		return false;
	}

	
	 /*
		 * Problem: Detect a cycle in directed graph using DFS
		 * Approach: to perform dfs with passing visited and currdfs call if it is present in both the array then it is cycle there.
		 * time: O(V+E) due to DFS
		 * Space: O(V) for queue and visited O(V)
		 */
		
		
		public static  boolean detectCycledfsund(Graph g)
		{
			
			HashSet<String> visited=new HashSet<>();
			HashSet<String> currdfs=new HashSet<>();
			
			for(String adj:g.vtces.keySet())
			{
				if(!visited.contains(adj)) {
					if(hascycleeun(adj,g,visited,currdfs))
					{
						return true;
					}
				}
				
			}
			
			
			return false;
		}

		private static boolean hascycleeun(String adj, Graph g, HashSet<String> visited, HashSet<String> crdfs) {
			
		System.out.println(adj);
		visited.add(adj);
		crdfs.add(adj);
		System.out.println(visited);
		System.out.println(crdfs);

			for(String key:g.vtces.get(adj).neighbr.keySet())
			{
				System.out.println(key+"----");

				if(!visited.contains(key))
				{
					boolean b=hascycleeun(key, g, visited, crdfs);
					if(b)
					{
						System.out.println("0000"+key+" - "+adj);
						return true;
					}
				}
				else if(crdfs.contains(key))
				{
					
					System.out.println("***********");
					return true;
				}
				//System.out.println(key);


			}
			
			//visited.remove(adj);
			crdfs.remove(adj);
			
			System.out.println("returning "+adj);
			return false;
		}
		
		//O(V+E) DFS traversal
		public static void findBridgesinGraph(Graph g)
		{
			
			HashSet<String> visited=new HashSet<>();
			
			HashMap<String,Integer> dis=new HashMap<>();
			HashMap<String,Integer> low=new HashMap<>();
			int timer=0;
			
			for(String nodes:g.vtces.keySet())
			{
				if(!visited.contains(nodes))
					DFSUtilBridges(nodes, "-1", g, visited, timer, dis, low);
			}

			
			
		}
		
		private static void DFSUtilBridges(String src,String parent, Graph g, HashSet<String> visited, int timer,HashMap<String,Integer> dis,HashMap<String,Integer> low) {
			
		//System.out.println(src+" ---- "+parent+"   "+timer);
			visited.add(src);
			timer++;

			dis.put(src, timer);
			low.put(src, timer);
			System.out.println(dis);
			System.out.println(low);
			System.out.println();
			for (String key : g.vtces.get(src).neighbr.keySet()) {
				
				if(key==parent)
					continue;
				if (!visited.contains(key))
				{
					DFSUtilBridges(key,src, g, visited, timer,dis,low);
					//System.out.println(dis);
					//System.out.println(low);
					
					low.put(src, Math.min(low.get(key), low.get(src)));
					
					
					if(low.get(key) > dis.get(src))
					{
						System.out.println("Bridge edge : "+src+" "+key);
					}

					
				}
				else
				{
					low.put(src, Math.min(dis.get(key), low.get(src)));
				}
				
				
			}
			
			//System.out.println("returning ...");
		//	System.out.println(dis);
			//System.out.println(low);
			//System.out.println();
			
		}
		


}
class Pairs
{
	String vertex;
	String psf;
	
	
}

 class Vertex {

	HashMap<String, Integer> neighbr = new HashMap<>();

}
