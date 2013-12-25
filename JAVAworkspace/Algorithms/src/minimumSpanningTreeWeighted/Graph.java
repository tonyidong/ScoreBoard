package minimumSpanningTreeWeighted;

public class Graph {
	
	private int MAX_SIZE = 20;
	private int INFINITY = 99999;
	private Vertex[] vertexList;
	private int[][] adjMatrix;
	private int nVerts;//The current number of vertices
	private int currentVert;
	private PriorityQ PQ;
	private int nTree;//Number of vertices in tree
	
	public Graph(){
		super();
		vertexList = new Vertex[MAX_SIZE];
		adjMatrix = new int[MAX_SIZE][MAX_SIZE];
		nVerts = 0;
		for(int i = 0; i < MAX_SIZE; i++){
			for(int j = 0; j < MAX_SIZE; j++){
				adjMatrix[i][j] = INFINITY;
			}
		}
		PQ = new PriorityQ();
	}
	
	public void addVertex(char label){
		vertexList[nVerts++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end, int weight){
		adjMatrix[start][end] = weight;
		adjMatrix[end][start] = weight;
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	
	public void putInPQ(int newVert, int newDist){
		int queueIndex = PQ.find(newVert);
		//Purpose, to find if there is another same one
		if(queueIndex != -1){
			Edge temp = PQ.peekN(queueIndex);
			int oldDist = temp.dist;
			if(newDist < oldDist){
				PQ.removeN(queueIndex);
				PQ.insert(new Edge(currentVert, newVert, newDist));
			}
		}else{
			PQ.insert(new Edge(currentVert, newVert, newDist));
		}
	}
	
	public void mst(){
		currentVert = 0;//starts at 0
		while(nTree < nVerts - 1){//While not all verts in the tree, put the current in the tree
			vertexList[currentVert].isInTree = true;
			nTree++;
			
			for(int i = 0; i < nVerts; i++){
				if(i == currentVert){
					continue;
				}
				if(vertexList[i].isInTree){
					continue;
				}
				int distance = adjMatrix[currentVert][i];
				if(distance == INFINITY){
					continue;
				}
				putInPQ(i, distance);
			}
			
			Edge min = PQ.removeMin();
			int sourceVert = min.start;
			currentVert = min.end;
			
			//Then display the edge
			System.out.print(vertexList[sourceVert].label);
			System.out.print(vertexList[currentVert].label);
			System.out.print(" ");
			
		}
		
		for (int i = 0; i < nVerts; i++){
			vertexList[i].isInTree = false;
		}
	}
}
