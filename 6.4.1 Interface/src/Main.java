import interfaces.Cookable;
import interfaces.Drivable;
import interfaces.Programmable;
import type.workers.Cook;
import type.workers.Driver;
import type.workers.Programmer;
import type.workers.Worker;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Cook cook1 = new Cook("Andrei");
        Cook cook2 = new Cook("Petr");
        Cook cook3 = new Cook("Alex");

        Driver driver1 = new Driver("Fedor");
        Driver driver2 = new Driver("Ivan");
        Driver driver3 = new Driver("Aleksandr");

        Programmer programmer1 = new Programmer("Artem");
        Programmer programmer2 = new Programmer("Victor");
        Programmer programmer3 = new Programmer("Mike");

        ArrayList<Worker> workerArray = new ArrayList<>();
        workerArray.add(cook1);
        workerArray.add(cook2);
        workerArray.add(cook3);
        workerArray.add(driver1);
        workerArray.add(driver2);
        workerArray.add(driver3);
        workerArray.add(programmer1);
        workerArray.add(programmer2);
        workerArray.add(programmer3);
        for (Worker worker : workerArray){
            worker.voice();
        }

        ArrayList<Programmable> programmersArray = new ArrayList<>();
        programmersArray.add(programmer1);
        programmersArray.add(programmer2);
        programmersArray.add(programmer3);
        for (Programmable programmer : programmersArray){
            programmer.program();
        }

        ArrayList<Cookable> cooksList = new ArrayList<>();
        cooksList.add(cook1);
        cooksList.add(cook2);
        cooksList.add(cook3);
        for (Cookable cook : cooksList){
            cook.cook();
        }

        ArrayList<Drivable> driversList = new ArrayList<>();
        driversList.add(driver1);
        driversList.add(driver2);
        driversList.add(driver3);
        for (Drivable driver : driversList){
            driver.drive();
        }
    }
}
