package TurningPoint;

public class MajorityElmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary1 = {1, 3, 4, 2, 1, 3, 1, 1, 1, 1, 4};
		int x = ME(ary1);
		System.out.println(x);
		

	}
	
	public static int ME(int[] A){
		
		int mIndex = 0;
		int c = 1;
		
		for(int i = 1; i < A.length; i++){
			System.out.print("Now at index " + i + " and Counter is now "+ c + " ");
			if (A[mIndex] == A[i]){
				c++;
			}else{
				c--;
			}
			System.out.print("and became " + c + " And mIndex is " + i + " ");
			if (c == 0){
				mIndex = i;
				c = 1;
			}
			System.out.print("And mIndex became " + mIndex + " ");
			System.out.println();
		}
		
		return mIndex;
				
	}

}
