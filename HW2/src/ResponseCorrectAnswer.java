
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public class ResponseCorrectAnswer implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3328318020167470760L;
	private ArrayList<String> responses;
//	private ArrayList<String> answers;
    
	public ResponseCorrectAnswer() {
		responses = new ArrayList<String>();
    }

//    public ResponseCorrectAnswer ResponseCorrectAnswer() {
//        // TODO implement here
//        return null;
//    }

    
    public Boolean compare( ResponseCorrectAnswer user,  ResponseCorrectAnswer correct) {
        //TODO: set params to correct values
    	
    	if(user.equals(correct)) {
        	return true;
        }
		return false;
    }

    /**
     * @return
     */
    public ArrayList<String> getResponses() {
      
        return this.responses;
    }

    /**
     * @param StringList responses 
     * @return
     */
    public void setResponses( ArrayList<String> responses) {
        this.responses = responses;
    }
//
//	public ArrayList<String> getAnswers() {
//		return this.answers;
//	}
//
//	public void setAnswers(ArrayList<String> answers) {
//		this.answers = answers;
//	}

}