
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 Survey Object class. Contains initialization of a survey and methods for question related methods.  
 */
public class Survey implements Serializable {

	private static final long serialVersionUID = -2409404523848565166L;
	
    protected int finishedQuestions;
    protected InputOutput io;
    protected ArrayList<Questions> questionList;
    private String name;
	protected String filePath;

	//Initializes a question list, the name and io.
    public Survey() {
    	questionList = new ArrayList<Questions>();
    	this.setName("");
    	io = new InputOutput();

    }
    //adds the type of question created by the admin to a question list
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

    //Displays the survey. It shows the name, the number of questions in the survey and then loops
    //through them and shows the prompt.
    public void display() {
    	io.getOutput().display("Survey name: " + this.getName());
		io.getOutput().display("Number of questions: " + this.questionList.size());
		
		for (int i = 0; i < this.questionList.size(); i++) {
			io.getOutput().display("Question " + (i+1) + ": ");
			io.getOutput().display(this.getQuestion(questionList.get(i)) + "\n");
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