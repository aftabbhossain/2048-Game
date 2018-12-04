import java.util.*;
import java.util.Arrays;

public class project1 {


	Random random = new Random();
	
	//Following are the borders for the board 
	String[] name = {"-","-","-","-","-","-"};
	String[] name1 = {"-","-","-","-","-","-"};
	
	//First new board
	String[][] start1st = {{"*","*","*","*"},{"*","*","2", "*"},{"*","*","*","*",},{"2","*","*","*"}};
	
	//Second new board
	String[][] start2nd = {{"2","*","*","*"},{"*","*","*","*"},{"*","*","*","*"},{"*","*","*","2"}};
	
	//Third new board
	String[][] start3rd = {{"*","*","2","*"},{"*","*","*","*"},{"*","2","*","*",},{"*","*","*","2"}};
	
	//Fourth new board
	String [][] start4th = {{"*","*","*","*"},{"*","*","*","*"},{"*","*","*","2"},{"2","*","*","*"}};
	
	//Fifth new board
	String [][] start5th = {{"*","*","*","2"},{"2","*","*","*"},{"*","*","*","*"},{"*","*","*","*"}};
	
	//The current board 
	String[][] board = new String[4][4];
	
	//The Score
	int validMoves = 0;
	int highestValue = 2;

	public void printTopBottomBorder(String[] data) {
		System.out.printf("%n"); 
		String result = "";
		for(int i = 0; i < data.length; i++) {
			result += data[i] + "    ";	
		}
			System.out.printf("%s", result);
	}
	
	public void print(String[][] data) {
		printTopBottomBorder(name);
		String row = "|      ";
		for(int k = 0; k < data.length; k++) {
			for(int l = 0; l < data.length; l++) {
				row += data[k][l] + "      ";
		}
		row += "|";
		System.out.printf("%n%n%s", row);
		row = "|      ";
		}
		printTopBottomBorder(name1);
	}
	public void board(String[][] board) {
		this.board = board ;
	}
	
	public void newBoard(int board) {
		switch(board) {
		case 0:
			board(start1st);
			break;
		case 1:
			board(start2nd);
			break;
		case 2:
			board(start3rd);
			break;
		case 3:
			board(start4th);
			break;
		
		case 4:
			board(start5th);
			break;
		}
		System.out.printf("%n");
	}
	
	public void setcurrentBoard(String[][] curr) {board = curr; }

	
	public void moveRight() {
		//first shift
		for(int i = 0; i < 4; i++) {
			for (int j = 3; j > -1; j --) {
				if(!board[i][j].equals("*")) {
					continue;
				}
					for (int k = j; k < 3; k++) {
						if(board[i][k+1].equals("*")) {
							//swap(board[i][k],board[i][k+1]);
							board[i][k+1] = board[i][k];
							board[i][k] = "*";
						}else {
							break;
						}
					
					
				}
			}
		}
		
		//combine
		for(int i = 0; i < 4; i++) {
			for(int j = 2; j >=0; j--) {
				if(!board[i][j].equals("*")) {
					if(board[i][j].equals(board[i][j+1])) {
						Integer temporary = Integer.parseInt(board[i][j+1]);
						temporary = temporary * 2;
						board[i][j+1] = temporary.toString();
						board[i][j] = "*";
						if(temporary > highestValue) highestValue = temporary;
						
					}
				}
			}
		}
		
		//second shift
		for(int i = 0; i < 4; i++) {
			for (int j = 3; j > -1; j --) {
				if(board[i][j].equals("*")) {
					continue;
				}
				for (int k = j; k < 3; k++) {
					if(board[i][k+1].equals("*")) {
						//swap(board[i][k],board[i][k+1]);
						board[i][k+1] = board[i][k];
						board[i][k] = "*";
					}else {
						break;
					}
				}
					
			
			}
		}
		
		
		add();
		
	}
	
