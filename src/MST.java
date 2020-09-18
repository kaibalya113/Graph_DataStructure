import java.awt.DisplayMode;
import java.util.Stack;

class vertex{
	char label;
	boolean isVisited;
	vertex(char lab){
		label = lab;
		isVisited = false;
	}
}
class GraphMST{
	private Stack<Integer> s;
	private final int max_nodes = 20;
	int noOfNodes;
	private vertex list[];
	private int graph[][];
	public GraphMST() {
		s = new Stack<Integer>();
		graph = new int[max_nodes][max_nodes];
		noOfNodes = 0;
		list = new vertex[max_nodes];
	}
	
	// add vertex
	void addVertex(char node) {
		list[noOfNodes++] = new vertex(node); //add nodes into vertex list
	}
	
	// add Edge
	void addEdge(int source, int destination) {
		graph[source][destination] = 1;
		graph[destination][source] =1;
	}
	
	
	// mst
	void mst() {
		list[0].isVisited = true;
		s.push(0);
		while(!s.isEmpty()) {
			int current = s.peek();
			int node = getUnVisitedNodes(current);
			if(node == -1) {
				s.pop();
			}else {
				list[node].isVisited = true;
				display(current);
				display(node);
				System.out.print(" ");
				s.push(node);
			}
		}
	}

	private void display(int node) {
		System.out.print(list[node].label);
		
	}

	private int getUnVisitedNodes(int current) {
		for(int i =0; i<noOfNodes; i++) {
			if(graph[current][i] == 1 && list[i].isVisited == false) {
				return i;
			}
		}
		return -1;
	}
}
public class MST {
	public static void main(String[] args) {
		GraphMST g = new GraphMST();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		System.out.println("MST: ");
		g.mst();
	}
}
