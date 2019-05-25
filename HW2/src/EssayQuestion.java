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
	}

	public void display() {
		io.getOutput().display(prompt + "\n");
	}

	public void tabulate() {
		// TODO implement here
	}

//	public void setUserResponses(ResponseCorrectAnswer userResponse) {
//		for (int i = 0; i < amountOfAnswers; i++) {
//			userResponse.setResponses(essay);
//		}
//	}

}