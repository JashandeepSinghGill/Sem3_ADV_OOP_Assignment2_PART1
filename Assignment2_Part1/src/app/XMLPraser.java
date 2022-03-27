/**
 * 
 */
package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 

/**
 * @author JashanGill
 *
 */
public class XMLPraser {
	/*The case not solved : 
	 * 	<p><p></p>
	 */
	private Stack<String> stack;
	private String line;
	private String msg;
	
	
	public XMLPraser() throws FileNotFoundException{
		this.stack = new Stack<String>();
		this.line="";
		this.msg= "";
	}
	
	public void start(String filePath) throws FileNotFoundException {
		
	//Calling the Parser method with the File Path as the variable
			Parser(filePath);
	}

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
			char[] l = line.toCharArray();
			
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
					tagStart = i+1;
					openCheck = true;
				}
				if (l[i]=='>' && openCheck == true) {
					tagEnd = i; 
					
					tag = line.substring(tagStart, tagEnd);
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
	
	
	private void TagValidator(String tag) throws FileNotFoundException {
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
