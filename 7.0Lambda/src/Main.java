public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        director.force(new Worker(){
            @Override
            public void work(){
                System.out.println("Working...");
            }
        }, 5);

        System.out.println("\n");
        String result = director.force(() -> System.out.println("Working..."), 5);
        System.out.println(result);
    }
}
