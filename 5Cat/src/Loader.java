/*TODO  1.	Создайте у класса Cat статическую переменную count, которая увеличивается на 1, если кошку создали, и убывает на 1, если кошка взорвалась или умерла.
        2.	Создайте статический метод getCount(), который возвращает количество кошек.


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

        vaska.feed(150.0);
        barsik.feed(50.5);

        System.out.println("Smyakal Vaska: " + vaska.getSumFood() + " gr");
        System.out.println("Smyakal Barsik: " + barsik.getSumFood()  + " gr" + '\n');

        murka.pee();
        System.out.println("Status Murka: " + murka.getStatus() + '\n');

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

