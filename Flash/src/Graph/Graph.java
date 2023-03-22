package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Heap.HeapGeneric;

public class Graph {

	public class Vertex {

		HashMap<String, Integer> neighbr = new HashMap<>();

	}

	HashMap<String, Vertex> vtces;

	Graph() {
		vtces = new HashMap<>();

	}

	public int numVertex() {

		return this.vtces.size();
	}

	public boolean containVertex(String vertex) {

		return this.vtces.containsKey(vertex);

	}

	public void addVertex(String vertex) {
		Vertex vtx = new Vertex();

		this.vtces.put(vertex, vtx);

	}

	public void removeVertex(String vertex) {

		Vertex vt = vtces.get(vertex);

		for (String key : vt.neighbr.keySet()) {
			vtces.get(key).neighbr.remove(vertex);
		}

		vtces.remove(vertex);
	}

	public int numEdges() {
		int size = 0;

		for (String key : this.vtces.keySet()) {
			size += vtces.get(key).neighbr.size();
		}

		return size / 2;
	}

	public boolean containEdge(String s, String e) {

		Vertex vtx = vtces.get(s);
		Vertex vtx1 = vtces.get(e);

		if (vtx == null || vtx1 == null)
			return false;
		else
			return vtx.neighbr.containsKey(e); // birctional hence only one is suffice
	}

	public void addEdge(String s, String e, int cost) {
		Vertex vtx = vtces.get(s);
		Vertex vtx1 = vtces.get(e);

		if (vtx == null || vtx1 == null || vtx.neighbr.containsKey(e))
			return;

		vtx.neighbr.put(e, cost);
		//comment below line for bellman ford directed graph
		//vtx1.neighbr.put(s, cost);

	}

	public void removeEdge(String s, String e) {

		Vertex vt1 = vtces.get(s);
		Vertex vt2 = vtces.get(e);

		if (vt1 == null || vt2 == null || !vt1.neighbr.containsKey(e))
			return;

		vt1.neighbr.remove(e);
		//vt2.neighbr.remove(s);

	}

	public boolean hasPath(String s, String e, HashSet<String> set) {
		// hashset to not check the visited node again
		set.add(s);
		if (containEdge(s, e))
			return true;

		for (String key : vtces.get(s).neighbr.keySet()) {

			if (!set.contains(key) && hasPath(key, e, set))
				return true;
		}
		return false;
	}

	public void display() {
		// ArrayList<String> list=new ArrayList<>(vtces.keySet());
		for (String key : vtces.keySet()) {
			System.out.print(key + " -> ");
			System.out.print(vtces.get(key).neighbr);
			System.out.println();
		}

	}

	public class Pair {

		String vertex;
		String pathSoFar;

	}
	
		//O(E+V)
	public boolean BFS(String src, String dest) {
		Queue<Pair> q = new LinkedList<>();
		HashSet<String> processed = new HashSet<>();
		Pair sp = new Pair();
		sp.vertex = src;
		sp.pathSoFar = src;
		q.add(sp);

		while (!q.isEmpty()) {

			Pair rp = q.poll();

			if (processed.contains(rp.vertex))
				continue;

			processed.add(rp.vertex);

			if (containEdge(rp.vertex, dest)) {
				System.out.println(rp.pathSoFar + "" + dest);
				return true;
			}

			Vertex vt = vtces.get(rp.vertex);

			for (String key : vt.neighbr.keySet()) {
				if (!processed.contains(key)) {
					Pair p = new Pair();
					p.vertex = key;
					p.pathSoFar = rp.pathSoFar + key;
					q.add(p);
				}
				// processed.add(key);
			}
		}
		return false;
	}
	
	//O(E+V)
	public void BFT() {
		Queue<Pair> q = new LinkedList<>();
		HashSet<String> processed = new HashSet<>();
		
		//for loop in case graph is disconnected
		
		for (String key : vtces.keySet()) {
			if (processed.contains(key))
				continue;
			Pair sp = new Pair();
			sp.vertex = key;
			sp.pathSoFar = key;

			q.add(sp);

			while (!q.isEmpty()) {

				Pair rp = q.poll();

				if (processed.contains(rp.vertex))
					continue;

				processed.add(rp.vertex);

				System.out.println(rp.vertex + " via" + rp.pathSoFar);

				Vertex vt = vtces.get(rp.vertex);

				for (String keys : vt.neighbr.keySet()) {
					if (!processed.contains(keys)) {
						Pair p = new Pair();
						p.vertex = keys;
						p.pathSoFar = rp.pathSoFar + keys;

						q.add(p);
					}

					// processed.add(key);

				}
			}
		}
	}
	
