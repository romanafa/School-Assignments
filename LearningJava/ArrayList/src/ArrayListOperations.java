//import java.util.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ArrayListOperations {

    public static void main(String[] args) {

        //make an array list with values from 1-10
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //make it to an ArrayList<Integer> object (more info,book page 462)
        ArrayList<Integer> ArrayList = new ArrayList<>(Arrays.asList(array));


        ArrayList.add(42);                 //adds integer 42 to the end of the list
        ArrayList.remove(8);        //removes integer with index 8

        //see if ArrayList contains added value
        if (ArrayList.contains(42))
            System.out.println("Does list contain 42? Yes");
        else
            System.out.println("Does list contain 42? No");

        //see if ArrayList contains removed value (value is 9, with index 8)
        if (ArrayList.contains(9))
            System.out.println("Does list contain 9? Yes");
        else
            System.out.println("Does list contain 9? No \n");


        //calling a method which will shuffle the values in an array
        shuffleArray(ArrayList);
        System.out.println("Shuffled ArrayList: " + ArrayList);

        //sorting the list in the ascending order (see book 462 for more info about sort() method)
        Collections.sort(ArrayList);
        //to get the list in descending order, we need to reverse it
        Collections.reverse(ArrayList);
        System.out.println("ArrayList with descending order: " + ArrayList);

    }

    //Shuffling the ArrayList without using shuffle() method
    private static void shuffleArray(ArrayList<Integer> ArrayList) {
        Random random = new Random();
        //getting the ArrayList size and getting random index j
        for (int i = ArrayList.size() - 1; i >= 1; i--) {
            int j = random.nextInt(i + 1);

            //switching the position with random j
            Integer temp = ArrayList.get(i);
            ArrayList.set(i, ArrayList.get(j));
            ArrayList.set(j, temp);
        }
    }


}
