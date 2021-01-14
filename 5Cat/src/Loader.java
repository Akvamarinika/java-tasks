/*TODO  1.	Сделайте в классе Cat ещё один конструктор, чтобы можно было создать кошку с весом, переданным в конструктор.
        2.	Создайте в главном классе Loader метод генерации котёнка private static Cat getKitten().
        Он должен возвращать кошку с весом 1100.00 грамм с помощью конструктора, в который передаём вес кошки.
        3.	Создайте три объекта класса Cat в методе main(), используя метод getKitten().

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
        Cat kitten;
        Cat kitten2;
        Cat kitten3;

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

        System.out.println("Number of cats: " + Cat.getCount() + '\n');

        vaska.setColor(Colors.FAWN);
        marsik.setColor(Colors.CREAM);
        barsik.setColor(Colors.GINGER);
        princess.setColor(Colors.BLUE_POINT);
        murka.setColor(Colors.FAWN);
        System.out.println("Color Vaska: " + vaska.getColor() );
        System.out.println("Color Marsik: " + marsik.getColor());
        System.out.println("Color Barsik: " + barsik.getColor());
        System.out.println("Color Princess: " + princess.getColor());
        System.out.println("Color Murka: " + murka.getColor() + '\n');

        System.out.println("Breed Vaska: " + vaska.getBreed() + " " + vaska.getBreed().rusName());
        System.out.println("Breed Marsik: " + marsik.getBreed() + " " + marsik.getBreed().rusName());
        System.out.println("Breed Barsik: " + barsik.getBreed() + " " + barsik.getBreed().rusName());
        System.out.println("Breed Princess: " + princess.getBreed() + " " + princess.getBreed().rusName());
        System.out.println("Breed Murka: " + murka.getBreed() + " " + murka.getBreed().rusName() + '\n');

        Cat persik = new Cat(2500.0);
        System.out.println("Breed Persik: " + persik.getBreed());
        System.out.println("Color Persik: " + persik.getColor());
        System.out.println("Weight Persik: " + persik.getWeight()  + '\n');

        kitten = getKitten();
        System.out.println("Breed kitten: " + kitten.getBreed());
        System.out.println("Color kitten: " + kitten.getColor());
        System.out.println("Weight kitten: " + kitten.getWeight()   + '\n');

        kitten2 = getKitten();
        System.out.println("Breed kitten2: " + kitten2.getBreed());
        System.out.println("Color kitten2: " + kitten2.getColor());
        System.out.println("Weight kitten2: " + kitten2.getWeight()   + '\n');

        kitten3 = getKitten();
        System.out.println("Breed kitten3: " + kitten3.getBreed());
        System.out.println("Color kitten3: " + kitten3.getColor());
        System.out.println("Weight kitten3: " + kitten3.getWeight()   + '\n');



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

    private static Cat getKitten(){
        return new Cat(1100.00);

    }

}

