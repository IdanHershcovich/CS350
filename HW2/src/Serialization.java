import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

///**
// * 
// */
//public class Serialization {
// 
//    /**
//     * Default constructor
//     */
//    public Serialization() {
//    }
// 
//    /**
//     * @param String name 
//     * @param Object obj
//     */
//    public void saveFile( String name,  Object obj) {
//        // TODO implement here
//    }
//
//    /** 
//     * 
//     */
//    public void load() {
//        // TODO implement here
//    }
//
//}


public class Serialization implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -59489478949289396L;
	protected String relativePath = "surveys";
	protected InputOutput io = new InputOutput();
	
	public Serialization() {
	
	}
	protected void save(Survey survey) throws IOException {
		String surveyName, path;
		io.getOutput().display("Please enter a name for this file: ");
		String name = io.getInput().getUserInputString();

		new File(relativePath + "/" + name).mkdir();
		path = relativePath + "/" + name + "/" + name + ".ser";
		
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(survey);
			out.close();
			fileOut.close();
			io.getOutput().display("Saved in " + relativePath + "/" + name);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
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
	
	protected void saveAnswers(String[] arr, String filePath) {
		String path;
		int numFiles = new File(filePath).list().length;
		path = filePath + "/answers" + Integer.toString(numFiles) + ".ser";
	
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(arr);
			out.close();
			fileOut.close();
			io.getOutput().display("Saved in " + path);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	
}
