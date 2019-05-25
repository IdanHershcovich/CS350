
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

/**
 * 
 */
public class MatchingQuestion extends Questions {

	/**
	 Matching question. This question consists of two "sides" to display. User has to make a relation of both sides
	 */
	private static final long serialVersionUID = 804247969826854704L;
	protected ArrayList<String> leftSideOptions;
	protected ArrayList<String> rightSideOptions;

	/**
	 * Default constructor. Initializes the 2 sides
	 */
	public MatchingQuestion() {
		prompt = "";
		this.leftSideOptions = new ArrayList<String>();
		this.rightSideOptions = new ArrayList<String>();
	}

	public void addLeftSide(String left) {
		this.leftSideOptions.add(left);
	}

	public void addRightSide(String right) {
		this.rightSideOptions.add(right);
	}

	public void getResponse(ResponseCorrectAnswer response) {
		// TODO implement here
	}

	public void tabulate() {
		// TODO implement here
	}

	public void editOption(ArrayList<String> side, int position) {
		// TODO implement here
	}

	//For admin creation of the question. Will prompt for the amount of choices and then both sides of the matching
	public void buildQuestion() throws IOException {
		io.getOutput().display("Enter the prompt for your Matching question: \n");
		this.setPrompt(getUserInputString());
		io.getOutput().display("Enter the amount of options for your matching question  \n");
		this.setAmountOfAnswers(io.getInput().getInputInt());

		io.getOutput().display("Enter the options for the left side of your matching question  \n");

		for (int i = 0; i < this.amountOfAnswers; i++) {
			io.getOutput().display("Enter choice #" + (i + 1) + "\n");
			this.addLeftSide(io.getInput().getUserInputString());
		}

		io.getOutput().display("Enter the options for the right side of your matching question  \n");

		for (int i = 0; i < this.amountOfAnswers; i++) {
			io.getOutput().display("Enter choice #" + (i + 1) + "\n");
			this.addRightSide(io.getInput().getUserInputString());
		}
	}

	public ArrayList<String> getLeftSideOptions() {
		return leftSideOptions;
	}

	public ArrayList<String> getRightSideOptions() {
		return rightSideOptions;
	}

	//defining the display method. Added a shuffle to avoid ordered answers.
	public void display() {
		io.getOutput().display(this.getPrompt() + "\n");
		// Randomizes right side options to help matching.
		Collections.shuffle(rightSideOptions);

		if (rightSideOptions.size() == leftSideOptions.size()) {
			for (int i = 0; i < rightSideOptions.size(); i++) {
				io.getOutput().display((char) ('A' + i) + ". " + leftSideOptions.get(i) + '\t' + (i + 1) + ". "
						+ rightSideOptions.get(i));
			}
		} else {
			io.getOutput().display("Please return the same amount of options for each side of the Matching question!");
		}

	}

}