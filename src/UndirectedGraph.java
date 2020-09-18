import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graphg{
	ArrayList<ArrayList<Integer>> list;
	boolean isVisited[];
	public Graphg(int node) {
		list = new ArrayList<>();
		isVisited = new boolean[node];
		for(int i =0 ;i < node; i++) {
			list.add(i, new ArrayList<>());
		}
	}
	// add Edge
	void addEdge(int source, int destination) {
		list.get(source).add(destination);
		list.get(destination).add(source);
	}
	// now check graph is conneced or not
	boolean check() {
		Stack<Integer> s = new Stack<>();
		// we ll start from 0 
		isVisited[0] = true;
		s.push(0);
		while(!s.isEmpty()) {
			int currentNode = s.pop();
			List<Integer> neighbours = list.get(currentNode);
			for (Integer integer : neighbours) {
				if(!isVisited[integer]) {
					isVisited[integer] = true;
					s.push(integer);
				}
			}
		}
		for(int i=0; i< isVisited.length ;i++) {
			if(!isVisited[i]) {
				return false;
			}
		}
		return true;
	}
}
public class UndirectedGraph {
	public static void main(String[] args) {
		int nodes =  7;
		Graphg g = new Graphg(nodes);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,3);
		g.addEdge(2,4);
		g.addEdge(3,5);
		g.addEdge(4,5);
		//g.addEdge(4,6);
		System.out.println(g.check());
		
	}
}
