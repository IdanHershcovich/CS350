
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 */
public class TextInput extends Input {

	/**
	 Implementation of Input class for "Text" data 
	 */
	private static final long serialVersionUID = -5850597247986864822L;

	/**
	 * 
	 */
	public TextInput() {
		// TODO implement here
	}

	//Gets string from the console
	public String getUserInputString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
	}
	//Gets an int from console. catches any other type of input
	public int getInputInt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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