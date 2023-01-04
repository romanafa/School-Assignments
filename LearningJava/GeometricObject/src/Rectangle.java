public class Rectangle extends GeometricObject implements GeometricObject.Comparable {
    private double width;
    private double height;


    public Rectangle() {
    }

    public Rectangle(double side){
        this(side, side);
    }


    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //getArea() method to get area of rectangle
    @Override
    public double getArea() {
        return height * width;
    }


    //method to get the perimeter of rectangle
    @Override
    public double  getPerimeter(){
        return (2 * width + 2 * height);
    }

    @Override
    public boolean equals(Object other) {
        return this.compareTo((Rectangle)other) == 0;
    }


    @Override
    public String toString() {
        return String.format(getClass().getName() + "\nWidth: " + width + " Height: " + height + "%n" + super.toString() + "%n");
    }



}
