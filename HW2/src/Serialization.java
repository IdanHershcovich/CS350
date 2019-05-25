import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization implements Serializable{
	
	/**
	 Serialization methods to save and load surveys
	 */
	private static final long serialVersionUID = -59489478949289396L;
	protected String relativePath;
	protected InputOutput io;
	protected String surveyName;
	protected String path;
	
	//Constructor class. Initializes the folder path, io surveyName and the filePath
	public Serialization() {
		relativePath = "surveys";
		io = new InputOutput();
		surveyName = "";
		path = "";
		
	}
	//Saves a survey and creates the directory in which to save the survey.
	protected void save(Survey survey) throws IOException {
		io.getOutput().display("Please enter a name for this file: ");
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
			io.getOutput().display("Saved in " + relativePath + "/" + surveyName);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	//Loads the survey from the folder given by the relative path. Displays all of the files in the
	//folder and then the user chooses
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
		
		choice = Integer.parseInt(io.getInput().getUserInputString());

		name = relativePath + "/" + listOfFiles[choice - 1].getName() + "/" + listOfFiles[choice - 1].getName() + ".ser";
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

	
	
}
