import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class GraphT{
	ArrayList<ArrayList<Integer>> list;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	HashMap<Integer, Integer> incomingnodes; 
	int node;
	Queue<Integer> source;
	
	GraphT(int nodes){
		this.node = nodes;
		list = new ArrayList<>();
		incomingnodes = new HashMap<>();
		source = new LinkedList<>();
		
		for(int i =0; i< nodes; i++) {
			list.add(i, new ArrayList<>()); // for each index create a blank list
			incomingnodes.put(i, 0); // At the start ing incomingnode fo revery index is 0
		}
	}
	void addEdge(int source, int destination) {
		list.get(source).add(destination);
		incomingnodes.put(destination, incomingnodes.get(destination) + 1);// what ever the value of
		//b is just add +1
	}
	public List<Integer> topologicalSort(){
		// first check which are the nodes whose incomingnode is 0 and add to queue;
		for (Map.Entry<Integer, Integer> arrayList : incomingnodes.entrySet()) {
			if(arrayList.getValue() == 0) {
				source.add(arrayList.getKey());
			}
		}
		List<Integer> result = new ArrayList<>();
		while(!source.isEmpty()) {
			int ndoe = source.remove();
			result.add(ndoe);
			
			List<Integer> neighbour = list.get(ndoe);
			for (Integer integer : neighbour) {
				// for each children reduce the incoming degree to -1
				incomingnodes.put(integer, incomingnodes.get(integer) - 1);
				// now check incoming node is zero or not if zero then add to queue
				if(incomingnodes.get(integer) == 0) {
					source.add(integer);
				} 
			}
			
		}
		if(result.size() != node) {
			return new ArrayList<>();
		}
		return result;
	}
}

public class TopologicalSort {
	public static void main(String[] args) {
		 /*In this topological sort we we sort the nodes whose having
		 no parent...*/
		int nodes = 6;
		GraphT graph = new GraphT(nodes);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(1,3);
		graph.addEdge(1,4);
		graph.addEdge(2,4);
		graph.addEdge(3,5);
		graph.addEdge(4,5);
		System.out.println(graph.topologicalSort());
	}
}
