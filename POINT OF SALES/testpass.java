import java.io.*;
import java.util.*;


public class testpass{
	public static void main(String [] argx) throws IOException{
	Console console = System.console();
        System.out.println("Reading input from console using Console in Java6 ");
        System.out.println("Please enter your input: ");
        String input = console.readLine();
        System.out.println("User Input from console: " + input);
        System.out.println("Reading password from Console in Java: ");
      
        //password will not be echoed to console and stored in char array
        char[] password = console.readPassword();
        System.out.println("Password entered by user: " + new String(password));
	}

}