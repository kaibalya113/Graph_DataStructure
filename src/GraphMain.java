import java.util.ArrayList;

// Adjancency List
class Graph{
	ArrayList<ArrayList<Integer>> graph; // [[1,2], [3,4]]
	int noOfNodes;
	
	Graph(int nodes){
		noOfNodes = nodes;
		graph = new ArrayList<ArrayList<Integer>>(); // allocate memory to the graph
		// allocate memory to each arraylist present in arraylist
		for(int i =0; i<noOfNodes; i++) {
			graph.add(new ArrayList<Integer>());
			
		}
		
	}
	void addEdge(int sourceNode , int destinationNode) { // This is undirected graph, we have to crreate path for both the nodes
		graph.get(sourceNode).add(destinationNode);
		graph.get(destinationNode).add(sourceNode);
	}
	void printGraph() {
		// it will show us all the nodes
		for(int i=0; i<noOfNodes; i++) {
			System.out.println("Node i: ");
			for(int x : graph.get(i))System.out.println("- > "+ x);
			System.out.println();
		}
	}
}
public class GraphMain {
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(3, 2);
		g.addEdge(2, 4);
		g.addEdge(1, 4);
		g.addEdge(3, 1);
		g.addEdge(2, 0);
		g.printGraph();
	}
}
