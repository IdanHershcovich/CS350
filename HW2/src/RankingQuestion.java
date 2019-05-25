import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 Ranking Question. Extends matching question since they're similar. Behaves the same way
 but with just one side.
 */
public class RankingQuestion extends MatchingQuestion {

	private static final long serialVersionUID = -7481728219616349345L;

	public RankingQuestion() {
		this.prompt = "";
		this.leftSideOptions = new ArrayList<String>();

	}
	/**
	 builder for this type of question. Will prompt for the amount of ranked items and then individually ask for them.
	 */
	public void buildQuestion() throws IOException {
		io.getOutput().display("Enter the prompt for your Ranking question: \n");
		this.setPrompt(getUserInputString());
		io.getOutput().display("Enter the amount of options for your ranking question  \n");
		this.setAmountOfAnswers(io.getInput().getInputInt());

		io.getOutput().display("Enter the options of your ranking question  \n");

		for (int i = 0; i < this.amountOfAnswers; i++) {
			io.getOutput().display("Enter choice #" + (i + 1) + "\n");
			this.addLeftSide(io.getInput().getUserInputString());
		}
		
	}
	
	/**
	 Displays a shuffled list of choices.
	 */
	public void display() {
		io.getOutput().display(this.getPrompt() + "\n");
		// Randomizes ranking order
				Collections.shuffle(leftSideOptions);

		for (int i = 0; i < leftSideOptions.size(); i++) {
			io.getOutput().display((i+1) + ". " + leftSideOptions.get(i));
		}
	}
	public void tabulate() {
		// TODO implement here
	}

}