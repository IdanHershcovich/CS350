import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */
public class EssayQuestion extends Questions {

    
	private static final long serialVersionUID = 6943091102259369582L;
	
	
	protected ArrayList<String> essay;
	protected InputOutput input;
	protected int amountOfAnswers;
    public EssayQuestion() {
    	prompt = "";
    	amountOfAnswers = 1;
    	
    }
    
    
//    public void setQuestion() {
//    	
//		 this.prompt = 
//	}

   
    public void display() {
       io.getOutput().display(prompt);
    }

    /**
     * @return
     */
    public void tabulate() {
        // TODO implement here
    }
    
//    public String getUserInputString() throws IOException {
//    	for (int i = 0; i < amountOfAnswers; i++) {
//    		setUserResponses(io.getInput().getUserInputString())
//    	}
//    }
    
    public void setUserResponses(ResponseCorrectAnswer userResponse) {
    	for (int i = 0; i < amountOfAnswers; i++) {
    		userResponse.setResponses(essay);
    	}
    }

    /**
     * @return
     */

}