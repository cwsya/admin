package plus.cws.admin.common.exception;

public class LoginException extends RuntimeException{
    private String message;
    public LoginException(String message){
        super(message);
        this.message = message;
    }
}
