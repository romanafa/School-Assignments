import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Bicycle extends Vehicle implements Vehicle.Comparable, Vehicle.Cloneable {
    private int gears;
    private java.util.Calendar productionDate = new GregorianCalendar();

    public Bicycle(){
    }

    public Bicycle(String name, String colour, int price, int model, String serialNumber, int direction, int gears) {
        super(name, colour, price, model, serialNumber, direction);
        this.gears = gears;
    }

    @Override
    public void setAllFields() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input bicycle data:");
        super.setAllFields();
        System.out.print("Gears: ");
        gears = input.nextInt();
    }

    @Override
    public void turnLeft(int degrees) {
        setDirection(getDirection() - degrees);

    }

    @Override
    public void turnRight(int degrees) {
        setDirection(getDirection() + degrees);
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
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
        Bicycle bicycle = null;
        try{
            bicycle = (Bicycle) super.clone();
        } catch (Exception e){
            return null;
        }
        return bicycle;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + " Gears: %d, Production date: %tF \n", getGears(), getProductionDate());
    }
}
