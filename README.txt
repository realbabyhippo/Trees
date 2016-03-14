
// README.txt

In this submission there are 4 classes files and 3 text files. 
The 4 class files are: 
	1) MyStack.java
	2) ExpressionTree.java
	3) Problem1.java
	4) Problem2.java
	5) AvlTree.java
	


You can compile all these files by typing in: <javac CLASSNAME.java> 
and you can run these files by typing in: < java CLASSNAME > 

Note that to correctly run Problem2.java you must type in <java Problem2 filename.txt> Furthermore, the filename.txt file must be in the same directory as the Problem2.java class file. 


fs28 MYSTACK.java 
fs24 
This generic class file constructs a stack made from a LinkedList. 
It includes:
	1) a push method to add items to a stack
	2) a pop method to remove items from a stack and return their values
	3) an isEmpty method to check whether a stack is empty or not.
 

Because this is a generic class, MyStack can be implemented on any type of object. 
It is used in the FindPalindromes class with Characters and it is used in the Program2 class with Strings. 


EXPRESSIONTREE.java

This class contains many parts:
	1)   A nested class called ExpressionNodes that constructs a TreeNode
	2)   A method that constructs an Expression Tree with a null root
	3)   A method that tests whether a string is either an operator or an operand. 
		 - Uses if-else for the two cases
		 - Returns a boolean true if the string is an operator
		 - Returns a boolean false if the string is an operand 
	4)  A method that constructs an Expression tree from a string of a simple math expression
		 - Splits the string by white space and creates an array of strings from these distinguished elements
		 - Checks to see if the string is an operand/operator
		 - If it'92s an operand, it creates a Node that is then pushed into a stack
		 - If it'92s an operator, it pops the first two numbers in the stack and makes them the children 
			of the parent operator node  
		 - updates the root of the tree
	5) A method that evaluates the expression held in the tree
		 - has a public method that calls upon a recursive private method 
		 - uses if/else with the base case being if the node is a leaf 
		 - uses Switch case with 4 cases for the 4 different possible operators 
		 - returns an integer 

	6)  A Method that derived a postfix expression from the tree
		-  has a public method that calls upon a recursive private method 
		- uses a StringBuilder to keep concatenating operands/operators to the same string 
		- returns a String of the expression
		- follows the paradigm of a postorder traversal

	7)  A Method that derived a prefix expression from the tree
		-  has a public method that calls upon a recursive private method 
		- uses a StringBuilder to keep concatenating operands/operators to the same string 
		- returns a String of the expression
		- follows the paradigm of a preorder traversal

	8)  A Method that derived an infix expression from the tree
		-  has a public method that calls upon a recursive private method 
		- uses a StringBuilder to keep concatenating operands/operators to the same string 
		- returns a String of the expression
		- follows the paradigm of a inorder traversal


fs28 PROBLEM1.java
fs24 
This tests the aforementioned methods in ExpressionTree. Creates an Expression Tree from an instantiated expression. 
Then it prints out the results of the four methods: tree evaluation, postfix expression, prefix expression, infix expression. 


fs28 AVLTREE.java 
fs24 
This class is primarily derived from the Weiss Code. However, some changes were implemented in order to gear the tree more towards our use. The class has various public methods that call upon private methods. The methods that were really modified include:

1) private insert: 
Added another else-if case that will add the LineNumber of a word to an ArrayList and a LinkedList if the word that has been already been inserted into the tree and the LineNumber has not been added to the ArrayList. The ArrayList is the list that is checked for the LineNumber, because it is easier to search through than a LinkedList. The ArrayList and the LinkList hold the same elements, but the elements of the ArrayList are more accessible. 

2) private static class AvlNode<AnyType>
This Node constructor has been modified to includes a LinkedList, ArrayList which store the LineNumbers. 

3) The public findMax and public findMin methods have been modified to no longer throw an UnderFlowException. 
Now, if the tree is empty, it prints an Error and exits the program. Because this change has been made, I don'92t have 
a UnderFlowException class in my homework directory, because it'92s not needed. 

	
PROGRAM2.java
This class creates a textFile from an inputFile that is read in by the Scanner object. It throws a cry/catch exception in case a file cannot be correctly read in. This tester class reads in the lines of a textfile, gets rid of punctuation, and makes all letters lower case. It creates an array of strings that are separated by whitespace, so each string is a word. It uses a for-loop and the insert method from the AvlTree class to insert words into the tree. It returns the final tree, which includes the words and a LinkList of the lines that contain these words. 















}
