package d;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// Ryan Sweitzer
// 1/17/17
// The purpose of this assignment is to introduce 5 common errors in coding that will eventually print out to a file once fixed correctly.
public class Assignment1 {

	public static void main(String[] args) throws FileNotFoundException {
		secureFile();
		makeFile("filename2.txt"); // violating FIO50-J
		checkForTen(true, true);


	}
	// This code allows for subclasses to override the method which requires a security check, violates MET03-J
	public final static void secureFile(){
		try{
			SecurityManager secMan = System.getSecurityManager();
			if (secMan != null){
				secMan.checkRead("clearence.txt");
			}
		}catch (SecurityException secEx){

		}
	}
	// This code attempts to open a file to write to, violates FIO50-J
	// this code attempts to open a file to write to but is still in use, violates FIO14-J
	public static void makeFile(String name)
			throws FileNotFoundException{
		try (OutputStream fOut = new BufferedOutputStream(
				Files.newOutputStream(Paths.get(name), StandardOpenOption.CREATE_NEW))) {
				// Work with out
		} catch (IOException x) {
				System.out.println("Error");
		}
		Runtime.getRuntime().exit(1);
	}
	// This code incorrectly performs an assignment within the conditional expression, violates EXP51-J
	// loop need to iterate 10 times, violates MSC54-J
	public static String checkForTen(boolean x, boolean y){
		String output = "";
		for (int i = 1; i <= 10; i++){// violating MSC54-J
			if (x == y){
				output = "The equation itertates ten times";
				
			}
		}
		return output;
	}
}