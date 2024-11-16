package plus.cws.admin.module.common.exception;

public class AuthException extends RuntimeException{

    private String message;
    public AuthException(String message){
        super(message);
        this.message = message;
    }
}
