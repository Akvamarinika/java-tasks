public class Mouse extends Product{
    boolean game;
    int permission;
    int numberOfButtons;

    public Mouse(String name, int quantity, double price, boolean game, int permission, int numberOfButtons) {
        super(name, quantity, price);
        this.game = game;
        this.permission = permission;
        this.numberOfButtons = numberOfButtons;
    }

}
