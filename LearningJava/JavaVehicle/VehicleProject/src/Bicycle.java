import java.lang.*;
import java.util.*;
import java.io.*;

public class Bicycle extends Vehicle
{
    int gears;
    Calendar productionDate;

    public int getGears() { return this.gears; }
    public void setGears(int value) { this.gears = value; }

    public Calendar getProductionDate() { return this.productionDate; }
    public void setProductionDate(Calendar value) { this.productionDate = value; }

    @Override
    protected void performDeepCopy(Vehicle other) throws CloneNotSupportedException
    {
        if (!(other instanceof Bicycle)) throw new CloneNotSupportedException("wrong inst type");
        Bicycle b = (Bicycle)other;
        b.productionDate = (Calendar)this.productionDate.clone();
    }



    public Bicycle()
    {
        this.productionDate = new GregorianCalendar();
        this.gears = 0;
    }

    public Bicycle(String name, String color, int price, int model, String serialNumber, int direction, int gears)
    {
        super(name, color, serialNumber, model, price, direction);
        this.productionDate = new GregorianCalendar();
        this.gears = gears;
    }

    @Override
    public void setAllFields()
    {
        super.setAllFields();

        System.out.print("Gears: ");
        this.gears = input.nextInt();
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
            setSpeed(spd + 0.3 * speedFactor);
        }
        else
        {
            setSpeed(spd + 0.5 * speedFactor);
        }

        if (getSpeed() > MAX_SPEED_BIKE) setSpeed(MAX_SPEED_BIKE);

        printSpeedChangeMessage("accellerated");
    }

    @Override
    public void brakes(int speedFactor)
    {
        setSpeed(getSpeed() / (0.5 * speedFactor));
        printSpeedChangeMessage("decelerated");
    }

    @Override
    public String toString()
    {
        return String.format(
                "%s, gears: %s, productionDate: %s",
                super.toString(),
                gears,
                DATE_FORMAT.format(productionDate.getTime())
        );
    }

    @Override
    public void writeData(PrintWriter out) throws IOException
    {
        super.writeData(out);
        writeValue(out, productionDate);
        writeValue(out, gears);
    }

    @Override
    public void readData(Scanner in) throws IOException
    {
        super.readData(in);
        productionDate = readCalendar(in);
        gears = in.nextInt();
    }

}