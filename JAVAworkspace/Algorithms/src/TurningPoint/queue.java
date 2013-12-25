package TurningPoint;

public class queue {
	
	private int head = 0;
	private int tail = 1;
	private int[] Q;
	private int n;
	
	public queue(int n){
		this.n = n;
		this.Q = new int[n];
	}
	
	public void enQueue(int x) throws Exception{
		Q[tail] = x;
		if (tail == n-1){
			tail = 0;
		}else if(head > tail){
			throw new Exception("Can't add more");
		}
		else{
			tail++;
		}
	}
	
	public int deQueue(){
		int x = Q[head];
		if (head == n-1){
			head = 0;
		}else{
			head++;
		}
		return x;
	}
	
	public String toString(){
		if(tail > head){
			for (int i = head; i < tail; i++){
				System.out.printf("%s ", Q[i]);
			}
		}else if(tail < head){
			for (int i = 0; i < tail; i++){
				System.out.printf("%s ", Q[i]);
			}
			for (int i = head; i < n; i++){
				System.out.printf("%s ", Q[i]);
			}
		}else{
			System.err.println("It's Full Yo!");
		}
		System.out.println();
		return "";
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		queue q = new queue(10);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(6);
		q.enQueue(2);
		q.enQueue(7);
		q.enQueue(1);
		q.toString();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.toString();
		q.enQueue(3);
		q.toString();
		q.enQueue(4);
		q.toString();
		q.enQueue(6);
		q.toString();
		q.enQueue(2);
		q.toString();
		q.enQueue(7);
		q.toString();
		q.enQueue(1);
		q.toString();
		q.enQueue(3);
		q.toString();
		q.enQueue(4);
		q.toString();
		q.enQueue(6);
		q.toString();
		q.enQueue(2);
		q.toString();
		q.enQueue(7);
		q.toString();
		q.enQueue(1);
		q.toString();
	}

}
