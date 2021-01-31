public class Car {
    private Enum brand;
    private Enum color;
    private int number;

    public Car(Enum brand, Enum color, int number){
        this.brand = brand;
        this.color = color;
        this.number = number;
    }

    public Car(){
        int rndBrandIndex = (int)Math.round(Math.random() * Brands.values().length);
        int rndColorIndex = (int)Math.round(Math.random() * Colors.values().length);
        this.brand = Brands.values()[rndBrandIndex];
        this.color = Colors.values()[rndColorIndex];
        this.number = (int) Math.round(Math.random() * 999999 + 10000);
    }
}
