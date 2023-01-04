import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Bicycle extends Vehicle {

    private int gears;
    private Calendar productionDate;

    public Bicycle() {

    }

    public Bicycle(String name, String color, int price, int model, String serialNumber, int direction, int gears) {
        super(name, color, price, model, serialNumber, direction);
        setGears(gears);
        setProductionDate(new GregorianCalendar());
    }

    @Override
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
        System.out.println("Gears: ");
        setGears(input.nextInt());
        setDirection(0);
        setSpeed(0);
        setProductionDate(new GregorianCalendar());
        setBuyingDate(new GregorianCalendar());
    }

    @Override
    public void turnLeft(int degrees) {
        setDirection(-degrees);

    }

    @Override
    public void turnRight(int degrees) {
        setDirection(degrees);

    }

    @Override
    public void accelerate(int speedFactor) {
        if (getSpeed() == 0) {
            setSpeed(0.3 * speedFactor);
        } else {
            setSpeed(getSpeed() * 0.5 * speedFactor);
        }

        if (getSpeed() > MAX_SPEED_BIKE) {
            setSpeed(MAX_SPEED_BIKE);
        }

    }

    @Override
    public void breaks(int speedFactor) {
        setSpeed(getSpeed() / (speedFactor * 0.5));

    }

    @Override
    public void writeData(PrintWriter out) {
        super.writeData(out);
        out.format(Locale.US, "%d", getGears());
        out.write(',');
        out.format(Locale.US, "%d", getProductionDate().get(Calendar.YEAR));
        out.write(',');
        out.format(Locale.US, "%d", getProductionDate().get(Calendar.MONTH));
        out.write(',');
        out.format(Locale.US, "%d", getProductionDate().get(Calendar.DATE));
        out.write(',');
    }

    @Override
    public void readData(Scanner in) {
        super.readData(in);
        setGears(Integer.parseInt(in.next()));
        setProductionDate(new GregorianCalendar(Integer.parseInt(in.next()), Integer.parseInt(in.next()), Integer.parseInt(in.next())));
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public Object clone() {
        Bicycle clone = null;
        clone = (Bicycle) super.clone();
        clone.productionDate = this.productionDate;
        return clone;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Gears: %d Production date: %tF ",
                getGears(), getProductionDate());
    }


}