	//O(E+V)
	public ArrayList<ArrayList<String>> getConnectedComponents() {

		ArrayList<ArrayList<String>> list = new ArrayList<>();
		Queue<Pair> q = new LinkedList<>();
		HashSet<String> processed = new HashSet<>();
		for (String key : vtces.keySet()) {

			if (processed.contains(key))
				continue;
			ArrayList<String> subans = new ArrayList<>();
			Pair sp = new Pair();
			sp.vertex = key;
			sp.pathSoFar = key;

			q.add(sp);

			while (!q.isEmpty()) {

				Pair rp = q.poll();

				if (processed.contains(rp.vertex))
					continue;

				processed.add(rp.vertex);

				// System.out.println(rp.vertex+" via"+rp.pathSoFar);
				subans.add(rp.vertex);

				Vertex vt = vtces.get(rp.vertex);

				for (String keys : vt.neighbr.keySet()) {
					if (!processed.contains(keys)) {
						Pair p = new Pair();
						p.vertex = keys;
						p.pathSoFar = rp.pathSoFar + keys;

						q.add(p);
					}

					// processed.add(key);

				}

			}

			list.add(subans);
		}

		return list;
	}
	//O(E+V) //in undirected graph
	public boolean isCyclic() {
		Queue<Pair> q = new LinkedList<>();
		HashSet<String> processed = new HashSet<>();
		for (String key : vtces.keySet()) {

			if (processed.contains(key))
				continue;

			Pair sp = new Pair();
			sp.vertex = key;
			sp.pathSoFar = key;

			q.add(sp);

			while (!q.isEmpty()) {

				Pair rp = q.poll();

				if (processed.contains(rp.vertex))
					return true;

				processed.add(rp.vertex);

				// System.out.println(rp.vertex+" via"+rp.pathSoFar);

				Vertex vt = vtces.get(rp.vertex);

				for (String keys : vt.neighbr.keySet()) {
					if (!processed.contains(keys)) {
						Pair p = new Pair();
						p.vertex = keys;
						p.pathSoFar = rp.pathSoFar + keys;

						q.add(p);
					}

					// processed.add(key);

				}

			}
		}
		return false;
	}
	//O(E+V)  if 1 connected component then connected graph
	public boolean isConnected() {
		Queue<Pair> q = new LinkedList<>();
		HashSet<String> processed = new HashSet<>();
		// add last and removefirst
		int flag = 0;

		for (String key : vtces.keySet()) {

			if (processed.contains(key))
				continue;

			flag++;
			Pair sp = new Pair();
			sp.vertex = key;
			sp.pathSoFar = key;

			q.add(sp);

			while (!q.isEmpty()) {

				Pair rp = q.poll();

				if (processed.contains(rp.vertex))
					continue;

				processed.add(rp.vertex);

				// System.out.println(rp.vertex+" via"+rp.pathSoFar);

				Vertex vt = vtces.get(rp.vertex);

				for (String keys : vt.neighbr.keySet()) {
					if (!processed.contains(keys)) {
						Pair p = new Pair();
						p.vertex = keys;
						p.pathSoFar = rp.pathSoFar + keys;

						q.add(p);
					}

					// processed.add(key);

				}

			}
		}
		if (flag >= 2)
			return false;
		else
			return true;
	}
	//O(E+V)
	public boolean DFS(String src, String dest) {
		Stack<Pair> st = new Stack<>();
		HashSet<String> processed = new HashSet<>();
		// add last and removefirst
		Pair sp = new Pair();
		sp.vertex = src;
		sp.pathSoFar = src;

		st.push(sp);

		while (!st.isEmpty()) {

			Pair rp = st.pop();

			if (processed.contains(rp.vertex))
				continue;

			processed.add(rp.vertex);

			if (containEdge(rp.vertex, dest)) {
				System.out.println(rp.pathSoFar + "" + dest);
				return true;
			}

			Vertex vt = vtces.get(rp.vertex);

			for (String key : vt.neighbr.keySet()) {
				if (!processed.contains(key)) {
					Pair p = new Pair();
					p.vertex = key;
					p.pathSoFar = rp.pathSoFar + key;

					st.push(p);
				}

				// processed.add(key);

			}

		}

		return false;

	}
	//O(E+V)
	public void DFT() {
		Stack<Pair> st = new Stack<>();
		HashSet<String> processed = new HashSet<>();
		// add last and removefirst

		for (String key : vtces.keySet()) {

			if (processed.contains(key))
				continue;

			Pair sp = new Pair();
			sp.vertex = key;
			sp.pathSoFar = key;

			st.push(sp);

			while (!st.isEmpty()) {

				Pair rp = st.pop();

				if (processed.contains(rp.vertex))
					continue;

				processed.add(rp.vertex);

				System.out.println(rp.vertex + " via" + rp.pathSoFar);

				Vertex vt = vtces.get(rp.vertex);

				for (String keys : vt.neighbr.keySet()) {
					if (!processed.contains(keys)) {
						Pair p = new Pair();
						p.vertex = keys;
						p.pathSoFar = rp.pathSoFar + keys;

						st.push(p);
					}

					// processed.add(key);

				}

			}
		}
	}

