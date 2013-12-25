package TurningPoint;

public class Goldilocks {
	
	public static void QS(int[] A, int[] B, int start, int end){
		if (start >= end) return;
		
		int n = A.length;
		int pivOfB = -1;
		int dec = 0;
		while (dec <= 0){
			int ran = (int)(Math.random()*n);
			for(int i = start; i <= end; i++){
				if (B[i] == A[ran]){
					pivOfB = i;
					dec++;
				}
			}
		}
		Swap(B, pivOfB, end);
		int pivot = partition(B, start, end);
		QS(A, B, start, pivot-1);
		QS(A, B, pivot+1, end);
	}

	

	public static int partition(int[] A, int start, int end){
		int pivot = A[end];
		int pIndex = start;
		for (int i = start; i < end; i++){
			if(A[i] <= pivot){
				Swap(A, i , pIndex);
				pIndex++;
			}
		}
		Swap(A, pIndex, end);
		return pIndex;
	}

	public static void Swap(int[] A, int a, int b){
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5, 9, 2, 8, 3, 7, 4, 6, 1};
		int[] B = {6, 7, 9, 4, 8, 3, 2, 5, 1};
		
		QS(A, B, 0, 8);

		for (int i = 0; i < 9; i++){
			System.out.printf("%s ", B[i]);
		}

	}

}
