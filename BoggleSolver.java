import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
public class BoggleSolver {
	

	//board dimension = 4
	private static  int N =4;
	private  boolean[][] visited;
	private  char[][] gameBoard;
	private  TrieTree t;
	private static   int[][] path;
	
//	private  static int[] dx = {1,1,0,-1,-1,-1,0,1};
//	private  static int[] dy = {0,1,1,1,0,-1,-1,-1};
//	private int count;

	static ArrayList<String> foundWords = new ArrayList<String>();

	static ArrayList<Integer> x = new ArrayList<Integer>();
	static ArrayList<Integer> y = new ArrayList<Integer>();
	

/////////////////////////////////////////////////////////////////////////////////////	
	  public BoggleSolver(int N, TrieTree t, char[][] gameBoard) {
	        this.N  = N;
	        this.t = t;
	        visited = new boolean[N][N];
	        this.gameBoard = gameBoard;
	  }

	  public void getWords() {
		  
	        for (int i = 0; i < N; i++){
	            for (int j = 0; j < N; j++){
	                search("", i, j);

	            }
	        } 	
	    }

	    // run depth first search starting at cell (i, j)
	    private void search(String wrd, int i, int j) {
	    	 
	        if (i < 0 || j < 0 || i >= N || j >= N) return;

	        // can't visited a cell more than once
	        if (visited[i][j]) return;

	       // if (!t.startsWith(wrd))  return;
	        // now mark as visited
	        visited[i][j] = true;
	     
	        // found a word
	        wrd = wrd + gameBoard[i][j];
	        
	        if (t.search(wrd) && wrd.length() > 3) 
	        	
	            //System.out.println(wrd);
	        	if(!foundWords.contains(wrd)){
	        		foundWords.add(wrd);	
	        	}
	        
	        x.add(i);
    		y.add(j);
	     
	        // check neighbors
	        for (int dx = -1; dx <= 1; dx++)
	            for (int dy = -1; dy <= 1; dy++)
	            	
	                search(wrd, i + dx, j + dy);
	        		
	        visited[i][j] = false;
}

////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieTree t = new TrieTree();  
		
		// Step 1: Scan in the dictionary
		// Save words into a Trie
		File wordsEn = new File(args[0]);
		Scanner dictScanner;
		try {
			dictScanner = new Scanner(wordsEn);
			
			// MODIFY:
			// insert each work into the TrieTree t
			while (dictScanner.hasNextLine()){
			t.insert(dictScanner.nextLine());
			}
			dictScanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// Scan in the board
		// this scans the board and save it into 
		// a 2-D array called gameBoard
		// each line is saved into a String array
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
		
		System.out.println();
		
		//System.out.println(t.search("approximately"));
		BoggleSolver boggle = new BoggleSolver(N, t, gameBoard);
	       // System.out.println(boggle);
	        boggle.getWords();
		
	        for( int i=0; i < foundWords.size(); i++){
	        	System.out.println(foundWords.get(i));
	         	//print path 
		    	//for each word in found words
		    		//for the length of the ith word in found words
		    		System.out.println("path");
		    		for (int n = 0; n < foundWords.get(i).length(); n++){
		    			System.out.println("[" + x.get(n) + "]" + "[" + y.get(n) + "]");
		    			//x.remove(m);
		    			//y.remove(m);
		    			}
		    		
		    		for(int m =0; m < foundWords.get(i).length(); m++){
		    			x.remove(m);
		    			y.remove(m);
		    		}
	
	        }
	        
	}
}