	// directed and undirected graph: if tree is connected && it has no cycle then its tree
	// undirected graph only: we can also check if tree is cyclic or not using = if tree has n-1 edges 
	
	
	//also if u find any edge which connects to its ancestor (visited) which is not his parent then its back edge. if graph contains 
		//back edge means it has cycle.
		
		
	public boolean isTree() {

		return !isCyclic() && isConnected();  //or edges=nodes-1 && isConnected() in case undirected graph
	}

	
	 public boolean isGraphContainsBackEdge(int curr,int parent,HashSet<Integer> visited,ArrayList<ArrayList<Integer>> adj)
	    {
	        
	        visited.add(curr);
	        
	        for(int i:adj.get(curr))
	        {
	            if(!visited.contains(i))
	            {
	              if(isGraphContainsBackEdge(i,curr,visited,adj)) 
	              return true;
	            }
	            else if(i!=parent)
	            return true;
	        }
	        return false;
	    }
	 
	 
	 
	
	//check if graph is bipartitle 
	//assuming graph is connected, if not then run below method in for loop for each vertex
	
	
	public boolean isBartitite(Graph g)
	{
		//BFS traversal
		Queue<String> q=new LinkedList<>();
		//array to track color and visited
		int[] vis=new int[g.numVertex()+1];
		Arrays.fill(vis, -1);
		q.add("1");
		int color=0;
		vis[Integer.parseInt("1")]=color;
		while(!q.isEmpty())
		{
			String node=q.poll();
			for(String nbr:g.vtces.get(node).neighbr.keySet())
			{
				if(vis[Integer.parseInt(nbr)]==-1)
				{
					q.add(nbr);
					vis[Integer.parseInt(nbr)]=vis[Integer.parseInt(node)]==0?1:0;
				}
				else
				{
					if(vis[Integer.parseInt(nbr)]==vis[Integer.parseInt(node)])
						return false;
				}
			}
			
		}
		return true;
	}
	
	
	//check if hamiltonian graph 
	// if hamiltonian cycle then its hamiltonian graph
	//https://www.youtube.com/watch?v=jGRRBJlNtwI
	public boolean isHamiltonianGraph(Graph g)
	{
		ArrayList<String> path=new ArrayList<>();
		String end="";
		path.add("1");
		return dfsmodified( "1",g,path,end);// && g.vtces.get(end).neighbr.containsKey("1"); //uncomment to check if hamiltonian cycle/circuit present 
		
		
	}
	
	private boolean dfsmodified(String node,Graph g, ArrayList<String> path,String end) {
		
		if(path.size()==g.numVertex())
			{
			end=node;
			return true;
			}
		
		
		for(String nbr:g.vtces.get(node).neighbr.keySet())
		{
			
			if(!path.contains(nbr))
			{
				
				path.add(nbr);
				if(dfsmodified(nbr, g, path,end))
					return true;
				else
					end="";
				path.remove(nbr);
			}
		}
		return false;
	}

	//shortest path for undirected graph with same weights using BFS
	
