
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public abstract class Questions implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1193596458467841394L;


	 	protected String prompt;
//	    protected int questionNumbers;
	    protected InputOutput io;
	    protected ResponseCorrectAnswer responseList;
		protected ArrayList<String> choices;
//	    protected ArrayList<ResponseCorrectAnswer> userResponseList;
//	    protected ResponseCorrectAnswer userResponse;
	   


	/**
     * Default constructor
     */
    public Questions() {
    	prompt = "";
    	io = new InputOutput();
    	responseList = new ResponseCorrectAnswer();
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

    public void setUserResponses( ResponseCorrectAnswer userAnswers) {
    	this.responseList = userAnswers;
    }
    
    public ResponseCorrectAnswer getUserResponses() {
    	return this.responseList;
    }

    
    public void editPrompt(String prompt) {
    	this.prompt = prompt;
    }

   
    public void buildQuestion() throws IOException {
    	
    }
    public void tabulate() {
        // TODO implement here
    }


    
    public String getUserInputString() throws IOException {
    	return io.getInput().getUserInputString();
    }
    

}