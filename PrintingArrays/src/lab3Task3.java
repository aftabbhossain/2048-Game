/*Aftab Musaa
CSC 172 Lab 3 Task 3
*/

//Import array list utility
import java.util.ArrayList;
//import iterator utility
import java.util.Iterator;

public class lab3Task3 {

public static void main(String [] args)
{
	
	ArrayList<Integer> array1 = new ArrayList<Integer>();
	
	array1.add(1);
	array1.add(2);
	array1.add(3);
	
	//Implement the printArray functions
	System.out.println("Basic for:");
	printArrayListBasicLoop(array1);
	
	System.out.println("Enhanced for:");
	printArrayListEnhancedLoop(array1);
	
	System.out.println("Basic for with the iterator:");
	printArrayListForLoopListIterator(array1);
	
	System.out.println("Basic while with the iterator:");
	printArrayListWhileLoopListIterator(array1);
	}

//Now we use basic while for loop
static void printArrayListBasicLoop(ArrayList<Integer> al){

	String out = "";
	for(int a = 0; a< al.size(); a++){
		out += al.get (a) + " ";
	}
	System.out.println(out);
	}

//Next we use the basic for loop with the iterator 
static void printArrayListEnhancedLoop(ArrayList<Integer> al) {

	String out = "";
	for(Integer a : al ) {
		out += a + " ";
	}
	System.out.println(out);
}
//We then use the for loop with the iterator
static void printArrayListForLoopListIterator(ArrayList<Integer> al)
{
	String out = "";
	for(Iterator<Integer> a=al.iterator();
			a.hasNext();) {
		out += a.next() + " ";
	}
	System.out.println(out);
}

//And finally, we utilize the while loop with the iterator
static void printArrayListWhileLoopListIterator(ArrayList<Integer> al) {
	
	String out = "";
	Iterator<Integer> a = al.iterator();
	
	while(a.hasNext()) {
		out += a.next() + " ";
	}
		System.out.println(out);	
}
	
	
}
