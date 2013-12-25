package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheApp {
	
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
		int value1, value2;
		Heap theHeap = new Heap(31);
		boolean success;

		theHeap.insert(70);
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);
		
		while(true){
			System.out.println("Please Enther the first letter of: show, insert, remove, change: ");
			char choice = getChar();
			switch(choice){
			case 's':
				theHeap.displayHeap();
				break;
			case 'i':
				System.out.println("What key? ");
				int key = getInt();
				success = theHeap.insert(key);
				if(!success){
					System.out.println("Can't Insert, heap full!");
				}
				break;
			case 'r':
				if(!theHeap.isEmpty()){
					theHeap.remove();
				}else{
					System.out.println("Empty Yo");
				}
				break;
			case 'c':
				System.out.println("Whata ever");
				
			default:
				System.out.println("Whatya say?");
				
			}
		}

	}

}