	public void shorttestPath(Graph g)
	{
		int[] shortestPath=new int[g.numVertex()];
		Arrays.fill(shortestPath, Integer.MAX_VALUE);
		
		Queue<String> q=new LinkedList<>();
		q.add("0");
		shortestPath[Integer.parseInt("0")]=0;
		while(!q.isEmpty())
		{
			String node=q.poll();
			
			for(String nodes:g.vtces.get(node).neighbr.keySet())
			{
				
				if(shortestPath[Integer.parseInt(node)]+1 < shortestPath[Integer.parseInt(nodes)] )
				{
				
					q.add(nodes);
					shortestPath[Integer.parseInt(nodes)]=shortestPath[Integer.parseInt(node)]+1;

				}
			}
		}
		
		System.out.println(Arrays.toString(shortestPath));
	}
	
	
	//shortest path from undirected  weighted 
	public void shorttestPathDAG(Graph g)
	{
		int[] shortestPath=new int[g.numVertex()];
		Arrays.fill(shortestPath, Integer.MAX_VALUE);
		
		Queue<String> q=new LinkedList<>();
		q.add("0");
		shortestPath[Integer.parseInt("0")]=0;
		while(!q.isEmpty())
		{
			String node=q.poll();
			
			for(String nodes:g.vtces.get(node).neighbr.keySet())
			{
				
				if(shortestPath[Integer.parseInt(node)]+g.vtces.get(node).neighbr.get(nodes) < shortestPath[Integer.parseInt(nodes)] )
				{
				
					q.add(nodes);
					shortestPath[Integer.parseInt(nodes)]=shortestPath[Integer.parseInt(node)]+g.vtces.get(node).neighbr.get(nodes);

				}
			}
		}
		
		System.out.println(Arrays.toString(shortestPath));
	}
	public static void main(String[] args) {
		//Graph g = new Graph();

		/*g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "B", 10);
		g.addEdge("B", "C", 20);
		g.addEdge("C", "D", 10);
		g.addEdge("A", "D", 50);
		g.addEdge("D", "E",20);
		g.addEdge("E", "F", 8);
		g.addEdge("E", "G", 9);
		g.addEdge("F", "G", 1);*/
		
		
		
//		g.addVertex("A");
//		g.addVertex("B");
//		g.addVertex("C");
//		g.addVertex("D");
//		g.addVertex("S");
//		g.addVertex("T");
		//g.addVertex("6");
/*
		g.addEdge("S", "A", 10);
		g.addEdge("A", "B", 5);
		g.addEdge("B", "T", 7);
		g.addEdge("S", "C", 8);
		g.addEdge("C", "D",10);
		g.addEdge("D", "T", 10);
		g.addEdge("A", "C", 2);
		g.addEdge("D", "B", 8);*/

//		g.addEdge("S", "A", 4);
//		g.addEdge("A", "B", 4);
//		g.addEdge("B", "T", 2);
//		g.addEdge("S", "C", 8);
//		g.addEdge("C", "D",6);
//		g.addEdge("D", "T", 6);
//		g.addEdge("B", "C", 3);
		//g.addEdge("D", "B", 8);
		
	//	g.display();
		
		/*g.addEdge("A", "B", 8);
		g.addEdge("A", "C", 4);
		g.addEdge("A", "D", 5);
		
		g.addEdge("C", "D", -3);
		g.addEdge("D", "E", 4);
		g.addEdge("E", "B", 2);*/
		
		//g.addEdge("B", "E", 2);
		/*g.addEdge("A", "B", 1);
		g.addEdge("A", "D", 5);
		g.addEdge("D", "C", 6);
		g.addEdge("B", "C", 3);
		g.addEdge("D", "E", 9);
		g.addEdge("E", "F", 4);
		g.addEdge("G", "F", 2);
		g.addEdge("E", "G", 4);
		g.display();
		//g.removeEdge("D", "E");
		//g.DFT();
		System.out.println();
		Graph gg=g.prims();
		gg.display();*/
		//g.BFT();
		// g.display();

		//System.out.println("-----------");
		// g.removeEdge("H", "C");
		// g.removeEdge("F", "G");
		// g.removeEdge("D", "E");
		/*
		 * System.out.println(g.numVertex()); System.out.println(g.numEdges());
		 * System.out.println(g.containVertex("G")); g.removeVertex("B");
		 * System.out.println(g.containEdge("C", "B"));
		 * 
		 * 
		 * g.addVertex("K"); g.display();
		 * 
		 * System.out.println(g.hasPath("A", "K",new HashSet<>()));
		 */
		//g.kruskal();
		//System.out.println("**********************");
		//Graph ng = g.prims();
		//ng.display();
		
		//System.out.println(g.Dijkstras("A"));
		// g.removeEdge("D", "E");
		// System.out.println(g.BFS("A", "F"));

		// System.out.println(g.DFS("A", "F"));
		// g.BFT();
		// g.DFT();
		// boolean iscyclic=g.isCyclic();
		// System.out.println(iscyclic);
		// System.out.println(g.isCyclic());
		// System.out.println(g.isConnected());
		// System.out.println(g.isTree());
		// for(ArrayList<String> list:g.getConnectedComponents())
		// {
		// System.out.println(list);
		// }
		//g.DFS("A", "E");
		//System.out.println(g.bellmanFord("A"));
		//g.floyed();
		
		
		
		
		
		
		
		
		
		
		
		
		
		//************test**********-
	/*	
		g.addVertex("0");
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
		g.addEdge("6", "7", 6);
		g.display();
		//for disconnected component
		for(String key:g.vtces.keySet())
		{
			
			
			if(!visited.contains(key))
				g.DFStvsl(key);
			
				
		}*/
		//g.display();
		//System.out.println(g.bellmanFord("A"));
		//System.out.println();
		//System.out.println(g.Dijkstras("A"));
		//g.DFStvslitr("0");
		
		//g.DFStvsl("A");
		
//		g.maxFlow("S", "T");
//		System.out.println(maxflow);
		
		
		
		
		
		
		
		
		
		
		
		
		//*******************************************08-10-2022
		
		Graph g=new Graph();
		
//		g.addVertex("A");
//		g.addVertex("B");
//		g.addVertex("C");
//		g.addVertex("D");
//		g.addVertex("E");
//		g.addVertex("F");
//		g.addVertex("G");
//		g.addVertex("H");
//		g.addVertex("I");
//		g.addVertex("J");

//		g.addEdge("A", "B", 4);
//		g.addEdge("B", "C", 4);
//		g.addEdge("A", "D", 2);
//		g.addEdge("D", "B", 8);
//		g.addEdge("D", "C",6);
//		g.addEdge("E", "F", 6);
//		g.addEdge("G", "H", 3);
//		g.addEdge("G", "I", 3);
//		g.addEdge("H", "I", 3);


		//g.display();
		
		//System.out.println(g.getConnectedComponents());
		
		//g.addVertex("0");

//		g.addVertex("1");
//		g.addVertex("2");
//		g.addVertex("3");
//		g.addVertex("4");
//		g.addVertex("5");
////		g.addVertex("6");
////		g.addVertex("7");
//
//		g.addEdge("1", "2", 4);
//		g.addEdge("2", "3", 4);
//
//		g.addEdge("2", "4", 4);
//		g.addEdge("2", "5", 4);
	//	g.addEdge("1", "5", 8);
	//	g.addEdge("3", "4", 8);
		//g.addEdge("3", "1", 8);
//		g.addEdge("5", "7", 8);
//		g.addEdge("6", "7", 8);

		//g.addEdge("2", "4", 2);

//		g.addEdge("4", "6",6);
//		g.addEdge("6", "7", 6);
//		g.addEdge("5", "7",6);

	
		
		
//		g.addVertex("s");
//		g.addVertex("a");
//		g.addVertex("b");
//		g.addVertex("c");
//		g.addVertex("d");
//		g.addVertex("t");
//     	//g.addVertex("7");
//
//		g.addEdge("s", "a", 7);
//		g.addEdge("a", "b", 5);
//
//		g.addEdge("s", "d", 4);
//		g.addEdge("d", "a", 3);
//		g.addEdge("d", "c", 2);
//		g.addEdge("c", "t", 5);
//		g.addEdge("a", "c", 3);
//		g.addEdge("c", "b", 3);
//		g.addEdge("b", "t", 8);



		//g.display();
		//System.out.println(g.isBartitite(g));
		
//		g.shorttestPath(g);
//		g.shorttestPathDAG(g);
		//g.getArtculationPoints(g);
		//System.out.println(g.isHamiltonianGraph(g));
		//System.out.println(g.maxFlow("s", "t"));
		
		
		
		
		
//		g.addVertex("A");
//		g.addVertex("B");
//		g.addVertex("C");
//		g.addVertex("D");
//		g.addVertex("E");
//		g.addVertex("F");
//		g.addVertex("G");
//		
//		g.addEdge("A", "B", 1);
//		g.addEdge("A", "D", 5);
//		g.addEdge("D", "C", 6);
//		g.addEdge("B", "C", 3);
//		g.addEdge("D", "E", 9);
//		g.addEdge("E", "F", 4);
//		g.addEdge("G", "F", 2);
//		g.addEdge("E", "G", 4);
		
		g.addEdge("A", "B", 1);
		g.addEdge("B", "C", 5);
		g.addEdge("C", "D", 6);
		g.addEdge("D", "A", 3);
		g.display();
		
		//System.out.println(g.getConnectedComponents());
		System.out.println(g.isCyclic());
		
	}

