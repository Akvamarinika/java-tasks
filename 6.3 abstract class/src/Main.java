import checking.account.IndividualEntrepreneur;
import checking.account.LegalEntity;
import checking.account.NaturalPerson;

public class Main {
    public static void main(String[] args){
        NaturalPerson naturalPerson = new NaturalPerson(100);
        System.out.println(naturalPerson);
        naturalPerson.toDeposit(50);
        naturalPerson.withdraw(30);

        LegalEntity legalEntity = new LegalEntity(5000);
        System.out.println(legalEntity);
        legalEntity.toDeposit(1000);
        legalEntity.withdraw(2500);

        IndividualEntrepreneur individualEntrepreneur = new IndividualEntrepreneur(1000);
        System.out.println(individualEntrepreneur);
        individualEntrepreneur.toDeposit(500);
        individualEntrepreneur.toDeposit(1200);
        individualEntrepreneur.withdraw(1000);

        
    }
}
