
public class Cat
{
    private static final int COUNTS_EYES = 2;
    private final double MIN_WEIGHT;
    private final double MAX_WEIGHT;
    private final double originWeight;
    private static int count;
    private double weight;
    private double sumFood;
    private Colors color;
    private Breeds breed;

    public Cat()
    {
        int idx = (int)Math.round(((Breeds.values().length - 1) * Math.random()));
        int idxColor = (int) Math.round((Colors.values().length - 1) * Math.random());
        breed = Breeds.values()[idx];
        color = Colors.values()[idxColor];
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        MIN_WEIGHT = 1000.0;
        MAX_WEIGHT = 9000.0;
        sumFood = 0;
        count++;
    }

    public Cat(double weight){
        this();
        this.weight = weight;

    }

    public static int getCount(){
        return count;
    }

    public  void catDestroy(){
        if (this.getStatus().equals("Dead") || this.getStatus().equals("Exploded") ){
            count--;
        }

    }

    public Double getWeight()
    {
        return weight;
    }

    public Double getSumFood(){
        return sumFood;
    }

    public Breeds getBreed(){
        //breed.printRusName();
        return breed;
    }

    public void setColor(Colors color){
        this.color = color;
    }

    public Colors getColor(){
        return  color;
    }

    private boolean isAlive(){
        return (weight > MIN_WEIGHT) && (weight < MAX_WEIGHT);
    }

    public void meow()
    {
        if (isAlive()){
            weight = weight - 1;
            System.out.println("Meow");
        } else {
            System.out.println("Cat can't meow. This cat dead or exploded");
        }

    }

    public void feed(Double amount)
    {
        if (isAlive()){
            weight = weight + amount;
            this.amountOfFoodEaten(amount);
        } else {
            System.out.println("Cat can't feed. This cat dead or exploded");
        }

    }

    public void drink(Double amount)
    {
        if (isAlive()){
            weight = weight + amount;
        } else {
            System.out.println("Cat can't drink. This cat dead or exploded");
        }

    }

    public void pee(){
        if (isAlive()){
            weight -= 50;
            System.out.println("Cat went to the toilet...");
        } else {
            System.out.println("Cat can't pee. This cat dead or exploded");
        }

    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    private Double amountOfFoodEaten(Double amount){
        sumFood = sumFood + amount;
        return sumFood;
    }



}