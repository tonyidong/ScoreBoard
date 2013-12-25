package MyBinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int x;
		Tree theTree = new Tree();
		
		theTree.insert(50, 1.5); 
		theTree.insert(25, 1.2); 
		theTree.insert(75, 1.7); 
		theTree.insert(12, 1.5); 
		theTree.insert(37, 1.2); 
		theTree.insert(43, 1.7); 
		theTree.insert(30, 1.5); 
		theTree.insert(33, 1.2); 
		theTree.insert(87, 1.7); 
		theTree.insert(93, 1.5); 
		theTree.insert(97, 1.5);
		
		while(true){
			System.out.println("Please enter first letter of show, insert, delete, find, insert: ");
			int c = getChar();
			switch(c){
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.println("Enter Value to be inserted: ");
				x = getInt();
				theTree.insert(x, x*0.618);
				break;
			case 'd':
				System.out.println("Enter Value to be deleted: ");
				x = getInt();
				boolean didIt = theTree.delete(x);
				if(didIt){
					System.out.println("Successfully deleted item with key " + x);
				}else{
					System.out.println("Did not find the item with key " + x);
				}
				break;
			case 'f':
				System.out.println("Enter the Value want to find: ");
				x = getInt();
				Node found = theTree.find(x);
				if(found != null){
					System.out.print("Found ");
					found.displayNode();
				}else{
					System.out.println("Can't find it!");
				}
				break;
			case 't':
				System.out.println("Enter 1, 2 or 3: ");
				x = getInt();
				theTree.traverse(x);
				break;
			default:
				System.out.println("Invalid! ");
				
				
			}
		}

	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}

}
