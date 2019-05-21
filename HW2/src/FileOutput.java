import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * 
 */
public class FileOutput implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8507145894253666646L;

	/**
     * Default constructor
     */
    public FileOutput() {
    }

    /**
     * 
     */
    protected String filePath;

    /**
     * 
     */
    protected String fileName;

    /**
     * 
     */
    public void FileOutput() {
        // TODO implement here
    }

    /**
     * @param String name 
     * @param String Path 
     * @return
     */
    public Survey load(String filename){
		Survey s = new Survey();
		try {
	         FileInputStream fileIn = new FileInputStream(filename);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         s = (Survey) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return s;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return s;
	      }
		return s;
	}


    /**
     * @return
     */
    public String getFilePath() {
        // TODO implement here
        return "";
    }

    /**
     * @param String path 
     * @return
     */
    public void setFilePath( String path) {
        // TODO implement here
        
    }

}