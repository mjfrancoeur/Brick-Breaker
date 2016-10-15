import acm.program.*;

public class sHandout4q2 extends ConsoleProgram {
	public void run() {
		removeAllOccurrences("Summer is here", 'e');
	}
	                   
	private void removeAllOccurrences(String str, char ch) {
		while(true) {
			int index = str.indexOf(ch);
			if(index == -1) {
				break;
			} else {
				str = str.substring(0, index) + str.substring(index + 1);
			}
		}
		println(str);
	}
}
