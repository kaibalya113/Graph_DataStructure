import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class GraphD{
	int node;
	ArrayList<ArrayList<Integer>> graphList;
	boolean isVisited[];
	public GraphD(int node) {
		this.node = node;
		graphList = new ArrayList<>();
		isVisited = new boolean[node];
		for(int i=0; i< node; i++) {
			graphList.add(i, new ArrayList<>());
		}
	}
	// add Edges
	public void addEdge(int source, int destination) {
		graphList.get(source).add(destination);
	}
	    
	
	public boolean isStronglyConnected() {
		for(int i =0; i< node; i++) {
			dfs(i);
			for(int j =0; j<node;j++) {
				if(!isVisited[j]) {
					return false;
				}
			}
			Arrays.fill(isVisited, false);
		}
		return true;
	}
	
	public void dfs(int node) {
		
		Stack<Integer> s = new Stack<>();
		isVisited[node] = true;
		s.push(node);
		
		while(!s.isEmpty()) {
			int n = s.pop();
			//System.out.print(n+ " ");
			List<Integer> nodee = graphList.get(n);
			for (Integer integer : nodee) {
				if(!isVisited[integer]) {
					isVisited[integer] = true;
					s.push(integer);
				}
			}
		}
	}
	
	
	
	
}
public class DirectedGraph {
	public static void main(String[] args) {	
		 /*Check if Directed graph is stongly connected or not
		 strongly means every nodes connected to every nodes
		 0 -> 1
		 0 -> 3
		 1 -> 2
		 2 -> 0
		 3 -> 2
		 
		 so in this graph: 
			 0 can travel: 1 , 2 , 3
			 1 can travel: 2 , 3 , 0
			 2 can travel: 0 , 1 , 3
			 3 can travel: 2 , 0 , 1
			 */
			/* for this we have to iterate a loop and find out 
			 dfs of a node then check is there any unvisited nodes are their.
			 if any unvisited node found, then this graph is not a strongly connected graph
			 */
		int node = 4;
		GraphD g = new GraphD(node);
		g.addEdge(0, 1);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(0, 3);
	    g.addEdge(3, 2);
		
		System.out.println(g.isStronglyConnected());
	}
}
