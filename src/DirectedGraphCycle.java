import java.util.ArrayList;
import java.util.List;

class GraphDg{
	int node;
	boolean isVisited[];
	boolean recrusive[];
	ArrayList<ArrayList<Integer>> list;
	
	GraphDg(int nodes){
		this.node = nodes;
		isVisited = new boolean[nodes];
		recrusive = new boolean[nodes];
		list = new ArrayList<>();
		for(int i = 0; i< nodes; i++) {
			list.add(i, new ArrayList<>());
		}
	}
	void addEdge(int source, int destination) {
		list.get(source).add(destination);
	}
	
	boolean isCyclic() {
		for(int i =0; i< node; i++) {
			if(checkIsCyclic(i)) {
				return true;
			}
		}
		return false;
	}
	boolean checkIsCyclic(int node) {
		if(recrusive[node]) {
			return true;
		}
		if(isVisited[node]) {
			return false;
		}
		recrusive[node] = true;
		isVisited[node] = true;
		List<Integer> neighbourList = list.get(node);
		for (Integer neighbour : neighbourList) {
			if(checkIsCyclic(neighbour)) {
				return true;
			}
		}
		recrusive[node] = false;
		return false;
		
	}
}
public class DirectedGraphCycle {
	public static void main(String[] args) {
		int nodes = 5;
		GraphDg graph = new GraphDg(nodes);
		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(2,0);
		graph.addEdge(0,3);
		graph.addEdge(3,4);
		graph.addEdge(4,0);
		System.out.println(graph.isCyclic());
	}
}
