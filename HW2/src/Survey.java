
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public class Survey implements Serializable {

	private static final long serialVersionUID = -2409404523848565166L;
	
    protected int finishedQuestions;
    protected InputOutput io;
    protected ArrayList<Questions> questionList;
    private String name;
	protected String filePath;



    public Survey() {
    	questionList = new ArrayList<Questions>();
    	this.setName("");
    	io = new InputOutput();

    }

    public void createQuestion(Questions q) throws IOException {
    	this.questionList.add(q);
       
    }
    
    public String getQuestion(Questions q) {
    	return q.getPrompt();
    }

    public void editQuestion( int questionNumber) {
        // TODO implement here
    }

    public void deleteQuestion( int questionNum) {
    	this.questionList.remove(questionNum);
    }

    public void display() {
    	io.getOutput().display("Survey name: " + this.getName());
		io.getOutput().display("Number of questions: " + this.questionList.size());
		
		for (int i = 0; i < this.questionList.size(); i++) {
			io.getOutput().display("Question " + (i+1) + ": ");
			io.getOutput().display((this.getQuestion(this.questionList.get(i))));
		}
    }

    public void save( String name,  ArrayList<Questions>  questions) {
        
    }

    public void take() { 
//    	HW3 WIP
//    	ArrayList<ResponseCorrectAnswer> userResponses = new ArrayList<ResponseCorrectAnswer>();
//		for (int i = 0; i < this.questionList.size(); i++) {
//			io.getOutput().display("Question " + (i+1) + " of " + this.questionList.size());
//			Questions q = this.questionList.get(i);
//			q.io.getOutput();
//			ResponseCorrectAnswer response = q.getUserResponses(io.getInput().getUserInputString());
//			userResponses.add(response);
	}
    
    public void tabulate() {
    	
    }
		
   

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}