/*Aftab Musaa
CSC 172 Lab 3 Task 2
*/

import java.util.ArrayList;

public class lab3Task2 {

public static void main(String[] args)
{

	int[][] array1 = {{10, 15, 30, 40},{15, 5, 8, 2},
			{20, 2, 4, 2}, {1, 4, 5, 0}};

	ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>(4);
	
	lab3Task1.fillArrayList(arrayList, array1);
	
	//Now implement string line for the running sum array
	System.out.println("The running sum Array is:");
	lab3Task1.print2Darray(runningSum2DArray(array1));
	
	//Now implement string line for the running sum array list
	System.out.println("The running sum Array List is:");
	lab3Task1.print2Darray(runningSum2DArray(array1));
}


public static int[][] runningSum2DArray(int[][] array)
{
	
	//This is the temporary 2d Integer Array
	int [][] temp = new int [4][4];
	//The running sum variable
	int sum = 0;
	
	for(int a = 0; a < 4; a++)
	{
		for(int b = 0; b < 4; b++)
		{
			sum += array[a][b];
			temp[a][b] = sum;
		}
		//Restart the sum
		sum = 0;
}
return temp;
}

public static ArrayList<ArrayList<Integer>> runningSum2ArrayList(ArrayList<ArrayList<Integer>> array)
{
	//The temp 2D arrayList is as follows
	ArrayList<ArrayList<Integer>> temp = new ArrayList<>(4);
	
	//Now this is the temp 1D ArrayList
	ArrayList<Integer> temp2 = new ArrayList<>(4);
	
	//This is the deep copy of the ArrayList Array
	for(int a = 0; a <4; a++)
	{
		for(int b = 0; b < 4; a++)
			temp2.add(array.get(a).get(b));
		temp.add(temp2);
		temp2 = new ArrayList<>(4);
	}
	


//Then initialize the running time
	int sum = 0;
	for (int a = 0; a < 4; a++)
	{
		
		//Now implement iterations through the elements 1-4 of each arrayList
		for (int b = 0; b <4; b++)
		{
			//Now add the current elements
			sum += array.get(a).get(b);
			temp.get(a).set(b, sum);
			
		}
		sum = 0;		
	}
	return temp;	
	}
}
