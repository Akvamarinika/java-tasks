public class Main {
    public static void main(String[] args){
        Rect rect = new Rect(5.0);
        System.out.println(rect.areaCalculation());
        Rect rect2 = new Rect(2.0, 8.0);
        System.out.println(rect2.areaCalculation());
        Triangle triangle = new Triangle(3.0);
        System.out.println(triangle.areaCalculation());
        Triangle triangle2 = new Triangle(10,5,8);
        System.out.println(triangle2.areaCalculation());
    }
}
