import java.util.Scanner;
public class ATM {

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    System.out.println("Enter your account number:");
	    int accno = in.nextInt();

	    System.out.println("Enter your pin:");
	    int pin = in.nextInt();
	    
		Transactions obj = new Transactions(pin,accno);
	}

}
