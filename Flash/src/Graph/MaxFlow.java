package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MaxFlow {

	public static void main(String[] args) {

		Graph g = new Graph();

		g.addVertex("s");
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("t");
		// g.addVertex("7");

		g.addEdge("s", "a", 7);
		g.addEdge("a", "b", 5);

		g.addEdge("s", "d", 4);
		g.addEdge("d", "a", 3);
		g.addEdge("d", "c", 2);
		g.addEdge("c", "t", 5);
		g.addEdge("a", "c", 3);
		g.addEdge("c", "b", 3);
		g.addEdge("b", "t", 8);

		g.display();
		// System.out.println(g.isBartitite(g));

		// g.shorttestPath(g);
		// g.shorttestPathDAG(g);
		// g.getArtculationPoints(g);
		// System.out.println(g.isHamiltonianGraph(g));
		System.out.println("\n"+maxFlow("s", "t", g));

	}

	// maximum flow problem using ford-fulkerson and edmond karp algorithm
	//for finding augmenting path ford's algorithm does not tell how to do it
	//edmands algorithm uses bfs

	static int maxflow = 0;

	public static int maxFlow(String src, String target, Graph g) {

		// build initial residual graph
		Graph rd = new Graph();

		for (String vt : g.vtces.keySet())
			rd.addVertex(vt);

		for (String s : g.vtces.keySet()) {
			String ss = s;
			for (String n : g.vtces.get(s).neighbr.keySet())
				rd.addEdge(ss, n, g.vtces.get(s).neighbr.get(n));

		}

		System.out.println("___________Residual graph_______________");
		rd.display();

		
		//find the augmenting path 
		while (BFSmxflow(rd, src, target)) {

			System.out.println("go ahead");

		}

		return maxflow;

	}

	private static boolean BFSmxflow(Graph rd, String src, String target) {

		HashSet<String> visited = new HashSet<>();

		Queue<MaxflowPair> q = new LinkedList<>();
		
		//node to parent map
		HashMap<String, String> map = new HashMap<>();
		int minflow = 342420;
		MaxflowPair m = new MaxflowPair();
		m.vt = src;
//		m.parent = "-1";
	
		q.add(m);
		map.put(src, "-1");
		visited.add(m.vt);

		//BFS algorithm to find augmenting path from src to target
		while (!q.isEmpty()) {

			MaxflowPair rm = q.poll();
			System.out.print(rm.vt + "->");

			//if we reach at target 
			//backtrack and while doing update the flow and reverse edge flow in residual graph
			if (rm.vt == target) {

				String targetParent = map.get(target);
			
				minflow=rm.minflow;
				//reduce the minflow from the augmenting path edges and also for backedges
				target = rm.vt;
				targetParent = map.get(target);
				while (!targetParent.equals("-1")) {
					int oldcost = rd.vtces.get(targetParent).neighbr.get(target);
					rd.vtces.get(targetParent).neighbr.put(target, oldcost - minflow);

					rd.addEdge(target, targetParent, rd.vtces.get(target).neighbr.get(targetParent) == null ? minflow
							: rd.vtces.get(target).neighbr.get(targetParent) + minflow);
					target = targetParent;
					targetParent = map.get(targetParent);
				}

				//System.out.println("minflow " + minflow);
				maxflow += minflow;
				
				return true;
			}
			for (String l : rd.vtces.get(rm.vt).neighbr.keySet()) {
				int flow = rd.vtces.get(rm.vt).neighbr.get(l);
				if (flow > 0 && !visited.contains(l)) {

					MaxflowPair mm = new MaxflowPair();
					mm.vt = l;
					//mm.parent = rm.vt;
					
					mm.minflow=Math.min(rm.minflow, rd.vtces.get(rm.vt).neighbr.get(l));
					q.add(mm);
					map.put(l, rm.vt);
					visited.add(mm.vt);
				}
			}

		}

		return false;
	}
}

class MaxflowPair {

	String vt;
	//String parent;
	Integer minflow=Integer.MAX_VALUE;
}
