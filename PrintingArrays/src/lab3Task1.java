/*Aftab Musaa
CSC 172 Lab 3 Task 1
*/

import java.util.ArrayList;

public class lab3Task1 {
public static void main(String[] args) {
	
	//Create 2D array
	int[][] array1 = {{10,15,30,40}, {15,5,8,2}, {20,2,4,2}, {1,4,5,0}};
	
	//Create a two dimensional ArrayList 
	ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>(4);
	
	fillArrayList(arraylist, array1);
	
	System.out.println("Values in the array are");
	print2Darray(array1);
	
	System.out.println("Values in the array list are");
	print2DarrayList (arraylist);
	}
	
	//Show the format version of 2D array
public static void print2Darray(int [][] array1)
{
	String out = "";
	
	//Iterate each array
		for(int a = 0; a < 4; a++)
		{
		//Now you have to iterate through the elements in each array
			for(int b = 0; b < 4; b++)
			{
				out += array1[a][b] + " ";
				if(array1[a][b] <10)
				{
					out += " "; 
				}
			}
			out += "\n";
		}
		
		//Insert a space after the number unless it's the last number in row
		System.out.println(out);
}
public static void print2DarrayList(ArrayList<ArrayList<Integer>> arraylist)
{
String out = "";
	
	//Iterate each array
		for(int a = 0; a < 4; a++)
		{
		//Now you have to iterate through the elements in each array
			for(int b = 0; b < 4; b++)
			{
				out += arraylist.get(a).get(b) + " ";
				if(arraylist.get(a).get(b) <10)
				{
					out += " "; 
				}
			}
			out += "\n";
		}
		
		//Insert a space after the number unless it's the last number in row
		System.out.println(out);
	
	
	
	
}
public static void fillArrayList(ArrayList<ArrayList<Integer>> arraylist, int[][] array)
{
	
	//Now we create an ArrayList to fill 2D ArrayList
	ArrayList <Integer> temp = new ArrayList<>(4);
	//Now use integers to fill in the ArrayList
	for(int a = 0; a < 4; a++)
	{
	//Then put in values from the 2D array
		for(int b= 0; b <4; b++)
		{
			temp.add(array[a][b]);
		}
		arraylist.add(temp);
		
		//Finally, empty the ArrayList to fill with another array
		temp = new ArrayList<Integer>();
	}



}
}