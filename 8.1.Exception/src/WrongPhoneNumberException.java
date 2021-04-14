public class WrongPhoneNumberException extends RuntimeException{
    private String phone;
    public WrongPhoneNumberException(String phone, String message){
        super(message);
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }
}
