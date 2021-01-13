
public class Cat
{
    private static int count;
    private final double originWeight;
    private double weight;

    private final double minWeight;
    private final double maxWeight;
    private double sumFood;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        sumFood = 0;
        count++;

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

    private boolean isAlive(){
        return (weight > minWeight) && (weight < maxWeight);
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
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
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