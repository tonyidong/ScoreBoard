package TurningPoint;

import java.awt.Color;
import ClosestPair.*;



public class Luminance {
	
	public static double lum(Color color){//Compute luminance of color
		int r = color.getRed();
		int b = color.getBlue();
		int g = color.getGreen();
		return .299*r + .587*g + .114*b;
	}
	
	public static Color toGray(Color color){
		int y = (int)Math.round(lum(color));
		Color gray = new Color(y, y, y);
		return gray;
	}
	
	public static boolean compatible(Color a, Color b){
		return Math.abs(lum(a) - lum(b)) >=128;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[6];
		for (int i = 0; i < 6; i++){
			a[i] = Integer.parseInt(args[i]);
		}
		Color c1 = new Color(a[0], a[1], a[2]);
		Color c2 = new Color(a[3], a[4], a[5]);
		StdOut.println(compatible(c1, c2));
		

	}

}
