import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class EdgePrims{
	int targetNode;
	int distanceFromNOde;
	public EdgePrims(int targetNode ,int distanceFromNOde) {
		this.distanceFromNOde = distanceFromNOde;
		this.targetNode = targetNode;
	}
}
class GraphPrims{
	ArrayList<ArrayList<EdgePrims>> list;
	boolean isVisited[];
	int nodes;
	GraphPrims(int nodes){
		list = new ArrayList<>();
		isVisited = new boolean[nodes];
		this.nodes = nodes;
		for(int i =0 ; i< nodes; i++) {
			list.add(i, new ArrayList<>());
		}
	}
	void addEdge(int source, int destination, int distance) {
		list.get(source).add(new EdgePrims(destination, distance));
		list.get(destination).add(new EdgePrims(source, distance));
	}
	int mst() {
		int minCost = 0;
		for(int i =0; i< nodes; i++) {
			if(!isVisited[i]) {

				minCost = minCost + primsAlgorithms(i);
			}
		}
		return minCost;
	}
	int primsAlgorithms(int source) {
		PriorityQueue<EdgePrims> minHeap = new PriorityQueue<>((e1,e2) -> e1.distanceFromNOde - e2.distanceFromNOde);
		isVisited[source] = true;
		List<EdgePrims> childNode = list.get(source);
		// add to priority queue
		for (EdgePrims edge : childNode) {
			minHeap.add(edge);
		}
		
		int minimumCost = 0;
		while(!minHeap.isEmpty()) {
			EdgePrims minValue = minHeap.poll();
			if(isVisited[minValue.targetNode]) {
				continue;
			}
			isVisited[minValue.targetNode] = true;
			minimumCost = minimumCost + minValue.distanceFromNOde;
			
			List<EdgePrims> childNodes = list.get(minValue.targetNode);
			
			for (EdgePrims edgePrims : childNodes) {
				if(!isVisited[edgePrims.targetNode]) {
					minHeap.add(edgePrims);
				}
			}
		}
		return minimumCost;
	}
}
public class PrimsAlgorithm {
	public static void main(String[] args) {
		int nodes = 5;
		GraphPrims graph = new GraphPrims(nodes);
		graph.addEdge(0,1,6);
		graph.addEdge(0,3,4);
		graph.addEdge(1,2,10);
		graph.addEdge(1,3,7);
		graph.addEdge(1,4,7);
		graph.addEdge(2,3,8);
		graph.addEdge(2,4,5);
		graph.addEdge(3,4,12);
		System.out.println(graph.mst());
		
	}
}
