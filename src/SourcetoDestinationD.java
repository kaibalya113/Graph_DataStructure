import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graphd{
	int nodes;
	ArrayList<ArrayList<Integer>> list;
	boolean isVisited[];
	Graphd(int nodes){
		this.nodes = nodes;
		list = new ArrayList<>();
		isVisited = new boolean[nodes];
		
		for(int i=0; i< nodes; i++) {
			list.add(i, new ArrayList<>());
		}
	}
	void addEdge(int source, int destinaion) {
		list.get(source).add(destinaion);
	}
	boolean isConnected(int startPoint, int endPoint) {
		Stack<Integer> stack = new Stack<>();
		isVisited[startPoint] = true;
		stack.push(startPoint);
		
		while(!stack.isEmpty()) {
			int deleted = stack.pop();
			List<Integer> neighbournodes = list.get(deleted);
			for (Integer integer : neighbournodes) {
				if(!isVisited[integer]) {
					isVisited[integer] =true;
					stack.push(integer);
				}
			}
		}
		
		//if(!isVisited[endPoint])
		return isVisited[endPoint];
	}
}
public class SourcetoDestinationD {
	public static void main(String[] args) {
		// Check if Source to Destination Path exists in Directed Graph
		int nodes = 4;
		Graphd graph = new Graphd(nodes);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(3, 2);
		System.out.println(graph.isConnected(3, 1));
		
	}
}
