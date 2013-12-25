package ClosestPair;

public class ex233 {
	
	public static void exe233(int n){
		if (n <= 0) return;
		System.out.printf("%d ", n);
		exe233(n-2);
		exe233(n-3);
		System.out.printf("%d ", n);
	}
	
	public static String ex234(int n){
		if (n<=0) return "";
		return ex234(n-3) + n + ex234(n-2) + n;
	}
	
	/*public static String ex235(int n) {
	    String s = exe233(n-3) + n + ex235(n-2) + n;
	    if (n <= 0) return "";
	    return s;
	}*/
	
	public static int gcd(int p, int q){
		if (q == 0) return p;
		return gcd(q, p%q);
	}
	
	public static boolean gcdlike(int p, int q) {
		   if (q == 0) return (p == 1);
		   return gcdlike(q, p % q);
		}
	
	/* public static void main(String[] args) { 
	        String ruler1 = " 1 ";
	        String ruler2 = ruler1 + "2" + ruler1;
	        String ruler3 = ruler2 + "3" + ruler2;
	        String ruler4 = ruler3 + "4" + ruler3;
	        String ruler5 = ruler4 + "5" + ruler4;

	        System.out.println(ruler1);
	        System.out.println(ruler2);
	        System.out.println(ruler3);
	        System.out.println(ruler4);
	        System.out.println(ruler5);
	    }*/
	
	public static String ruler(int n){
		if (n == 1) return "1";
		return ruler(n-1) + n + ruler(n-1); 
	}
	
	/*Solve the following recurrence relations, all with T(1) = 1. Assume N is a power of two.
T(N) = T(N/2) + 1
T(N) = 2T(N/2) + 1
T(N) = 2T(N/2) + N
T(N) = 4T(N/2) + 3*/
	
	public static int T(int n){
		if (n == 1) return 1;
		return 2*T(n/2) + n;
	}

	public static void main(String[] args) {
		System.out.println(T(4));
	}

}
