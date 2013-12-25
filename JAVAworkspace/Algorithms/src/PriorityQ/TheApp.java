package PriorityQ;

public class TheApp {
	
	public static void main(String[] agrs){
		PriorityQ thePQ = new PriorityQ(5); thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);
		
		while(!thePQ.isEmpty()){
			long x = thePQ.remove();
			System.out.print(x + " ");
		}
		
		System.out.println();
	}

}
