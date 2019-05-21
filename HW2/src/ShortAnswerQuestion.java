/**
 * 
 */
public class ShortAnswerQuestion extends EssayQuestion {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1052658735688535658L;
    private int lengthLimit;




    public ShortAnswerQuestion() {
    	lengthLimit = 0;
    	prompt = "";
    }

    public void checkLength() {
       if (essay.get(0).length() > lengthLimit) {
    	   System.out.println("Submitted answer is too long! It must be less than " + lengthLimit + " words.");
       }
        
    }
    
    public void display() {
        io.getOutput().display(prompt);
        io.getOutput().display("Your question must be less than " + this.getLengthLimit() + " words");

     }

   
    public int getLengthLimit() {
        // TODO implement here
        return this.lengthLimit;
    }

    /**
     * @return
     */
    public void setLengthLimit(int limit) {
       this.lengthLimit = limit;
    }

    /**
     * @return
     */
    public void tabulate() {
        // TODO implement here
        
    }

}