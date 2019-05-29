
import java.io.IOException;
import java.util.ArrayList;

/**
 * Multiple Choice Question. Instantiates a new question with amount of prompts
 * chosen by admin
 */
public class MultipleChoiceQuestion extends Questions {

	private static final long serialVersionUID = -6134938477523176073L;
	protected int numOfPrompts;

	public MultipleChoiceQuestion() {
		prompt = "";
		this.choices = new ArrayList<String>();
		numOfPrompts = 0;
	}

	public int getNumOfPrompts() {
		return numOfPrompts;
	}

	public void setNumOfPrompts(int numOfPrompts) {
		this.numOfPrompts = numOfPrompts;
	}

	/**
	 * Builds question for this type of question. gets prompt and choices from the
	 * admin
	 */
	public void buildQuestion() throws IOException {
		io.getOutput().display("Enter the prompt for your Multiple Choice question: \n");
		this.setPrompt(getUserInputString());
		io.getOutput().display("Enter the number of choices for your multiple-choice question.  \n");
		this.setNumOfPrompts(io.getInput().getInputInt());

		for (int i = 0; i < this.numOfPrompts; i++) {
			io.getOutput().display("Enter choice #" + (i + 1) + "\n");
			this.setChoices(getUserInputString());
		}

		io.getOutput().display("How many responses should this question have? ");
		this.setAmountOfAnswers(io.getInput().getInputInt());
	}

	/**
	 * Displays the question in the console. loops through the amount of choices and
	 * adds a letter before the choice for readability and answering.
	 */
	public void display() {
		io.getOutput().display(this.getPrompt() + "\n");
		for (int i = 0; i < this.choices.size(); i++) {
			io.getOutput().display((char) ('A' + i) + ". " + this.choices.get(i) + " ");
		}
	}

	//Options for editing the prompt and the choices.
	public void editQuestion() throws IOException {
		io.getOutput().display("Would you like to edit the prompt?");
		String choice = io.getInput().getUserInputString();
		if (choice.contains("yes".toLowerCase())) {
			io.getOutput().display("Enter a new prompt: ");
			this.setPrompt(io.getInput().getUserInputString());
		}
		io.getOutput().display("Would you like to edit the choices?");
		choice = io.getInput().getUserInputString();
		if (choice.contains("yes".toLowerCase())) {
			for (int i = 0; i < this.choices.size(); i++) {
				io.getOutput().display((1 + i) + ". " + this.choices.get(i) + " ");
			}
			io.getOutput().display("Which choice do you want to modify? ");
			int choiceNum = io.getInput().getInputInt() - 1;
			io.getOutput().display("New choice: ");
			this.editChoice(choiceNum);
		}

	}

	public ArrayList<String> getChoices() {
		return choices;
	}

	public void setChoices(String prompt) {
		this.choices.add(prompt);
	}
}
