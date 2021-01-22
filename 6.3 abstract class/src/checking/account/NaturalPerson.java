package checking.account;

public class NaturalPerson extends Client {

    public NaturalPerson(double balance){
        super(balance);
    }

    @Override
    public String toString(){
        return "Физическое лицо: пополнение и снятие происходит без комиссии. ";
    }
}
