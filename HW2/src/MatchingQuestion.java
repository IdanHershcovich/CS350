
import java.util.ArrayList;

/**
 * 
 */
public class MatchingQuestion extends Questions {

    /**
	 * 
	 */
	private static final long serialVersionUID = 804247969826854704L;
    protected ArrayList<String> leftSideOptions;
    protected ArrayList<String> rightSideOptions;

	/**
     * Default constructor
     */
    public MatchingQuestion() {
    	prompt = "";
    	this.leftSideOptions = new ArrayList<String>();
    	this.rightSideOptions = new ArrayList<String>();
    }
    
    public void addLeftSide( ResponseCorrectAnswer left) {
        for( String choice : left.getResponses()) {
        	leftSideOptions.add(choice.toString());
        }
    }
    
    public void addRightSide( ResponseCorrectAnswer right) {
        for( String choice : right.getResponses()) {
        	rightSideOptions.add(choice.toString());
        }
    }
   
    public void getResponse( ResponseCorrectAnswer response) {
        // TODO implement here
    }
    
    public void tabulate() {
        // TODO implement here
    }

    public void editOption( ArrayList<String> side,  int position) {
        // TODO implement here
    }


	public ArrayList<String> getLeftSideOptions() {
		return leftSideOptions;
	}

	public ArrayList<String> getRightSideOptions() {
		return rightSideOptions;
	}
	
	public void display() {
		io.getOutput().display(this.getPrompt());
		
		if (rightSideOptions.size() == leftSideOptions.size()) {
		for (int i  = 0; i < rightSideOptions.size(); i ++) {
			io.getOutput().display((char) ('A' + i) + ". " + leftSideOptions.get(i) + '\t' + 
					i + ". " + rightSideOptions.get(i));
		}
		}
		else {
			io.getOutput().display("Please return the same amount of options for each side of the Matching question!");
		}
		
	}

}