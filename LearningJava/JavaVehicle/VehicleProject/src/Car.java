import java.lang.*;
import java.util.*;
import java.io.*;

public class Car extends Vehicle
{
    Calendar productionDate;
    int power;

    public int getPower() { return this.power; }
    public void setPower(int value) { this.power = value; }

    public Calendar getProductionDate() { return this.productionDate; }
    public void setProductionDate(Calendar value) { this.productionDate = value; }

    @Override
    protected void performDeepCopy(Vehicle other) throws CloneNotSupportedException
    {
        if (!(other instanceof Car)) throw new CloneNotSupportedException("wrong inst type");
        Car b = (Car)other;
        b.productionDate = (Calendar)this.productionDate.clone();
    }

    public Car()
    {
        this.productionDate = new GregorianCalendar();
        this.power = 0;
    }

    public Car(String name, String color, int price, int model, String serialNumber, int direction, int power)
    {
        super(name, color, serialNumber, model, price, direction);
        this.productionDate = new GregorianCalendar();
        this.power = power;
    }

    @Override
    public void setAllFields()
    {
        super.setAllFields();

        System.out.print("Power: ");
        this.power = input.nextInt();
    }

    @Override
    public void turnLeft(int degrees)
    {
        turnLeftInternal(degrees);
    }

    @Override
    public void turnRight(int degrees)
    {
        turnRightInternal(degrees);
    }

    @Override
    public void accelerate(int speedFactor)
    {
        double spd = getSpeed();
        if (spd == 0)
        {
            setSpeed(spd + 0.5 * speedFactor);
        }
        else
        {
            setSpeed(spd + speedFactor);
        }

        if (getSpeed() > MAX_SPEED_CAR) setSpeed(MAX_SPEED_CAR);

        printSpeedChangeMessage("accellerated");
    }

    @Override
    public void brakes(int speedFactor)
    {
        setSpeed(getSpeed() / (speedFactor));
        printSpeedChangeMessage("decelerated");
    }

    @Override
    public String toString()
    {
        return String.format(
                "%s, power: %s, productionDate: %s",
                super.toString(),
                power,
                DATE_FORMAT.format(productionDate.getTime())
        );
    }

    @Override
    public void writeData(PrintWriter out) throws IOException
    {
        super.writeData(out);
        writeValue(out, productionDate);
        writeValue(out, power);
    }

    @Override
    public void readData(Scanner in) throws IOException
    {
        super.readData(in);
        productionDate = readCalendar(in);
        power = in.nextInt();
    }


}