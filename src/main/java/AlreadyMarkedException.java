package some.pack;

public class AlreadyMarkedException extends Exception {
    
    public AlreadyMarkedException(){
    }
    
    public AlreadyMarkedException(String msg) {
        super(msg);
    }
}