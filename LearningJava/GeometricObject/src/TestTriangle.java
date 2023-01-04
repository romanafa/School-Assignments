import java.util.Scanner;

public class TestTriangle {

    public static void main(String[] args) {

        //get the description of triangle from user
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("Enter three sides of triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        //creating new object from Triangle class with parameters from GeometricObject and Triangle
        Triangle triangle = new Triangle("Pink", false, side1, side2, side3);


        //displaying sides, area and perimeter with get methods
        System.out.println("Side1? " + triangle.getSide1());
        System.out.println("Side2? " + triangle.getSide2());
        System.out.println("Side3? " + triangle.getSide3());
        System.out.println("");
        System.out.printf("Area: %.2f%n", triangle.getArea());
        System.out.printf("Perimeter: %.2f%n%n", triangle.getPerimeter());

        //calling the toString method to get information about triangle
        System.out.println(triangle.toString());

    }

}