import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class that tests functionality of Vehicle, Bicycle and Car classes.
 */

public class TestVehicle {

    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    public static void main(String[] args) {

        TestVehicle vtest = new TestVehicle();

        try {
            vtest.readVehicles();
            vtest.menuLoop();
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException!");
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException!");
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException!");
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (InstantiationException e) {
            System.out.println("InstantiationException!");
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException!");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private void readVehicles() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        File file = new File("Vehicles.txt");
        Scanner in = new Scanner(file);
        in.useDelimiter(",");
        while(in.hasNextLine()) {
            String vehClass = in.next();
            Class veh1 = Class.forName(vehClass);
            Vehicle veh = (Vehicle)veh1.newInstance();
            veh.readData(in);
            System.out.println("Vehicle read from file: " + veh);
            vehicles.add(veh);
            in.nextLine();
        }
        in.close();
    }

    private void writeVehicles() throws FileNotFoundException {
        File file = new File("Vehicles.txt");
        PrintWriter out = new PrintWriter(file);
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i).writeData(out);
            System.out.println("Vehicle written to file: " + vehicles.get(i));
            out.println();
        }
        out.close();
    }

    private void menuLoop() throws InputMismatchException{
        Scanner input = new Scanner(System.in);
        Vehicle vehicle;

        while (true) {
            System.out.println("1...................................New car");
            System.out.println("2...............................New bicycle");
            System.out.println("3......................Find vehicle by name");
            System.out.println("4..............Show data about all vehicles");
            System.out.println("5.......Change direction of a given vehicle");
            System.out.println("6.........................Test Clone Method");
            System.out.println("7..................Test driveable interface");
            System.out.println("8..............................Exit program");
            System.out.print(".............................Your choice? ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nInput car data:");
                    vehicle = new Car();
                    vehicle.setAllFields();
                    vehicles.add(vehicle);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\nInput bicycle data:");
                    vehicle = new Bicycle();
                    vehicle.setAllFields();
                    vehicles.add(vehicle);
                    System.out.println();
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("\nName of vehicle:");
                    String vehicleName = input.nextLine().toLowerCase();
                    boolean exists = false;

                    for (int i = 0; i < vehicles.size(); i++) {
                        if (Objects.equals(vehicleName, vehicles.get(i).getName().toLowerCase())) {
                            System.out.println(vehicles.get(i));
                            exists = true;
                        }
                    }

                    if (!exists) {
                        System.out.println("No vehicle with that name.");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    for(int i = 0; i < vehicles.size(); i++) {
                        System.out.println(vehicles.get(i));
                    }
                    System.out.println();
                    break;
                case 5:
                    input.nextLine();
                    System.out.println("\nName of vehicle: ");
                    String directionVehicle = input.nextLine().toLowerCase();
                    System.out.println("Direction [R/L]: ");
                    char directionChar = input.next().charAt(0);
                    System.out.println("Degrees [0-360]: ");
                    int directionDegrees = input.nextInt();
                    boolean matching = false;

                    for (int i = 0; i < vehicles.size(); i++) {
                        if (Objects.equals(directionVehicle, vehicles.get(i).getName().toLowerCase())) {
                            matching = true;
                            if (directionChar == 'L') {
                                vehicles.get(i).turnLeft(directionDegrees);
                            } else if (directionChar == 'R') {
                                vehicles.get(i).turnRight(directionDegrees);
                            } else {
                                System.out.println("Direction can only be L or R");
                            }
                        }
                    }

                    if(!matching) {
                        System.out.println("No vehicle with that name.");
                    }
                    System.out.println();
                    break;
                case 6:
                    Car oldCar = new Car("Skoda", "Red", 20000, 2011, "DS321J", 0, 50);
                    Car newCar = (Car) oldCar.clone();
                    System.out.println("\nBefore changing dates: ");
                    System.out.printf("Old car: Buying date: %tF %n", oldCar.getBuyingDate());
                    System.out.printf("Clone car: Buying date: %tF %n", newCar.getBuyingDate());
                    System.out.printf("Old car: Production date: %tF %n",  oldCar.getProductionDate());
                    System.out.printf("Clone car: Production date: %tF %n", newCar.getProductionDate());

                    newCar.setBuyingDate(new GregorianCalendar(2017, 04, 26));
                    newCar.setProductionDate(new GregorianCalendar(2017, 01, 02));
                    System.out.println("After changing dates: ");
                    System.out.printf("Old car: Buying date: %tF %n", oldCar.getBuyingDate());
                    System.out.printf("Clone car: Buying date: %tF %n", newCar.getBuyingDate());
                    System.out.printf("Old car: Production date: %tF %n",  oldCar.getProductionDate());
                    System.out.printf("Clone car: Production date: %tF %n", newCar.getProductionDate());

                    break;
                case 7:
                    System.out.println("\nCar:");
                    Car accCar = new Car("Skoda", "Red", 20000, 2011, "DS321J", 0, 50);
                    accCar.accelerate(10);
                    System.out.println("Vehicle accelerated to: " + accCar.getSpeed() + " km/h");
                    accCar.accelerate(50);
                    System.out.println("Vehicle accelerated to: " + accCar.getSpeed() + " km/h");
                    accCar.breaks(1000);
                    System.out.println("Vehicle slowed down to: " + accCar.getSpeed() + " km/h");
                    accCar.stop();
                    System.out.println("Bicycle:");
                    Bicycle accBike = new Bicycle("BMX", "Blue", 3000, 2016, "JD32", 0, 3);
                    accBike.accelerate(10);
                    System.out.println("Vehicle accelerated to: " + accBike.getSpeed() + " km/h");
                    accBike.accelerate(67);
                    System.out.println("Vehicle accelerated to: " + accBike.getSpeed() + " km/h");
                    accBike.breaks(1000);
                    System.out.println("Vehicle accelerated to: " + accBike.getSpeed() + " km/h");
                    accBike.stop();

                    break;
                case 8:
                    input.close();
                    try {
                        writeVehicles();
                    } catch (FileNotFoundException e) {
                        System.out.println("FileNotFoundException!");
                        System.out.println(e.getMessage());
                        System.exit(1);
                    }
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }

    }
}