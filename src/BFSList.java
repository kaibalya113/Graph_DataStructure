import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GraphBFSList{
	ArrayList<ArrayList<Integer>> graph;
	boolean isVisited[];
	public GraphBFSList(int node) {
		graph = new ArrayList<>();
		isVisited = new boolean[node];
		for(int i =0; i<node ;i++) {
			graph.add(i, new ArrayList<>());
		}
	}
	void addEdge(int source, int destination) {
		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}
	public void bfsList(){
		Queue<Integer> q = new LinkedList<Integer>();
		
		// start from 0
		isVisited[0] = true;
		q.add(0);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.println(node+" ");
			List<Integer> neighbour = graph.get(node);
			for (Integer integer : neighbour) {
				if(!isVisited[integer]) {
					isVisited[integer] = true;
					q.add(integer);
				}
			}
		}
		
	}
	
}


public class BFSList {
	public static void main(String[] args) {
		int noOfNode = 7;
		GraphBFSList g = new GraphBFSList(noOfNode);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(1, 4);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(4, 3);
		
		g.bfsList();
		
	}
}
