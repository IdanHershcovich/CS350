import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest extends Serialization {
	/**
	 Serialization for test. Very similar to the regular serialization, but for the Test object and with the appropriate paths
	 */
	private static final long serialVersionUID = 5067335843701878545L;
	/**
	 * 
	 */
	protected String relativePath;
	protected InputOutput io;
	protected String testName;
	protected String path;
	
	public SerializeTest() {
		relativePath = "tests";
		io = new InputOutput();
		testName = "";
		path = "";
	}
	
	protected void save(Test test) throws IOException {
		io.getOutput().display("Please enter a name for this file: ");
		testName = test.getName();

		path = relativePath + "/" + testName + "/";
		File filePath = new File(path);
		filePath.mkdirs();

		
		try {
			path = relativePath + "/" + testName + "/" + testName + ".ser";
			File file = new File(path);
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(test);
			out.close();
			fileOut.close();
			io.getOutput().display("Saved in " + relativePath + "/" + testName);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	protected Test load() throws IOException {
		Test test = null;
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