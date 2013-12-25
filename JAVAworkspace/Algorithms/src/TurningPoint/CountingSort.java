package TurningPoint;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary1 = {4,3,1,2,2};
		int n = ary1.length;
		int[] ary2 = new int[n];
		CountS(ary1, ary2, 4);
		for(int i = 0; i < n; i++){
			System.out.printf("%s ", ary2[i]);
		}
		System.out.println();
//		Insertion.instS(ary1);
		for(int i = 0; i < n; i++){
			System.out.printf("%s ", ary1[i]);
		}

	}
	
	public static void CountS(int[] A, int[] B, int k){
		int[] C = new int[k+1];
		for(int i = 1; i < A.length; i++){
			C[A[i]] += 1;
		}
		for(int i = 0; i < C.length; i++){
			System.out.printf("%s ", C[i]);
		}
		System.out.println();
		for(int i = 1; i < k+1; i++){
			C[i] = C[i] + C[i-1];
		}
		for(int i = 0; i < C.length; i++){
			System.out.printf("%s ", C[i]);
		}
		System.out.println();
		/*for(int i = A.length - 1; i >= 0; i--){
			B[C[A[i]]] = A[i];
			C[A[i]] -= 1;
		}*/
		int r = A.length-1;
		while (r >= 0){
			int a = A[r];
			int j = C[a];
			if (j >= r){
				C[a] --;
				while(j != r){
					int b = A[j];
					k = C[b];
					A[j] = a;
					a = b;
					j = k;
					C[b]--;
				}
				A[j] = a;
				System.out.println(A[r]);
			}
			r--;
		}
	}

}
