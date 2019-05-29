
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Survey Object class. Contains initialization of a survey and methods for
 * question related methods.
 */
public class Survey implements Serializable {

	private static final long serialVersionUID = -2409404523848565166L;

	protected int finishedQuestions;
	protected InputOutput io;
	protected ArrayList<Questions> questionList;
	private String name;
	protected String userName;
	protected String filePath;
	protected ArrayList<ResponseCorrectAnswer> userResponses;

	// Initializes a question list, the name and io.
	public Survey() {
		questionList = new ArrayList<Questions>();
		userName = "";
		this.setName("");
		io = new InputOutput();
		userResponses = new ArrayList<ResponseCorrectAnswer>();
	}

	// adds the type of question created by the admin to a question list
	public void createQuestion(Questions q) throws IOException {
		this.questionList.add(q);
	}

	public String getQuestion(Questions q) {
		return q.getPrompt();
	}

	public void deleteQuestion(int questionNum) {
		this.questionList.remove(questionNum);
	}

	// Displays the survey. It shows the name, the number of questions in the survey
	// and then loops
	// through them and shows the prompt.
	public void display() {
		io.getOutput().display("Survey name: " + this.getName());
		io.getOutput().display("Number of questions: " + this.questionList.size());

		for (int i = 0; i < this.questionList.size(); i++) {
			io.getOutput().display("Question " + (i + 1) + ": ");
			this.questionList.get(i).display();
			// io.getOutput().display(this.getQuestion(questionList.get(i)) + "\n");
		}
	}
	
	//Take survey. Loops through the question list while asking for a response for each. Saves them to
	//an ArrayLists of RCAs
	public void take() throws IOException {
		for (int i = 0; i < this.questionList.size(); i++) {
			io.getOutput().display("Question " + (i + 1) + " of " + this.questionList.size());
			Questions q = this.questionList.get(i);
			q.display();
			ResponseCorrectAnswer response = new ResponseCorrectAnswer();
			for (int j = 0; j < q.getAmountOfAnswers(); j++) {
				io.getOutput().display("\n Answer " + (j+1)+ " out of " + (q.getAmountOfAnswers()) + ":");
				response.setCorrectAnswer(io.getInput().getUserInputString());
			}
			userResponses.add(response);
		}
	}
	
	//Displays the question and all of the user responses to that question.
	public void tabulate() throws ClassNotFoundException, IOException {
		ArrayList<ArrayList<ResponseCorrectAnswer>> allAnswers = new ArrayList<ArrayList<ResponseCorrectAnswer>>();
		Serialization serialization = new Serialization();
		
		allAnswers=	serialization.loadAllAnswers(this.filePath);
		
		for (int i = 0; i < this.questionList.size(); i++) {
			this.questionList.get(i).display();
			io.getOutput().display("\nReplies: ");
			for (int j = 0; j < allAnswers.size(); j++) {
				io.getOutput().display(allAnswers.get(j).get(i).getResponses() + "\n");
			}
			
			io.getOutput().display("Tabulate:");
			tabulateMap(allAnswers, i);
			io.getOutput().display("\n");		
		}	
	}
	
	//HashMap for indexing and assigning the values to the choices. Loops through every survey/test
	// and then gets the responses of each question before comparing.
	protected void tabulateMap(ArrayList<ArrayList<ResponseCorrectAnswer>> allAnswers, int index) {
		HashMap<ArrayList<String>, Integer> answerCount = new HashMap<ArrayList<String>, Integer>();

		for (int i = 0; i < allAnswers.size(); i++) {
			
			for (int j = 0; j < allAnswers.get(i).get(j).getResponses().size(); j++) {
				
				ArrayList<String> allResponses = allAnswers.get(i).get(index).getResponses();
				
				if (answerCount.containsKey(allResponses)) {
					
					answerCount.put(allResponses, answerCount.get(allResponses) + 1);
					
				} else {
					answerCount.put(allResponses, 1);
				}
			}
		}
		
		for (Entry<ArrayList<String>, Integer> entry : answerCount.entrySet()) {
		    io.getOutput().display(entry.getKey() + ": " + entry.getValue());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}