package ex3;

public final class Rectangle implements Shape {
    
    private Integer lenght;
    private Integer height;
    
    public Rectangle(Integer lenght, Integer height) {
        this.lenght = lenght;
        this.height = height;
    }

    public Integer getLenght() {
        return lenght;
    }

    public void setLenght(Integer lenght) {
        this.lenght = lenght;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public void area() {
       int area = lenght * height;
       System.out.println("\nArea do retangulo: " + area);

    }
}   
