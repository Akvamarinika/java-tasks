public class Triangle extends Figure {
    private double c;

    public Triangle(double a, double b, double c){
        super(a, b);
        this.c = c;
    }
    public Triangle(double size){
        super(size, size);
        this.c = size;
    }

    @Override
    public double areaCalculation(){
        if (getA() + getB() > c && getA() + c > getB() && getB() + c > getA()) {
            double p = (getA() + getB() + c) / 2;
            return Math.sqrt(p * (p - getA()) * (p - getB()) * (p - c));
        }
        return -1;
    }

}
