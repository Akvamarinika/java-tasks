package type.workers;

import interfaces.Cookable;


public class Cook extends Worker implements Cookable {
    public Cook(String name){
        super(name);
    }

    @Override
    public void cook() {
        System.out.println("Готовит");
    }
}
