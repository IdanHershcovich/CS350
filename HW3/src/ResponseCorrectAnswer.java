
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public class ResponseCorrectAnswer implements Serializable {

	
	/**
	 Used for holding the correct answers.
	 Compares the correctAnswer from the admin and the user response when doing tests.
	 */
	private static final long serialVersionUID = 3328318020167470760L;
	private ArrayList<String> responses;
	private InputOutput io;
    
	public ResponseCorrectAnswer() {
		responses = new ArrayList<String>();
		io = new InputOutput();
    }
    
    public Boolean compare( ResponseCorrectAnswer user,  ResponseCorrectAnswer correct) {
        //TODO: set params to correct values
    	
    	if(user.responses.equals(correct.responses)) {
        	return true;
        }
		return false;
    }

    public ArrayList<String> getResponses() {
      
        return this.responses;
    }

    public void setResponses( ArrayList<String> responses) {
        this.responses = responses;
    }
    
    public void setCorrectAnswer (String correctAnswer) {
    	this.responses.add(correctAnswer);
    }
    
    public String getCorrectAnswer (int index) {
    	return this.responses.get(index);
    }
    
    public void display() {
    	for (int i = 0; i < this.responses.size(); i ++) {
    		io.getOutput().display(this.responses.get(i));
    	}
    }
}