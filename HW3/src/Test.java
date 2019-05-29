
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */
public class Test extends Survey {

	/**
	 * Test Object class. Similar to survey but holds and prompts the users for
	 * correct answers to the questions
	 */
	private static final long serialVersionUID = -7470299821996705752L;
	protected ArrayList<ResponseCorrectAnswer> correctAnswers;
	protected Grader grader;

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
	 * Builds the answer part of the question. Will prompt for one or more answers
	 * and get the input from the console. After, the user is then prompted to input
	 * the correct answer to the question. This is stored in an arrayList of RCAs.
	 */
	public void buildCorrectAnswer(Questions q) throws IOException {

		if (q.getAmountOfAnswers() != 0) {
			io.getOutput().display("Assign a correct answer to the question: \n");
			this.questionList.get(this.correctAnswers.size()).display();
		}

		ResponseCorrectAnswer test = new ResponseCorrectAnswer();

		for (int i = 0; i < q.getAmountOfAnswers(); i++) {
			test.setCorrectAnswer(io.getInput().getUserInputString());
		}

		this.correctAnswers.add(test);
	}

	public void editCorrectAnswer(Questions q, int questionNum) throws IOException {
		io.getOutput().display("Would you like to edit an answer? \n");
		String choice = io.getInput().getUserInputString();
		if (choice.contains("yes".toLowerCase())) {

			ResponseCorrectAnswer newRCA = new ResponseCorrectAnswer();
			if (this.questionList.get(questionNum).choices.isEmpty()) {
				io.getOutput().display("No answer to edit! \n");
			} else if (q.getAmountOfAnswers() == 1) {
				this.questionList.get(questionNum).display();
				io.getOutput().display("Old answer: \n");
				this.correctAnswers.get(questionNum).display();
				io.getOutput().display("New answer: \n");
				newRCA.setCorrectAnswer(io.getInput().getUserInputString());
				this.correctAnswers.set(questionNum, newRCA);
			}

			else {
				io.getOutput().display("Which answer would you like to edit? \n");
				this.questionList.get(questionNum).display();
				io.getOutput().display("Old answer: \n");
				this.correctAnswers.get(questionNum).display();
				this.questionList.get(this.correctAnswers.size()).display();
				int choiceNum = io.getInput().getInputInt() - 1;
				this.correctAnswers.set(choiceNum, newRCA);
			}
		}
	}

	/**
	 * Display function implemented for test. Shows the name, amount of questions,
	 * the name of the questions, the choices and the correct answer
	 */
	public void display() {
		io.getOutput().display("Test name: " + this.getName());
		io.getOutput().display("Number of questions: " + this.questionList.size());
		for (int i = 0; i < this.questionList.size(); i++) {
			io.getOutput().display("\n Question " + (i + 1) + ": ");
			this.questionList.get(i).display();

			io.getOutput().display("Correct Answer(s): ");

			this.correctAnswers.get(i).display();
		}

	}
	
	//Gets the amount of correct answers and divides them by the total amount of questions. Essays are included but
	//in the grading since it's done automatically.
	public void grade(ArrayList<ResponseCorrectAnswer> userAnswers, ArrayList<ResponseCorrectAnswer> correctAnswers) {
		grader = new Grader();
		float correct = 0;
		float grade = 0;
		for (int i = 0; i < this.questionList.size(); i++) {
			correct = grader.grade(userAnswers.get(i), correctAnswers.get(i));
		}
		
		grade = (correct / this.questionList.size()) * 100;
		io.getOutput().display("Your grade is: " + Float.toString(grade));
	}
}