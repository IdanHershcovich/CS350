
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Input implements java.io.Serializable {

	/**
	 * 
	 * abstract Input class. Methods for getting strings and ints and checking
	  if the input matches the type.
	 * Uses bufferedReader for the console input
	 */
	private static final long serialVersionUID = -7701867319609541357L;

	public Input() {
	}

	public String getUserInputString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	public int getInputInt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				return Integer.parseInt(br.readLine());

			} catch (Exception e) {
			}
		}
	}

//	public ResponseCorrectAnswer getUserInputRCA() throws IOException {
//		ResponseCorrectAnswer RCA = new ResponseCorrectAnswer();
//		ArrayList<String> list = new ArrayList<String>();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//		String line = null;
//		while ((line = br.readLine()) != null) {
//			list.add(line);
//			RCA.setResponses(list);
//		}
//
//		return RCA;
//	}

}