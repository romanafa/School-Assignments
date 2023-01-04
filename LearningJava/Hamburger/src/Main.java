public class Main {
    public static void main(String[] args) {


        Hamburger hamburger = new Hamburger("Basic", "white", "sausage", 3.56);
        double price = hamburger.itemizeHamburger();
        System.out.println("This " + price);
        hamburger.addHamburgerAddition1("tomato", 0.27);
        hamburger.addHamburgerAddition2("lettuce", 0.75);
        hamburger.addHamburgerAddition3("cheese", 1.13);
        System.out.println("Total Burger price is " + hamburger.itemizeHamburger());


        HealthyBurger healthyBurger = new HealthyBurger("bacon", 5.67);
        healthyBurger.addHamburgerAddition1("egg", 5.43);
        healthyBurger.addHealthAddition1("lentils", 3.41);
        System.out.println("Total Healthy Burger price is " + healthyBurger.itemizeHamburger());

        DeluxeBurger deluxe = new DeluxeBurger();
        deluxe.itemizeHamburger();


    }
}
