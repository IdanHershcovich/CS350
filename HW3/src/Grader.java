

/**
 Grader class. Used in Test to grade the answers of a test.  
 */
public class Grader {

    private int correct;
	private ResponseCorrectAnswer test;
    
    public Grader() {
    	test = new ResponseCorrectAnswer();
    	correct = 0;   	
    }

    //compares the RCAs. The user answer with the correct answer. For every correct answer, 
    //it adds 1 to an int and returns it
    public int grade(ResponseCorrectAnswer userAnswer, ResponseCorrectAnswer correctAnswer) {
    	
    	if (test.compare(userAnswer, correctAnswer)) {
    		correct ++;
    	}
    	
		return correct;
    }

}