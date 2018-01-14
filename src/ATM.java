import java.util.InputMismatchException;
import java.util.Scanner;
public class ATM {

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    int accno=0,pin=0;
	    
	    try{
	    	System.out.println("Enter your account number:");
		     accno = in.nextInt();

		    System.out.println("Enter your pin:");
		     pin = in.nextInt();
	    }
	    catch (InputMismatchException ex )
	    { 
	      System.out.println("You entered bad data." );
	      System.out.println("Run the program again." );
	      return;
	    } 
	    
		Transactions obj = new Transactions(pin,accno);
	}

}
