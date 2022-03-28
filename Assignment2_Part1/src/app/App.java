/**
 * 
 */
package app;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author JashanGill
 *
 */
public class App {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Welcome, This is XML Parser.");
		System.out.println("Enter file Path: ");
		
//		//Creating the Scanner Class to Fetch The XML File path from user
//		Scanner sc = new Scanner(System.in);
//		String filePath = sc.nextLine();
//		sc.close();
		
		XMLPraser praser = new XMLPraser();
		praser.start("./res/test1.xml");
		//praser.start(filePath);
	}
}
