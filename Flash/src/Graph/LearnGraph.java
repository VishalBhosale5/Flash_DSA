package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Heap.HeapGeneric;


public class LearnGraph {

	public static void main(String[] args) {
		LearnGraph g = new LearnGraph();

		/*graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("K");

		graph.addEdge("A", "D", 2);
		graph.addEdge("D", "C", 1);
		graph.addEdge("B", "C", 3);
		graph.addEdge("A", "B", 5);
		graph.addEdge("D", "E", 4);
		graph.addEdge("E", "F", 6);
		graph.addEdge("F", "G", 3);
		
		graph.addEdge("E", "G", 9);*/
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		
		g.addEdge("A", "B", 1);
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
		//System.out.println();
		LearnGraph gg=g.prims();
		gg.display();
		//g.BFT();
		//graph.display();

		// graph.BFS("A");
		//graph.DFS("A");
		//System.out.println();
		//HashSet<String> s = new HashSet<>();
		//s.add("A");
		//graph.DFSR(s, "A");
		// graph.DFT("A");
		// graph.BFT("A");

		// graph.removeEdge("D", "A");
		// graph.removeVertex("D");
		// graph.display();
		
//graph.kruskal();
	}

	HashMap<String, Vertex> vtces = new HashMap<>();

	// This is a edge which stores the neighbour data with cost.
	private class Vertex {

		HashMap<String, Integer> neighb = new HashMap<>();

	}

	public void addVertex(String vname) {
		Vertex pair = new Vertex();

		vtces.put(vname, pair);

	}

	public void addEdge(String src, String dest, int cost) {

		if (!this.vtces.containsKey(src) && !vtces.containsKey(dest))
			return;
		// also check if edge is already present or not
		if (vtces.get(src).neighb.containsKey(dest))
			return;

		// in case of undirected graph if directed then comment last line
		vtces.get(src).neighb.put(dest, cost);
		 vtces.get(dest).neighb.put(src, cost); //for undirected graph comment off

	}

	public void removeVertex(String vname) {

		for (String key : vtces.get(vname).neighb.keySet()) {

			vtces.get(key).neighb.remove(vname);
		}

		vtces.remove(vname);

	}

	public void removeEdge(String src, String dest) {
		// check if vertex and edge is already present or not

		if (vtces.get(src) != null || vtces.get(dest) != null || !vtces.get(src).neighb.containsKey(dest))
			return;

		vtces.get(src).neighb.remove(dest);
		 vtces.get(dest).neighb.remove(src); //for undirected graph comment off

	}

	public void display() {
		System.out.println("-----------------Display------------------------");
		for (String key : vtces.keySet()) {
			System.out.println(key + " ->" + vtces.get(key).neighb);
		}
		System.out.println("-----------------------------------------");

	}

	// BFS traversal

	public void BFS(String src) {

		HashSet<String> prc = new HashSet<>();

		Queue<String> q = new LinkedList<>();

		Vertex vt = new Vertex();

		q.add(src);
		prc.add(src);

		while (!q.isEmpty()) {
			String vttc = q.remove();

			System.out.print(vttc + " ");

			for (String key : vtces.get(vttc).neighb.keySet()) {

				if (!prc.contains(key)) {
					prc.add(key);
					q.add(key);
				}
			}

		}

	}

	// BFT

	class Pair {
		String vname;
		String psf;
	}

	public void BFT(String src) {
		Pair p = new Pair();
		p.vname = src;
		p.psf = src;
		HashSet<String> prc = new HashSet<>();

		Queue<Pair> q = new LinkedList<>();

		q.add(p);
		prc.add(src);

		while (!q.isEmpty()) {
			Pair vttc = q.remove();

			System.out.println(vttc.vname + " via " + vttc.psf);

			for (String key : vtces.get(vttc.vname).neighb.keySet()) {

				if (!prc.contains(key)) {
					Pair pp = new Pair();
					pp.vname = key;
					pp.psf = vttc.psf + key;
					prc.add(key);
					q.add(pp);
				}
			}

		}

	}

	// DFS
	public void DFS(String src) {

		HashSet<String> prc = new HashSet<>();

		Stack<String> st = new Stack<>();

		Vertex vt = new Vertex();

		st.add(src);
		prc.add(src);

		while (!st.isEmpty()) {
			String vttc = st.pop();

			System.out.print(vttc + " ");

			for (String key : vtces.get(vttc).neighb.keySet()) {

				if (!prc.contains(key)) {
					prc.add(key);
					st.push(key);
				}
			}

		}

	}

	public void DFSR(HashSet<String> prc, String vname) {

		System.out.print(vname + " ");

		for (String key : vtces.get(vname).neighb.keySet()) {

			if (!prc.contains(key)) {
				prc.add(key);

				DFSR(prc, key);

			}

		}

	}