	// kruskal's algorithm to find minimum cost spanning tree
	/*
	 * 1)create disjoint set O(1) 2) union O(1) 3) find O(n) but when used path
	 * compression techniques then further it will take O(1)
	 */
	public class DisjointSet {

		HashMap<String, Node> map = new HashMap<>();

		public class Node {

			String data;
			Node parent;
			int rank;
		}

		public void create(String value) {
			Node nn = new Node();
			nn.data = value;
			nn.parent = nn;
			nn.rank = 0;
			map.put(value, nn);

		}

		public void union(String value1, String value2) {
			// union by rank

			Node set1 = map.get(value1);
			Node set2 = map.get(value2);

			//find representative node of set
			Node rp1 = find(set1);
			Node rp2 = find(set2);

			if (rp1.data.equals(rp2.data))
				return;
			else {
				if (rp1.rank == rp2.rank) {
					rp1.parent = rp2;
					rp2.rank = rp2.rank + 1;
				} else if (rp1.rank > rp2.rank) {
					rp2.parent = rp1;
					// no rank change  

				} else
					rp1.parent = rp2;

			}

		}

		public String find(String value) {
			/*
			 * Node adr=map.get(value); while(adr!=adr.parent) { adr=adr.parent; }
			 * 
			 * return adr.data;
			 */

			return find(map.get(value)).data;
		}

