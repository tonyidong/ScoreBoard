package heap;

public class Heap {
	
	private Node[] heapAry;
	private int maxSize;
	private int currentSize;
	
	public Heap(int maxSize) {
		super();
		this.maxSize = maxSize;
		heapAry = new Node[maxSize];
		currentSize = 0;
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public boolean insert(int key){
		if(currentSize == maxSize) return false;
		Node x = new Node(key);
		heapAry[currentSize] = x;
		trickleUp(currentSize++);
		return true;
	}
	
	public void trickleUp(int index){
		int parent = (index-1)/2;
		Node bottom = heapAry[index];
		
		while(index > 0 && heapAry[parent].getKey() < bottom.getKey()){
			heapAry[index] = heapAry[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapAry[index] = bottom;
	}
	
	public Node remove(){
		Node root = heapAry[0];
		heapAry[0] = heapAry[--currentSize];
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index){
		int largerChild;
		Node top = heapAry[index];//Save the node
		while(index < currentSize/2){//while node has at least one child, genius
			int leftChild = 2*index + 1;
			int rightChild = leftChild +1;
			
			if(rightChild < currentSize//if rightChild exist
					&& heapAry[leftChild].getKey() < heapAry[rightChild].getKey()){
				largerChild = rightChild;
			}else{
				largerChild = leftChild;
			}
			
			if(top.getKey() >= heapAry[largerChild].getKey()){
				break;
			}
			heapAry[index] = heapAry[largerChild];
			index = largerChild;
		}
		heapAry[index] = top;
	}
	
	public boolean change(int index, int value){
		if(index < 0 || index >= currentSize){
			return false;
		}
		int oldValue = heapAry[index].getKey();
		heapAry[index].setKey(value);
		
		if(oldValue < value){
			trickleUp(index);
			return true;
		}else{
			trickleDown(index);
			return true;
		}
	}
	
	public void displayHeap(){
		System.out.println("heapArray: ");
		for(int i = 0; i < maxSize; i++){
			if(heapAry[i] != null){
				System.out.printf("%s ", heapAry[i].getKey());
			}else{
				System.out.printf("%s ", "--");
			}
		}
		System.out.println();
		
		//Heap Format
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0; 
		int j = 0;
		String dots = "...............................";
		System.out.println(dots+dots);
		
		while (currentSize > 0){
			if (column == 0){
				for(int k = 0; k < nBlanks; k++){
					System.out.print(' ');
				}
			}
			System.out.print(heapAry[j].getKey());
			if(++j == currentSize){
				break;
			}
			if(++column == itemsPerRow){
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}else{
				for(int i = 0; i < nBlanks*2-2; i++){
					System.out.print(' ');
				}
			}
		}
		System.out.println("\n" + dots+dots);
	}

}
