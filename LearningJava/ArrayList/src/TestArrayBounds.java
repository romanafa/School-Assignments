import java.util.Scanner;

public class TestArrayBounds {

    public static void main(String[] args){

        //an array with 100 integers
        int[] numbers = new int[100];

        //store random values in the array up to 10000
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = (int)(Math.random() * 10001);
        }

        //get index from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index number: ");
        int index = input.nextInt();


        try {
            System.out.println("Integer with index " + index + " is " + numbers[index]); //if index is 0-99
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("The index " + index + " is out of bounds."); //if index is more than 99
        }

    }
}
