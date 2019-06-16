
public class TrieTree {
	
	public TrieNode root;
	 
    // Constructor
	
   public TrieTree(){
	// construct a empty tree
	   root = new TrieNode(' ');
   }
   
   public void insert(String word){
	 /*  if (search(word)==true){
		   return;
	   }*/
	  TrieNode current = root;
	  for (char c : word.toCharArray()){
		  TrieNode child = current.getChild(c);
		  if(child != null){
			  current = child;
		  }
		  else{
			  TrieNode temp = new TrieNode(c);
			  current.childrenList.add(temp);
			  current = current.getChild(c);
			  //current = temp;
		  }
		  current.count++;
	  }
	  current.isEnd = true;	
	   
   }



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


   //Returns if there is any word in the tri
   // that starts with the given prefix.
   public boolean startsWith(String prefix) {
       TrieNode p = searchNode(prefix);
       if(p==null){
           return false;
       }else{
           return true;
       }
   }

   public TrieNode searchNode(String s){
       TrieNode p = root;
       for(int i=0; i<s.length(); i++){
           char c= s.charAt(i);
           int index = c-'a';
           if(p.childrenList.get(index)!=null){
               p = p.childrenList.get(index);
           }else{
               return null;
           }
       }

       if(p==root)
           return null;

       return p;
   }
}
   

   
   
   
   
   
   
   
   
   
   
   
   
   

   
  