import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Car extends Vehicle {
    private int power;
    private Calendar productionDate;

    public Car() {
    }

    public Car(String name, String color, int price, int model, String serialNumber, int direction, int power) {
        super(name, color, price, model, serialNumber, direction);
        setPower(power);
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
        System.out.println("Serial #: ");
        input.nextLine();
        setSerialNumber(input.nextLine());
        System.out.println("Power: ");
        setPower(input.nextInt());
        setDirection(0);
        setSpeed(0);
        setProductionDate(new GregorianCalendar());
        setBuyingDate(new GregorianCalendar());
    }

    @Override
    public void turnLeft(int degrees) {
        if (degrees > 0 && degrees < 360) {
            setDirection(getDirection()-degrees);
        }

        if (getDirection() > 360) {
            setDirection(getDirection() - 360);
        } else if (getDirection() < 0) {
            setDirection(getDirection() + 360);
        }
    }

    @Override
    public void turnRight(int degrees) {
        if (degrees > 0 && degrees < 360) {
            setDirection(getDirection()+degrees);
        }

        if (getDirection() > 360) {
            setDirection(getDirection() - 360);
        } else if (getDirection() < 0) {
            setDirection(getDirection() + 360);
        }

    }


    @Override
    public void accelerate(int speedFactor) {
        if (getSpeed() == 0) {
            setSpeed(0.5 * speedFactor);
        } else {
            setSpeed(getSpeed() * speedFactor);
        }

        if (getSpeed() > MAX_SPEED_CAR) {
            setSpeed(MAX_SPEED_CAR);
        }
    }

    @Override
    public void breaks(int speedFactor) {
        setSpeed(getSpeed()/speedFactor);
    }

    @Override
    public void writeData(PrintWriter out) {
        super.writeData(out);
        out.format(Locale.US, "%d", getPower());
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
        setPower(Integer.parseInt(in.next()));
        setProductionDate(new GregorianCalendar(Integer.parseInt(in.next()), Integer.parseInt(in.next()), Integer.parseInt(in.next())));
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public Object clone() {
        Car clone = null;
        clone = (Car) super.clone();
        clone.productionDate = this.productionDate;
        return clone;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Power: %d Production date: %tF ",
                getPower(), getProductionDate());
    }

}