/**
 * 
 */
public class InputOutput implements java.io.Serializable {

    
	private static final long serialVersionUID = 7047043786352590310L;
	

	private Output output;
	private Input input;
	
	public InputOutput() {
         output = new TextOutput();
         input = new TextInput();
    }
	
	public Output getOutput() {
		return output;
	}
	public void setOutput(Output textOutput) {
		this.output = textOutput;
	}
	public Input getInput() {
		return input;
		
		
	}
	public void setInput(Input textInput) {
		this.input = textInput;
	}
    

}