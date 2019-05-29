
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public abstract class Questions implements Serializable {

    /**
	 Abstract Question Class. Contains abstract methods defined in the implementations.
	 A question has a prompt, an io object, list of user responses, the choices for the prompt and
	 amount of answers. 
	 */
	private static final long serialVersionUID = 1193596458467841394L;


	 	protected String prompt;
	    protected InputOutput io;
	    protected int amountOfAnswers;
	    protected ArrayList<ResponseCorrectAnswer> responseList;
		protected ArrayList<String> choices;

	/**
     * Default constructor
     */
    public Questions() {
    	prompt = "";
    	io = new InputOutput();
    	responseList = new ArrayList<ResponseCorrectAnswer>();
    	this.setAmountOfAnswers(1);
    	choices = new ArrayList<String>();
    }

    public void setPrompt( String setPrompt) {
        
    	this.prompt = setPrompt;
    }

    /**
     * @return
     */
    public String getPrompt() { 
        return this.prompt;
    }

    public void setUserResponses( ResponseCorrectAnswer userAnswer) {
    	this.responseList.add(userAnswer);
    }
    
    public ResponseCorrectAnswer getUserResponses(int index) {
    	return this.responseList.get(index);
    }

    public String getChoices(int index) {
		
    	return choices.get(index);
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}
    
	public void editChoice(int choiceNumber) throws IOException {
		String newChoice = io.getInput().getUserInputString();
		choices.set(choiceNumber, newChoice);
	}
	
    public void editPrompt(String prompt) {
    	this.prompt = prompt;
    }

   
    public void buildQuestion() throws IOException {
    	
    }
 
    public int getAmountOfAnswers() {
		
		return amountOfAnswers;
	}

	public void setAmountOfAnswers(int amountOfAnswers) {
		this.amountOfAnswers = amountOfAnswers;
	}
    
    public String getUserInputString() throws IOException {
    	return io.getInput().getUserInputString();
    }
    
    public void display() {
    	
    }

	public void editQuestion() throws IOException {
		// TODO Auto-generated method stub
		
	}

}