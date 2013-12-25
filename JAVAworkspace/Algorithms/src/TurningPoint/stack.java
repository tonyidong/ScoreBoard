package TurningPoint;

public class stack {
	
	private int top = -1;
	private final int n;
	private int[] S;
	
	public stack(int x){
		this.n = x;
		this.S = new int[n];
	}
	
	public boolean isEmpty(){
		if(top <= -1) return true;
		else return false;
	}
	
	public void push(int x){
		top += 1;
		S[top] = x;
	}
	
	public int pop() throws Exception{
		if (isEmpty()){
			throw new Exception("It's Empty Yo, underFlow Yo");
		}else{
			top -= 1;
			return S[top+1];
		}
		
	}
	
	public String toString(){
		for(int i = 0; i < top+1; i++){
			System.out.printf("%s ", S[i]);
		}
		return "";
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		stack a = new stack(10);
		a.push(5);
		System.out.println(a);
		a.pop();
		System.out.println(a);
		a.push(57);
		a.push(52);
		a.push(2);
		a.push(4);
		System.out.println(a);
		a.pop();
		System.out.println(a);
		

	}

}
