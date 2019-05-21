
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Input implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7701867319609541357L;
	protected BufferedReader br;

	public Input() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public String getUserInputString() throws IOException {

		return br.readLine();
	}

	public int getInputInt() {
		while (true) {
			try {
				return Integer.parseInt(br.readLine());

			} catch (Exception e) {
				System.out.println("Your input did not match any of the choices! Please try again");

			}
		}
	}

	public ResponseCorrectAnswer getUserInputRCA() throws IOException {
		ResponseCorrectAnswer RCA = new ResponseCorrectAnswer();
		ArrayList<String> list = new ArrayList<String>();

		String line = null;
		while ((line = br.readLine()) != null) {
			list.add(line);
			RCA.setResponses(list);
		}

		return RCA;
	}

}