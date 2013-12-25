package dfs;

public class Graph {
	
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;
	private int[][] adjMat;
	private int nVert;
	private StackX theStack;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVert = 0;
		theStack = new StackX();
	}
	
	public void addVertex(char x){
		vertexList[nVert++] = new Vertex(x);
	}
	
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int x){
		System.out.print(vertexList[x].label + " ");
	}
	
	public void mst(){//Minimum spanning tree
		vertexList[0].wasVisted = true;//Has a place to start, we start at 0
		theStack.push(0);
		
		while(!theStack.isEmpty()){
			int currentVertex = theStack.peek();
			//Then get the next unvisited neighbor
			int v = getAdjUnvisitedVertex(currentVertex);
			if(v == -1){
				theStack.pop();
			}else{
				vertexList[v].wasVisted = true;//mark the founded neighbor as read
				theStack.push(v);//push it on the stack
				//Display the edge?
				displayVertex(currentVertex);
				displayVertex(v);
				System.out.print(" ");
			}
		}
		for(int i = 0; i < nVert; i++){
			vertexList[i].wasVisted = false;
		}
	}
	
	public void dfs(){
		//actually start from the very beginning AKA vertex 0
		vertexList[0].wasVisted = true;//Therefore it is visited
		displayVertex(0);//Display it to show how it works
		theStack.push(0);//Push the first vertex onto the stack
		
		while(!theStack.isEmpty()){ //All the stuff happens in here
			//get a unvisited vertex near the top
			int v = getAdjUnvisitedVertex(theStack.peek());
			if(v == -1){
				theStack.pop();
			}else{
				vertexList[v].wasVisted = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		//reset if visited cuz our job is done;
		for(int i = 0; i < nVert; i++){
			vertexList[i].wasVisted = false;
		}
	}
	
	public int getAdjUnvisitedVertex(int x){
		for(int i = 0; i < nVert; i++){
			if(adjMat[x][i] == 1 && vertexList[i].wasVisted == false){
				return i;
			}
		}
		return -1;
	}
	
}
