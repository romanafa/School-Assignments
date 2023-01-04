public class Calculator {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Oppgi regnestykket: ");
        String equation = input.nextLine();
        double result = 0;
// Ser etter + eller - eller * eller / og deler opp strengen etter de.
        String[] tokens = equation.split("[+\\-*/]");
        int left = Integer.parseInt(tokens[0].trim());
        int right = Integer.parseInt(tokens[1].trim());
        if (equation.contains("+"))
            result = left + right;
        if (equation.contains("-"))
            result = left - right;
        if (equation.contains("*"))
            result = left * right;
        if (equation.contains("/") && right != 0)
            result = (left * 1.0) / right;
// Display result
        System.out.println("Resultat: " + result);
    }
}
