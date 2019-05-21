import java.io.IOException;

/**
 * 
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
	public void display() {
		io.getOutput().display(this.getPrompt());
		for (int i = 0; i < this.choices.size(); i++) {
			io.getOutput().display((char) ('A' + i) + ". " + choices.get(i).toString());
		}

	}

	public void tabulate() {
		// TODO implement here
	}

}