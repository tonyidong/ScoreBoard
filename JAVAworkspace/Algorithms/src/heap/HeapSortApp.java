package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSortApp {
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
	
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int size, j;
		
		System.out.println("Please Enter numbers of Items: ");
		
		size = getInt();
		HeapSort theHeap = new HeapSort(size);
		
		for(j = 0; j < size; j++){
			int rand = (int)(Math.random()*100);
			Node x = new Node(rand);
			theHeap.insertAt(j, x);
			theHeap.increamentSize();
		}
		
		System.out.println("The random heap is: ");
		theHeap.displayArray();
		
		for(j = size/2 -1; j>=0; j--){
			theHeap.trickleDown(j);
		}
		
		System.out.println("So the heap is now: ");
		theHeap.displayArray();
		theHeap.displayHeap();
		
		for(j = size - 1; j >= 0; j--){
			Node biggestNode = theHeap.remove();
			theHeap.insertAt(j, biggestNode);
		}
		
		System.out.println("Sorted: ");
		theHeap.displayArray();
	}

}
