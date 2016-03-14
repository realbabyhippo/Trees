
//**ExpressionTree.java - This class will construct a Node, ExpressionTree and includes 4 methods to invoke on an Expression Tree

public class ExpressionTree
{	
		//** nested class creates ExpressionNodes **//
		public class ExpressionNodes
	    {
	        //** initializes instance variables **//
	        String data;
	        ExpressionNodes left;
	        ExpressionNodes right;
	
	        //** constructor for the Tree Node **//
	        public ExpressionNodes(String data)
	        {
	            this.data = data;
	            this.left = null;
	            this.right = null;
	        }
	        
	        //**recursive constructor**//
	        public ExpressionNodes(String data, ExpressionNodes left, ExpressionNodes right)
	        {
	        	this.data = data;
	        	this.left = left;
	        	this.right = right; 
	        }
	    }  
		
		private ExpressionNodes root; // initializes root node
		
		//**constructs Expression Tree object**// 
		public ExpressionTree()
		{
	       root = null;
		}

		//**method checks to see if a character is an operator or operand**// 
		private static boolean isOperator(String c)
		{	
			if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") ) 
			{
				return true;
			}
			
			else
			{
				return false;
			}
		}
	
		
		//**Constructs Tree **//	
	    void ConstructTree(String input) 
	    {	
	    	 MyStack<ExpressionNodes> stack1 = new MyStack<ExpressionNodes>();
	
	         ExpressionNodes t;
	         ExpressionNodes t1;
	         ExpressionNodes t2;
	
	         // ** Creates an Array of Strings. Each string is distinguished by white space ** //
	         String[] splitInput = input.split(" "); 
	         
	         //** Traverse through every character of splitInput String**//
	         for (int i = 0; i < splitInput.length; i++) 
	         {
	        	 //** checks to see if the string is an operand, if so, pushes operand into stack1 **//
	             if (isOperator(splitInput[i]) == false)
	             {
	                 t = new ExpressionNodes(splitInput[i]); //creates Node from operand
	                 stack1.push(t); // pushes Node into stack1 create a tree of just the operand
	             } 
	                    
	           
	            //** if char is operator, pop two trees **//
	            else
	            {
	                t = new ExpressionNodes(splitInput[i]); // creates Node from operator
	 
	                //** Pop first two operands in the stack **// 
	                t1 = stack1.pop();  // pop the top of the stack1 //  
	                t2 = stack1.pop();	// pop the next node in stack1 //
	 
	                //** make the first top two nodes just popped into children nodes **//
	                t.right = t1;
	                t.left = t2;
	 
	                stack1.push(t); // push the new tree with operator root and operand children into stack1
	                
	                
	            } 
	           
	         } // close for loop
	         
	            root = stack1.pop(); // set root = this top node
	    
	 
	    } // close ConstructTree
	        
	     
	   
		//** public method will call a recursive helper method to return the integer element of input postfix expression** 
	    public int eval() 
	    {   
	    	return eval(root);
	    }
	    
	    private int eval(ExpressionNodes root)
	    {
	    	// if the node is a leaf node // 
	    	if (root.right == null && root.left == null) 
	    	{
	    			int leaf = Integer.parseInt(root.data);
	    			return leaf; 
	    	}
	    	
	    	// if the node is an operator // 
	    	else 
	    	{
	    			int op1 = eval(root.left);  
	    			int op2 = eval(root.right);
	  
	    	
			    	String operator = root.data; // initialize operator string 
			    	int n = 0; // initialize the integer that will be returned 
			    	
			    	// switch case to conduct for the different operators 
			    	switch(operator) 
			    	{
				        case "+":
				        	n = op1 + op2; 
				        	break;
				        	
				        case "-":
				            n = op1 - op2; 
				            break;
				            
				        case "*":
				            n = op1 * op2; 
				            break;
				            
				        case "/":
				            n = op1 / op2; 
				            break;
			    	}
			    	
			    	return n; 
	    	}
			
	    }
				
	    // ** public method that will call the private recursive prefix method **//
	    public String postfix()
	    {
	    	// create an empty string builder // 
	    	StringBuilder sb = new StringBuilder();
	    	
	    	// fill the string builder//
	    	postfix(root, sb);
	    	
	    	return sb.toString().trim();
	    }
	    
	    // ** recursive method that will create a postfix expression ** // 
	    private void postfix(ExpressionNodes root, StringBuilder sb)
	    {
	    	if (root.left != null) // if there is a left child
	    	{ 
	    		postfix(root.left, sb); // run recursive method
	    	}
	    	
	    	if (root.right != null)  // if there is a right child
	    	{ 
	    		postfix(root.right, sb); // run recursive method 
	    	}
	    	
	    	// add the string of this node to the the string builder 
	    	sb.append(root.data);
	    	
	    	// add a space in between nodes for clarity.
	    	sb.append(" ");
	    }
	
	    // ** public method that will call the private recursive prefix method **//
	    public String prefix()
	    {
	    	// create an empty string builder // 
	    	StringBuilder sb = new StringBuilder();
	    	
	    	// fill the string builder//
	    	prefix(root, sb);
	    	
	    	return sb.toString().trim();
	    }
	    	
	    
	    // ** recursive method that will create a prefix expression ** // 
	    private void prefix(ExpressionNodes root, StringBuilder sb)
	    {
	    	
	    	// add the string of this node to the the string builder 
	    	sb.append(root.data);
	    	
	    	// add a space in between nodes for clarity.
	    	sb.append(" ");
	    	
	    	if (root.left != null) // if there is a left child
	    	{ 
	    		prefix(root.left, sb); // run recursive method 
	    	}
	    	
	    	if (root.right != null) // if there is a right child
	    	{ 
	    		prefix(root.right, sb);  // run recursive method 
	    	}
	    	
	    }
	    

	    // ** public method that will call the private recursive infix method **//
	    public String infix()
	    {
	    	// create an empty string builder // 
	    	StringBuilder sb = new StringBuilder();
	    	
	    	// fill the string builder//
	    	infix(root, sb);
	    	
	    	return sb.toString().trim();
	    }
	    	
	    
	    // ** recursive method that will create a prefix expression ** // 
	    private void infix(ExpressionNodes root, StringBuilder sb)
	    {	
	    	
	    	if (root.left != null) // if there is a left child
	    	{ 
	    		infix(root.left, sb); // run recursive method 
	    	}
	    	
	    	// add the string of this node to the the string builder 
	    	sb.append(root.data);
	    	
	    	// add a space in between nodes for clarity.
	    	sb.append(" ");
	    	
	    	
	    	if (root.right != null) // if there is a right child
	    	{ 
	    		infix(root.right, sb);  // run recursive method 
	    	}
	    	
	    }
	    
	     
	}
	    	
	      	
	
		
	

