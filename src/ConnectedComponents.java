import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GraphList{
	int node;
	ArrayList<ArrayList<Integer>> list;
	boolean isVisited[];
	GraphList(int node){
		this.node = node;
		list = new ArrayList<>();
		isVisited = new boolean[node];
		for(int i =0; i< node; i++) {
			list.add(i, new ArrayList<>());
		}
	}
	
	// addEdge
	public void addEdge(int source, int destination) {
		list.get(source).add(destination);
		list.get(destination).add(source);
	}
	
	public int getNoOfConnectedNodes() {
		int noOfNodes = 0;
		for(int i =0; i< node; i++) {
			if(!isVisited[i]) {
				dfs(i);
				noOfNodes++;
			}
			
		}
		return noOfNodes;
	}
	
	// dfs
	public void dfs(int node) {
		Stack<Integer> stack = new Stack<>();
		isVisited[node] = true;
		stack.push(node);
		
		while(!stack.isEmpty()) {
			int deletedNode = stack.pop();
			List<Integer> neighbourNode =list.get(deletedNode);
			//System.out.println(neighbourNode);
			for (Integer neighbour : neighbourNode) {
				if(!isVisited[neighbour]) {
					isVisited[neighbour]= true;
					stack.push(neighbour);
				}
			}
		}
	}
	
}
public class ConnectedComponents {
	public static void main(String[] args) {
//		 In this Graph we will check how many nodes are conneted
//		 if there are : 0 ->1 ->2 ->3 and 4->5->6
//		 so result will be 2 graphs are connected 
		
		int node = 7;
		GraphList graph = new GraphList(node);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(4, 5);
		System.out.println(graph.getNoOfConnectedNodes());
	}
}
