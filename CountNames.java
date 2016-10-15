/*
* File: CountNames.java
* ---------------------
* This program shows an example of using a HashMap. It reads a
* list of names from the user and list out how many times each name
* appeared in the list.
*/


import acm.program.*;
import java.util.*;

public class CountNames extends ConsoleProgram{

	public void run() {
		  addNames();
		  printNames();
		}


		/*
		* Reads a list of names from the user, storing names and how many
		* times each appeared in the map that is passed in as a parameter.
		*/

		private void addNames() {
			int count;
			while(true) {
		    String name = readLine("Enter a name: ");
		    if(name.equals("")){
		      break;
		    } else if(nameCounts.containsKey(name)) {
		      count = nameCounts.get(name) + 1;
		    } else {
					count = 1;
		    }
				nameCounts.put(name, count);
		  }
		}

		private void printNames() {
		  Iterator<String> it = nameCounts.keySet().iterator();
		  while(it.hasNext()) {
		    String name = it.next();
		    Integer count = nameCounts.get(name);
		    println("Entry [" + name + "] has count " + count);
		  }
		}


/*alternate method to print out the HashMap, using a for loop */
		private void alternatePrintNames() {
		  for(String name : nameCounts.keySet()) {
		    Integer count = nameCounts.get(name);
		    println("Entry [" + name + "] has count " + count);
		  }

		}


		/* instance variables */
		private HashMap<String, Integer> nameCounts = new HashMap<String, Integer>();

	}
