import java.util.Scanner;
import java.util.*;
public class controller {

	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		int startingBoard = random.nextInt(4);
		
		System.out.println("Press any key to begin");
	
		String key = input.next();
		
		project1 bb = new project1();
		
		bb.newBoard(startingBoard);
		bb.print(bb.board);
		while(!key.equals("q")) {
			
			key = input.next();
			switch(key) {
			case "w":
			//if(bb.canMove() ) {
				//bb.moveup();
				bb.print(bb.board);
				System.out.println();;
				System.out.println("Valid moves: " +bb.validMoves);
				System.out.println("High score: " +bb.highestValue);
			//}else {
				//bb.gameOver();
			//}
			key = "";
			break;
			case "a":
				//if(bb.canMove()) {
					bb.moveleft();
					bb.print(bb.board);
					System.out.println();
					System.out.println("Valid moves: " + bb.validMoves);
					System.out.println("High Scaore: " + bb.highestValue);;
				//}else {
				//	bb.gameOver();
				//}
				key = "";
				break;
			case "d":
				//if(bb.canMove()) {
					bb.moveRight();
					bb.print(bb.board);
					System.out.println();
					System.out.println("Valid Moves: " +bb.validMoves);
					System.out.println("High Score: " +bb.highestValue);;
				
				key = "";
				break;
			case "s":
				
					bb.moveDown();
					bb.print(bb.board);
					System.out.println();
					System.out.println("Valid Moves: " +bb.validMoves);
					System.out.println("High Score: " +bb.highestValue);;
	
				key = "";
				break;
			case "r":
			System.out.println("Are you sure you want to restart? Press r again to confirm. If otherwise, press any key.");
			key = input.next();
			if(key.equals("r")) {
				bb.reset();
				break;
			}else {
				System.out.println("Continue");
				break;
			}
			case "q":
				System.out.println("Are you sure you want to quit? Press q again if so. Otherwise, press any key to cotinue.");
				key = input.next();
				if(!key.equals("q")); {
					System.out.println("Continue");
				}
				break;
			}
			
		}
		
		if(key.equals("q")) {
			System.out.printf("%n%n%n%n%n%n%n");
			System.out.println("Game Over");;
			System.out.println("Valid moves: " + bb.validMoves);
			System.out.println("High Score: " + bb.highestValue);
			
		}
		input.close();
			}
			}
	