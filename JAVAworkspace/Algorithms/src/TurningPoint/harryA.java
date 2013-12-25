package TurningPoint;

public class harryA {

	public static boolean snape(int a, int b, int c, int[] counter){
		if (a > b) {
			System.out.println("*************************************");
			counter[0]++;
			return false;
		}
		
		if (b > c) {
			System.out.println("*************************************");
			counter[0]++;
			return false;
		}
		else {
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 3, 2, 4, 5, 7, 6, 8, 9, 11, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int[] counter = {0};

		int n = A.length;

		for (int i = 0; i < 10000; i++){

			double p = Math.random();
			int ind = (int)((n-2)*p+1);
			System.out.println(n);
			System.out.println(p);
			System.out.println(ind);
			System.out.println(snape(A[ind-1], A[ind], A[ind+1], counter));
			System.out.println();
		}
		
		System.out.println((double)counter[0]/10000);

	}

}
