package TurningPoint;

public class StopWatch {
	
	private final long start;
	
	public StopWatch(){
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime(){
		long now = System.currentTimeMillis();
		return (now - start)/1000.0;
	}

	public static void main(String[] args) {
		int N = 500000000;
		
		double totalMath = 0.000000000000000000;
		StopWatch watchdog = new StopWatch();
		for (int i = 0; i < N; i++){
			totalMath += Math.sqrt(i);
		}
		double T = watchdog.elapsedTime();
		
		System.out.println(T);

	}

}
