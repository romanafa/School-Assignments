import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public abstract class Vehicle implements Comparable <Vehicle>, Cloneable, Driveable, Fileable{
    private String color, name, serialNumber;
    private int model, price, direction;
    private double speed;
    private Calendar buyingDate;

    protected java.util.Scanner input = new java.util.Scanner(System.in);

    public Vehicle() {

    }

    public Vehicle(String name, String color, int price, int model, String serialNumber, int direction) {
        setName(name);
        setColor(color);
        setPrice(price);
        setModel(model);
        setSerialNumber(serialNumber);
        setDirection(direction);
        setSpeed(0.0);
        setBuyingDate(new GregorianCalendar());
    }

    public void setAllFields() {
        System.out.println("Name: ");
        setName(input.nextLine());
        System.out.println("Color: ");
        setColor(input.nextLine());
        System.out.println("Price: ");
        setPrice(input.nextInt());
        System.out.println("Model: ");
        setModel(input.nextInt());
        input.nextLine();
        System.out.println("Serial #: ");
        setSerialNumber(input.nextLine());
        setDirection(0);
        setSpeed(0.0);
        setBuyingDate(new GregorianCalendar());
    }

    public abstract void turnLeft(int degrees);
    public abstract void turnRight(int degrees);

    @Override
    public void stop() {
        setSpeed(0);
        System.out.println("Vehicle stops");
    }

    @Override
    public void writeData(PrintWriter out) {
        out.format(Locale.US, "%s", this.getClass().getSimpleName());
        out.write(',');
        out.format(Locale.US, "%s", getName());
        out.write(',');
        out.format(Locale.US, "%s", getColor());
        out.write(',');
        out.format(Locale.US, "%d", getPrice());
        out.write(',');
        out.format(Locale.US, "%d", getModel());
        out.write(',');
        out.format(Locale.US, "%s", getSerialNumber());
        out.write(',');
        out.format(Locale.US, "%d", getDirection());
        out.write(',');
        out.format(Locale.US, "%.2f", getSpeed());
        out.write(',');
        out.format(Locale.US, "%d", getBuyingDate().get(Calendar.YEAR));
        out.write(',');
        out.format(Locale.US, "%d", getBuyingDate().get(Calendar.MONTH));
        out.write(',');
        out.format(Locale.US, "%d", getBuyingDate().get(Calendar.DATE));
        out.write(',');

        //out.format(String.format("%s , %s , %d , %d , %s , %d% , %.2f , %tF ,",
        //		getName(), getColor(), getPrice(), getModel(), getSerialNumber(), getDirection(), getSpeed(), getBuyingDate()));
    }

    @Override
    public void readData(Scanner in) {
        setName(in.next());
        setColor(in.next());
        setPrice(Integer.parseInt(in.next()));
        setModel(Integer.parseInt(in.next()));
        setSerialNumber(in.next());
        setDirection(Integer.parseInt(in.next()));
        setSpeed(Double.parseDouble(in.next()));
        setBuyingDate(new GregorianCalendar(Integer.parseInt(in.next()), Integer.parseInt(in.next()), Integer.parseInt(in.next())));
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Calendar getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Calendar buyingDate) {
        this.buyingDate = buyingDate;
    }

    public int compareTo(Vehicle other) {
        if (this.getPrice() > other.getPrice()) {
            return 1;
        } else if (this.getPrice() < other.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }

    public Object clone() {
        Vehicle clone = null;
        try {
            clone = (Vehicle) super.clone();
            clone.buyingDate = this.buyingDate;
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported.");
            e.printStackTrace();
        }
        return clone;
    }

    public String toString() {
        return String.format("Name: %s Color: %s Price: %d Model: %d Serial#: %s Direction: %d Speed: %.2f Buying date: %tF ",
                getName(), getColor(), getPrice(), getModel(), getSerialNumber(), getDirection(), getSpeed(), getBuyingDate());
    }

}