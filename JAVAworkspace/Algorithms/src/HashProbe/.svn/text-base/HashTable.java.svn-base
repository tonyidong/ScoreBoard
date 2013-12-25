package HashProbe;

public class HashTable {
	
	private DataItem[] hashArray; //what actually holds hash table
	private int arraySize;
	private DataItem nonItem; //For deletion
	
	public HashTable(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);//deleted items keys are -1
	}
	
	public void displayTable(){
		System.out.println("Table: ");
		for (int i = 0; i < arraySize; i++){
			{
				if(hashArray[i] != null){
					System.out.printf("%s ", hashArray[i].getKey());
				}else{
					System.out.print("** ");
				}
				System.out.println();
			}
		}
	}
	
	public int hashFunc(int key){
		return key % arraySize;
	}
	
	public void insert(DataItem item){//Assuming table not full
		int key = item.getKey();//get the key
		int hashVal = hashFunc(key);//hash the key***
		
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
			hashVal++;//go to the next cell
			hashVal %= arraySize;//Wrap Around
		}
		
		hashArray[hashVal] = item;
	}
	
	public DataItem delete(int key){
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null){
			if (hashArray[hashVal].getKey() == key){
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			hashVal++;
			hashVal %= arraySize;
		}
		return null;//can't find it
	}
	
	public DataItem find(int key){
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null){
			if (hashArray[hashVal].getKey() == key){
				return hashArray[hashVal];
			}
			hashVal++;
			hashVal %= arraySize;
		}
		return null;
	}

}
