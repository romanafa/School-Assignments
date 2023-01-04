import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class TestVehicle implements Vehicle.Cloneable {

    public static void main(String[] args) {
        TestVehicle vtest = new TestVehicle();
        try {
            vtest.menuLoop();
        } catch (IOException e) {
            System.out.println("IO Exception!");
            System.exit(1);
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException");
            System.exit(1);
        }
    }

    private void menuLoop() throws IOException, CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Vehicle> arr = new ArrayList<Vehicle>();
        Vehicle vehicle;
        arr.add(new Car("Volvo", "Black", 85000, 2010, "1010-11", 163, 0));
        arr.add(new Bicycle("Diamant", "yellow", 4000, 1993, "BC100", 10, 0));
        arr.add(new Car("Ferrari Testarossa", "red", 1200000, 1996, "A112", 350, 0));
        arr.add(new Bicycle("DBS", "pink", 5000, 1994, "42", 10, 0));
        while (true) {
            System.out.println("1...................................New car");
            System.out.println("2...............................New bicycle");
            System.out.println("3......................Find vehicle by name");
            System.out.println("4..............Show data about all vehicles");
            System.out.println("5.......Change direction of a given vehicle");
            System.out.println("6.........................Test clone method");
            System.out.println("7..............................Exit program");
            System.out.println(".............................Your choice?");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: //new car + add to the array
                    vehicle = new Car();
                    vehicle.setAllFields();
                    arr.add(vehicle);
                    break;
                case 2: //new bike + add to the array
                    vehicle = new Bicycle();
                    vehicle.setAllFields();
                    arr.add(vehicle);
                    break;
                case 3:
                    System.out.print("Name of vehicle: ");
                    String showInfo = scan.next();
                    for (Vehicle obj : arr) {
                        if (obj.getName().equals(showInfo)) {  //compare if some object contains user input
                            System.out.println(obj.toString());
                        }
                    }
                    break;
                case 4:
                    StringBuilder stringBuilder = new StringBuilder(); //creating StringBuilder to print ArrayList as String
                    for (Vehicle v : arr){
                        stringBuilder.append(v);
                        stringBuilder.append("");
                    }
                    System.out.println(stringBuilder.toString());
                    break;
                case 5:
                    System.out.print("Name of vehicle: ");
                    String dirChangeName = scan.next();
                    for (Vehicle veh : arr){
                        if (veh.getName().equals(dirChangeName)){   //check if vehicle exists
                            System.out.print("Direction [R/L]: ");
                            char dir = scan.next().charAt(0);
                            if (dir == 'R' || dir == 'r') {
                                System.out.print("Degrees [0-360]:");
                                int degrees = scan.nextInt();
                                if (degrees >= 0 && degrees <= 360){
                                    veh.turnRight(degrees);
                                }
                                else
                                    System.out.println("Invalid turn.");
                            }
                            else if (dir == 'L' || dir == 'l') {
                                System.out.print("Degrees [0-360]:");
                                int degrees = scan.nextInt();
                                if (degrees >= 0 && degrees <= 360){
                                    veh.turnLeft(degrees);
                                }
                                else
                                    System.out.println("Invalid turn.");
                            }
                            else
                                System.out.println("Invalid character. Please, choose action again from menu [1-6].");
                        }
                    }
                        break;
                case 6:
                    Vehicle car1 = new Car("Volkswagen", "Red", 25000, 1998, "vw98", 0, 0);
                    car1.clone();
                    Vehicle car2 = (Vehicle)car1.clone();
                    car2.setBuyingDate(Calendar.getInstance());
                    System.out.println("Date objects are separate, deep copy.");
                    System.out.println(car1.getBuyingDate() + "\n" + car2.getBuyingDate().replaceAll(car2.getBuyingDate(), "2019-02-20"));
                    break;
                case 7:
                    System.exit(0);
                    break;
                    default:
                        System.out.println("Please choose from options [1-7]");
            }
        }
    }
}