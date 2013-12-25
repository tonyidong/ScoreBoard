package DoubleHashing;

public class DataItem {
	
	private int Data;
	private int key;
	
	public DataItem(int x){
		this.key = x;
	}
	
	public DataItem(int theKey, int y){
		this.key = theKey; 
		this.Data = y;
	}
	
	public int getKey(){
		return this.key;
	}

}
