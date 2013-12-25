package TurningPoint;
import ClosestPair.*;


public class Transition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5; //# of pages
		int[][] count = new int[N][N]; //Links from i to j;
		int[] outDegree = new int[N];//Links from i to anywhere
		
		while(!StdIn.isEmpty()){
			int i = StdIn.readInt();
			int j = StdIn.readInt();
			outDegree[i]++;
			count[i][j]++;
		}
		
		StdOut.println(N + " " + N);
		
		for (int i = 0; i < N; i++){
			for (int j = 0; i<N; i++){
				double p = .90*count[i][j]/outDegree[i] + .10/N; 
                StdOut.printf("%7.5f ", p); 
			}
			System.out.println();
		}

	}

}
