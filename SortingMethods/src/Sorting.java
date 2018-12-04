/*Aftab H Musaa 
 * Sorting.java
 * Lab Partner: Evan Cohen-Doty
 * Lab Section MW 325-440
 */
/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Sorting {


 /**
     * 
     * Sorts the numbers present in the file based on the algorithm provided.
     * 0 = Arrays.sort() (Java Default)
     * 1 = Bubble Sort
     * 2 = Selection Sort 
     * 3 = Insertion Sort 
     * 4 = Mergesort
     * 5 = Quicksort
     *
     * @param args the command-line arguments
 * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException  { 
    	
        In in = new In(args[0]);
        
		  // Storing file input in an array
        int[] a = in.readAllInts();

        // b contains sorted integers from a (You can use Java Arrays.sort() method)
        int[] b = new int[a.length];
        for(int i = 0; i < a.length; i++) {
        	b[i] = a[i];
        }
        Arrays.sort(b);
        // c contains all integers stored in reverse order 
        int[] c = new int[b.length];
        for(int i = 0; i < b.length; i++) {
        	c[i] = b[b.length - 1 - i];
        }
        // (you can have your own O(n) solution to get c from b
        
        // d contains almost sorted array 
        int[] d = new int[b.length];
		for(int i = 0 ; i < b.length; i++) {
			d[i] = b[i];
		}
		for(int i = 0; i < d.length * 0.1; i++) {
			int temp = d[i];
			d[i] = d[d.length - 1 - i];
			d[d.length - 1 - i] = temp;
		}
        //(You can copy b to a and then perform (0.1 * d.length)  many swaps to acheive this.   
        
        //TODO: 
        // Read the second argument and based on input select the sorting algorithm
        //  * 0 = Arrays.sort() (Java Default)
        //  Perform sorting on a,b,c,d. Pring runtime for each case along with timestamp and record those. 
        // For runtime and priting, you can use the same code from Lab 4 as follows:
        
        //  * 1 = Bubble Sort
        //  * 3 = Insertion Sort 
        //  * 4 = Mergesort
        //  * 5 = Quicksort
		
		//performs the default java sort on each array
        if(args[1].equals("0")) {
        	
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            //TODO: Replace with your own netid
            String netID = "amusaa";
            //TODO: Replace with the algorithm used 
            String algorithmUsed = "Java default (Arrays.sort())";
            //starts the clock 
            Stopwatch timer = new Stopwatch();
            //sorts the array
            Arrays.sort(a);
            //gets the time when done sorting
            double time = timer.elapsedTimeMillis();
            String arrayUsed = "a";
            //prints to the terminal all the relevant information
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out1 = new PrintStream(new FileOutputStream("a.txt"));
            System.setOut(out1);
            //prints the now sorted array to a text file
            	for(int i = 0; i < a.length; i++) {
            		System.out.print(a[i] + " ");
            }
            
          // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
            Stopwatch timer2 = new Stopwatch();            
            Arrays.sort(b);
            time = timer2.elapsedTimeMillis();
            arrayUsed = "b";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out2 = new PrintStream(new FileOutputStream("b.txt"));
            System.setOut(out2);
            	for(int i = 0; i < b.length; i++) {
            		System.out.print(b[i] + " ");
            }
            
            Stopwatch timer3 = new Stopwatch();
            Arrays.sort(c);
            time = timer3.elapsedTimeMillis();
            arrayUsed = "c";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out3 = new PrintStream(new FileOutputStream("c.txt"));
            System.setOut(out3);
            	for(int i = 0; i < c.length; i++) {
            		System.out.print(c[i] + " ");
            }
            
            Stopwatch timer4 = new Stopwatch();
            Arrays.sort(d);
            time = timer4.elapsedTimeMillis();
            arrayUsed = "d";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out4 = new PrintStream(new FileOutputStream("d.txt"));
            System.setOut(out4);
            	for(int i = 0; i < d.length; i++) {
            		System.out.print(d[i] + " ");
            }
        }
        if(args[1].equals("1")) {
        	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            //TODO: Replace with your own netid
            String netID = "amusaa";
            
            String algorithmUsed = "Bubble sort";
            Stopwatch timer1 = new Stopwatch();
            for(int i = 0; i < a.length; i++) {
            	for(int j = a.length-1; j > i; j--) {
            		if(a[j] < a[j-1]) {
            			int temp = a[j];
            			a[j] = a[j-1];
            			a[j-1] = temp;
            		}
            	}
            }
            double time = timer1.elapsedTimeMillis();
            String arrayUsed = "a";
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            arrayUsed = "b";
            Stopwatch timer2 = new Stopwatch();
            for(int i = 0; i < b.length; i++) {
            	for(int j = b.length - 1; j > 1; j--) {
            		if(b[j] < b[j-1]) {
            			int temp = b[j];
            			b[j] = b[j-1];
            			b[j-1] = temp;
            		}
            	}
            }
            time = timer2.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            
            arrayUsed = "c";
            Stopwatch timer3 = new Stopwatch();
            	for(int i = 0; i < c.length; i++) {
            		for(int j = c.length -1; j > 0; j--) {
            			if(c[j] < c[j-1]) {
            				int temp = c[j];
            					c[j] = c[j-1];
            						c[i] = temp;
            		}
            	}
            }
            time = timer3.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            
            arrayUsed = "d";
            Stopwatch timer4 = new Stopwatch();
            	for(int i = 0; i < d.length; i++) {
            		for(int j = d.length -1; j > 1; j--) {
            			if(d[j] < d[j-1]) {
            				int temp = d[j];
            					d[j] = d[j-1];
            						d[j-1] = temp;
            		}
            	}
            }
            time = timer4.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
        }
        if(args[1].equals("2")) {
        	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String netID = "amusaa";
            String algorithmUsed = "Selection sort";
            
            String arrayUsed = "a";
            Stopwatch timer5 = new Stopwatch();
            	for(int i = 0; i < a.length; i ++) {
            		int minIndex = i;
            			for(int j = a.length - 1; j > i; j--) {
            				if(a[minIndex] > a[j])
            					minIndex = j;
            	}
            	int temp = a[minIndex];
            	a[minIndex] = a[i];
            	a[i] = temp;
            }
            double time = timer5.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out = new PrintStream(new FileOutputStream("a.txt"));
            System.setOut(out);
            for(int i = 0; i < a.length; i++) {
            	System.out.print(a[i] + " ");
            }
            arrayUsed = "b";
            Stopwatch timer6 = new Stopwatch();
            	for(int i = 0; i < b.length; i ++) {
            		int minIndex = i;
            			for(int j = b.length - 1; j > i; j--) {
            				if(a[minIndex] > b[j])
            			minIndex = j;
            	}
            	int temp = b[minIndex];
            	b[minIndex] = b[i];
            	b[i] = temp;
            }
            time = timer6.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out1 = new PrintStream(new FileOutputStream("b.txt"));
            System.setOut(out1);
            	for(int i = 0; i < b.length; i++) {
            		System.out.print(b[i] + " ");
            }
            	
            arrayUsed = "c";
            Stopwatch timer7 = new Stopwatch();
            	for(int i = 0; i < c.length; i ++) {
            		int minIndex = i;
            			for(int j = c.length - 1; j > i; j--) {
            				if(c[minIndex] > c[j])
            					minIndex = j;
            	}
            	int temp = c[minIndex];
            	c[minIndex] = c[i];
            	c[i] = temp;
            }
            time = timer7.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out2 = new PrintStream(new FileOutputStream("c.txt"));
            System.setOut(out2);
            for(int i = 0; i < c.length; i++) {
            	System.out.print(c[i] + " ");
            }
            arrayUsed = "d";
            Stopwatch timer8 = new Stopwatch();
            	for(int i = 0; i < d.length; i ++) {
            		int minIndex = i;
            			for(int j = d.length - 1; j > i; j--) {
            				if(d[minIndex] > d[j])
            					minIndex = j;
            	}
            	int temp = d[minIndex];
            		d[minIndex] = d[i];
            		d[i] = temp;
            }
            time = timer8.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out3 = new PrintStream(new FileOutputStream("d.txt"));
            System.setOut(out3);
            	for(int i = 0; i < d.length; i++) {
            		System.out.print(d[i] + " ");
            }
        }
        if(args[1].equals("3")) {
        	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            //TODO: Replace with your own netid
            String netID = "amusaa";
            
            String algorithmUsed = "Insertion sort";
            
            String arrayUsed = "a";
            Stopwatch timer9 = new Stopwatch();
            	for(int i = 0; i < a.length; i++) {
            		for(int j = i; (j > 0) && (a[j] < a[j-1]); j--) {
            			int temp = a[j];
            				a[j] = a[j-1];
            					a[j-1] = temp;
            	}
            }
            double time = timer9.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out1 = new PrintStream(new FileOutputStream("a.txt"));
            System.setOut(out1);
            	for(int i = 0; i < a.length; i++) {
            		System.out.print(a[i] + " ");
            }
            
            arrayUsed = "b";
            Stopwatch timer10 = new Stopwatch();
            	for(int i = 0; i < b.length; i++) {
            		for(int j = i; (j>0) && (b[j] < b[j-1]); j--) {
            			int temp = b[j];
            			b[j] = b[j-1];
            				b[j-1] = temp;
            	}
            }
            time = timer10.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out2 = new PrintStream(new FileOutputStream("b.txt"));
            System.setOut(out2);
            	for(int i = 0; i < b.length; i++) {
            		System.out.print(b[i] + " ");
            }
            
            arrayUsed = "c";
            Stopwatch timer11 = new Stopwatch();
            	for(int i = 0; i < c.length; i++) {
            		for(int j = i; (j>0) && (c[j] < c[j-1]); j--) {
            			int temp = c[j];
            			c[j] = c[j-1];
            				c[j-1] = temp;
            	}
            }
            time = timer11.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out3 = new PrintStream(new FileOutputStream("c.txt"));
            System.setOut(out3);
            	for(int i = 0; i < c.length; i++) {
            		System.out.print(c[i] + " ");
            }
            
            arrayUsed = "d";
            Stopwatch timer12 = new Stopwatch();
            	for(int i = 0; i < d.length; i++) {
            		for(int j = i; (j > 0) && (d[j] < d[j-1]); j--) {
            			int temp = d[j];
            				d[j] = d[j-1];
            					d[j-1] = temp;
            	}
            }
            time = timer12.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out4 = new PrintStream(new FileOutputStream("d.txt"));
            System.setOut(out4);
            	for(int i = 0; i < d.length; i++) {
            		System.out.print(d[i] + " ");
            }
        }
        if(args[1].equals("4")) {
        	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String netID = "amusaa";
            String algorithmUsed = "Merge sort";
            
            String arrayUsed = "a";
            int[] temp1 = new int[a.length];
            Stopwatch timer13 = new Stopwatch();
            mergeSort(a, temp1, 0, a.length-1);
            double time = timer13.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out1 = new PrintStream(new FileOutputStream("a.txt"));
            System.setOut(out1);
            	for(int i = 0 ; i < a.length; i++) {
            		System.out.print(a[i] + " ");
            }
            
            arrayUsed = "b";
            int[] temp2 = new int[b.length];
            Stopwatch timer14 = new Stopwatch();
            mergeSort(b, temp2, 0, b.length -1);
            time = timer14.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out2 = new PrintStream(new FileOutputStream("b.txt"));
            System.setOut(out2);
            	for(int i = 0; i < b.length; i++) {
            		System.out.print(b[i] + " ");
            }
            
            arrayUsed = "c";
            int[] temp3 = new int[c.length];
            Stopwatch timer15 = new Stopwatch();
            mergeSort(c, temp3, 0, c.length-1);
            time = timer15.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out3 = new PrintStream(new FileOutputStream("c.txt"));
            System.setOut(out3);
            	for(int i = 0; i < c.length; i++) {
            		System.out.print(c[i] + " ");
            }
            
            arrayUsed = "d";
            int[] temp4 = new int[d.length];
            Stopwatch timer16 = new Stopwatch();
            mergeSort(d, temp4, 0, d.length -1);
            time = timer16.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out4 = new PrintStream(new FileOutputStream("d.txt"));
            System.setOut(out4);
            	for(int i = 0; i < d.length; i++) {
            		System.out.print(d[i] + " ");
            }
        }
        if(args[1].equals("5")) {
        	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String netID = "amusaa";
            String algorithmUsed = "Quick sort";
            
            String arrayUsed = "a";
            Stopwatch timer17 = new Stopwatch();
            quickSort(a, 0, a.length-1);
            double time = timer17.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out1 = new PrintStream(new FileOutputStream("a.txt"));
            System.setOut(out1);
            	for(int i = 0; i < a.length; i++) {
            		System.out.print(a[i] + " ");
            }
            
            arrayUsed = "b";
            Stopwatch timer18 = new Stopwatch();
            quickSort(b, 0, b.length-1);
            time = timer18.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out2 = new PrintStream(new FileOutputStream("b.txt"));
            System.setOut(out2);
            	for(int i = 0; i < b.length; i++) {
            		System.out.print(b[i] + " ");
            }
            
            arrayUsed = "c";
            Stopwatch timer19 = new Stopwatch();
            quickSort(c, 0, c.length-1);
            time = timer19.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out3 = new PrintStream(new FileOutputStream("c.txt"));
            System.setOut(out3);
            	for(int i = 0; i < c.length; i++)
            		System.out.print(c[i] + " ");
            
            arrayUsed = "d";
            Stopwatch timer20 = new Stopwatch();
            quickSort(d, 0, d.length -1);
            time = timer20.elapsedTimeMillis();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            PrintStream out4 = new PrintStream(new FileOutputStream("d.txt"));
            System.setOut(out4);
            	for(int i = 0; i < d.length; i++)
            		System.out.print(d[i] + " ");
        }
        
  }
    public static void quickSort(int[] array, int l, int r) {
		int pivotIndex = findPivot(array, l, r);
		int temp = array[pivotIndex];
		array[pivotIndex] = array[r];
		array[r] = temp;
		
		int k = partition(array, l, r, array[r]);
		int zhupa = array[k];
		array[k] = array[r];
		array[r] = zhupa;
			if((k-l) > 1) quickSort(array, l, k-1);
				if((r-k) > 1) quickSort(array, k+1, r);
	}
	
	public static int findPivot(int[] array, int l, int r) {
		return (l+r)/2;
	}
	
	public static int partition(int[] array, int l, int r, int pivot) {
		do { // Move bounds inward until they meet
			while (array[++l]<(pivot));
				while ((r!=0) && (array[--r]>(pivot)));
		int temp1 = array[l];
		array[l] = array[r];
		array[r] = temp1;
			} while (l < r); // Stop when they cross
		int temp = array[l];
		array[l] = array[r];
		array[r] = temp;
			return l; // Return first position in right partition
		}
    public static void mergeSort(int[] A, int[] temp, int l, int r) {
		int mid = (l+r)/2; // Select midpoint
			if (l == r) return; // List has one element
		mergeSort(A, temp, l, mid); // Mergesort first half
		mergeSort(A, temp, mid+1, r); // Mergesort second half
		for (int i=l; i<=r; i++) // Copy subarray to temp
			temp[i] = A[i];
		// Do the merge operation back to A
		int i1 = l; int i2 = mid + 1;
			for (int curr=l; curr<=r; curr++) {
				if (i1 == mid+1) // Left sublist exhausted
				A[curr] = temp[i2++];
				else if (i2 > r) // Right sublist exhausted
				A[curr] = temp[i1++];
				else if (temp[i1] < (temp[i2])) // Get smaller
				A[curr] = temp[i1++];
				else A[curr] = temp[i2++];
		}
	}
} 


