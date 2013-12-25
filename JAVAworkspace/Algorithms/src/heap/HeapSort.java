/**
 * 
 */
package heap;

/**
 * @author Dong
 *
 */
public class HeapSort {
	
	private Node[] heapAry;
	private int maxSize;
	private int currentSize;
	
	public HeapSort(int maxSize){
		this.maxSize = maxSize;
		heapAry = new Node[maxSize];
		currentSize = 0;
	}
	
	public Node remove(){
		Node root = heapAry[0];
		heapAry[0] = heapAry[--currentSize];
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index){
		int largerChild;
		Node top = heapAry[index]; //Hey, isn't this a pointer?
		/**
		 * @Question: isn't this a pointer?
		 * @AnswerByMyself: yes this is a pointer, but after we like exchange stuff in the array, 
		 * 					this freaking thing is still somewhere in the heap, then it is still 
		 * 					available and will not be GCed by JAVA
		 */
		while(index < currentSize/2){//Not on the bottom row
			int leftChild = 2*index+1;
			int rightChild = leftChild+1;
			//Now we find the larger child, but first, find out if right child exists.
			if(rightChild < currentSize && heapAry[leftChild].getKey() < heapAry[rightChild].getKey()){
				largerChild = rightChild;
			}else{
				largerChild = leftChild;
			}
			
			//Then we have the larger Child, we wanna move it, we need to find if the top one is larger than the
			//larger child, if it is
			if(top.getKey() >= heapAry[largerChild].getKey()){
				break;//Job is done? Oh yes, cuz all the sub-heap is valid and the child is 
				//smaller than the parent, it's also valid;
				/**
				 * @Question: But is this still gonna be useful? I mean when can we switch sth
				 * 			from the bottom to top and be the largest?
				 */
			}
			//Then the if is not passed, we need to shift child up until 
			//the switched one reach it's correct position
			heapAry[index] = heapAry[largerChild];
			index = largerChild;//This actually updates every loop, and set all things over again
		}
		heapAry[index] = top;//root to index
	}
	
	public void displayHeap(){
		int nBlanks = 32;
		int itemsPerRow = 1;//First Row has only one item(root)
		int column = 0;
		int j = 0;//THis is the current item
		String dots = "................................";
		System.out.println(dots+dots);
		while(currentSize > 0){
			if(column == 0){//is it the first item in the row?
				for(int i = 0; i < nBlanks; i++){
					System.out.print(" ");//ALl the blanks we need, first row is 32 blanks AKA 65 of table length
				}
				System.out.print(heapAry[j].getKey());
			}
			
			if(++j == currentSize){
				break; //THis means that we are done with it, current exceeded the currentSize
			}
			
			if(++column == itemsPerRow){//Then it is the end of that row
				nBlanks /= 2;//genius!
				itemsPerRow *= 2;//Genius!
				column = 0;//Start over from the first item, OMG so genius
				System.out.println();
			}else{//if not reached the last item on row, go to the next item
				for(int i = 0; i < nBlanks*2-2; i++){//-2, for the two actual elements
					System.out.print(" ");
				}
			}
		}
		System.out.println("\n" + dots+dots);
	}
	
	public void displayArray(){
		for(int i = 0; i <maxSize; i++){
			System.out.printf("%s ", heapAry[i].getKey());//Get key, get key, how many time jesus
		}
		System.out.println();
	}
	
	public void insertAt(int x, Node node){
		heapAry[x] = node;
	}
	
	public void increamentSize(){
		currentSize++;
	}

}