		private Node find(Node node) {
			if (node == node.parent)
				return node;

			Node n = find(node.parent);
			node.parent = n; // path compression technique O(1) time will take for next find operatiopns
			return n;
		}

	}

	private class EdgePair implements Comparable<EdgePair> {
		String v1;
		String v2;
		int cost;

		@Override
		public int compareTo(EdgePair o) {

			return this.cost - o.cost;
		}
		
		public String toString() {
			return this.v1+" -> "+this.v2+" "+this.cost;

		}
	}

	public ArrayList<EdgePair> getAllEdges() {
		ArrayList<EdgePair> edges = new ArrayList<>();

		for (String from : vtces.keySet()) {

			for (String to : vtces.get(from).neighbr.keySet()) {

				EdgePair pair = new EdgePair();

				pair.v1 = from;
				pair.v2 = to;
				pair.cost = vtces.get(from).neighbr.get(to);

				edges.add(pair);
			}

		}
		return edges;
	}
	
	//O(ElogE) -- where E is V^2 ElogV^2=2Elogv====O(ElogV)
	//greedy algorithm
	public void kruskal() {
		
		// 1. sort all the edge list according to the cost
		ArrayList<EdgePair> edges = getAllEdges();
		Collections.sort(edges);  //ElogE
		
		
		//2. create the disjoint sets
		DisjointSet set = new DisjointSet();
		//v
		for (String vt : vtces.keySet()) {
			set.create(vt);
		}
			//E
		//iterate through all the sorted edges and do union
		for (EdgePair edge : edges) {
			String rpe1 = set.find(edge.v1); //logv
			String rpe2 = set.find(edge.v2);

			if (rpe1.equals(rpe2)) {
				continue;
			} else {
				// anser
				System.out.println(edge.v1 + " - " + edge.v2 + "->" + edge.cost);
				set.union(edge.v1, edge.v2);
			}
		}

	}

	// prims algorithm

	private class PrimsPair implements Comparable<PrimsPair> {
		String vname;
		String acqvname;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			return this.cost - o.cost;
		}

	}
	//O(Elogv)
	public Graph prims() {

		Graph mst = new Graph();

		HashMap<String, PrimsPair> map = new HashMap<>();

		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();

		for (String key : vtces.keySet()) {

			PrimsPair pair = new PrimsPair();
			pair.vname = key;
			pair.acqvname = null;
			pair.cost = Integer.MAX_VALUE;

			heap.add(pair);
			map.put(key, pair);

		}

		while (!heap.isEmpty()) {
			PrimsPair rmp = heap.delete();   //vlogv

			map.remove(rmp.vname);

			if (rmp.acqvname == null)
				mst.addVertex(rmp.vname);
			else {
				mst.addVertex(rmp.vname);
				mst.addEdge(rmp.vname, rmp.acqvname, rmp.cost);
			}

			// do work for neighbours
				//2Elogv  O(Elogv)
			for (String neighbour : vtces.get(rmp.vname).neighbr.keySet()) {
				if (map.containsKey(neighbour)) {

					int oldcost = map.get(neighbour).cost;

					int ncost = vtces.get(rmp.vname).neighbr.get(neighbour);

					// update pair when new cost is less than previous one
					if (ncost < oldcost) {
						PrimsPair getpair = map.get(neighbour);
						getpair.acqvname = rmp.vname;

						getpair.cost = ncost;

						// if we are changing the heap elements then also need to reheapify because it
						// will stay same if we not do it
						// do upheapify
						heap.updatePriority(getpair);  //logv

					}

				}
			}

		}

		return mst;

	}
	
	
	
	
	//Dijkstras algorithm
	
	
	
	private class DijkstraPair implements Comparable<DijkstraPair> {
		String vname;
		String psf;
		int cost;

		@Override
		public int compareTo(DijkstraPair o) {
			//heapGeneric is already mean heap
			return this.cost - o.cost;
		}

	}
