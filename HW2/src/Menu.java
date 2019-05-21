import java.io.IOException;

import java.io.IOException;
import java.util.ArrayList;
//
///**
// * 
// Abstract Menu class. contains a way to display the different menus.
// */
//public abstract class Menu {
//
//	 protected int selectedOption;
//	 protected ArrayList<String> choices;
//	 protected InputOutput io;
//	 
//	 public Menu() {
//		 selectedOption = 0;
//		 io = new InputOutput();
//		 choices = new ArrayList<String>();
//	 }
//	 
//	 
//	 public void addChoice(String c) {
//		 this.choices.add(c);
//	 }
//	 
//	 public void display(){
//		 for (int i = 0; i < this.choices.size(); i++) {
//			 io.getOutput().display(i + ". " + this.choices.get(i));
//		 }
//	 }  	 
//	 
//    public int getSelectedOption() {
//    	return selectedOption;
//    }
//    
//    public void setSelectedOption(int option) {
//    	this.selectedOption = option;
//    	
//    }
//    
//
//}

public class Menu implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5627318687708220536L;
	private InputOutput io = new InputOutput();
	private ArrayList<String> mainMenu;
	private ArrayList<String> surveyMenu;
	private ArrayList<String> testMenu;

	private ArrayList<String> questionTypeMenu;

	public Menu() {
		mainMenu = new ArrayList<String>();
		mainMenu.add("Survey");
		mainMenu.add("Test");

		surveyMenu = new ArrayList<String>();
		surveyMenu.add("Create");
		surveyMenu.add("Display");
		surveyMenu.add("Load");
		surveyMenu.add("Save");
		surveyMenu.add("Modify");
		surveyMenu.add("Take");
		surveyMenu.add("Tabulate");
		surveyMenu.add("Quit");

		testMenu = new ArrayList<String>();
		testMenu.add("Create");
		testMenu.add("Display");
		testMenu.add("Load");
		testMenu.add("Save");
		testMenu.add("Modify");
		testMenu.add("Take");
		testMenu.add("Tabulate");
		testMenu.add("Grade");
		testMenu.add("Quit");

		questionTypeMenu = new ArrayList<String>();
		questionTypeMenu.add("Add True or False Question");
		questionTypeMenu.add("Add Multiple Choice Question");
		questionTypeMenu.add("Add Essay Question");
		questionTypeMenu.add("Add Short Answer Question");
		questionTypeMenu.add("Add Ranking Question");
		questionTypeMenu.add("Add Matching Question");
		questionTypeMenu.add("Return Questionnaire");

	}

	public void mainMenu() throws IOException, ClassNotFoundException {
		int choice;

		io.getOutput().display("Select Questionnaire");
		for (int i = 0; i < mainMenu.size(); i++) {
			io.getOutput().display((i + 1) + ") " + mainMenu.get(i));
		}
		choice = io.getInput().getInputInt();

		switch (choice) {
		case 1:
			surveyMenu();
			break;
		case 2:
			testMenu();
			break;
		default:
			io.getOutput().display("Your input did not match any of the choices! Please try again");
			this.mainMenu();
			break;
		}

	}

	public void surveyMenu() throws ClassNotFoundException, IOException {
		Survey survey = new Survey();
		int choice;
		boolean menuLoop = true;

		io.getOutput().display("Survey Menu");
		while (menuLoop) {
			for (int i = 0; i < surveyMenu.size(); i++) {
				io.getOutput().display((i + 1) + " " + surveyMenu.get(i));
			}
			choice = io.getInput().getInputInt();

			switch (choice) {
			case 1:
				survey = questionMenu(survey);
				break;
			case 2:
				survey.display();
				break;
			case 3:
				survey = loadSurvey(); // serialize
				break;
			case 4:
				saveMenu(survey);
				break;
			case 5:
				io.getOutput().display("You cannot edit right now!");
				break;
			case 6:
				survey = loadSurvey(); // serialize
				survey.take();
				break;
			case 7:
				survey.tabulate();
				break;
			case 8:
				mainMenu();
				break;
			default:
				io.getOutput().display("Your input did not match any of the choices! Please try again");
				this.surveyMenu();
				if (choice != (int) choice) {
					io.getOutput().display("Your input did not match any of the choices! Please try again");
				}
				break;
			}
		}
	}

	public void testMenu() throws ClassNotFoundException, IOException {
		Test test = new Test();
		int choice;
		boolean menuLoop = true;

		io.getOutput().display("Test Menu");
		while (menuLoop) {
			for (int i = 0; i < testMenu.size(); i++) {
				io.getOutput().display((i + 1) + " " + testMenu.get(i));
			}
			choice = io.getInput().getInputInt();

			switch (choice) {
			case 1:
				questionMenu(test);
				break;
			case 2:
				test.display();
				break;
			case 3:
				test = loadTest(); // serialize
				break;
			case 4:
				saveMenu(test); // serialize
				break;
			case 5:
				io.getOutput().display("You cannot edit right now!");
				break;
			case 6:
				test = loadTest(); // serialize
				test.take();
				break;
			case 7:
				test.tabulate();
				break;
			case 8:
				io.getOutput().display("No grades yet!");// hw3
				break;
			case 9:
				mainMenu();
				break;
			default:
				io.getOutput().display("Your input did not match any of the choices! Please try again");
				this.testMenu();
				if (choice != (int) choice) {
					io.getOutput().display("Your input did not match any of the choices! Please try again");
				}
				break;
			}
		}
	}

	public Survey questionMenu(Survey survey) throws NumberFormatException, IOException {
		boolean menuLoop = true;
		int choice;
		
		Questions q = null;
		io.getOutput().display("Question Menu");
		while (menuLoop) {
			for (int i = 0; i < questionTypeMenu.size(); i++) {
				io.getOutput().display((i + 1) + " " + questionTypeMenu.get(i));
			}
			choice = io.getInput().getInputInt();

			
			switch (choice) {
			case 1:
				q = new TrueOrFalseQuestions();
				break;
			case 2:
				q = new MultipleChoiceQuestion();
				break;
			case 3:
				q = new ShortAnswerQuestion();
				break;
			case 4:
				q = new EssayQuestion();
				break;
			case 5:
				q = new RankingQuestion();
				break;
			case 6:
				q = new MatchingQuestion();
				break;
			case 7:
				return survey;

			default:
				io.getOutput().display("Your input did not match any of the choices! Please try again");
				this.questionMenu(survey);
				
			}
			survey.createQuestion(q);
			q.buildQuestion();
		}
		
		
		return survey;
	}

	public Survey questionMenu(Test test) throws NumberFormatException, IOException {
		boolean menuLoop = true;
		int choice;

		io.getOutput().display("Question Menu");
		while (menuLoop) {
			for (int i = 0; i < questionTypeMenu.size(); i++) {
				io.getOutput().display((i + 1) + " " + questionTypeMenu.get(i));
			}
			choice = io.getInput().getInputInt();

			switch (choice) {
			case 1:
				test.createQuestion(new TrueOrFalseQuestions());
				break;
			case 2:
				test.createQuestion(new TrueOrFalseQuestions());
				break;
			case 3:
				test.createQuestion(new ShortAnswerQuestion());
				break;
			case 4:
				test.createQuestion(new EssayQuestion());
				break;
			case 5:
				test.createQuestion(new RankingQuestion());
				break;
			case 6:
				test.createQuestion(new MatchingQuestion());
				break;
			case 7:
				return test;

			default:
				io.getOutput().display("Your input did not match any of the choices! Please try again");
				this.questionMenu(test);
				if (choice != (int) choice) {
					io.getOutput().display("Your input did not match any of the choices! Please try again");
				}
			}
		}

		return test;
	}

	public void saveMenu(Survey survey) throws IOException {
		Serialization serialize = new Serialization();
		serialize.save(survey);
	}

	public void saveMenu(Test test) throws IOException {
		SerializeTest serialize = new SerializeTest();
		serialize.save(test);
	}

	public Survey loadSurvey() throws IOException {
		Serialization serialize = new Serialization();
		return serialize.load();
	}

	public Test loadTest() throws IOException {
		SerializeTest serialize = new SerializeTest();
		return serialize.load();
	}
}
