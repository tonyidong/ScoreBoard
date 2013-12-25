package DoubleHashing;

public class HashTable {
	private DataItem[] hsary;
	private int hsarySize;
	private DataItem deleted = new DataItem(-1);
	private final double GR = (Math.sqrt(5)-1)/2;//Golden Ratio
	
	public HashTable(int x){
		this.hsary = new DataItem[x];
		this.hsarySize = x;
	}
	
	public void displayTable(){
		for (int i = 0; i < this.hsarySize; i++){
			if (hsary[i] != null && hsary[i].getKey() != deleted.getKey()){
				System.out.println("Position: " + i + " Key: " + hsary[i].getKey());
			}else{
				System.out.println("Position: " + i + " Key: " + "****");
			}
		}
	}
	
	public int hsFunc1(int key){
		return key % hsarySize;
	}
	
	public int hsFunc2(int key){
		return 5 - key%5;
	}
	
	public void insert(DataItem x){
		int hsVal = hsFunc1(x.getKey());
		int step = hsFunc2(x.getKey());
		while(hsary[hsVal] != null && hsary[hsVal].getKey() != -1){
			hsVal += step;
			hsVal %= hsarySize;
		}
		hsary[hsVal] = x;
	}
	
	public DataItem delete(int key){
		int hsVal = hsFunc1(key);
		int step = hsFunc2(key);
		
		while (hsary[hsVal] != null){
			if (hsary[hsVal].getKey() == key){
				DataItem temp = hsary[hsVal];
				hsary[hsVal] = this.deleted;
				return temp;
			}
			hsVal += step;
			hsVal %= hsarySize;
		}
		
		System.out.println("Can't find the item");
		return null;
	}
	
	public DataItem find(int key)
	{
		int hsVal = hsFunc1(key);
		int step = hsFunc2(key);
		
		while (hsary[hsVal] != null){
			if (hsary[hsVal].getKey() == key){
				return hsary[hsVal];
			}
			hsVal += step;
			hsVal %= hsarySize;
		}
		System.out.println("Can't find the item");
		return null;
	}
	
	
}
