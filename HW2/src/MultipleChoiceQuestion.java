
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */
public class MultipleChoiceQuestion extends Questions {

	private static final long serialVersionUID = -6134938477523176073L;
	private int amountOfAnswers;
	protected int numOfPrompts;

	public MultipleChoiceQuestion() {
		prompt = "";
		amountOfAnswers = 0;
		this.choices = new ArrayList<String>();
		numOfPrompts = 0;

	}

	public int getNumOfPrompts() {
		return numOfPrompts;
	}

	public void setNumOfPrompts(int numOfPrompts) {
		this.numOfPrompts = numOfPrompts;
	}

	public void buildQuestion() throws IOException {
		io.getOutput().display("Enter the prompt for your Multiple Choice question: \n");
		this.setPrompt(getUserInputString());
		io.getOutput().display("Enter the number of choices for your multiple-choice question.  \n");
		this.setNumOfPrompts(io.getInput().getInputInt());
		io.getOutput().display("Enter the number of answers for your multiple-choice question.  \n");
		
		for (int i = 0; i < this.numOfPrompts; i++) {
			io.getOutput().display("Enter choice #" + (i + 1) + "\n");
			this.setChoices(getUserInputString());
		}	
	}

	public void display() {
		io.getOutput().display(this.getPrompt());
		for (int i = 0; i < this.choices.size(); i++) {
			io.getOutput().display((char) ('A' + i) + ". " + this.choices.get(i) + " ");
		}
	}

	public void tabulate() {
		// TODO implement here
	}

	public void editPrompt(String newChoice, int promptNumber) throws IOException {
		newChoice = io.getInput().getUserInputString();
		choices.set(promptNumber, newChoice);
	}

	public ArrayList<String> getChoices() {
		return choices;
	}

	public void setChoices(String prompt) {
		this.choices.add(prompt);
	}

	public int getAmountOfAnswers() {
		return amountOfAnswers;
	}

	public void setAmountOfAnswers(int amountOfAnswers) {
		this.amountOfAnswers = amountOfAnswers;
	}
}
