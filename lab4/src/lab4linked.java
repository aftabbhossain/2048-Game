//lists
public class lab4linked <E> {
private Link <E> head;
private Link <E> tail;
protected Link <E> curr;
int cnt;

lab4linked (int size) { this () ; }
 lab4linked () {
	 curr = tail = head = new Link<E> (null);
	 cnt = 0;
 }
 
//method is in charge of inserting elements
 public void insert (E it) {
	 curr.setNext (new Link<E> (it, curr.next()));
	 if (tail == curr) tail = curr.next ();
	 cnt ++;
 }
  
//method for appending 
 public void append (E it) {
	 tail = tail.setNext(new Link<E>(it, null));
	 cnt ++;
 }

//method for removing
 public E remove () {
	 if (curr.next () == null) return null;
	 E it = curr.next().element ();
	 if (tail == curr.next() .next());
	 cnt--;
	 return it;
 }
 
//method for moving elements to the start
	public void moveToStart () 
	{curr = head; }

//method for moving elements to the end
	public void moveToEnd ()
	{curr = tail;  }

//method for moving elements to thep revious position
public void prev () {
	if (curr == head) return;
	Link <E> temp = head;
	while (temp.next() != curr) temp = temp.next () ;
	curr = temp;
}
//method for moving the elements to the next position
public void next ()
{ if (curr != tail) curr = curr.next(); }

//method in getting the length
public int length() { return cnt; }

//method for the current position
public int currPos () {
	Link <E> temp = head;
	int i;
	for (i=0; curr != temp; i++)
temp = temp.next();
return i;
 }
//method for moving elements to other positions 
	public void moveToPos (int pos) {
		assert (pos>=0) && (pos<=cnt) : "Position out of range";
		curr = head;
		for (int i=0; i<pos; i++) curr = curr.next();
	}
//method for receiving the value and what to do if the element is null
	public E getValue() {
		if(curr.next() == null) return null;
		return curr.next().element();
	
	}
	}