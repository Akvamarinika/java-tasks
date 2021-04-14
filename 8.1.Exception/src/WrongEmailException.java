public class WrongEmailException extends RuntimeException{
    private String email;
    public WrongEmailException(String email, String message){
        super(message);
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
}
