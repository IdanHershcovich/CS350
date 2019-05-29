import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Serialization implements Serializable {

	/**
	 * Serialization methods to save and load surveys
	 */
	private static final long serialVersionUID = -59489478949289396L;
	protected String relativePath;
	protected InputOutput io;
	protected String surveyName;
	protected String path;

	// Constructor class. Initializes the folder path, io surveyName and the
	// filePath
	public Serialization() {
		relativePath = "surveys";
		io = new InputOutput();
		surveyName = "";
		path = "";
	}

	// Saves a survey and creates the directory in which to save the survey.
	protected void save(Survey survey) throws IOException {

		surveyName = survey.getName();

		path = relativePath + "/" + surveyName + "/";
		File filePath = new File(path);
		filePath.mkdirs();

		try {
			path = relativePath + "/" + surveyName + "/" + surveyName + ".ser";
			File file = new File(path);
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(survey);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	//Saves answers to a file in the same directory as the survey.
	protected void saveAnswers(ArrayList<ResponseCorrectAnswer> userResponses, String surveyName, String userName) {
		String path;
		String filePath = relativePath + "/" + surveyName + "/";
		int numFiles = new File(filePath).list().length - 1;

		try {
			path = relativePath + "/" + surveyName + "/" + surveyName + "_" + userName + "_answer_" + numFiles + ".ser";
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(userResponses);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	// Loads the survey from the folder given by the relative path. Displays all of
	// the files in the
	// folder and then the user chooses
	protected Survey load() throws NumberFormatException, IOException {
		Survey survey = null;
		int choice;
		String name;
		File folder = new File(relativePath);
		File[] listOfFiles = folder.listFiles(File::isDirectory);

		for (int i = 0; i < listOfFiles.length; i++) {
			choice = i + 1;
			io.getOutput().display(choice + ") " + listOfFiles[i].getName());
		}

		choice = io.getInput().getInputInt();
		while (choice > listOfFiles.length || choice <= 0) {

			io.getOutput().display("Please enter a correct choice!");
			choice = io.getInput().getInputInt();
		}

		name = relativePath + "/" + listOfFiles[choice - 1].getName() + "/" + listOfFiles[choice - 1].getName()
				+ ".ser";
		try {
			FileInputStream fileIn = new FileInputStream(name);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			survey = (Survey) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("class not found");
			c.printStackTrace();
		}
		survey.filePath = relativePath + "/" + listOfFiles[choice - 1].getName();
		return survey;
	}

	//Returns the files of a test/survey that contain the word "answers" to be selected by the user.
	public ArrayList<ResponseCorrectAnswer> loadAnswers(String surveyName,  String filePath) throws NumberFormatException, IOException {
		int choice;
		String name;
		ArrayList<ResponseCorrectAnswer> userAnswers = null;
		relativePath = filePath;
		File folder = new File(relativePath);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].getName().toLowerCase().contains("answer")) {
				choice = i + 1;
				io.getOutput().display(choice + ") " + listOfFiles[i].getName());
			}

		}
		
		if(listOfFiles.length <= 1) {
			io.getOutput().display("No answers yet! \n");
		}
		else {
			io.getOutput().display("Select set of Answers");
			choice = io.getInput().getInputInt();
			while (choice > listOfFiles.length || choice <= 0) {
	
				io.getOutput().display("Please enter a correct choice!");
				choice = io.getInput().getInputInt();
			}
	
			name = relativePath + "/" + listOfFiles[choice - 1].getName();
			try {
				FileInputStream fileIn = new FileInputStream(name);
				ObjectInputStream in = new ObjectInputStream(fileIn);
	
				userAnswers = (ArrayList<ResponseCorrectAnswer>) in.readObject();
				in.close();
				fileIn.close();
			} catch (IOException i) {
				i.printStackTrace();
			} catch (ClassNotFoundException c) {
				System.out.println("class not found");
				c.printStackTrace();
			}
		}
		return userAnswers;
	}
	
	//returns all answers in an array list of arraylists of RCAs from the folder of a test or survey.
	public ArrayList<ArrayList<ResponseCorrectAnswer>> loadAllAnswers( String filePath) throws NumberFormatException, IOException {
		relativePath = filePath;
		File folder = new File(relativePath);
		File[] listOfFiles = folder.listFiles();
		ArrayList<ResponseCorrectAnswer> responses = null;
		ArrayList<ArrayList<ResponseCorrectAnswer>> allResponses = new ArrayList<ArrayList<ResponseCorrectAnswer>>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].getName().toLowerCase().contains("answer")) {
				String name = relativePath + "/" + listOfFiles[i].getName();
				try {
					FileInputStream fileIn = new FileInputStream(name);
					ObjectInputStream in = new ObjectInputStream(fileIn);
	
					responses = (ArrayList<ResponseCorrectAnswer>) in.readObject();
					allResponses.add(responses);
					in.close();
					fileIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException c) {
					System.out.println("class not found");
					c.printStackTrace();
				}
			}
		}
		return allResponses;
	}
}


