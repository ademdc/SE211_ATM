import java.util.Scanner;
import java.util.Locale;
import java.util.ResourceBundle;

public class Transactions {
	private  Scanner in; 
    private  double balance; // initial balance to 0 for everyone
    private  int anotherTransaction;
    private  ResourceBundle r;
    private Database db;

 
    public Transactions(int pin, int accno){
        in = new Scanner(System.in);
        r = chooseLanguage();
        db = new Database(pin,accno);
        balance = db.getBalance();
        transaction();
    }
 
    private  void transaction(){
        // here is where most of work is
 
        int choice; 
 
        System.out.println(r.getString("option")); 
        System.out.println(r.getString("withdraw"));
        System.out.println(r.getString("deposit"));
        System.out.println(r.getString("balance"));
 
        choice = in.nextInt();
 
        switch(choice){
            case 1:
                float amount; 
                System.out.println(r.getString("amount")); 
                amount = in.nextFloat();
                if(amount > balance || amount == 0){
                    System.out.println(r.getString("insufficient")); 
                    anotherTransaction(); // ask if they want another transaction
                } else {
                    // they have some cash
                    // update balance 
                    balance = balance - amount; 
                    System.out.println(r.getString("withdrawn")+amount+r.getString("newbalance")+balance+"\n");
                    anotherTransaction(); 
                }
            break; 
 
            case 2:
                // option number 2 is depositing 
                float deposit; 
                System.out.println(r.getString("amounttodeposit")); 
                deposit = in.nextFloat();
                // update balance 
                balance = deposit + balance;
                System.out.println(r.getString("deposited")+deposit+r.getString("newbalance2")+balance+"\n");
                anotherTransaction();
            break; 
 
            case 3:
                // this option is to check balance 
                System.out.println(r.getString("newbalance3")+balance+"\n");
                anotherTransaction(); 
            break;
 
            default:
                System.out.println(r.getString("invalid")+"\n\n"); 
                anotherTransaction();
            break;
        }
 
    }
 
    private  void anotherTransaction(){
        System.out.println(r.getString("anothertransaction"));
        anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
            transaction(); // call transaction method
        } else if(anotherTransaction == 2){
            System.out.println(r.getString("thanks"));
            db.updateBalance(balance);
        } else {
            System.out.println(r.getString("invalid"));
            anotherTransaction();
        }
    }
    
    private ResourceBundle chooseLanguage(){
    	int pick;
    	System.out.println("Choose language:\n\t1. Bosanski \n\t2. English \n\t3. German \n");
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
    		 lang = "en";
    		 country="US";
    		 break;
    	}
    		
		Locale l = new Locale(lang,country);
		ResourceBundle bundle = ResourceBundle.getBundle("languages/config",l);
		return bundle;
    }
}
