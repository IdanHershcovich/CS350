
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */
public class TextInput extends Input {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5850597247986864822L;

	/**
	 * 
	 */
	public TextInput() {
		// TODO implement here
	}

	/**
	 * @param random
	 * @return
	 */
	public String getUserInputString() {
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
	}
	
	public int getInputInt() {
		while(true) {
		try {
			return Integer.parseInt(br.readLine());

		} 
		catch(Exception e) {
			System.out.println("Your input did not match any of the choices! Please try again");

		}
		}
	}


}