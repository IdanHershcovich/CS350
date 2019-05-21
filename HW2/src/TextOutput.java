
import java.util.ArrayList;

/**
 * 
 */
public class TextOutput extends Output {

   
	private static final long serialVersionUID = 3149175526896218052L;
	

    /**
     * 
     */
    public TextOutput() {
        // TODO implement here
    }

    /**
     */
    public void display(String output) {
        // TODO implement here
         System.out.println(output);
    }
    
    public void display(ArrayList<String> outputArray)
    {
    	for(String text: outputArray) {
            System.out.println(text);
        }

    }

}