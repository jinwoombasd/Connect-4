/********************************************
Program: Main
Author: Jinwoo Park
Contact: jinwoo.park@my.uwrf.edu
Date: 11-21-2022
Modified: 11-30-2022

Description:
This program runs connect 4 game which 2 players can play.
*********************************************/    

import java.util.*;
class Main {
  public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);

		  char[][] board = new char[6][7];

      int turn = 1;
		  char player = 'R';
	    boolean winner = false;	
      String Player = "Red"; 
   
		//make board array
		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[0].length; col++){
				board[row][col] = ' ';
			}
		}
    
		//make player's turn
		while (winner == false && turn <= 42){
			 boolean Play;
			 int play;
			 do {
				game(board);
				
				System.out.print("Drop a " + Player + " disk " + ", choose a column(1-7): ");
				play = scanner.nextInt()-1;
				
				Play = valid(play,board);
				
			}while (Play == false);
      
			//drop the checker
		for (int row = board.length-1; row >= 0; row--){
				if(board[row][play] == ' '){
					board[row][play] = player;
					break;
				}
			}
			
			//determine winner
			winner = Winner(player,board);
			
			//switch players
		if (player == 'R') {
      player = 'Y';
      Player = "Yellow";
      } else {
      player = 'R';
      Player = "Red";
      } turn++;
    }
    
		game(board);

    //print out winner
		if (winner){
			if (player == 'R'){
				System.out.println("Yellow won!");
			}else{
				System.out.println("Red won!");
			}
		}else{
			System.out.println("Draw!");
		}
		
	}

  //design game board
	public static void game(char[][] board){
		System.out.println(" 1 2 3 4 5 6 7");
		for (int row = 0; row < board.length; row++){
			System.out.print("|");
			for (int col = 0; col < board[0].length; col++){
				System.out.print(board[row][col]);
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println(" 1 2 3 4 5 6 7");
		System.out.println();
	}
	
	public static boolean valid(int column, char[][] board){
		//determine valid column
		if (column < 0 || column > board[0].length){
			return false;
		}
		
		//determine full column
		if (board[0][column] != ' '){
			return false;
		}
		
		return true;
	}
	
	public static boolean Winner(char player, char[][] board){
    
		//check for vertical win
		for (int row = 0; row < board.length - 3; row++){
			for (int col = 0; col < board[0].length; col++){
				if (board[row][col] == player && board[row + 1][col] == player && 
            board[row + 2][col] == player && board[row + 3][col] == player){
					return true;
				}
			}
		}
    
     //check for horizontal win
		for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == player && board[row][col + 1] == player && 
            board[row][col + 2] == player && board[row][col + 3] == player){
					return true;
				}
			}
		}
		
		
		//check for diagonal win
		for (int row = 0; row < board.length - 3; row++){
			for (int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == player && board[row + 1][col + 1] == player && 
            board[row + 2][col + 2] == player && board[row + 3][col + 3] == player){
					return true;
				}
			}
		}
		
		//check for diagonal win
		for (int row = board.length - 1; row > 2; row--){
			for (int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == player && board[row - 1][col + 1] == player && 
            board[row - 2][col + 2] == player && board[row - 3][col + 3] == player){
					return true;
				}
			}
		}
		return false;
	}
}