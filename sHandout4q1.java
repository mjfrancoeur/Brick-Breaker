
import acm.program.*;

public class sHandout4q1 extends ConsoleProgram{
	public void run() {
		while (true) {
			 String digits = readLine("Enter a numeric string: ");
			 if (digits.length() == 0) break;
			 println(altMethod(digits));
		}
	}
	
	private String addCommasToNumericString(String str) {
		String newString = "";
		if(str.length() < 3) {
			return(str);
		} else {
				int remainder = str.length() % 3;
					if(remainder != 0) {
						newString = str.substring(0, remainder) + ",";
					}
				while(true) {
					if(remainder + 3 >= str.length()) {
						newString += str.substring(remainder);
						break;
					} else {
						for(int i = remainder + 3; i <str.length(); i =i + 3) {
							newString = newString + str.substring(remainder, i) + ",";
							remainder = i;
						} 	
					}	
				}	
				return(newString);			
	}
	}
	
	private String altMethod(String str) {
		String result = "";
		int nDigits = 0;
		for(int i = str.length() - 1; i >= 0; i--) {
			result = str.charAt(i) + result;
			nDigits++;
			if((nDigits % 3 == 0) && (i > 0)) {
			result = "," + result;	
			}
		} return result;
	}
	
}
