package shortestPath;

public class Graph {

	private final int MAX_VERTS = 20;
	private final int INFINITY = 9999999;
	private Vertex[] vertexList;
	private int[][] adjMatrix;
	private int nVerts;
	private int nTree;
	private DistPar[] sPath;
	private int currentVert;
	private int startToCurrent;

	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		nTree = 0;
		for(int i = 0; i < MAX_VERTS; i++){
			for(int j = 0; j < MAX_VERTS; j++){
				adjMatrix[i][j] = INFINITY;
			}
		}
		sPath = new DistPar[MAX_VERTS];
	}


	public void addVertex(char c) {
		// TODO Auto-generated method stub
		vertexList[nVerts++] = new Vertex(c);
	}

	public void addEdge(int i, int j, int k) {
		// TODO Auto-generated method stub
		adjMatrix[i][j] = k;
		//Directed
	}

	public void path() {
		// TODO Auto-generated method stub
		int startTree = 0;//Start at the first vertex
		vertexList[startTree].isInTree = true;
		nTree = 1;

		//Transfer row of distances to sPath from adjMatrix
		for(int i = 0; i < nVerts; i++){
			int tempDist = adjMatrix[startTree][i];
			sPath[i] = new DistPar(startTree, tempDist);
		}
		//OK, it is the dist from 0 to each and every vertex.


		//Until all the vertices are in the tree
		/**
		 * @Question: What is the tree? I don't see any tree here, imaginary?
		 */
		while(nTree < nVerts){
			int minIndex = getMin();
			int minDist = sPath[minIndex].distance;
			
			if(minDist == INFINITY){
				System.out.println("There is no reachable vertex Bro");
				break;
			}else{
				currentVert = minIndex;
				startToCurrent = sPath[minIndex].distance;
			}
			
			//put currentVert into the Tree
			vertexList[currentVert].isInTree = true;
			nTree++;
			adjust_sPath();
		}
		displayPath();
		nTree = 0;
		for(int i = 0; i < nVerts; i++){
			vertexList[i].isInTree = false;
		}

	}

	public int getMin(){
		int minDist = INFINITY;
		int index = 0;
		for(int i = 0; i < nVerts; i++){
			if(vertexList[i].isInTree && sPath[i].distance < minDist){
				minDist = sPath[i].distance;
				index = i;
			}
		}
		return index;
	}
	
	public void adjust_sPath(){
		int column = 1;//Cuz we skip the first vertex
		while(column < nVerts){
			if(vertexList[column].isInTree){
				column++;
				continue;
			}
			int currentToFringe = adjMatrix[currentVert][column];
			int startToFringe = startToCurrent + currentToFringe;
			int sPathDist = sPath[column].distance;
			
			if(startToFringe < sPathDist){
				sPath[column].parent = currentVert;
				sPath[column].distance = startToFringe;
			}
			column++;
		}
		
	}

	private void displayPath() {
		// TODO Auto-generated method stub
		for(int i = 0; i < nVerts; i++){
			System.out.print(vertexList[i].label + "=");
			if(sPath[i].distance >= INFINITY - 10){
				System.out.print("Inf");
			}else{
				System.out.print(sPath[i].distance);
				char parent = vertexList[sPath[i].parent].label;
				System.out.print("(" + parent + ")");
			}
			System.out.println();
		}
	}

}
