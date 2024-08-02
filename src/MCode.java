/**
 * 
 * Class for Morse Code Encryption with all English Characters and Numbers
 * @author sbodd
 *
 */
public class MCode {
	
	// For testing
	public static void main(String[] args) {
		System.out.println(encode("the quick brown fox jumps over the lazy dog"));

	}
	
	public static String encode(String text) {
		text = text.toLowerCase(); text.trim(); 
		boolean flag = true;
		String code = "";
		for (int i = 0; i < text.length(); i++) {
			if (flag && text.charAt(i) != ' ') {
				code += "—";
			}
			flag = true;
			switch (text.charAt(i)) {
				case 'a':
					code += ".—"; break;
				case 'b':
					code += "—..."; break;
				case 'c':
					code += "—.—."; break;
				case 'd':
					code += "—.."; break;
				case 'e':
					code += "."; break;
				case 'f':
					code += "..—."; break;
				case 'g':
					code += "——."; break;
				case 'h':
					code += "...."; break;
				case 'i':
					code += ".."; break;
				case 'j':
					code += ".———"; break;
				case 'k':
					code += "—.—"; break;
				case 'l':
					code += ".—.."; break;
				case 'm':
					code += "——"; break;
				case 'n':
					code += "—."; break;
				case 'o':
					code += "———"; break;
				case 'p':
					code += ".——."; break;
				case 'q':
					code += "——.—"; break;
				case 'r':
					code += ".—."; break;
				case 's':
					code += "..."; break;
				case 't':
					code += "—"; break;
				case 'u':
					code += "..—"; break;
				case 'v':
					code += "...—"; break;
				case 'w':
					code += ".——"; break;
				case 'x':
					code += "—..—"; break;
				case 'y':
					code += "—.——"; break;
				case 'z':
					code += "——.."; break;
				case '1':
					code += ".————"; break;
				case '2':
					code += "..———"; break;
				case '3':
					code += "...——"; break;
				case '4':
					code += "....—"; break;
				case '5':
					code += "....."; break;
				case '6':
					code += "—...."; break;
				case '7':
					code += "——..."; break;
				case '8':
					code += "———.."; break;
				case '9':
					code += "————."; break;
				case '0':
					code += "—————"; break;
				case ' ':
					code += "——."; flag = false;
			}
		}
		return code;
	}

}
