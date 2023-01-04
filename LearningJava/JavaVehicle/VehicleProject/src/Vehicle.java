import java.lang.*;
import java.util.*;
import java.io.*;
import java.text.*;


public abstract class Vehicle implements Comparable<Vehicle>, Cloneable, Driveable, Fileable
{
    protected static final String CSV_DELIMETER = ",";

    protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static final String FILE_EXTENSION = ".vehicle";

    public static final FilenameFilter FILE_FILTER = new FilenameFilter() {
        public boolean accept(File directory, String fileName) {
            return fileName.endsWith(FILE_EXTENSION);
        }
    };

    String color;
    String name;
    String serialNumber;
    int model;
    int price;
    int direction;
    double speed;
    Calendar buyingDate;

    protected Scanner input = new Scanner(System.in);

    public static Vehicle fromFile(File file)
            throws FileNotFoundException, IOException
    {
        try ( Scanner in = new Scanner(file).useLocale(Locale.US) )
        {
            in.useDelimiter(CSV_DELIMETER);
            String vehClass = in.next();
            Class veh1 = Class.forName(vehClass);
            Vehicle veh = (Vehicle)veh1.newInstance();
            veh.readData(in);
            return veh;
        }
        catch (ReflectiveOperationException ex)
        // ClassNotFoundException+InstantiationException+IllegalAccessException
        {
            throw new IOException("Invalid vehicle class", ex);
        }
    }

    public void toFile(File file) throws IOException
    {
        try ( PrintWriter out = new PrintWriter(file) )
        {
            writeValue(out, this.getClass().getName());
            this.writeData(out);
        }
    }

    protected static void writeValue(PrintWriter out, String strValue)
    {
        out.format(Locale.US, "%s%s", strValue, CSV_DELIMETER);
    }

    protected static void writeValue(PrintWriter out, Calendar value)
    {
        String strValue = DATE_FORMAT.format(value.getTime());
        writeValue(out, strValue);
    }

    protected static void writeValue(PrintWriter out, int value)
    {
        String strValue = String.valueOf(value);
        writeValue(out, strValue);
    }

    protected static void writeValue(PrintWriter out, double value)
    {
        String strValue = String.valueOf(value);
        writeValue(out, strValue);
    }

    protected static Calendar readCalendar(Scanner in) throws IOException
    {
        Date date;
        String dstr = in.next();

        try
        {
            date = DATE_FORMAT.parse(dstr);
        }
        catch (ParseException ex)
        {
            throw new IOException("Invalid date/time format: " + dstr, ex);
        }

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }

    @Override
    public void writeData(PrintWriter out) throws IOException
    {
        writeValue(out, color);
        writeValue(out, name);
        writeValue(out, serialNumber);
        writeValue(out, model);
        writeValue(out, price);
        writeValue(out, direction);
        writeValue(out, speed);
        writeValue(out, buyingDate);
    }

    @Override
    public void readData(Scanner in) throws IOException
    {
        this.color = in.next();
        this.name = in.next();
        this.serialNumber = in.next();

        this.model = in.nextInt();
        this.price = in.nextInt();
        this.direction = in.nextInt();
        this.speed = in.nextDouble();
        this.buyingDate = readCalendar(in);
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        Vehicle v = (Vehicle)super.clone();
        v.buyingDate = (Calendar)this.buyingDate.clone();
        v.performDeepCopy(this);
        return v;
    }

    protected abstract void performDeepCopy(Vehicle other) throws CloneNotSupportedException;

    @Override
    public void stop()
    {
        this.setSpeed(0);
        System.out.println(String.format("%s %s is stopped", this.getClass().getSimpleName(), this.getName()));
    }

    @Override
    public int compareTo(Vehicle rhs)
    {
        return (int)Math.signum(this.price - rhs.price);
    }

    protected void printSpeedChangeMessage(String desc)
    {
        System.out.println(String.format("%s %s: %s to %.2f kmph",
                this.getClass().getSimpleName(),
                this.getName(),
                desc,
                getSpeed()
        ));
    }

    public Vehicle()
    {
        this.direction = 0;
        this.speed = 0;
        this.buyingDate = new GregorianCalendar();
    }

    public Vehicle(String name, String color, String serialNumber, int model, int price, int direction)
    {
        this.direction = 0;
        this.speed = 0;
        this.buyingDate = new GregorianCalendar();

        this.color = color;
        this.name = name;
        this.serialNumber = serialNumber;
        this.model = model;
        this.price = price;
        this.direction = direction;
    }

    public void setAllFields()
    {
        System.out.println(String.format("Input %s data: ", this.getClass().getSimpleName()));

        System.out.print("Name: ");
        this.name = input.next();

        System.out.print("Color: ");
        this.color = input.next();

        System.out.print("Price: ");
        this.price = input.nextInt();

        System.out.print("Model: ");
        this.model = input.nextInt();

        System.out.print("Serial #: ");
        this.serialNumber = input.next();
    }

    public String getColor() { return this.color; }
    public void setColor(String value) { this.color = value; }

    public String getName() { return this.name; }
    public void setName(String value) { this.name = value; }

    public String getSerialNumber() { return this.serialNumber; }
    public void setSerialNumber(String value) { this.serialNumber = value; }

    public int getModel() { return this.model; }
    public void setModel(int value) { this.model = value; }

    public int getPrice() { return this.price; }
    public void setPrice(int value) { this.price = value; }

    public int getDirection() { return this.direction; }
    public void setDirection(int value) { this.direction = value; }

    public double getSpeed() { return this.speed; }
    public void setSpeed(double value) { this.speed = value; }

    public Calendar getBuyingDate() { return this.buyingDate; }
    public void setBuyingDate(Calendar value) { this.buyingDate = value; }

    public abstract void turnLeft(int degrees);
    public abstract void turnRight(int degrees);

    protected void turnLeftInternal(int degrees)
    {
        int dir = (this.getDirection() + degrees);
        while (dir < 0) dir += 360;
        this.setDirection(dir);
    }

    protected void turnRightInternal(int degrees)
    {
        int dir = (this.getDirection() - degrees);
        while (dir >= 360) dir -= 360;
        this.setDirection(dir);
    }

    @Override
    public String toString()
    {
        return String.format(
                "%s name: %s, color: %s, serial: %s, model: %s, price: %s, direction: %s, buyingDate: %s",
                this.getClass().getSimpleName(), name, color, serialNumber, model, price, direction,
                DATE_FORMAT.format(buyingDate.getTime())
        );
    }

}