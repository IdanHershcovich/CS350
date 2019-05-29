import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */
public class EssayQuestion extends Questions {

	private static final long serialVersionUID = 6943091102259369582L;

	protected ArrayList<String> essay; //ArrayList in case there are more than 1 answers

	public EssayQuestion() {
		prompt = "";
	}
	
	//builds the question with the prompts for the admin
	public void buildQuestion() throws IOException {
		io.getOutput().display("Enter the prompt for your Essay question: \n");
		this.setPrompt(getUserInputString());
		io.getOutput().display("How many responses should this question have? ");
		this.setAmountOfAnswers(io.getInput().getInputInt());
	}

	public void display() {
		io.getOutput().display(prompt + "\n");
	}
	
	//sets a new prompt
	public void editQuestion() throws IOException {
		io.getOutput().display("Would you like to edit the prompt?");
		String choice = io.getInput().getUserInputString();
		if (choice.contains("yes".toLowerCase())) {
			io.getOutput().display("Enter a new prompt: ");
			this.setPrompt(io.getInput().getUserInputString());
		}
		
	}

}