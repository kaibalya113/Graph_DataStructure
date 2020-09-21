import java.util.ArrayList;
import java.util.List;

class GraphUDC{
	int node;
	ArrayList<ArrayList<Integer>> list;
	boolean isVisited[];
	GraphUDC(int nodes){
		this.node = nodes;
		list = new ArrayList<>();
		isVisited = new boolean[nodes];
		for(int i =0; i< nodes; i++) {
			list.add(i, new ArrayList<>());
		}
	}
	
	void addEdge(int source, int destination) {
		list.get(source).add(destination);
		list.get(destination).add(source);
	}
	String cyclicOrNot() {
		for(int i =0; i< node; i++) {
			if(!isVisited[i]) {
				if(isCyclic(i, -1)) {
					return "cyclic";
				}
			}
		}
		return "not Cyclic";
	}
	boolean isCyclic(int node, int parent) {
		isVisited[node] = true;
		List<Integer> neighbours = list.get(node);
		for (Integer neighbour : neighbours) {
			if(!isVisited[neighbour]) {
				isCyclic(neighbour, node);
				
			}else if(neighbour != parent) {
				return true;
			}
		}
		return false;
	}
}
public class UndirectedGraphCycle {
	public static void main(String[] args) {
		int nodes = 3;
		GraphUDC graph = new GraphUDC(nodes);
		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(2,0);
		System.out.println(graph.cyclicOrNot());
	}
}
