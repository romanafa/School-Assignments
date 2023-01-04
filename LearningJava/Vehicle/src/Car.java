import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Car extends Vehicle implements Vehicle.Comparable, Vehicle.Cloneable {
    private int power;
    private java.util.Calendar productionDate = new GregorianCalendar();

    public Car(){
    }

    public Car(String name, String colour, int price, int model, String serialNumber, int direction, int power) {
        super(name, colour, price, model, serialNumber, direction);
        this.power = power;
    }

    @Override
    public void setAllFields() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input car data:");
        super.setAllFields();
        System.out.print("Power: ");
        this.power = input.nextInt();
    }

    @Override
    public void turnLeft(int degrees) {
        if (degrees >= 0 && degrees <= 360){
            setDirection(getDirection() - degrees);
            if (getDirection() < 0)
                setDirection(360 + getDirection());
        }
    }

    @Override
    public void turnRight(int degrees) {
        if (degrees >= 0 && degrees <= 360){
            setDirection(getDirection() + degrees);
            if (getDirection() > 360)
                setDirection(getDirection() - 360);
        }
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public java.util.Calendar getProductionDate() {
        productionDate = Calendar.getInstance();
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public Object clone(){
        Car car = null;
        try{
            car = (Car)super.clone();
        } catch (Exception e){
            return null;
        }
        return car;
    }


    @Override
    public String toString() {
        return String.format(super.toString() + " Power: %d, Production date: %tF \n", getPower(), getProductionDate());
    }
}
