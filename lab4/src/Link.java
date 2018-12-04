//links
public class Link <E> { //set the generic E


Link <E> next;
E data;

public Link (Link<E> n) {
next = n ;
}

public Link ( E d, Link <E> n) {
	next = n;
	data = d;
}
//classes for the setters and getters
public Link<E> setNext (Link <E> n) { next = n; return next; }

public void setData (E d) {data = d; }
 
public Link <E> next() { return next ; }

public E element() { return data; }	
}
