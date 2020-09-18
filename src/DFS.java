import java.util.Stack;

class Vertex{
	public char label;
	public boolean isVisited;
	
	public Vertex(char lab) {
		this.label = lab;
		isVisited= false;
	}
}

class GraphDFS{
	private final int max_vertex = 20;
	private Vertex vertexList[];
	private int adjMatrix[][];
	private int nVerts;
	private Stack<Integer> s;
	
	GraphDFS(){
		vertexList = new Vertex[max_vertex];
		adjMatrix = new int[max_vertex][max_vertex];
		nVerts =0; // it will track how many vertices are added into graph
		s = new Stack<Integer>();
	}

	public void addVertex(char c) {
		vertexList[nVerts++] = new Vertex(c);
		
	}

	public void addEdge(int source, int destination) {
		adjMatrix[source][destination] = 1;
		adjMatrix[destination][source] = 1;
		
	}
	public void displayVertex(int vertex) {
		System.out.print(vertexList[vertex].label+" ");
		
	}
	public void dfs() {
		vertexList[0].isVisited = true;
		displayVertex(0);
		s.push(0);
		
		while(!s.isEmpty()) {
			int vertex = getUnVisitedVertex(s.peek());
			
			if(vertex == -1) {
				s.pop();
			}else {
				vertexList[vertex].isVisited = true;
				displayVertex(vertex);
				s.push(vertex);
			}
		}
	}
 
	private int getUnVisitedVertex(Integer vertex) {
		for(int j=0; j< nVerts; j++) {
			if(adjMatrix[vertex][j] == 1 && vertexList[j].isVisited == false) {
				return j;
			}
		}
		return -1;
	}
}
public class DFS {
	// Depth First Search
	public static void main(String[] args) {
		GraphDFS g = new GraphDFS();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		
		 g.addEdge(0, 1);
		 g.addEdge(1, 2);
		 g.addEdge(0, 3);
		 g.addEdge(3, 4);
		 g.addEdge(4, 5);
		 g.addEdge(1, 3);
		 
		 System.out.println("Visits: ");
		 g.dfs();
		 System.out.println();
		
		
	}

}
