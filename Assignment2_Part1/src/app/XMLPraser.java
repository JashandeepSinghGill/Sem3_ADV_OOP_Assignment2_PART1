/**
 * 
 */
package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 

/**
 * This class is XMLPraser that parses the xml code by taking the XML code and checking all the tags and to see if the are valid or not
 * 
 * @author JashanGill
 *
 */
public class XMLPraser {
	
	private Stack<String> stack;
	private String line;
	private String msg;
	
	
	public XMLPraser() throws FileNotFoundException{
		this.stack = new Stack<String>();
		this.line="";
		this.msg= "";
	}
	/**
	 * This method starts the Parser and moves the cursor to the Parser Method
	 * 
	 * @param filePath It takes in the path location of the XML file
	 * @throws FileNotFoundException	Error thrown if the file is not found
	 */
	public void start(String filePath) throws FileNotFoundException {
		
	//Calling the Parser method with the File Path as the variable
			Parser(filePath);
	}
	/**
	 * This method runs the file in a Scanner While Loop that would take every line of the file until the end.
	 * Then we convert the line to an array of strings and iterate over it to look for the '<' and '>' to identify the tags in XML
	 * 
	 * @param filePath	filePath It takes in the path location of the XML file
	 * @throws FileNotFoundException	Error thrown if the file is not found
	 */
	private void Parser(String filePath) throws FileNotFoundException {
		boolean openCheck = false;
		int bracketsCount = 0;
		String looseBrackets = "";
		String tag ="";
		int tagStart = 0, tagEnd = 0;
		
		File file = new File(filePath);
		Scanner in = new Scanner(file);
		
		while(in.hasNext()) {
			
			String line = in.nextLine();
			this.line = line;
			bracketsCount = 0;
			//converting the String line to char array named 'l'
			char[] l = line.toCharArray();
			
			//Loop to check for any Loose Brackets in the code
			for (int i = 0; i < l.length; i++) {
				if (l[i]=='<') {
					bracketsCount++;
				}
				if (l[i]=='>') {
					bracketsCount--;
				}
			}
			if(bracketsCount < 0) {
				 looseBrackets = "Loose Brackets found in line: \n"+ this.line+"\n";
			}
			
			for (int i = 0; i < l.length; i++) {
				if (l[i]=='<' && openCheck == false) {
					tagStart = i;
					openCheck = true;
				}
				if (l[i]=='>' && openCheck == true) {
					tagEnd = i; 
					
					tag = line.substring(tagStart+1, tagEnd);
					if(tag.equals("")) {
						continue;
					}
					TagValidator(tag);
					openCheck = false;
				}
			}
		}
		in.close();

		msg += "\n"+looseBrackets+"\n";
		while(this.stack.isEmpty() == false) {
			msg += "Closing Tag Missing For <"+ stack.pop()+">\n\n";
		}
		
		System.out.println(msg);
	}
	
	/**
	 * This method runs a check on each tag extracted by the Parser and checks if the tag is valid according to the syntax rules
	 * 
	 * @param tag	the Tag provided by the Parser without the brackets
	 */
	private void TagValidator(String tag){
		String tagName = tag.contains(" ")?tag.substring(0, tag.indexOf(" ")):tag;
		String openTag ="";
		String closeTag = "";
		int rootTagCount = 0;
		
		if(tagName.equals("root")) {
			rootTagCount++;
			}
		if(rootTagCount > 1) {
			msg += "Second root tag found at line:\n"+ this.line+"\n\n";
		}
		
				
		if(tag.contains("<") || tag.contains(">")) {
			msg += "Error in line:\n"+ this.line+"\n";
			msg += "Invalid Tag \n\n";
		}
		else if(tag.startsWith("?") && tag.endsWith("?")){
			msg += "Tag ignored at line:\n"+ this.line+"\n\n";
		}
		else if(tag.endsWith("/")){
			tag = tag.substring(0, tag.length() - 1);
			msg += "Self Closing Tag ignored at line:\n"+ this.line+"\n\n";
		}
		else if(tag.startsWith("/")){
			closeTag = tagName.substring(1);
			if (stack.peek().equals(closeTag)) {
				stack.pop();		
			}else {
				if(stack.search(closeTag) == 1) {
					while(!stack.peek().equals(closeTag)) {
						msg += "Closing Tag Missing For <"+ stack.pop()+">\n\n";	
						}
					stack.pop();
				}else {
				msg += "Error in line:\n"+ this.line+"\n    Not able to find  <"+closeTag+">\n\n";
				}
			}
		}
		else if(!tag.startsWith("/") && this.stack.search(tagName) == -1){
			openTag = tagName;
			stack.push(openTag);
		}
		else {
			msg = "Code Prased. No error Found";
		}
	}
}
