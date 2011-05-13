package some.pack;

public class InvalidSquareException extends Exception {
    
    public InvalidSquareException(){
    }
    
    public InvalidSquareException(String msg) {
        super(msg);
    }
}