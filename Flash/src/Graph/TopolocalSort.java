package Graph;

public class TopolocalSort {
public static void main(String[] args) {
	Graph g=new Graph();
	g.addVertex("A");
	g.addVertex("B");
	g.addVertex("C");
	g.addVertex("D");
	g.addVertex("E");
	g.addVertex("F");
	g.addVertex("G");

	g.addEdge("A", "D", 6);
	g.addEdge("A", "B", 3);
	g.addEdge("B", "C", 1);
	g.addEdge("C", "D", 8);
	g.addEdge("E", "D", 5);
	g.addEdge("E", "F", 7);
	g.addEdge("F", "G", 0);
	g.addEdge("E", "G", 0);
	g.display();
	System.out.println();
	g.DFS("E", "G");
}
}
