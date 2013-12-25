package TurningPoint;
import ClosestPair.*;

public class Histogram {
	
	private final double[] freq;
	private double max;
	
	public Histogram(int N){
		freq = new double[N];
	}
	
	public void addDataPoint(int i){
		freq[i]++;
		freq[i] = Math.max(freq[i], max);
	}
	
	public void draw(){
		StdDraw.setYscale(0, max);
		StdStats.plotBars(freq);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 20;
		int T = 1000000;
		
		Histogram hist = new Histogram(N+1);
		for(int t = 0; t < T; t++){
			hist.addDataPoint((int)Math.random()*20);
			
		}
		StdDraw.setCanvasSize(500, 100);
		hist.draw();

	}

}
