public class Car {
    private Enum<Brands> brand;
    private Enum<Colors> color;
    private int number;

    public Car(Enum<Brands> brand, Enum<Colors> color, int number){
        this.brand = brand;
        this.color = color;
        this.number = number;
    }

    public Car(){
        int rndBrandIndex = (int)Math.round(Math.random() * (Brands.values().length-1));
        int rndColorIndex = (int)Math.round(Math.random() * (Colors.values().length-1));
        this.brand = Brands.values()[rndBrandIndex];
        this.color = Colors.values()[rndColorIndex];
        this.number = (int) Math.round(Math.random() * 999999 + 100000);
    }

    @Override
    public String toString() {
       /* int spaceNum = Brands.ALFA_ROMEO.toString().length() - brand.toString().length();
        int spaceNum2 = Colors.CHERRY.toString().length() - color.toString().length();*/
        return String.format("Brand: %10s \t Color: %7s \t Number: %8s\n", brand, color, number);
    }

}
