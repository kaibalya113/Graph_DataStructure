import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class GraphMD{
	int node ;
	ArrayList<ArrayList<Integer>> list;
	//Queue<Integer> addingNode;
	boolean isVisited[];
	GraphMD(int nodes){
		this.node = nodes;
		list = new ArrayList<>();
		//addingNode = new ArrayList<>();
		isVisited = new boolean[nodes];
		for(int i =0; i< nodes; i ++) {
			list.add(i, new ArrayList<>());
		}
	}
	void addEdge(int source, int destination) {
		list.get(source).add(destination);
		list.get(destination).add(source);
	} 
	public int minDistance(int startNode, int targetNode) {
		if(startNode == targetNode) {
			return 0;
		}
		Queue<Integer> addingNode = new LinkedList<>();
		
		int minDistance = 0;
		
		isVisited[startNode] = true;
		addingNode.add(startNode);
		while(!addingNode.isEmpty()) {
			int size = addingNode.size();
			while(size > 0) {
				int noded = addingNode.poll();
				
				java.util.List<Integer> neighbour = list.get(noded);
				for (Integer one : neighbour) {
					if(one == targetNode) {
						return ++minDistance;
					}
					if(!isVisited[one]) {
						isVisited[one] = true;
						addingNode.add(one);
					}
				}
				size--;
			}
			minDistance++;
			
		}
		return -1;
		
	}
	
}
public class MinDistance {
	public static void main(String[] args) {
		int nodes = 6;
		GraphMD graph = new GraphMD(nodes);
		graph.addEdge(0,1); 
		graph.addEdge(0,3); 
		graph.addEdge(1,2); 
		graph.addEdge(3,4); 
		graph.addEdge(2,4);
		graph.addEdge(4,5);  
		System.out.println(graph.minDistance(0, 5));
	}
}
