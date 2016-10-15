
import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class sectionHandout5q2 extends ConsoleProgram {
	public void run() {
		BufferedReader rd = openFile("enter the file you want to open: ");
		int[] scoreArray = new int[11];	
		
		try{
			while(true) {
				String line = rd.readLine();
				if(line == null) {
					break;
				}
				int score = Integer.parseInt(line);
				if(score < 0 || score > 100) {
					throw new ErrorException("That score is out of range");
				} else {
					int range = score / 100;
					scoreArray[range]++;
				}
			}
			rd.close();
			
		} catch(IOException ex) {
			println("I'm sorry, cannot open this file.");
		}
		
	}
	
	private BufferedReader openFile(String prompt) {
		BufferedReader rd = null;
		while(rd == null) {
			try{
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));			
			} catch(IOException ex) {
				println("I'm sorry, cannot open this file.");
			}
		}
		return rd;
	}
	
}
