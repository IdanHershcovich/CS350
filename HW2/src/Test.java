
import java.util.ArrayList;

/**
 * 
 */
public class Test extends Survey {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7470299821996705752L;
	private ArrayList<ResponseCorrectAnswer> answers;

	/**
	 * Default constructor
	 */
	public Test() {
		questionList = new ArrayList<Questions>();
		this.setName("");
		io = new InputOutput();
	}

	public void display() {
		io.getOutput().display("Test name: " + this.getName());
		io.getOutput().display("Number of questions: " + this.questionList.size());

		if (answers.size() == 0) {
			io.getOutput().display("Test has not been graded yet.");
		} else {
			// TODO: put answers here
		}
		for (int i = 0; i < this.questionList.size(); i++) {
			io.getOutput().display("Question " + (i + 1) + ": ");
			this.questionList.get(i).io.getOutput();
		}
	}

	public void editTest() {
		// TODO implement here
	}

}