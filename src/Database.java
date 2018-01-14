
import java.sql.*;

public class Database {
	private Connection myConn = null;
	private Statement myStmt = null;
	private ResultSet myRs = null;
	private double balance;
	private int id;
	
	public Database(int pin, int cardno){
		try{
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root" , "adem123");
			myStmt = myConn.createStatement();
			String sql = "select * from users";
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				int userpin = Integer.parseInt(myRs.getString("pin"));
				double useraccno = Double.parseDouble(myRs.getString("cardno"));
				
				if(pin==userpin && cardno==useraccno){
				balance = Double.parseDouble(myRs.getString("balance"));
				id = Integer.parseInt(myRs.getString("id"));
				
				}	
			}
			if(balance==0.0){
				checkDataIntegrity();
			}
			}catch(EntryNotFoundException e){
				System.out.println(e.getMessage());
				System.exit(0);
			}
		    catch(Exception exc){
				exc.printStackTrace();
			}
	
	}
	public double getBalance(){
		return balance;
	}
	
	public void updateBalance(double newBalance){
		try{
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root" , "adem123");
			myStmt = myConn.createStatement();
			myStmt.executeUpdate("update users set balance="+newBalance+" where id="+id);
			myRs = myStmt.executeQuery("select * from users where id="+id);
			System.out.println("Update complete.");
			}catch(Exception exc){
				exc.printStackTrace();
			}
	}
	
	public void checkDataIntegrity() throws EntryNotFoundException{
		throw new EntryNotFoundException();
	}
	

	
}
