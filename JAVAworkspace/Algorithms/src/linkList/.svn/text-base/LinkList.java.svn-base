package linkList;

public class LinkList {
	private Link first;

	public LinkList() {//When constructed, no item in the list
		super();
		this.first = null;
	}
	
	public boolean isEmpty(){//True is the list is empty
		return first == null;
	}
	
	//Insert in the front of the list
	public void insertFirst(int id, double dd){//make new link
		Link newLink = new Link(id, dd);
		newLink.next = first; //newLink --> oldFirst
		first = newLink;//first --> newLink
	}
	
	public Link deleteFirst(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		System.out.println("The Link list from first to last: ");
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		
	}
	
	
	
	

}
