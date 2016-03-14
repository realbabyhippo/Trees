
//**AVLTreeTester.java - This class reads through a file and then indexes the words and created an AVL tree and 
		// keeps track of every line the word has occurred on 

import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

public class AVLTreeTester{

	public static void main(String[] args) throws FileNotFoundException 
	{
		try 
		{
			//creates an AVL Tree
			AvlTree<String> tree = new AvlTree<String>();
	
			// creates File and Scanner objects from text file
			File textFile = new File(args[0]); // create new File
			Scanner readFile = new Scanner(textFile); // instantiate the Scanner 
			
			//instantiates line number
			int lineNumber = 0;
	
			while(readFile.hasNext())
			{
				//increments the line number for the word
				lineNumber++; 
			
				String TextLine = readFile.nextLine();
					
				// gets rid of punctuation and makes it all lowercase // 
				TextLine = TextLine.replaceAll("[^a-zA-Z ]", "").toLowerCase();  
				
				//splits the line into words by using a space as the delimiter 
				String[] parts = TextLine.split(" ");
				
				// for loop that will go through the line // 
				for(int i = 0 ; i < parts.length ; i++)
				{
					tree.insert(parts[i] , lineNumber);
				}
			
			}
			//prints tree in alphabetic order
			tree.printTree();
			
			readFile.close(); // close scanner 
		
		} // close try 	
		
		catch(Exception FileNotFoundException) 
		{
		            System.out.println("I/O error.");
		}
	
	} // close main method
		
} // close class 

