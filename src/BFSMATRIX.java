import java.beans.DesignMode;
import java.util.LinkedList;
import java.util.Queue;

class Vertext1{
	char label;
	boolean isVisited;
	public Vertext1(char name) {
		this.label = label;
		isVisited = false;
	}
	
}
class GraphBFS{
	private final int max_vertex = 20;
	private Vertext1 vartexList[];
	private int matrix[][];
	
	int noOfVertex ;
	Queue<Integer> q;
	
	public GraphBFS() {
		vartexList = new Vertext1[max_vertex];
		matrix = new int[20][20];
		noOfVertex = 0;
		q = new LinkedList<Integer>();
	}
	void addVertex(char name) {
		vartexList[noOfVertex++] = new Vertext1(name);
	}
	
	void addEdge(int source, int destination) {
		matrix[source][destination] =1;
		matrix[destination][source] =1;
 	}
	void bfs() {
		vartexList[0].isVisited = true;
		display(0);
		q.add(0);
		int v2;
		
		while(!q.isEmpty()) {
			int v1 = q.remove();
			while((v2 = getUnVisitedNode(v1)) != -1) {
				vartexList[v2].isVisited = true;
				display(v2);
				q.add(v2);
				
			}
		}
	}
	private int getUnVisitedNode(int v1) {
		for(int j=0;j < noOfVertex; j++) {
			if(matrix[v1][j] == 1 && vartexList[j].isVisited == false) {
				return j;
			}
		}
		return -1;
	}
	void display(int node) {
		System.out.print(node+" ");
	}
	
}
public class BFSMATRIX {
	public static void main(String[] args) {
		GraphBFS g = new GraphBFS();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		
		g.addEdge(0,1);
		g.addEdge(1, 2);

		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(1, 4);
		System.out.println("visits: ");
		g.bfs();
	}
}
