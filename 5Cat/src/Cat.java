
public class Cat
{
    private static int count;
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
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

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        this.amountOfFoodEaten(amount);
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
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

    public void pee(){
        weight -= 50;
        System.out.println("Cat went to the toilet...");
    }

}