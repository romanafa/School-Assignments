public class Circle extends GeometricObject implements GeometricObject.Comparable {

    private double radius;

    public Circle(){
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }


    @Override
    public boolean equals(Object other) {
        return this.compareTo((Circle)other) == 0;
    }


    @Override  //getClass().getName() to get the object class name
    public String toString() {
        return String.format(getClass().getName() + "\nRadius: " + radius + "%n" + super.toString() + "%n");
    }

}
