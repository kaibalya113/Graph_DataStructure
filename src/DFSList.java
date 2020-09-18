import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GraphQ{
	// Initialize array
	ArrayList<ArrayList<Integer>> list;
	boolean isVisited[];
	
	GraphQ(int nodes){
		list = new ArrayList<ArrayList<Integer>>(); // Initializing list
		isVisited = new boolean[nodes];
		for(int i =0; i< nodes; i++) {
			list.add(i, new ArrayList<>());
		}
		System.out.println(list);
	}
	void addEdge(int source, int destination) {
		list.get(source).add(destination);
		list.get(destination).add(source);
	}
	void dfs(int start) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(start);
		isVisited[start] = true;
		while(!stack.isEmpty()) {
			Integer node = stack.pop();
			System.out.println(node+ " ");
			// then search for neighbour nodes
			List<Integer> neighbourNodes = list.get(node);
			//System.out.println("List of neighbours: "+neighbourNodes);
			for(int neighbour : neighbourNodes) {
				//System.out.println(neighbour);
				if(!isVisited[neighbour]) {
					isVisited[neighbour] = true;
					stack.push(neighbour);
				}
			}
		}
	}
}
public class DFSList { 
	public static void main(String[] args) {
		int noOfNodes = 7;
		GraphQ g = new GraphQ(7);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,3);
		g.addEdge(2,4);
		g.addEdge(3,5);
		g.addEdge(4,5);
		g.addEdge(4,6);
		g.dfs(0);
	}

}
