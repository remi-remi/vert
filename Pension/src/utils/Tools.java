package utils;

public abstract class Tools {

	/**
	 * envoie le texte de l'input dans la console
	 * @param text à érire dans la console 
	 * 
	 */
	  public static void echo(String input) {
		    System.out.println(input);
		  }
	  public static void echo(int input) {
		    System.out.println(""+input);
		  }
	  
	  public static void redcho(String input) {
		    System.err.println(input);
		  }
	  public static void redcho(int input) {
		    System.err.println(""+input);
		  }
	  
	  
	  
	
	
	  /**
	   * @
	   * @return il retourne 0
	   */
	  static int getLigne()
	  {
	    	int currentLine = new Throwable().getStackTrace()[0].getLineNumber();
	    	Tools.echo("["+currentLine+"]");
	    	return currentLine;
	  }

	 
	  
	  
	  
	  
	  
	  
	  
}

