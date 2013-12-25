package TurningPoint;

public class Insertion {
	
	public static void instS(int[] A){
		int n = A.length;
		for (int i = 1; i < n; i++){
			int value = A[i];
			int j = i-1;
			while(j >= 0 && value < A[j]){
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] B = {2, 4, 1, 3, 5};
		System.out.println("What the fuck");
		int[] A = new int[20];
		
		for (int i = 0; i < A.length; i++){
			A[i] = (int)(Math.random()*10000);
		}
		
		
		instS(A);
		instS(B);
		for(int i = 0; i < A.length; i++){
			System.out.printf("%s ", A[i]);
		}
		System.out.println();
		for(int i = 0; i < B.length; i++){
			System.out.printf("%s ", B[i]);
		}

	}

}
