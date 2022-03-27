/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.XMLPraser;

/**
 * @author JashanGill
 *
 */
class XMLPraserTests {

	private XMLPraser praser;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		praser = new XMLPraser();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		praser = null;
	}

	/**
	 * Test method for {@link app.XMLPraser#start()}.
	 * @throws FileNotFoundException 
	 */
	@Test
	void sameLineTagTest() throws FileNotFoundException {
		System.out.println("Test:    sameLineTagTest");
		praser.start("./res/test1.xml");
	}
	
//	@Test
//	void diffLineTagTest() throws FileNotFoundException {
//		System.out.println("Test:    diffLineTagTest");
//		praser.start("./res/test2.xml");
//	}
//	
//	@Test
//	void tagWithinTagTest() throws FileNotFoundException {
//		System.out.println("Test:    tagWithinTagTest");
//		praser.start("./res/test3.xml");
//	}
//	
//	@Test
//	void IgnoredTagTest() throws FileNotFoundException {
//		System.out.println("Test:    IgnoredTagTest");
//		praser.start("./res/test4.xml");
//	}
//	@Test
//	void twoRootTagTest() throws FileNotFoundException {
//		System.out.println("Test:    twoRootTagTest");
//		praser.start("./res/test5.xml");
//	}
//	
//	@Test
//	void SelfClosingTagTest() throws FileNotFoundException {
//		System.out.println("Test:    SelfClosingTagTest");
//		praser.start("./res/test6.xml");
//	}
//	
//	@Test
//	void noClosingTagTest() throws FileNotFoundException {
//		System.out.println("Test:    noClosingTagTest");
//		praser.start("./res/test7.xml");
//	}
//	
//	@Test
//	void noOpeningTagTest() throws FileNotFoundException {
//		System.out.println("Test:    noOpeningTagTest");
//		praser.start("./res/test8.xml");
//	}

}
