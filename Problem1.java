// JK3466
//HOMEWORK3
// Problem1.java - This class test class instantiates a post-fix expression, 
	// and demonstrates the methods in ExpressionTree.java

public class Problem1 
{

	public static void main(String[] args) 
    {
    	 
    		String input = "34 2 - 5 *"; 
 
    		//create Tree object //
    		ExpressionTree MyTree = new ExpressionTree();
    		
    		// create Expression Tree from input // 
    		MyTree.ConstructTree(input);
    		
    		int evaluation = MyTree.eval(); 
    		String postfix = MyTree.postfix();
    		String prefix = MyTree.prefix(); 
    		String infix = MyTree.infix(); 
    	
    		// Print out values // 
    		System.out.println("When this tree is evaluated, the result is: "  + evaluation); 
    		System.out.println("   The postfix expression from the tree is: "  + postfix); 
    		System.out.println("    The prefix expression from the tree is: "  + prefix); 
    		System.out.println("     The infix expression from the tree is: "  + infix ); 
    		
    }
	
}
    
    	 	
   	 			
  

	 		 
	 		
	 	
	 	
	 

