import java.io.IOException;

/**
 * 
 */
public class ShortAnswerQuestion extends EssayQuestion {

	private static final long serialVersionUID = 1052658735688535658L;
    private int lengthLimit;

    //Short Answer class. Very similar to essay, but it has a method to check for the length of the user's response
    public ShortAnswerQuestion() {
    	this.lengthLimit = 0;
    	this.prompt = "";
    	this.amountOfAnswers = 1;
    }

    public void checkLength() {
       if (essay.get(0).length() > lengthLimit) {
    	   System.out.println("Submitted answer is too long! It must be less than " + lengthLimit + " words.");
       }
        
    }
    
    public void display() {
        io.getOutput().display(prompt + "\n");
        io.getOutput().display("Your question must be less than " + this.getLengthLimit() + " words \n");

     }
    
    public void buildQuestion() throws IOException {
		io.getOutput().display("Enter the prompt for your Short Answer question: \n");
		this.setPrompt(getUserInputString());
		io.getOutput().display("Enter the maximum length of words for your short answer question.  \n");
		this.setLengthLimit(io.getInput().getInputInt());
		io.getOutput().display("How many responses should this question have? ");
		this.setAmountOfAnswers(io.getInput().getInputInt());
	}
    
    public void editQuestion() throws IOException {
		io.getOutput().display("Would you like to edit the prompt?");
		String choice = io.getInput().getUserInputString();
		if (choice.contains("yes".toLowerCase())) {
			io.getOutput().display("Enter a new prompt: ");
			this.setPrompt(io.getInput().getUserInputString());
		}
		io.getOutput().display("Would you like to edit the word count limit?");
		choice = io.getInput().getUserInputString();
		if (choice.contains("yes".toLowerCase())) {
			io.getOutput().display("Enter a new word limit: ");
			this.setLengthLimit(io.getInput().getInputInt());
		}
	}

    public int getLengthLimit() {
        
        return this.lengthLimit;
    }

    public void setLengthLimit(int limit) {
       this.lengthLimit = limit;
    }
}