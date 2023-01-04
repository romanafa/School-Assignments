public class Hamburger {
    private String name;
    private String breadType;
    private String meat;
    private double price;

    //additions, we need to track them, name + price
    private String addition1Name;
    private double addition1Price;

    private String addition2Name;
    private double addition2Price;

    private String addition3Name;
    private double addition3Price;

    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String breadType, String meat, double price) {
        this.name = name;
        this.breadType = breadType;
        this.meat = meat;
        this.price = price;
    }

    //record method for each of additions
    public void addHamburgerAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1Price = price;
    }

    public void addHamburgerAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2Price = price;
    }

    public void addHamburgerAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3Price = price;
    }

    public void addHamburgerAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4Price = price;
    }

    //method to add up price of the hamburger
    public double itemizeHamburger() {
        double hamburgerPrice = this.price; //local variable passed the base price
        System.out.println(this.name + " hamburger on a " + this.breadType
                + " roll, with " + this.meat + " costs " + this.price + " dollars");

        //we need to add aditions
        if(this.addition1Name != null) {
            hamburgerPrice += this.addition1Price;
            System.out.println("Added " + this.addition1Name + " for an extra "
                    + this.addition1Price + " dollars.");
        }
        if(this.addition2Name != null) {
            hamburgerPrice += this.addition2Price;
            System.out.println("Added " + this.addition2Name + " for an extra "
                    + this.addition2Price + " dollars.");
        }
        if(this.addition3Name != null) {
            hamburgerPrice += this.addition3Price;
            System.out.println("Added " + this.addition3Name + " for an extra "
                    + this.addition3Price + " dollars.");
        }
        if(this.addition4Name != null) {
            hamburgerPrice += this.addition4Price;
            System.out.println("Added " + this.addition4Name + " for an extra "
                    + this.addition4Price + " dollars.");
        }

        return hamburgerPrice;

    }
}
