/*
	Object representation for each node in graph:
	1. vertex - represents the vertex number of node
	2. weight - weight from a given vertex, according to adjaceny list
*/
static private class graphDS implements Comparable<graphDS>{
	int vertex, weight;
	graphDS(int vertex, int weight){
		this.vertex = vertex;
		this.weight = weight;
	}
	@Override
	public int compareTo(graphDS o) {
		return this.weight - o.weight;
	}
	
}


/*
	Example :
	Input

	Number of nodes ( n ) = 4
	 1 2 1 
	 2 3 4
	 1 4 3
	 4 3 2
	 1 3 10

	In this example, we have number of nodes(n) = 4 . Each row then represents a edge. In each row first two numbers represent the node number(1 starting) which are connected by this edge and the third integer is the cost associated with this edge.

	In the above example, we can select edge 1(connecting nodes 1 and 2 with cost 1), 3(connecting nodes 1 and 4 with cost 3), 

*/
static public int solve(int A, ArrayList<ArrayList<Integer>> B) {
	if(A == 1)
		return 0;
	
	boolean[] hasVisited = new boolean[A];
	ArrayList<ArrayList<graphDS>> adjL = new ArrayList<ArrayList<graphDS>>();
	
	for(int i = 0; i < A; i++)
		adjL.add(new ArrayList<graphDS>());
	
	for(ArrayList<Integer> al : B){
		int v1 = al.get(0) - 1, v2 = al.get(1) - 1, wt = al.get(2);
		
		adjL.get(v1).add(new graphDS(v2, wt));
		adjL.get(v2).add(new graphDS(v1, wt));
	}
	
	PriorityQueue<graphDS> pq = new PriorityQueue<graphDS>();
	pq.add(new graphDS(0, 0));
	
	int res = 0;
	while(!pq.isEmpty()){
		graphDS curr = pq.poll();
		if(hasVisited[curr.vertex])
			continue;
		
		res += curr.weight;
		hasVisited[curr.vertex] = true;
		
		for(graphDS ds : adjL.get(curr.vertex))
			pq.add(ds);
	}
	
	return res;
}