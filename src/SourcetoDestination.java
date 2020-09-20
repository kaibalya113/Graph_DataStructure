import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GraphSD{
	int node;
	ArrayList<ArrayList<Integer>> list;
	boolean isVisited[];
	
	public GraphSD(int nodes) {
		this.node = nodes;
		list = new ArrayList<>();
		isVisited = new boolean[nodes];
		
		for(int i =0; i<nodes; i++) {
			list.add(i, new ArrayList<>());
		}
	}
	public void addEdge(int source, int destination) {
		list.get(source).add(destination);
		list.get(destination).add(source);
	}
	public boolean isConnected(int startPoint, int endPoint) {
		Stack<Integer> stack = new Stack<>();
		isVisited[startPoint] = true;
		stack.push(startPoint);
		
		while(!stack.isEmpty()) {
			int deletedNode = stack.pop();
			List<Integer> neighbourNodes = list.get(deletedNode);
			for (Integer neighbour : neighbourNodes) {
				if(!isVisited[neighbour]) {
					isVisited[neighbour] = true;
					stack.push(neighbour);
				}
			}
		}
		if(!isVisited[endPoint] ) {
			return false;
		}
		return true;
	}
}

public class SourcetoDestination {
	public static void main(String[] args) {
		int nodes= 7;
		GraphSD graph = new GraphSD(nodes);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		/*graph.addEdge(2, 4);
		graph.addEdge(3, 5);*/
		graph.addEdge(4, 5);
		graph.addEdge(4, 5);
		System.out.println(graph.isConnected(0, 1));
	}
}
