import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
class Edge{
	int targetNode;
	int distanceFromNode;
	Edge(int targetNode, int distanceFromNode){
		this.distanceFromNode = distanceFromNode;
		this.targetNode = targetNode;
	}
}
class GraphDijkstra{
	ArrayList<ArrayList<Edge>> list;
	boolean isVisited[];
	int distance[]; // it will contains distance to all the node
	GraphDijkstra(int nodes){
		list = new ArrayList<>();
		isVisited = new boolean[nodes];
		distance = new int[nodes];
		for(int i =0;i< nodes; i++) {
			list.add(i, new ArrayList<>());// for each list it will contains new arratlist
			//for the distance max value we are initializing
			distance[i] = Integer.MAX_VALUE;
		}
	}
	void addEdge(int source, int targetNode, int distanceFromNode) {
		list.get(source).add(new Edge(targetNode, distanceFromNode));
	}
	int dijkstra(int source, int destination) {
		if(source == destination) {
			return 0;
		}
		// create priority queue
		// using priority queue we can define minheap
		PriorityQueue<Edge> minheap = new PriorityQueue<>((e1,e2) -> e1.distanceFromNode - e2.distanceFromNode);
		distance[source] = 0;
		minheap.add(new Edge(0, 0));
		
		while(!minheap.isEmpty()) {
			int v = minheap.poll().targetNode;
			if(isVisited[v]) {
				continue;
			}
			List<Edge> childNode = list.get(v);
			
			for (Edge edge : childNode) {
				int dist = edge.distanceFromNode;
				int childNodea = edge.targetNode;
				
				if(!isVisited[childNodea] && (distance[v] + dist < distance[childNodea])) {
					distance[childNodea] = distance[v] + dist;
					edge.distanceFromNode = distance[v] + dist;
					minheap.add(edge);
				}
			}
		}
		
		return distance[destination];
	}
}
public class DijkstraAlgorithm {
	public static void main(String[] args) {
		int nodes = 5;
		GraphDijkstra graph = new GraphDijkstra(nodes);
		graph.addEdge(0,1,1);
		graph.addEdge(0,2,7);
		graph.addEdge(1,2,5);
		graph.addEdge(1,4,4);
		graph.addEdge(4,3,2);
		graph.addEdge(2,3,6);
		//for(int i = 0; i< 5; i++) {
			System.out.println(graph.dijkstra(0,4));
	//	}
		
	}
}
