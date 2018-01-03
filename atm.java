import java.util.Scanner;
import java.util.Locale;
import java.util.ResourceBundle;

public class atm{
 
    private static Scanner in; 
    private static float balance = 0; // initial balance to 0 for everyone
    private static int anotherTransaction;
 
    public static void main(String args[]){
        in = new Scanner(System.in);
        
        ResourceBundle bundle = chooseLanguage();
        System.out.println(bundle.getString("option")); 
        System.out.println(bundle.getString("withdraw"));
        System.out.println(bundle.getString("deposit"));
        System.out.println(bundle.getString("balance"));
        // call our transaction method here 
        transaction(bundle);
    }
 
    private static void transaction(ResourceBundle bundle2){
        // here is where most of work is
        int choice; 

        choice = in.nextInt();
 
        switch(choice){
            case 1:
                float amount; 
                System.out.println("Please enter amount to withdraw: "); 
                amount = in.nextFloat();
                if(amount > balance || amount == 0){
                    System.out.println("You have insufficient funds\n\n"); 
                    anotherTransaction(); // ask if they want another transaction
                } else {
                    // they have some cash
                    // update balance 
                    balance = balance - amount; 
                    System.out.println("You have withdrawn "+amount+" and your new balance is "+balance+"\n");
                    anotherTransaction(); 
                }
            break; 
 
            case 2:
                // option number 2 is depositing 
                float deposit; 
                System.out.println("Please enter amount you would wish to deposit: "); 
                deposit = in.nextFloat();
                // update balance 
                balance = deposit + balance;
                System.out.println("You have deposited "+deposit+" new balance is "+balance+"\n");
                anotherTransaction();
            break; 
 
            case 3:
                // this option is to check balance 
                System.out.println("Your balance is "+balance+"\n");
                anotherTransaction(); 
            break;
 
            default:
                System.out.println("Invalid option:\n\n"); 
                anotherTransaction();
            break;
        }
 
    }
 
    private static void anotherTransaction(){
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
            transaction(); // call transaction method
        } else if(anotherTransaction == 2){
            System.out.println("Thanks for choosing us. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
    
    private static ResourceBundle chooseLanguage(){
    	
    	int pick;
    	System.out.println("Choose language: 1. Bosanski 2. English 3. German \n\n");
    	Scanner sc = new Scanner(System.in);
        pick = sc.nextInt();
        String lang;
        String country;
    	switch(pick){
    	case 1:
    		 lang = "bs";
    		 country="BS";
    		break;
    	case 2:
    		 lang = "en";
    		 country="US";
    		break;
    	case 3:
    		 lang = "ge";
    		 country="GE";
    		break;
    	default:
    		System.out.println("Invalid, default language choosen \n\n");	
    		 lang = "bs";
    		 country="BS";
    	}
    		
		Locale l = new Locale(lang,country);
	    ResourceBundle r = ResourceBundle.getBundle("languages/config",l);
		
		String str = r.getString("wish");
		System.out.println(str);
		return r;
    }
}