	// DFT
	public void DFT(String src) {

		HashSet<String> prc = new HashSet<>();

		Stack<Pair> st = new Stack<>();

		Pair p = new Pair();
		p.vname = src;
		p.psf = src;

		st.add(p);
		prc.add(src);

		while (!st.isEmpty()) {
			Pair vttc = st.pop();

			System.out.println(vttc.vname + " via " + vttc.psf);

			for (String key : vtces.get(vttc.vname).neighb.keySet()) {

				if (!prc.contains(key)) {
					Pair pai = new Pair();
					pai.vname = key;
					pai.psf = vttc.psf + key;
					prc.add(key);
					st.push(pai);
				}
			}

		}

	}

	// Minimum spanning tree
	// kruskal algorightm

	class DisJointSet {
		HashMap<String, Node> set = new HashMap<>();

		public class Node {
			String vname;
			Node parent;
			int rank;

		}

		public void create(String value) {
			Node nn = new Node();
			nn.vname = value;
			nn.parent = nn;
			nn.rank = 0;
			set.put(value, nn);
		}

		public String find(String vname) {
			return findN(set.get(vname)).vname;
		}

		private Node findN(Node node) {

			if (node == node.parent)
				return node;

			return findN(node.parent);
		}

		public void union(String v1, String v2) {
			Node set1 = set.get(v1);
			Node set2 = set.get(v2);

			Node rp1 = findN(set1);
			Node rp2 = findN(set2);

			if (rp1.vname.equals(rp2.vname))
				return; // self loop
			else {
				if (rp1.rank == rp2.rank) {
					rp1.parent = rp2;
					rp2.rank = rp2.rank + 1;
				} else if (rp1.rank > rp2.rank)
					rp2.parent = rp1;
				else
					rp1.parent = rp2;
			}
			

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

	}

	public ArrayList<EdgePair> getAllEdges() {

		ArrayList<EdgePair> edges = new ArrayList<>();

		for (String from : vtces.keySet()) {

			for (String to : vtces.get(from).neighb.keySet()) {
				EdgePair pair = new EdgePair();
				pair.v1 = from;
				pair.v2 = to;
				pair.cost = vtces.get(from).neighb.get(to);

				edges.add(pair);

			}

		}

		return edges;

	}
	
	
	
	public void kruskal()
	{
		ArrayList<EdgePair> edges=getAllEdges();
		Collections.sort(edges);
		DisJointSet set=new DisJointSet();
		
		for(String vrtx:vtces.keySet())
		set.create(vrtx);
		
		for(EdgePair edge:edges)
		{
			
			String rpe1=set.find(edge.v1);
			String rpe2=set.find(edge.v2);
			
			if(rpe1.equals(rpe2))
				continue;
			else
			{
				
				System.out.println(edge.v1+" - "+edge.v2+" "+edge.cost);
				set.union(edge.v1, edge.v2);
				
				
			}
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	//prims algorithm
	
	private class PrimsPair implements Comparable<PrimsPair> {
		String vname;
		String acqvname;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			return this.cost - o.cost;
		}

	}
	
	public LearnGraph prims() {

		LearnGraph mst = new LearnGraph();

		HashSet<String> set = new HashSet<>();

		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();
		
		

		PrimsPair pair = new PrimsPair();
		pair.vname = "A";
		pair.acqvname = null;
		pair.cost = Integer.MAX_VALUE;
		heap.add(pair);
		//set.add(pair.vname);
		/*for (String key : vtces.keySet()) {

			PrimsPair pair = new PrimsPair();
			pair.vname = key;
			pair.acqvname = null;
			pair.cost = Integer.MAX_VALUE;

			heap.add(pair);
			set.add(key);

		}*/

		while (!heap.isEmpty()) {
			PrimsPair rmp = heap.delete();   //vlogv
			
			if(set.contains(rmp.vname))
				continue;
			set.add(rmp.vname);
			
				
			if (rmp.acqvname == null)
			{
			
			}
			else {
				/*mst.addVertex(rmp.vname);
				mst.addEdge(rmp.vname, rmp.acqvname, rmp.cost);*/
				System.out.println(rmp.vname+" "+rmp.acqvname+" "+rmp.cost);
			}

			// do work for neighbours
				//2Elogv  O(Elogv)
			for (String neighbour : vtces.get(rmp.vname).neighb.keySet()) {
				if (!set.contains(neighbour)) {

						PrimsPair getpair = new PrimsPair();
						getpair.acqvname = rmp.vname;
						getpair.vname=neighbour;
						getpair.cost=vtces.get(rmp.vname).neighb.get(neighbour);

				heap.add(getpair);

					}

				}
			}

		

		return mst;

	}
	
	
	
	
	
	
	

}
