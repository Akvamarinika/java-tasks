import java.lang.Math;
public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return 2 * Math.PI * Math.abs(radius);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return 4 / 3 * Math.PI * Math.abs(Math.pow(radius, 3));
    }

    public static boolean isTriangleRightAngled(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTriangleRightAngled(a, b, c)) {
            double perimeter = (a + b + c) / 2;
            return Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
        }

        return -1.0;
    }

}