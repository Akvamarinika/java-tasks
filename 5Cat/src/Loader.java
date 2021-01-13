/*TODO  Придумайте способ, который поможет проверить, жива ли кошка, на основе значения её веса.
   Используя это, запретите неживой кошке есть, пить, ходить в туалет,
   выполняя проверку веса внутри методов, которые изменяют вес кошки.

*/
public class Loader
{
    public static void main(String[] args)
    {
        System.out.println("Number of cats: " + Cat.getCount());
        Cat vaska = new Cat();
        Cat marsik = new Cat();
        Cat barsik = new Cat();
        Cat princess = new Cat();
        Cat murka = new Cat();
        System.out.println("Number of cats: " + Cat.getCount());

        System.out.println("Weight Vaska: " + vaska.getWeight());
        System.out.println("Weight Marsik: " + marsik.getWeight());
        System.out.println("Weight Barsik: " + barsik.getWeight());
        System.out.println("Weight Princess: " + princess.getWeight());
        System.out.println("Weight Murka: " + murka.getWeight() + '\n');

        System.out.println("Status Vaska: " + vaska.getStatus());
        System.out.println("Status Barsik: " + barsik.getStatus() + '\n');

        vaska.feed(100.0);
        barsik.feed(250.5);

        System.out.println("Weight Vaska: " + vaska.getWeight());
        System.out.println("Weight Barsik: " + barsik.getWeight() + '\n');
        System.out.println("Status Vaska: " + vaska.getStatus());
        System.out.println("Status Barsik: " + barsik.getStatus() + '\n');

        System.out.println("Status Murka: " + murka.getStatus());
        System.out.println("Status Murka: " + overfeedCat(murka) + '\n');
        murka.catDestroy();

        System.out.println("Status Marsik: " + marsik.getStatus());
        System.out.println("Status Marsik: " + overmeowCat(marsik) + '\n');
        marsik.catDestroy();

        barsik.pee();
        System.out.println("Weight Barsik: " + barsik.getWeight() + '\n');

        vaska.feed(150.0);
        barsik.feed(50.5);
        System.out.println("Smyakal Vaska: " + vaska.getSumFood() + " gr");
        System.out.println("Smyakal Barsik: " + barsik.getSumFood()  + " gr" + '\n');

        murka.pee();
        murka.drink(30.15);
        System.out.println("Status Murka: " + murka.getStatus() + '\n');

        marsik.feed(55.5);
        marsik.meow();
        System.out.println("Status Marsik: " + murka.getStatus() + '\n');

        System.out.println("Number of cats: " + Cat.getCount());
    }

    public static String overfeedCat(Cat cat){
        while (!cat.getStatus().equals("Exploded")){
            cat.feed(50.0);
        }
        return cat.getStatus();
    }

    public static String overmeowCat(Cat cat){
        while (!cat.getStatus().equals("Dead")){
            cat.meow();
        }
        return cat.getStatus();
    }

}

