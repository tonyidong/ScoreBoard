package linkList2;

public class Link {
	public int iData;
	public double dData;
	public Link next;
	
	public Link(int iData, double dData) {
		super();
		this.iData = iData;
		this.dData = dData;
	}
	
	public void displayLink(){
		System.out.println("{" + iData + ", " + dData + "} ");
	}
}
