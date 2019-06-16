
public class TrieTree {
	
	public TrieNode root;
	 
    // Constructor
	
   public TrieTree(){
	// construct a empty tree
	   root = new TrieNode(' ');
   }
   
   public void insert(String word){
	   if (search(word)==true){
		   return;
	   }
	  TrieNode current = root;
	  for (char c : word.toCharArray()){
		  TrieNode child = current.getChild(c);
		  if(child != null){
			  current = child;
		  }
		  else{
			  current.childrenList.add(new TrieNode(c));
			  current = current.getChild(c);
		  }
		  current.count++;
	  }
	  current.isEnd = true;	
	   
   }
   
   
   
   
   
   
   
   
   
   
   
   
 /*  
   public void insert(String word)
   {
       int level;
       int length = word.length();
       int index;
     
       TrieNode currentNode = root;
     
       for (level = 0; level < length; level++)
       {
           index = word.charAt(level) - 'a';
           if (currentNode.childrenList[index] == null)
               currentNode.childrenList[index] = new TrieNode(word.charAt(index));
     
           currentNode = currentNode.childrenList[index];
       }
     
       // mark last node as leaf
       currentNode.isEnd = true;
   }*/
     
   // Returns true ifword presents in trie, else false
/*  public boolean search(String word)
  
  
  
   {
       int level;
       int length =word.length();
       int index;
       TrieNode currentNode = root;
     
       for (level = 0; level < length; level++)
       {
           index =word.charAt(level) - 'a';
     
           if (currentNode.childrenList[index] == null)
               return false;
     
           currentNode = currentNode.childrenList[index];
       }
     
       return (currentNode != null && currentNode.isEnd);
   }*/
     

   public boolean search( String word){
	   
	   TrieNode current = root;
	   for( char ch : word.toCharArray()){
	      if (current.getChild(ch) == null)
	      return false;
	      
	      else
	      current = current.getChild(ch);
	      
	   }
	   if (current.isEnd == true)
	      return true;
	      
	    return false;
	   }


	
   
   

  
   
   /*public void insert( String word){
		if(word.isEmpty()){
	        root.isEnd = true;
	        return;	
			}
		
		int l = word.length();
	char letter = word.charAt(0);
	int i = letter - 'a';

		if( root.childrenList[i]== null){
			root.childrenList[i] = new TrieNode(word.charAt(i));
		}
		//root.childrenList[index]
		insert(word.substring(1));
		root.count++;
	}

	





	//like insert
	  public boolean search(String word){
	  	if(word.isEmpty()){
	  		return  root.isEnd;
	  	}

	//travers and keep track of index
	  	char letter = word.charAt(0);
	  	int i = letter - 'a';

	  	if(root.childrenList == null){
	  		return false;
	  	}
	  	return search(word.substring(1));
	  }
*/

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   /*
   
   // Insert
   public void insert(String word){
	   
	   if(word.isEmpty()){
		   root.isEnd = true;
		   return;
	   }
	   
	  TrieNode currentNode = root;
	 
		 for ( char i : word.toCharArray()) {
			 
			 TrieNode child = currentNode.getChild(i);
			 
			 if( child != null){
				 currentNode = child;
			 }
			 else{
				 currentNode.childrenList[i] = child;
				 currentNode = currentNode.childrenList[i]; 
			 }
			 currentNode.count++;
		 }
		 
		 currentNode.isEnd = true;
		  
	  }
*/
   
   // search
//   public boolean search(String word){
//	   
//	   TrieNode currentNode = this.root;
//	   
//	   for ( char i : word.toCharArray()){
//		   
////		   if( currentNode.childrenList[i] == null){
////			   return false;
////		   }
//		   if(currentNode.childrenList[i] != null){
//			   currentNode = currentNode.childrenList[i];
//				   
//			   }
//		   if( currentNode.isEnd == true){
//			   return true;
//		   }
//		   
//	   }
//	   
//	   return false;
//   }
   
   
   
   
   
   
   
   // remove
  /* public void remove(String word){
	   
	   
	   if (search(word) == false){
		   
		   System.out.println(word + "is not present" );
	   }
	  
	   TrieNode currentNode = root;
	   
		   for( char i : word.toCharArray()){
			   
			   TrieNode child = currentNode.getChild(i);
			   
			   if ( child.count == 1){
				   currentNode.childrenList[i] = null;
			   }
			   else{
				   currentNode.count++;
				   currentNode = child;
			   }
			   
		   }

		  currentNode.isEnd = false;
}*/
}