	public void moveleft() {
		for(int i = 0; i < 4; i++) {
			for (int j = 3; j > -1; j --) {
				if(!board[i][j].equals("*")) {
					continue;
				}
					for (int k = j; k < 3; k++) {
						if(board[i][k+1].equals("*")) {
							//swap(board[i][k],board[i][k+1]);
							board[i][k+1] = board[i][k];
							board[i][k] = "*";
						}else {
							break;
						}
					
					
				}
			}
		}
		
		//combine
		for(int i = 0; i < 4; i++) {
			for(int j = 2; j >=0; j--) {
				if(!board[i][j].equals("*")) {
					if(board[i][j].equals(board[i][j+1])) {
						Integer temporary = Integer.parseInt(board[i][j+1]);
						temporary = temporary * 2;
						board[i][j+1] = temporary.toString();
						board[i][j] = "*";
						if(temporary > highestValue) highestValue = temporary;
						
					}
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for (int j = 3; j > -1; j --) {
				if(board[i][j].equals("*")) {
					continue;
				}
				for (int k = j; k < 3; k++) {
					if(board[i][k+1].equals("*")) {
						
						board[i][k+1] = board[i][k];
						board[i][k] = "*";
					}else {
						break;
					}
				}
					
			
			}
		}
		
		
		add();
		
	}
	
	public void shiftRight() {
		for(int k = 0; k <4; k++) {
			for(int l = 3; l > -1; l--) {
				if(board[k][l].equals("*")) {
					continue;
				}
				for(int p = l; p < 3; p++) {
					if(board[k][p+1].equals("*")) {
						board[k][p] = "*";
					}else {
						break;
					}
				}
			}
		}
	}
	
	public void combineLeft() {
		 for (int i = 0; i < 4; i++) {
			 for( int j = 2; j >= 0; j--) {
				 if(board[i][j].equals("*") == false) {
					 if(board[i][j].equals(board[i][j+1]) == true) {
						 Integer num3 = Integer.parseInt(board[i][j]);
						 num3 = num3+num3;
						 board[i][j-1] = num3.toString();
						 board[i][j] = "*";
					 }
				 }
			 }
		 }
	}
	
	public void combineRight() {
		for(int k = 0; k <4; k++) {
			for(int l = 2; l > 0; l--) {
				if(board[k][l].equals("*") == false) {
			
				
					if(board[k][l].equals(board[k][l+1])) {
						Integer num = Integer.parseInt(board[k][l]);
						num = num + num;
						board[k][l+1] = num.toString();
						board[k][l] = "*";
					}
				}
			}
		}
	}

	public void shiftLeft() {
		for(int k = 0; k < 4; k++) {
			for(int l = 1; l < 4; l++) {
				if(board[k][l].equals("*")) {
					continue;
				}
				for(int a = l; a >= 1; a--) {
					if(board[l][a-1].equals("*")) {
						board[l][a-1] = board[l][a];
						board[l][a] = "*";
					}else {
						break;
					}
						
				}
			}
		}
	}
	//combining the integers going left
	public void combineleft() {
		for(int k = 0; k < 4; k++) {
			for(int l = 0; l < 3; l++) {
				if(board[k][l].equals("*")) {
					
				}
				else if(board[k][l].equals(board[k][l+1])) {
					Integer num = Integer.parseInt(board[k][l+1]);
					num = num + num;
					board[k][l+1] = num.toString();
					board[k][l] = "*";
				}else {
					break;
					
					}
				}
			}
		}
	
	public void moveup() {
		boolean moved = false;
		String[][] before = board;
		for(int k = 0; k < 4; k++) {
			for(int l = 0; l < 4; l++) {
				if(!board[k][l].equals("*")) {
					
					changePositionup(k,l);
					if(before.equals(board)) moved = true;
					System.out.println(moved);
				}else {
				}
			}
		}
		if(moved) validMoves++;
		add();
	}
	
	public void shiftUp() {
		
	}
	
	public void moveDown() {
		boolean moved = false;
		String[][] before = board;
		for(int k = 3; k > -1; k--) {
			for(int l = 0; l < 4; l++) {
				if(!board[k][l].equals("*")) {
					changePositionDown(k,l);
					if(before.equals(board)) moved = true;
				} else {
					changePositionDown(k,l);
					if(before.equals(board)) moved = true;
				}
			}
		}
		if(moved) validMoves++;
		add();
	
	}
	
	public void changePositionRight(int column, int rowPosition) {
		
		for(int i = 0; i < 4; i++) {
			for(int j = 3; j > 1; j --) {
				if(!board [i][j].equals("*")) {
					if(board[i][j-1].equals(board[i][j])) {
					}else {
						
						if(board[i][j-1].equals("*")) {
							if(!board[i][j-2].equals("*")) {
								
							}
						}
					}
				}
		}
		
		
		}
	}
	
	public void moveUp() {
		for(int i = 0; i < 4; i++) {
			for (int j = 3; j > -1; j --) {
				if(!board[i][j].equals("*")) {
					continue;
				}
					for (int k = j; k < 3; k++) {
						if(board[i][k+1].equals("*")) {
							//swap(board[i][k],board[i][k+1]);
							board[i][k+1] = board[i][k];
							board[i][k] = "*";
						}else {
							break;
						}
					
					
				}
			}
		}
		
		//combine
		for(int i = 0; i < 4; i++) {
			for(int j = 2; j >=0; j--) {
				if(!board[i][j].equals("*")) {
					if(board[i][j].equals(board[i][j+1])) {
						Integer temporary = Integer.parseInt(board[i][j+1]);
						temporary = temporary * 2;
						board[i][j+1] = temporary.toString();
						board[i][j] = "*";
						if(temporary > highestValue) highestValue = temporary;
						
					}
				}
			}
		}
		
		//second shift
		for(int i = 0; i < 4; i++) {
			for (int j = 3; j > -1; j--) {
				if(board[i][j].equals("*")) {
					continue;
				}
				for (int k = j; k < 3; k++) {
					if(board[k+1][i].equals("*")) {
						//swap(board[i][k],board[i][k+1]);
						board[k+1][i] = board[k][i];
						board[k][i] = "*";
					}else {
						break;
					}
				}	
			
			}
		}
		
		
		add();
		
	
	}
	
	public void shiftDown() {
		for(int i = 3; i > 0; i--) {
			for(int j = 2; j > -1; j--) {
				if(board[i][j].equals("*") != true) {
					for(int k = j; k < 3; k++) {
						if(board[k-1][i].equals("*") == true) {
							swap(board[k-1][i], board[k][i]);
						}
					}
				}
			}
		}
	}
	
	public void swap(String s1, String s2) {
		String temporary = s1;
		s1 = s2;
		s2 = temporary;
	}
	
	public void combineDown() {
		
	}

public void changePositionLeft(int column, int rowPosition) {
	
	for(int k = rowPosition -1; k > -1; --k) {
		if(!board[column][k].equals("*")) {
			if(board[column][k].equals(board[column][rowPosition])) {
				Integer num1 = Integer.parseInt(board[column][rowPosition]);
				num1 *= 2;
				board[column][k] = num1.toString();
				board[column][k+1] = "*";
				if(num1 > highestValue) highestValue = num1;
			} else {
				break;
			}
			}
		if(board[column][k].equals("*"));
		String temp = "*";
		board[column][k] = board[column][rowPosition];
		board[column][rowPosition] = temp;
		}
		}
		
		
	public void changePositionDown(int columnPosition, int row) {
		
		for(int k = columnPosition + 1; k < 4; k++) {
			if(!board[k][row].equals("*")) {
				if(board[k-1][row].equals(board[k][row])) {
					Integer num1 = Integer.parseInt(board[k][row]);
					num1 *= 2;
					board[k][row] = num1.toString();
					board[k-1][row] = "*";
					if(num1 > highestValue) highestValue = num1;
				}
				else 
				{
					break;
				}
			}
			
			if(board[k][row].equals("*")) {
				String temp = "*";
				board[k][row] = board[k-1][row];
				board[k-1][row] = temp;
				}
			}
	}
	
	public void changePositionup(int columnPosition, int row) {
		for(int k = columnPosition -1; k > -1; k--) {
			if(!board[k][row].equals("*")) {
				if(board[k+1][row].equals(board[k][row])) {
					Integer num1 = Integer.parseInt(board[k][row]);
					num1 *= 2;
					board[k][row] = num1.toString();
					board[k+1][row] = "*";
					if(num1 > highestValue) highestValue = num1;
				} else {
					break;
				}
			}
			
			if(board[k][row].equals("*")) {
				String temp = "*";
				board[k][row] = board[k+1][row];
				board[k = 1][row] = temp;
			}
		}
	}
	
	public void add() {
		int k = 0;
		int l = 0;
				boolean inserted = false;
		
		String[] newNumbers = {"2","2","2","2","2","2","2","2","4","4"};
		int added = random.nextInt(10);
		
				
			while(inserted == false) {
				k = random.nextInt(4);
				l = random.nextInt(4);
				if(board[k][l].equals("*")) {
					board[k][l] = newNumbers[added].toString();
					inserted = true;
				}
			}
	 }
	
	public void gameOver() {
		System.out.println("GAME OVER");
		System.out.println("Number of valid moves: " +validMoves);
		System.out.println("Highest number on the board: " +highestValue);
		
	}
	
	public void reset() {
		int board = random.nextInt(4);
		newBoard(board);
		
		print(this.board);
	}
}
