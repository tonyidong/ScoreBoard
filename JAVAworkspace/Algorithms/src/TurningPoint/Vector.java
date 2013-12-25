package TurningPoint;

public class Vector {
	
	private final int N; //The length of the vector
	private double[] data;
	
	public Vector(int N){
		this.N = N;
		this.data = new double[N];
	}
	
	public Vector(double[] ary1){
		this.N = ary1.length;
		this.data = new double[N];
		for (int i = 0; i< N; i++){
			data[i] = ary1[i];
		}
	}
	
	public int length(){
		return data.length;
	}
	
	public double dot(Vector that){
		if (this.length() != that.length()) throw new RuntimeException("Can't dot different dimention vectors");
		double sum = 0.0;
		for (int i = 0; i < N; i++){
			sum += this.data[i] * that.data[i];
		}
		return sum;
	}
	
	public double magnitude(){
		return Math.sqrt(this.dot(this));
	}
	
	public double distanceTo(Vector that){
		if (this.length() != that.length()) throw new RuntimeException("Can't distanceTo different dimention vectors");
		return this.minus(that).magnitude();
	}
	
	public Vector plus(Vector that){
		if (this.length() != that.length()) throw new RuntimeException("Can't add different dimention vectors");
		Vector vec = new Vector(N);
		for (int i = 0; i < N; i++){
			vec.data[i] = this.data[i] + that.data[i];
		}
		return vec;
	}
	
	public Vector minus(Vector that){
		if (this.length() != that.length()) throw new RuntimeException("Can't minus different dimention vectors");
		Vector vec = new Vector(N);
		for (int i = 0; i < N; i++){
			vec.data[i] = this.data[i] - that.data[i];
		}
		return vec;
	}
	
	public double cartesain(int i){
		return data[i];
	}
	
	public Vector times(double t){
		Vector vec = new Vector(N);
		for (int i = 0; i< N; i++){
			vec.data[i] = t*this.data[i];
		}
		return vec;
	}
	
	public Vector direction(){
		if(this.magnitude()==0) throw new RuntimeException("zero-vector does not have direction");
		return this.times(1.0/this.magnitude());
	}
	
	public String toString(){
		String s = "(";
		for (int i = 0; i<N; i++){
			s += data[i];
			if (i < N-1) s+= ", ";
		}
		return s + ")";
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
