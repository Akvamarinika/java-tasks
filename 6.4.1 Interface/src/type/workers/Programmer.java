package type.workers;

import interfaces.Programmable;

public class Programmer extends Worker implements Programmable {
    public  Programmer(String name){
        super(name);
    }

    @Override
    public void program() {
        System.out.println("Программирует");
    }
}