//O(V+E)
	public HashMap<String,Integer> Dijkstras(String src)
	{

		HashMap<String,Integer> ans=new HashMap<>();
		HashMap<String, DijkstraPair> map = new HashMap<>();
		//min heap
		HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();

		for (String key : vtces.keySet()) {

			DijkstraPair pair = new DijkstraPair();
			pair.vname = key;
			pair.psf = "";
			pair.cost = Integer.MAX_VALUE;
				if(key.equals(src))
				{
					pair.cost=0;
					pair.psf=key;
				}
			heap.add(pair);
			map.put(key, pair);

		}

		while (!heap.isEmpty()) {
			DijkstraPair rmp = heap.delete();

			map.remove(rmp.vname);

		ans.put(rmp.vname, rmp.cost);


			for (String neighbour : vtces.get(rmp.vname).neighbr.keySet()) {
				if (map.containsKey(neighbour)) {

					int oldcost = map.get(neighbour).cost;

					int ncost = rmp.cost+vtces.get(rmp.vname).neighbr.get(neighbour);

					// update pair when new cost is less than previous one
					if (ncost < oldcost) {
						DijkstraPair getpair = map.get(neighbour);
						getpair.psf = rmp.psf+neighbour;

						getpair.cost = ncost;

						// if we are changing the heap elements then also need to reheapify because it
						// will stay same if we not do it
						// do upheapify
						heap.updatePriority(getpair);

					}

				}
			}

		}

		return ans;

	}
	
	
	
	
	//bELLMAN FORD
		//O(EV)
	public HashMap<String,Integer> bellmanFord(String src)
	{
		ArrayList<EdgePair> edges=getAllEdges();
		System.out.println(edges);
		HashMap<String,Integer> map=new HashMap<>();
		
		//filled the hashmap with infinity
		for(String vname:vtces.keySet())
		{
			map.put(vname, 10000000);
		
		if(src.equals(vname))
		{
			map.put(vname, 0);
		}
		
		}
		
		
		System.out.println("***************");
		int V=vtces.size();
		//O(V*E)
		//relax V-1 times for every edge
		for(int i=1;i<=V-1;i++) //do V instead of V-1 to check negative edge cycle
		{
			for(EdgePair pair:edges)
			{
				int oldcost=map.get(pair.v2);
				int newcost=map.get(pair.v1)+pair.cost;
				//System.out.println(pair.v1+" "+pair.v2);
				if(oldcost>newcost)
				{
					if(i<=V-1)
					map.put(pair.v2, newcost);
					else
						System.out.println("Negative cycle edge present");
				}
				
			}
			System.out.println(map);
		}
		
		
		
		return map;
		
		
	}
	
	
	
	
	//Floyed warshall
	
	
	
	public void floyed()
	{
		
		int[] mat[]=new int[vtces.size()][vtces.size()];
		int ii=0,jj=0;
		for(String i:vtces.keySet())
		{
			
			jj=0;
			for(String j:vtces.get(i).neighbr.keySet())
			{
				
				
				mat[ii][jj++]=1;
			}
			
			
			
			ii++;
		}
		
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat.length;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println("done");
	}
	
	
	
	
	
	
	//*********************test**************-
	
	
	/*
	 * DFS traversal
	 * implementation: recursive and using stack
	 * used to find connected components,articulation point/bridges 
	 * time: O(V+E)
	 * space: O(V)
	 *
	 */
	static HashSet<String> visited=new HashSet<>();
	public void DFStvsl(String src)
	{
		
		//Vertex pair=this.vtces.get(src);
		System.out.print(src+" ->");
		visited.add(src);
		
		for(String key:vtces.get(src).neighbr.keySet())
		{
			if(!visited.contains(key))
			DFStvsl(key);
		}
		
		
	}
	
	//iterative
	public void DFStvslitr(String src)
	{
	 HashSet<String> visited=new HashSet<>();
		Stack<String> st=new Stack<>();
		
		st.push(src);
		visited.add(src);
		
		
		while(!st.isEmpty())
		{
			//remove ,mark ,add neighbour
			
			String rm=st.pop();
			System.out.print(rm+" ->");
			

			
			
			for(String nbr:vtces.get(rm).neighbr.keySet())
			{
				if(visited.contains(nbr)==false)
				{
					st.push(nbr);
					visited.add(nbr);
				}
			}
			
			
	
			
		}
		
		
	}
	
	
	//maximum flow problem using ford-fulkerson and edmond karp algorithm
	
	
	static int maxflow=0;

	public int maxFlow(String src,String target)
	{
		
		//build initial residual graph
		Graph rd=new Graph();
		//add vertex
		for(String vt:this.vtces.keySet())
			rd.addVertex(vt);
		
			for(String s:this.vtces.keySet())
			{
				String ss=s;
				for(String n:this.vtces.get(s).neighbr.keySet())
					rd.addEdge(ss, n, this.vtces.get(s).neighbr.get(n));
				
				
				
			}
		
			System.out.println("---------");
		rd.display();
		
		
		
		
		while(BFSmxflow(rd,src,target))
		{
			
			System.out.println("go ahead");
			
			
		}
		
		
		return maxflow;
		
	}
	
	class maxflow
	{
		
		String vt;
		String parent;
	}

	private boolean BFSmxflow(Graph rd, String src, String target) {
		
		
		HashSet<String> visited=new HashSet<>();
		
		Queue<maxflow> q=new LinkedList<>();
		//Stack<maxflow> st=new Stack<>();
		HashMap<String, String> map=new HashMap<>();
		int minflow=342420;
		maxflow m=new maxflow();
		m.vt=src;
		m.parent="-1";
		q.add(m);
		map.put(src, "-1");
		while(!q.isEmpty())
		{
			
			maxflow rm=q.poll();
			System.out.print(rm.vt+"==>");

			if(rm.vt==target)
			{
				
				String sss=map.get(target);
				
				while(!sss.equals("-1"))
				{
					//System.out.print("  "+sss+" <--"+target);
					int oldcost=rd.vtces.get(sss).neighbr.get(target);
					
					if(minflow>oldcost)
						minflow=oldcost;
					//rd.vtces.get(sss).neighbr.put(target,oldcost-minflow);

					//rd.addEdge(target, sss, rd.vtces.get(target).neighbr.get(sss)==null?minflow:rd.vtces.get(target).neighbr.get(sss)+minflow);
					target=sss;

					sss=map.get(sss);
				}
				target=rm.vt;
				sss=map.get(target);
				while(!sss.equals("-1"))
				{
					System.out.print("  "+sss+" <--"+target);
					int oldcost=rd.vtces.get(sss).neighbr.get(target);
					rd.vtces.get(sss).neighbr.put(target,oldcost-minflow);

					rd.addEdge(target, sss, rd.vtces.get(target).neighbr.get(sss)==null?minflow:rd.vtces.get(target).neighbr.get(sss)+minflow);
					target=sss;

					sss=map.get(sss);
				}
				
			
				
			
			System.out.println();
System.out.println("minflow "+minflow);
				maxflow+=minflow;
				
				
				
				
				return true;
			}
			visited.add(rm.vt);
			//System.out.println(rd+"  "+rm.vt);
			for(String l:rd.vtces.get(rm.vt).neighbr.keySet())
			{
				System.out.println("---");
				int flow=rd.vtces.get(rm.vt).neighbr.get(l);
				if(flow>0 && !visited.contains(l))
				{
					
					
					maxflow mm=new maxflow();
					mm.vt=l;
					mm.parent=rm.vt;
					q.add(mm);
					map.put(l, rm.vt);
				}
			}
			
			
			
			
		}
		
		
		
		return false;
	}
	
	//for undirected graph
	public void getArtculationPoints(Graph g)
	{
		HashSet<String> an=new HashSet<>();
		
		HashMap<String,Integer> distance=new HashMap<>();
		HashMap<String,Integer> lowlink=new HashMap<>();
		int time=0;
		for(String vertex:g.vtces.keySet())
		{
			
			if(!distance.containsKey(vertex))
			{
				System.out.println("-------------");
				dfs(vertex,distance,lowlink,time,g,"-1",an);
			}
		}
		System.out.println(an);

	}

	private void dfs(String currnode, HashMap<String, Integer> distance, HashMap<String, Integer> lowlink,int time,Graph g,String parent,HashSet<String> an) {
		
		System.out.println("current node"+currnode);
		distance.put(currnode, time);
		lowlink.put(currnode, time);
		time++;
		
		for(String nbr:g.vtces.get(currnode).neighbr.keySet())
		{
			if(!nbr.equals(parent))
			{
			if(!distance.containsKey(nbr))
			{
			dfs(nbr, distance, lowlink, time, g,currnode,an);
			
				lowlink.put(currnode, Math.min(lowlink.get(currnode), lowlink.get(nbr)));
				if(!parent.equals("-1")  &&  lowlink.get(nbr)>=distance.get(currnode))
				{
					an.add(currnode);
				}
			}
			else
			{
				lowlink.put(currnode, Math.min(lowlink.get(currnode), distance.get(nbr)));
	
			}
			}
				
			
		
		}
		
		
		
	}
	
	
	
	
	

}
