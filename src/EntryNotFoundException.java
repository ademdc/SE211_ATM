
public class EntryNotFoundException extends Exception {
	public EntryNotFoundException(){
		super("Entry not in database");
	}
	
	public EntryNotFoundException(String message){
		super(message);
	}
}
