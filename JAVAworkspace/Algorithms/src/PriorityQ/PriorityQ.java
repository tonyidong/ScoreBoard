package PriorityQ;

public class PriorityQ {
	
	private int maxSize;
	private long[] QArray;
	private int n;
	
	public PriorityQ(int s){
		maxSize = s;
		QArray = new long[s];
		n = 0;
	}
	
	public void insert(long x){
		
		if(n == 0){
			QArray[n++] = x;
		}else{
			for(int i = n-1; i >= 0; i--){
				if(x > QArray[i]){
					QArray[i+1] = QArray[i];
				}else{
					break;
				}
				QArray[i+1] = x;
				n++;
			}
		}
	}
	
	public long remove(){
		return QArray[--n];
	}
	
	public long peek(){
		return QArray[n-1];
	}
	
	public boolean isEmpty(){
		return n==0;
	}
	
	public boolean isFull(){
		return n == maxSize;
	}

}
