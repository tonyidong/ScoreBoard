package TurningPoint;


import java.util.*;

public class lsts {
	
	public static void exper(List<Integer> lst, String name){
		System.out.println("Now try to add to the end of " + name);
		double start = System.currentTimeMillis();
		for (int i = 0; i < 1E5; i++){
			lst.add(i);
		}
		double end = System.currentTimeMillis();
		System.out.println(end - start);
		
		System.out.println("Now try to remove from the end of " + name);
		start = System.currentTimeMillis();
		for (int i = lst.size()-1; i >=0; i--){
			lst.remove(i);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		System.out.println("Now add stuff again to " + name);
		start = System.currentTimeMillis();
		for (int i = 0; i < 1E5; i++){
			lst.add(i);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		System.out.println("Now try to remove from the beginning of " + name);
		start = System.currentTimeMillis();
		for (int i = 0; i < lst.size(); i++){
			lst.remove(i);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> arylst1 = new ArrayList<Integer>();
		LinkedList<Integer> lkdlst1 = new LinkedList<Integer>();
		
		System.out.println("the current System time is: " + System.currentTimeMillis());
		
		exper(arylst1, "ArrayList");
		exper(lkdlst1, "LinkedList");
		
		
		System.out.println("the current System time is: " + System.currentTimeMillis());
		

	}

}
