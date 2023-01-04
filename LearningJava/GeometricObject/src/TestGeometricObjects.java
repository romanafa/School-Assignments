public class TestGeometricObjects {
    public static void main(String[] args){

        //create two circle objects
        Circle circle1 = new Circle(2.00);
        Circle circle2 = new Circle(3.00);
        System.out.println("The biggest circle: \n" + Circle.max(circle1, circle2));

        //create two rectangle objects
        Rectangle rectangle1 = new Rectangle(2.00,3.00);
        Rectangle rectangle2 = new Rectangle(4.00,6.00);
        System.out.println("The biggest rectangle: \n"  + Rectangle.max(rectangle1, rectangle2));

        //create two triangle objects
        Triangle triangle1 = new Triangle(20.00, 20.00, 20.00);
        Triangle triangle2 = new Triangle(9.00, 10.00, 9.00);
        System.out.println("The biggest triangle: \n" + Triangle.max(triangle1,triangle2));

        //get the biggest object
        System.out.printf("The biggest geometric object is \n%s", GeometricObject.max(Circle.max(circle1, circle2), Rectangle.max(rectangle1, rectangle2)) == circle1
                || (GeometricObject.max(Circle.max(circle1, circle2), Rectangle.max(rectangle1, rectangle2)) ==circle2) ? GeometricObject.max(Circle.max(circle1, circle2), Triangle.max(triangle1,triangle2))
                : GeometricObject.max(Rectangle.max(rectangle1, rectangle2), Triangle.max(triangle1,triangle2)));

    }
}
