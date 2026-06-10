package ex3;

public final class Circle implements Shape{
    private Integer radius;

    public Circle(Integer radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        double area = Math.PI * (radius * radius);
        System.out.printf("\nArea do circulo: %.2f", area);
    }
}
