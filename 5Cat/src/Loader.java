/*TODO  1.	Создайте в классе Cat метод, который возвращает сумму съеденной еды текущей кошки.
        2.	Создайте в классе Cat метод «Сходить в туалет» pee(), который уменьшает вес кошки и что-нибудь печатает.

*/
public class Loader
{
    public static void main(String[] args)
    {
        Cat vaska = new Cat();
        Cat marsik = new Cat();
        Cat barsik = new Cat();
        Cat princess = new Cat();
        Cat murka = new Cat();

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

        System.out.println("Status Murka: " + murka.getStatus());
        System.out.println("Status Murka: " + overfeedCat(murka) + '\n');

        System.out.println("Status Marsik: " + marsik.getStatus());
        System.out.println("Status Marsik: " + overmeowCat(marsik) + '\n');

        vaska.feed(150.0);
        barsik.feed(50.5);

        System.out.println("Smyakal Vaska: " + vaska.getSumFood() + " gr");
        System.out.println("Smyakal Marsik: " + barsik.getSumFood()  + " gr" + '\n');

        murka.pee();
        System.out.println("Status Murka: " + murka.getStatus());
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

