public class NotFoundUserException extends RuntimeException {
    private String user;
    public NotFoundUserException(String user, String message){
        super(message);
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
