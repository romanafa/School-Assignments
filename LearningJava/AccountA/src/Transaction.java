public class Transaction {

    private double amount;
    private double balance;
    private String description;
    private char type;
    private java.util.Date date;

    //constructor with all parameters
    public Transaction(double amount, double balance, String description, char type) {
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        this.type = type;
        date = new java.util.Date();
    }

    //Public GET methods for all fields
    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public char getType() {
        return type;
    }

    public java.util.Date getDate() {
        return date;
    }

    public String toString() {
        return String.format("%tF %1$tT", getDate()) + "       " + getType() + "       " + getAmount() + "        " + getBalance() +
                "       " + getDescription() + "\n";
    }


}
