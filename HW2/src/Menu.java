import java.io.IOException;

import java.io.IOException;
import java.util.ArrayList;

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

	// Initializes and adds the options for the menus
	public Menu() {
		mainMenu = new ArrayList<String>();
		mainMenu.add("Survey");
		mainMenu.add("Test");
		mainMenu.add("Quit");

		surveyMenu = new ArrayList<String>();
		surveyMenu.add("Create");
		surveyMenu.add("Display");
		surveyMenu.add("Load");
		surveyMenu.add("Save");
		surveyMenu.add("Modify");
		surveyMenu.add("Take");
		surveyMenu.add("Tabulate");
		surveyMenu.add("Main Menu");

		testMenu = new ArrayList<String>();
		testMenu.add("Create");
		testMenu.add("Display");
		testMenu.add("Load");
		testMenu.add("Save");
		testMenu.add("Modify");
		testMenu.add("Take");
		testMenu.add("Tabulate");
		testMenu.add("Grade");
		testMenu.add("Main Menu");

		questionTypeMenu = new ArrayList<String>();
		questionTypeMenu.add("Add True or False Question");
		questionTypeMenu.add("Add Multiple Choice Question");
		questionTypeMenu.add("Add Essay Question");
		questionTypeMenu.add("Add Short Answer Question");
		questionTypeMenu.add("Add Ranking Question");
		questionTypeMenu.add("Add Matching Question");
		questionTypeMenu.add("Return to Questionnaire Menu");

	}

	// Main menu. Makes admin choose the type of Questionnaire they want or quit the
	// program.
	// Can handle wrong input type.
	public void mainMenu() throws IOException, ClassNotFoundException {
		int choice;

		io.getOutput().display("##################");

		io.getOutput().display("Select Questionnaire");
		for (int i = 0; i < mainMenu.size(); i++) {
			io.getOutput().display((i + 1) + ") " + mainMenu.get(i));
		}
		io.getOutput().display("##################");
		choice = io.getInput().getInputInt();

		switch (choice) {
		case 1:
			surveyMenu();
			break;
		case 2:
			testMenu();
			break;
		case 3:
			System.exit(0);
		default:
			io.getOutput().display("Your input did not match any of the choices! Please try again");
			this.mainMenu();
			break;
		}

	}

	// Survey menu. Makes admin choose what they want to do with a survey or return
	// to previous menu.
	// Can handle wrong input. Switch statement that will return the option the user
	// chose
	public void surveyMenu() throws ClassNotFoundException, IOException {
		Survey survey = new Survey();
		int choice;
		boolean menuLoop = true;

		io.getOutput().display("Survey Menu \n");

		while (menuLoop) {
			io.getOutput().display("##################");
			for (int i = 0; i < surveyMenu.size(); i++) {
				io.getOutput().display((i + 1) + ") " + surveyMenu.get(i));
			}

			choice = io.getInput().getInputInt();

			switch (choice) {
			case 1:
				if (survey.getName() == "") {
					io.getOutput().display("Suvery name: ");
					survey.setName(io.getInput().getUserInputString());
				}
				survey = questionMenu(survey);
				break;
			case 2:
				survey.display();
				break;
			case 3:
				survey = loadSurvey();
				break;
			case 4:
				saveMenu(survey);
				break;
			case 5:
				io.getOutput().display("You cannot edit right now!");
				break;
			case 6:
				io.getOutput().display("You cannot take it right now!");
//				survey = loadSurvey(); 
//				survey.take();
				break;
			case 7:
				io.getOutput().display("You cannot tabulate right now!");
//				survey.tabulate();
				break;
			case 8:
				mainMenu();
				break;
			default:
				io.getOutput().display("Your input did not match any of the choices! Please try again");
				this.surveyMenu();
				break;
			}

		}
	}

	// Test menu. Makes admin choose what they want to do with a survey or return to
	// previous menu.
	// Can handle wrong input. Switch statement that will return the option the user
	// chose
	public void testMenu() throws ClassNotFoundException, IOException {
		Test test = new Test();
		int choice;
		boolean menuLoop = true;

		io.getOutput().display("Test Menu \n");

		while (menuLoop) {
			io.getOutput().display("##################");
			for (int i = 0; i < testMenu.size(); i++) {
				io.getOutput().display((i + 1) + ") " + testMenu.get(i));
			}
			choice = io.getInput().getInputInt();

			switch (choice) {
			case 1:
				if (test.getName() == "") {
					io.getOutput().display("Test name: ");
					test.setName(io.getInput().getUserInputString());
				}
				questionMenu(test);

				break;
			case 2:
				test.display();
				break;
			case 3:
				test = loadTest();
				break;
			case 4:
				saveMenu(test);
				break;
			case 5:
				io.getOutput().display("You cannot edit right now!");
				break;
			case 6:
				io.getOutput().display("You cannot take a test right now!");
//				test = loadTest(); // serialize
//				test.take();
				break;
			case 7:
//				test.tabulate();
				io.getOutput().display("You cannot tabulate right now!");
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
				break;
			}
		}
	}

	// Question menu for the survey. Will instantiate a new question of the chosen
	// type and build it.
	public Survey questionMenu(Survey survey) throws NumberFormatException, IOException {
		boolean menuLoop = true;
		int choice;
		Questions q = null;

		io.getOutput().display("Question Menu");
		while (menuLoop) {
			for (int i = 0; i < questionTypeMenu.size(); i++) {
				io.getOutput().display((i + 1) + ") " + questionTypeMenu.get(i));
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
				q = new EssayQuestion();
				break;
			case 4:
				q = new ShortAnswerQuestion();
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

	// Question menu for the test. Will instantiate a new question of the chosen
	// type, build it and prompt for a correct answer.
	public Survey questionMenu(Test test) throws NumberFormatException, IOException {
		boolean menuLoop = true;
		int choice;

		Questions q = null;
		io.getOutput().display("Question Menu");
		while (menuLoop) {
			for (int i = 0; i < questionTypeMenu.size(); i++) {
				io.getOutput().display((i + 1) + ") " + questionTypeMenu.get(i));
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
				q = new EssayQuestion();
				break;
			case 4:
				q = new ShortAnswerQuestion();
				break;
			case 5:
				q = new RankingQuestion();
				break;
			case 6:
				q = new MatchingQuestion();
				break;
			case 7:
				return test;

			default:
				io.getOutput().display("Your input did not match any of the choices! Please try again");
				this.questionMenu(test);
			}
			test.createQuestion(q);
			q.buildQuestion();
			test.buildCorrectAnswer(q);
		}
		return test;
	}

	// Methods that call the serialization class to save or load a test or survey.
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
