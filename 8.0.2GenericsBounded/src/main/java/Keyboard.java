public class Keyboard extends Product{
    Boolean multimedia;
    Boolean mechanical;
    Boolean backlight;

    public Keyboard(String name, int quantity, double price, Boolean multimedia, Boolean mechanical, Boolean backlight) {
        super(name, quantity, price);
        this.multimedia = multimedia;
        this.mechanical = mechanical;
        this.backlight = backlight;
    }
}
