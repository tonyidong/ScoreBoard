package HashProbe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HTApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataItem aDataItem;
		int aKey, size, n, keysPerCell;
		System.out.print("Please Enther the Size of Hash Table: ");
		size = getInt();
		System.out.print("Enter initial number of items: ");
		n = getInt();
		keysPerCell = 10;
		
		HashTable theHashTable = new HashTable(size);
		
		for(int i = 0; i < n; i++){
			aKey = (int)(Math.random()*keysPerCell*size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
		}
		
		while(true){//interact with user
			System.out.println("Please enter fist letter of show, insert, delete, or find: ");
			char choice = getChar();
			switch(choice){
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.println("Please Enter Key Value to Insert: ");
				aKey = getInt();
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.println("Please Enther value to delete");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.println("Please Enter key value to find: ");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if(aDataItem != null){
					System.out.println("Found " + aKey);
				}else{
					System.out.println("Could Not Find: " + aKey);
				}
				break;
			default:
				System.out.println("Please Enter A Valid Entry!");
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
