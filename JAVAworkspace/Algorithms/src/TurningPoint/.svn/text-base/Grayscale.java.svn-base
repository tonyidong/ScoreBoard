package TurningPoint;

import java.awt.Color;

public class Grayscale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Picture pic = new Picture(args[0]);
		for(int x = 0; x<pic.height(); x++){
			for (int y = 0; y < pic.width(); y++){
				Color color = pic.get(x,y);
				Color gray = Luminance.toGray(color);
				pic.set(x, y, gray);
			}
		}
		
		pic.show();

	}

}
