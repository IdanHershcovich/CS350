
import java.util.ArrayList;

/**
 * 
 */
public class TextOutput extends Output {

   
	private static final long serialVersionUID = 3149175526896218052L;
	

    /**
     Implementation of Output abstract for "Text" data
     */
    public TextOutput() {
        // TODO implement here
    }

    /**
     Displays in the console
     */
    public void display(String output) {
        // TODO implement here
         System.out.println(output);
    }
    
    //Overload the display for ArrayLists
    public void display(ArrayList<String> outputArray)
    {
    	for(String text: outputArray) {
            System.out.println(text);
        }

    }

}