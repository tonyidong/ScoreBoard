package DoubleHashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashApp {

	
	
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
		int aKey;
		DataItem Item;
		int size, n;
		
		System.out.println("Please enter the initial size of the HashTable: ");
		size = getInt();
		System.out.println("Please enter the initial # of elements in the HashTable: ");
		n = getInt();
		
		HashTable hstb = new HashTable(size);
		
		for(int i = 0; i < n; i++){
			int x = (int) (Math.random()*size*7);
			DataItem temp = new DataItem(x);
			hstb.insert(temp);
		}
		
		while(true){
			System.out.print("Enter first letter of "); 
			System.out.print("show, insert, delete, or find: ");
			char c = getChar();
			switch(c){
			case 's': 
				hstb.displayTable();
				break;
			case 'i':
				System.out.print("What is the key");
				aKey = getInt();
				hstb.insert(new DataItem(aKey));
				break;
			case 'd':
				System.out.print("What is the key");
				aKey = getInt();
				Item = hstb.delete(aKey);
				break;
			case 'f':
				System.out.print("What is the key");
				aKey = getInt();
				Item = hstb.find(aKey);
				if (Item == null){
					System.out.println("Can't find it");
				}else{
					System.out.println("Found " + aKey);
				}
				break;
			default:
				System.out.println("Type in sth valid bro!");
				break;
			}
		}
		

	}

}
