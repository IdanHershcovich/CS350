import java.io.IOException;

/**
 * Similar to multiple choice. It's just an MC question with 2 set choices.
 */
public class TrueOrFalseQuestions extends MultipleChoiceQuestion {

	private static final long serialVersionUID = 7128200438709619175L;

	public TrueOrFalseQuestions() {
		prompt = "";
		this.choices.add("True");
		this.choices.add("False");
	}

	public void buildQuestion() throws IOException {
		io.getOutput().display("Enter the prompt for your True/False question: \n");
		this.setPrompt(getUserInputString());
	}

	public void editQuestion() throws IOException {
		io.getOutput().display("Would you like to edit the prompt?");
		String choice = io.getInput().getUserInputString();
		if (choice.contains("yes".toLowerCase())) {
			io.getOutput().display("Enter a new prompt: ");
			this.setPrompt(io.getInput().getUserInputString());
		}
	}

	public void display() {
		io.getOutput().display(this.getPrompt() + "\n");
		for (int i = 0; i < this.choices.size(); i++) {
			io.getOutput().display((char) ('A' + i) + ". " + choices.get(i).toString());
		}
	}
}