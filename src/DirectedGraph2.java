import java.util.Stack;

class Vertex1{
	int label;
	boolean isVisited;
	Vertex1(int label){
		this.label = label;
		isVisited = false;
	}
}

class GraphMat{
	private final int max_vertex = 20;
	private Vertex vertexList[];
	private int adjMatrix[][];
	private int nVerts;
	private Stack<Integer> s;
	
	GraphMat(){
		adjMatrix = new int[max_vertex][max_vertex];
		vertexList = new Vertex[max_vertex];
		nVerts =0; // it will track how many vertices are added into graph
		s = new Stack<Integer>();
	}
	
}

public class DirectedGraph2 {
	public static void main(String[] args) {
		GraphMat gm = new GraphMat();
	}
}
