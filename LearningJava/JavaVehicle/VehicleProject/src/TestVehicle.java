import java.util.*;
import java.io.*;

public class TestVehicle
{
    public static void main(String[] args)
    {
        TestVehicle vtest = new TestVehicle();
        try
        {
            vtest.menuLoop();
        }
        catch(IOException e) {
            System.out.println("IO Exception!");
            System.exit(1);
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println("CloneNotSupportedException");
            System.exit(1);
        }
    }

    static Vehicle findVehicle(ArrayList<Vehicle> arr, String name)
    {
        for (Vehicle v : arr)
        {
            if (v.getName().equals(name)) return v;
        }

        return null;
    }

    private void menuLoop() throws IOException, CloneNotSupportedException
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<Vehicle> arr = new ArrayList<Vehicle>();

        String wdirStr = new java.io.File( "." ).getCanonicalPath();
        File wdir = new File(wdirStr);

        for (File file : wdir.listFiles(Vehicle.FILE_FILTER))
        {
            Vehicle loaded = Vehicle.fromFile(file);
            arr.add(loaded);
            System.out.println(String.format("Loaded vehicle: %s", loaded));
        }

        if (arr.size() == 0)
        {
            arr.add(new Car("Volvo","Black",85000,2010,"1010-11",163,0));
            arr.add(new Bicycle("Diamant","yellow",4000,1993,"BC100",10,0));
            arr.add(new Car("Ferrari Testarossa","red",1200000,1996,"A112",350,0));
            arr.add(new Bicycle("DBS","pink",5000,1994,"42",10,0));

            System.out.println("Loaded default vehicle set");
        }

        boolean doExit = false;
        while(!doExit)
        {
            System.out.println("1...................................New car");
            System.out.println("2...............................New bicycle");
            System.out.println("3......................Find vehicle by name");
            System.out.println("4..............Show data about all vehicles");
            System.out.println("5.......Change direction of a given vehicle");
            System.out.println("6.......................Test clone() method");
            System.out.println("7..................Test driveable interface");
            System.out.println("8..............................Save vehicle");
            System.out.println("9..............................Load vehicle");
            System.out.println("0..............................Exit program");
            System.out.println("...............................Your choice?");
            System.out.print(":");
            int choice = scan.nextInt();

            switch (choice)
            {
                case 1:
                    //legg til en ny bil
                {
                    Car car = new Car();
                    car.setAllFields();
                    arr.add(car);
                }
                break;
                case 2:
                    //legg til en ny sykkel
                {
                    Bicycle bic = new Bicycle();
                    bic.setAllFields();
                    arr.add(bic);
                }
                break;
                case 3:
                    //vis info om gitt kjøretøy
                {
                    System.out.println("Vehicle name: ");
                    Vehicle v = findVehicle(arr, scan.next());
                    if (v != null) System.out.println(v);
                    else System.out.println("Not found");
                }
                break;
                case 4:
                    //vis info om alle kjøretøy
                    for (Vehicle v2 : arr)
                    {
                        System.out.println(v2);
                    }
                    break;
                case 5:
                    // Finn kjøretøy med gitt navn, sett ny retning
                {
                    System.out.println("Vehicle name: ");
                    Vehicle v3 = findVehicle(arr, scan.next());
                    if (v3 == null) {
                        System.out.println("Not found");
                    }
                    else {
                        System.out.println("Direction [L/R]: ");
                        String dir = scan.next().toLowerCase().trim();
                        System.out.println("# of deg's: ");
                        int offs = scan.nextInt();

                        if (dir == "l") v3.turnLeft(offs);
                        else if (dir == "r") v3.turnRight(offs);
                        else System.out.println("Invalid dir");
                    }
                }
                break;
                case 6: // test clone
                {
                    System.out.println("Vehicle name: ");
                    Vehicle toClone = findVehicle(arr, scan.next());
                    if (toClone == null) {
                        System.out.println("Not found");
                    }
                    else {
                        Vehicle theClone = (Vehicle)toClone.clone();
                        arr.add(theClone);

                        theClone.setBuyingDate(new GregorianCalendar());

                        System.out.println("Original:");
                        System.out.println(toClone);
                        System.out.println();
                        System.out.println("Clone:");
                        System.out.println(theClone);
                    }
                }
                case 7: // speed
                {
                    System.out.println("Make 2 vehicles: ");
                    Vehicle nv1 = new Bicycle("BMX","color",4000,1993,"BC133",10,0);
                    Vehicle nv2 = new Car("Lada","red",1200000,1996,"A122",350,0);
                    System.out.println(nv1);
                    System.out.println(nv2);
                    nv1.accelerate(50);
                    nv2.accelerate(50);
                    nv1.accelerate(100);
                    nv2.accelerate(100);

                    nv1.brakes(10);
                    nv2.brakes(10);

                    nv1.stop();
                    nv2.stop();
                }
                break;
                case 8: // save
                {
                    System.out.print("Which vehicle?: ");
                    String name = scan.next();
                    Vehicle saveV = findVehicle(arr, name);
                    if (saveV == null)
                    {
                        System.out.println("Not found");
                    }
                    else
                    {
                        System.out.print("Save - File name (full path): ");
                        String saveFilename = scan.next();
                        File saveFile = new File(saveFilename);
                        saveV.toFile(saveFile);
                    }
                }
                break;
                case 9: // load
                {
                    System.out.print("Load - File name (full path): ");
                    String loadFilename = scan.next();
                    File loadFile = new File(loadFilename);

                    try
                    {
                        Vehicle loadV = Vehicle.fromFile(loadFile);
                        System.out.println(loadV);
                        System.out.print("Add to retinue?: ");
                        String yesNo = scan.next().toLowerCase().trim();
                        if (yesNo.equals("y"))
                        {
                            arr.add(loadV);
                            System.out.println("Added.");
                        }
                    }
                    catch (Exception ex)
                    {
                        System.out.println(ex);
                    }
                }
                break;
                case 0: // exit
                    scan.close();
                    doExit = true;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }

        for (Vehicle veh : arr)
        {
            File saveAs =
                    java.nio.file.Paths.get(wdir.getPath(), veh.name + Vehicle.FILE_EXTENSION).toFile();
            veh.toFile(saveAs);
            System.out.println(String.format("Saved vehicle: %s", veh));
        }
    }
}