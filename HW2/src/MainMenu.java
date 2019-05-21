//import java.io.IOException;
//import java.util.ArrayList;
//
//public class MainMenu extends Menu {
//	
//	InputOutput io;
//	public MainMenu() {
//		io = new InputOutput();
//		selectedOption = 0;
//		choices = new ArrayList<String>();
//		choices.add("Survey ");
//		choices.add("Test ");
//		choices.add("Quit ");
//
//
//	}
//
//	
//	 public void chooseQuestionnaire() throws IOException {
//	    this.getChoices();
//	    	
//		 while(String.valueOf(selectedOption).toLowerCase() != "quit") {
//	    	switch(selectedOption) {
//	    	case 1: 
//	    		break;
//	    	
//	    	case 2: 
//	    		break;
//	    				
//	    	}	
//	    }
//		 System.exit(0);
//	 }
//	 
//	 public int getChoices() throws IOException {
//		 while(io.getInput().br.readLine() != null) {
//			 selectedOption = Integer.parseInt(io.getInput().getUserInputString());
//		 }
//		 return selectedOption;
//	 }
//}
