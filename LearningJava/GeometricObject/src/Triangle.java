public class Triangle extends GeometricObject implements GeometricObject.Comparable {
    private double side1;
    private double side2;
    private double side3;


    public Triangle(){
        this(1.0);
    }

    //constructor
    public Triangle(double side){
        this(side, side, side);
    }


    //constructor with three parameters
    public Triangle(double side1, double side2, double side3){
        this("White", false, side1, side2, side3);
    }

    //constructor with new values which are initialized and with values from superclass
    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //Getters and setters
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    //method to get the areal of the triangle
    @Override
    public double getArea() {
        double areal, s;
        s = (side1 + side2 + side3) / 2;
        areal = Math.pow((s*(s-side1)*(s-side2)*(s-side3)),0.5);
        return areal;
    }


    //method to get the perimeter of the triangle
    @Override
    public double  getPerimeter(){
        double perimeter;
        perimeter = side1 + side2 + side3;
        return perimeter;
    }


    @Override
    public boolean equals(Object other) {
        return this.compareTo((Triangle)other) == 0;
    }


    //method to get information about the object, overriding the method from superclass
    @Override
    public String toString() {
        return String.format(getClass().getName() + "\nSides: " + side1 + ", " + side2 + ", " + side3 + "%n" + super.toString() + "%n");
    }

}

