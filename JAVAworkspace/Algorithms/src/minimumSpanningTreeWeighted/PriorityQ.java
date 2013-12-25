package minimumSpanningTreeWeighted;

public class PriorityQ {

	private final int MAX_SIZE = 20;
	private Edge[] Qary;
	private int size;

	public PriorityQ(){
		Qary = new Edge[MAX_SIZE];
		size = 0;
	}

	public void insert(Edge item){
		int i = 0;

		for (i = 0; i < size; i++){
			if(item.dist >= Qary[i].dist) break; 
		}


		for (int j = size - 1; j >= i; j--){
			Qary[j+1] = Qary[j];
		}

		Qary[i] = item;
		size++;
	}

	public Edge removeMin(){
		return Qary[--size];
	}

	public void removeN(int n){
		for(int i = n; i < size; i++){
			Qary[i] = Qary[i+1];
		}
		size--;
	}

	public Edge peekMin(){
		if(size <= 0) return null;
		return Qary[size - 1];
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public Edge peekN(int n){
		if(n >= size) return null;
		return Qary[n];
	}

	public int find(int x){
		if(size == 0) return -1;
		for(int i = 0; i < size; i++){
			if(Qary[i].end == x){
				return i;//Returns it's position
			}
		}
		return -1;
	}

}
