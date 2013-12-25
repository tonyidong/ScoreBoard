package TurningPoint;

public class Date {
	
	private static final int[] DAYS= {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private final int year;
	private final int month;
	private final int day;
	
	public Date(int m, int d, int y){
		if(!isValid(m, d, y)) throw new RuntimeException("The Date entered is not valid!");
		month = m;
		day = d;
		year = y;
	}
	
	private static boolean isValid(int m, int d, int y){
		if (m < 1 || m > 12) return false;
		if (d < 1 || d > DAYS[m]) return false;
		if (m == 2 && d == 29 && !isLeapYear(y)) return false;
		return true;
	}
	

	private static boolean isLeapYear(int y) {
		// TODO Auto-generated method stub
		if (y%400 == 0) return true;
		if (y%100 == 0) return false;
		return (y%4 ==0);
	}
	
	public Date next(){
		if (isValid(month, day+1, year)) return new Date(month, day+1, year);
		else if(isValid(month+1, 1, year)) return new Date(month+1, 1, year);
		return new Date(1, 1, year+1); //Not sure if This is valid;
	}
	
	public int compareTo(Date that){
		if (this.year != that.year) return this.year - that.year;
		if (this.month != that.month)return this.month - that.month;
		return this.day - that.day;
	}
	
	public boolean isAfter(Date that){
		return compareTo(that) > 0;
	}
	
	public boolean isBefore(Date that){
		return compareTo(that) < 0;
	}
	
	public String toString(){
		return month+"/"+day+"/"+year;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
