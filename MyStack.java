
//MyStack.java - a generic stack class derived from a Linkedlist 

public class MyStack<E>
// E is the generic parameter
{

	Node top; //initializes the top element of the stack 
	
	//defines node of stack 	
	class Node
    	{
		E value; //value of each node
      	Node next;  //pointer to next node
       
      			public Node(E value) // construct the node object 
			{
        			this.value =value;  //initializing the value to recognized in the node a
         			next=null; // set the next node as null 
       			}
    	}

	//This function pushes new element into the list 
    	public void push(E value)
    	{
     		Node current = new Node(value); // creates node "current"
 
     		if(isEmpty()) // if there is an empty stack     								
        	{
     			top= current; // fill the fist node with the the new value
     		}

    		else // if not starting with an empty list
    		{	
       			current.next=top; // set the next node as the new top of stack 
        		top=current; // fill this new empty top with desired value
     		}
    	}
    
    	//This function pops the topmost element
    	public E pop()
    	{
    		E value = null; // initialize the value of E as null 
    		if (!isEmpty())
    		{
			value= top.value; // initializes value as the value of the top of the stack // 
    			top=top.next; // sets the next node in the stack to be the top of the stack // 
    		}
    		return value; // returns the popped value 
    	}
   
    
   	
	 //This function checks if a stack is empty
    	public boolean isEmpty()
    	{
        	return (top==null); 
    	}	    
    
}
    
    
    
    
    





