
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */
public class Test extends Survey {

	/**
	 Test Object class. Similar to survey but holds and prompts the users for correct answers to the questions
	 */
	private static final long serialVersionUID = -7470299821996705752L;
	protected ArrayList<ResponseCorrectAnswer> correctAnswers;

	/**
	 * Default constructor
	 */
	public Test() {
		questionList = new ArrayList<Questions>();
		this.setName("");
		io = new InputOutput();
		correctAnswers = new ArrayList<ResponseCorrectAnswer>();
	}

	/**
	 * 
	 Builds the answer part of the question. Will prompt for one or more answers and get the input from the console. After, the user
	 is then prompted to input the correct answer to the question. This is stored in an arrayList of RCAs. 
	 */
	public void buildCorrectAnswer(Questions q) throws IOException {

		io.getOutput().display("How many answers does this question have? \n");
		q.setAmountOfAnswers(io.getInput().getInputInt());
		
		if(q.getAmountOfAnswers() != 0) {
			io.getOutput().display("Assign a correct answer to the question (Select the choice): \n");
			this.questionList.get(this.correctAnswers.size()).display();
		}
		
		ResponseCorrectAnswer test = new ResponseCorrectAnswer();
		
		for (int i = 0; i < q.getAmountOfAnswers(); i++) {
			test.setCorrectAnswer(io.getInput().getUserInputString());
		}

		this.correctAnswers.add(test);
	}

	/**
	 Display function implemented for test. Shows the name, amount of questions, 
	 the name of the questions, the choices and the correct answer
	 */
	public void display() {
		io.getOutput().display("Test name: " + this.getName());
		io.getOutput().display("Number of questions: " + this.questionList.size());
		for (int i = 0; i < this.questionList.size(); i++) {
			io.getOutput().display("Question " + (i + 1) + ": ");
			this.questionList.get(i).display();

			io.getOutput().display("Correct Answer(s): ");

			this.correctAnswers.get(i).display();

		}

	}

	public void editTest() {
		// TODO implement here
	}
}