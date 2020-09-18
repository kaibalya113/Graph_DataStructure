

// Adjancency Matrix

class GraphM{
	int vertexes;
	int matrix[][];
	public GraphM(int vertexes) {
		this.vertexes = vertexes;
		matrix = new int[vertexes][vertexes];
	}
	// add path
	void addEdge(int source, int destination) {
		matrix[source][destination] = 1;
		matrix[destination][source] = 1;
	}
	// display
	void dispalyGraph() {
		for(int i =0; i< vertexes; i++) {
			for(int j=0; j<vertexes; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
//		Vertex 0 is connected to:1 4 
//		Vertex 1 is connected to:0 2 3 4 
//		Vertex 2 is connected to:1 3 
//		Vertex 3 is connected to:1 2 4 
//		Vertex 4 is connected to:0 1 3 
		
		
		for (int i = 0; i < vertexes; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (int j = 0; j <vertexes ; j++) {
                if(matrix[i][j]==1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
	}
}
public class GraphMatrix {
	public static void main(String[] args) {
		GraphM graph = new GraphM(5);
		/*graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);*/
		
		graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.dispalyGraph();
	}
}
