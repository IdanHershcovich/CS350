import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 */
public class FileInput implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1487082683413889876L;

	/**
     * Default constructor
     */
    public FileInput() {
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
    public void FileInput() {
        // TODO implement here
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

    /**
     * @param String name 
     * @return
     */
    public void setFileName( String name) {
        // TODO implement here
       
    }

    /**
     * @return
     */
    public String getFileName() {
        // TODO implement here
        return "";
    }

    /**
     * @param String path 
     * @param String name 
     * @return
     */
    public void save(Survey obj,String filename){
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream(filename);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(obj);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}

}