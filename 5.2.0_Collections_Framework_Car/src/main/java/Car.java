import java.util.Objects;

public class Car implements Comparable<Car>{
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
        this.number = (int) Math.round(Math.random() * 9999999 + 100000);
    }

    public Enum<Brands> getBrand() {
        return brand;
    }

    public Enum<Colors> getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("Brand: %10s \t Color: %7s \t Number: %8s\n", brand, color, number);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return number == car.number &&
                brand == car.brand &&
                Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, number);
    }

    @Override
    public int compareTo(Car car) {
        int result = this.brand.toString().compareTo(car.brand.toString());
        if (result == 0){
            result = this.color.toString().compareTo(car.color.toString());
        }
        if (result == 0){
            result = this.number - car.number;
        }

        return result;
    }
}
