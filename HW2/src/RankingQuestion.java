import java.util.ArrayList;

/**
 * 
 */
public class RankingQuestion extends MatchingQuestion {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7481728219616349345L;

	
    public RankingQuestion() {
    	this.prompt = "";
    	this.leftSideOptions = new ArrayList<String>();
    			
    }
    
    public void display() {
		io.getOutput().display(this.getPrompt());

    	for (int i  = 0; i < leftSideOptions.size(); i ++) {
    		io.getOutput().display(i + ". " + leftSideOptions.get(i));
    	}
    }
    

   
    /**
     * @return
     */
    public void tabulate() {
        // TODO implement here
    }

    

}