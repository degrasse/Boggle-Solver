import java.util.LinkedList;

public class TrieNode {
	// Instance Variable
	    char data; 
	    boolean isEnd; 
	    int count;  
	    // children List
	    // need to modify!
	    // you can implement this with arrayList or LinkedList or array
	    LinkedList<TrieNode> childrenList;
	   // TrieNode[] childrenList;

	    
	// Constructors
	    public TrieNode(char c){    
	        data = c;
	        isEnd = false;
	        count = 0;
	        childrenList = new LinkedList<TrieNode>(); //points to array 
	        // Modify: Initialize the children list
	    }  

	 // Methods
		/*
    	 * if the children list is not null
    	 * for each TrieNode in the children list
    	 * if you find a TrieNode that contains the char c
    	 * return the node
    	 * else return null
    	 * 
    	 */

	    
	    public TrieNode getChild(char c){
	    	   if(childrenList != null){
	    	      for( TrieNode child : childrenList){
	    	         if(child.data == c){
	    	         return child;
	    	         }
	    	      }
	    	   }
			return null;
	    	   
	    	}
}

