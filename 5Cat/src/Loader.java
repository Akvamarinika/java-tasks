/*TODO  1.	Выведите в консоль вес созданных кошек.
        2.	Покормите двух кошек, после этого распечатайте их вес (убедитесь, что вес изменился).
        3.	Перекормите кошку, чтобы ее статус стал Exploded.
        4.	«Замяукайте» кошку до статуса Dead.
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
        System.out.println("Status Marsik: " + overmeowCat(marsik));

    }

    public static String overfeedCat(Cat cat){
        while (!cat.getStatus().equals("Exploded")){
            cat.feed(200.0);
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

