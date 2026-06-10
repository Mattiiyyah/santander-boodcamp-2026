package ex3;

public final class Square implements Shape {
    private Integer side;

    public Square(Integer side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    @Override
    public void area() {
        int area = side * side;
        System.out.println("\nArea do quadrado: " + area);
    }   
}
