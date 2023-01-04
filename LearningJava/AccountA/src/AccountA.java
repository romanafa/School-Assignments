import java.util.ArrayList;

public class AccountA {

    private String name;
    private int id;
    private double balance;
    private static double annualInterestRate;
    private java.util.Date dateCreated;
    private ArrayList<Transaction> transactions;


    public AccountA() {
        dateCreated = new java.util.Date();
        transactions = new ArrayList<Transaction>();   //making a new list
    }

    public AccountA(String name, int newId, double newBalance) {
        this.name =name;
        id = newId;
        balance = newBalance;
        dateCreated = new java.util.Date();
        transactions = new ArrayList<Transaction>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }
    public double getBalance() {
        return balance;
    }
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public void setId(int newId) {
        id = newId;
    }
    public void setBalance(double newBalance) {
        balance = newBalance;
    }
    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 1200);
    }

    //Method which describes withdrawals and which adds the transaction to transaction list
    public void withdraw(double amount, String description) {
        balance -= amount;
        transactions.add(new Transaction(amount, balance, description,
                'W'));
    }

    //method which describes deposits and which adds the transaction to transaction list
    public void deposit(double amount, String description) {
        balance += amount;
        transactions.add(new Transaction(amount, balance,description,
                'D'));
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }


}
