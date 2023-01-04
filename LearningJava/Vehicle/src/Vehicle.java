import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public abstract class Vehicle implements Cloneable {
    private String colour, name, serialNumber;
    private int model, price, direction;
    private double speed;
    private java.util.Calendar buyingDate = new GregorianCalendar();
    protected java.util.Scanner input = new Scanner(System.in);

    //empty constructor
    public Vehicle(){
    }

    public Vehicle(String name, String colour, int price, int model, String serialNumber, int direction) {
        this.name = name;
        this.colour = colour;
        this.serialNumber = serialNumber;
        this.model = model;
        this.price = price;
        this.direction = direction;
        this.speed = 0;
        this.buyingDate = Calendar.getInstance();
    }

    public void setAllFields(){
        //input for å lese inn alle verdier fra brukeren
        System.out.print("Name: ");
        name = input.next();
        System.out.print("Colour: ");
        colour = input.next();
        System.out.print("Price: ");
        price = input.nextInt();
        System.out.print("Model(year): ");
        model = input.nextInt();
        System.out.print("Serial #: ");
        serialNumber = input.next();
    }

    //abstract methods which should be impltemented by child class
    public abstract void turnLeft(int degrees);
    public abstract void turnRight(int degrees);

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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


    public String getBuyingDate() {
        buyingDate = Calendar.getInstance();
        //change Calendar to String
        buyingDate.add(Calendar.DATE, -30); //get date 30 days before today`s date
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(buyingDate.getTime());
        return formatted;
        //return "2019-02-15";*/
    }

    public void setBuyingDate(Calendar buyingDate) {
        this.buyingDate = buyingDate;
    }

    public interface Comparable{
        int compareTo(Vehicle obj);
    }

    public int compareTo(Vehicle obj) {  //
        if (this.getPrice() > obj.getPrice()) {
            return 1;
        }
        else if (this.getPrice() < obj.getPrice())
            return -1;
        else
            return 0;
    }

    public interface Cloneable{
    }

    @Override
    public Object clone(){
        try{
            return (Vehicle)super.clone();
        }
        catch (CloneNotSupportedException ex){
            return null;
        }
    }

    public String toString(){
        return String.format("Name: %s Colour: %s Price: %d Model: %d Serial#: %s Direction: %d Speed: %.2f" , getName(), getColour(),
                getPrice(), getModel(), getSerialNumber(), getDirection(), getSpeed()); //return string
    }
}
