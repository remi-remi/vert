package utils;

import static utils.Tools.echo;
import static utils.Tools.redcho;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
	  
	  
	  ///Adrien(fileChooser.getSelectedFile());
		public byte[] Adrien(File fichier) {
			try {
				byte[] fileContent = Files.readAllBytes(fichier.toPath());
				for (int i : fileContent) {
					echo("le fichier content "+fileContent.length+" bytes");
					return fileContent;
				}
			} catch (IOException e1) {
				redcho("oh non impossible d'en faire des bytes !!!");
				
			}
			return null;
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

