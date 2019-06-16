import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BoggleSolver {
	

	//board dimension = 4
	private static int d =4;
	private static boolean[][] visited = new boolean[d][d];
	private static char[][] gameB;
	private static TrieTree tr;
	private  static int[][] path = new int[2][4];
	private  static int[] dx = {1,1,0,-1,-1,-1,0,1};
	private  static int[] dy = {0,1,1,1,0,-1,-1,-1};
	

	static ArrayList<String> foundWords = new ArrayList<String>();


	public BoggleSolver( TrieTree tr, char[][] gameB){
		 
		 this.tr = tr;
		 this.gameB = gameB;
		 visited = new boolean[d][d];
		 
		}
	private static void printpath( int[][] path, int count){
		System.out.println("Path: ");

		for(int i = 0; i < count; i ++){
			System.out.println("[" + path[0][i] + "," + path[1][i]);
		}
	}
	
public static  void isWord(char[][] board, TrieTree t){
	
		int m = board.length;
		int n = board[0].length;
		
	
		for(int i = 0; i < m; i++){
			for(int j = 0; j<n; j++){
				backtrack( " ", i, j);
				
			}
		}
		for (String w : foundWords){
			System.out.println(w);
		}
	}
	
	



	private static void backtrack(String wrd, int row , int col){
		//return if outside 
		wrd = "";
		
		if( row < 0 || row>=d || col<0 || col>=d){
			
			return;
			
		}

		//don't reuse if already visited 
		if (visited[row][col]==true){
			//System.out.println("hi2");
			return;
		}
		
		/*if(tr.search(wrd) != true){
			
			return;
		}*/
		
		//so if current position isn't outside and hasn't been visited
		//mark as visited
		visited[row][col] = true;

		//now add the current letter to the wrd 
		int count = wrd.length();
		wrd = wrd + gameB[row][col];
		count++;
		
		
		path[0][count] = row;
		path[1][count] = col;
		
		
			//check if in dictionary
			if( tr.search(wrd) == true && wrd.length() >3){
				foundWords.add(wrd);
				//System.out.println(wrd);
				//printpath(path, count);
			
				
			}
			
			for (int i = -1; i <= 1; i++){
		        for (int j = -1; j <= 1; j++){
		           backtrack(wrd, row + i, col + j);
					visited[row][col] = false;
					
		        }
		        }
				
				
			
	}



	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieTree t = new TrieTree();  
		
		// Step 1: Scan in the dictionary
		// 			Save words into a Trie
		File wordsEn = new File(args[0]);
		Scanner dictScanner;
		try {
			dictScanner = new Scanner(wordsEn);
			
			// MODIFY:
			// insert each work into the TrieTree t
			t.insert(dictScanner.nextLine());
			
			dictScanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// Step 2: Scan in the board
		// DO NOT NEED TO MODIFY
		// this scans the board and save it into 
		// a 2-D array called gameBoard
		// each line is saved into a String array
		// 
		
		File board = new File(args[1]);
		Scanner bScanner;
		// A game board of 4 by 4
		char[][] gameBoard = new char[4][4];
		// 
		String[] line = new String[4];
		
		int count = 0;
		try {
			bScanner = new Scanner(board);
			while (bScanner.hasNextLine()) {
				line[count] = bScanner.nextLine();
				count++;
			}
			bScanner.close();
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					gameBoard[x][y] = line[x].charAt(y);
					System.out.print(gameBoard[x][y]);
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		

		TrieTree test = new TrieTree(); 
		test.insert("hi");
		test.insert("hey");
		test.insert("hello");
		
		System.out.println(test.search("hey"));
		
	
		
	BoggleSolver boggle = new BoggleSolver(t, gameBoard);
				
	isWord(gameBoard, t);
				 
		
		
	
		
		
		// example:
		// s b w r
		// t o m e
		// v n n p
		// p e q l
				
		// Let's say a valid word is bone. You can print the result in different ways.
		
		// Example 1:
		// Bone is found from the board. Path: [0,1] -> [1,1] -> [2,1] -> [3,1]
		
		// Example 2:\96a333333333333																																																																																																																																																																																												`
		// Word found:
		// * b * *
		// * o * *
		// * n * *      
		// * e * *  
	}
	
	

	}

