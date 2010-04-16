package edu.umd.cs.guitar.ripper;

import java.io.File;

import org.kohsuke.args4j.CmdLineException;

import edu.umd.cs.guitar.model.JFCConstants;

import junit.framework.TestCase;
/**
 * The JFCRipperTest class implements unit tests for the member
 * functions defined in the JFCRipper. There is nothing tangible in the
 * class to test so instead the execute parameter is run and the output 
 * generated is examined 
 */
public class JFCRipperTest extends TestCase {
	
	/**
	 * testNullExecute ensures a 72 byte XML output is generated by a blank configuration  to 
	 * */
	public void testNullExecute() {

		try{
			JFCRipper ripper = new JFCRipper(new JFCRipperConfiguration());
			ripper.execute();
			File a = new File(JFCRipperConfiguration.GUI_FILE);
			assertEquals(72,a.length());
		}catch(Exception e){
			e.printStackTrace();
			fail("Exception Occured");
		}	
	}
	/**
	 * testHelp ensures a CmdLineException is thrown when the CONFIG.help falg is set 
	 * */
	public void testHelp() {
		JFCRipper ripper = new JFCRipper(new JFCRipperConfiguration());
		boolean found = false;
		ripper.CONFIG.help=true;
		try{
			ripper.execute();
		}catch(Exception e){
			if (e instanceof CmdLineException){
				found= true;
				assertTrue(found);
			}
		}
		if (!found){
			fail("No Exception Occured");
		}
	}
	
	
	/**
	 * testOneWindow runs the program on the mock GUI OneWindow and ensures 1 object is found 
	 * in the GUI Structure 
	 * 
	 * */
	public void testOneWindow() {
		JFCRipperConfiguration config = new JFCRipperConfiguration();
		JFCRipperConfiguration.MAIN_CLASS="OneWindow";
		JFCRipper ripper = new JFCRipper(config);
		try{
			ripper.execute();
			//use lRippedWindowTitles rather than lRippedWindw which exists inside the monitor not ripper.
			assertEquals(1,ripper.ripper.lRippedWindowTitles.size());
		}catch(Exception e){
			fail("Exception Occured");
		}
		ripper=null;
	}
	/**
	 * testOneWindow runs the program on the mock GUI testOneWindow2 with a user defined configuration
	 * and ensures 2 objects are found in the GUI Structure 
	 * 
	 * NEW
	 * EDIT: Config_file was set to wrong location.
	 * 	     And Wrong Main_Class was being used.
	 * */
	public void testOneWindow2() {
		JFCRipperConfiguration config = new JFCRipperConfiguration();
		JFCRipperConfiguration.CONFIG_FILE="configuration.xml";
		JFCRipperConfiguration.MAIN_CLASS="OneWindow";
		
		JFCRipper ripper = new JFCRipper(config);
		try{
			ripper.execute();
			assertEquals(2,ripper.ripper.lComponentFilter.size());
		}catch(Exception e){
			fail("Exception Occured");
		}
		ripper=null;
	}
}