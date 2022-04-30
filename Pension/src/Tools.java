public class Tools {

	/**
	 * envoie le texte de l'input dans la console
	 * @param text à érire dans la console 
	 * 
	 */
	  static void print(String input) {
		    System.out.println(input);
		  }
	  static void print(int input) {
		    System.out.println(""+input);
		  }
	
	
	  /**
	   * @
	   * @return il retourne 0
	   */
	  static int getLigne()
	  {
	    	int currentLine = new Throwable().getStackTrace()[0].getLineNumber();
	    	Tools.print("["+currentLine+"]");
	    	return currentLine;
	  }

	 
	  
	  
	  
	  
	  
	  
	  
}

