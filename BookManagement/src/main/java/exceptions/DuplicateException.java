package exceptions;

public class DuplicateException extends Exception{
    public DuplicateException(){
        super("Already exists");
    }

}
