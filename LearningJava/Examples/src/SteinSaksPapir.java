import java.util.Random;
import java.util.Scanner;

public class SteinSaksPapir {

    public static void main(String[] args) {
        int computerNumber, userNumber;

        computerNumber = new Random().nextInt(3); //will choose a random value from 0 until 2, importing java.util.Random


        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.print("Write in number 0(rock), 1(scissors) or 2(paper): ");
        userNumber = input.nextInt();

        if ((userNumber < 0 ) || (userNumber > 2)) {
            System.out.println("You entered invalid value, run program again.");
        }

        switch(computerNumber) {
            case 0: //checking case if computerNumber == 0
                if (userNumber == 0)
                    System.out.println("Computer had rock, you had rock. No winner in this round.");
                if (userNumber == 1)
                    System.out.println("Computer had rock, you had scissors. You lost." );
                if (userNumber == 2)
                    System.out.println("Computer had rock, you had paper. You won!");
                break;

            case 1: //checking case if computerNumber == 1
                if (userNumber == 0)
                    System.out.println("Computer had scissors, you had rock. You won!");
                if (userNumber == 1)
                    System.out.println("Computer had scissors, you had scissors. No winner in this round.");
                if (userNumber == 2)
                    System.out.println("Computer had scissors, you had paper. You lost.");
                break;
            case 2: //checking case if computerNumber == 2
                if (userNumber == 0)
                    System.out.println("Computer had paper, you had rock. You lost");
                if (userNumber == 1)
                    System.out.println("Computer had paper, you had scissors. You won!" );
                if (userNumber == 2)
                    System.out.println("Computer had paper, you had paper. No winner in this round.");
                break;

        }

    }

}
