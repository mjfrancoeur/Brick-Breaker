
import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class sectionhandout5q1 extends ConsoleProgram{
	public void run() {
		BufferedReader rd = openFile("Please enter file name: ");
		int countLines = 0;
		int countWords = 0;
		int countChars = 0;
		
		try {
			while(true) {
				String line = rd.readLine();
				if(line == null) {
					break;
				}
				countLines++;
				countChars += line.length();
				StringTokenizer tokenizer = new StringTokenizer(line);
				while(tokenizer.hasMoreTokens()) {
					String temp = tokenizer.nextToken();
					countWords++;	
				}
			} rd.close();
		} catch(IOException ex) {
			println("Sorry sir. Can't open that file");
		}
		println(countLines);
		println(countWords);
		println(countChars);
		
	}
	
	private BufferedReader openFile(String prompt) {
		BufferedReader rd = null;
		while(rd == null) {
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));
			} catch(IOException ex) {
				println("Can't open that file. Sorry, sir.");
			}		
		} return rd;
	}


}



