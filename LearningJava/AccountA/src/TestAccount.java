public class TestAccount {
    public static void main(String[] args) {

        //create new object
        AccountA account1 = new AccountA("Danny Boi",1, 1109.0);
        AccountA.setAnnualInterestRate(5.5);

        //information about customer
        System.out.println("Name: " + account1.getName());
        System.out.println("Annual interest rate: " + AccountA.getAnnualInterestRate());
        System.out.println("Balance: " + account1.getBalance());

        //transactions made on account1:
        account1.deposit(30.0, "Allowance");
        account1.deposit(40.0, "Lottery prize");
        account1.deposit(50.0, "Grandpa's gift");
        account1.withdraw(5.0, "Ice creams");
        account1.withdraw(4.0, "Scratch card");
        account1.withdraw(2.0, "Bus ticket");

        //converting from an ArrayList to String(book from page 416)
        StringBuilder stringBuilder = new StringBuilder();
        for (Object s : account1.getTransactions()){
            stringBuilder.append(s);
            stringBuilder.append("");
        }

        //transaction information output
        System.out.println("DATE                     TYPE    AMOUNT      BALANCE     DESCRIPTION");
        System.out.println(stringBuilder.toString());


    }
}