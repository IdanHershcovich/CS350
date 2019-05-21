import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest extends Serialization {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5067335843701878545L;
	/**
	 * 
	 */
	private String relativePath = "tests";
	
	protected void save(Test test) throws IOException {
		String testName, path;
		io.getOutput().display("Please enter a name for this file: ");
		testName = io.getInput().getUserInputString();
		File newDir = new File(relativePath + "/" + test);
		newDir.mkdir();
		path = relativePath + "/" + test + "/" + test + ".ser";
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(test);
			out.close();
			fileOut.close();
			io.getOutput().display("Saved in " + relativePath + "/" + test);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	protected Test load() throws IOException {
		Test test = new Test();
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
		         test = (Test) in.readObject();
		         in.close();
		         fileIn.close();
		      } catch (IOException i) {
		         i.printStackTrace();
		      } catch (ClassNotFoundException c) {
		         System.out.println("class not found");
		         c.printStackTrace();
		      }
		test.filePath = relativePath + "/" + listOfFiles[choice - 1].getName();
		return test;
	}
}